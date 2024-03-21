package com.jagex.graphics.skybox;

import com.jagex.graphics.Matrix;
import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.PickingCylinder;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import com.jagex.math.IntMath;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ks")
public final class SkyBoxSphere {

    @OriginalMember(owner = "client!ks", name = "h", descriptor = "[I")
    public static final int[] anIntArray418 = new int[4];

    @OriginalMember(owner = "client!wga", name = "e", descriptor = "Lclient!d;")
    public static TextureSource textureSource;

    @OriginalMember(owner = "client!ks", name = "l", descriptor = "Lclient!ka;")
    public static Model model;

    @OriginalMember(owner = "client!ks", name = "j", descriptor = "Lclient!st;")
    public static Sprite aSprite;

    @OriginalMember(owner = "client!ks", name = "o", descriptor = "Lclient!st;")
    public static Sprite aSprite_25;

    @OriginalMember(owner = "client!mba", name = "E", descriptor = "Lclient!sb;")
    public static js5 aJs5_80;

    @OriginalMember(owner = "client!ks", name = "n", descriptor = "I")
    public int anInt5627;

    @OriginalMember(owner = "client!ks", name = "e", descriptor = "I")
    public int anInt5628;

    @OriginalMember(owner = "client!ks", name = "d", descriptor = "I")
    public int anInt5631;

    @OriginalMember(owner = "client!ks", name = "b", descriptor = "Lclient!st;")
    public Sprite aSprite_24;

    @OriginalMember(owner = "client!ks", name = "m", descriptor = "I")
    public int anInt5638;

    @OriginalMember(owner = "client!ks", name = "r", descriptor = "I")
    public int anInt5639;

    @OriginalMember(owner = "client!ks", name = "i", descriptor = "I")
    public final int anInt5635;

    @OriginalMember(owner = "client!ks", name = "k", descriptor = "I")
    public final int anInt5626;

    @OriginalMember(owner = "client!ks", name = "g", descriptor = "I")
    public final int anInt5630;

    @OriginalMember(owner = "client!ks", name = "f", descriptor = "Z")
    public final boolean aBoolean429;

    @OriginalMember(owner = "client!ks", name = "p", descriptor = "I")
    public final int anInt5633;

    @OriginalMember(owner = "client!ks", name = "a", descriptor = "I")
    public final int anInt5634;

    @OriginalMember(owner = "client!ks", name = "q", descriptor = "I")
    public final int anInt5637;

    @OriginalMember(owner = "client!ks", name = "c", descriptor = "I")
    public final int anInt5640;

    @OriginalMember(owner = "client!ks", name = "t", descriptor = "I")
    public final int anInt5632;

    @OriginalMember(owner = "client!ks", name = "u", descriptor = "I")
    public final int anInt5629;

    @OriginalMember(owner = "client!ks", name = "s", descriptor = "I")
    public final int anInt5636;

    @OriginalMember(owner = "client!ks", name = "<init>", descriptor = "(IIIIIIIZIII)V")
    public SkyBoxSphere(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
        this.anInt5635 = arg2;
        this.anInt5626 = arg3;
        this.anInt5630 = arg4;
        this.aBoolean429 = arg7;
        this.anInt5633 = arg1;
        this.anInt5634 = arg6;
        this.anInt5637 = arg5;
        this.anInt5640 = arg0;
        this.anInt5632 = arg8;
        this.anInt5629 = arg9;
        this.anInt5636 = arg10;
    }

