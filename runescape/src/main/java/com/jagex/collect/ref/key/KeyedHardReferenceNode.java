package com.jagex.collect.ref.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tja")
public final class KeyedHardReferenceNode extends KeyedReferenceNode {

    @OriginalMember(owner = "client!tja", name = "y", descriptor = "Ljava/lang/Object;")
    public final Object object;

    @OriginalMember(owner = "client!tja", name = "<init>", descriptor = "(Lclient!uq;Ljava/lang/Object;I)V")
    public KeyedHardReferenceNode(@OriginalArg(0) CacheKey cacheKey, @OriginalArg(1) Object object, @OriginalArg(2) int size) {
        super(cacheKey, size);
        this.object = object;
    }

    @OriginalMember(owner = "client!tja", name = "c", descriptor = "(B)Z")
    @Override
    public boolean isSoft() {
        return false;
    }

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(I)Ljava/lang/Object;")
    @Override
    public Object get() {
        return this.object;
    }
}
