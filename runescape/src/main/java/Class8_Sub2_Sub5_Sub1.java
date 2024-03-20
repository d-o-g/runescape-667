import com.jagex.game.Animator;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.graphics.Ground;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sv")
public final class Class8_Sub2_Sub5_Sub1 extends Class8_Sub2_Sub5 {

    @OriginalMember(owner = "client!sv", name = "ib", descriptor = "I")
    public int anInt8867;

    @OriginalMember(owner = "client!sv", name = "cb", descriptor = "I")
    public int anInt8872;

    @OriginalMember(owner = "client!sv", name = "Q", descriptor = "I")
    public int anInt8873;

    @OriginalMember(owner = "client!sv", name = "S", descriptor = "I")
    public int anInt8874;

    @OriginalMember(owner = "client!sv", name = "db", descriptor = "I")
    public int anInt8876 = -1;

    @OriginalMember(owner = "client!sv", name = "X", descriptor = "Z")
    public boolean aBoolean672 = false;

    @OriginalMember(owner = "client!sv", name = "fb", descriptor = "I")
    public int anInt8879 = 0;

    @OriginalMember(owner = "client!sv", name = "kb", descriptor = "I")
    public int anInt8878 = -1;

    @OriginalMember(owner = "client!sv", name = "O", descriptor = "I")
    public int anInt8885 = 0;

