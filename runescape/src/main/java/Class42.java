import com.jagex.ParticleList;
import com.jagex.core.datastruct.Node2;
import com.jagex.math.IntMath;
import jaggl.OpenGL;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bj")
public final class Class42 {

    @OriginalMember(owner = "client!bj", name = "f", descriptor = "Lclient!ed;")
    public Class94 aClass94_1;

    @OriginalMember(owner = "client!bj", name = "h", descriptor = "Lclient!jc;")
    public Interface12 anInterface12_1;

    @OriginalMember(owner = "client!bj", name = "b", descriptor = "Lclient!ed;")
    public Class94 aClass94_2;

    @OriginalMember(owner = "client!bj", name = "c", descriptor = "Lclient!ed;")
    public Class94 aClass94_3;

    @OriginalMember(owner = "client!bj", name = "k", descriptor = "[F")
    public final float[] aFloatArray10 = new float[16];

    @OriginalMember(owner = "client!bj", name = "t", descriptor = "Lclient!jfa;")
    public final Node_Sub21_Sub1 aClass2_Sub21_Sub1_1 = new Node_Sub21_Sub1(786336);

    @OriginalMember(owner = "client!bj", name = "r", descriptor = "I")
    public final int anInt998 = IntMath.countBits(1600);

    @OriginalMember(owner = "client!bj", name = "s", descriptor = "[[Lclient!up;")
    public final Particle[][] aParticle = new Particle[64][768];

    @OriginalMember(owner = "client!bj", name = "n", descriptor = "[I")
    public final int[] anIntArray74 = new int[1600];

