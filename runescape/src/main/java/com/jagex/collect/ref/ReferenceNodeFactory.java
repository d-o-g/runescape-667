package com.jagex.collect.ref;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gh")
public abstract class ReferenceNodeFactory {

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

    @OriginalMember(owner = "client!gh", name = "a", descriptor = "(Lclient!vw;I)Lclient!vw;")
    public abstract ReferenceNode create(@OriginalArg(0) ReferenceNode node);
}
