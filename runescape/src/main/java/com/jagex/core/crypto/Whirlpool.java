package com.jagex.core.crypto;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wla")
public final class Whirlpool {

    @OriginalMember(owner = "client!sl", name = "D", descriptor = "[[J")
    public static final long[][] aLongArrayArray1 = new long[8][256];

    @OriginalMember(owner = "client!sl", name = "E", descriptor = "[J")
    public static final long[] aLongArray19 = new long[11];

    static {
        for (@Pc(58) int local58 = 0; local58 < 256; local58++) {
            @Pc(67) char local67 = "ᠣ웨螸ŏ㚦틵祯酒悼鮎ꌌ笵ᷠퟂ\u2e4b﹗ᕷ㟥\u9ff0䫚壉⤊놠殅뵝ჴ쬾է\ue427䆋Ᵹ闘ﯮ籦\udd17䞞쨭뼇굚茳挂ꩱ젙䧙\uf2e3守騦㊰\ue90f햀뻍㑈ｺ遟\u2068\u1aae둔錢擱猒䀈쏬\udba1贽需켫皂혛떯橐䗳ワ㽕ꋪ斺⿀\ude1c\ufd4d鉵ڊ닦ฟ拔ꢖ暈╙葲㥌幸㢌톥\ue261댡鰞䏇ﰄ写洍\ufadf縤㮫츑轎럫㲁铷뤓ⳓ\ue76e쐃噄義⪻셓\udc0b鵬ㅴ\uf646겉ᓡᘺ椉炶탭챂颤⡜\uf886".charAt(local58 / 2);
            @Pc(84) long local84 = (local58 & 0x1) == 0 ? local67 >>> 8 : local67 & 0xFF;
            @Pc(88) long local88 = local84 << 1;
            if (local88 >= 256L) {
                local88 ^= 0x11DL;
            }

            @Pc(100) long local100 = local88 << 1;
            if (local100 >= 256L) {
                local100 ^= 0x11DL;
            }

            @Pc(114) long local114 = local100 ^ local84;
            @Pc(118) long local118 = local100 << 1;
            if (local118 >= 256L) {
                local118 ^= 0x11DL;
            }

            @Pc(130) long local130 = local118 ^ local84;
            aLongArrayArray1[0][local58] = or(or(local88 << 8, or(or(or(local84 << 32, or(or(local84 << 48, local84 << 56), local100 << 40)), local118 << 24), local114 << 16)), local130);
            for (@Pc(166) int local166 = 1; local166 < 8; local166++) {
                aLongArrayArray1[local166][local58] = or(aLongArrayArray1[local166 - 1][local58] >>> 8, aLongArrayArray1[local166 - 1][local58] << 56);
            }
        }

        aLongArray19[0] = 0L;

        for (@Pc(209) int local209 = 1; local209 <= 10; local209++) {
            @Pc(216) int local216 = local209 * 8 - 8;
            aLongArray19[local209] = xor(and(aLongArrayArray1[7][local216 + 7], 255L), xor(and(aLongArrayArray1[6][local216 + 6], 65280L), xor(xor(xor(xor(and(280375465082880L, aLongArrayArray1[2][local216 + 2]), xor(and(aLongArrayArray1[0][local216], -72057594037927936L), and(aLongArrayArray1[1][local216 + 1], 71776119061217280L))), and(1095216660480L, aLongArrayArray1[3][local216 + 3])), and(aLongArrayArray1[4][local216 + 4], 4278190080L)), and(aLongArrayArray1[5][local216 + 5], 16711680L))));
        }
    }

    @OriginalMember(owner = "client!tca", name = "a", descriptor = "(B[BII)[B")
    public static byte[] digest(@OriginalArg(1) byte[] arg0, @OriginalArg(2) int len, @OriginalArg(3) int off) {
        @Pc(10) byte[] buf;
        if (off > 0) {
            buf = new byte[len];
            for (@Pc(12) int i = 0; i < len; i++) {
                buf[i] = arg0[i + off];
            }
        } else {
            buf = arg0;
        }

        @Pc(40) Whirlpool whirlpool = new Whirlpool();
        whirlpool.reset();
        whirlpool.add((long) (len * 8), buf);
        @Pc(60) byte[] hash = new byte[64];
        whirlpool.finalize(hash);
        return hash;
    }

