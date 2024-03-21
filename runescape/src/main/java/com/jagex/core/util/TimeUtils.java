package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class TimeUtils {

    @OriginalMember(owner = "client!kj", name = "d", descriptor = "I")
    public static int clock = 0;

    @OriginalMember(owner = "client!uca", name = "a", descriptor = "(JZ)V")
    public static void sleep(@OriginalArg(0) long milliseconds) {
        if (milliseconds <= 0L) {
            return;
        }

        if (milliseconds % 10L == 0L) {
            sleepUninterruptibly(milliseconds - 1L);
            sleepUninterruptibly(1L);
        } else {
            sleepUninterruptibly(milliseconds);
        }
    }

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(JB)V")
    public static void sleepUninterruptibly(@OriginalArg(0) long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (@Pc(12) InterruptedException ignored) {
            /* empty */
        }
    }

    private TimeUtils() {
        /* empty */
    }
}
