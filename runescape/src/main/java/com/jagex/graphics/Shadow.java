package com.jagex.graphics;

import com.jagex.core.datastruct.key.DoublyLinkedNode;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!r")
public abstract class Shadow extends DoublyLinkedNode {

    @OriginalMember(owner = "client!r", name = "<init>", descriptor = "()V")
    protected Shadow() {
    }
}
