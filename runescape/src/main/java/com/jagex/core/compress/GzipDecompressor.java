package com.jagex.core.compress;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.zip.Inflater;

@OriginalClass("client!qaa")
public final class GzipDecompressor {

    @OriginalMember(owner = "client!av", name = "j", descriptor = "[B")
    public static final byte[] aByteArray1 = {
        31, -117, 8, 0, 0, 0, 0, 0, 0, 0, -5, 127, -29, -1, 109, 6, 103, 6, 14,
        54, 54, 118, 54, 86, 14, 118, 118, 118, 78, 78, 14, 46, 30, 17, 94, 30,
        110, 110, 30, 73, 33, 97, 126, 17, 89, 41, 121, 57, 89, 41, 25, 25, 5,
        21, 61, 117, 5, 37, 29, 101, 25, 25, 13, 115, 77, 29, 3, 67, 19, 19,
        19, 121, 117, 75, 91, 11, 35, 27, 61, 99, 19, 35, -112, 33, -116, -100,
        -100, -100, 60, -36, 60, 18, -68, -68, 18, 70, -118, 50, -118, 70, 36,
        -125, -1, 7, 24, 68, 56, 24, 24, 25, 24, 89, 24, -107, 24, -104, 4, 25,
        -103, 5, 25, 89, -108, 24, -2, 31, 97, -112, 103, 96, 96, 100, 101, 4,
        3, 6, 40, 96, 100, 98, 102, 97, 101, 99, -25, -32, -28, -30, 6, 42,
        -40, 42, -64, -64, -60, -56, -52, -52, -60, -62, -52, -54, -54, -62, 2,
        -108, -83, 5, -54, 51, -80, 8, -78, 10, 41, 26, 58, -78, 9, 7, 38, -78,
        43, 21, -118, 24, 53, 78, 92, -56, -95, -20, -76, -15, -96, 104, -48,
        -59, 15, 42, -58, 73, 69, 77, -100, 92, 98, -30, 18, -110, 82, -86,
        106, -22, 26, -102, 90, 38, -90, 102, -26, 22, -106, 86, -50, 46, -82,
        110, -18, 30, -98, 94, -63, 33, -95, 97, -31, 17, -111, 81, -55, 41,
        -87, 105, -23, 25, -103, 89, -59, 37, -91, 101, -27, 21, -107, 85, -51,
        45, -83, 109, -19, 29, -99, 93, -109, 38, 79, -103, 58, 109, -6, -116,
        -103, -77, 22, 45, 94, -78, 116, -39, -14, 21, 43, 87, 109, -38, -68,
        101, -21, -74, -19, 59, 118, -18, 58, 116, -8, -56, -47, 99, -57, 79,
        -100, 60, 117, -23, -14, -107, -85, -41, -82, -33, -72, 121, -21, -31,
        -93, -57, 79, -98, 62, 123, -2, -30, -27, -85, -113, -97, 62, 127, -7,
        -6, -19, -5, -113, -97, -65, 64, -2, 98, 100, 96, 102, -124, 1, -84,
        -2, 18, 4, -6, -117, -119, -123, -123, -103, -123, 29, -28, 47, 70,
        -90, 114, -112, 2, 65, 22, 86, 69, 67, 54, 33, -57, 64, -10, -60, 66,
        97, 37, -93, 70, 14, 17, -89, -119, 11, 55, 30, -28, 84, 54, 14, -6,
        32, -102, 84, 116, -111, 75, 76, -59, -28, -95, -22, 71, -112, -41,
        -64, 62, 35, -50, 99, 77, 100, -7, 12, -18, 49, -124, -65, 110, 49,
        -16, -79, 48, 2, -29, 15, -24, 78, 6, 6, 123, -122, -97, -1, -70, 52,
        22, -16, -49, 127, -79, -88, -21, -1, 77, 0, 38, 27, -28, 10, 110, 2,
        0, 0
    };

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
