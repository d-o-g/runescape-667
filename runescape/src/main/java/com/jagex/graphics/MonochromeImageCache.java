package com.jagex.graphics;

import com.jagex.core.datastruct.key.Deque;
import com.jagex.graphics.MonochromeImageCacheSlot;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ija")
public final class MonochromeImageCache {

    @OriginalMember(owner = "client!ija", name = "h", descriptor = "I")
    public int cachedId = -1;

    @OriginalMember(owner = "client!ija", name = "t", descriptor = "I")
    public int count = 0;

    @OriginalMember(owner = "client!ija", name = "c", descriptor = "Lclient!sia;")
    public Deque history = new Deque();

    @OriginalMember(owner = "client!ija", name = "o", descriptor = "Z")
    public boolean dirty = false;

    @OriginalMember(owner = "client!ija", name = "f", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!ija", name = "p", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "[Lclient!v;")
    public MonochromeImageCacheSlot[] slots;

    @OriginalMember(owner = "client!ija", name = "b", descriptor = "[[I")
    public int[][] output;

    @OriginalMember(owner = "client!ija", name = "<init>", descriptor = "(III)V")
    public MonochromeImageCache(@OriginalArg(0) int capacity, @OriginalArg(1) int height, @OriginalArg(2) int width) {
        this.capacity = capacity;
        this.height = height;
        this.slots = new MonochromeImageCacheSlot[this.height];
        this.output = new int[this.capacity][width];
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(B)[[I")
    public int[][] get() {
        if (this.capacity != this.height) {
            throw new RuntimeException("Can only retrieve a full image cache");
        }
        for (@Pc(32) int i = 0; i < this.capacity; i++) {
            this.slots[i] = MonochromeImageCacheSlot.USED;
        }
        return this.output;
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(I)V")
    public void reset() {
        for (@Pc(3) int i = 0; i < this.capacity; i++) {
            this.output[i] = null;
        }

        this.slots = null;
        this.output = null;
        this.history.clear();
        this.history = null;
    }

    @OriginalMember(owner = "client!ija", name = "a", descriptor = "(II)[I")
    public int[] get(@OriginalArg(1) int index) {
        if (this.capacity == this.height) {
            this.dirty = this.slots[index] == null;
            this.slots[index] = MonochromeImageCacheSlot.USED;
            return this.output[index];
        } else if (this.capacity == 1) {
            this.dirty = this.cachedId != index;
            this.cachedId = index;
            return this.output[0];
        } else {
            @Pc(34) MonochromeImageCacheSlot slot = this.slots[index];

            if (slot != null) {
                this.dirty = false;
            } else {
                this.dirty = true;

                if (this.count < this.capacity) {
                    slot = new MonochromeImageCacheSlot(index, this.count);
                    this.count++;
                } else {
                    @Pc(59) MonochromeImageCacheSlot last = (MonochromeImageCacheSlot) this.history.last();
                    slot = new MonochromeImageCacheSlot(index, last.slot);
                    this.slots[last.id] = null;
                    last.unlink();
                }

                this.slots[index] = slot;
            }

            this.history.addFirst(slot);
            return this.output[slot.slot];
        }
    }
}
