package com.jagex.core.datastruct.ref.key;

import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!pv")
public abstract class KeyedReferenceNode extends Node2 {

    @OriginalMember(owner = "client!pv", name = "u", descriptor = "I")
    public final int size;

    @OriginalMember(owner = "client!pv", name = "x", descriptor = "Lclient!uq;")
    public final CacheKey cacheKey;

    @OriginalMember(owner = "client!pv", name = "<init>", descriptor = "(Lclient!uq;I)V")
    protected KeyedReferenceNode(@OriginalArg(0) CacheKey cacheKey, @OriginalArg(1) int size) {
        this.size = size;
        this.cacheKey = cacheKey;
    }

    @OriginalMember(owner = "client!pv", name = "a", descriptor = "(I)Ljava/lang/Object;")
    public abstract Object get();

    @OriginalMember(owner = "client!pv", name = "c", descriptor = "(B)Z")
    public abstract boolean isSoft();
}
