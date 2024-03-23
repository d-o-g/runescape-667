package com.jagex.game;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!raa")
public interface QuickChatFillerDecoder {

    @OriginalMember(owner = "client!raa", name = "a", descriptor = "(IJLclient!it;[I)Ljava/lang/String;")
    String decode(@OriginalArg(1) long value, @OriginalArg(2) QuickChatDynamicCommand command, @OriginalArg(3) int[] vars);
}
