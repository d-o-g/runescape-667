package com.jagex.game.runetek6.config.enumtype;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nw")
public final class EnumMapping extends Node {

    @OriginalMember(owner = "client!nw", name = "l", descriptor = "[I")
    public final int[] index;

    @OriginalMember(owner = "client!nw", name = "<init>", descriptor = "(I)V")
    public EnumMapping(@OriginalArg(0) int length) {
        this.index = new int[length];
    }
}
