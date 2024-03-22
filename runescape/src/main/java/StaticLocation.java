import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.ModelAndShadow;
import com.jagex.graphics.Shadow;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jda")
public final class StaticLocation extends PositionEntity implements Location {

    @OriginalMember(owner = "client!jda", name = "U", descriptor = "Lclient!ke;")
    public Class205 aClass205_5;

    @OriginalMember(owner = "client!jda", name = "nb", descriptor = "Z")
    public final boolean aBoolean364;

    @OriginalMember(owner = "client!jda", name = "Q", descriptor = "Z")
    public final boolean aBoolean363;

    @OriginalMember(owner = "client!jda", name = "cb", descriptor = "B")
    public final byte aByte83;

    @OriginalMember(owner = "client!jda", name = "db", descriptor = "S")
    public final short aShort57;

    @OriginalMember(owner = "client!jda", name = "Y", descriptor = "B")
    public final byte aByte84;

    @OriginalMember(owner = "client!jda", name = "pb", descriptor = "Z")
    public boolean aBoolean365;

    @OriginalMember(owner = "client!jda", name = "ib", descriptor = "Z")
    public final boolean castsShadow;

    @OriginalMember(owner = "client!jda", name = "gb", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!jda", name = "eb", descriptor = "Lclient!r;")
    public Shadow shadow;

    @OriginalMember(owner = "client!jda", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIIIIIZ)V")
    public StaticLocation(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) LocType arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13, @OriginalArg(14) boolean arg14) {
        super(arg2, arg3, arg4, arg5, arg6, arg8, arg9, arg10, arg11, arg1.lb == 1, Static194.method2904(arg12, arg13));
        this.aBoolean364 = arg1.interactivity != LocInteractivity.NONINTERACTIVE && !arg7;
        this.aBoolean363 = arg7;
        this.aByte83 = (byte) arg13;
        this.aShort57 = (short) arg1.id;
        this.aByte84 = (byte) arg12;
        super.aByte143 = (byte) arg3;
        this.aBoolean365 = arg14;
        this.castsShadow = arg0.method8006() && arg1.hardShadow && !this.aBoolean363 && Static400.instance.aClass57_Sub12_1.method4364() != 0;
        @Pc(83) int local83 = 2048;
        if (this.aBoolean365) {
            local83 |= 0x10000;
        }
        @Pc(98) ModelAndShadow local98 = this.method4223(arg0, this.castsShadow, local83);
        if (local98 != null) {
            this.model = local98.model;
            this.shadow = local98.shadow;
            if (this.aBoolean365) {
                this.model = this.model.copy((byte) 0, local83, false);
                return;
            }
        }
    }

    @OriginalMember(owner = "client!jda", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        @Pc(16) Shadow local16;
        if (this.shadow == null && this.castsShadow) {
            @Pc(27) ModelAndShadow local27 = this.method4223(arg0, true, 262144);
            local16 = local27 == null ? null : local27.shadow;
        } else {
            local16 = this.shadow;
            this.shadow = null;
        }
        if (local16 != null) {
            Static292.method4618(local16, super.aByte143, super.x, super.z, (boolean[]) null);
        }
        if (arg1 > -42) {
            this.model = null;
        }
    }

