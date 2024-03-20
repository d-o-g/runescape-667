import com.jagex.game.runetek6.config.loctype.LocInteractivity;
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

@OriginalClass("client!im")
public final class StaticWallDecor extends WallDecor implements Location {

    @OriginalMember(owner = "client!im", name = "lb", descriptor = "I")
    public static int lb = -1;

    @OriginalMember(owner = "client!im", name = "T", descriptor = "Lclient!ke;")
    public Class205 aClass205_4;

    @OriginalMember(owner = "client!im", name = "P", descriptor = "S")
    public final short aShort52;

    @OriginalMember(owner = "client!im", name = "ib", descriptor = "B")
    public byte aByte78;

    @OriginalMember(owner = "client!im", name = "jb", descriptor = "B")
    public byte aByte77;

    @OriginalMember(owner = "client!im", name = "K", descriptor = "Z")
    public final boolean aBoolean350;

    @OriginalMember(owner = "client!im", name = "Y", descriptor = "Z")
    public final boolean aBoolean348;

    @OriginalMember(owner = "client!im", name = "kb", descriptor = "Z")
    public final boolean aBoolean349;

    @OriginalMember(owner = "client!im", name = "M", descriptor = "Lclient!ka;")
    public Model aModel_3;

    @OriginalMember(owner = "client!im", name = "eb", descriptor = "Lclient!r;")
    public Shadow aClass2_Sub2_Sub9_2;