    @OriginalMember(owner = "client!sv", name = "<init>", descriptor = "(IIIII)V")
    public Class8_Sub2_Sub5_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        super(arg0, arg1, arg2, arg3, arg4);
    }

    @OriginalMember(owner = "client!sv", name = "d", descriptor = "(B)I")
    @Override
    public int method9287() {
        @Pc(9) ObjType local9 = Static419.aObjTypeList_1.list(this.anInt8867);
        @Pc(12) int local12 = local9.picksizeshift;
        if (this.anInt8878 != -1) {
            @Pc(22) ObjType local22 = Static419.aObjTypeList_1.list(this.anInt8878);
            if (local22.picksizeshift > local12) {
                local12 = local22.picksizeshift;
            }
        }
        if (this.anInt8876 != -1) {
            @Pc(48) ObjType local48 = Static419.aObjTypeList_1.list(this.anInt8876);
            if (local48.picksizeshift > local12) {
                local12 = local48.picksizeshift;
            }
        }
        return local12;
    }

    @OriginalMember(owner = "client!sv", name = "h", descriptor = "(I)Z")
    @Override
    public boolean method9282(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.anInt8879 = -87;
        }
        return this.aBoolean672;
    }

    @OriginalMember(owner = "client!sv", name = "c", descriptor = "(B)I")
    @Override
    public int method9292(@OriginalArg(0) byte arg0) {
        return arg0 == -21 ? this.anInt8879 : -65;
    }

    @OriginalMember(owner = "client!sv", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 == -5) {
            ;
        }
    }

    @OriginalMember(owner = "client!sv", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 > -93) {
            this.method9278((Toolkit) null, 61);
        }
        return null;
    }

    @OriginalMember(owner = "client!sv", name = "k", descriptor = "(I)I")
    @Override
    public int method9286(@OriginalArg(0) int arg0) {
        return arg0 == 2 ? -10 : -14;
    }

    @OriginalMember(owner = "client!sv", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (arg2) {
            this.method9278((Toolkit) null, 104);
        }
        @Pc(16) Matrix local16 = arg3.scratchMatrix();
        local16.method7125(super.anInt10690, super.anInt10691 - 10, super.anInt10694);
        @Pc(32) ObjType local32 = Static419.aObjTypeList_1.list(this.anInt8867);
        @Pc(42) Model local42 = local32.model((Animator) null, 131072, (PlayerModel) null, this.anInt8873, arg3);
        if (local42 != null && (Static504.aBoolean579 ? local42.pickedOrtho(arg1, arg0, local16, true, local32.picksizeshift, Static582.anInt8627) : local42.picked(arg1, arg0, local16, true, local32.picksizeshift))) {
            return true;
        }
        @Pc(82) ObjType local82;
        if (this.anInt8878 != -1) {
            local82 = Static419.aObjTypeList_1.list(this.anInt8878);
            local42 = local82.model((Animator) null, 131072, (PlayerModel) null, this.anInt8874, arg3);
            if (local42 != null && (Static504.aBoolean579 ? local42.pickedOrtho(arg1, arg0, local16, true, local82.picksizeshift, Static582.anInt8627) : local42.picked(arg1, arg0, local16, true, local82.picksizeshift))) {
                return true;
            }
        }
        if (this.anInt8876 != -1) {
            local82 = Static419.aObjTypeList_1.list(this.anInt8876);
            local42 = local82.model((Animator) null, 131072, (PlayerModel) null, this.anInt8872, arg3);
            if (local42 != null && (Static504.aBoolean579 ? local42.pickedOrtho(arg1, arg0, local16, true, local82.picksizeshift, Static582.anInt8627) : local42.picked(arg1, arg0, local16, true, local82.picksizeshift))) {
                return true;
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!sv", name = "b", descriptor = "(B)Z")
    @Override
    public boolean method9283() {
        return false;
    }

    @OriginalMember(owner = "client!sv", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        @Pc(17) Class286 local17 = Static467.method6351(super.aByte144, super.anInt10690 >> Static52.anInt1066, super.anInt10694 >> Static52.anInt1066);
        @Pc(29) GroundDecor local29 = Static687.method8959(super.aByte144, super.anInt10690 >> Static52.anInt1066, super.anInt10694 >> Static52.anInt1066);
        @Pc(31) int local31 = 0;
        if (local17 != null && local17.aPositionEntity.aBoolean815) {
            local31 = local17.aPositionEntity.method9286(2);
        }
        if (local29 != null && -local31 < local29.aShort46) {
            local31 = -local29.aShort46;
        }
        if (local31 != this.anInt8885) {
            super.anInt10691 -= this.anInt8885;
            this.anInt8885 = local31;
            super.anInt10691 += local31;
        }
        @Pc(94) Matrix local94 = arg0.scratchMatrix();
        local94.makeIdentity();
        if (this.anInt8885 == 0) {
            @Pc(110) Ground local110 = Static246.activeGround[super.aByte143];
            @Pc(115) int local115 = this.anInt8879 << 1;
            @Pc(122) int local122 = -local115 / 2;
            @Pc(127) int local127 = -local115 / 2;
            @Pc(139) int local139 = local110.method7878(super.anInt10694 + local127, local122 + super.anInt10690);
            @Pc(143) int local143 = local115 / 2;
            @Pc(148) int local148 = -local115 / 2;
            @Pc(161) int local161 = local110.method7878(super.anInt10694 + local148, local143 + super.anInt10690);
            @Pc(166) int local166 = -local115 / 2;
            @Pc(170) int local170 = local115 / 2;
            @Pc(182) int local182 = local110.method7878(local170 + super.anInt10694, super.anInt10690 + local166);
            @Pc(186) int local186 = local115 / 2;
            @Pc(190) int local190 = local115 / 2;
            @Pc(203) int local203 = local110.method7878(super.anInt10694 + local190, local186 + super.anInt10690);
            @Pc(215) int local215 = local161 > local139 ? local139 : local161;
            @Pc(223) int local223 = local203 > local182 ? local182 : local203;
            @Pc(235) int local235 = local161 < local203 ? local161 : local203;
            @Pc(243) int local243 = local139 >= local182 ? local182 : local139;
            if (local115 != 0) {
                @Pc(259) int local259 = (int) (Math.atan2((double) (local215 - local223), (double) local115) * 2607.5945876176133D) & 0x3FFF;
                if (local259 != 0) {
                    local94.rotateAxisX(local259);
                }
            }
            if (local115 != 0) {
                @Pc(285) int local285 = (int) (Math.atan2((double) (local243 - local235), (double) local115) * 2607.5945876176133D) & 0x3FFF;
                if (local285 != 0) {
                    local94.rotateAxisZ(-local285);
                }
            }
            @Pc(297) int local297 = local203 + local139;
            if (local182 + local161 < local297) {
                local297 = local161 + local182;
            }
            local297 = (local297 >> 1) - super.anInt10691;
            if (local297 != 0) {
                local94.translate(0, local297, 0);
            }
        }
        local94.translate(super.anInt10690, super.anInt10691 - 10, super.anInt10694);
        @Pc(345) Class8_Sub7 local345 = Static642.method8441(true, 3);
        this.anInt8879 = 0;
        this.aBoolean672 = false;
        @Pc(369) Model local369;
        if (this.anInt8876 != -1) {
            local369 = Static419.aObjTypeList_1.list(this.anInt8876).model((Animator) null, 2048, (PlayerModel) null, this.anInt8872, arg0);
            if (local369 != null) {
                if (Static504.aBoolean579) {
                    local369.renderOrtho(local94, local345.aPickingCylinderArray1[2], Static582.anInt8627, 0);
                } else {
                    local369.render(local94, local345.aPickingCylinderArray1[2], 0);
                }
                this.aBoolean672 |= local369.F();
                this.anInt8879 = local369.ma();
            }
        }
        if (this.anInt8878 != -1) {
            local369 = Static419.aObjTypeList_1.list(this.anInt8878).model((Animator) null, 2048, (PlayerModel) null, this.anInt8874, arg0);
            if (local369 != null) {
                if (Static504.aBoolean579) {
                    local369.renderOrtho(local94, local345.aPickingCylinderArray1[1], Static582.anInt8627, 0);
                } else {
                    local369.render(local94, local345.aPickingCylinderArray1[1], 0);
                }
                this.aBoolean672 |= local369.F();
                if (local369.ma() > this.anInt8879) {
                    this.anInt8879 = local369.ma();
                }
            }
        }
        local369 = Static419.aObjTypeList_1.list(this.anInt8867).model((Animator) null, 2048, (PlayerModel) null, this.anInt8873, arg0);
        if (local369 != null) {
            if (Static504.aBoolean579) {
                local369.renderOrtho(local94, local345.aPickingCylinderArray1[0], Static582.anInt8627, 0);
            } else {
                local369.render(local94, local345.aPickingCylinderArray1[0], 0);
            }
            this.aBoolean672 |= local369.F();
            if (local369.ma() > this.anInt8879) {
                this.anInt8879 = local369.ma();
            }
        }
        return local345;
    }
}
