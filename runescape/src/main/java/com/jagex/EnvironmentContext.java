package com.jagex;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!le")
public final class EnvironmentContext {

    @OriginalMember(owner = "client!le", name = "b", descriptor = "Z")
    public final boolean signed;

    @OriginalMember(owner = "client!le", name = "n", descriptor = "I")
    public final int cpuCount;

    @OriginalMember(owner = "client!le", name = "k", descriptor = "Z")
    public final boolean armCpu;

    @OriginalMember(owner = "client!le", name = "o", descriptor = "I")
    public final int heapSize;

    @OriginalMember(owner = "client!le", name = "<init>", descriptor = "(ZIIZ)V")
    public EnvironmentContext(@OriginalArg(0) boolean signed, @OriginalArg(1) int heapSize, @OriginalArg(2) int cpuCount, @OriginalArg(3) boolean armCpu) {
        this.signed = signed;
        this.cpuCount = cpuCount;
        this.armCpu = armCpu;
        this.heapSize = heapSize;
    }

    @OriginalMember(owner = "client!le", name = "d", descriptor = "(B)I")
    public int getHeapSize() {
        return this.heapSize;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(B)Z")
    public boolean isArmCpu() {
        return this.armCpu;
    }

    @OriginalMember(owner = "client!le", name = "c", descriptor = "(B)I")
    public int cpuCount() {
        return this.cpuCount;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(I)Z")
    public boolean isSigned() {
        return this.signed;
    }
}
