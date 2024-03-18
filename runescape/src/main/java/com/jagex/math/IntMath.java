package com.jagex.math;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class IntMath {

    @OriginalMember(owner = "client!nt", name = "b", descriptor = "(II)I")
    public static int nextPow2(@OriginalArg(0) int n) {
        @Pc(4) int n1 = n - 1;
        @Pc(16) int n2 = n1 | n1 >>> 1;
        @Pc(22) int n3 = n2 | n2 >>> 2;
        @Pc(28) int n4 = n3 | n3 >>> 4;
        @Pc(34) int n5 = n4 | n4 >>> 8;
        @Pc(40) int n6 = n5 | n5 >>> 16;
        return n6 + 1;
    }

    private IntMath() {
        /* empty */
    }
}
