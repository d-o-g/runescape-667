package com.jagex.collect.ref;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jl")
public final class SoftReferenceFactory extends ReferenceNodeFactory {

    @OriginalMember(owner = "client!nw", name = "k", descriptor = "Lclient!gh;")
    public static final ReferenceNodeFactory INSTANCE = create();

    @OriginalMember(owner = "client!uca", name = "b", descriptor = "(Z)Lclient!gh;")
    public static ReferenceNodeFactory create() {
        try {
            return (ReferenceNodeFactory) Class.forName("com.jagex.collect.ref.SoftReferenceFactory").getDeclaredConstructor().newInstance();
        } catch (@Pc(16) Throwable ignored) {
            return null;
        }
    }

    @OriginalMember(owner = "client!jl", name = "<init>", descriptor = "()V")
    public SoftReferenceFactory() {
    }

    @OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!vw;I)Lclient!vw;")
    @Override
    public ReferenceNode create(@OriginalArg(0) ReferenceNode node) {
        return new SoftReferenceNode(node.get(), node.size);
    }
}
