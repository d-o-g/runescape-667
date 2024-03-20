package com.jagex.js5;

import com.jagex.core.crypto.Whirlpool;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.math.BigInteger;

@OriginalClass("client!nj")
public final class Js5MasterIndex {

    @OriginalMember(owner = "client!nj", name = "l", descriptor = "Lclient!ge;")
    public Packet buffer;

    @OriginalMember(owner = "client!nj", name = "b", descriptor = "[Lclient!pm;")
    public Js5ResourceProvider[] providers;

    @OriginalMember(owner = "client!nj", name = "e", descriptor = "Ljava/math/BigInteger;")
    public final BigInteger rsaModulus;

    @OriginalMember(owner = "client!nj", name = "d", descriptor = "Lclient!pla;")
    public final Js5WorkerThread workerThread;

    @OriginalMember(owner = "client!nj", name = "h", descriptor = "Lclient!iba;")
    public final CachedResourceWorker resourceWorker;

    @OriginalMember(owner = "client!nj", name = "n", descriptor = "Ljava/math/BigInteger;")
    public final BigInteger rsaExponent;

    @OriginalMember(owner = "client!nj", name = "f", descriptor = "Lclient!rja;")
    public Js5WorkerRequestMessage message;

    @OriginalMember(owner = "client!nj", name = "<init>", descriptor = "(Lclient!pla;Lclient!iba;Ljava/math/BigInteger;Ljava/math/BigInteger;)V")
    public Js5MasterIndex(@OriginalArg(0) Js5WorkerThread workerThread, @OriginalArg(1) CachedResourceWorker resourceWorker, @OriginalArg(2) BigInteger rsaExponent, @OriginalArg(3) BigInteger rsaModulus) {
        this.rsaModulus = rsaModulus;
        this.workerThread = workerThread;
        this.resourceWorker = resourceWorker;
        this.rsaExponent = rsaExponent;

        if (!this.workerThread.isUrgentFull()) {
            this.message = this.workerThread.requestIndex(Js5Archive.ARCHIVESET, Js5Archive.ARCHIVESET, true, (byte) 0);
        }
    }

    @OriginalMember(owner = "client!nj", name = "c", descriptor = "(I)Z")
    public boolean method5800() {
        if (this.buffer != null) {
            return true;
        }

        if (this.message == null) {
            if (this.workerThread.isUrgentFull()) {
                return false;
            }

            this.message = this.workerThread.requestIndex(Js5Archive.ARCHIVESET, Js5Archive.ARCHIVESET, true, (byte) 0);
        }

        if (this.message.incomplete) {
            return false;
        }

        @Pc(49) Packet packet = new Packet(this.message.getData());
        packet.pos = 5;

        @Pc(56) int local56 = packet.g1();
        packet.pos += local56 * 72;

        @Pc(72) byte[] data = new byte[packet.data.length - packet.pos];
        packet.gdata(0, data.length, data);

        @Pc(102) byte[] expectedWhirlpool;
        if (this.rsaExponent != null && this.rsaModulus != null) {
            @Pc(92) BigInteger local92 = new BigInteger(data);
            @Pc(99) BigInteger local99 = local92.modPow(this.rsaExponent, this.rsaModulus);
            expectedWhirlpool = local99.toByteArray();
        } else {
            expectedWhirlpool = data;
        }

        if (expectedWhirlpool.length != 65) {
            throw new RuntimeException("Incorrect Whirlpool length - got: " + expectedWhirlpool.length + " bytes");
        }

        @Pc(131) byte[] actualWhirlpool = Whirlpool.digest(packet.data, packet.pos - data.length - 5, 5);
        for (@Pc(140) int i = 0; i < 64; i++) {
            if (expectedWhirlpool[i + 1] != actualWhirlpool[i]) {
                throw new RuntimeException("Masterindex Whirlpool from server does not match my calculation - expected:" + js5.whirlpoolToString(expectedWhirlpool) + " got:" + js5.whirlpoolToString(actualWhirlpool));
            }
        }

        this.providers = new Js5ResourceProvider[local56];
        this.buffer = packet;
        return true;
    }

    @OriginalMember(owner = "client!nj", name = "a", descriptor = "(Lclient!af;ILclient!af;B)Lclient!pm;")
    public Js5ResourceProvider getProvider(@OriginalArg(0) FileSystem_Client datafs, @OriginalArg(1) int archiveId, @OriginalArg(2) FileSystem_Client indexStore) {
        return this.getProvider(true, datafs, archiveId, indexStore);
    }

    @OriginalMember(owner = "client!nj", name = "a", descriptor = "(ZLclient!af;ILclient!af;I)Lclient!pm;")
    public Js5ResourceProvider getProvider(@OriginalArg(0) boolean clearIdle, @OriginalArg(1) FileSystem_Client datafs, @OriginalArg(2) int archiveId, @OriginalArg(3) FileSystem_Client indexStore) {
        if (this.buffer == null) {
            throw new RuntimeException("Not ready!");
        } else if (archiveId < 0 || archiveId >= this.providers.length) {
            throw new RuntimeException("Invalid archiveid requested - archiveid:" + archiveId);
        } else if (this.providers[archiveId] != null) {
            return this.providers[archiveId];
        } else {
            this.buffer.pos = (archiveId * 72) + 6;
            @Pc(52) int indexcrc = this.buffer.g4();
            @Pc(57) int version = this.buffer.g4();
            @Pc(60) byte[] whirlpool = new byte[64];
            this.buffer.gdata(0, 64, whirlpool);

            if (indexcrc == 0) {
                System.out.println("Warning: indexcrc==0 - likely invalid archiveid requested - archiveid:" + archiveId);
            }

            @Pc(84) Js5ResourceProvider provider = new Js5ResourceProvider(archiveId, datafs, indexStore, this.workerThread, this.resourceWorker, indexcrc, whirlpool, version, clearIdle);
            this.providers[archiveId] = provider;
            return provider;
        }
    }

    @OriginalMember(owner = "client!nj", name = "a", descriptor = "(I)V")
    public void process() {
        if (this.providers == null) {
            return;
        }

        for (@Pc(12) int i = 0; i < this.providers.length; i++) {
            if (this.providers[i] != null) {
                this.providers[i].processRequests();
            }
        }

        for (@Pc(41) int i = 0; i < this.providers.length; i++) {
            if (this.providers[i] != null) {
                this.providers[i].processExtras();
            }
        }
    }
}
