package com.jagex.core.datastruct.ref;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jl")
public final class SoftReferenceFactory extends ReferenceNodeFactory {

    @OriginalMember(owner = "client!jl", name = "<init>", descriptor = "()V")
    public SoftReferenceFactory() {
    }

    @OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!vw;I)Lclient!vw;")
    @Override
    public ReferenceNode create(@OriginalArg(0) ReferenceNode node) {
        return new SoftReferenceNode(node.get(), node.size);
    }
}
