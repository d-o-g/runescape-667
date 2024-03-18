package com.jagex.math;

import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Trig1 {

    @OriginalMember(owner = "client!ts", name = "b", descriptor = "[I")
    public static final int[] SIN = new int[16384];

    @OriginalMember(owner = "client!ts", name = "l", descriptor = "[I")
    public static final int[] COS = new int[16384];

    static {
        @Pc(63) double d = 3.834951969714103E-4D;
        for (@Pc(65) int i = 0; i < 16384; i++) {
            SIN[i] = (int) (Math.sin((double) i * d) * 16384.0D);
            COS[i] = (int) (Math.cos(d * (double) i) * 16384.0D);
        }
    }

    private Trig1() {
        /* empty */
    }
}
