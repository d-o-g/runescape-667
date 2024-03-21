package com.jagex.collect.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sba")
public final class Class331 {

    @OriginalMember(owner = "client!sba", name = "i", descriptor = "Lclient!av;")
    public HashTable table;

    @OriginalMember(owner = "client!sba", name = "j", descriptor = "Lclient!ie;")
    public Node aNode_266;

    @OriginalMember(owner = "client!sba", name = "k", descriptor = "I")
    public int anInt8579 = 0;

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "()V")
    public Class331() {
    }

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "(Lclient!av;)V")
    public Class331(@OriginalArg(0) HashTable table) {
        this.table = table;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(I)Lclient!ie;")
    public Node next() {
        @Pc(23) Node node;
        if (this.anInt8579 > 0 && this.table.buckets[this.anInt8579 - 1] != this.aNode_266) {
            node = this.aNode_266;
            this.aNode_266 = node.next;
            return node;
        }
        while (this.table.bucketCount > this.anInt8579) {
            node = this.table.buckets[this.anInt8579++].next;
            if (this.table.buckets[this.anInt8579 - 1] != node) {
                this.aNode_266 = node.next;
                return node;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(Z)Lclient!ie;")
    public Node first() {
        this.anInt8579 = 0;
        return this.next();
    }
}
