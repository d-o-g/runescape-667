package com.jagex.collect.hash;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.lang.ref.SoftReference;

@OriginalClass("client!fja")
public final class HashableSoftReference extends HashableReference {

    @OriginalMember(owner = "client!fja", name = "y", descriptor = "Ljava/lang/ref/SoftReference;")
    public final SoftReference softReference;

    @OriginalMember(owner = "client!fja", name = "<init>", descriptor = "(Lclient!uq;Ljava/lang/Object;I)V")
    public HashableSoftReference(@OriginalArg(0) Hashable hashable, @OriginalArg(1) Object object, @OriginalArg(2) int size) {
        super(hashable, size);
        this.softReference = new SoftReference(object);
    }

    @OriginalMember(owner = "client!fja", name = "a", descriptor = "(I)Ljava/lang/Object;")
    @Override
    public Object get() {
        return this.softReference.get();
    }

    @OriginalMember(owner = "client!fja", name = "c", descriptor = "(B)Z")
    @Override
    public boolean isSoft() {
        return true;
    }
}
