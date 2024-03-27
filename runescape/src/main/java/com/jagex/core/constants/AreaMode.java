package com.jagex.core.constants;


import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class AreaMode {

    public static final int DEFAULT = -1;

    public static final int STATIC_AREA = 0;

    public static final int CLEAR_LOCAL_NPCS = 1;

    public static final int ALLOW_OUT_OF_BOUNDS = 3;

    public static final int RETAIN_OUT_OF_BOUNDS = 4;

    @OriginalMember(owner = "client!br", name = "b", descriptor = "(II)Z")
    public static boolean isOutOfBounds(@OriginalArg(0) int mode) {
        return mode == ALLOW_OUT_OF_BOUNDS || mode == RETAIN_OUT_OF_BOUNDS;
    }

    private AreaMode() {
        /* empty */
    }
}
