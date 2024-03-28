package com.jagex.core.util;

import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nl")
public abstract class TickScheduler {

    @OriginalMember(owner = "client!rv", name = "c", descriptor = "(I)Lclient!nl;")
    public static TickScheduler create() {
        try {
            return new NativeTickScheduler();
        } catch (@Pc(8) Throwable ignored) {
            try {
                return (TickScheduler) Class.forName("com.jagex.core.util.NanoTickScheduler").getDeclaredConstructor().newInstance();
            } catch (@Pc(16) Throwable local16) {
                return new DefaultTickScheduler();
            }
        }
    }

    @OriginalMember(owner = "client!nl", name = "a", descriptor = "(BJ)I")
    protected abstract int schedule(@OriginalArg(1) long arg0);

    @OriginalMember(owner = "client!nl", name = "a", descriptor = "(I)V")
    public abstract void reset();

    @OriginalMember(owner = "client!nl", name = "a", descriptor = "(JI)I")
    public final int scheduleDelayed(@OriginalArg(0) long arg0) {
        @Pc(13) long delay = this.getDelay();
        if (delay > 0L) {
            TimeUtils.sleep(delay);
        }
        return this.schedule(arg0);
    }

    @OriginalMember(owner = "client!nl", name = "b", descriptor = "(B)J")
    protected abstract long getDelay();

    @OriginalMember(owner = "client!nl", name = "b", descriptor = "(I)J")
    public abstract long getTickTime();
}
