package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tt")
public abstract class Matrix {

    @OriginalMember(owner = "client!fb", name = "i", descriptor = "[F")
    public static final float[] SIN = new float[16384];

    @OriginalMember(owner = "client!fb", name = "c", descriptor = "[F")
    public static final float[] COS = new float[16384];

    static {
        @Pc(70) double d = 3.834951969714103E-4D;
        for (@Pc(72) int i = 0; i < 16384; i++) {
            SIN[i] = (float) Math.sin(d * (double) i);
            COS[i] = (float) Math.cos(d * (double) i);
        }
    }

    @OriginalMember(owner = "client!tt", name = "c", descriptor = "(III[I)V")
    public abstract void method7124(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(III)V")
    public abstract void applyTranslation(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "([I)V")
    public abstract void method7126(@OriginalArg(0) int[] arg0);

    @OriginalMember(owner = "client!tt", name = "f", descriptor = "(I)V")
    public abstract void rotateAxisY(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(Lclient!tt;)V")
    public abstract void method7128(@OriginalArg(0) Matrix arg0);

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "()Lclient!tt;")
    public abstract Matrix method7129();

    @OriginalMember(owner = "client!tt", name = "c", descriptor = "(I)V")
    public abstract void rotateAxisX(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "g", descriptor = "(I)V")
    public abstract void rotate(@OriginalArg(0) int angle);

    @OriginalMember(owner = "client!tt", name = "e", descriptor = "(I)V")
    public abstract void makeRotationZ(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "()V")
    public abstract void makeIdentity();

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "(III)V")
    public abstract void translate(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(IIIIII)V")
    public abstract void method7135(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(I)V")
    public abstract void makeRotationX(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "(III[I)V")
    public abstract void projectDirection(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "(I)V")
    public abstract void rotateAxisZ(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(III[I)V")
    public abstract void method7140(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);
}
