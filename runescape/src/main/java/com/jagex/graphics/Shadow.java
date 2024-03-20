package com.jagex.graphics;

import com.jagex.collect.LinkedHashTable;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!r")
public abstract class Shadow extends LinkedHashTable.Node {

    @OriginalMember(owner = "client!r", name = "<init>", descriptor = "()V")
    protected Shadow() {
    }
}
