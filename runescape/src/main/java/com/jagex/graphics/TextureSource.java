package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!d")
public interface TextureSource {

    @OriginalMember(owner = "client!d", name = "a", descriptor = "(I)I")
    int textureCount();

    @OriginalMember(owner = "client!d", name = "a", descriptor = "(II)Z")
    boolean textureAvailable(@OriginalArg(1) int arg0);

    @OriginalMember(owner = "client!d", name = "a", descriptor = "(FIIZZI)[I")
    int[] argbOutput(@OriginalArg(0) float f, @OriginalArg(1) int id, @OriginalArg(2) int width, @OriginalArg(5) int height);

    @OriginalMember(owner = "client!d", name = "a", descriptor = "(IIFBIZ)[F")
    float[] floatArgbOutput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) float arg2, @OriginalArg(4) int arg3);

    @OriginalMember(owner = "client!d", name = "b", descriptor = "(II)Lclient!fa;")
    TextureMetrics getMetrics(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!d", name = "a", descriptor = "(IZIIBF)[I")
    int[] rgbOutput(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) float arg4);
}
