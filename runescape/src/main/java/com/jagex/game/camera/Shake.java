package com.jagex.game.camera;

import org.openrs2.deob.annotation.OriginalMember;

public final class Shake {

    public static final int DIRECTIONS = 5; // 0=x, 1=y, 2=z, 3=yaw, 4=pitch

    @OriginalMember(owner = "client!s", name = "b", descriptor = "[Z")
    public static final boolean[] enabled = new boolean[DIRECTIONS];

    @OriginalMember(owner = "client!ki", name = "d", descriptor = "[I")
    public static final int[] center = new int[DIRECTIONS];

    @OriginalMember(owner = "client!ega", name = "g", descriptor = "[I")
    public static final int[] amplitude = new int[DIRECTIONS];

    @OriginalMember(owner = "client!lha", name = "a", descriptor = "[I")
    public static final int[] frequency = new int[DIRECTIONS];

    @OriginalMember(owner = "client!g", name = "j", descriptor = "[I")
    public static final int[] time = new int[DIRECTIONS];

    private Shake() {
        /* empty */
    }
}
