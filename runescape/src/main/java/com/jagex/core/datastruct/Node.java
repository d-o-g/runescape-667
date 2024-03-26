package com.jagex.core.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ep")
public class Node {

    @OriginalMember(owner = "client!lm", name = "a", descriptor = "(BLclient!ep;Lclient!ep;)V")
    public static void method5282(@OriginalArg(1) Node arg0, @OriginalArg(2) Node arg1) {
        if (arg0.prev != null) {
            arg0.unlink();
        }
        arg0.next = arg1;
        arg0.prev = arg1.prev;
        arg0.prev.next = arg0;
        arg0.next.prev = arg0;
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
