package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!v")
public final class MonochromeImageCacheSlot extends Node {

    @OriginalMember(owner = "client!mn", name = "p", descriptor = "Lclient!v;")
    public static final MonochromeImageCacheSlot USED = new MonochromeImageCacheSlot(0, 0);

    @OriginalMember(owner = "client!v", name = "o", descriptor = "I")
    public final int slot;

    @OriginalMember(owner = "client!v", name = "m", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!v", name = "<init>", descriptor = "(II)V")
    public MonochromeImageCacheSlot(@OriginalArg(0) int id, @OriginalArg(1) int slot) {
        this.slot = slot;
        this.id = id;
    }
}