    @OriginalMember(owner = "client!ks", name = "a", descriptor = "(Lclient!ha;)V")
    public static void method5051(@OriginalArg(0) Toolkit arg0) {
        if (model != null) {
            return;
        }
        @Pc(8) Mesh local8 = new Mesh(580, 1104, 1);
        local8.addSphericalSpace();
        local8.addVertex(0, 128, 0);
        local8.addVertex(0, -128, 0);
        for (@Pc(37) int local37 = 0; local37 <= 24; local37++) {
            @Pc(44) int local44 = local37 * 8192 / 24;
            @Pc(48) int local48 = Trig1.SIN[local44];
            @Pc(52) int local52 = Trig1.COS[local44];
            @Pc(61) int local61;
            @Pc(67) int local67;
            @Pc(75) int local75;
            @Pc(83) int local83;
            for (@Pc(54) int local54 = 1; local54 < 24; local54++) {
                local61 = local54 * 8192 / 24;
                local67 = Trig1.COS[local61] >> 7;
                local75 = Trig1.SIN[local61] * local48 >> 21;
                local83 = Trig1.SIN[local61] * local52 >> 21;
                local8.addVertex(-local75, local67, local83);
            }
            if (local37 > 0) {
                local61 = local37 * 23 + 2;
                local67 = local61 - 23;
                local8.addFace(0, local61, local67, (short) 127, (short) 0, (byte) 0, (byte) 0, (byte) 0);
                for (local75 = 1; local75 < 23; local75++) {
                    local83 = local67 + 1;
                    @Pc(130) int local130 = local61 + 1;
                    local8.addFace(local67, local61, local83, (short) 127, (short) 0, (byte) 0, (byte) 0, (byte) 0);
                    local8.addFace(local83, local61, local130, (short) 127, (short) 0, (byte) 0, (byte) 0, (byte) 0);
                    local67 = local83;
                    local61 = local130;
                }
                local8.addFace(local61, 1, local67, (short) 127, (short) 0, (byte) 0, (byte) 0, (byte) 0);
            }
        }
        local8.maxVertex = local8.vertexCount;
        local8.faceGroup = null;
        local8.vertexGroup = null;
        local8.facePriorities = null;
        model = arg0.createModel(local8, 51200, 33, 64, 768);
    }

    @OriginalMember(owner = "client!ks", name = "b", descriptor = "(Lclient!ha;)V")
    public static void method5058(@OriginalArg(0) Toolkit arg0) {
        if (aSprite_25 != null) {
            return;
        }
        @Pc(4) int[] local4 = new int[16384];
        @Pc(7) int[] local7 = new int[16384];
        for (@Pc(9) int local9 = 0; local9 < 64; local9++) {
            @Pc(14) int local14 = 64 - local9;
            @Pc(18) int local18 = local14 * local14;
            @Pc(24) int local24 = 128 - local9 - 1;
            @Pc(28) int local28 = local9 * 128;
            @Pc(32) int local32 = local24 * 128;
            for (@Pc(34) int local34 = 0; local34 < 64; local34++) {
                @Pc(39) int local39 = 64 - local34;
                @Pc(43) int local43 = local39 * local39;
                @Pc(49) int local49 = 128 - local34 - 1;
                @Pc(59) int local59 = 256 - (local43 + local18 << 8) / 4096;
                local59 = local59 * 16 * 192 / 1536;
                if (local59 < 0) {
                    local59 = 0;
                } else if (local59 > 255) {
                    local59 = 255;
                }
                @Pc(81) int local81 = local59 / 2;
                local7[local28 + local34] = local7[local28 + local49] = local7[local32 + local34] = local7[local32 + local49] = (local59 | 0xFF00) << 16;
                local4[local28 + local34] = local4[local28 + local49] = local4[local32 + local34] = local4[local32 + local49] = 127 - local81 << 24 | 0xFFFFFF;
            }
        }
        aSprite_25 = arg0.createSprite(128, 128, 128, local7);
        aSprite = arg0.createSprite(128, 128, 128, local4);
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(IZ)I")
    public static int method5587(@OriginalArg(0) int arg0) {
        @Pc(7) int local7 = arg0 >>> 1;
        @Pc(13) int local13 = local7 | local7 >>> 1;
        @Pc(19) int local19 = local13 | local13 >>> 2;
        @Pc(25) int local25 = local19 | local19 >>> 4;
        @Pc(40) int local40 = local25 | local25 >>> 8;
        @Pc(46) int local46 = local40 | local40 >>> 16;
        return ~local46 & arg0;
    }

    @OriginalMember(owner = "client!ks", name = "c", descriptor = "(Lclient!ha;Lclient!ks;)Z")
    public boolean method5050(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) SkyBoxSphere arg1) {
        return this.aSprite_24 != null || this.method5057(arg0, arg1);
    }

