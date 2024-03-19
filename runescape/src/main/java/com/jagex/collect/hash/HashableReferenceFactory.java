package com.jagex.collect.hash;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nka")
public abstract class HashableReferenceFactory {

    @OriginalMember(owner = "client!qda", name = "p", descriptor = "Lclient!nka;")
    public static final HashableReferenceFactory instance = create();

    @OriginalMember(owner = "client!nl", name = "c", descriptor = "(I)Lclient!nka;")
    private static HashableReferenceFactory create() {
        try {
            return (HashableReferenceFactory) Class.forName("com.jagex.collect.hash.HashableSoftReferenceFactory").getDeclaredConstructor().newInstance();
        } catch (@Pc(18) Throwable ignored) {
            return null;
        }
    }

    @OriginalMember(owner = "client!nka", name = "a", descriptor = "(Lclient!pv;I)Lclient!pv;")
    public abstract HashableReference create(@OriginalArg(0) HashableReference reference);
}
