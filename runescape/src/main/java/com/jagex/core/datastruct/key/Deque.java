package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sia")
public final class Deque<T extends Node> {

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "Lclient!ie;")
    public Node pointer;

    @OriginalMember(owner = "client!sia", name = "x", descriptor = "Lclient!ie;")
    public final Node sentinel = new Node();

    @OriginalMember(owner = "client!sia", name = "<init>", descriptor = "()V")
    public Deque() {
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;I)V")
    public void addFirst(@OriginalArg(0) T node) {
        if (node.prev != null) {
            node.unlink();
        }
        node.next = this.sentinel.next;
        node.prev = this.sentinel;
        node.prev.next = node;
        node.next.prev = node;
    }

    @OriginalMember(owner = "client!sia", name = "e", descriptor = "(I)Lclient!ie;")
    public T first() {
        @Pc(7) Node first = this.sentinel.next;
        if (first == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = first.next;
            return (T) first;
        }
    }

    @OriginalMember(owner = "client!sia", name = "f", descriptor = "(I)V")
    public void clear() {
        while (true) {
            @Pc(7) Node current = this.sentinel.next;
            if (this.sentinel == current) {
                this.pointer = null;
                return;
            }
            current.unlink();
        }
    }

    @OriginalMember(owner = "client!sia", name = "c", descriptor = "(I)I")
    public int size() {
        @Pc(13) int size = 0;
        @Pc(17) Node node = this.sentinel.next;
        while (node != this.sentinel) {
            node = node.next;
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!sia", name = "d", descriptor = "(I)Z")
    public boolean isEmpty() {
        return this.sentinel == this.sentinel.next;
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(Lclient!ie;Lclient!sia;B)V")
    public void append(@OriginalArg(0) Node before, @OriginalArg(1) Deque<T> deque) {
        @Pc(7) Node node = this.sentinel.prev;
        this.sentinel.prev = before.prev;
        before.prev.next = this.sentinel;
        if (before != this.sentinel) {
            before.prev = deque.sentinel.prev;
            before.prev.next = before;
            node.next = deque.sentinel;
            deque.sentinel.prev = node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(I)Lclient!ie;")
    public T removeFirst() {
        @Pc(7) Node node = this.sentinel.next;
        if (node == this.sentinel) {
            return null;
        } else {
            node.unlink();
            return (T) node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "h", descriptor = "(I)Lclient!ie;")
    public T next() {
        @Pc(13) Node node = this.pointer;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next;
            return (T) node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(ILclient!sia;)V")
    public void appendTo(@OriginalArg(1) Deque<T> deque) {
        this.append(this.sentinel.next, deque);
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(B)Lclient!ie;")
    public T last() {
        @Pc(14) Node node = this.sentinel.prev;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return (T) node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "b", descriptor = "(B)Lclient!ie;")
    public T previous() {
        @Pc(6) Node node = this.pointer;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.prev;
            return (T) node;
        }
    }

    @OriginalMember(owner = "client!sia", name = "a", descriptor = "(BLclient!ie;)V")
    public void addLast(@OriginalArg(1) T node) {
        if (node.prev != null) {
            node.unlink();
        }
        node.next = this.sentinel;
        node.prev = this.sentinel.prev;
        node.prev.next = node;
        node.next.prev = node;
    }
}
