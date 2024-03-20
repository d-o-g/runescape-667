package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tt")
public abstract class Matrix {

    @OriginalMember(owner = "client!tt", name = "c", descriptor = "(III[I)V")
    public abstract void method7124(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(III)V")
    public abstract void method7125(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2);

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
    public abstract void translate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(IIIIII)V")
    public abstract void method7135(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(I)V")
    public abstract void method7136(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "(III[I)V")
    public abstract void method7138(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);

    @OriginalMember(owner = "client!tt", name = "b", descriptor = "(I)V")
    public abstract void rotateAxisZ(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "(III[I)V")
    public abstract void method7140(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3);
}
