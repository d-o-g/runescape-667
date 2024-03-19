package com.jagex.js5;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!bm")
public abstract class ResourceProvider {

    @OriginalMember(owner = "client!bm", name = "<init>", descriptor = "()V")
    protected ResourceProvider() {
    }

    @OriginalMember(owner = "client!bm", name = "a", descriptor = "(II)V")
    public abstract void requestGroup(@OriginalArg(1) int groupId);

    @OriginalMember(owner = "client!bm", name = "a", descriptor = "(BI)I")
    public abstract int completePercentage(@OriginalArg(1) int groupId);

    @OriginalMember(owner = "client!bm", name = "a", descriptor = "(IB)[B")
    public abstract byte[] fetchgroup(@OriginalArg(0) int groupId);

    @OriginalMember(owner = "client!bm", name = "b", descriptor = "(B)Lclient!pj;")
    public abstract Js5Index index();
}