    @OriginalMember(owner = "client!im", name = "<init>", descriptor = "(Lclient!ha;Lclient!c;IIIIIZIIII)V")
    public StaticWallDecor(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) LocType arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
        super(arg4, arg5, arg6, arg2, arg3, arg8, arg9);
        super.anInt10694 = arg6;
        this.aShort52 = (short) arg1.id;
        this.aByte78 = (byte) arg11;
        super.anInt10690 = arg4;
        this.aByte77 = (byte) arg10;
        this.aBoolean350 = arg1.interactivity != LocInteractivity.NONINTERACTIVE && !arg7;
        this.aBoolean348 = arg7;
        this.aBoolean349 = arg0.method8006() && arg1.hardShadow && !this.aBoolean348 && Static400.instance.aClass57_Sub12_1.method4364() != 0;
        @Pc(81) ModelAndShadow local81 = this.method4045(arg0, 2048, this.aBoolean349);
        if (local81 != null) {
            this.aModel_3 = local81.model;
            this.aClass2_Sub2_Sub9_2 = local81.shadow;
        }
    }

    @OriginalMember(owner = "client!im", name = "c", descriptor = "(I)I")
    @Override
    public int method6855(@OriginalArg(0) int arg0) {
        if (arg0 != 23796) {
            this.method6858();
        }
        return this.aByte78;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IILclient!ha;)Lclient!ka;")
    public Model method4041(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1) {
        if (this.aModel_3 != null && arg1.compareFunctionMasks(this.aModel_3.ua(), arg0) == 0) {
            return this.aModel_3;
        } else {
            @Pc(35) ModelAndShadow local35 = this.method4045(arg1, arg0, false);
            return local35 == null ? null : local35.model;
        }
    }

    @OriginalMember(owner = "client!im", name = "d", descriptor = "(I)V")
    @Override
    public void method6856() {
        if (this.aModel_3 != null) {
            this.aModel_3.method7479();
        }
    }

    @OriginalMember(owner = "client!im", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        if (arg0 != 2) {
            this.aModel_3 = null;
        }
        return this.aModel_3 == null ? 0 : this.aModel_3.fa();
    }

    @OriginalMember(owner = "client!im", name = "e", descriptor = "(I)Z")
    @Override
    public boolean castsShadow(@OriginalArg(0) int arg0) {
        return arg0 == -19717 ? this.aBoolean349 : true;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (arg2) {
            this.method6857((Toolkit) null, 39);
        }
        @Pc(18) Model local18 = this.method4041(131072, arg3);
        if (local18 == null) {
            return false;
        } else {
            @Pc(23) Matrix local23 = arg3.scratchMatrix();
            local23.method7125(super.anInt10690, super.anInt10691, super.anInt10694);
            return Static504.aBoolean579 ? local18.pickedOrtho(arg1, arg0, local23, false, 0, Static582.anInt8627) : local18.picked(arg1, arg0, local23, false, 0);
        }
    }

    @OriginalMember(owner = "client!im", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -93) {
            this.method6855(-71);
        }
        if (this.aClass205_4 == null) {
            this.aClass205_4 = Static317.method4583(super.anInt10691, super.anInt10690, this.method4041(0, arg0), super.anInt10694);
        }
        return this.aClass205_4;
    }

    @OriginalMember(owner = "client!im", name = "b", descriptor = "(Lclient!ha;I)V")
    @Override
    public void addShadow(@OriginalArg(0) Toolkit arg0) {
        @Pc(37) Shadow local37;
        if (this.aClass2_Sub2_Sub9_2 == null && this.aBoolean349) {
            @Pc(29) ModelAndShadow local29 = this.method4045(arg0, 262144, true);
            local37 = local29 == null ? null : local29.shadow;
        } else {
            local37 = this.aClass2_Sub2_Sub9_2;
            this.aClass2_Sub2_Sub9_2 = null;
        }
        if (local37 != null) {
            Static630.method8357(local37, super.aByte143, super.anInt10690, super.anInt10694, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!im", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 != -5) {
            this.aByte78 = 89;
        }
    }

    @OriginalMember(owner = "client!im", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 == 0) {
            return this.aModel_3 == null ? false : this.aModel_3.F();
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method6857(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        @Pc(28) Shadow local28;
        if (this.aClass2_Sub2_Sub9_2 == null && this.aBoolean349) {
            @Pc(20) ModelAndShadow local20 = this.method4045(arg0, 262144, true);
            local28 = local20 == null ? null : local20.shadow;
        } else {
            local28 = this.aClass2_Sub2_Sub9_2;
            this.aClass2_Sub2_Sub9_2 = null;
        }
        if (arg1 < -42 && local28 != null) {
            Static292.method4618(local28, super.aByte143, super.anInt10690, super.anInt10694, (boolean[]) null);
        }
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(I)I")
    @Override
    public int getId(@OriginalArg(0) int arg0) {
        return arg0 == -32136 ? this.aShort52 & 0xFFFF : 109;
    }

    @OriginalMember(owner = "client!im", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        if (this.aModel_3 == null) {
            return true;
        } else {
            return !this.aModel_3.r();
        }
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(BLclient!ha;IZ)Lclient!od;")
    public ModelAndShadow method4045(@OriginalArg(1) Toolkit arg0, @OriginalArg(2) int arg1, @OriginalArg(3) boolean arg2) {
        @Pc(17) LocType local17 = Static354.aLocTypeList_4.list(this.aShort52 & 0xFFFF);
        @Pc(29) Ground local29;
        @Pc(24) Ground local24;
        if (this.aBoolean348) {
            local24 = Static706.aGroundArray3[0];
            local29 = Static693.aGroundArray2[super.aByte143];
        } else {
            local29 = Static706.aGroundArray3[super.aByte143];
            if (super.aByte143 < 3) {
                local24 = Static706.aGroundArray3[super.aByte143 + 1];
            } else {
                local24 = null;
            }
        }
        return local17.modelAndShadow(this.aByte78, super.anInt10694, super.anInt10690, local29, arg2, super.anInt10691, this.aByte77, arg0, (LocTypeCustomisation) null, arg1, local24);
    }

    @OriginalMember(owner = "client!im", name = "b", descriptor = "(I)I")
    @Override
    public int method6858() {
        return this.aByte77;
    }

    @OriginalMember(owner = "client!im", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.aModel_3 == null) {
            return null;
        }
        @Pc(12) Matrix local12 = arg0.scratchMatrix();
        local12.method7125(super.anInt10690 + super.aShort101, super.anInt10691, super.aShort102 + super.anInt10694);
        @Pc(41) Class8_Sub7 local41 = Static642.method8441(this.aBoolean350, 1);
        if (Static504.aBoolean579) {
            this.aModel_3.renderOrtho(local12, local41.aPickingCylinderArray1[0], Static582.anInt8627, 0);
        } else {
            this.aModel_3.render(local12, local41.aPickingCylinderArray1[0], 0);
        }
        return local41;
    }

    @OriginalMember(owner = "client!im", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        if (arg0 != -21) {
            this.aByte77 = 110;
        }
        return this.aModel_3 == null ? 0 : this.aModel_3.ma();
    }
}
