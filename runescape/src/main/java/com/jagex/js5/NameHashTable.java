package com.jagex.js5;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!eha")
public final class NameHashTable {

    @OriginalMember(owner = "client!eha", name = "b", descriptor = "[I")
    public final int[] table;

    @OriginalMember(owner = "client!eha", name = "<init>", descriptor = "([I)V")
    public NameHashTable(@OriginalArg(0) int[] names) {
        @Pc(5) int size;
        for (size = 1; size <= names.length + (names.length >> 1); size <<= 0x1) {
        }

        this.table = new int[size + size];
        for (@Pc(34) int i = 0; i < size + size; i++) {
            this.table[i] = -1;
        }

        @Pc(52) int i = 0;
        while (i < names.length) {
            @Pc(64) int pos;
            for (pos = size - 1 & names[i]; this.table[pos + pos + 1] != -1; pos = size - 1 & pos + 1) {
            }
            this.table[pos + pos] = names[i];
            this.table[pos + pos + 1] = i++;
        }
    }

    @OriginalMember(owner = "client!eha", name = "a", descriptor = "(II)I")
    public int find(@OriginalArg(1) int name) {
        @Pc(11) int size = (this.table.length >> 1) - 1;
        @Pc(15) int position = size & name;

        while (true) {
            @Pc(25) int index = this.table[position + position + 1];
            if (index == -1) {
                return -1;
            }

            if (name == this.table[position + position]) {
                return index;
            }

            position = size & position + 1;
        }
    }
}
