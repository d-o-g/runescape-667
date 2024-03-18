package com.jagex.collect.ref;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mh")
public final class HardReferenceNode extends ReferenceNode {

    @OriginalMember(owner = "client!mh", name = "z", descriptor = "Ljava/lang/Object;")
    public final Object object;

    @OriginalMember(owner = "client!mh", name = "<init>", descriptor = "(Ljava/lang/Object;I)V")
    public HardReferenceNode(@OriginalArg(0) Object object, @OriginalArg(1) int weight) {
        super(weight);
        this.object = object;
    }

    @OriginalMember(owner = "client!mh", name = "c", descriptor = "(B)Ljava/lang/Object;")
    @Override
    public Object get() {
        return this.object;
    }

    @OriginalMember(owner = "client!mh", name = "d", descriptor = "(I)Z")
    @Override
    public boolean isSoft() {
        return false;
    }
}
