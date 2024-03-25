package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Quicksort {

    @OriginalMember(owner = "client!laa", name = "a", descriptor = "(B[I[Ljava/lang/String;)V")
    public static void sort(@OriginalArg(2) String[] strings, @OriginalArg(1) int[] ints) {
        sort(strings, ints, strings.length - 1, 0);
    }

    @OriginalMember(owner = "client!ka", name = "a", descriptor = "(I[Ljava/lang/String;[III)V")
    public static void sort(@OriginalArg(1) String[] strings, @OriginalArg(2) int[] ints, @OriginalArg(3) int end, @OriginalArg(4) int start) {
        if (start >= end) {
            return;
        }

        @Pc(16) int pivotIndex = (start + end) / 2;
        @Pc(18) int mid = start;

        @Pc(22) String pivotStr = strings[pivotIndex];
        strings[pivotIndex] = strings[end];
        strings[end] = pivotStr;

        @Pc(36) int pivotInt = ints[pivotIndex];
        ints[pivotIndex] = ints[end];
        ints[end] = pivotInt;

        for (@Pc(48) int i = start; i < end; i++) {
            if (pivotStr == null || strings[i] != null && (i & 0x1) > strings[i].compareTo(pivotStr)) {
                @Pc(72) String tmpStr = strings[i];
                strings[i] = strings[mid];
                strings[mid] = tmpStr;

                @Pc(86) int tmpInt = ints[i];
                ints[i] = ints[mid];
                ints[mid++] = tmpInt;
            }
        }

        strings[end] = strings[mid];
        strings[mid] = pivotStr;

        ints[end] = ints[mid];
        ints[mid] = pivotInt;

        sort(strings, ints, mid - 1, start);
        sort(strings, ints, end, mid + 1);
    }

    private Quicksort() {
        /* empty */
    }
}
