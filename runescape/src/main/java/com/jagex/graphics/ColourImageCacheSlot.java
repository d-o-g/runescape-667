package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!iia")
public final class ColourImageCacheSlot extends Node {

    @OriginalMember(owner = "client!ql", name = "h", descriptor = "Lclient!iia;")
    public static final ColourImageCacheSlot USED = new ColourImageCacheSlot(0, 0);

    @OriginalMember(owner = "client!iia", name = "k", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!iia", name = "p", descriptor = "I")
    public final int slot;

    @OriginalMember(owner = "client!iia", name = "<init>", descriptor = "(II)V")
    public ColourImageCacheSlot(@OriginalArg(0) int id, @OriginalArg(1) int slot) {
        this.id = id;
        this.slot = slot;
    }
}
