package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ie")
public class Node {

    @OriginalMember(owner = "client!ge", name = "a", descriptor = "(ILclient!ie;Lclient!ie;)V")
    public static void addBefore(@OriginalArg(1) Node back, @OriginalArg(2) Node front) {
        if (front.prev != null) {
            front.unlink();
        }
        front.next = back;
        front.prev = back.prev;
        front.prev.next = front;
        front.next.prev = front;
    }

    @OriginalMember(owner = "client!ie", name = "f", descriptor = "J")
    public long key;

    @OriginalMember(owner = "client!ie", name = "c", descriptor = "Lclient!ie;")
    public Node prev;

    @OriginalMember(owner = "client!ie", name = "i", descriptor = "Lclient!ie;")
    public Node next;

    @OriginalMember(owner = "client!ie", name = "a", descriptor = "(B)V")
    public final void unlink() {
        if (this.prev != null) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.next = null;
            this.prev = null;
        }
    }

    @OriginalMember(owner = "client!ie", name = "e", descriptor = "(I)Z")
    public final boolean isLinked() {
        return this.prev != null;
    }
}
