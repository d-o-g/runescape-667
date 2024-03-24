package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ep")
public class Cylinder {

    @OriginalMember(owner = "client!ep", name = "c", descriptor = "Lclient!ep;")
    public Cylinder prev;

    @OriginalMember(owner = "client!ep", name = "e", descriptor = "Lclient!ep;")
    public Cylinder next;

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
