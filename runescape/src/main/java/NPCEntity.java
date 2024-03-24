import com.jagex.ParticleList;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!wj")
public final class NPCEntity extends Class8_Sub2_Sub1_Sub2 {

    @OriginalMember(owner = "client!wj", name = "Qc", descriptor = "Ljava/lang/String;")
    public String aString128;

    @OriginalMember(owner = "client!wj", name = "Gc", descriptor = "Lclient!vk;")
    public NPCTypeCustomisation aNPCTypeCustomisation_1;

    @OriginalMember(owner = "client!wj", name = "Yc", descriptor = "Lclient!o;")
    public NPCType type;

    @OriginalMember(owner = "client!wj", name = "Sc", descriptor = "I")
    public int combatLevel;

    @OriginalMember(owner = "client!wj", name = "ad", descriptor = "I")
    public int anInt10774 = -1;

    @OriginalMember(owner = "client!wj", name = "fd", descriptor = "I")
    public int anInt10767 = -1;

    @OriginalMember(owner = "client!wj", name = "Jc", descriptor = "I")
    public int anInt10788 = 1;

    @OriginalMember(owner = "client!wj", name = "Dc", descriptor = "I")
    public int anInt10790 = 1;

    @OriginalMember(owner = "client!wj", name = "<init>", descriptor = "()V")
    public NPCEntity() {
    }

