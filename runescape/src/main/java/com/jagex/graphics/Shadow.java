package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!r")
public abstract class Shadow extends Node2 {

    @OriginalMember(owner = "client!r", name = "<init>", descriptor = "()V")
    protected Shadow() {
    }
}
