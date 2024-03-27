package com.jagex.graphics.particles;

import org.openrs2.deob.annotation.OriginalMember;

public final class ParticleLimits {

    @OriginalMember(owner = "client!fs", name = "c", descriptor = "[I")
    public static final int[] SYSTEMS = {3, 7, 15};

    @OriginalMember(owner = "client!fba", name = "d", descriptor = "[I")
    public static final int[] PARTICLES = {2047, 16383, 65535};

    private ParticleLimits() {
        /* empty */
    }
}
