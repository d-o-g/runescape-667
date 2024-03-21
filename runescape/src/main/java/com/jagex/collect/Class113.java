package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!et")
public final class Class113 {

    @OriginalMember(owner = "client!et", name = "a", descriptor = "Lclient!fi;")
    public Node2 pointer;

    @OriginalMember(owner = "client!et", name = "e", descriptor = "Lclient!fi;")
    public final Node2 sentinel = new Node2();

    @OriginalMember(owner = "client!et", name = "<init>", descriptor = "()V")
    public Class113() {
        this.sentinel.next2 = this.sentinel;
        this.sentinel.prev2 = this.sentinel;
    }

    @OriginalMember(owner = "client!et", name = "b", descriptor = "(I)V")
    public void clear() {
        while (true) {
            @Pc(16) Node2 node = this.sentinel.next2;
            if (node == this.sentinel) {
                this.pointer = null;
                return;
            }
            node.unlink2();
        }
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(ILclient!fi;)V")
    public void add(@OriginalArg(1) Node2 node) {
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
        for (@Pc(19) Node2 node = this.sentinel.next2; node != this.sentinel; node = node.next2) {
            size++;
        }
        return size;
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(Z)Lclient!fi;")
    public Node2 next() {
        @Pc(6) Node2 node = this.pointer;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next2;
            return node;
        }
    }

    @OriginalMember(owner = "client!et", name = "a", descriptor = "(I)Lclient!fi;")
    public Node2 first() {
        @Pc(15) Node2 node = this.sentinel.next2;
        if (node == this.sentinel) {
            this.pointer = null;
            return null;
        } else {
            this.pointer = node.next2;
            return node;
        }
    }

}
