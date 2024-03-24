package com.jagex.graphics.particles;

import org.openrs2.deob.annotation.OriginalMember;

public final class ParticleLimits {

    @OriginalMember(owner = "client!fs", name = "c", descriptor = "[I")
    public static final int[] anIntArray265 = {3, 7, 15};

    @OriginalMember(owner = "client!fba", name = "d", descriptor = "[I")
    public static final int[] anIntArray246 = {2047, 16383, 65535};

    @OriginalMember(owner = "client!oea", name = "v", descriptor = "I")
    public static int particleLimit = 0;

    private ParticleLimits() {
        /* empty */
    }
}
