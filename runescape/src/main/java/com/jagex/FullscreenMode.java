package com.jagex;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!oga")
public final class FullscreenMode {

    @OriginalMember(owner = "client!oga", name = "c", descriptor = "I")
    public int refreshrate;

    @OriginalMember(owner = "client!oga", name = "b", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!oga", name = "f", descriptor = "I")
    public int bits;

    @OriginalMember(owner = "client!oga", name = "e", descriptor = "I")
    public int width;
}