    @OriginalMember(owner = "client!jda", name = "e", descriptor = "(I)Z")
    @Override
    public boolean castsShadow() {
        return this.castsShadow;
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!jda", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.method9283();
        }
        return this.model == null ? 0 : this.model.fa();
    }

    @OriginalMember(owner = "client!jda", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method9280(61);
        }
        return this.aBoolean365;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(BLclient!ha;I)Lclient!ka;")
    public Model method4221(@OriginalArg(1) Toolkit arg0, @OriginalArg(2) int arg1) {
        if (this.model != null && arg0.compareFunctionMasks(this.model.ua(), arg1) == 0) {
            return this.model;
        } else {
            @Pc(34) ModelAndShadow local34 = this.method4223(arg0, false, arg1);
            return local34 == null ? null : local34.model;
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.aShort57 & 0xFFFF;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        @Pc(9) Model local9 = this.method4221(arg3, 131072);
        if (local9 == null) {
            return arg2 ? false : false;
        } else {
            @Pc(14) Matrix local14 = arg3.scratchMatrix();
            local14.method7125(super.x, super.anInt10691, super.z);
            return Static504.aBoolean579 ? local9.pickedOrtho(arg1, arg0, local14, false, 0, Static582.anInt8627) : local9.picked(arg1, arg0, local14, false, 0);
        }
    }

    @OriginalMember(owner = "client!jda", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        this.aBoolean365 = false;
        if (arg0 != 27811) {
            this.aClass205_5 = null;
        }
        if (this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return this.aByte84;
    }

    @OriginalMember(owner = "client!jda", name = "m", descriptor = "(I)I")
    public int method4222() {
        return this.model == null ? 15 : this.model.na() / 4;
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 > -93) {
            return null;
        } else {
            if (this.aClass205_5 == null) {
                this.aClass205_5 = Static317.method4583(super.anInt10691, super.x, this.method4221(arg0, 0), super.z);
            }
            return this.aClass205_5;
        }
    }

    @OriginalMember(owner = "client!jda", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(21) Shadow shadow;
        if (this.shadow == null && this.castsShadow) {
            @Pc(32) ModelAndShadow modelAndShadow = this.method4223(toolkit, true, 262144);
            shadow = modelAndShadow == null ? null : modelAndShadow.shadow;
        } else {
            shadow = this.shadow;
            this.shadow = null;
        }
        if (shadow != null) {
            Static630.method8357(shadow, super.aByte143, super.x, super.z, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return -59;
        }
    }

    @OriginalMember(owner = "client!jda", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 == -5) {
            ;
        }
    }

    @OriginalMember(owner = "client!jda", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.shadow = null;
        }
        return this.model == null ? false : this.model.F();
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.model == null) {
            return null;
        }
        @Pc(20) Matrix local20 = arg0.scratchMatrix();
        local20.method7125(super.x, super.anInt10691, super.z);
        @Pc(34) Class8_Sub7 local34 = Static642.method8441(this.aBoolean364, 1);
        if (Static504.aBoolean579) {
            this.model.renderOrtho(local20, local34.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            this.model.render(local20, local34.aPickingCylinderArray1[0], 0);
        }
        return local34;
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg6 instanceof StaticWall) {
            @Pc(38) StaticWall local38 = (StaticWall) arg6;
            if (this.model != null && local38.model != null) {
                this.model.method7481(local38.model, arg5, arg0, arg3, arg1);
            }
        } else if (arg6 instanceof StaticLocation) {
            @Pc(14) StaticLocation local14 = (StaticLocation) arg6;
            if (this.model != null && local14.model != null) {
                this.model.method7481(local14.model, arg5, arg0, arg3, arg1);
            }
        }
        if (arg4 <= 101) {
            this.method9278((Toolkit) null, -1);
        }
    }

    @OriginalMember(owner = "client!jda", name = "a", descriptor = "(Lclient!ha;BZI)Lclient!od;")
    public ModelAndShadow method4223(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2) {
        @Pc(11) LocType local11 = Static354.aLocTypeList_4.list(this.aShort57 & 0xFFFF);
        @Pc(27) Ground local27;
        @Pc(33) Ground local33;
        if (this.aBoolean363) {
            local27 = Static693.aGroundArray2[super.aByte143];
            local33 = Static706.aGroundArray3[0];
        } else {
            local27 = Static706.aGroundArray3[super.aByte143];
            if (super.aByte143 >= 3) {
                local33 = null;
            } else {
                local33 = Static706.aGroundArray3[super.aByte143 + 1];
            }
        }
        return local11.modelAndShadow(this.aByte84 == 11 ? this.aByte83 + 4 : this.aByte83, super.z, super.x, local27, arg1, super.anInt10691, this.aByte84 == 11 ? 10 : this.aByte84, arg0, (LocTypeCustomisation) null, arg2, local33);
    }

    @OriginalMember(owner = "client!jda", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.aByte83;
    }
}
