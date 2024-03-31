package com.jagex.core.algorithms;

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
                @Pc(72) String tempString = strings[i];
                strings[i] = strings[mid];
                strings[mid] = tempString;

                @Pc(86) int tempInt = ints[i];
                ints[i] = ints[mid];
                ints[mid++] = tempInt;
            }
        }

        strings[end] = strings[mid];
        strings[mid] = pivotStr;

        ints[end] = ints[mid];
        ints[mid] = pivotInt;

        sort(strings, ints, mid - 1, start);
        sort(strings, ints, end, mid + 1);
    }

    @OriginalMember(owner = "client!qaa", name = "a", descriptor = "([Ljava/lang/Object;[IB)V")
    public static void sort(@OriginalArg(1) int[] ints, @OriginalArg(0) Object[] objects) {
        sort(ints, objects, 0, ints.length - 1);
    }

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(II[I[Ljava/lang/Object;Z)V")
    public static void sort(@OriginalArg(2) int[] ints, @OriginalArg(3) Object[] objects, @OriginalArg(1) int start, @OriginalArg(0) int end) {
        if (start >= end) {
            return;
        }

        @Pc(16) int pivotIndex = (start + end) / 2;
        @Pc(18) int mid = start;

        @Pc(22) int pivotInt = ints[pivotIndex];
        ints[pivotIndex] = ints[end];
        ints[end] = pivotInt;

        @Pc(36) Object pivotObj = objects[pivotIndex];
        objects[pivotIndex] = objects[end];
        objects[end] = pivotObj;

        @Pc(56) int mask = ~pivotInt == Integer.MIN_VALUE ? 0 : 1;
        for (@Pc(58) int i = start; i < end; i++) {
            if (pivotInt + (i & mask) > ints[i]) {
                @Pc(72) int tmpInt = ints[i];
                ints[i] = ints[mid];
                ints[mid] = tmpInt;

                @Pc(86) Object tmpObject = objects[i];
                objects[i] = objects[mid];
                objects[mid++] = tmpObject;
            }
        }

        ints[end] = ints[mid];
        ints[mid] = pivotInt;

        objects[end] = objects[mid];
        objects[mid] = pivotObj;

        sort(ints, objects, start, mid - 1);
        sort(ints, objects, mid + 1, end);
    }

    private Quicksort() {
        /* empty */
    }
}
