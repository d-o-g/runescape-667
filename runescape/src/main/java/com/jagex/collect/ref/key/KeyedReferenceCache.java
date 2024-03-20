package com.jagex.collect.ref.key;

import com.jagex.collect.LruCache;
import com.jagex.collect.HashTable;
import com.jagex.collect.Queue;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!aka")
public final class KeyedReferenceCache {

    @OriginalMember(owner = "client!aka", name = "c", descriptor = "Lclient!jga;")
    public final Queue history = new Queue();

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!aka", name = "i", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!aka", name = "b", descriptor = "Lclient!av;")
    public final HashTable table;

    @OriginalMember(owner = "client!aka", name = "<init>", descriptor = "(I)V")
    public KeyedReferenceCache(@OriginalArg(0) int size) {
        this.capacity = size;
        this.remaining = size;
        @Pc(16) int bucketCount;
        for (bucketCount = 1; size > (bucketCount + bucketCount); bucketCount += bucketCount) {
        }
        this.table = new HashTable(bucketCount);
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ILclient!uq;)V")
    public void removeByKey(@OriginalArg(1) CacheKey cacheKey) {
        @Pc(9) long key = cacheKey.toLong();

        for (@Pc(22) KeyedReferenceNode node = (KeyedReferenceNode) this.table.get(key); node != null; node = (KeyedReferenceNode) this.table.nextWithSameKey()) {
            if (node.cacheKey.matches(cacheKey)) {
                this.remove(node);
                return;
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Z)V")
    public void reset() {
        this.history.clear();
        this.table.clear();
        this.remaining = this.capacity;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(B)V")
    public void removeSoftReferences() {
        for (@Pc(5) KeyedReferenceNode node = (KeyedReferenceNode) this.history.first(); node != null; node = (KeyedReferenceNode) this.history.next()) {
            if (node.isSoft()) {
                node.unlink();
                node.unlink2();
                this.remaining += node.size;
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZLclient!pv;)V")
    public void remove(@OriginalArg(1) KeyedReferenceNode node) {
        if (node != null) {
            node.unlink();
            node.unlink2();
            this.remaining += node.size;
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZI)V")
    public void clean(@OriginalArg(0) int maxAge) {
        if (KeyedReferenceNodeFactory.INSTANCE == null) {
            return;
        }

        for (@Pc(11) KeyedReferenceNode node = (KeyedReferenceNode) this.history.first(); node != null; node = (KeyedReferenceNode) this.history.next()) {
            if (node.isSoft()) {
                if (node.get() == null) {
                    node.unlink();
                    node.unlink2();
                    this.remaining += node.size;
                }
            } else if (++node.key2 > (long) maxAge) {
                @Pc(38) KeyedReferenceNode newReference = KeyedReferenceNodeFactory.INSTANCE.create(node);
                this.table.put(node.key, newReference);
                LruCache.Node.attachAfter(node, newReference);
                node.unlink();
                node.unlink2();
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "b", descriptor = "(I)I")
    public int capacity() {
        return this.capacity;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(I)I")
    public int remaining() {
        return this.remaining;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZILjava/lang/Object;Lclient!uq;)V")
    public void put(@OriginalArg(2) Object value, @OriginalArg(3) CacheKey cacheKey, @OriginalArg(1) int size) {
        if (size > this.capacity) {
            throw new IllegalStateException("s>cs");
        }

        this.removeByKey(cacheKey);
        this.remaining--;

        while (this.remaining < 0) {
            @Pc(42) KeyedReferenceNode first = (KeyedReferenceNode) this.history.removeFirst();
            this.remove(first);
        }

        @Pc(59) KeyedHardReferenceNode node = new KeyedHardReferenceNode(cacheKey, value, 1);
        this.table.put(cacheKey.toLong(), node);
        this.history.add(node);
        node.key2 = 0L;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Lclient!uq;B)Ljava/lang/Object;")
    public Object get(@OriginalArg(0) CacheKey cacheKey) {
        @Pc(18) long hash = cacheKey.toLong();

        for (@Pc(25) KeyedReferenceNode node = (KeyedReferenceNode) this.table.get(hash); node != null; node = (KeyedReferenceNode) this.table.nextWithSameKey()) {
            if (node.cacheKey.matches(cacheKey)) {
                @Pc(39) Object object = node.get();

                if (object != null) {
                    if (node.isSoft()) {
                        @Pc(84) KeyedHardReferenceNode hardReference = new KeyedHardReferenceNode(cacheKey, object, node.size);
                        this.table.put(node.key, hardReference);
                        this.history.add(hardReference);
                        hardReference.key2 = 0L;
                        node.unlink();
                        node.unlink2();
                    } else {
                        this.history.add(node);
                        node.key2 = 0L;
                    }

                    return object;
                } else {
                    node.unlink();
                    node.unlink2();
                    this.remaining += node.size;
                }
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Ljava/lang/Object;ILclient!uq;)V")
    public void put(@OriginalArg(0) Object object, @OriginalArg(2) CacheKey cacheKey) {
        this.put(object, cacheKey, 1);
    }
}
