package com.jagex.collect.hash;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uq")
public interface Hashable {

    @OriginalMember(owner = "client!uq", name = "a", descriptor = "(ILclient!uq;)Z")
    boolean matches(@OriginalArg(1) Hashable other);

    @OriginalMember(owner = "client!uq", name = "a", descriptor = "(I)J")
    long hash();
}
