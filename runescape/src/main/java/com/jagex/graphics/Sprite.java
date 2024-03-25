package com.jagex.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!st")
public abstract class Sprite implements Surface {

    @OriginalMember(owner = "client!st", name = "<init>", descriptor = "()V")
    protected Sprite() {
    }

    @OriginalMember(owner = "client!st", name = "d", descriptor = "()I")
    public abstract int getHeight();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFIILclient!aa;II)V")
    public final void method8183(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(3) int arg2, @OriginalArg(4) ClippingMask arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        this.renderRotated(arg0, arg1, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, 4096, arg2, arg3, arg4, arg5);
    }

    @OriginalMember(owner = "client!st", name = "c", descriptor = "(IIII)V")
    public abstract void method8184(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFIILclient!aa;II)V")
    public final void renderRotated(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) ClippingMask arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        if (arg4 == 0) {
            return;
        }
        @Pc(9) double local9 = (double) (arg5 & 0xFFFF) * 9.587379924285257E-5D;
        @Pc(16) float local16 = (float) Math.sin(local9) * (float) arg4;
        @Pc(23) float local23 = (float) Math.cos(local9) * (float) arg4;
        @Pc(37) float local37 = (-arg2 * local23 + -arg3 * local16) / 4096.0F + arg0;
        @Pc(50) float local50 = (arg2 * local16 + -arg3 * local23) / 4096.0F + arg1;
        @Pc(67) float local67 = (((float) this.scaleWidth() - arg2) * local23 + -arg3 * local16) / 4096.0F + arg0;
        @Pc(85) float local85 = (-((float) this.scaleWidth() - arg2) * local16 + -arg3 * local23) / 4096.0F + arg1;
        @Pc(102) float local102 = (-arg2 * local23 + ((float) this.scaleHeight() - arg3) * local16) / 4096.0F + arg0;
        @Pc(118) float local118 = (arg2 * local16 + ((float) this.scaleHeight() - arg3) * local23) / 4096.0F + arg1;
        this.method8191(local37, local50, local67, local85, local102, local118, arg6, arg7, arg8);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFII)V")
    public final void method8186(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        this.method8188(arg0, arg1, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, arg2, arg3, 1, 0);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFIIIII)V")
    public final void method8187(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg4) {
        this.method8188(arg0, arg1, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, arg2, arg3, 0, arg4);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFIIIII)V")
    public void method8188(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
        if (arg4 == 0) {
            return;
        }
        @Pc(9) double local9 = (double) (arg5 & 0xFFFF) * 9.587379924285257E-5D;
        @Pc(16) float local16 = (float) Math.sin(local9) * (float) arg4;
        @Pc(23) float local23 = (float) Math.cos(local9) * (float) arg4;
        @Pc(37) float local37 = (-arg2 * local23 + -arg3 * local16) / 4096.0F + arg0;
        @Pc(50) float local50 = (arg2 * local16 + -arg3 * local23) / 4096.0F + arg1;
        @Pc(67) float local67 = (((float) this.scaleWidth() - arg2) * local23 + -arg3 * local16) / 4096.0F + arg0;
        @Pc(85) float local85 = (-((float) this.scaleWidth() - arg2) * local16 + -arg3 * local23) / 4096.0F + arg1;
        @Pc(102) float local102 = (-arg2 * local23 + ((float) this.scaleHeight() - arg3) * local16) / 4096.0F + arg0;
        @Pc(118) float local118 = (arg2 * local16 + ((float) this.scaleHeight() - arg3) * local23) / 4096.0F + arg1;
        this.method8204(local37, local50, local67, local85, local102, local118, arg6, arg7);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "(IIIIIII)V")
    public abstract void method8189(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIIIII)V")
    protected abstract void method8190(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFLclient!aa;II)V")
    public void method8191(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) float arg4, @OriginalArg(5) float arg5, @OriginalArg(6) ClippingMask arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
        this.method8194(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "()I")
    public abstract int scaleHeight();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "([I)V")
    public abstract void projectOffsets(@OriginalArg(0) int[] arg0);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFILclient!aa;II)V")
    protected abstract void method8194(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) float arg4, @OriginalArg(5) float arg5, @OriginalArg(7) ClippingMask arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IILclient!aa;II)V")
    public abstract void method8195(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) ClippingMask arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(III)V")
    public abstract void method8196();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIII)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIII)V")
    public final void method8198(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this.method8189(x, y, width, height, 1, 0, 1);
    }

    @OriginalMember(owner = "client!st", name = "c", descriptor = "()I")
    public abstract int getWidth();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFIIII)V")
    protected abstract void render(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int arg7);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIII)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(II)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y) {
        this.render(x, y, 1, 0, 1);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "()I")
    public abstract int scaleWidth();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFIII)V")
    public void method8204(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int arg7) {
        this.render(x, y, width, height, op, colour, mode, arg7);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIIII)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        this.method8190(x, y, width, height, op, colour, mode);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "(IIII)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this.method8190(x, y, width, height, 1, 0, 1);
    }
}
