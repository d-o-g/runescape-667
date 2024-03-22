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

@OriginalClass("client!cu")
public final class StaticGroundDecor extends GroundDecor implements Location {

    @OriginalMember(owner = "client!cu", name = "fb", descriptor = "Lclient!ke;")
    public Class205 aClass205_1;

    @OriginalMember(owner = "client!cu", name = "W", descriptor = "S")
    public short aShort20;

    @OriginalMember(owner = "client!cu", name = "F", descriptor = "B")
    public byte aByte38;

    @OriginalMember(owner = "client!cu", name = "jb", descriptor = "Z")
    public final boolean aBoolean182;

    @OriginalMember(owner = "client!cu", name = "ab", descriptor = "Z")
    public final boolean aBoolean183;

    @OriginalMember(owner = "client!cu", name = "U", descriptor = "Z")
    public boolean aBoolean180;

    @OriginalMember(owner = "client!cu", name = "S", descriptor = "Z")
    public boolean aBoolean181;

    @OriginalMember(owner = "client!cu", name = "R", descriptor = "Lclient!r;")
    public Shadow aClass2_Sub2_Sub9_1;

    @OriginalMember(owner = "client!cu", name = "bb", descriptor = "Lclient!ka;")
    public Model model;

    @OriginalMember(owner = "client!cu", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIZ)V")
    public StaticGroundDecor(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) LocType arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) boolean arg9) {
        super(arg4, arg5, arg6, arg2, arg3, arg1.anInt1227);
        this.aShort20 = (short) arg1.id;
        super.z = arg6;
        this.aByte38 = (byte) arg8;
        this.aBoolean182 = arg1.interactivity != LocInteractivity.NONINTERACTIVE && !arg7;
        super.x = arg4;
        this.aBoolean183 = arg7;
        this.aBoolean180 = arg9;
        this.aBoolean181 = arg0.method8006() && arg1.hardShadow && !this.aBoolean183 && Static400.instance.aClass57_Sub12_1.method4364() != 0;
        @Pc(68) int local68 = 2048;
        if (this.aBoolean180) {
            local68 |= 0x10000;
        }
        @Pc(83) ModelAndShadow local83 = this.method1831(local68, 20, arg0, this.aBoolean181);
        if (local83 != null) {
            this.aClass2_Sub2_Sub9_1 = local83.shadow;
            this.model = local83.model;
            if (this.aBoolean180) {
                this.model = this.model.copy((byte) 0, local68, false);
                return;
            }
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        if (this.model == null) {
            return true;
        } else {
            return !this.model.r();
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.model == null) {
            return null;
        }
        @Pc(20) Matrix local20 = arg0.scratchMatrix();
        local20.method7125(super.x, super.anInt10691, super.z);
        @Pc(34) Class8_Sub7 local34 = Static642.method8441(this.aBoolean182, 1);
        if (Static504.aBoolean579) {
            this.model.renderOrtho(local20, local34.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            this.model.render(local20, local34.aPickingCylinderArray1[0], 0);
        }
        return local34;
    }

    @OriginalMember(owner = "client!cu", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        if (arg0 == 2) {
            return this.model == null ? 0 : this.model.fa();
        } else {
            return 14;
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg4 <= 101) {
            this.method1831(-126, -84, (Toolkit) null, false);
        }
        if (!(arg6 instanceof StaticGroundDecor)) {
            return;
        }
        @Pc(21) StaticGroundDecor local21 = (StaticGroundDecor) arg6;
        if (this.model != null && local21.model != null) {
            this.model.method7481(local21.model, arg5, arg0, arg3, arg1);
            return;
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (arg2) {
            NativeLibraryList.signLink = null;
        }
        @Pc(16) Model local16 = this.method1834(arg3, 131072);
        if (local16 == null) {
            return false;
        } else {
            @Pc(21) Matrix local21 = arg3.scratchMatrix();
            local21.method7125(super.x, super.anInt10691, super.z);
            return Static504.aBoolean579 ? local16.pickedOrtho(arg1, arg0, local21, false, 0, Static582.anInt8627) : local16.picked(arg1, arg0, local21, false, 0);
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit toolkit) {
        @Pc(33) Shadow local33;
        if (this.aClass2_Sub2_Sub9_1 == null && this.aBoolean181) {
            @Pc(25) ModelAndShadow local25 = this.method1831(262144, 20, toolkit, true);
            local33 = local25 == null ? null : local25.shadow;
        } else {
            local33 = this.aClass2_Sub2_Sub9_1;
            this.aClass2_Sub2_Sub9_1 = null;
        }
        if (local33 != null) {
            Static630.method8357(local33, super.aByte143, super.x, super.z, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(IILclient!ha;Z)Lclient!od;")
    public ModelAndShadow method1831(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) boolean arg3) {
        @Pc(13) LocType local13 = Static354.aLocTypeList_4.list(this.aShort20 & 0xFFFF);
        if (arg1 != 20) {
            this.aShort20 = -113;
        }
        @Pc(29) Ground local29;
        @Pc(35) Ground local35;
        if (this.aBoolean183) {
            local29 = Static693.aGroundArray2[super.aByte143];
            local35 = Static706.aGroundArray3[0];
        } else {
            local29 = Static706.aGroundArray3[super.aByte143];
            if (super.aByte143 >= 3) {
                local35 = null;
            } else {
                local35 = Static706.aGroundArray3[super.aByte143 + 1];
            }
        }
        return local13.modelAndShadow(this.aByte38, super.z, super.x, local29, arg3, super.anInt10691, 22, arg2, (LocTypeCustomisation) null, arg0, local35);
    }

    @OriginalMember(owner = "client!cu", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.aByte38 = 33;
        }
        return this.model == null ? false : this.model.F();
    }

    @OriginalMember(owner = "client!cu", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method6856();
        }
        return this.aBoolean180;
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (this.aClass205_1 == null) {
            this.aClass205_1 = Static317.method4583(super.anInt10691, super.x, this.method1834(arg0, 0), super.z);
        }
        if (arg1 >= -93) {
            this.aClass205_1 = null;
        }
        return this.aClass205_1;
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(I)I")
    @Override
    public int getRotation() {
        return this.aByte38;
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void removeShadow(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -42) {
            this.getId();
        }
        @Pc(25) Shadow local25;
        if (this.aClass2_Sub2_Sub9_1 == null && this.aBoolean181) {
            @Pc(36) ModelAndShadow local36 = this.method1831(262144, 20, arg0, true);
            local25 = local36 == null ? null : local36.shadow;
        } else {
            local25 = this.aClass2_Sub2_Sub9_1;
            this.aClass2_Sub2_Sub9_1 = null;
        }
        if (local25 != null) {
            Static292.method4618(local25, super.aByte143, super.x, super.z, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!cu", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        this.aBoolean180 = false;
        if (arg0 == 27811 && this.model != null) {
            this.model.s(this.model.ua() & 0xFFFEFFFF);
        }
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(I)I")
    @Override
    public int getId() {
        return this.aShort20 & 0xFFFF;
    }

    @OriginalMember(owner = "client!cu", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.model != null) {
            this.model.method7479();
        }
    }

    @OriginalMember(owner = "client!cu", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            NativeLibraryList.signLink = null;
        }
    }

    @OriginalMember(owner = "client!cu", name = "b", descriptor = "(I)I")
    @Override
    public int getShape() {
        return 22;
    }

    @OriginalMember(owner = "client!cu", name = "e", descriptor = "(I)Z")
    @Override
    public boolean castsShadow() {
        return this.aBoolean181;
    }

    @OriginalMember(owner = "client!cu", name = "a", descriptor = "(ILclient!ha;I)Lclient!ka;")
    public Model method1834(@OriginalArg(1) Toolkit arg0, @OriginalArg(2) int arg1) {
        if (this.model != null && arg0.compareFunctionMasks(this.model.ua(), arg1) == 0) {
            return this.model;
        } else {
            @Pc(26) ModelAndShadow local26 = this.method1831(arg1, 20, arg0, false);
            return local26 == null ? null : local26.model;
        }
    }

    @OriginalMember(owner = "client!cu", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 == -21) {
            return this.model == null ? 0 : this.model.ma();
        } else {
            return -86;
        }
    }
}
