package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ps")
public final class QueueIterator {

    @OriginalMember(owner = "client!ps", name = "a", descriptor = "Lclient!cm;")
    public Node2 node;

    @OriginalMember(owner = "client!ps", name = "e", descriptor = "Lclient!jga;")
    public Queue queue;

    @OriginalMember(owner = "client!ps", name = "<init>", descriptor = "()V")
    public QueueIterator() {
    }

    @OriginalMember(owner = "client!ps", name = "<init>", descriptor = "(Lclient!jga;)V")
    public QueueIterator(@OriginalArg(0) Queue queue) {
        this.queue = queue;
    }

    @OriginalMember(owner = "client!ps", name = "b", descriptor = "(I)Lclient!cm;")
    public Node2 next() {
        @Pc(6) Node2 node = this.node;
        if (node == this.queue.sentinel) {
            this.node = null;
            return null;
        } else {
            this.node = node.next2;
            return node;
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
