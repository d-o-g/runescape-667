package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gga")
public final class HashTable {

    @OriginalMember(owner = "client!gga", name = "h", descriptor = "Lclient!cm;")
    public Node2 searchPointer;

    @OriginalMember(owner = "client!gga", name = "c", descriptor = "J")
    public long searchKey;

    @OriginalMember(owner = "client!gga", name = "d", descriptor = "[Lclient!cm;")
    public final Node2[] buckets;

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "I")
    public final int bucketCount;

    @OriginalMember(owner = "client!gga", name = "<init>", descriptor = "(I)V")
    public HashTable(@OriginalArg(0) int bucketCount) {
        this.buckets = new Node2[bucketCount];
        this.bucketCount = bucketCount;

        for (@Pc(10) int i = 0; i < bucketCount; i++) {
            @Pc(20) Node2 node = this.buckets[i] = new Node2();
            node.prev2 = node;
            node.next2 = node;
        }
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(BLclient!cm;J)V")
    public void put(@OriginalArg(1) Node2 node, @OriginalArg(2) long key) {
        if (node.prev2 != null) {
            node.unlink2();
        }

        @Pc(28) Node2 bucket = this.buckets[(int) ((long) (this.bucketCount - 1) & key)];
        node.next2 = bucket;
        node.prev2 = bucket.prev2;
        node.prev2.next2 = node;
        node.next2.prev2 = node;
        node.key2 = key;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(JI)Lclient!cm;")
    public Node2 get(@OriginalArg(0) long key) {
        this.searchKey = key;
        @Pc(20) Node2 bucket = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
        for (this.searchPointer = bucket.next2; this.searchPointer != bucket; this.searchPointer = this.searchPointer.next2) {
            if (key == this.searchPointer.key2) {
                @Pc(41) Node2 node = this.searchPointer;
                this.searchPointer = this.searchPointer.next2;
                return node;
            }
        }
        this.searchPointer = null;
        return null;
    }

    @OriginalMember(owner = "client!gga", name = "a", descriptor = "(I)Lclient!cm;")
    public Node2 nextWithSameKey() {
        if (this.searchPointer == null) {
            return null;
        }

        @Pc(24) Node2 bucket = this.buckets[(int) (this.searchKey & (long) (this.bucketCount - 1))];
        while (this.searchPointer != bucket) {
            if (this.searchKey == this.searchPointer.key2) {
                @Pc(38) Node2 node = this.searchPointer;
                this.searchPointer = this.searchPointer.next2;
                return node;
            }

            this.searchPointer = this.searchPointer.next2;
        }

        this.searchPointer = null;
        return null;
    }
}
