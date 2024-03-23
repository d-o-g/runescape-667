package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class ToolkitType {

    public static final int JAVA = 0;

    public static final int GL = 1;

    public static final int SSE = 2;

    public static final int D3D = 3;

    public static final int GLX = 5;

    @OriginalMember(owner = "client!oka", name = "b", descriptor = "(II)Z")
    public static boolean isSoftware(@OriginalArg(0) int toolkit) {
        return toolkit == JAVA || toolkit == SSE;
    }

    @OriginalMember(owner = "client!ega", name = "a", descriptor = "(IB)Z")
    public static boolean isHardware(@OriginalArg(0) int toolkit) {
        return toolkit == GL || toolkit == D3D || toolkit == GLX;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(II)Z")
    public static boolean is3d(@OriginalArg(1) int toolkit) {
        return toolkit == SSE || toolkit == D3D;
    }

    private ToolkitType() {
        /* empty */
    }
}
