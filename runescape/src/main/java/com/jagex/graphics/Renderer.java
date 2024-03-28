package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dp")
public final class Renderer {

    @OriginalMember(owner = "client!dp", name = "g", descriptor = "Ljava/lang/String;")
    public final String name;

    @OriginalMember(owner = "client!dp", name = "b", descriptor = "J")
    public final long driverVersion;

    @OriginalMember(owner = "client!dp", name = "e", descriptor = "I")
    public final int version;

    @OriginalMember(owner = "client!dp", name = "i", descriptor = "Ljava/lang/String;")
    public final String device;

    @OriginalMember(owner = "client!dp", name = "h", descriptor = "I")
    public final int vendor;

    @OriginalMember(owner = "client!dp", name = "<init>", descriptor = "(ILjava/lang/String;ILjava/lang/String;J)V")
    public Renderer(@OriginalArg(0) int vendor, @OriginalArg(1) String name, @OriginalArg(2) int version, @OriginalArg(3) String device, @OriginalArg(4) long driverVersion) {
        this.name = name;
        this.driverVersion = driverVersion;
        this.version = version;
        this.device = device;
        this.vendor = vendor;
    }
}
