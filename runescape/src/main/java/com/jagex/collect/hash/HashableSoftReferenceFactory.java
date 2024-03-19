package com.jagex.collect.hash;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ao")
public final class HashableSoftReferenceFactory extends HashableReferenceFactory {

    @OriginalMember(owner = "client!ao", name = "<init>", descriptor = "()V")
    public HashableSoftReferenceFactory() {
    }

    @OriginalMember(owner = "client!ao", name = "a", descriptor = "(Lclient!pv;I)Lclient!pv;")
    @Override
    public HashableReference create(@OriginalArg(0) HashableReference reference) {
        return new HashableSoftReference(reference.hashable, reference.get(), reference.size);
    }
}
