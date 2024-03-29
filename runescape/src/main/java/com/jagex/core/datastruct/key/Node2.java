package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cm")
public class Node2 extends Node {

    @OriginalMember(owner = "client!eja", name = "a", descriptor = "(ZLclient!cm;Lclient!cm;)V")
    public static void addBefore(@OriginalArg(1) Node2 front, @OriginalArg(2) Node2 back) {
        if (front.prev2 != null) {
            front.unlink2();
        }
        front.prev2 = back.prev2;
        front.next2 = back;
        front.prev2.next2 = front;
        front.next2.prev2 = front;
    }

    @OriginalMember(owner = "client!mt", name = "a", descriptor = "(ILclient!cm;Lclient!cm;)V")
    public static void addAfter(@OriginalArg(1) Node2 back, @OriginalArg(2) Node2 front) {
        if (front.prev2 != null) {
            front.unlink2();
        }
        front.next2 = back.next2;
        front.prev2 = back;
        front.prev2.next2 = front;
        front.next2.prev2 = front;
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