    @OriginalMember(owner = "client!rv", name = "a", descriptor = "(JJ)J")
    private static long and(@OriginalArg(0) long value, @OriginalArg(1) long bitmask) {
        return value & bitmask;
    }

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(JJ)J")
    private static long or(@OriginalArg(0) long arg0, @OriginalArg(1) long arg1) {
        return arg0 | arg1;
    }

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(JJ)J")
    private static long xor(@OriginalArg(0) long value, @OriginalArg(1) long bitmask) {
        return value ^ bitmask;
    }

    @OriginalMember(owner = "client!wla", name = "o", descriptor = "[J")
    public final long[] aLongArray23 = new long[8];

    @OriginalMember(owner = "client!wla", name = "e", descriptor = "[J")
    public final long[] aLongArray24 = new long[8];

    @OriginalMember(owner = "client!wla", name = "g", descriptor = "[B")
    public final byte[] aByteArray112 = new byte[64];

    @OriginalMember(owner = "client!wla", name = "d", descriptor = "[J")
    public final long[] aLongArray22 = new long[8];

    @OriginalMember(owner = "client!wla", name = "n", descriptor = "I")
    public int anInt10807 = 0;

    @OriginalMember(owner = "client!wla", name = "b", descriptor = "[J")
    public final long[] aLongArray26 = new long[8];

    @OriginalMember(owner = "client!wla", name = "m", descriptor = "[B")
    public final byte[] aByteArray113 = new byte[32];

    @OriginalMember(owner = "client!wla", name = "q", descriptor = "I")
    public int anInt10812 = 0;

