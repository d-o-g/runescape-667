package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sia")
public final class Deque {

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "Lclient!ie;")
    public Node pointer;

    @OriginalMember(owner = "client!sia", name = "x", descriptor = "Lclient!ie;")
    public final Node last = new Node();

    @OriginalMember(owner = "client!sia", name = "<init>", descriptor = "()V")
    public Deque() {
        this.last.next = this.last;
        this.last.prev = this.last;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;I)V")
    public void addFirst(@OriginalArg(0) Node node) {
        if (node.prev != null) {
            node.remove();
        }
        node.next = this.last.next;
        node.prev = this.last;
        node.prev.next = node;
        node.next.prev = node;
    }

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "(I)Lclient!ie;")
    public Node first() {
        @Pc(7) Node first = this.last.next;
        if (first == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = first.next;
            return first;
        }
    }

    @OriginalMember(owner = "client!sia", name = "f", descriptor = "(I)V")
    public void clear() {
        while (true) {
            @Pc(7) Node current = this.last.next;
            if (this.last == current) {
                this.pointer = null;
                return;
            }
            current.remove();
        }
    }

    @OriginalMember(owner = "client!sia", name = "c", descriptor = "(I)I")
    public int size() {
        @Pc(13) int size = 0;
        @Pc(17) Node current = this.last.next;
        while (current != this.last) {
            current = current.next;
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!sia", name = "d", descriptor = "(I)Z")
    public boolean isEmpty() {
        return this.last == this.last.next;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;Lclient!sia;B)V")
    public void append(@OriginalArg(0) Node before, @OriginalArg(1) Deque deque) {
        @Pc(7) Node node = this.last.prev;
        this.last.prev = before.prev;
        before.prev.next = this.last;
        if (before != this.last) {
            before.prev = deque.last.prev;
            before.prev.next = before;
            node.next = deque.last;
            deque.last.prev = node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(I)Lclient!ie;")
    public Node removeFirst() {
        @Pc(7) Node node = this.last.next;
        if (node == this.last) {
            return null;
        } else {
            node.remove();
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "h", descriptor = "(I)Lclient!ie;")
    public Node next() {
        @Pc(13) Node node = this.pointer;
        if (node == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(ILclient!sia;)V")
    public void appendTo(@OriginalArg(1) Deque arg0) {
        this.append(this.last.next, arg0);
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(B)Lclient!ie;")
    public Node last() {
        @Pc(14) Node node = this.last.prev;
        if (node == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "(B)Lclient!ie;")
    public Node previous() {
        @Pc(6) Node node = this.pointer;
        if (node == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(BLclient!ie;)V")
    public void addLast(@OriginalArg(1) Node node) {
        if (node.prev != null) {
            node.remove();
        }
        node.next = this.last;
        node.prev = this.last.prev;
        node.prev.next = node;
        node.next.prev = node;
    }
}
