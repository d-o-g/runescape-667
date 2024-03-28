package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!di")
public final class NanoTickScheduler extends TickScheduler {

    @OriginalMember(owner = "client!di", name = "i", descriptor = "J")
    public long aLong81 = 0L;

    @OriginalMember(owner = "client!di", name = "k", descriptor = "J")
    public long tickTime = 0L;

    @OriginalMember(owner = "client!di", name = "l", descriptor = "J")
    public long lastTick = 0L;

    @OriginalMember(owner = "client!di", name = "g", descriptor = "[J")
    public final long[] aLongArray2 = new long[10];

    @OriginalMember(owner = "client!di", name = "j", descriptor = "I")
    public int anInt2211 = 0;

    @OriginalMember(owner = "client!di", name = "h", descriptor = "I")
    public int anInt2210 = 1;

    @OriginalMember(owner = "client!di", name = "<init>", descriptor = "()V")
    public NanoTickScheduler() {
        this.tickTime = System.nanoTime();
        this.aLong81 = System.nanoTime();
    }

    @OriginalMember(owner = "client!di", name = "a", descriptor = "(BJ)I")
    @Override
    protected int schedule(@OriginalArg(1) long arg0) {
        if (this.aLong81 > this.tickTime) {
            this.lastTick += this.aLong81 - this.tickTime;
            this.tickTime += this.aLong81 - this.tickTime;
            this.aLong81 += arg0;
            return 1;
        }
        @Pc(12) int local12 = 0;
        do {
            this.aLong81 += arg0;
            local12++;
        } while (local12 < 10 && this.tickTime > this.aLong81);
        if (this.aLong81 < this.tickTime) {
            this.aLong81 = this.tickTime;
        }
        return local12;
    }

    @OriginalMember(owner = "client!di", name = "b", descriptor = "(B)J")
    @Override
    protected long getDelay() {
        this.tickTime += this.method2092();
        return this.tickTime < this.aLong81 ? (this.aLong81 - this.tickTime) / 1000000L : 0L;
    }

    @OriginalMember(owner = "client!di", name = "b", descriptor = "(I)J")
    @Override
    public long getTickTime() {
        return this.tickTime;
    }

    @OriginalMember(owner = "client!di", name = "c", descriptor = "(B)J")
    public long method2092() {
        @Pc(1) long now = System.nanoTime();
        @Pc(7) long elapsed = now - this.lastTick;
        this.lastTick = now;
        if (elapsed > -5000000000L && elapsed < 5000000000L) {
            this.aLongArray2[this.anInt2211] = elapsed;
            this.anInt2211 = (this.anInt2211 + 1) % 10;
            if (this.anInt2210 < 1) {
                this.anInt2210++;
            }
        }
        @Pc(54) long local54 = 0L;
        for (@Pc(56) int local56 = 1; local56 <= this.anInt2210; local56++) {
            local54 += this.aLongArray2[(this.anInt2211 + 10 - local56) % 10];
        }
        return local54 / (long) this.anInt2210;
    }

    @OriginalMember(owner = "client!di", name = "a", descriptor = "(I)V")
    @Override
    public void reset() {
        if (this.aLong81 > this.tickTime) {
            this.tickTime += this.aLong81 - this.tickTime;
        }
        this.lastTick = 0L;
    }
}
