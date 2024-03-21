package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ts")
public final class LruCache {

    @OriginalMember(owner = "client!ts", name = "j", descriptor = "Lclient!cm;")
    public Node2 pointer = new Node2();

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "Lclient!jga;")
    public final Queue history = new Queue();

    @OriginalMember(owner = "client!ts", name = "h", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!ts", name = "g", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!ts", name = "c", descriptor = "Lclient!av;")
    public final IterableHashTable table;

    @OriginalMember(owner = "client!ts", name = "<init>", descriptor = "(I)V")
    public LruCache(@OriginalArg(0) int capacity) {
        this.remaining = capacity;
        this.capacity = capacity;
        @Pc(19) int bucketCount;
        for (bucketCount = 1; bucketCount + bucketCount < capacity; bucketCount += bucketCount) {
        }
        this.table = new IterableHashTable(bucketCount);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(BLclient!cm;J)V")
    public void put(@OriginalArg(1) Node2 node, @OriginalArg(2) long key) {
        if (this.remaining == 0) {
            @Pc(19) Node2 first = this.history.removeFirst();
            first.unlink();
            first.unlink2();

            if (this.pointer == first) {
                first = this.history.removeFirst();
                first.unlink();
                first.unlink2();
            }
        } else {
            this.remaining--;
        }

        this.table.put(key, node);
        this.history.add(node);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(JZ)Lclient!cm;")
    public Node2 get(@OriginalArg(0) long key) {
        @Pc(16) Node2 node = (Node2) this.table.get(key);
        if (node != null) {
            this.history.add(node);
        }
        return node;
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(IJ)V")
    public void remove(@OriginalArg(1) long key) {
        @Pc(18) Node2 node = (Node2) this.table.get(key);
        if (node != null) {
            node.unlink();
            node.unlink2();
            this.remaining++;
        }
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(B)V")
    public void clear() {
        this.history.clear();
        this.table.clear();
        this.pointer = new Node2();
        this.remaining = this.capacity;
    }
}
