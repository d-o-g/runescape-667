package com.jagex.game.runetek6.config.enumtype;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hu")
public final class EnumStringMapping extends Node {

    @OriginalMember(owner = "client!hu", name = "l", descriptor = "[I")
    public final int[] index;

    @OriginalMember(owner = "client!hu", name = "q", descriptor = "Ljava/lang/String;")
    public final String value;

    @OriginalMember(owner = "client!hu", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public EnumStringMapping(@OriginalArg(0) String value, @OriginalArg(1) int index) {
        this.index = new int[index];
        this.value = value;
    }
}
