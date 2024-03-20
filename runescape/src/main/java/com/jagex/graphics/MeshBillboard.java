package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!aq")
public final class MeshBillboard {

    @OriginalMember(owner = "client!aq", name = "h", descriptor = "I")
    public final int anInt591;

    @OriginalMember(owner = "client!aq", name = "c", descriptor = "I")
    public final int anInt592;

    @OriginalMember(owner = "client!aq", name = "j", descriptor = "I")
    public final int face;

    @OriginalMember(owner = "client!aq", name = "d", descriptor = "I")
    public final int group;

    @OriginalMember(owner = "client!aq", name = "<init>", descriptor = "(IIII)V")
    public MeshBillboard(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        this.anInt591 = arg3;
        this.anInt592 = arg0;
        this.face = arg1;
        this.group = arg2;
    }

    @OriginalMember(owner = "client!aq", name = "a", descriptor = "(II)Lclient!aq;")
    public MeshBillboard copy(@OriginalArg(1) int arg0) {
        return new MeshBillboard(this.anInt592, arg0, this.group, this.anInt591);
    }
}
