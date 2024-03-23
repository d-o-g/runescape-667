import com.jagex.ParticleList;
import com.jagex.Constants;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.io.Packet;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeCustomisation;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Model;
import com.jagex.graphics.PickingCylinder;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ca")
public final class PlayerEntity extends Class8_Sub2_Sub1_Sub2 {

    @OriginalMember(owner = "client!rj", name = "c", descriptor = "Lclient!ca;")
    public static PlayerEntity self;

    @OriginalMember(owner = "client!ca", name = "Sc", descriptor = "Ljava/lang/String;")
    public String aString8;

    @OriginalMember(owner = "client!ca", name = "Mc", descriptor = "Lclient!ju;")
    public PlayerModel playerModel;

    @OriginalMember(owner = "client!ca", name = "xd", descriptor = "Ljava/lang/String;")
    public String accountName;

    @OriginalMember(owner = "client!ca", name = "bd", descriptor = "I")
    public int anInt1441;

    @OriginalMember(owner = "client!ca", name = "Ec", descriptor = "I")
    public int anInt1443;

    @OriginalMember(owner = "client!ca", name = "yd", descriptor = "I")
    public int anInt1448;

    @OriginalMember(owner = "client!ca", name = "qd", descriptor = "I")
    public int anInt1430 = -1;

    @OriginalMember(owner = "client!ca", name = "Dd", descriptor = "B")
    public byte aByte32 = 0;

    @OriginalMember(owner = "client!ca", name = "wd", descriptor = "Z")
    public boolean aBoolean124 = false;

    @OriginalMember(owner = "client!ca", name = "gd", descriptor = "B")
    public byte aByte33 = 0;

    @OriginalMember(owner = "client!ca", name = "rd", descriptor = "I")
    public int anInt1433 = 0;

    @OriginalMember(owner = "client!ca", name = "Dc", descriptor = "Z")
    public boolean aBoolean125 = false;

    @OriginalMember(owner = "client!ca", name = "Gc", descriptor = "I")
    public int anInt1431 = -1;

    @OriginalMember(owner = "client!ca", name = "Jc", descriptor = "Z")
    public boolean vorbis = false;

    @OriginalMember(owner = "client!ca", name = "cd", descriptor = "I")
    public int anInt1437 = 0;

    @OriginalMember(owner = "client!ca", name = "Ad", descriptor = "I")
    public int anInt1436 = 0;

    @OriginalMember(owner = "client!ca", name = "Gd", descriptor = "I")
    public int anInt1452 = 0;

    @OriginalMember(owner = "client!ca", name = "Lc", descriptor = "Z")
    public boolean aBoolean127 = false;

    @OriginalMember(owner = "client!ca", name = "sd", descriptor = "I")
    public int anInt1455 = -1;

    @OriginalMember(owner = "client!ca", name = "id", descriptor = "Z")
    public boolean aBoolean129 = false;

    @OriginalMember(owner = "client!ca", name = "Fd", descriptor = "I")
    public int anInt1444 = 0;

    @OriginalMember(owner = "client!ca", name = "zd", descriptor = "Z")
    public boolean aBoolean128 = false;

    @OriginalMember(owner = "client!ca", name = "pd", descriptor = "B")
    public byte aByte31 = 0;

    @OriginalMember(owner = "client!ca", name = "Bd", descriptor = "I")
    public int anInt1459 = -1;

    @OriginalMember(owner = "client!ca", name = "Oc", descriptor = "I")
    public int soundVolume = 255;

    @OriginalMember(owner = "client!ca", name = "hd", descriptor = "I")
    public int anInt1445 = -1;

    @OriginalMember(owner = "client!ca", name = "ld", descriptor = "I")
    public int anInt1469 = -1;

    @OriginalMember(owner = "client!ca", name = "Tc", descriptor = "I")
    public int anInt1467 = -1;

    @OriginalMember(owner = "client!ca", name = "ed", descriptor = "I")
    public int anInt1471 = -1;

