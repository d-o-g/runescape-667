package com.jagex.core.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fi")
public class Node2 extends Node {

    @OriginalMember(owner = "client!fi", name = "l", descriptor = "Lclient!fi;")
    public Node2 prev2;

    @OriginalMember(owner = "client!fi", name = "i", descriptor = "Lclient!fi;")
    public Node2 next2;

    @OriginalMember(owner = "client!fi", name = "b", descriptor = "(Z)V")
    public final void unlink2() {
        if (this.prev2 != null) {
            this.prev2.next2 = this.next2;
            this.next2.prev2 = this.prev2;
            this.prev2 = null;
            this.next2 = null;
        }
    }
}
