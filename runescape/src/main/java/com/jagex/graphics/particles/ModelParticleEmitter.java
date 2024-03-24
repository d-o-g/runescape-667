package com.jagex.graphics.particles;

import com.jagex.game.runetek6.config.emittertype.ParticleEmitterType;
import com.jagex.game.runetek6.config.emittertype.ParticleEmitterTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!rv")
public final class ModelParticleEmitter {

    @OriginalMember(owner = "client!rv", name = "d", descriptor = "I")
    public int anInt8502;

    @OriginalMember(owner = "client!rv", name = "g", descriptor = "I")
    public int anInt8503;

    @OriginalMember(owner = "client!rv", name = "c", descriptor = "I")
    public int anInt8504;

    @OriginalMember(owner = "client!rv", name = "x", descriptor = "I")
    public int anInt8507;

    @OriginalMember(owner = "client!rv", name = "u", descriptor = "I")
    public int anInt8509;

    @OriginalMember(owner = "client!rv", name = "k", descriptor = "I")
    public int anInt8512;

    @OriginalMember(owner = "client!rv", name = "m", descriptor = "Lclient!rv;")
    public ModelParticleEmitter next;

    @OriginalMember(owner = "client!rv", name = "q", descriptor = "I")
    public int anInt8516;

    @OriginalMember(owner = "client!rv", name = "n", descriptor = "I")
    public int anInt8518;

    @OriginalMember(owner = "client!rv", name = "t", descriptor = "I")
    public int anInt8520;

    @OriginalMember(owner = "client!rv", name = "b", descriptor = "B")
    public final byte aByte130;

    @OriginalMember(owner = "client!rv", name = "j", descriptor = "I")
    public final int anInt8514;

    @OriginalMember(owner = "client!rv", name = "e", descriptor = "I")
    public final int anInt8508;

    @OriginalMember(owner = "client!rv", name = "v", descriptor = "I")
    public final int anInt8505;

    @OriginalMember(owner = "client!rv", name = "o", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!rv", name = "<init>", descriptor = "(IIIIB)V")
    public ModelParticleEmitter(@OriginalArg(0) int id, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4) {
        this.aByte130 = arg4;
        this.anInt8514 = arg1;
        this.anInt8508 = arg2;
        this.anInt8505 = arg3;
        this.id = id;
    }

    @OriginalMember(owner = "client!rv", name = "d", descriptor = "(I)Lclient!vaa;")
    public ParticleEmitterType getType() {
        return ParticleEmitterTypeList.get(this.id);
    }

    @OriginalMember(owner = "client!rv", name = "a", descriptor = "(ZIII)Lclient!rv;")
    public ModelParticleEmitter copy(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        return new ModelParticleEmitter(this.id, arg0, arg1, arg2, this.aByte130);
    }
}
