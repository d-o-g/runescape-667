package com.jagex.core.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ep")
public class Node {

    @OriginalMember(owner = "client!lm", name = "a", descriptor = "(BLclient!ep;Lclient!ep;)V")
    public static void addBefore(@OriginalArg(2) Node before, @OriginalArg(1) Node node) {
        if (node.prev != null) {
            node.unlink();
        }
        node.next = before;
        node.prev = before.prev;
        node.prev.next = node;
        node.next.prev = node;
    }

    @OriginalMember(owner = "client!ep", name = "c", descriptor = "Lclient!ep;")
    public Node prev;

    @OriginalMember(owner = "client!ep", name = "e", descriptor = "Lclient!ep;")
    public Node next;

    @OriginalMember(owner = "client!ep", name = "a", descriptor = "(Z)V")
    public final void unlink() {
        if (this.prev != null) {
            this.prev.next = this.next;
            this.next.prev = this.prev;
            this.next = null;
            this.prev = null;
        }
    }
}
