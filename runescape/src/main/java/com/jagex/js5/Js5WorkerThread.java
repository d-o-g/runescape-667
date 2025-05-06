package com.jagex.js5;

import com.jagex.core.constants.CompressionType;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.io.BufferedSocket;
import com.jagex.core.io.Packet;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

@OriginalClass("client!pla")
public final class Js5WorkerThread {

    private static final int PREFETCH_LIMIT = 20;
    private static final int URGENT_LIMIT = 20;
    private static final int LATENCY_LIMIT = 30000;

    @OriginalMember(owner = "client!pla", name = "y", descriptor = "Lclient!nk;")
    public BufferedSocket socket;

    @OriginalMember(owner = "client!pla", name = "q", descriptor = "I")
    public int latency;

    @OriginalMember(owner = "client!pla", name = "m", descriptor = "J")
    public long lastAttempt;

    @OriginalMember(owner = "client!pla", name = "B", descriptor = "Lclient!rja;")
    public Js5WorkerRequestMessage current;

    @OriginalMember(owner = "client!pla", name = "C", descriptor = "Lclient!jga;")
    public final Queue<Js5WorkerRequestMessage> urgentRequests = new Queue<Js5WorkerRequestMessage>();

    @OriginalMember(owner = "client!pla", name = "b", descriptor = "Lclient!jga;")
    public final Queue<Js5WorkerRequestMessage> pendingUrgentRequests = new Queue<>();

    @OriginalMember(owner = "client!pla", name = "r", descriptor = "Lclient!jga;")
    public final Queue<Js5WorkerRequestMessage> prefetchRequests = new Queue<>();

    @OriginalMember(owner = "client!pla", name = "j", descriptor = "Lclient!jga;")
    public final Queue<Js5WorkerRequestMessage> pendingPrefetchRequests = new Queue<>();

    @OriginalMember(owner = "client!pla", name = "v", descriptor = "Lclient!ge;")
    public final Packet write = new Packet(4);

