package com.jagex.game.runetek6.config.loctype;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!gp")
public final class LocTypeCustomisation {

    @OriginalMember(owner = "client!le", name = "h", descriptor = "J")
    public static long uid = 1L;

    @OriginalMember(owner = "client!gp", name = "e", descriptor = "[I")
    public int[] models;

    @OriginalMember(owner = "client!gp", name = "g", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!gp", name = "d", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!gp", name = "f", descriptor = "J")
    public long id;

    @OriginalMember(owner = "client!gp", name = "<init>", descriptor = "(J[I[S[S)V")
    public LocTypeCustomisation(@OriginalArg(0) long id, @OriginalArg(1) int[] models, @OriginalArg(2) short[] arg2, @OriginalArg(3) short[] arg3) {
        this.models = models;
        this.recol_d = arg2;
        this.retex_d = arg3;
        this.id = id;
    }

    @OriginalMember(owner = "client!gp", name = "<init>", descriptor = "()V")
    public LocTypeCustomisation() {
    }
}
