package com.jagex.collect.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gga")
public final class Class144 {

    @OriginalMember(owner = "client!gga", name = "h", descriptor = "Lclient!cm;")
    public Node2 node;

    @OriginalMember(owner = "client!gga", name = "c", descriptor = "J")
    public long aLong115;

    @OriginalMember(owner = "client!gga", name = "d", descriptor = "[Lclient!cm;")
    public final Node2[] nodes;

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!gga", name = "<init>", descriptor = "(I)V")
    public Class144(@OriginalArg(0) int capacity) {
        this.nodes = new Node2[capacity];
        this.capacity = capacity;

        for (@Pc(10) int i = 0; i < capacity; i++) {
            @Pc(20) Node2 node = this.nodes[i] = new Node2();
            node.prev2 = node;
            node.next2 = node;
        }
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(BLclient!cm;J)V")
    public void method3094(@OriginalArg(1) Node2 arg0, @OriginalArg(2) long arg1) {
        if (arg0.prev2 != null) {
            arg0.unlink2();
        }
        @Pc(28) Node2 local28 = this.nodes[(int) ((long) (this.capacity - 1) & arg1)];
        arg0.next2 = local28;
        arg0.prev2 = local28.prev2;
        arg0.prev2.next2 = arg0;
        arg0.next2.prev2 = arg0;
        arg0.key2 = arg1;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(JI)Lclient!cm;")
    public Node2 method3095(@OriginalArg(0) long arg0) {
        this.aLong115 = arg0;
        @Pc(20) Node2 local20 = this.nodes[(int) (arg0 & (long) (this.capacity - 1))];
        for (this.node = local20.next2; this.node != local20; this.node = this.node.next2) {
            if (arg0 == this.node.key2) {
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
        @Pc(24) Node2 local24 = this.nodes[(int) (this.aLong115 & (long) (this.capacity - 1))];
        while (this.node != local24) {
            if (this.aLong115 == this.node.key2) {
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
