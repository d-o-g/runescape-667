package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jg")
public final class DequeIterator {

    @OriginalMember(owner = "client!jg", name = "g", descriptor = "Lclient!sia;")
    public Deque deque;

    @OriginalMember(owner = "client!jg", name = "j", descriptor = "Lclient!ie;")
    public Node node;

    @OriginalMember(owner = "client!jg", name = "<init>", descriptor = "()V")
    public DequeIterator() {
    }

    @OriginalMember(owner = "client!jg", name = "<init>", descriptor = "(Lclient!sia;)V")
    public DequeIterator(@OriginalArg(0) Deque deque) {
        this.deque = deque;
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(B)Lclient!ie;")
    public Node next() {
        @Pc(12) Node node = this.node;
        if (this.deque.sentinel == node) {
            this.node = null;
            return null;
        } else {
            this.node = node.next;
            return node;
        }
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(I)Lclient!ie;")
    public Node first() {
        @Pc(8) Node node = this.deque.sentinel.next;
        if (this.deque.sentinel == node) {
            this.node = null;
            return null;
        } else {
            this.node = node.next;
            return node;
        }
    }

    @OriginalMember(owner = "client!jg", name = "a", descriptor = "(Lclient!sia;I)V")
    public void setDeque(@OriginalArg(0) Deque deque) {
        this.deque = deque;
    }
}
