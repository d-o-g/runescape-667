package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fla")
public final class LinkedList {

    @OriginalMember(owner = "client!fla", name = "f", descriptor = "Lclient!ep;")
    public Node pointer;

    @OriginalMember(owner = "client!fla", name = "j", descriptor = "Lclient!ep;")
    public final Node sentinel = new Node();

    @OriginalMember(owner = "client!fla", name = "<init>", descriptor = "()V")
    public LinkedList() {
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }

    @OriginalMember(owner = "client!fla", name = "d", descriptor = "(I)Z")
    public boolean isEmpty() {
        return this.sentinel == this.sentinel.next;
    }

    @OriginalMember(owner = "client!fla", name = "e", descriptor = "(I)Lclient!ep;")
    public Node removeFirst() {
        @Pc(15) Node next = this.sentinel.next;
        if (next == this.sentinel) {
            return null;
        } else {
            next.unlink();
            return next;
        }
    }

    @OriginalMember(owner = "client!fla", name = "c", descriptor = "(I)I")
    public int size() {
        @Pc(7) int size = 0;
        for (@Pc(11) Node node = this.sentinel.next; node != this.sentinel; node = node.next) {
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(I)Lclient!ep;")
    public Node next() {
        @Pc(6) Node point = this.pointer;
        if (this.sentinel == point) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = point.next;
            return point;
        }
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(ZLclient!ep;)V")
    public void add(@OriginalArg(1) Node node) {
        if (node.prev != null) {
            node.unlink();
        }
        node.prev = this.sentinel.prev;
        node.next = this.sentinel;
        node.prev.next = node;
        node.next.prev = node;
    }

    @OriginalMember(owner = "client!fla", name = "b", descriptor = "(I)Lclient!ep;")
    public Node last() {
        @Pc(15) Node last = this.sentinel.prev;
        if (last == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = last.prev;
            return last;
        }
    }

    @OriginalMember(owner = "client!fla", name = "b", descriptor = "(B)V")
    public void clear() {
        while (true) {
            @Pc(11) Node node = this.sentinel.next;
            if (node == this.sentinel) {
                this.pointer = null;
                return;
            }
            node.unlink();
        }
    }

    @OriginalMember(owner = "client!fla", name = "a", descriptor = "(B)Lclient!ep;")
    public Node first() {
        @Pc(15) Node node = this.sentinel.next;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next;
            return node;
        }
    }

    @OriginalClass("client!ep")
    public static class Node {

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
}
