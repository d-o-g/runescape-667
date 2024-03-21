package com.jagex.graphics;

import com.jagex.collect.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lca")
public abstract class PointLight extends Node {

    @OriginalMember(owner = "client!lca", name = "y", descriptor = "I")
    public final int range;

    @OriginalMember(owner = "client!lca", name = "r", descriptor = "I")
    public final int anInt9582;

    @OriginalMember(owner = "client!lca", name = "z", descriptor = "F")
    protected float intensity;

    @OriginalMember(owner = "client!lca", name = "x", descriptor = "I")
    protected int x;

    @OriginalMember(owner = "client!lca", name = "v", descriptor = "I")
    protected int z;

    @OriginalMember(owner = "client!lca", name = "t", descriptor = "I")
    protected int y;

    @OriginalMember(owner = "client!lca", name = "<init>", descriptor = "(IIIIIF)V")
    public PointLight(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z, @OriginalArg(3) int range, @OriginalArg(4) int arg4, @OriginalArg(5) float intensity) {
        this.range = range;
        this.anInt9582 = arg4;
        this.intensity = intensity;
        this.x = x;
        this.z = z;
        this.y = y;
    }

    @OriginalMember(owner = "client!lca", name = "d", descriptor = "(I)I")
    public final int getY() {
        return this.y;
    }

    @OriginalMember(owner = "client!lca", name = "h", descriptor = "(I)I")
    public final int getX() {
        return this.x;
    }

    @OriginalMember(owner = "client!lca", name = "a", descriptor = "(IIII)V")
    public abstract void setPosition(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2);

    @OriginalMember(owner = "client!lca", name = "a", descriptor = "(I)F")
    public final float getIntensity() {
        return this.intensity;
    }

    @OriginalMember(owner = "client!lca", name = "c", descriptor = "(I)I")
    public final int getZ() {
        return this.z;
    }

    @OriginalMember(owner = "client!lca", name = "b", descriptor = "(B)I")
    public final int method8431() {
        return this.anInt9582;
    }

    @OriginalMember(owner = "client!lca", name = "g", descriptor = "(I)I")
    public final int getRange() {
        return this.range;
    }

    @OriginalMember(owner = "client!lca", name = "a", descriptor = "(BF)V")
    public abstract void method8433(@OriginalArg(1) float arg0);
}
