package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!za")
public abstract class MemoryPool extends Node {

    @OriginalMember(owner = "client!za", name = "<init>", descriptor = "()V")
    protected MemoryPool() {
    }
}
