package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sba")
public final class HashTableIterator {

    @OriginalMember(owner = "client!sba", name = "i", descriptor = "Lclient!av;")
    public IterableHashTable table;

    @OriginalMember(owner = "client!sba", name = "j", descriptor = "Lclient!ie;")
    public Node pointer;

    @OriginalMember(owner = "client!sba", name = "k", descriptor = "I")
    public int bucket = 0;

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "()V")
    public HashTableIterator() {
        /* empty */
    }

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "(Lclient!av;)V")
    public HashTableIterator(@OriginalArg(0) IterableHashTable table) {
        this.table = table;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(I)Lclient!ie;")
    public Node next() {
        if (this.bucket > 0 && this.table.buckets[this.bucket - 1] != this.pointer) {
            @Pc(23) Node node = this.pointer;
            this.pointer = node.next;
            return node;
        }

        while (this.table.bucketCount > this.bucket) {
            @Pc(23) Node node = this.table.buckets[this.bucket++].next;

            if (this.table.buckets[this.bucket - 1] != node) {
                this.pointer = node.next;
                return node;
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(Z)Lclient!ie;")
    public Node first() {
        this.bucket = 0;
        return this.next();
    }
}
