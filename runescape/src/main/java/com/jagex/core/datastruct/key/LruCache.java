package com.jagex.core.datastruct.key;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ts")
public final class LruCache<T extends DoublyLinkedNode> {

    @OriginalMember(owner = "client!ts", name = "j", descriptor = "Lclient!cm;")
    public DoublyLinkedNode pointer = new DoublyLinkedNode();

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "Lclient!jga;")
    public final Queue<DoublyLinkedNode> history = new Queue<>();

    @OriginalMember(owner = "client!ts", name = "h", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!ts", name = "g", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!ts", name = "c", descriptor = "Lclient!av;")
    public final IterableHashTable<DoublyLinkedNode> table;

    @OriginalMember(owner = "client!ts", name = "<init>", descriptor = "(I)V")
    public LruCache(@OriginalArg(0) int capacity) {
        this.remaining = capacity;
        this.capacity = capacity;
        @Pc(19) int bucketCount = 1;
        while ((bucketCount + bucketCount) < capacity) {
            bucketCount += bucketCount;
        }
        this.table = new IterableHashTable<>(bucketCount);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(BLclient!cm;J)V")
    public void put(@OriginalArg(1) T node, @OriginalArg(2) long key) {
        if (this.remaining == 0) {
            @Pc(19) DoublyLinkedNode first = this.history.removeFirst();
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
    public T get(@OriginalArg(0) long key) {
        @Pc(16) DoublyLinkedNode node = this.table.get(key);
        if (node != null) {
            this.history.add(node);
        }
        return (T) node;
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(IJ)V")
    public void remove(@OriginalArg(1) long key) {
        @Pc(18) DoublyLinkedNode node = this.table.get(key);
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
        this.pointer = new DoublyLinkedNode();
        this.remaining = this.capacity;
    }
}
