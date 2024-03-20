package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!et")
public final class Class113 {

    @OriginalMember(owner = "client!et", name = "a", descriptor = "Lclient!fi;")
    public Node pointer;

    @OriginalMember(owner = "client!et", name = "e", descriptor = "Lclient!fi;")
    public final Node sentinel = new Node();

    @OriginalMember(owner = "client!et", name = "<init>", descriptor = "()V")
    public Class113() {
        this.sentinel.next2 = this.sentinel;
        this.sentinel.prev2 = this.sentinel;
    }

    @OriginalMember(owner = "client!et", name = "b", descriptor = "(I)V")
    public void clear() {
        while (true) {
            @Pc(16) Node node = this.sentinel.next2;
            if (node == this.sentinel) {
                this.pointer = null;
                return;
            }
            node.unlink2();
        }
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(ILclient!fi;)V")
    public void add(@OriginalArg(1) Node node) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        node.next2 = this.sentinel;
        node.prev2 = this.sentinel.prev2;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
    }

    @OriginalMember(owner = "client!et", name = "c", descriptor = "(I)I")
    public int size() {
        @Pc(7) int size = 0;
        for (@Pc(19) Node node = this.sentinel.next2; node != this.sentinel; node = node.next2) {
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(Z)Lclient!fi;")
    public Node next() {
        @Pc(6) Node node = this.pointer;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next2;
            return node;
        }
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(I)Lclient!fi;")
    public Node first() {
        @Pc(15) Node node = this.sentinel.next2;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next2;
            return node;
        }
    }

    @OriginalClass("client!fi")
    public static class Node extends LinkedList.Node {

        @OriginalMember(owner = "client!fi", name = "l", descriptor = "Lclient!fi;")
        public Node prev2;

        @OriginalMember(owner = "client!fi", name = "i", descriptor = "Lclient!fi;")
        public Node next2;

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
}
