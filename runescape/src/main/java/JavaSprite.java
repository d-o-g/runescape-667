import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qc")
public abstract class JavaSprite extends Sprite {

    @OriginalMember(owner = "client!qc", name = "j", descriptor = "I")
    protected int anInt9294;

    @OriginalMember(owner = "client!qc", name = "n", descriptor = "I")
    protected int anInt9295;

    @OriginalMember(owner = "client!qc", name = "v", descriptor = "I")
    protected int anInt9298;

    @OriginalMember(owner = "client!qc", name = "h", descriptor = "I")
    protected int anInt9308;

    @OriginalMember(owner = "client!qc", name = "w", descriptor = "[I")
    public int[] anIntArray713;

    @OriginalMember(owner = "client!qc", name = "o", descriptor = "Lclient!iaa;")
    protected final JavaToolkit toolkit;

    @OriginalMember(owner = "client!qc", name = "z", descriptor = "I")
    public final int anInt9302;

    @OriginalMember(owner = "client!qc", name = "u", descriptor = "I")
    public final int anInt9306;

    @OriginalMember(owner = "client!qc", name = "<init>", descriptor = "(Lclient!iaa;II)V")
    public JavaSprite(@OriginalArg(0) JavaToolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        this.toolkit = arg0;
        this.anInt9302 = arg1;
        this.anInt9306 = arg2;
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "()I")
    @Override
    public final int scaleHeight() {
        return this.anInt9308 + this.anInt9306 + this.anInt9294;
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(IILclient!aa;II)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) ClippingMask mask, @OriginalArg(3) int maskX, @OriginalArg(4) int maskY);

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "([I)V")
    @Override
    public final void projectOffsets(@OriginalArg(0) int[] destination) {
        destination[0] = this.anInt9298;
        destination[1] = this.anInt9308;
        destination[2] = this.anInt9295;
        destination[3] = this.anInt9294;
    }

    @OriginalMember(owner = "client!qc", name = "d", descriptor = "()I")
    @Override
    public final int getHeight() {
        return this.anInt9306;
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(IIIIIIII)V")
    protected abstract void renderImpl(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode);

    @OriginalMember(owner = "client!qc", name = "b", descriptor = "(IIIIIIIII)V")
    public abstract void method8207(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7);

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(IIIIIIIII)V")
    public abstract void method8208(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7);

    @OriginalMember(owner = "client!qc", name = "c", descriptor = "()I")
    @Override
    public final int getWidth() {
        return this.anInt9302;
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(FFFFFFILclient!aa;II)V")
    @Override
    protected final void renderParallelogramImpl(@OriginalArg(0) float centerX, @OriginalArg(1) float centerY, @OriginalArg(2) float x1, @OriginalArg(3) float y1, @OriginalArg(4) float x2, @OriginalArg(5) float y2, @OriginalArg(7) ClippingMask mask, @OriginalArg(8) int maskX, @OriginalArg(9) int maskY) {
        if (this.toolkit.stopped()) {
            throw new IllegalStateException();
        } else if (this.method8211(centerX, centerY, x1, y1, x2, y2)) {
            @Pc(22) JavaClippingMask local22 = (JavaClippingMask) mask;
            this.method8210(local22.lineOffsets, local22.lineWidths, Static513.anInt9301 - maskX, -maskY - (Static513.anInt9297 - Static513.anInt9314));
        }
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(FFFFFFIIII)V")
    @Override
    protected final void renderImpl(@OriginalArg(0) float x, @OriginalArg(1) float y, @OriginalArg(2) float width, @OriginalArg(3) float height, @OriginalArg(4) float op, @OriginalArg(5) float colour, @OriginalArg(6) int mode, @OriginalArg(7) int filter) {
        if (this.toolkit.stopped()) {
            throw new IllegalStateException();
        } else if (this.method8211(x, y, width, height, op, colour)) {
            Static513.anInt9313 = filter;
            if (mode != 1) {
                Static513.anInt9304 = filter >>> 24;
                Static513.anInt9312 = 256 - Static513.anInt9304;
                if (mode == 0) {
                    Static513.anInt9319 = filter >> 16 & 0xFF;
                    Static513.anInt9299 = filter >> 8 & 0xFF;
                    Static513.anInt9315 = filter & 0xFF;
                } else if (mode == 2) {
                    Static513.anInt9296 = filter >>> 24;
                    Static513.anInt9300 = 256 - Static513.anInt9296;
                    @Pc(73) int local73 = (filter & 0xFF00FF) * Static513.anInt9300 & 0xFF00FF00;
                    @Pc(81) int local81 = (filter & 0xFF00) * Static513.anInt9300 & 0xFF0000;
                    Static513.anInt9305 = (local73 | local81) >>> 8;
                }
            }
            if (mode == 1) {
                this.method8209(1);
            } else if (mode == 0) {
                this.method8209(0);
            } else if (mode == 3) {
                this.method8209(3);
            } else if (mode == 2) {
                this.method8209(2);
            }
        }
    }

    @OriginalMember(owner = "client!qc", name = "b", descriptor = "()I")
    @Override
    public final int scaleWidth() {
        return this.anInt9298 + this.anInt9302 + this.anInt9295;
    }

    @OriginalMember(owner = "client!qc", name = "c", descriptor = "(IIII)V")
    @Override
    public final void setOffsets(@OriginalArg(0) int x1, @OriginalArg(1) int y1, @OriginalArg(2) int x2, @OriginalArg(3) int y2) {
        this.anInt9298 = x1;
        this.anInt9308 = y1;
        this.anInt9295 = x2;
        this.anInt9294 = y2;
    }

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(IIIII)V")
    public abstract void render(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int op, @OriginalArg(3) int color, @OriginalArg(4) int mode);

    @OriginalMember(owner = "client!qc", name = "b", descriptor = "(IIIIIII)V")
    @Override
    public final void renderTiled(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int op, @OriginalArg(5) int colour, @OriginalArg(6) int mode) {
        if (this.toolkit.stopped()) {
            throw new IllegalStateException();
        }
        if (this.anIntArray713 == null) {
            this.anIntArray713 = new int[4];
        }
        this.toolkit.K(this.anIntArray713);
        this.toolkit.T(this.toolkit.clipX1, this.toolkit.clipY1, x + width, y + height);
        @Pc(40) int local40 = this.scaleWidth();
        @Pc(43) int local43 = this.scaleHeight();
        @Pc(51) int local51 = (width + local40 - 1) / local40;
        @Pc(59) int local59 = (height + local43 - 1) / local43;
        for (@Pc(61) int local61 = 0; local61 < local59; local61++) {
            @Pc(66) int local66 = local61 * local43;
            for (@Pc(68) int local68 = 0; local68 < local51; local68++) {
                this.render(x + local68 * local40, y + local66, op, colour, mode);
            }
        }
        this.toolkit.KA(this.anIntArray713[0], this.anIntArray713[1], this.anIntArray713[2], this.anIntArray713[3]);
    }

    @OriginalMember(owner = "client!qc", name = "b", descriptor = "(II)V")
    protected abstract void method8209(@OriginalArg(0) int arg0);

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "([I[III)V")
    protected abstract void method8210(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3);

    @OriginalMember(owner = "client!qc", name = "a", descriptor = "(FFFFFF)Z")
    public boolean method8211(@OriginalArg(0) float arg0, @OriginalArg(1) float arg1, @OriginalArg(2) float arg2, @OriginalArg(3) float arg3, @OriginalArg(4) float arg4, @OriginalArg(5) float arg5) {
        @Pc(8) int local8 = this.anInt9298 + this.anInt9302 + this.anInt9295;
        @Pc(17) int local17 = this.anInt9308 + this.anInt9306 + this.anInt9294;
        @Pc(34) float local34;
        @Pc(41) float local41;
        @Pc(48) float local48;
        @Pc(55) float local55;
        @Pc(61) float local61;
        @Pc(67) float local67;
        @Pc(73) float local73;
        @Pc(79) float local79;
        if (local8 != this.anInt9302 || local17 != this.anInt9306) {
            local34 = (arg2 - arg0) / (float) local8;
            local41 = (arg3 - arg1) / (float) local8;
            local48 = (arg4 - arg0) / (float) local17;
            local55 = (arg5 - arg1) / (float) local17;
            local61 = local48 * (float) this.anInt9308;
            local67 = local55 * (float) this.anInt9308;
            local73 = local34 * (float) this.anInt9298;
            local79 = local41 * (float) this.anInt9298;
            @Pc(86) float local86 = -local34 * (float) this.anInt9295;
            @Pc(93) float local93 = -local41 * (float) this.anInt9295;
            @Pc(100) float local100 = -local48 * (float) this.anInt9294;
            @Pc(107) float local107 = -local55 * (float) this.anInt9294;
            arg0 += local73 + local61;
            arg1 += local79 + local67;
            arg2 += local86 + local61;
            arg3 += local93 + local67;
            arg4 += local73 + local100;
            arg5 += local79 + local107;
        }
        local34 = arg4 + arg2 - arg0;
        local41 = arg3 + arg5 - arg1;
        if (arg0 < arg2) {
            local48 = arg0;
            local55 = arg2;
        } else {
            local48 = arg2;
            local55 = arg0;
        }
        if (arg4 < local48) {
            local48 = arg4;
        }
        if (local34 < local48) {
            local48 = local34;
        }
        if (arg4 > local55) {
            local55 = arg4;
        }
        if (local34 > local55) {
            local55 = local34;
        }
        if (arg1 < arg3) {
            local61 = arg1;
            local67 = arg3;
        } else {
            local61 = arg3;
            local67 = arg1;
        }
        if (arg5 < local61) {
            local61 = arg5;
        }
        if (local41 < local61) {
            local61 = local41;
        }
        if (arg5 > local67) {
            local67 = arg5;
        }
        if (local41 > local67) {
            local67 = local41;
        }
        if (local48 < (float) this.toolkit.clipX1) {
            local48 = (float) this.toolkit.clipX1;
        }
        if (local55 > (float) this.toolkit.clipX2) {
            local55 = (float) this.toolkit.clipX2;
        }
        if (local61 < (float) this.toolkit.clipY1) {
            local61 = (float) this.toolkit.clipY1;
        }
        if (local67 > (float) this.toolkit.clipY2) {
            local67 = (float) this.toolkit.clipY2;
        }
        local55 = local48 - local55;
        if (local55 >= 0.0F) {
            return false;
        }
        local67 = local61 - local67;
        if (local67 >= 0.0F) {
            return false;
        }
        Static513.anInt9291 = this.toolkit.surfaceWidth;
        Static513.anInt9292 = (int) ((float) ((int) local61 * Static513.anInt9291) + local48);
        local73 = (arg2 - arg0) * (arg5 - arg1) - (arg3 - arg1) * (arg4 - arg0);
        local79 = (arg4 - arg0) * (arg3 - arg1) - (arg5 - arg1) * (arg2 - arg0);
        Static513.anInt9321 = (int) ((arg5 - arg1) * 4096.0F * (float) this.anInt9302 / local73);
        Static513.anInt9309 = (int) ((arg3 - arg1) * 4096.0F * (float) this.anInt9306 / local79);
        Static513.anInt9311 = (int) ((arg4 - arg0) * 4096.0F * (float) this.anInt9302 / local79);
        Static513.anInt9293 = (int) ((arg2 - arg0) * 4096.0F * (float) this.anInt9306 / local73);
        Static513.anInt9320 = (int) (local48 * 16.0F + 8.0F - (arg0 + arg2 + arg4 + local34) / 4.0F * 16.0F);
        Static513.anInt9307 = (int) (local61 * 16.0F + 8.0F - (arg1 + arg3 + arg5 + local41) / 4.0F * 16.0F);
        Static513.anInt9310 = (this.anInt9302 >> 1 << 12) + (Static513.anInt9307 * Static513.anInt9311 >> 4);
        Static513.anInt9317 = (this.anInt9306 >> 1 << 12) + (Static513.anInt9307 * Static513.anInt9293 >> 4);
        Static513.anInt9318 = Static513.anInt9320 * Static513.anInt9321 >> 4;
        Static513.anInt9316 = Static513.anInt9320 * Static513.anInt9309 >> 4;
        Static513.anInt9301 = (int) local48;
        Static513.anInt9303 = (int) local55;
        Static513.anInt9314 = (int) local61;
        Static513.anInt9297 = (int) local67;
        return true;
    }
}
