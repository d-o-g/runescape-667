package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jga")
public final class Queue {

    @OriginalMember(owner = "client!jga", name = "f", descriptor = "Lclient!cm;")
    public LinkedHashTable.Node pointer;

    @OriginalMember(owner = "client!jga", name = "h", descriptor = "Lclient!cm;")
    public final LinkedHashTable.Node last = new LinkedHashTable.Node();

    @OriginalMember(owner = "client!jga", name = "<init>", descriptor = "()V")
    public Queue() {
        this.last.next2 = this.last;
        this.last.prev2 = this.last;
    }

    @OriginalMember(owner = "client!jga", name = "c", descriptor = "(I)Lclient!cm;")
    public LinkedHashTable.Node removeFirst() {
        @Pc(7) LinkedHashTable.Node node = this.last.next2;
        if (this.last == node) {
            return null;
        } else {
            node.unlink2();
            return node;
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(ZLclient!cm;)V")
    public void add(@OriginalArg(1) LinkedHashTable.Node node) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        node.next2 = this.last;
        node.prev2 = this.last.prev2;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(B)I")
    public int size() {
        @Pc(5) int size = 0;
        @Pc(17) LinkedHashTable.Node current = this.last.next2;
        while (this.last != current) {
            current = current.next2;
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!jga", name = "b", descriptor = "(I)Lclient!cm;")
    public LinkedHashTable.Node next() {
        @Pc(11) LinkedHashTable.Node next = this.pointer;
        if (next == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = next.next2;
            return next;
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(Z)V")
    public void clear() {
        while (true) {
            @Pc(3) LinkedHashTable.Node current = this.last.next2;
            if (current == this.last) {
                this.pointer = null;
                return;
            }
            current.unlink2();
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(I)Lclient!cm;")
    public LinkedHashTable.Node first() {
        @Pc(18) LinkedHashTable.Node first = this.last.next2;
        if (first == this.last) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = first.next2;
            return first;
        }
    }
}
