package com.jagex.core.compress;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.zip.Inflater;

@OriginalClass("client!qaa")
public final class GzipDecompressor {

    @OriginalMember(owner = "client!k", name = "j", descriptor = "Lclient!qaa;")
    public static final GzipDecompressor INSTANCE = new GzipDecompressor();

    @OriginalMember(owner = "client!qaa", name = "e", descriptor = "Ljava/util/zip/Inflater;")
    public Inflater inflater;

    @OriginalMember(owner = "client!qaa", name = "<init>", descriptor = "(III)V")
    public GzipDecompressor(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
    }

    @OriginalMember(owner = "client!qaa", name = "<init>", descriptor = "()V")
    public GzipDecompressor() {
        this(-1, 1000000, 1000000);
    }

    @OriginalMember(owner = "client!qaa", name = "a", descriptor = "(ILclient!ge;[B)V")
    public void gunzip(@OriginalArg(1) Packet packet, @OriginalArg(2) byte[] data) {
        if (packet.data[packet.pos] != 31 || packet.data[packet.pos + 1] != -117) {
            throw new RuntimeException("Invalid GZIP header!");
        }

        if (this.inflater == null) {
            this.inflater = new Inflater(true);
        }

        try {
            this.inflater.setInput(packet.data, packet.pos + 10, -8 - packet.pos - (10 - packet.data.length));
            this.inflater.inflate(data);
        } catch (@Pc(68) Exception ignored) {
            this.inflater.reset();
            throw new RuntimeException("Invalid GZIP compressed data!");
        }

        this.inflater.reset();
    }

    @OriginalMember(owner = "client!qaa", name = "a", descriptor = "([BZ)[B")
    public byte[] decompress(@OriginalArg(0) byte[] data) {
        @Pc(8) Packet packet = new Packet(data);
        packet.pos = data.length - 4;
        @Pc(24) int len = packet.ig4();
        @Pc(27) byte[] out = new byte[len];
        packet.pos = 0;
        this.gunzip(packet, out);
        return out;
    }
}