    @OriginalMember(owner = "client!wla", name = "i", descriptor = "[J")
    public final long[] aLongArray25 = new long[8];

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "(I)V")
    public void reset() {
        for (@Pc(3) int i = 0; i < 32; i++) {
            this.aByteArray113[i] = 0;
        }

        this.anInt10812 = this.anInt10807 = 0;
        this.aByteArray112[0] = 0;

        for (@Pc(48) int i = 0; i < 8; i++) {
            this.aLongArray22[i] = 0L;
        }
    }

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "(J[BI)V")
    public void add(@OriginalArg(0) long arg0, @OriginalArg(1) byte[] arg1) {
        @Pc(7) int local7 = 0;
        @Pc(24) int local24 = 8 - ((int) arg0 & 0x7) & 0x7;
        @Pc(29) int local29 = this.anInt10812 & 0x7;
        @Pc(31) long local31 = arg0;
        @Pc(33) int local33 = 31;
        @Pc(35) int local35 = 0;
        while (local33 >= 0) {
            local35 += (this.aByteArray113[local33] & 0xFF) + ((int) local31 & 0xFF);
            this.aByteArray113[local33] = (byte) local35;
            local31 >>>= 0x8;
            local35 >>>= 0x8;
            local33--;
        }
        @Pc(96) int local96;
        while (arg0 > 8L) {
            local96 = arg1[local7] << local24 & 0xFF | (arg1[local7 - -1] & 0xFF) >>> 8 - local24;
            if (local96 < 0 || local96 >= 256) {
                throw new RuntimeException("LOGIC ERROR");
            }
            this.aByteArray112[this.anInt10807] = (byte) (this.aByteArray112[this.anInt10807] | local96 >>> local29);
            this.anInt10812 += 8 - local29;
            this.anInt10807++;
            if (this.anInt10812 == 512) {
                this.method9345();
                this.anInt10812 = this.anInt10807 = 0;
            }
            this.aByteArray112[this.anInt10807] = (byte) (local96 << 8 - local29 & 0xFF);
            this.anInt10812 += local29;
            local7++;
            arg0 -= 8L;
        }
        if (arg0 <= 0L) {
            local96 = 0;
        } else {
            local96 = arg1[local7] << local24 & 0xFF;
            this.aByteArray112[this.anInt10807] = (byte) (this.aByteArray112[this.anInt10807] | local96 >>> local29);
        }
        if (arg0 + (long) local29 < 8L) {
            this.anInt10812 = (int) ((long) this.anInt10812 + arg0);
            return;
        }
        this.anInt10812 += 8 - local29;
        this.anInt10807++;
        arg0 -= (long) (8 - local29);
        if (this.anInt10812 == 512) {
            this.method9345();
            this.anInt10812 = this.anInt10807 = 0;
        }
        this.aByteArray112[this.anInt10807] = (byte) (local96 << 8 - local29 & 0xFF);
        this.anInt10812 += (int) arg0;
    }

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "([BII)V")
    public void finalize(@OriginalArg(0) byte[] arg0) {
        this.aByteArray112[this.anInt10807] = (byte) (this.aByteArray112[this.anInt10807] | 0x80 >>> (this.anInt10812 & 0x7));
        this.anInt10807++;

        if (this.anInt10807 > 32) {
            while (true) {
                if (this.anInt10807 >= 64) {
                    this.method9345();
                    this.anInt10807 = 0;
                    break;
                }

                this.aByteArray112[this.anInt10807++] = 0;
            }
        }

        while (this.anInt10807 < 32) {
            this.aByteArray112[this.anInt10807++] = 0;
        }

        Arrays.copy(this.aByteArray113, 0, this.aByteArray112, 32, 32);
        this.method9345();

        @Pc(105) int local105 = 0;
        @Pc(107) int local107 = 0;
        while (local105 < 8) {
            @Pc(114) long local114 = this.aLongArray22[local105];
            arg0[local107] = (byte) (int) (local114 >>> 56);
            arg0[local107 + 1] = (byte) (int) (local114 >>> 48);
            arg0[local107 + 2] = (byte) (int) (local114 >>> 40);
            arg0[local107 + 3] = (byte) (int) (local114 >>> 32);
            arg0[local107 + 4] = (byte) (int) (local114 >>> 24);
            arg0[local107 + 5] = (byte) (int) (local114 >>> 16);
            arg0[local107 + 6] = (byte) (int) (local114 >>> 8);
            arg0[local107 + 7] = (byte) (int) local114;
            local107 += 8;
            local105++;
        }
    }

    @OriginalMember(owner = "client!wla", name = "a", descriptor = "(B)V")
    public void method9345() {
        @Pc(7) int local7 = 0;
        @Pc(9) int local9 = 0;
        while (local7 < 8) {
            this.aLongArray25[local7] = xor(and(255L, (long) this.aByteArray112[local9 + 7]), xor(and(0xFFL << 8, (long) this.aByteArray112[local9 + 6] << 8), xor(xor(xor(xor(and(0xFFL << 40, (long) this.aByteArray112[local9 + 2] << 40), xor(and(255L, (long) this.aByteArray112[local9 + 1]) << 48, (long) this.aByteArray112[local9] << 56)), and(0xFFL << 32, (long) this.aByteArray112[local9 + 3] << 32)), and(255L, (long) this.aByteArray112[local9 + 4]) << 24), and((long) this.aByteArray112[local9 + 5], 255L) << 16)));
            local9 += 8;
            local7++;
        }
        for (@Pc(121) int local121 = 0; local121 < 8; local121++) {
            this.aLongArray23[local121] = xor(this.aLongArray25[local121], this.aLongArray24[local121] = this.aLongArray22[local121]);
        }
        @Pc(159) int local159;
        for (@Pc(153) int local153 = 1; local153 <= 10; local153++) {
            @Pc(168) int local168;
            @Pc(170) int local170;
            for (local159 = 0; local159 < 8; local159++) {
                this.aLongArray26[local159] = 0L;
                local168 = 0;
                local170 = 56;
                while (local168 < 8) {
                    this.aLongArray26[local159] = xor(this.aLongArray26[local159], aLongArrayArray1[local168][(int) (this.aLongArray24[local159 - local168 & 0x7] >>> local170) & 0xFF]);
                    local170 -= 8;
                    local168++;
                }
            }
            for (local168 = 0; local168 < 8; local168++) {
                this.aLongArray24[local168] = this.aLongArray26[local168];
            }
            this.aLongArray24[0] = xor(this.aLongArray24[0], aLongArray19[local153]);
            @Pc(262) int local262;
            for (local170 = 0; local170 < 8; local170++) {
                this.aLongArray26[local170] = this.aLongArray24[local170];
                local262 = 0;
                @Pc(264) int local264 = 56;
                while (local262 < 8) {
                    this.aLongArray26[local170] = xor(this.aLongArray26[local170], aLongArrayArray1[local262][(int) (this.aLongArray23[local170 - local262 & 0x7] >>> local264) & 0xFF]);
                    local262++;
                    local264 -= 8;
                }
            }
            for (local262 = 0; local262 < 8; local262++) {
                this.aLongArray23[local262] = this.aLongArray26[local262];
            }
        }
        for (local159 = 0; local159 < 8; local159++) {
            this.aLongArray22[local159] = xor(this.aLongArray22[local159], xor(this.aLongArray23[local159], this.aLongArray25[local159]));
        }
    }
}
