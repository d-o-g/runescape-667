package com.jagex.graphics;

import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dca")
public final class DoublyLinkedNode_Sub2_Sub7 extends Node2 {

    @OriginalMember(owner = "client!dca", name = "u", descriptor = "[B")
    public final byte[] aByteArray21;

    @OriginalMember(owner = "client!dca", name = "<init>", descriptor = "([B)V")
    public DoublyLinkedNode_Sub2_Sub7(@OriginalArg(0) byte[] arg0) {
        this.aByteArray21 = arg0;
    }
}
