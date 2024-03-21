package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gga")
public final class HashTable {

    @OriginalMember(owner = "client!gga", name = "h", descriptor = "Lclient!cm;")
    public Node2 node;

    @OriginalMember(owner = "client!gga", name = "c", descriptor = "J")
    public long searchKey;

    @OriginalMember(owner = "client!gga", name = "d", descriptor = "[Lclient!cm;")
    public final Node2[] nodes;

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!gga", name = "<init>", descriptor = "(I)V")
    public HashTable(@OriginalArg(0) int capacity) {
        this.nodes = new Node2[capacity];
        this.capacity = capacity;

        for (@Pc(10) int i = 0; i < capacity; i++) {
            @Pc(20) Node2 node = this.nodes[i] = new Node2();
            node.prev2 = node;
            node.next2 = node;
        }
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(BLclient!cm;J)V")
    public void put(@OriginalArg(1) Node2 node, @OriginalArg(2) long key) {
        if (node.prev2 != null) {
            node.unlink2();
        }
        @Pc(28) Node2 local28 = this.nodes[(int) ((long) (this.capacity - 1) & key)];
        node.next2 = local28;
        node.prev2 = local28.prev2;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
        node.key2 = key;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(JI)Lclient!cm;")
    public Node2 get(@OriginalArg(0) long key) {
        this.searchKey = key;
        @Pc(20) Node2 local20 = this.nodes[(int) (key & (long) (this.capacity - 1))];
        for (this.node = local20.next2; this.node != local20; this.node = this.node.next2) {
            if (key == this.node.key2) {
                @Pc(41) Node2 local41 = this.node;
                this.node = this.node.next2;
                return local41;
            }
        }
        this.node = null;
        return null;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(I)Lclient!cm;")
    public Node2 method3096() {
        if (this.node == null) {
            return null;
        }

        @Pc(24) Node2 node = this.nodes[(int) (this.searchKey & (long) (this.capacity - 1))];
        while (this.node != node) {
            if (this.searchKey == this.node.key2) {
                @Pc(38) Node2 local38 = this.node;
                this.node = this.node.next2;
                return local38;
            }
            this.node = this.node.next2;
        }

        this.node = null;
        return null;
    }
}
