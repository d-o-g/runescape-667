package com.jagex.math;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class IntMath {

    @OriginalMember(owner = "client!nt", name = "b", descriptor = "(II)I")
    public static int nextPow2(@OriginalArg(0) int n) {
        // @formatter:off
        @Pc(4)  int n1 = n - 1;
        @Pc(16) int n2 = n1 | n1 >>> 1;
        @Pc(22) int n3 = n2 | n2 >>> 2;
        @Pc(28) int n4 = n3 | n3 >>> 4;
        @Pc(34) int n5 = n4 | n4 >>> 8;
        @Pc(40) int n6 = n5 | n5 >>> 16;
        // @formatter:on
        return n6 + 1;
    }

    @OriginalMember(owner = "client!kaa", name = "a", descriptor = "(IBI)I")
    public static int gcd(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(4) int local4;
        if (arg1 < arg0) {
            local4 = arg1;
            arg1 = arg0;
            arg0 = local4;
        }
        while (arg0 != 0) {
            local4 = arg1 % arg0;
            arg1 = arg0;
            arg0 = local4;
        }
        return arg1;
    }

    @OriginalMember(owner = "client!nla", name = "a", descriptor = "(IB)I")
    public static int countBits(@OriginalArg(0) int n) {
        @Pc(5) int bits = 0;
        if (n < 0 || n >= 65536) {
            n >>>= 0x10;
            bits += 16;
        }
        if (n >= 256) {
            bits += 8;
            n >>>= 0x8;
        }
        if (n >= 16) {
            bits += 4;
            n >>>= 0x4;
        }
        if (n >= 4) {
            bits += 2;
            n >>>= 0x2;
        }
        if (n >= 1) {
            n >>>= 0x1;
            bits++;
        }
        return bits + n;
    }

    private IntMath() {
        /* empty */
    }
}
