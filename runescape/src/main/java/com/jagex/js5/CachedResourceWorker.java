package com.jagex.js5;

import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!iba")
public final class CachedResourceWorker implements Runnable {

    @OriginalMember(owner = "client!iba", name = "d", descriptor = "Lclient!jga;")
    public final Queue requests = new Queue();

    @OriginalMember(owner = "client!iba", name = "n", descriptor = "I")
    public int remaining = 0;

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "Z")
    public boolean closed = false;

    @OriginalMember(owner = "client!iba", name = "g", descriptor = "Ljava/lang/Thread;")
    public Thread thread;

    @OriginalMember(owner = "client!iba", name = "<init>", descriptor = "(Lclient!vq;)V")
    public CachedResourceWorker(@OriginalArg(0) SignLink signLink) {
        @Pc(20) SignedResource resource = signLink.startThread(this, 5);
        while (resource.status == 0) {
            TimeUtils.sleep(10L);
        }
        if (resource.status == 2) {
            throw new RuntimeException();
        }
        this.thread = (Thread) resource.result;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(Lclient!af;IZ)Lclient!vp;")
    public Js5ResourceRequest readUrgent(@OriginalArg(0) FileSystem_Client arg0, @OriginalArg(1) int arg1) {
        @Pc(7) Js5ResourceRequest request = new Js5ResourceRequest();
        request.type = Js5ResourceRequest.TYPE_READ_URGENT;

        @Pc(13) Queue local13 = this.requests;
        synchronized (this.requests) {
            @Pc(21) Js5ResourceRequest first = (Js5ResourceRequest) this.requests.first();

            while (true) {
                if (first == null) {
                    break;
                }

                if (first.key2 == (long) arg1 && first.fileSystem == arg0 && first.type == Js5ResourceRequest.TYPE_WRITE) {
                    request.incomplete = false;
                    request.data = first.data;
                    return request;
                }

                first = (Js5ResourceRequest) this.requests.next();
            }
        }

        request.data = arg0.read(arg1);
        request.urgent = true;
        request.incomplete = false;
        return request;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(I)V")
    public void close() {
        this.closed = true;

        @Pc(9) Queue local9 = this.requests;
        synchronized (this.requests) {
            this.requests.notifyAll();
        }

        try {
            this.thread.join();
        } catch (@Pc(25) InterruptedException ignored) {
            /* empty */
        }

        this.thread = null;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(ILclient!vp;)V")
    public void add(@OriginalArg(1) Js5ResourceRequest request) {
        @Pc(6) Queue local6 = this.requests;
        synchronized (this.requests) {
            this.requests.add(request);
            this.remaining++;
            this.requests.notifyAll();
        }
    }

    @OriginalMember(owner = "client!iba", name = "run", descriptor = "()V")
    @Override
    public void run() {
        while (!this.closed) {
            @Pc(10) Queue local10 = this.requests;
            @Pc(18) Js5ResourceRequest request;
            synchronized (this.requests) {
                request = (Js5ResourceRequest) this.requests.removeFirst();

                if (request == null) {
                    try {
                        this.requests.wait();
                    } catch (@Pc(26) InterruptedException ignored) {
                        /* empty */
                    }
                    continue;
                }
                this.remaining--;
            }

            try {
                if (request.type == Js5ResourceRequest.TYPE_WRITE) {
                    request.fileSystem.save(request.data.length, request.data, (int) request.key2);
                } else if (request.type == Js5ResourceRequest.TYPE_VERIFY) {
                    request.data = request.fileSystem.read((int) request.key2);
                }
            } catch (@Pc(83) Exception ex) {
                JagException.sendTrace(ex, null);
            }

            request.incomplete = false;
        }
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(B[BILclient!af;)Lclient!vp;")
    public Js5ResourceRequest write(@OriginalArg(1) byte[] data, @OriginalArg(2) int archiveId, @OriginalArg(3) FileSystem_Client fileSystem) {
        @Pc(7) Js5ResourceRequest request = new Js5ResourceRequest();
        request.key2 = (long) archiveId;
        request.type = Js5ResourceRequest.TYPE_WRITE;
        request.data = data;
        request.fileSystem = fileSystem;
        request.urgent = false;
        this.add(request);
        return request;
    }

    @OriginalMember(owner = "client!iba", name = "a", descriptor = "(Lclient!af;II)Lclient!vp;")
    public Js5ResourceRequest verify(@OriginalArg(0) FileSystem_Client fileSystem, @OriginalArg(2) int key) {
        @Pc(7) Js5ResourceRequest local7 = new Js5ResourceRequest();
        local7.fileSystem = fileSystem;
        local7.urgent = false;
        local7.type = Js5ResourceRequest.TYPE_VERIFY;
        local7.key2 = (long) key;
        this.add(local7);
        return local7;
    }
}