    @OriginalMember(owner = "client!ks", name = "d", descriptor = "(Lclient!ha;Lclient!ks;)V")
    public void method5052(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) SkyBoxSphere arg1) {
        method5051(arg0);
        method5058(arg0);
        arg0.K(anIntArray418);
        arg0.KA(0, 0, this.anInt5638, this.anInt5638);
        arg0.ya();
        arg0.aa(0, 0, this.anInt5638, this.anInt5638, this.anInt5634 | 0xFF000000, 0);
        @Pc(31) int local31 = 0;
        @Pc(33) int local33 = 0;
        @Pc(35) int local35 = 256;
        if (arg1 != null) {
            if (arg1.aBoolean429) {
                local31 = -arg1.anInt5635;
                local33 = -arg1.anInt5626;
                local35 = -arg1.anInt5630;
            } else {
                local31 = arg1.anInt5635 - this.anInt5635;
                local33 = arg1.anInt5626 - this.anInt5626;
                local35 = arg1.anInt5630 - this.anInt5630;
            }
        }
        @Pc(79) int local79;
        @Pc(84) int local84;
        @Pc(94) int local94;
        if (this.anInt5639 != 0) {
            local79 = Trig1.SIN[this.anInt5639];
            local84 = Trig1.COS[this.anInt5639];
            local94 = local33 * local84 - local35 * local79 >> 14;
            local35 = local33 * local79 + local35 * local84 >> 14;
            local33 = local94;
        }
        if (this.anInt5628 != 0) {
            local79 = Trig1.SIN[this.anInt5628];
            local84 = Trig1.COS[this.anInt5628];
            local94 = local35 * local79 + local31 * local84 >> 14;
            local35 = local35 * local84 - local31 * local79 >> 14;
            local31 = local94;
        }
        @Pc(147) Model local147 = model.copy((byte) 0, 51200, true);
        local147.aa((short) 0, (short) this.anInt5633);
        arg0.xa(1.0F);
        arg0.ZA(16777215, 1.0F, 1.0F, (float) local31, (float) local33, (float) local35);
        local84 = this.anInt5638 * 1024 / (local147.RA() - local147.V());
        if (this.anInt5634 != 0) {
            local84 = local84 * 13 / 16;
        }
        @Pc(190) int[] local190 = arg0.Y();
        arg0.DA(this.anInt5638 / 2, this.anInt5638 / 2, local84, local84);
        arg0.setCamera(arg0.createMatrix());
        @Pc(209) Matrix local209 = arg0.createMatrix();
        local209.method7125(0, 0, arg0.i() - local147.HA());
        local147.renderOrtho(local209, (PickingCylinder) null, 1024, 1);
        @Pc(231) int local231 = this.anInt5638 * 13 / 16;
        @Pc(238) int local238 = (this.anInt5638 - local231) / 2;
        aSprite.render(local238, local238, local231, local231, 0, this.anInt5634 | 0xFF000000, 1);
        this.aSprite_24 = arg0.method7964(0, 0, this.anInt5638, this.anInt5638, true);
        arg0.ya();
        arg0.aa(0, 0, this.anInt5638, this.anInt5638, 0, 0);
        aSprite_25.render(0, 0, this.anInt5638, this.anInt5638, 1, 0, 0);
        this.aSprite_24.method8196();
        arg0.DA(local190[0], local190[1], local190[2], local190[3]);
        arg0.KA(anIntArray418[0], anIntArray418[1], anIntArray418[2], anIntArray418[3]);
    }

    @OriginalMember(owner = "client!ks", name = "a", descriptor = "(Lclient!ha;Lclient!ks;)V")
    public void method5054(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) SkyBoxSphere arg1) {
        @Pc(6) Mesh local6 = Mesh.load(this.anInt5633, aJs5_80);
        if (local6 == null) {
            return;
        }
        arg0.K(anIntArray418);
        arg0.KA(0, 0, this.anInt5638, this.anInt5638);
        arg0.ya();
        arg0.aa(0, 0, this.anInt5638, this.anInt5638, 0, 0);
        @Pc(34) int local34 = 0;
        @Pc(36) int local36 = 0;
        @Pc(38) int local38 = 256;
        if (arg1 != null) {
            if (arg1.aBoolean429) {
                local34 = -arg1.anInt5635;
                local36 = -arg1.anInt5626;
                local38 = -arg1.anInt5630;
            } else {
                local34 = this.anInt5635 - arg1.anInt5635;
                local36 = this.anInt5626 - arg1.anInt5626;
                local38 = this.anInt5630 - arg1.anInt5630;
            }
        }
        @Pc(83) int local83;
        @Pc(87) int local87;
        @Pc(91) int local91;
        @Pc(101) int local101;
        if (this.anInt5639 != 0) {
            local83 = -this.anInt5639 & 0x3FFF;
            local87 = Trig1.SIN[local83];
            local91 = Trig1.COS[local83];
            local101 = local36 * local91 - local38 * local87 >> 14;
            local38 = local36 * local87 + local38 * local91 >> 14;
            local36 = local101;
        }
        if (this.anInt5628 != 0) {
            local83 = -this.anInt5628 & 0x3FFF;
            local87 = Trig1.SIN[local83];
            local91 = Trig1.COS[local83];
            local101 = local38 * local87 + local34 * local91 >> 14;
            local38 = local38 * local91 - local34 * local87 >> 14;
            local34 = local101;
        }
        arg0.xa(1.0F);
        arg0.ZA(this.anInt5634, 1.0F, 1.0F, (float) local34, (float) local36, (float) local38);
        local6.rotate(this.anInt5636 & 0x3FFF, this.anInt5632 & 0x3FFF, this.anInt5629 & 0x3FFF);
        @Pc(190) Model local190 = arg0.createModel(local6, 2048, 0, 64, 768);
        local87 = local190.RA() - local190.V();
        local91 = local190.EA() - local190.fa();
        local101 = local87 > local91 ? local87 : local91;
        @Pc(216) int local216 = this.anInt5638 * 1024 / local101;
        @Pc(219) int[] local219 = arg0.Y();
        arg0.DA(this.anInt5638 / 2, this.anInt5638 / 2, local216, local216);
        arg0.setCamera(arg0.createMatrix());
        @Pc(238) Matrix local238 = arg0.scratchMatrix();
        local238.method7125(0, 0, arg0.i() - local190.HA());
        local190.renderOrtho(local238, (PickingCylinder) null, arg0.i(), 1);
        this.aSprite_24 = arg0.method7964(0, 0, this.anInt5638, this.anInt5638, true);
        this.aSprite_24.method8196();
        arg0.DA(local219[0], local219[1], local219[2], local219[3]);
        arg0.KA(anIntArray418[0], anIntArray418[1], anIntArray418[2], anIntArray418[3]);
    }

    @OriginalMember(owner = "client!ks", name = "a", descriptor = "(Lclient!ha;IIIIIIIIII)V")
    public void method5055(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
        if (this.aSprite_24 == null) {
            return;
        }
        @Pc(6) int[] local6 = new int[3];
        @Pc(14) int local14 = -(this.anInt5635 - arg7 << 16);
        @Pc(21) int local21 = this.anInt5626 - arg8 << 15;
        @Pc(29) int local29 = -(this.anInt5630 - arg9 << 16);
        @Pc(32) Matrix local32 = arg0.method8017();
        local32.method7124(0, 0, 0, local6);
        @Pc(44) int local44 = local14 + local6[0];
        @Pc(50) int local50 = local21 + local6[1];
        @Pc(56) int local56 = local29 + local6[2];
        arg0.H(local44, local50, local56, local6);
        if (local6[2] < 0) {
            return;
        }
        @Pc(75) int local75 = local6[0] - this.anInt5627 / 2;
        @Pc(84) int local84 = local6[1] - this.anInt5627 / 2;
        if (local84 < arg4 && local84 + this.anInt5627 > 0 && local75 < arg3 && local75 + this.anInt5627 > 0) {
            this.aSprite_24.render(local75, local84, this.anInt5627, this.anInt5627, 0, arg10 << 24 | 0xFFFFFF, 1);
        }
    }

    @OriginalMember(owner = "client!ks", name = "a", descriptor = "(IIII)Z")
    public boolean method5056(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
        @Pc(7) int local7;
        @Pc(12) int local12;
        @Pc(17) int local17;
        if (this.aBoolean429) {
            this.anInt5631 = 1073741823;
            local7 = this.anInt5635;
            local12 = this.anInt5626;
            local17 = this.anInt5630;
        } else {
            local7 = this.anInt5635 - arg0;
            local12 = this.anInt5626 - arg1;
            local17 = this.anInt5630 - arg2;
            this.anInt5631 = (int) Math.sqrt((double) (local7 * local7 + local12 * local12 + local17 * local17));
            if (this.anInt5631 == 0) {
                this.anInt5631 = 1;
            }
            local7 = (local7 << 8) / this.anInt5631;
            local12 = (local12 << 8) / this.anInt5631;
            local17 = (local17 << 8) / this.anInt5631;
        }
        @Pc(90) int local90 = (int) (Math.sqrt((double) (local7 * local7 + local12 * local12 + local17 * local17)) * 256.0D);
        if (local90 > 128) {
            local7 = (local7 << 16) / local90;
            local12 = (local12 << 16) / local90;
            local17 = (local17 << 16) / local90;
            this.anInt5627 = this.anInt5637 * arg3 / (this.aBoolean429 ? 1024 : this.anInt5631);
        } else {
            this.anInt5627 = 0;
        }
        if (this.anInt5627 < 8) {
            this.aSprite_24 = null;
            return false;
        }
        @Pc(143) int local143 = IntMath.nextPow2(this.anInt5627);
        if (local143 > arg3) {
            local143 = method5587(arg3);
        }
        if (local143 > 512) {
            local143 = 512;
        }
        if (local143 != this.anInt5638) {
            this.anInt5638 = local143;
        }
        this.anInt5639 = (int) (Math.asin((double) ((float) local12 / 256.0F)) * 2607.5945876176133D) & 0x3FFF;
        this.anInt5628 = (int) (Math.atan2((double) local7, (double) -local17) * 2607.5945876176133D) & 0x3FFF;
        this.aSprite_24 = null;
        return true;
    }

    @OriginalMember(owner = "client!ks", name = "b", descriptor = "(Lclient!ha;Lclient!ks;)Z")
    public boolean method5057(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) SkyBoxSphere arg1) {
        if (this.aSprite_24 == null) {
            if (this.anInt5640 == 0) {
                if (textureSource.textureAvailable(this.anInt5633)) {
                    @Pc(23) int[] local23 = textureSource.argbOutput(0.7F, this.anInt5633, this.anInt5638, this.anInt5638);
                    this.aSprite_24 = arg0.createSprite(this.anInt5638, this.anInt5638, this.anInt5638, local23);
                }
            } else if (this.anInt5640 == 2) {
                this.method5054(arg0, arg1);
            } else if (this.anInt5640 == 1) {
                this.method5052(arg0, arg1);
            }
        }
        return this.aSprite_24 != null;
    }
}