    @OriginalMember(owner = "client!bj", name = "j", descriptor = "[[Lclient!up;")
    public final Particle[][] aParticleArrayArray1 = new Particle[1600][64];

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "I")
    public int anInt1000 = 0;

    @OriginalMember(owner = "client!bj", name = "l", descriptor = "[I")
    public final int[] anIntArray75 = new int[8191];

    @OriginalMember(owner = "client!bj", name = "q", descriptor = "[I")
    public final int[] anIntArray76 = new int[64];

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "(ZLclient!qha;)V")
    public void method1075(@OriginalArg(1) GlToolkit arg0) {
        Static481.aFloat124 = arg0.aFloat149;
        arg0.method7027();
        OpenGL.glDisable(OpenGL.GL_LIGHT0);
        OpenGL.glDisable(OpenGL.GL_LIGHT1);
        arg0.method6972(false);
        OpenGL.glNormal3f(0.0F, -1.0F, 0.0F);
    }

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "(BLclient!qha;I)V")
    public void method1077(@OriginalArg(1) GlToolkit arg0, @OriginalArg(2) int arg1) {
        OpenGL.glGetFloatv(OpenGL.GL_MODELVIEW_MATRIX, this.aFloatArray10, 0);
        @Pc(15) float local15 = this.aFloatArray10[0];
        @Pc(20) float local20 = this.aFloatArray10[4];
        @Pc(35) float local35 = this.aFloatArray10[8];
        @Pc(40) float local40 = this.aFloatArray10[1];
        @Pc(45) float local45 = this.aFloatArray10[5];
        @Pc(50) float local50 = this.aFloatArray10[9];
        @Pc(54) float local54 = local40 + local15;
        @Pc(58) float local58 = local45 + local20;
        @Pc(62) float local62 = local50 + local35;
        @Pc(66) float local66 = local15 - local40;
        @Pc(71) float local71 = local20 - local45;
        @Pc(75) float local75 = local35 - local50;
        @Pc(80) float local80 = local40 - local15;
        @Pc(84) float local84 = local45 - local20;
        @Pc(88) float local88 = local50 - local35;
        this.aClass2_Sub21_Sub1_1.pos = 0;
        @Pc(99) int local99;
        @Pc(117) int local117;
        @Pc(123) int local123;
        @Pc(134) Particle local134;
        @Pc(137) int local137;
        @Pc(142) byte local142;
        @Pc(147) byte local147;
        @Pc(150) byte local150;
        @Pc(155) byte local155;
        @Pc(161) float local161;
        @Pc(167) float local167;
        @Pc(173) float local173;
        @Pc(178) int local178;
        @Pc(503) float local503;
        @Pc(508) int local508;
        @Pc(448) int local448;
        @Pc(464) Particle local464;
        @Pc(467) int local467;
        @Pc(480) byte local480;
        @Pc(485) byte local485;
        @Pc(497) float local497;
        if (arg0.aBoolean618) {
            for (local99 = arg1 - 1; local99 >= 0; local99--) {
                local117 = this.anIntArray74[local99] > 64 ? 64 : this.anIntArray74[local99];
                if (local117 > 0) {
                    for (local123 = local117 - 1; local123 >= 0; local123--) {
                        local134 = this.aParticleArrayArray1[local99][local123];
                        local137 = local134.anInt7539;
                        local142 = (byte) (local137 >> 16);
                        local147 = (byte) (local137 >> 8);
                        local150 = (byte) local137;
                        local155 = (byte) (local137 >>> 24);
                        local161 = (float) (local134.anInt7537 >> 12);
                        local167 = (float) (local134.anInt7534 >> 12);
                        local173 = (float) (local134.anInt7536 >> 12);
                        local178 = local134.anInt7535 >> 12;
                        this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(local161 + (float) -local178 * local54);
                        this.aClass2_Sub21_Sub1_1.method4336((float) -local178 * local58 + local167);
                        this.aClass2_Sub21_Sub1_1.method4336((float) -local178 * local62 + local173);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(local161 + (float) local178 * local66);
                        this.aClass2_Sub21_Sub1_1.method4336((float) local178 * local71 + local167);
                        this.aClass2_Sub21_Sub1_1.method4336(local173 + (float) local178 * local75);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(local54 * (float) local178 + local161);
                        this.aClass2_Sub21_Sub1_1.method4336(local167 + (float) local178 * local58);
                        this.aClass2_Sub21_Sub1_1.method4336(local173 + local62 * (float) local178);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4336(local80 * (float) local178 + local161);
                        this.aClass2_Sub21_Sub1_1.method4336(local167 + (float) local178 * local84);
                        this.aClass2_Sub21_Sub1_1.method4336(local173 + local88 * (float) local178);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                    }
                    if (this.anIntArray74[local99] > 64) {
                        local448 = this.anIntArray74[local99] - 64 - 1;
                        for (local137 = this.anIntArray76[local448] - 1; local137 >= 0; local137--) {
                            local464 = this.aParticle[local448][local137];
                            local467 = local464.anInt7539;
                            local150 = (byte) (local467 >> 16);
                            local155 = (byte) (local467 >> 8);
                            local480 = (byte) local467;
                            local485 = (byte) (local467 >>> 24);
                            local173 = (float) (local464.anInt7537 >> 12);
                            local497 = (float) (local464.anInt7534 >> 12);
                            local503 = (float) (local464.anInt7536 >> 12);
                            local508 = local464.anInt7535 >> 12;
                            this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4336((float) -local508 * local54 + local173);
                            this.aClass2_Sub21_Sub1_1.method4336(local58 * (float) -local508 + local497);
                            this.aClass2_Sub21_Sub1_1.method4336((float) -local508 * local62 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4336((float) local508 * local66 + local173);
                            this.aClass2_Sub21_Sub1_1.method4336(local497 + local71 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4336((float) local508 * local75 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(local173 + local54 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4336(local497 + local58 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4336(local62 * (float) local508 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4336(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4336(local173 + local80 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4336(local497 + (float) local508 * local84);
                            this.aClass2_Sub21_Sub1_1.method4336(local88 * (float) local508 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                        }
                    }
                }
            }
        } else {
            for (local99 = arg1 - 1; local99 >= 0; local99--) {
                local117 = this.anIntArray74[local99] <= 64 ? this.anIntArray74[local99] : 64;
                if (local117 > 0) {
                    for (local123 = local117 - 1; local123 >= 0; local123--) {
                        local134 = this.aParticleArrayArray1[local99][local123];
                        local137 = local134.anInt7539;
                        local142 = (byte) (local137 >> 16);
                        local147 = (byte) (local137 >> 8);
                        local150 = (byte) local137;
                        local155 = (byte) (local137 >>> 24);
                        local161 = (float) (local134.anInt7537 >> 12);
                        local167 = (float) (local134.anInt7534 >> 12);
                        local173 = (float) (local134.anInt7536 >> 12);
                        local178 = local134.anInt7535 >> 12;
                        this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(local54 * (float) -local178 + local161);
                        this.aClass2_Sub21_Sub1_1.method4337((float) -local178 * local58 + local167);
                        this.aClass2_Sub21_Sub1_1.method4337(local62 * (float) -local178 + local173);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(local66 * (float) local178 + local161);
                        this.aClass2_Sub21_Sub1_1.method4337(local167 + (float) local178 * local71);
                        this.aClass2_Sub21_Sub1_1.method4337(local173 + local75 * (float) local178);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(local54 * (float) local178 + local161);
                        this.aClass2_Sub21_Sub1_1.method4337((float) local178 * local58 + local167);
                        this.aClass2_Sub21_Sub1_1.method4337(local173 + (float) local178 * local62);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                        this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                        this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                        this.aClass2_Sub21_Sub1_1.method4337((float) local178 * local80 + local161);
                        this.aClass2_Sub21_Sub1_1.method4337(local167 + (float) local178 * local84);
                        this.aClass2_Sub21_Sub1_1.method4337((float) local178 * local88 + local173);
                        this.aClass2_Sub21_Sub1_1.p1(local142);
                        this.aClass2_Sub21_Sub1_1.p1(local147);
                        this.aClass2_Sub21_Sub1_1.p1(local150);
                        this.aClass2_Sub21_Sub1_1.p1(local155);
                    }
                    if (this.anIntArray74[local99] > 64) {
                        local448 = this.anIntArray74[local99] - 64 - 1;
                        for (local137 = this.anIntArray76[local448] - 1; local137 >= 0; local137--) {
                            local464 = this.aParticle[local448][local137];
                            local467 = local464.anInt7539;
                            local150 = (byte) (local467 >> 16);
                            local155 = (byte) (local467 >> 8);
                            local480 = (byte) local467;
                            local485 = (byte) (local467 >>> 24);
                            local173 = (float) (local464.anInt7537 >> 12);
                            local497 = (float) (local464.anInt7534 >> 12);
                            local503 = (float) (local464.anInt7536 >> 12);
                            local508 = local464.anInt7535 >> 12;
                            this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(local173 + local54 * (float) -local508);
                            this.aClass2_Sub21_Sub1_1.method4337(local58 * (float) -local508 + local497);
                            this.aClass2_Sub21_Sub1_1.method4337((float) -local508 * local62 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(local66 * (float) local508 + local173);
                            this.aClass2_Sub21_Sub1_1.method4337((float) local508 * local71 + local497);
                            this.aClass2_Sub21_Sub1_1.method4337(local75 * (float) local508 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(local173 + local54 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4337((float) local508 * local58 + local497);
                            this.aClass2_Sub21_Sub1_1.method4337((float) local508 * local62 + local503);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                            this.aClass2_Sub21_Sub1_1.method4337(0.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(1.0F);
                            this.aClass2_Sub21_Sub1_1.method4337(local173 + local80 * (float) local508);
                            this.aClass2_Sub21_Sub1_1.method4337(local84 * (float) local508 + local497);
                            this.aClass2_Sub21_Sub1_1.method4337(local503 + (float) local508 * local88);
                            this.aClass2_Sub21_Sub1_1.p1(local150);
                            this.aClass2_Sub21_Sub1_1.p1(local155);
                            this.aClass2_Sub21_Sub1_1.p1(local480);
                            this.aClass2_Sub21_Sub1_1.p1(local485);
                        }
                    }
                }
            }
        }
        if (this.aClass2_Sub21_Sub1_1.pos != 0) {
            this.anInterface12_1.method5002(this.aClass2_Sub21_Sub1_1.data, this.aClass2_Sub21_Sub1_1.pos, 24);
            arg0.method7039(this.aClass94_2, null, this.aClass94_1, this.aClass94_3);
            arg0.method6998(this.aClass2_Sub21_Sub1_1.pos / 24);
        }
    }

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "(ILclient!qha;)V")
    public void method1078(@OriginalArg(1) GlToolkit arg0) {
        arg0.method6972(true);
        OpenGL.glEnable(OpenGL.GL_LIGHT0);
        OpenGL.glEnable(OpenGL.GL_LIGHT1);
        if (arg0.aFloat149 != Static481.aFloat124) {
            arg0.xa(Static481.aFloat124);
        }
    }

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "(ILclient!qha;I)V")
    public void method1079(@OriginalArg(0) int arg0, @OriginalArg(1) GlToolkit arg1) {
        Static481.aFloat124 = arg1.aFloat149;
        arg1.method6964((float) arg0);
        arg1.method6978();
        OpenGL.glDisable(OpenGL.GL_LIGHT0);
        OpenGL.glDisable(OpenGL.GL_LIGHT1);
        arg1.method6972(false);
        OpenGL.glNormal3f(0.0F, -1.0F, 0.0F);
    }

    @OriginalMember(owner = "client!bj", name = "a", descriptor = "(Lclient!qha;Lclient!lk;IZ)V")
    public void method1080(@OriginalArg(0) GlToolkit arg0, @OriginalArg(1) ParticleList arg1, @OriginalArg(2) int arg2) {
        if (arg0.aClass73_Sub3_3 == null) {
            return;
        }
        if (arg2 >= 0) {
            this.method1079(arg2, arg0);
        } else {
            this.method1075(arg0);
        }
        @Pc(34) float local34 = arg0.aClass73_Sub3_3.aFloat155;
        @Pc(38) float local38 = arg0.aClass73_Sub3_3.aFloat151;
        @Pc(42) float local42 = arg0.aClass73_Sub3_3.aFloat154;
        @Pc(46) float local46 = arg0.aClass73_Sub3_3.aFloat159;
        try {
            @Pc(48) int local48 = 0;
            @Pc(50) int local50 = Integer.MAX_VALUE;
            @Pc(52) int local52 = 0;
            @Pc(56) Node2 local56 = arg1.particles.sentinel;
            @Pc(59) Node2 local59;
            @Pc(91) int local91;
            for (local59 = local56.next2; local59 != local56; local59 = local59.next2) {
                @Pc(64) Particle local64 = (Particle) local59;
                local91 = (int) (local46 + local42 * (float) (local64.anInt7536 >> 12) + (float) (local64.anInt7537 >> 12) * local34 + (float) (local64.anInt7534 >> 12) * local38);
                if (local91 > local52) {
                    local52 = local91;
                }
                this.anIntArray75[local48++] = local91;
                if (local50 > local91) {
                    local50 = local91;
                }
            }
            @Pc(118) int local118 = local52 - local50;
            if (local118 + 2 <= 1600) {
                local91 = 0;
                local118 += 2;
            } else {
                local91 = IntMath.countBits(local118) + 1 - this.anInt998;
                local118 = (local118 >> local91) + 2;
            }
            local48 = 0;
            local59 = local56.next2;
            @Pc(152) int local152 = -2;
            @Pc(154) boolean local154 = true;
            @Pc(156) boolean local156 = true;
            while (local59 != local56) {
                this.anInt1000 = 0;
                for (@Pc(165) int local165 = 0; local165 < local118; local165++) {
                    this.anIntArray74[local165] = 0;
                }
                for (@Pc(184) int local184 = 0; local184 < 64; local184++) {
                    this.anIntArray76[local184] = 0;
                }
                while (local59 != local56) {
                    @Pc(210) Particle local210 = (Particle) local59;
                    if (local156) {
                        local154 = local210.aBoolean574;
                        local152 = local210.anInt7540;
                        local156 = false;
                    }
                    if (local48 > 0 && (local210.anInt7540 != local152 || local210.aBoolean574 != local154)) {
                        local156 = true;
                        break;
                    }
                    @Pc(257) int local257 = this.anIntArray75[local48++] - local50 >> local91;
                    if (local257 < 1600) {
                        if (this.anIntArray74[local257] >= 64) {
                            label102:
                            {
                                if (this.anIntArray74[local257] == 64) {
                                    if (this.anInt1000 == 64) {
                                        break label102;
                                    }
                                    this.anIntArray74[local257] += this.anInt1000++ + 1;
                                }
                                this.aParticle[this.anIntArray74[local257] - 65][this.anIntArray76[this.anIntArray74[local257] - 64 - 1]++] = local210;
                            }
                        } else {
                            this.aParticleArrayArray1[local257][this.anIntArray74[local257]++] = local210;
                        }
                    }
                    local59 = local59.next2;
                }
                if (local152 >= 0) {
                    arg0.method7046(local152);
                } else {
                    arg0.method7046(-1);
                }
                if (local154 && Static481.aFloat124 != arg0.aFloat149) {
                    arg0.xa(Static481.aFloat124);
                } else if (arg0.aFloat149 != 1.0F) {
                    arg0.xa(1.0F);
                }
                this.method1077(arg0, local118);
            }
        } catch (@Pc(421) Exception local421) {
        }
        this.method1078(arg0);
    }

    @OriginalMember(owner = "client!bj", name = "b", descriptor = "(ILclient!qha;)V")
    public void method1081(@OriginalArg(1) GlToolkit arg0) {
        this.anInterface12_1 = arg0.method7024(true, 196584, null, 24);
        this.aClass94_3 = new Class94(this.anInterface12_1, 5126, 2, 0);
        this.aClass94_1 = new Class94(this.anInterface12_1, 5126, 3, 8);
        this.aClass94_2 = new Class94(this.anInterface12_1, 5121, 4, 20);
    }
}
