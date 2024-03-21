package com.jagex.collect.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ps")
public final class Class299 {

    @OriginalMember(owner = "client!ps", name = "a", descriptor = "Lclient!cm;")
    public Node2 node;

    @OriginalMember(owner = "client!ps", name = "e", descriptor = "Lclient!jga;")
    public Queue queue;

    @OriginalMember(owner = "client!ps", name = "<init>", descriptor = "()V")
    public Class299() {
    }

    @OriginalMember(owner = "client!ps", name = "<init>", descriptor = "(Lclient!jga;)V")
    public Class299(@OriginalArg(0) Queue queue) {
        this.queue = queue;
    }

    @OriginalMember(owner = "client!ps", name = "b", descriptor = "(I)Lclient!cm;")
    public Node2 next() {
        @Pc(6) Node2 local6 = this.node;
        if (local6 == this.queue.sentinel) {
            this.node = null;
            return null;
        } else {
            this.node = local6.next2;
            return local6;
        }
    }

    @OriginalMember(owner = "client!ps", name = "a", descriptor = "(I)Lclient!cm;")
    public Node2 first() {
        @Pc(14) Node2 node = this.queue.sentinel.next2;
        if (this.queue.sentinel == node) {
            this.node = null;
            return null;
        } else {
            this.node = node.next2;
            return node;
        }
    }
}