    @OriginalMember(owner = "client!wj", name = "<init>", descriptor = "(I)V")
    public NPCEntity(@OriginalArg(0) int arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!pla", name = "a", descriptor = "(ILclient!wj;)I")
    public static int currentSound(@OriginalArg(1) NPCEntity arg0) {
        @Pc(6) NPCType local6 = arg0.type;
        if (local6.multinpcs != null) {
            local6 = local6.getMultiNPC(TimedVarDomain.instance);
            if (local6 == null) {
                return -1;
            }
        }
        @Pc(22) int local22 = local6.walkSound;
        @Pc(32) BASType local32 = arg0.method9317();
        @Pc(37) int local37 = arg0.animator.getAnimationId();
        if (local37 == -1 || arg0.ready) {
            local22 = local6.readySound;
        } else if (local32.run == local37 || local32.runFollowTurn180 == local37 || local32.runFollowTurnCw == local37 || local37 == local32.runFollowTurnCcw) {
            local22 = local6.runSound;
        } else if (local32.crawl == local37 || local37 == local32.crawlFollowTurn180 || local32.crawlFollowTurnCw == local37 || local32.crawlFollowTurnCcw == local37) {
            local22 = local6.crawlSound;
        }
        return local22;
    }

    @OriginalMember(owner = "client!wj", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!wj", name = "j", descriptor = "(B)Z")
    public boolean method9322() {
        return this.type != null;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg4 <= 101) {
            Static712.method9329((byte) 99);
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (this.type == null || !this.method9324(131072, arg3)) {
            return false;
        }
        @Pc(20) Matrix local20 = arg3.scratchMatrix();
        @Pc(25) int local25 = super.aClass126_7.method2673(16383);
        local20.rotate(local25);
        local20.translate(super.x, super.anInt10691, super.z);
        @Pc(38) boolean local38 = arg2;
        for (@Pc(40) int local40 = 0; local40 < super.aModelArray3.length; local40++) {
            if (super.aModelArray3[local40] != null) {
                @Pc(71) boolean var10000;
                label50:
                {
                    if (this.type.pickSizeShift <= 0) {
                        label48:
                        {
                            if (this.type.anInt6706 == -1) {
                                if (this.type.size == 1) {
                                    break label48;
                                }
                                var10000 = false;
                            } else {
                                if (this.type.anInt6706 == 1) {
                                    break label48;
                                }
                                var10000 = false;
                            }
                            if (!var10000) {
                                var10000 = false;
                                break label50;
                            }
                        }
                    }
                    var10000 = true;
                }
                @Pc(89) boolean local89 = var10000;
                @Pc(105) boolean local105;
                if (Static504.aBoolean579) {
                    local105 = super.aModelArray3[local40].pickedOrtho(arg1, arg0, local20, local89, this.type.pickSizeShift, Static582.anInt8627);
                } else {
                    local105 = super.aModelArray3[local40].picked(arg1, arg0, local20, local89, this.type.pickSizeShift);
                }
                if (local105) {
                    local38 = true;
                    break;
                }
            }
        }
        for (@Pc(136) int local136 = 0; local136 < super.aModelArray3.length; local136++) {
            super.aModelArray3[local136] = null;
        }
        return local38;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.type == null || !this.method9324(2048, arg0)) {
            return null;
        }
        @Pc(22) Matrix local22 = arg0.scratchMatrix();
        @Pc(27) int local27 = super.aClass126_7.method2673(16383);
        local22.rotate(local27);
        @Pc(45) Class291 local45 = Static334.activeTiles[super.level][super.x >> Static52.anInt1066][super.z >> Static52.anInt1066];
        if (local45 == null || local45.aGroundDecor_1 == null) {
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) super.anInt10732 / 10.0F);
        } else {
            @Pc(75) int local75 = super.anInt10732 - local45.aGroundDecor_1.aShort46;
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) local75 / 10.0F);
        }
        local22.translate(super.x, -super.anInt10732 + super.anInt10691 - 20, super.z);
        @Pc(104) BASType local104 = this.method9317();
        @Pc(118) NPCType local118 = this.type.multinpcs == null ? this.type : this.type.getMultiNPC(TimedVarDomain.instance);
        super.aBoolean819 = false;
        @Pc(123) Class8_Sub7 local123 = null;
        if (ClientOptions.instance.spotShadows.getValue() == 1 && local118.hasShadow && local104.animateShadow) {
            @Pc(159) Animator local159 = super.aAnimator_11.isAnimating() && super.aAnimator_11.isDelayed() ? super.aAnimator_11 : null;
            @Pc(179) Animator local179 = super.animator.isAnimating() && (!super.ready || local159 == null) ? super.animator : null;
            @Pc(223) Model local223 = Static618.method8320(this.type.shadowInnerAlpha & 0xFF, super.aModelArray3[0], super.anInt10742, this.type.shadowInnerColour & 0xFFFF, super.anInt10716, this.type.size, arg0, this.type.shadowOuterAlpha & 0xFF, local179 == null ? local159 : local179, super.anInt10746, local27, this.type.shadowOuterColour & 0xFFFF);
            if (local223 != null) {
                local123 = Static642.method8441(this.method9330(), super.aModelArray3.length + 1);
                super.aBoolean819 = true;
                arg0.C(false);
                if (Static504.aBoolean579) {
                    local223.renderOrtho(local22, local123.aPickingCylinderArray1[super.aModelArray3.length], Static582.anInt8627, 0);
                } else {
                    local223.render(local22, local123.aPickingCylinderArray1[super.aModelArray3.length], 0);
                }
                arg0.C(true);
            }
        }
        local22.rotate(local27);
        local22.translate(super.x, -super.anInt10732 + super.anInt10691 - 5, super.z);
        if (local123 == null) {
            local123 = Static642.method8441(this.method9330(), super.aModelArray3.length);
        }
        this.method9319(arg0, false, super.aModelArray3, local22);
        @Pc(314) int local314;
        if (Static504.aBoolean579) {
            for (local314 = 0; local314 < super.aModelArray3.length; local314++) {
                if (super.aModelArray3[local314] != null) {
                    super.aModelArray3[local314].renderOrtho(local22, local123.aPickingCylinderArray1[local314], Static582.anInt8627, 0);
                }
            }
        } else {
            for (local314 = 0; local314 < super.aModelArray3.length; local314++) {
                if (super.aModelArray3[local314] != null) {
                    super.aModelArray3[local314].render(local22, local123.aPickingCylinderArray1[local314], 0);
                }
            }
        }
        if (super.aClass8_Sub5_8 != null) {
            @Pc(394) ParticleList local394 = super.aClass8_Sub5_8.method3645();
            if (Static504.aBoolean579) {
                arg0.method7967(local394, Static582.anInt8627);
            } else {
                arg0.method8021(local394);
            }
        }
        for (@Pc(419) int local419 = 0; local419 < super.aModelArray3.length; local419++) {
            if (super.aModelArray3[local419] != null) {
                super.aBoolean819 |= super.aModelArray3[local419].F();
            }
            super.aModelArray3[local419] = null;
        }
        super.anInt10704 = Static198.anInt3276;
        return local123;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IZLclient!ha;)Z")
    public boolean method9324(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(5) int local5 = arg0;
        @Pc(9) BASType local9 = this.method9317();
        @Pc(27) Animator local27 = super.aAnimator_11.isAnimating() && !super.aAnimator_11.isDelayed() ? super.aAnimator_11 : null;
        @Pc(47) Animator local47 = super.animator.isAnimating() && (!super.ready || local27 == null) ? super.animator : null;
        @Pc(50) int local50 = local9.hillWidth;
        @Pc(53) int local53 = local9.hillHeight;
        if (local50 != 0 || local53 != 0 || local9.rollTargetAngle != 0 || local9.pitchTargetAngle != 0) {
            arg0 |= 0x7;
        }
        @Pc(100) boolean local100 = super.aByte149 != 0 && super.anInt10760 <= TimeUtils.clock && TimeUtils.clock < super.anInt10752;
        if (local100) {
            arg0 |= 0x80000;
        }
        @Pc(111) int local111 = super.aClass126_7.method2673(16383);
        @Pc(134) Model local134 = super.aModelArray3[0] = this.type.getModel(TimedVarDomain.instance, arg1, BASTypeList.instance, local27, local111, super.anIntArray877, this.aNPCTypeCustomisation_1, local47, arg0, super.aClass152_Sub2_Sub1Array3);
        if (local134 == null) {
            return false;
        }
        super.anInt10748 = local134.fa();
        super.anInt10728 = local134.ma();
        this.method9306(local134);
        if (local50 == 0 && local53 == 0) {
            this.method9314(local111, 0, 0, this.boundSize((byte) 116) << 9, this.boundSize((byte) 79) << 9, -86);
        } else {
            this.method9314(local111, local9.hillMaxAngleX, local9.hillMaxAngleY, local50, local53, -119);
            if (super.anInt10746 != 0) {
                super.aModelArray3[0].FA(super.anInt10746);
            }
            if (super.anInt10742 != 0) {
                super.aModelArray3[0].VA(super.anInt10742);
            }
            if (super.anInt10716 != 0) {
                super.aModelArray3[0].H(0, super.anInt10716, 0);
            }
        }
        if (local100) {
            local134.adjustColours(super.aByte150, super.aByte147, super.aByte148, super.aByte149 & 0xFF);
        }
        this.method9297(local5, local53, arg1, local9, local111, local50);
        return true;
    }

    @OriginalMember(owner = "client!wj", name = "f", descriptor = "(B)I")
    @Override
    public int method9299() {
        if (this.type.multinpcs != null) {
            @Pc(19) NPCType local19 = this.type.getMultiNPC(TimedVarDomain.instance);
            if (local19 != null && local19.height != -1) {
                return local19.height;
            }
        }
        return this.type.height == -1 ? super.method9299() : this.type.height;
    }

    @OriginalMember(owner = "client!wj", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= -93) {
            this.method9320(98);
        }
        return null;
    }

    @OriginalMember(owner = "client!wj", name = "d", descriptor = "(I)Lclient!dj;")
    @Override
    public Class80 method9318(@OriginalArg(0) int arg0) {
        if (arg0 == -3109) {
            return super.aClass80_3 != null && super.aClass80_3.aString20 == null ? null : super.aClass80_3;
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!wj", name = "e", descriptor = "(B)Z")
    @Override
    public boolean method9311() {
        return Static523.graphicsDefaults.npcShouldDisplayChat;
    }

    @OriginalMember(owner = "client!wj", name = "h", descriptor = "(B)I")
    @Override
    public int method9304(@OriginalArg(0) byte arg0) {
        if (arg0 >= -48) {
            this.method9290(117);
        }
        if (this.type.multinpcs != null) {
            @Pc(22) NPCType local22 = this.type.getMultiNPC(TimedVarDomain.instance);
            if (local22 != null && local22.mobilisingArmiesIcon != -1) {
                return local22.mobilisingArmiesIcon;
            }
        }
        return this.type.mobilisingArmiesIcon;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IIB)V")
    public void method9325(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(10) int local10 = super.pathX[0];
        @Pc(20) int local20 = super.pathY[0];
        if (arg1 == 0) {
            local20++;
        }
        if (arg1 == 1) {
            local20++;
            local10++;
        }
        if (arg1 == 2) {
            local10++;
        }
        if (arg1 == 3) {
            local20--;
            local10++;
        }
        if (arg1 == 4) {
            local20--;
        }
        if (arg1 == 5) {
            local20--;
            local10--;
        }
        if (arg1 == 6) {
            local10--;
        }
        if (arg1 == 7) {
            local10--;
            local20++;
        }
        if (super.aAnimator_11.isAnimating() && super.aAnimator_11.getAnimation().walkingPrecedence == 1) {
            super.anIntArray869 = null;
            super.aAnimator_11.update(true, -1);
        }
        for (@Pc(110) int local110 = 0; local110 < super.aClass199Array3.length; local110++) {
            if (super.aClass199Array3[local110].anInt4930 != -1) {
                @Pc(131) SpotAnimationType local131 = SpotAnimationTypeList.instance.list(super.aClass199Array3[local110].anInt4930);
                if (local131.loopSeq && local131.seq != -1 && SeqTypeList.instance.list(local131.seq).walkingPrecedence == 1) {
                    super.aClass199Array3[local110].aAnimator_7.update(true, -1);
                    super.aClass199Array3[local110].anInt4930 = -1;
                }
            }
        }
        if (super.anInt10764 < super.pathX.length - 1) {
            super.anInt10764++;
        }
        for (@Pc(201) int local201 = super.anInt10764; local201 > 0; local201--) {
            super.pathX[local201] = super.pathX[local201 - 1];
            super.pathY[local201] = super.pathY[local201 - 1];
            super.aByteArray111[local201] = super.aByteArray111[local201 - 1];
        }
        super.pathX[0] = local10;
        super.pathY[0] = local20;
        super.aByteArray111[0] = (byte) arg0;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IZIIII)V")
    public void method9326(@OriginalArg(1) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        super.level = super.aByte143 = (byte) arg3;
        if (Static441.method5968(arg1, arg2)) {
            super.aByte143++;
        }
        if (super.aAnimator_11.isAnimating() && super.aAnimator_11.getAnimation().walkingPrecedence == 1) {
            super.anIntArray869 = null;
            super.aAnimator_11.update(true, -1);
        }
        for (@Pc(61) int local61 = 0; local61 < super.aClass199Array3.length; local61++) {
            if (super.aClass199Array3[local61].anInt4930 != -1) {
                @Pc(81) SpotAnimationType local81 = SpotAnimationTypeList.instance.list(super.aClass199Array3[local61].anInt4930);
                if (local81.loopSeq && local81.seq != -1 && SeqTypeList.instance.list(local81.seq).walkingPrecedence == 1) {
                    super.aClass199Array3[local61].aAnimator_7.update(true, -1);
                    super.aClass199Array3[local61].anInt4930 = -1;
                }
            }
        }
        if (!arg0) {
            @Pc(134) int local134 = arg2 - super.pathX[0];
            @Pc(142) int local142 = arg1 - super.pathY[0];
            if (local134 >= -8 && local134 <= 8 && local142 >= -8 && local142 <= 8) {
                if (super.pathX.length - 1 > super.anInt10764) {
                    super.anInt10764++;
                }
                for (@Pc(183) int local183 = super.anInt10764; local183 > 0; local183--) {
                    super.pathX[local183] = super.pathX[local183 - 1];
                    super.pathY[local183] = super.pathY[local183 - 1];
                    super.aByteArray111[local183] = super.aByteArray111[local183 - 1];
                }
                super.pathX[0] = arg2;
                super.aByteArray111[0] = 1;
                super.pathY[0] = arg1;
                return;
            }
        }
        super.anInt10764 = 0;
        super.anInt10763 = 0;
        super.pathX[0] = arg2;
        super.anInt10762 = 0;
        super.pathY[0] = arg1;
        super.x = (arg4 << 8) + (super.pathX[0] << 9);
        super.z = (super.pathY[0] << 9) + (arg4 << 8);
        if (super.aClass8_Sub5_8 != null) {
            super.aClass8_Sub5_8.method3656();
        }
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(IILjava/lang/String;B)V")
    public void method9327(@OriginalArg(2) String arg0) {
        @Pc(17) int local17 = Static504.method6733() * Static523.graphicsDefaults.npcChatTimeout;
        this.method9313(local17, arg0, 0, 0);
    }

    @OriginalMember(owner = "client!wj", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (this.type == null || !super.aBoolean820 && !this.method9324(0, arg0)) {
            return;
        }
        @Pc(26) Matrix local26 = arg0.scratchMatrix();
        local26.rotate(super.aClass126_7.method2673(16383));
        local26.translate(super.x, super.anInt10691 - 20, super.z);
        this.method9319(arg0, super.aBoolean820, super.aModelArray3, local26);
        for (@Pc(53) int local53 = 0; local53 < super.aModelArray3.length; local53++) {
            super.aModelArray3[local53] = null;
        }
        if (arg1 != -5) {
            this.method9278(null, -21);
        }
    }

    @OriginalMember(owner = "client!wj", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method9322();
        }
        return false;
    }

    @OriginalMember(owner = "client!wj", name = "a", descriptor = "(Lclient!o;Z)V")
    public void method9328(@OriginalArg(0) NPCType arg0) {
        if (arg0 != this.type && MiniMenu.open && Static321.method4622(super.id)) {
            Static488.method6522();
        }
        this.type = arg0;
        if (this.type != null) {
            this.aString128 = this.type.name;
            this.combatLevel = this.type.combatLevel;
        }
        if (super.aClass8_Sub5_8 != null) {
            super.aClass8_Sub5_8.method3656();
        }
    }

    @OriginalMember(owner = "client!wj", name = "m", descriptor = "(I)I")
    @Override
    protected int method9320(@OriginalArg(0) int arg0) {
        if (this.type.multinpcs != null) {
            @Pc(15) NPCType local15 = this.type.getMultiNPC(TimedVarDomain.instance);
            if (local15 != null && local15.basId != -1) {
                return local15.basId;
            }
        }
        if (arg0 != 0) {
            this.anInt10774 = -66;
        }
        return this.type.basId;
    }

    @OriginalMember(owner = "client!wj", name = "n", descriptor = "(I)Z")
    public boolean method9330() {
        return this.type.interactive;
    }

    @OriginalMember(owner = "client!wj", name = "d", descriptor = "(B)I")
    @Override
    public int method9287() {
        return this.type == null ? 0 : this.type.pickSizeShift;
    }
}
