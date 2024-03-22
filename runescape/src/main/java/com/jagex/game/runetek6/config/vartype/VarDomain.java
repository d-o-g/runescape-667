package com.jagex.game.runetek6.config.vartype;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uk")
public interface VarDomain {

    @OriginalMember(owner = "client!uk", name = "a", descriptor = "(IB)I")
    int getVarBitValue(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!uk", name = "a", descriptor = "(II)I")
    int getVarValueInt(@OriginalArg(0) int arg0);
}
