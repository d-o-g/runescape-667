package com.jagex.game.camera;

import org.openrs2.deob.annotation.OriginalMember;

public final class Shake {

    @OriginalMember(owner = "client!gka", name = "q", descriptor = "[[I")
    public static final int[][] anIntArrayArray86 = new int[][]{{12, 12, 12, 12}, {12, 12, 12, 12, 12, 5}, {5, 5, 1, 1}, {5, 1, 1, 5}, {5, 5, 5}, {5, 5, 5}, {12, 12, 12, 12, 12, 12}, {1, 12, 12, 12, 12, 12}, {1, 1, 7, 1}, {8, 9, 9, 8, 8, 3, 1, 9}, {8, 8, 9, 8, 9, 9}, {10, 10, 11, 11, 11, 7, 3, 7}, {12, 12, 12, 12}};

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