    @OriginalMember(owner = "client!ca", name = "<init>", descriptor = "(I)V")
    public PlayerEntity(@OriginalArg(0) int arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!ca", name = "<init>", descriptor = "()V")
    public PlayerEntity() {
    }

    @OriginalMember(owner = "client!kf", name = "a", descriptor = "(ILclient!ca;)I")
    public static int method4870(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(6) int local6 = arg0.anInt1445;
        @Pc(10) BASType local10 = arg0.method9317();
        @Pc(15) int local15 = arg0.animator.getAnimationId();
        if (local15 == -1 || arg0.ready) {
            local6 = arg0.anInt1455;
        } else if (local10.run == local15 || local15 == local10.runFollowTurn180 || local10.runFollowTurnCw == local15 || local10.runFollowTurnCcw == local15) {
            local6 = arg0.anInt1469;
        } else if (local10.crawl == local15 || local10.crawlFollowTurn180 == local15 || local10.crawlFollowTurnCw == local15 || local10.crawlFollowTurnCcw == local15) {
            local6 = arg0.anInt1459;
        }
        return local6;
    }

    @OriginalMember(owner = "client!ca", name = "d", descriptor = "(Lclient!ha;I)V")
    @Override
    public void method9289(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (this.playerModel == null || !super.aBoolean820 && !this.method1421(0, arg0)) {
            return;
        }
        @Pc(24) Matrix local24 = arg0.scratchMatrix();
        local24.rotate(super.aClass126_7.method2673(arg1 ^ 0xFFFFC004));
        local24.translate(super.x, arg1 + super.anInt10691, super.z);
        this.method9319(arg0, super.aBoolean820, super.aModelArray3, local24);
        for (@Pc(53) int local53 = 0; local53 < super.aModelArray3.length; local53++) {
            super.aModelArray3[local53] = null;
        }
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IILjava/lang/String;B)V")
    public void method1413(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
        this.method9313(Static504.method6733() * Static523.graphicsDefaults.playerChatTimeout, arg2, arg1, arg0);
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(BIIILclient!ka;Lclient!tt;Lclient!ha;I)V")
    public void method1414(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) Model arg4, @OriginalArg(5) Matrix arg5, @OriginalArg(6) Toolkit arg6, @OriginalArg(7) int arg7) {
        if (arg0 != -74) {
            this.method9289(null, 41);
        }
        @Pc(20) int local20 = arg7 * arg7 + arg1 * arg1;
        if (local20 < 262144 || local20 > arg2) {
            return;
        }
        @Pc(53) int local53 = (int) (Math.atan2(arg1, arg7) * 2607.5945876176133D - (double) super.aClass126_7.method2673(16383)) & 0x3FFF;
        @Pc(65) Model local65 = Static691.method9004(super.anInt10746, super.anInt10742, arg3, super.anInt10716, local53, arg6);
        if (local65 != null) {
            arg6.C(false);
            local65.render(arg5, null, 0);
            arg6.C(true);
        }
    }

    @OriginalMember(owner = "client!ca", name = "c", descriptor = "(Lclient!ha;I)Lclient!ke;")
    @Override
    public Class205 method9278(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) int arg1) {
        if (arg1 > -93) {
            this.method1424(true);
        }
        return null;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IIZLclient!ha;)Z")
    @Override
    public boolean method9279(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) Toolkit arg3) {
        if (this.playerModel == null || !this.method1421(131072, arg3)) {
            return false;
        }
        @Pc(22) Matrix local22 = arg3.scratchMatrix();
        @Pc(27) int local27 = super.aClass126_7.method2673(16383);
        local22.rotate(local27);
        local22.translate(super.x, super.anInt10691, super.z);
        @Pc(40) boolean local40 = arg2;
        for (@Pc(42) int local42 = 0; local42 < super.aModelArray3.length; local42++) {
            if (super.aModelArray3[local42] != null && (Static504.aBoolean579 ? super.aModelArray3[local42].pickedOrtho(arg1, arg0, local22, true, 0, Static582.anInt8627) : super.aModelArray3[local42].picked(arg1, arg0, local22, true, 0))) {
                local40 = true;
                break;
            }
        }
        for (@Pc(95) int local95 = 0; local95 < super.aModelArray3.length; local95++) {
            super.aModelArray3[local95] = null;
        }
        return local40;
    }

    @OriginalMember(owner = "client!ca", name = "i", descriptor = "(I)Z")
    @Override
    public boolean method9290(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.method1414((byte) 124, 20, -110, 30, null, null, null, 15);
        }
        return false;
    }

    @OriginalMember(owner = "client!ca", name = "h", descriptor = "(B)I")
    @Override
    public int method9304(@OriginalArg(0) byte arg0) {
        if (arg0 > -48) {
            this.method9318(-126);
        }
        return -1;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IZLclient!ha;IBILclient!eo;)V")
    @Override
    public void method9285(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Toolkit arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Renderable arg6) {
        if (arg4 >= 101) {
            throw new IllegalStateException();
        }
    }

    @OriginalMember(owner = "client!ca", name = "m", descriptor = "(I)I")
    @Override
    protected int method9320(@OriginalArg(0) int arg0) {
        if (arg0 != 0) {
            this.anInt1444 = -112;
        }
        return this.anInt1443;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(Lclient!ka;IBLclient!ha;IILclient!tt;II)V")
    public void method1416(@OriginalArg(0) Model arg0, @OriginalArg(1) int arg1, @OriginalArg(3) Toolkit arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) Matrix arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7) {
        @Pc(12) int local12 = arg4 * arg4 + arg7 * arg7;
        if (local12 < 262144 || local12 > arg1) {
            return;
        }
        @Pc(53) int local53 = (int) (Math.atan2(arg4, arg7) * 2607.5945876176133D - (double) super.aClass126_7.method2673(16383)) & 0x3FFF;
        @Pc(65) Model local65 = Static691.method9004(super.anInt10746, super.anInt10742, arg3, super.anInt10716, local53, arg2);
        if (local65 != null) {
            arg2.C(false);
            local65.renderOrtho(arg5, null, arg6, 0);
            arg2.C(true);
        }
    }

    @OriginalMember(owner = "client!ca", name = "j", descriptor = "(B)Z")
    public boolean method1417() {
        return this.playerModel != null;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IIIB)V")
    public void method1418(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) byte arg2) {
        if (super.anInt10764 < super.pathX.length - 1) {
            super.anInt10764++;
        }
        for (@Pc(24) int local24 = super.anInt10764; local24 > 0; local24--) {
            super.pathX[local24] = super.pathX[local24 - 1];
            super.pathY[local24] = super.pathY[local24 - 1];
            super.aByteArray111[local24] = super.aByteArray111[local24 - 1];
        }
        super.pathX[0] = arg1;
        super.aByteArray111[0] = arg2;
        if (-24527 != -24527) {
            this.method9304((byte) -13);
        }
        super.pathY[0] = arg0;
    }

    @OriginalMember(owner = "client!ca", name = "g", descriptor = "(B)I")
    @Override
    public int boundSize(@OriginalArg(0) byte arg0) {
        if (this.playerModel == null || this.playerModel.npcId == -1) {
            if (arg0 < 43) {
                this.soundVolume = 1;
            }
            return super.boundSize((byte) 76);
        } else {
            return Static690.aNPCTypeList_2.list(this.playerModel.npcId).size;
        }
    }

    @OriginalMember(owner = "client!ca", name = "c", descriptor = "(III)V")
    public void method1419(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        super.anInt10764 = 0;
        super.pathX[0] = arg0;
        super.anInt10763 = 0;
        super.anInt10762 = 0;
        super.pathY[0] = arg1;
        @Pc(26) int local26 = this.boundSize((byte) 84);
        super.x = local26 * 256 + super.pathX[0] * 512;
        super.z = super.pathY[0] * 512 + local26 * 256;
        if (self == this) {
            Static218.method3187();
        }
        if (super.aClass8_Sub5_8 != null) {
            super.aClass8_Sub5_8.method3656();
        }
    }

    @OriginalMember(owner = "client!ca", name = "j", descriptor = "(I)V")
    @Override
    public void method9280(@OriginalArg(0) int arg0) {
        if (arg0 != 27811) {
            this.aBoolean127 = true;
        }
        throw new IllegalStateException();
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ILclient!ha;)Lclient!pea;")
    @Override
    public Class8_Sub7 method9276(@OriginalArg(1) Toolkit arg0) {
        if (this.playerModel == null || !this.method1421(2048, arg0)) {
            return null;
        }
        @Pc(22) Matrix local22 = arg0.scratchMatrix();
        @Pc(27) int local27 = super.aClass126_7.method2673(16383);
        local22.rotate(local27);
        @Pc(53) Class291 local53 = Static334.activeTiles[super.level][super.x >> Static52.anInt1066][super.z >> Static52.anInt1066];
        if (local53 == null || local53.aGroundDecor_1 == null) {
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) super.anInt10732 / 10.0F);
        } else {
            @Pc(68) int local68 = super.anInt10732 - local53.aGroundDecor_1.aShort46;
            super.anInt10732 = (int) ((float) super.anInt10732 - (float) local68 / 10.0F);
        }
        local22.translate(super.x, -super.anInt10732 + super.anInt10691 - 20, super.z);
        super.aBoolean819 = false;
        @Pc(114) Class8_Sub7 local114 = null;
        if (ClientOptions.instance.spotShadows.getValue() == 1) {
            @Pc(126) BASType local126 = this.method9317();
            if (local126.animateShadow && (this.playerModel.npcId == -1 || Static690.aNPCTypeList_2.list(this.playerModel.npcId).hasShadow)) {
                @Pc(166) Animator local166 = super.aAnimator_11.isAnimating() && super.aAnimator_11.isDelayed() ? super.aAnimator_11 : null;
                @Pc(186) Animator local186 = super.animator.isAnimating() && (!super.ready || local166 == null) ? super.animator : null;
                @Pc(212) Model local212 = Static618.method8320(240, super.aModelArray3[0], super.anInt10742, 0, super.anInt10716, 1, arg0, 160, local186 == null ? local166 : local186, super.anInt10746, local27, 0);
                if (local212 != null) {
                    local114 = Static642.method8441(true, super.aModelArray3.length + 1);
                    super.aBoolean819 = true;
                    arg0.C(false);
                    if (Static504.aBoolean579) {
                        local212.renderOrtho(local22, local114.aPickingCylinderArray1[super.aModelArray3.length], Static582.anInt8627, 0);
                    } else {
                        local212.render(local22, local114.aPickingCylinderArray1[super.aModelArray3.length], 0);
                    }
                    arg0.C(true);
                }
            }
        }
        @Pc(269) int local269;
        if (self == this) {
            for (local269 = Static527.aClass254Array1.length - 1; local269 >= 0; local269--) {
                @Pc(275) Class254 local275 = Static527.aClass254Array1[local269];
                if (local275 != null && local275.anInt6371 != -1) {
                    @Pc(310) int local310;
                    if (local275.anInt6363 == 1) {
                        @Pc(298) Node_Sub45 local298 = (Node_Sub45) Static18.A_HASH_TABLE___2.get(local275.anInt6366);
                        if (local298 != null) {
                            @Pc(303) NPCEntity local303 = local298.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                            local310 = local303.x - self.x;
                            @Pc(316) int local316 = local303.z - self.z;
                            if (Static504.aBoolean579) {
                                this.method1416(super.aModelArray3[0], 92160000, arg0, local275.anInt6371, local310, local22, Static582.anInt8627, local316);
                            } else {
                                this.method1414((byte) -74, local310, 92160000, local275.anInt6371, super.aModelArray3[0], local22, arg0, local316);
                            }
                        }
                    }
                    @Pc(371) int local371;
                    if (local275.anInt6363 == 2) {
                        @Pc(364) int local364 = local275.anInt6369 - self.x;
                        local371 = local275.anInt6362 - self.z;
                        local310 = local275.anInt6364 << 9;
                        local310 *= local310;
                        if (Static504.aBoolean579) {
                            this.method1416(super.aModelArray3[0], local310, arg0, local275.anInt6371, local364, local22, Static582.anInt8627, local371);
                        } else {
                            this.method1414((byte) -74, local364, local310, local275.anInt6371, super.aModelArray3[0], local22, arg0, local371);
                        }
                    }
                    if (local275.anInt6363 == 10 && local275.anInt6366 >= 0 && local275.anInt6366 < PlayerList.highResolutionPlayers.length) {
                        @Pc(438) PlayerEntity local438 = PlayerList.highResolutionPlayers[local275.anInt6366];
                        if (local438 != null) {
                            local371 = local438.x - self.x;
                            local310 = local438.z - self.z;
                            if (Static504.aBoolean579) {
                                this.method1416(super.aModelArray3[0], 92160000, arg0, local275.anInt6371, local371, local22, Static582.anInt8627, local310);
                            } else {
                                this.method1414((byte) -74, local371, 92160000, local275.anInt6371, super.aModelArray3[0], local22, arg0, local310);
                            }
                        }
                    }
                }
            }
            local22.rotate(local27);
            local22.translate(super.x, super.anInt10691, super.z);
        }
        local22.rotate(local27);
        local22.translate(super.x, -super.anInt10732 + super.anInt10691 - 5, super.z);
        if (local114 == null) {
            local114 = Static642.method8441(true, super.aModelArray3.length);
        }
        this.method9319(arg0, false, super.aModelArray3, local22);
        if (Static504.aBoolean579) {
            for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
                if (super.aModelArray3[local269] != null) {
                    super.aModelArray3[local269].renderOrtho(local22, local114.aPickingCylinderArray1[local269], Static582.anInt8627, self == this ? 1 : 0);
                }
            }
        } else {
            for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
                if (super.aModelArray3[local269] != null) {
                    super.aModelArray3[local269].render(local22, local114.aPickingCylinderArray1[local269], self == this ? 1 : 0);
                }
            }
        }
        if (super.aClass8_Sub5_8 != null) {
            @Pc(635) ParticleList local635 = super.aClass8_Sub5_8.method3645();
            if (Static504.aBoolean579) {
                arg0.method7967(local635, Static582.anInt8627);
            } else {
                arg0.method8021(local635);
            }
        }
        for (local269 = 0; local269 < super.aModelArray3.length; local269++) {
            if (super.aModelArray3[local269] != null) {
                super.aBoolean819 |= super.aModelArray3[local269].F();
            }
            super.aModelArray3[local269] = null;
        }
        super.anInt10704 = Static198.anInt3276;
        return local114;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(Lclient!ge;I)V")
    public void method1420(@OriginalArg(0) Packet packet) {
        packet.pos = 0;
        @Pc(12) int local12 = packet.g1();
        this.aByte32 = (byte) (local12 & 0x1);
        @Pc(21) boolean local21 = this.vorbis;
        this.vorbis = (local12 & 0x2) != 0;
        @Pc(40) boolean local40 = (local12 & 0x4) != 0;
        @Pc(44) int local44 = super.boundSize((byte) 85);
        this.method9310((local12 >> 3 & 0x7) + 1);
        this.aByte31 = (byte) (local12 >> 6 & 0x3);
        super.x += this.boundSize((byte) 44) - local44 << 8;
        super.z += this.boundSize((byte) 111) - local44 << 8;
        this.aByte33 = packet.g1b();
        this.anInt1430 = packet.g1b();
        this.anInt1431 = packet.g1b();
        this.aBoolean124 = packet.g1b() == 1;
        if (ModeWhere.LIVE == client.modeWhere && Static608.staffModLevel >= 2) {
            this.aBoolean124 = false;
        }
        this.anInt1433 = 0;
        @Pc(134) int local134 = -1;
        @Pc(139) int[] local139 = new int[Static523.wearposDefaults.hidden.length];
        @Pc(144) ObjTypeCustomisation[] local144 = new ObjTypeCustomisation[Static523.wearposDefaults.hidden.length];
        @Pc(149) ObjType[] local149 = new ObjType[Static523.wearposDefaults.hidden.length];
        @Pc(165) int local165;
        @Pc(184) int local184;
        @Pc(191) int local191;
        @Pc(240) int local240;
        for (@Pc(151) int local151 = 0; local151 < Static523.wearposDefaults.hidden.length; local151++) {
            if (Static523.wearposDefaults.hidden[local151] != 1) {
                local165 = packet.g1();
                if (local165 == 0) {
                    local139[local151] = 0;
                } else {
                    local184 = packet.g1();
                    local191 = (local165 << 8) + local184;
                    if (local151 == 0 && local191 == 65535) {
                        local134 = packet.g2();
                        this.anInt1433 = packet.g1();
                        break;
                    }
                    if (local191 >= 32768) {
                        local191 = Static349.anIntArray426[local191 - 32768];
                        local139[local151] = local191 | 0x40000000;
                        local149[local151] = Static419.objTypeList.list(local191);
                        local240 = local149[local151].team;
                        if (local240 != 0) {
                            this.anInt1433 = local240;
                        }
                    } else {
                        local139[local151] = local191 - 256 | Integer.MIN_VALUE;
                    }
                }
            }
        }
        if (local134 == -1) {
            local165 = packet.g2();
            local184 = 0;
            for (local191 = 0; local191 < Static523.wearposDefaults.hidden.length; local191++) {
                if (Static523.wearposDefaults.hidden[local191] == 0) {
                    if ((local165 & 0x1 << local184) != 0) {
                        local144[local191] = ObjTypeCustomisation.decode(packet, local149[local191]);
                    }
                    local184++;
                }
            }
        }
        @Pc(332) int[] local332 = new int[10];
        for (local184 = 0; local184 < 10; local184++) {
            local191 = packet.g1();
            if (local184 >= PlayerModel.recol_d.length || local191 < 0 || PlayerModel.recol_d[local184][0].length <= local191) {
                local191 = 0;
            }
            local332[local184] = local191;
        }
        this.anInt1443 = packet.g2();
        this.aString8 = packet.gjstr();
        if (self == this) {
            Constants.playerDisplayName = this.aString8;
        }
        this.accountName = this.aString8;
        this.anInt1444 = packet.g1();
        if (local40) {
            this.anInt1436 = packet.g2();
            this.anInt1437 = this.anInt1444;
            if (this.anInt1436 == 65535) {
                this.anInt1436 = -1;
            }
            this.anInt1471 = -1;
        } else {
            this.anInt1436 = 0;
            this.anInt1437 = packet.g1();
            this.anInt1471 = packet.g1();
            if (this.anInt1471 == 255) {
                this.anInt1471 = -1;
            }
        }
        local191 = this.anInt1452;
        this.anInt1452 = packet.g1();
        @Pc(490) int local490;
        if (this.anInt1452 == 0) {
            Static76.method1552(this);
        } else {
            local240 = this.anInt1455;
            @Pc(487) int local487 = this.anInt1459;
            local490 = this.anInt1445;
            @Pc(493) int local493 = this.anInt1469;
            @Pc(496) int local496 = this.soundVolume;
            this.anInt1455 = packet.g2();
            this.anInt1459 = packet.g2();
            this.anInt1445 = packet.g2();
            this.anInt1469 = packet.g2();
            this.soundVolume = packet.g1();
            if (this.vorbis != local21 || this.anInt1452 != local191 || local240 != this.anInt1455 || local487 != this.anInt1459 || this.anInt1445 != local490 || this.anInt1469 != local493 || local496 != this.soundVolume) {
                Static247.method3523(this);
            }
        }
        if (this.playerModel == null) {
            this.playerModel = new PlayerModel();
        }
        local240 = this.playerModel.npcId;
        @Pc(603) int[] local603 = this.playerModel.clientpalette;
        this.playerModel.update(local332, local139, local144, local134, this.method9320(0), this.aByte32 == 1);
        if (local134 != local240) {
            super.x = (super.pathX[0] << 9) + (this.boundSize((byte) 83) << 8);
            super.z = (super.pathY[0] << 9) + (this.boundSize((byte) 45) << 8);
        }
        if (PlayerList.activePlayerSlot == super.anInt10740 && local603 != null) {
            for (local490 = 0; local490 < local332.length; local490++) {
                if (local332[local490] != local603[local490]) {
                    Static419.objTypeList.spriteCacheReset();
                    break;
                }
            }
        }
        if (super.aClass8_Sub5_8 != null) {
            super.aClass8_Sub5_8.method3656();
        }
        if (!super.animator.isAnimating() || !super.ready) {
            return;
        }
        @Pc(717) BASType local717 = this.method9317();
        if (!local717.isReady(super.animator.getAnimationId())) {
            super.animator.update(true, -1);
            super.ready = false;
            return;
        }
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(IILclient!ha;)Z")
    public boolean method1421(@OriginalArg(0) int arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(5) int local5 = arg0;
        @Pc(15) BASType local15 = this.method9317();
        @Pc(33) Animator local33 = super.aAnimator_11.isAnimating() && !super.aAnimator_11.isDelayed() ? super.aAnimator_11 : null;
        @Pc(58) Animator local58 = !super.animator.isAnimating() || this.aBoolean129 || super.ready && local33 != null ? null : super.animator;
        @Pc(61) int local61 = local15.hillWidth;
        @Pc(64) int local64 = local15.hillHeight;
        if (local61 != 0 || local64 != 0 || local15.rollTargetAngle != 0 || local15.pitchTargetAngle != 0) {
            arg0 |= 0x7;
        }
        @Pc(95) int local95 = super.aClass126_7.method2673(16383);
        @Pc(119) boolean local119 = super.aByte149 != 0 && TimeUtils.clock >= super.anInt10760 && TimeUtils.clock < super.anInt10752;
        if (local119) {
            arg0 |= 0x80000;
        }
        @Pc(152) Model local152 = super.aModelArray3[0] = this.playerModel.bodyModel(Static419.objTypeList, local33, Static574.basTypeList, Static25.seqTypeList, arg0, super.anIntArray877, Static523.wearposDefaults, Static68.idkTypeList, arg1, Static690.aNPCTypeList_2, super.aClass152_Sub2_Sub1Array3, local95, local58, TimedVarDomain.instance);
        @Pc(155) int local155 = PlayerModel.cacheHardReferenceCount();
        if (ClientOptions.maxmemory < 96 && local155 > 50) {
            Static358.method9191();
        }
        if (ModeWhere.LIVE != client.modeWhere && local155 < 50) {
            @Pc(181) int local181 = 50 - local155;
            while (Static107.anInt2161 < local181) {
                Static163.aByteArrayArray36[Static107.anInt2161] = new byte[102400];
                Static107.anInt2161++;
            }
            while (local181 < Static107.anInt2161) {
                Static107.anInt2161--;
                Static163.aByteArrayArray36[Static107.anInt2161] = null;
            }
        } else if (ModeWhere.LIVE != client.modeWhere) {
            Static107.anInt2161 = 0;
            Static163.aByteArrayArray36 = new byte[50][];
        }
        if (local152 == null) {
            return false;
        }
        super.anInt10748 = local152.fa();
        super.anInt10728 = local152.ma();
        this.method9306(local152);
        if (local61 == 0 && local64 == 0) {
            this.method9314(local95, 0, 0, this.boundSize((byte) 59) << 9, this.boundSize((byte) 126) << 9, -81);
        } else {
            this.method9314(local95, local15.hillMaxAngleX, local15.hillMaxAngleY, local61, local64, -104);
            if (super.anInt10746 != 0) {
                local152.FA(super.anInt10746);
            }
            if (super.anInt10742 != 0) {
                local152.VA(super.anInt10742);
            }
            if (super.anInt10716 != 0) {
                local152.H(0, super.anInt10716, 0);
            }
        }
        if (local119) {
            local152.adjustColours(super.aByte150, super.aByte147, super.aByte148, super.aByte149 & 0xFF);
        }
        if (!this.aBoolean129) {
            this.method9297(local5, local64, arg1, local15, local95, local61);
        }
        return true;
    }

    @OriginalMember(owner = "client!ca", name = "e", descriptor = "(B)Z")
    @Override
    public boolean method9311() {
        return Static523.graphicsDefaults.playerShouldDisplayChat;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ZI)Ljava/lang/String;")
    public String method1422() {
        return this.accountName;
    }

    @OriginalMember(owner = "client!ca", name = "a", descriptor = "(ZZ)Ljava/lang/String;")
    public String method1424(@OriginalArg(0) boolean arg0) {
        @Pc(5) String local5 = "";
        if (Static685.aStringArray47 != null) {
            local5 = local5 + Static685.aStringArray47[this.aByte31];
        }
        if (arg0) {
            this.method9290(106);
        }
        @Pc(40) int[] local40;
        if (this.aByte32 == 1 && Static150.anIntArray233 != null) {
            local40 = Static150.anIntArray233;
        } else {
            local40 = Static406.anIntArray484;
        }
        if (local40 != null && local40[this.aByte31] != -1) {
            @Pc(62) Class53 local62 = Static619.aClass387_2.method8925(local40[this.aByte31]);
            if (local62.aChar1 == 's') {
                local5 = local5 + local62.method1229(this.aByte33 & 0xFF);
            } else {
                JagException.sendTrace(new Throwable(), "gdn1");
                local40[this.aByte31] = -1;
            }
        }
        local5 = local5 + this.aString8;
        if (Static377.aStringArray30 != null) {
            local5 = local5 + Static377.aStringArray30[this.aByte31];
        }
        return local5;
    }

    @OriginalMember(owner = "client!ca", name = "d", descriptor = "(I)Lclient!dj;")
    @Override
    public Class80 method9318(@OriginalArg(0) int arg0) {
        if (arg0 != -3109) {
            this.aBoolean128 = false;
        }
        if (super.aClass80_3 != null) {
            if (super.aClass80_3.aString20 == null) {
                return null;
            }
            if (Static133.anInt2458 == 0 || Static133.anInt2458 == 3 || Static133.anInt2458 == 1 && Static362.method5241(arg0 + 3109, this.accountName)) {
                return super.aClass80_3;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!ca", name = "b", descriptor = "(IIIB)V")
    public void method1425(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) byte arg2) {
        if (super.aAnimator_11.isAnimating() && super.aAnimator_11.getAnimation().walkingPrecedence == 1) {
            super.anIntArray869 = null;
            super.aAnimator_11.update(true, -1);
        }
        for (@Pc(33) int local33 = 0; local33 < super.aClass199Array3.length; local33++) {
            if (super.aClass199Array3[local33].anInt4930 != -1) {
                @Pc(56) Class227 local56 = Static23.aClass128_1.list(super.aClass199Array3[local33].anInt4930);
                if (local56.aBoolean448 && local56.anInt5842 != -1 && Static25.seqTypeList.list(local56.anInt5842).walkingPrecedence == 1) {
                    super.aClass199Array3[local33].aAnimator_7.update(true, -1);
                    super.aClass199Array3[local33].anInt4930 = -1;
                }
            }
        }
        if (-9380 != -9380) {
            this.boundSize((byte) -74);
        }
        this.anInt1467 = -1;
        if (arg1 < 0 || Static720.mapWidth <= arg1 || arg0 < 0 || Static501.mapHeight <= arg0) {
            this.method1419(arg1, arg0);
        } else if (super.pathX[0] >= 0 && super.pathX[0] < Static720.mapWidth && super.pathY[0] >= 0 && Static501.mapHeight > super.pathY[0]) {
            if (arg2 == 2) {
                Static360.method5232(this, arg1, arg0);
            }
            this.method1418(arg0, arg1, arg2);
        } else {
            this.method1419(arg1, arg0);
        }
    }
}
