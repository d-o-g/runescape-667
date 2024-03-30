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
    public final void renderRotated(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(3) int scale, @OriginalArg(4) ClippingMask mask, @OriginalArg(5) int maskX, @OriginalArg(6) int maskY) {
        this.renderRotated(x, y, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, 4096, scale, mask, maskX, maskY);
    }

    @OriginalMember(owner = "client!st", name = "c", descriptor = "(IIII)V")
    public abstract void setOffsets(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFIILclient!aa;II)V")
    public final void renderRotated(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float centerX, @OriginalArg(3) float centerY, @OriginalArg(4) int scale, @OriginalArg(5) int angle, @OriginalArg(6) ClippingMask mask, @OriginalArg(7) int maskX, @OriginalArg(8) int maskY) {
        if (scale == 0) {
            return;
        }

        @Pc(9) double a = (double) (angle & 0xFFFF) * 9.587379924285257E-5D; // pi / 32768
        @Pc(16) float sinA = (float) Math.sin(a) * (float) scale;
        @Pc(23) float cosA = (float) Math.cos(a) * (float) scale;
        @Pc(37) float cx = (((-centerX * cosA) + (-centerY * sinA)) / 4096.0F) + x;
        @Pc(50) float cy = (((centerX * sinA) + (-centerY * cosA)) / 4096.0F) + y;
        @Pc(67) float x1 = (((((float) this.scaleWidth() - centerX) * cosA) + (-centerY * sinA)) / 4096.0F) + x;
        @Pc(85) float y1 = (((-((float) this.scaleWidth() - centerX) * sinA) + (-centerY * cosA)) / 4096.0F) + y;
        @Pc(102) float x2 = (((-centerX * cosA) + (((float) this.scaleHeight() - centerY) * sinA)) / 4096.0F) + x;
        @Pc(118) float y2 = (((centerX * sinA) + (((float) this.scaleHeight() - centerY) * cosA)) / 4096.0F) + y;
        this.renderParallelogram(cx, cy, x1, y1, x2, y2, mask, maskX, maskY);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFII)V")
    public final void renderRotated(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) int scale, @OriginalArg(3) int angle) {
        this.renderRotated(x, y, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, scale, angle, 1, 0);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFIIIII)V")
    public final void renderRotated(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) int scale, @OriginalArg(3) int op, @OriginalArg(5) int mode) {
        this.renderRotated(x, y, (float) this.scaleWidth() / 2.0F, (float) this.scaleHeight() / 2.0F, scale, op, 0, mode);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFIIIII)V")
    public void renderRotated(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float centerX, @OriginalArg(3) float centerY, @OriginalArg(4) int scale, @OriginalArg(5) int op, @OriginalArg(6) int color, @OriginalArg(7) int mode) {
        if (scale == 0) {
            return;
        }

        @Pc(9) double a = (double) (op & 0xFFFF) * 9.587379924285257E-5D; // pi / 32768
        @Pc(16) float sinA = (float) Math.sin(a) * (float) scale;
        @Pc(23) float cosA = (float) Math.cos(a) * (float) scale;
        @Pc(37) float cx = (((-centerX * cosA) + (-centerY * sinA)) / 4096.0F) + x;
        @Pc(50) float cy = (((centerX * sinA) + (-centerY * cosA)) / 4096.0F) + y;
        @Pc(67) float x1 = (((((float) this.scaleWidth() - centerX) * cosA) + (-centerY * sinA)) / 4096.0F) + x;
        @Pc(85) float y1 = (((-((float) this.scaleWidth() - centerX) * sinA) + (-centerY * cosA)) / 4096.0F) + y;
        @Pc(102) float x2 = (((-centerX * cosA) + (((float) this.scaleHeight() - centerY) * sinA)) / 4096.0F) + x;
        @Pc(118) float y2 = (((centerX * sinA) + (((float) this.scaleHeight() - centerY) * cosA)) / 4096.0F) + y;
        this.renderParallelogram(cx, cy, x1, y1, x2, y2, color, mode);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "(IIIIIII)V")
    public abstract void renderTiled(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIIIII)V")
    protected abstract void renderImpl(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFLclient!aa;II)V")
    public void renderParallelogram(@OriginalArg(0) float centerX, @OriginalArg(1) float centerY, @OriginalArg(2) float x1, @OriginalArg(3) float y1, @OriginalArg(4) float x2, @OriginalArg(5) float y2, @OriginalArg(6) ClippingMask mask, @OriginalArg(7) int maskX, @OriginalArg(8) int maskY) {
        this.renderParallelogramImpl(centerX, centerY, x1, y1, x2, y2, mask, maskX, maskY);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "()I")
    public abstract int scaleHeight();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "([I)V")
    public abstract void projectOffsets(@OriginalArg(0) int[] destination);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFILclient!aa;II)V")
    protected abstract void renderParallelogramImpl(@OriginalArg(0) float centerX, @OriginalArg(1) float centerY, @OriginalArg(2) float x1, @OriginalArg(3) float y1, @OriginalArg(4) float x2, @OriginalArg(5) float y2, @OriginalArg(7) ClippingMask mask, @OriginalArg(8) int maskX, @OriginalArg(9) int maskY);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IILclient!aa;II)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) ClippingMask mask, @OriginalArg(3) int maskX, @OriginalArg(4) int maskY);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(III)V")
    public abstract void copyAlpha(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int channel);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIII)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int op, @OriginalArg(3) int color, @OriginalArg(4) int mode);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIII)V")
    public final void renderTiled(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this.renderTiled(x, y, width, height, 1, 0, 1);
    }

    @OriginalMember(owner = "client!st", name = "c", descriptor = "()I")
    public abstract int getWidth();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFIIII)V")
    protected abstract void renderImpl(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int filter);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIII)V")
    public abstract void copyRect(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour);

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(II)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y) {
        this.render(x, y, 1, 0, 1);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "()I")
    public abstract int scaleWidth();

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(FFFFFFIII)V")
    public void renderParallelogram(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int filter) {
        this.renderImpl(x, y, width, height, op, colour, mode, filter);
    }

    @OriginalMember(owner = "client!st", name = "a", descriptor = "(IIIIIII)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        this.renderImpl(x, y, width, height, op, colour, mode);
    }

    @OriginalMember(owner = "client!st", name = "b", descriptor = "(IIII)V")
    public final void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height) {
        this.renderImpl(x, y, width, height, 1, 0, 1);
    }
}