    @OriginalMember(owner = "client!pla", name = "w", descriptor = "I")
    public volatile int errors = 0;

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "I")
    public volatile int response = Js5ResponseCode.OK;

    @OriginalMember(owner = "client!pla", name = "s", descriptor = "B")
    public byte xorCode = 0;

    @OriginalMember(owner = "client!pla", name = "x", descriptor = "Lclient!ge;")
    public final Packet read = new Packet(8);

    @OriginalMember(owner = "client!pla", name = "b", descriptor = "(B)V")
    public void reset() {
        try {
            this.socket.close();
        } catch (@Pc(5) Exception ignored) {
            /* empty */
        }

        this.socket = null;
        this.response = Js5ResponseCode.DISCONNECTED;
        this.xorCode = (byte) (int) (Math.random() * 255.0D + 1.0D);
        this.errors++;
    }

    @OriginalMember(owner = "client!pla", name = "c", descriptor = "(B)V")
    public void connected() {
        if (this.socket == null) {
            return;
        }

        try {
            this.write.pos = 0;
            this.write.p1(Js5RequestCode.CONNECTED);
            this.write.p3(3);
            this.socket.write(4, this.write.data);
        } catch (@Pc(33) IOException local33) {
            try {
                this.socket.close();
            } catch (@Pc(39) Exception ignored) {
                /* empty */
            }

            this.errors++;
            this.response = Js5ResponseCode.CONNECTED;
            this.socket = null;
        }
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(Z)V")
    public void close() {
        if (this.socket != null) {
            this.socket.close();
        }
    }

    @OriginalMember(owner = "client!pla", name = "e", descriptor = "(I)I")
    public int urgentCount() {
        return this.urgentRequests.size() + this.pendingUrgentRequests.size();
    }

    @OriginalMember(owner = "client!pla", name = "d", descriptor = "(B)Z")
    public boolean tick() {
        if (this.socket != null) {
            @Pc(7) long now = SystemTimer.safetime();
            @Pc(14) int deltaTime = (int) (now - this.lastAttempt);

            this.lastAttempt = now;

            if (deltaTime > 200) {
                deltaTime = 200;
            }

            this.latency += deltaTime;

            if (this.latency > LATENCY_LIMIT) {
                try {
                    this.socket.close();
                } catch (@Pc(42) Exception ignored) {
                    /* empty */
                }

                this.socket = null;
            }
        }

        if (this.socket == null) {
            return this.urgentCount() == 0 && this.prefetchCount() == 0;
        }

        try {
            this.socket.sanityCheck();

            for (@Pc(84) Js5WorkerRequestMessage message = this.urgentRequests.first(); message != null; message = this.urgentRequests.next()) {
                this.write.pos = 0;
                this.write.p1(Js5RequestCode.URGENT);
                this.write.p3((int) message.key2);
                this.socket.write(4, this.write.data);
                this.pendingUrgentRequests.add(message);
            }

            for (@Pc(142) Js5WorkerRequestMessage message = this.prefetchRequests.first(); message != null; message = this.prefetchRequests.next()) {
                this.write.pos = 0;
                this.write.p1(Js5RequestCode.PREFETCH);
                this.write.p3((int) message.key2);
                this.socket.write(4, this.write.data);
                this.pendingPrefetchRequests.add(message);
            }

            for (@Pc(14) int i = 0; i < 100; i++) {
                @Pc(199) int available = this.socket.available();
                if (available < 0) {
                    throw new IOException();
                }
                if (available == 0) {
                    break;
                }

                this.latency = 0;

                @Pc(212) byte needed = 0;
                if (this.current == null) {
                    needed = 8;
                } else if (this.current.blockPos == 0) {
                    needed = 1;
                }

                if (needed > 0) {
                    @Pc(236) int remaining = needed - this.read.pos;
                    if (available < remaining) {
                        remaining = available;
                    }

                    this.socket.read(remaining, this.read.pos, this.read.data);

                    if (this.xorCode != 0) {
                        for (@Pc(260) int j = 0; j < remaining; j++) {
                            this.read.data[this.read.pos + j] = (byte) (this.read.data[this.read.pos + j] ^ this.xorCode);
                        }
                    }

                    this.read.pos += remaining;

                    if (needed <= this.read.pos) {
                        if (this.current == null) {
                            this.read.pos = 0;
                            @Pc(260) int archiveId = this.read.g1();
                            @Pc(328) int groupId = this.read.g2();
                            @Pc(333) int compressionTypeAndPrefetchFlag = this.read.g1();
                            @Pc(338) int compressedLength = this.read.g4();
                            @Pc(342) int compressionType = compressionTypeAndPrefetchFlag & 0x7F;
                            @Pc(354) boolean prefetch = (compressionTypeAndPrefetchFlag & 0x80) != 0;
                            @Pc(361) long key = (archiveId << 16) + groupId;

                            @Pc(371) Js5WorkerRequestMessage message;
                            if (prefetch) {
                                for (message = this.pendingPrefetchRequests.first(); message != null && message.key2 != key; message = this.pendingPrefetchRequests.next()) {
                                }
                            } else {
                                for (message = this.pendingUrgentRequests.first(); message != null && message.key2 != key; message = this.pendingUrgentRequests.next()) {
                                }
                            }

                            if (message == null) {
                                System.out.println("Could not find matching request - archiveid:" + archiveId + " groupid:" + groupId + " ctype:" + compressionType + " clen:" + compressedLength + " xorcode:" + xorCode);
                                throw new IOException();
                            }

                            this.current = message;
                            @Pc(454) int headerSize = compressionType == CompressionType.NONE ? 5 : 9;
                            this.current.packet = new Packet(headerSize + compressedLength + this.current.padding);
                            this.current.packet.p1(compressionType);
                            this.current.packet.p4(compressedLength);
                            this.current.blockPos = 8;
                            this.read.pos = 0;
                        } else {
                            if (this.current.blockPos != 0) {
                                System.out.println("Error processing incoming header!");
                                throw new IOException();
                            }

                            if (this.read.data[0] == -1) {
                                this.read.pos = 0;
                                this.current.blockPos = 1;
                            } else {
                                this.current = null;
                            }
                        }
                    }
                } else {
                    @Pc(236) int remaining = this.current.packet.data.length - this.current.padding;
                    @Pc(260) int len = 512 - this.current.blockPos;
                    if (len > remaining - this.current.packet.pos) {
                        len = remaining - this.current.packet.pos;
                    }
                    if (len > available) {
                        len = available;
                    }

                    this.socket.read(len, this.current.packet.pos, this.current.packet.data);

                    if (this.xorCode != 0) {
                        for (@Pc(328) int j = 0; j < len; j++) {
                            this.current.packet.data[this.current.packet.pos + j] = (byte) (this.current.packet.data[this.current.packet.pos + j] ^ this.xorCode);
                        }
                    }

                    this.current.packet.pos += len;
                    this.current.blockPos += len;

                    if (remaining == this.current.packet.pos) {
                        this.current.unlink2();
                        this.current.incomplete = false;
                        this.current = null;
                    } else if (this.current.blockPos == 512) {
                        this.current.blockPos = 0;
                    }
                }
            }

            return true;
        } catch (@Pc(694) IOException exception) {
            try {
                this.socket.close();
            } catch (@Pc(702) Exception ignored) {
                /* empty */
            }
            this.socket = null;
            this.errors++;
            this.response = Js5ResponseCode.CONNECTED;
            return this.urgentCount() == 0 && this.prefetchCount() == 0;
        }
    }

    @OriginalMember(owner = "client!pla", name = "b", descriptor = "(I)Z")
    public boolean isPrefetchFull() {
        return this.prefetchCount() >= PREFETCH_LIMIT;
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ZI)V")
    public void loggedIn(@OriginalArg(0) boolean loggedIn) {
        if (this.socket == null) {
            return;
        }
        try {
            this.write.pos = 0;
            this.write.p1(loggedIn ? Js5RequestCode.LOGGED_IN : Js5RequestCode.LOGGED_OUT);
            this.write.p3(0);
            this.socket.write(4, this.write.data);
        } catch (@Pc(38) IOException local38) {
            try {
                this.socket.close();
            } catch (@Pc(44) Exception ignored) {
                /* empty */
            }

            this.socket = null;
            this.response = Js5ResponseCode.CONNECTED;
            this.errors++;
        }
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ZILclient!nk;)V")
    public void setSocket(@OriginalArg(0) boolean loggedIn, @OriginalArg(2) BufferedSocket socket) {
        if (this.socket != null) {
            try {
                this.socket.close();
            } catch (@Pc(14) Exception local14) {
            }
            this.socket = null;
        }

        this.socket = socket;
        this.connected();
        this.loggedIn(loggedIn);
        this.current = null;
        this.read.pos = 0;

        while (true) {
            @Pc(48) Js5WorkerRequestMessage urgentRequest = (Js5WorkerRequestMessage) this.pendingUrgentRequests.removeFirst();

            if (urgentRequest != null) {
                this.urgentRequests.add(urgentRequest);
            } else {
                break;
            }
        }

        while (true) {
            @Pc(48) Js5WorkerRequestMessage prefetchRequest = (Js5WorkerRequestMessage) this.pendingPrefetchRequests.removeFirst();

            if (prefetchRequest != null) {
                this.prefetchRequests.add(prefetchRequest);
            } else {
                break;
            }
        }

        if (this.xorCode != 0) {
            try {
                this.write.pos = 0;
                this.write.p1(Js5RequestCode.ENCRYPTION);
                this.write.p1(this.xorCode);
                this.write.p2(0);
                this.socket.write(4, this.write.data);
            } catch (@Pc(117) IOException exception) {
                try {
                    this.socket.close();
                } catch (@Pc(123) Exception ignored) {
                    /* empty */
                }

                this.errors++;
                this.socket = null;
                this.response = Js5ResponseCode.CONNECTED;
            }

        }

        this.latency = 0;
        this.lastAttempt = SystemTimer.safetime();
    }

    @OriginalMember(owner = "client!pla", name = "c", descriptor = "(I)V")
    public void disconnect() {
        if (this.socket == null) {
            return;
        }

        try {
            this.write.pos = 0;
            this.write.p1(Js5RequestCode.DISCONNECTED);
            this.write.p3(0);
            this.socket.write(4, this.write.data);
        } catch (@Pc(42) IOException exception) {
            try {
                this.socket.close();
            } catch (@Pc(48) Exception ignored) {
                /* empty */
            }

            this.socket = null;
            this.response = Js5ResponseCode.CONNECTED;
            this.errors++;
        }
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(I)Z")
    public boolean isUrgentFull() {
        return this.urgentCount() >= URGENT_LIMIT;
    }

    @OriginalMember(owner = "client!pla", name = "d", descriptor = "(I)V")
    public void stop() {
        if (this.socket != null) {
            this.socket.breakConnection();
        }
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(B)I")
    public int prefetchCount() {
        return this.prefetchRequests.size() + this.pendingPrefetchRequests.size();
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(IIBZB)Lclient!rja;")
    public Js5WorkerRequestMessage requestIndex(@OriginalArg(0) int archiveId, @OriginalArg(1) int groupId, @OriginalArg(3) boolean urgent, @OriginalArg(4) byte padding) {
        @Pc(19) long key = (archiveId << 16) + groupId;
        @Pc(23) Js5WorkerRequestMessage message = new Js5WorkerRequestMessage();
        message.urgent = urgent;
        message.padding = padding;
        message.key2 = key;

        if (urgent) {
            if (this.urgentCount() < URGENT_LIMIT) {
                this.urgentRequests.add(message);
            } else {
                throw new RuntimeException("Urgent list exceeded max limit of 20");
            }
        } else {
            if (this.prefetchCount() < PREFETCH_LIMIT) {
                this.prefetchRequests.add(message);
            } else {
                throw new RuntimeException("Prefetch list exceeded max limit of 20");
            }
        }

        return message;
    }
}
