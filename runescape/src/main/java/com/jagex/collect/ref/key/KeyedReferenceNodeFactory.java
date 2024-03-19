package com.jagex.collect.ref.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nka")
public abstract class KeyedReferenceNodeFactory {

    @OriginalMember(owner = "client!qda", name = "p", descriptor = "Lclient!nka;")
    public static final KeyedReferenceNodeFactory INSTANCE = create();

    @OriginalMember(owner = "client!nl", name = "c", descriptor = "(I)Lclient!nka;")
    private static KeyedReferenceNodeFactory create() {
        try {
            return (KeyedReferenceNodeFactory) Class.forName("com.jagex.collect.ref.key.KeyedSoftReferenceFactory").getDeclaredConstructor().newInstance();
        } catch (@Pc(18) Throwable ignored) {
            return null;
        }
    }

    @OriginalMember(owner = "client!nka", name = "a", descriptor = "(Lclient!pv;I)Lclient!pv;")
    public abstract KeyedReferenceNode create(@OriginalArg(0) KeyedReferenceNode node);
}
