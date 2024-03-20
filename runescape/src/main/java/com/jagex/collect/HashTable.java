package com.jagex.collect;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!av")
public final class HashTable {

    @OriginalMember(owner = "client!av", name = "c", descriptor = "Lclient!ie;")
    public Deque.Node searchPointer;

    @OriginalMember(owner = "client!av", name = "a", descriptor = "J")
    public long searchKey;

    @OriginalMember(owner = "client!av", name = "d", descriptor = "Lclient!ie;")
    public Deque.Node iteratorPointer;

    @OriginalMember(owner = "client!av", name = "h", descriptor = "I")
    public int iteratorPosition = 0;

    @OriginalMember(owner = "client!av", name = "q", descriptor = "I")
    public final int bucketCount;

    @OriginalMember(owner = "client!av", name = "e", descriptor = "[Lclient!ie;")
    public final Deque.Node[] buckets;

    @OriginalMember(owner = "client!av", name = "<init>", descriptor = "(I)V")
    public HashTable(@OriginalArg(0) int bucketCount) {
        this.bucketCount = bucketCount;
        this.buckets = new Deque.Node[bucketCount];
        for (@Pc(13) int i = 0; i < bucketCount; i++) {
            @Pc(23) Deque.Node node = this.buckets[i] = new Deque.Node();
            node.next = node;
            node.prev = node;
        }
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(JLclient!ie;I)V")
    public void put(@OriginalArg(0) long key, @OriginalArg(1) Deque.Node node) {
        if (node.prev != null) {
            node.remove();
        }
        @Pc(28) Deque.Node tail = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
        node.next = tail;
        node.prev = tail.prev;
        node.prev.next = node;
        node.next.prev = node;
        node.key = key;
    }

    @OriginalMember(owner = "client!av", name = "b", descriptor = "(Z)Lclient!ie;")
    public Deque.Node first() {
        this.iteratorPosition = 0;
        return this.next();
    }

    @OriginalMember(owner = "client!av", name = "c", descriptor = "(Z)V")
    public void clear() {
        for (@Pc(6) int i = 0; i < this.bucketCount; i++) {
            @Pc(12) Deque.Node tail = this.buckets[i];
            while (true) {
                @Pc(15) Deque.Node current = tail.next;
                if (current == tail) {
                    break;
                }
                current.remove();
            }
        }
        this.searchPointer = null;
        this.iteratorPointer = null;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(IJ)Lclient!ie;")
    public Deque.Node get(@OriginalArg(1) long key) {
        this.searchKey = key;
        @Pc(25) Deque.Node tail = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
        for (this.searchPointer = tail.next; this.searchPointer != tail; this.searchPointer = this.searchPointer.next) {
            if (key == this.searchPointer.key) {
                @Pc(43) Deque.Node result = this.searchPointer;
                this.searchPointer = this.searchPointer.next;
                return result;
            }
        }
        this.searchPointer = null;
        return null;
    }

    @OriginalMember(owner = "client!av", name = "c", descriptor = "(B)I")
    public int size() {
        @Pc(5) int n = 0;
        for (@Pc(13) int i = 0; i < this.bucketCount; i++) {
            @Pc(19) Deque.Node tail = this.buckets[i];
            @Pc(22) Deque.Node current = tail.next;
            while (current != tail) {
                current = current.next;
                n++;
            }
        }
        return n;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(I)Lclient!ie;")
    public Deque.Node next() {
        @Pc(32) Deque.Node node;
        if (this.iteratorPosition > 0 && this.iteratorPointer != this.buckets[this.iteratorPosition - 1]) {
            node = this.iteratorPointer;
            this.iteratorPointer = node.next;
            return node;
        }
        while (this.bucketCount > this.iteratorPosition) {
            node = this.buckets[this.iteratorPosition++].next;
            if (this.buckets[this.iteratorPosition - 1] != node) {
                this.iteratorPointer = node.next;
                return node;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(Z)I")
    public int getBucketCount() {
        return this.bucketCount;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(B[Lclient!ie;)I")
    public int flatten(@OriginalArg(1) Deque.Node[] nodes) {
        @Pc(5) int n = 0;
        for (@Pc(16) int i = 0; i < this.bucketCount; i++) {
            @Pc(22) Deque.Node tail = this.buckets[i];
            for (@Pc(25) Deque.Node current = tail.next; current != tail; current = current.next) {
                nodes[n++] = current;
            }
        }
        return n;
    }

    @OriginalMember(owner = "client!av", name = "a", descriptor = "(B)Lclient!ie;")
    public Deque.Node nextWithSameKey() {
        if (this.searchPointer == null) {
            return null;
        }
        @Pc(28) Deque.Node node = this.buckets[(int) (this.searchKey & (long) (this.bucketCount - 1))];
        while (this.searchPointer != node) {
            if (this.searchPointer.key == this.searchKey) {
                @Pc(43) Deque.Node current = this.searchPointer;
                this.searchPointer = this.searchPointer.next;
                return current;
            }
            this.searchPointer = this.searchPointer.next;
        }
        this.searchPointer = null;
        return null;
    }
}
