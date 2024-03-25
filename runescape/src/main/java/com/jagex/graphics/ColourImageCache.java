package com.jagex.graphics;

import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ug")
public final class ColourImageCache {

    @OriginalMember(owner = "client!ug", name = "j", descriptor = "I")
    public int cachedId = -1;

    @OriginalMember(owner = "client!ug", name = "c", descriptor = "I")
    public int count = 0;

    @OriginalMember(owner = "client!ug", name = "f", descriptor = "Lclient!sia;")
    public Deque history = new Deque();

    @OriginalMember(owner = "client!ug", name = "k", descriptor = "Z")
    public boolean dirty = false;

    @OriginalMember(owner = "client!ug", name = "b", descriptor = "I")
    public final int capacity;

    @OriginalMember(owner = "client!ug", name = "h", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!ug", name = "g", descriptor = "[Lclient!iia;")
    public ColourImageCacheSlot[] slots;

    @OriginalMember(owner = "client!ug", name = "l", descriptor = "[[[I")
    public int[][][] output;

    @OriginalMember(owner = "client!ug", name = "<init>", descriptor = "(III)V")
    public ColourImageCache(@OriginalArg(0) int capacity, @OriginalArg(1) int height, @OriginalArg(2) int width) {
        this.capacity = capacity;
        this.height = height;
        this.slots = new ColourImageCacheSlot[this.height];
        this.output = new int[this.capacity][3][width];
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(Z)V")
    public void reset() {
        for (@Pc(15) int i = 0; i < this.capacity; i++) {
            this.output[i][0] = null;
            this.output[i][1] = null;
            this.output[i][2] = null;
            this.output[i] = null;
        }

        this.output = null;
        this.slots = null;
        this.history.clear();
        this.history = null;
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(II)[[I")
    public int[][] get(@OriginalArg(0) int index) {
        if (this.capacity == this.height) {
            this.dirty = this.slots[index] == null;
            this.slots[index] = ColourImageCacheSlot.USED;
            return this.output[index];
        } else if (this.capacity == 1) {
            this.dirty = this.cachedId != index;
            this.cachedId = index;
            return this.output[0];
        } else {
            @Pc(78) ColourImageCacheSlot slot = this.slots[index];

            if (slot != null) {
                this.dirty = false;
            } else {
                this.dirty = true;

                if (this.count < this.capacity) {
                    slot = new ColourImageCacheSlot(index, this.count);
                    this.count++;
                } else {
                    @Pc(111) ColourImageCacheSlot last = (ColourImageCacheSlot) this.history.last();
                    slot = new ColourImageCacheSlot(index, last.slot);
                    this.slots[last.id] = null;
                    last.unlink();
                }

                this.slots[index] = slot;
            }

            this.history.addFirst(slot);
            return this.output[slot.slot];
        }
    }

    @OriginalMember(owner = "client!ug", name = "a", descriptor = "(I)[[[I")
    public int[][][] get() {
        if (this.height != this.capacity) {
            throw new RuntimeException("Can only retrieve a full image cache");
        }
        for (@Pc(20) int i = 0; i < this.capacity; i++) {
            this.slots[i] = ColourImageCacheSlot.USED;
        }
        return this.output;
    }
}
