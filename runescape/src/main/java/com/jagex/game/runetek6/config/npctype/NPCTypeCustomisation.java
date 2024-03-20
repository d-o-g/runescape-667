package com.jagex.game.runetek6.config.npctype;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vk")
public final class NPCTypeCustomisation {

    @OriginalMember(owner = "client!vk", name = "f", descriptor = "[S")
    public short[] retex_d;

    @OriginalMember(owner = "client!vk", name = "d", descriptor = "[I")
    public int[] models;

    @OriginalMember(owner = "client!vk", name = "g", descriptor = "[S")
    public short[] recol_d;

    @OriginalMember(owner = "client!vk", name = "c", descriptor = "J")
    public long id;

    @OriginalMember(owner = "client!vk", name = "<init>", descriptor = "(J[I[S[S)V")
    public NPCTypeCustomisation(@OriginalArg(0) long id, @OriginalArg(1) int[] models, @OriginalArg(2) short[] recol_d, @OriginalArg(3) short[] retex_d) {
        this.retex_d = retex_d;
        this.models = models;
        this.recol_d = recol_d;
        this.id = id;
    }

    @OriginalMember(owner = "client!vk", name = "<init>", descriptor = "()V")
    public NPCTypeCustomisation() {
    }
}
