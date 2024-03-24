package com.jagex.graphics.particles;

import com.jagex.game.runetek6.config.effectortype.ParticleEffectorType;
import com.jagex.game.runetek6.config.effectortype.ParticleEffectorTypeList;
import com.jagex.graphics.Matrix;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mn")
public final class ModelParticleEffector {

    @OriginalMember(owner = "client!mn", name = "j", descriptor = "I")
    public int anInt6249;

    @OriginalMember(owner = "client!mn", name = "c", descriptor = "I")
    public int anInt6250;

    @OriginalMember(owner = "client!mn", name = "h", descriptor = "I")
    public int anInt6252;

    @OriginalMember(owner = "client!mn", name = "l", descriptor = "Lclient!mn;")
    public ModelParticleEffector next;

    @OriginalMember(owner = "client!mn", name = "d", descriptor = "Lclient!tt;")
    public Matrix matrix;

    @OriginalMember(owner = "client!mn", name = "n", descriptor = "I")
    public final int type;

    @OriginalMember(owner = "client!mn", name = "a", descriptor = "I")
    public final int vertex;

    @OriginalMember(owner = "client!mn", name = "<init>", descriptor = "(II)V")
    public ModelParticleEffector(@OriginalArg(0) int type, @OriginalArg(1) int vertex) {
        this.type = type;
        this.vertex = vertex;
    }

    @OriginalMember(owner = "client!mn", name = "a", descriptor = "(B)Lclient!ok;")
    public ParticleEffectorType type() {
        return ParticleEffectorTypeList.get(this.type);
    }

    @OriginalMember(owner = "client!mn", name = "a", descriptor = "(ZI)Lclient!mn;")
    public ModelParticleEffector copy(@OriginalArg(1) int v) {
        return new ModelParticleEffector(this.type, v);
    }
}
