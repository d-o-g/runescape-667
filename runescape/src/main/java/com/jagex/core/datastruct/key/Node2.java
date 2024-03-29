package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cm")
public class Node2 extends Node {

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(ZLclient!cm;Lclient!cm;)V")
    public static void addBefore(@OriginalArg(2) Node2 before, @OriginalArg(1) Node2 node) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        node.prev2 = before.prev2;
        node.next2 = before;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
    }

    @OriginalMember(owner = "client!mt", name = "a", descriptor = "(ILclient!cm;Lclient!cm;)V")
    public static void addAfter(@OriginalArg(1) Node2 after, @OriginalArg(2) Node2 node) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        node.next2 = after.next2;
        node.prev2 = after;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
    }

    @OriginalMember(owner = "client!cm", name = "l", descriptor = "Lclient!cm;")
    public Node2 next2;

    @OriginalMember(owner = "client!cm", name = "s", descriptor = "Lclient!cm;")
    public Node2 prev2;

    @OriginalMember(owner = "client!cm", name = "m", descriptor = "J")
    public long key2;

    @OriginalMember(owner = "client!cm", name = "c", descriptor = "(I)V")
    public final void unlink2() {
        if (this.prev2 != null) {
            this.prev2.next2 = this.next2;
            this.next2.prev2 = this.prev2;
            this.next2 = null;
            this.prev2 = null;
        }
    }

    @OriginalMember(owner = "client!cm", name = "b", descriptor = "(B)Z")
    public final boolean isLinked2() {
        return this.prev2 != null;
    }
}
