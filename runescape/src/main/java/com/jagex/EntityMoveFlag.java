package com.jagex;

import org.openrs2.deob.annotation.OriginalMember;

public final class EntityMoveFlag {

    public static final int NORTH = 0x1;

    public static final int EAST = 0x4;

    public static final int SOUTH = 0x2;

    public static final int WEST = 0x8;

    @OriginalMember(owner = "client!ol", name = "G", descriptor = "[I")
    public static final int[] FLAG_TO_YAW = {
        /* 00 */ -1,
        /* 01 */ 8192,
        /* 02 */ 0,
        /* 03 */ -1,
        /* 04 */ 12288,
        /* 05 */ 10240,
        /* 06 */ 14336,
        /* 07 */ -1,
        /* 08 */ 4096,
        /* 09 */ 6144,
        /* 10 */ 2048,
    };

    private EntityMoveFlag() {
        /* empty */
    }
}
