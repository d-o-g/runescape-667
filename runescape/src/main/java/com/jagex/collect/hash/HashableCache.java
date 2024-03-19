package com.jagex.collect.hash;

import com.jagex.collect.DoublyLinkedNode;
import com.jagex.collect.HashTable;
import com.jagex.collect.Queue;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!aka")
public final class HashableCache {

    @OriginalMember(owner = "client!aka", name = "c", descriptor = "Lclient!jga;")
    public final Queue history = new Queue();

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!aka", name = "i", descriptor = "I")
    public int remaining;

    @OriginalMember(owner = "client!aka", name = "b", descriptor = "Lclient!av;")
    public final HashTable table;

    @OriginalMember(owner = "client!aka", name = "<init>", descriptor = "(I)V")
    public HashableCache(@OriginalArg(0) int size) {
        this.capacity = size;
        this.remaining = size;
        @Pc(16) int tableSize;
        for (tableSize = 1; size > tableSize + tableSize; tableSize += tableSize) {
        }
        this.table = new HashTable(tableSize);
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ILclient!uq;)V")
    public void method251(@OriginalArg(1) Hashable hashable) {
        @Pc(9) long hash = hashable.hash();

        for (@Pc(22) HashableReference reference = (HashableReference) this.table.get(hash); reference != null; reference = (HashableReference) this.table.nextWithSameKey()) {
            if (reference.hashable.matches(hashable)) {
                this.remove(reference);
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
    public void method253() {
        for (@Pc(5) HashableReference local5 = (HashableReference) this.history.first(); local5 != null; local5 = (HashableReference) this.history.next()) {
            if (local5.isSoft()) {
                local5.remove();
                local5.remove2();
                this.remaining += local5.size;
            }
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZLclient!pv;)V")
    public void remove(@OriginalArg(1) HashableReference reference) {
        if (reference != null) {
            reference.remove();
            reference.remove2();
            this.remaining += reference.size;
        }
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(ZI)V")
    public void clearSoft(@OriginalArg(0) int maxAge) {
        if (HashableReferenceFactory.instance == null) {
            return;
        }

        for (@Pc(11) HashableReference reference = (HashableReference) this.history.first(); reference != null; reference = (HashableReference) this.history.next()) {
            if (reference.isSoft()) {
                if (reference.get() == null) {
                    reference.remove();
                    reference.remove2();
                    this.remaining += reference.size;
                }
            } else if (++reference.key2 > (long) maxAge) {
                @Pc(38) HashableReference newReference = HashableReferenceFactory.instance.create(reference);
                this.table.put(reference.key, newReference);
                DoublyLinkedNode.attachAfter(reference, newReference);
                reference.remove();
                reference.remove2();
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
    public void put(@OriginalArg(2) Object value, @OriginalArg(3) Hashable hashable, @OriginalArg(1) int size) {
        if (size > this.capacity) {
            throw new IllegalStateException("s>cs");
        }

        this.method251(hashable);

        this.remaining--;
        while (this.remaining < 0) {
            @Pc(42) HashableReference first = (HashableReference) this.history.removeFirst();
            this.remove(first);
        }

        @Pc(59) HashableHardReference hardReference = new HashableHardReference(hashable, value, 1);
        this.table.put(hashable.hash(), hardReference);
        this.history.add(hardReference);
        hardReference.key2 = 0L;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Lclient!uq;B)Ljava/lang/Object;")
    public Object method260(@OriginalArg(0) Hashable hashable) {
        @Pc(18) long hash = hashable.hash();

        for (@Pc(25) HashableReference reference = (HashableReference) this.table.get(hash); reference != null; reference = (HashableReference) this.table.nextWithSameKey()) {
            if (reference.hashable.matches(hashable)) {
                @Pc(39) Object object = reference.get();

                if (object != null) {
                    if (reference.isSoft()) {
                        @Pc(84) HashableHardReference hardReference = new HashableHardReference(hashable, object, reference.size);
                        this.table.put(reference.key, hardReference);
                        this.history.add(hardReference);
                        hardReference.key2 = 0L;
                        reference.remove();
                        reference.remove2();
                    } else {
                        this.history.add(reference);
                        reference.key2 = 0L;
                    }

                    return object;
                } else {
                    reference.remove();
                    reference.remove2();
                    this.remaining += reference.size;
                }
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!aka", name = "a", descriptor = "(Ljava/lang/Object;ILclient!uq;)V")
    public void put(@OriginalArg(0) Object object, @OriginalArg(2) Hashable hashable) {
        this.put(object, hashable, 1);
    }
}
