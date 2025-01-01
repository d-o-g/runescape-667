package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!aq")
public final class MeshBillboard {

    @OriginalMember(owner = "client!aq", name = "h", descriptor = "I")
    public final int distance;

    @OriginalMember(owner = "client!aq", name = "c", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!aq", name = "j", descriptor = "I")
    public final int face;

    @OriginalMember(owner = "client!aq", name = "d", descriptor = "I")
    public final int group;

    @OriginalMember(owner = "client!aq", name = "<init>", descriptor = "(IIII)V")
    public MeshBillboard(@OriginalArg(0) int id, @OriginalArg(1) int face, @OriginalArg(2) int group, @OriginalArg(3) int distance) {
        this.distance = distance;
        this.id = id;
        this.face = face;
        this.group = group;
    }

    @OriginalMember(owner = "client!aq", name = "a", descriptor = "(II)Lclient!aq;")
    public MeshBillboard copy(@OriginalArg(1) int face) {
        return new MeshBillboard(this.id, face, this.group, this.distance);
    }
}
