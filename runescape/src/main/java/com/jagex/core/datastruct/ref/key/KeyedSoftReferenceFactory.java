package com.jagex.core.datastruct.ref.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ao")
public final class KeyedSoftReferenceFactory extends KeyedReferenceNodeFactory {

    @OriginalMember(owner = "client!ao", name = "<init>", descriptor = "()V")
    public KeyedSoftReferenceFactory() {
    }

    @OriginalMember(owner = "client!ao", name = "a", descriptor = "(Lclient!pv;I)Lclient!pv;")
    @Override
    public KeyedReferenceNode create(@OriginalArg(0) KeyedReferenceNode node) {
        return new KeyedSoftReferenceNode(node.cacheKey, node.get(), node.size);
    }
}
