package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class SystemTimer {

    @OriginalMember(owner = "client!in", name = "I", descriptor = "J")
    public static long lastTime;

    @OriginalMember(owner = "client!vea", name = "G", descriptor = "J")
    public static long timeOffset;

    @OriginalMember(owner = "client!sj", name = "a", descriptor = "(Z)J")
    public static synchronized long safetime() {
        @Pc(5) long now = System.currentTimeMillis();
        if (lastTime > now) {
            System.out.println("WARNING: safetime: time jumped back by " + (lastTime - now) + " ms");
            timeOffset += lastTime - now;
        }
        lastTime = now;
        return now + timeOffset;
    }

    private SystemTimer() {
        /* empty */
    }
}
