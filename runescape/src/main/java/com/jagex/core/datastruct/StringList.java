package com.jagex.core.datastruct;

import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wca")
public final class StringList {

    @OriginalMember(owner = "client!uda", name = "i", descriptor = "(I)Lclient!wca;")
    public static StringList createLinear() {
        return createLinear(1);
    }

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(IB)Lclient!wca;")
    public static StringList createLinear(@OriginalArg(0) int growthFactor) {
        return new StringList(growthFactor, false);
    }

    @OriginalMember(owner = "client!wca", name = "b", descriptor = "[Ljava/lang/String;")
    public String[] elements = new String[0];

    @OriginalMember(owner = "client!wca", name = "i", descriptor = "I")
    public int last = -1;

    @OriginalMember(owner = "client!wca", name = "o", descriptor = "Z")
    public boolean exponential = false;

    @OriginalMember(owner = "client!wca", name = "m", descriptor = "I")
    public final int growthFactor;

    @OriginalMember(owner = "client!wca", name = "<init>", descriptor = "(IZ)V")
    public StringList(@OriginalArg(0) int growthFactor, @OriginalArg(1) boolean exponential) {
        this.growthFactor = growthFactor;
        this.exponential = exponential;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(Ljava/lang/String;B)V")
    public void add(@OriginalArg(0) String string) {
        this.set(this.last + 1, string);
    }

    @OriginalMember(owner = "client!wca", name = "toString", descriptor = "()Ljava/lang/String;")
    @Override
    public String toString() {
        @Pc(9) StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (@Pc(15) int i = 0; i < this.last; i++) {
            if (i != 0) {
                buffer.append(", ");
            }
            buffer.append(this.elements[i]);
        }
        buffer.append("]");
        return buffer.toString();
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(I)[Ljava/lang/String;")
    public String[] toArray() {
        @Pc(16) String[] array = new String[this.last + 1];
        Arrays.copy(this.elements, 0, array, 0, this.last + 1);
        return array;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(II)I")
    public int nextSize(@OriginalArg(0) int count) {
        @Pc(16) int currentCount = this.elements.length;
        while (currentCount <= count) {
            if (!this.exponential) {
                currentCount += this.growthFactor;
            } else if (currentCount == 0) {
                currentCount = 1;
            } else {
                currentCount *= this.growthFactor;
            }
        }
        return currentCount;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(IB)V")
    public void expand(@OriginalArg(0) int arg0) {
        @Pc(9) String[] elements = new String[this.nextSize(arg0)];
        Arrays.copy(this.elements, 0, elements, 0, this.elements.length);
        this.elements = elements;
    }

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(BILjava/lang/String;)V")
    public void set(@OriginalArg(1) int index, @OriginalArg(2) String element) {
        if (index > this.last) {
            this.last = index;
        }
        if (index >= this.elements.length) {
            this.expand(index);
        }
        this.elements[index] = element;
    }
}
