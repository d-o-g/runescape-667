package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ts")
public final class LruCache {

    @OriginalMember(owner = "client!ts", name = "j", descriptor = "Lclient!cm;")
    public Node pointer = new Node();

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "Lclient!jga;")
    public final Queue history = new Queue();

    @OriginalMember(owner = "client!ts", name = "h", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!ts", name = "g", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!ts", name = "c", descriptor = "Lclient!av;")
    public final HashTable table;

    @OriginalMember(owner = "client!ts", name = "<init>", descriptor = "(I)V")
    public LruCache(@OriginalArg(0) int capacity) {
        this.remaining = capacity;
        this.capacity = capacity;
        @Pc(19) int bucketCount;
        for (bucketCount = 1; bucketCount + bucketCount < capacity; bucketCount += bucketCount) {
        }
        this.table = new HashTable(bucketCount);
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(BLclient!cm;J)V")
    public void put(@OriginalArg(1) Node node, @OriginalArg(2) long key) {
        if (this.remaining == 0) {
            @Pc(19) Node first = this.history.removeFirst();
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
    public Node get(@OriginalArg(0) long key) {
        @Pc(16) Node node = (Node) this.table.get(key);
        if (node != null) {
            this.history.add(node);
        }
        return node;
    }

    @OriginalMember(owner = "client!ts", name = "a", descriptor = "(IJ)V")
    public void remove(@OriginalArg(1) long key) {
        @Pc(18) Node node = (Node) this.table.get(key);
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
        this.pointer = new Node();
        this.remaining = this.capacity;
    }

    @OriginalClass("client!cm")
    public static class Node extends Deque.Node {

        @OriginalMember(owner = "client!mt", name = "a", descriptor = "(ILclient!cm;Lclient!cm;)V")
        public static void attachAfter(@OriginalArg(1) Node back, @OriginalArg(2) Node front) {
            if (front.prev2 != null) {
                front.unlink2();
            }
            front.next2 = back.next2;
            front.prev2 = back;
            front.prev2.next2 = front;
            front.next2.prev2 = front;
        }

        @OriginalMember(owner = "client!cm", name = "l", descriptor = "Lclient!cm;")
        public Node next2;

        @OriginalMember(owner = "client!cm", name = "s", descriptor = "Lclient!cm;")
        public Node prev2;

        @OriginalMember(owner = "client!cm", name = "m", descriptor = "J")
        public long key2;

        @OriginalMember(owner = "client!cm", name = "c", descriptor = "(I)V")
        public final void unlink2() {
            if (this.prev2 != null) {
                this.prev2.next2 = this.next2;
                this.next2.prev2 = this.prev2;
                this.next2 = null;
                this.prev2 = null;
            }
        }

        @OriginalMember(owner = "client!cm", name = "b", descriptor = "(B)Z")
        public final boolean isLinked2() {
            return this.prev2 != null;
        }
    }
}
