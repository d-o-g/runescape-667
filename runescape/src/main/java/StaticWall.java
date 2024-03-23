import com.jagex.core.stringtools.general.Base37;
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

@OriginalClass("client!jn")
public final class StaticWall extends Wall implements Location {

    @OriginalMember(owner = "client!jn", name = "T", descriptor = "Lclient!ke;")
    public Class205 aClass205_6;

    @OriginalMember(owner = "client!jn", name = "ib", descriptor = "Z")
    public final boolean aBoolean379;

    @OriginalMember(owner = "client!jn", name = "cb", descriptor = "S")
    public final short aShort60;

    @OriginalMember(owner = "client!jn", name = "U", descriptor = "B")
    public byte aByte88;

    @OriginalMember(owner = "client!jn", name = "L", descriptor = "Z")
    public final boolean aBoolean376;

    @OriginalMember(owner = "client!jn", name = "H", descriptor = "Z")
    public boolean aBoolean378;

    @OriginalMember(owner = "client!jn", name = "O", descriptor = "B")
    public byte aByte87;

    @OriginalMember(owner = "client!jn", name = "hb", descriptor = "Z")
    public final boolean aBoolean377;

    @OriginalMember(owner = "client!jn", name = "X", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!jn", name = "eb", descriptor = "Lclient!r;")
    public Shadow aClass2_Sub2_Sub9_4;

    private int arg0;

    @OriginalMember(owner = "client!jn", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIZ)V")
    public StaticWall(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) LocType arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) boolean arg10) {
        super(arg4, arg5, arg6, arg2, arg3, Static490.method6553(arg9, arg8));
        super.x = arg4;
        super.z = arg6;
        this.aBoolean379 = arg1.interactivity != LocInteractivity.NONINTERACTIVE && !arg7;
        this.aShort60 = (short) arg1.id;
        this.aByte88 = (byte) arg8;
        this.aBoolean376 = arg7;
        this.aBoolean378 = arg10;
        this.aByte87 = (byte) arg9;
        this.aBoolean377 = arg0.method8006() && arg1.hardShadow && !this.aBoolean376 && ClientOptions.instance.hardShadows.getValue() != 0;
        @Pc(77) int local77 = 2048;
        if (this.aBoolean378) {
            local77 |= 0x10000;
        }
        @Pc(92) ModelAndShadow local92 = this.method4475(arg0, local77, this.aBoolean377);
        if (local92 != null) {
            this.model = local92.model;
            this.aClass2_Sub2_Sub9_4 = local92.shadow;
            if (this.aBoolean378) {
                this.model = this.model.copy((byte) 0, local77, false);
                return;
            }
        }
    }

    @OriginalMember(owner = "client!jn", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method9283();
        }
        return this.aBoolean378;
    }

    @OriginalMember(owner = "client!jn", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 == 0) {
            return this.model == null ? false : this.model.F();
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(21) Shadow local21;
        if (this.aClass2_Sub2_Sub9_4 == null && this.aBoolean377) {
            @Pc(32) ModelAndShadow local32 = this.method4475(toolkit, 262144, true);
            local21 = local32 == null ? null : local32.shadow;
        } else {
            local21 = this.aClass2_Sub2_Sub9_4;
            this.aClass2_Sub2_Sub9_4 = null;
        }
        if (local21 != null) {
            Static630.method8357(local21, super.aByte143, super.x, super.z, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg6 instanceof StaticWall) {
            @Pc(34) StaticWall local34 = (StaticWall) arg6;
            if (this.model != null && local34.model != null) {
                this.model.method7481(local34.model, arg5, arg0, arg3, arg1);
            }
        } else if (arg6 instanceof StaticLocation) {
            @Pc(10) StaticLocation local10 = (StaticLocation) arg6;
            if (this.model != null && local10.model != null) {
                this.model.method7481(local10.model, arg5, arg0, arg3, arg1);
            }
        }
        if (arg4 < 101) {
            this.method9282(1);
        }
    }

    @OriginalMember(owner = "client!jn", name = "e", descriptor = "(I)Z")
    @Override
    public boolean castsShadow() {
        return this.aBoolean377;
    }

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!jn", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        this.arg0 = arg0;
        if (arg0 != 2) {
            Base37.encode((String) null);
        }
        return this.model == null ? 0 : this.model.fa();
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (this.aClass205_6 == null) {
            this.aClass205_6 = Static317.method4583(super.anInt10691, super.x, this.method4474(arg0, 0), super.z);
        }
        if (arg1 >= -93) {
            this.aClass205_6 = null;
        }
        return this.aClass205_6;
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;BI)Lclient!ka;")
    public Model method4474(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) int arg1) {
        if (this.model != null && arg0.compareFunctionMasks(this.model.ua(), arg1) == 0) {
            return this.model;
        } else {
            @Pc(37) ModelAndShadow local37 = this.method4475(arg0, arg1, false);
            return local37 == null ? null : local37.model;
        }
    }

    @OriginalMember(owner = "client!jn", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        this.aBoolean378 = false;
        if (this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
        if (arg0 != 27811) {
            this.aByte88 = -28;
        }
    }

    @OriginalMember(owner = "client!jn", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -42) {
            this.aClass205_6 = null;
        }
        @Pc(24) Shadow local24;
        if (this.aClass2_Sub2_Sub9_4 == null && this.aBoolean377) {
            @Pc(35) ModelAndShadow local35 = this.method4475(arg0, 262144, true);
            local24 = local35 == null ? null : local35.shadow;
        } else {
            local24 = this.aClass2_Sub2_Sub9_4;
            this.aClass2_Sub2_Sub9_4 = null;
        }
        if (local24 != null) {
            Static292.method4618(local24, super.aByte143, super.x, super.z, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return 49;
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(Lclient!ha;ZIZ)Lclient!od;")
    public ModelAndShadow method4475(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) int arg1, @OriginalArg(3) boolean arg2) {
        @Pc(11) LocType local11 = Static354.aLocTypeList_4.list(this.aShort60 & 0xFFFF);
        @Pc(27) Ground local27;
        @Pc(38) Ground local38;
        if (this.aBoolean376) {
            local27 = Static693.aGroundArray2[super.aByte143];
            local38 = Static706.aGroundArray3[0];
        } else {
            local27 = Static706.aGroundArray3[super.aByte143];
            if (super.aByte143 < 3) {
                local38 = Static706.aGroundArray3[super.aByte143 + 1];
            } else {
                local38 = null;
            }
        }
        return local11.modelAndShadow(this.aByte87, super.z, super.x, local27, arg2, super.anInt10691, this.aByte88, arg0, (LocTypeCustomisation) null, arg1, local38);
    }

    @OriginalMember(owner = "client!jn", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            this.aBoolean378 = true;
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        @Pc(9) Model local9 = this.method4474(arg3, 131072);
        if (local9 == null) {
            if (arg2) {
                this.aClass205_6 = null;
            }
            return false;
        } else {
            @Pc(14) Matrix local14 = arg3.scratchMatrix();
            local14.method7125(super.x, super.anInt10691, super.z);
            return Static504.aBoolean579 ? local9.pickedOrtho(arg1, arg0, local14, false, 0, Static582.anInt8627) : local9.picked(arg1, arg0, local14, false, 0);
        }
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.aShort60 & 0xFFFF;
    }

    @OriginalMember(owner = "client!jn", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.model == null) {
            return null;
        }
        @Pc(20) Matrix local20 = arg0.scratchMatrix();
        local20.method7125(super.x, super.anInt10691, super.z);
        @Pc(34) Class8_Sub7 local34 = Static642.method8441(this.aBoolean379, 1);
        if (Static504.aBoolean579) {
            this.model.renderOrtho(local20, local34.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            this.model.render(local20, local34.aPickingCylinderArray1[0], 0);
        }
        return local34;
    }

    @OriginalMember(owner = "client!jn", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return this.aByte88;
    }

    @OriginalMember(owner = "client!jn", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.aByte87;
    }
}
