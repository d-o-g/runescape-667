package com.jagex.game.runetek6.config.enumtype;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rd")
public final class EnumMappingFrequency extends Node {

    @OriginalMember(owner = "client!rd", name = "l", descriptor = "I")
    public int frequency;

    @OriginalMember(owner = "client!rd", name = "o", descriptor = "Ljava/lang/String;")
    public String value;

    @OriginalMember(owner = "client!rd", name = "<init>", descriptor = "()V")
    public EnumMappingFrequency() {
    }

    @OriginalMember(owner = "client!rd", name = "<init>", descriptor = "(Ljava/lang/String;I)V")
    public EnumMappingFrequency(@OriginalArg(0) String value, @OriginalArg(1) int frequency) {
        this.frequency = frequency;
        this.value = value;
    }
}
