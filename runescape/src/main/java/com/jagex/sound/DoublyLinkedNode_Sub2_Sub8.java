package com.jagex.sound;

import com.jagex.core.datastruct.key.DoublyLinkedNode;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dk")
public final class DoublyLinkedNode_Sub2_Sub8 extends DoublyLinkedNode {

    @OriginalMember(owner = "client!dk", name = "w", descriptor = "D")
    public double aDouble10;

    @OriginalMember(owner = "client!dk", name = "t", descriptor = "[[S")
    public final short[][] aShortArrayArray3;

    @OriginalMember(owner = "client!dk", name = "<init>", descriptor = "([[SD)V")
    public DoublyLinkedNode_Sub2_Sub8(@OriginalArg(0) short[][] arg0, @OriginalArg(1) double arg1) {
        this.aDouble10 = arg1;
        this.aShortArrayArray3 = arg0;
    }

    @OriginalMember(owner = "client!dk", name = "a", descriptor = "(Z)J")
    public long method2133() {
        return this.aShortArrayArray3.length << 0 | this.aShortArrayArray3[0].length;
    }
}
