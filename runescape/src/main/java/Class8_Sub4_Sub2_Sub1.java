import com.jagex.collect.Node;
import com.jagex.game.runetek6.config.emittertype.MeshEmitterType;
import com.jagex.game.runetek6.config.magnettype.MeshMagnetType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pp")
public final class Class8_Sub4_Sub2_Sub1 extends Class8_Sub4_Sub2 {

    @OriginalMember(owner = "client!pp", name = "F", descriptor = "S")
    public short aShort91;

    @OriginalMember(owner = "client!pp", name = "x", descriptor = "I")
    public int anInt7541;

    @OriginalMember(owner = "client!pp", name = "D", descriptor = "Lclient!rf;")
    public Class8_Sub8 aClass8_Sub8_1;

    @OriginalMember(owner = "client!pp", name = "z", descriptor = "S")
    public short aShort96;

    @OriginalMember(owner = "client!pp", name = "C", descriptor = "S")
    public short aShort93;

    @OriginalMember(owner = "client!pp", name = "B", descriptor = "S")
    public short aShort92;

    @OriginalMember(owner = "client!pp", name = "E", descriptor = "S")
    public short aShort95;

    @OriginalMember(owner = "client!pp", name = "y", descriptor = "S")
    public short aShort94;

    @OriginalMember(owner = "client!pp", name = "A", descriptor = "I")
    public int anInt7542;

    @OriginalMember(owner = "client!pp", name = "<init>", descriptor = "(Lclient!rf;IIIIIIIIIIIZZ)V")
    public Class8_Sub4_Sub2_Sub1(@OriginalArg(0) Class8_Sub8 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) boolean arg12, @OriginalArg(13) boolean arg13) {
        this.aClass8_Sub8_1 = arg0;
        super.anInt7537 = arg1 << 12;
        super.anInt7534 = arg2 << 12;
        super.anInt7536 = arg3 << 12;
        super.anInt7539 = arg9;
        this.aShort93 = this.aShort96 = (short) arg8;
        super.anInt7535 = arg10;
        super.anInt7540 = arg11;
        super.aBoolean574 = arg13;
        this.aShort92 = (short) arg4;
        this.aShort95 = (short) arg5;
        this.aShort94 = (short) arg6;
        this.anInt7542 = arg7;
        super.aByte122 = this.aClass8_Sub8_1.aMeshEmitter_1.aByte130;
        this.method6693();
    }

    @OriginalMember(owner = "client!pp", name = "c", descriptor = "()V")
    public void method6693() {
        @Pc(4) int local4 = this.aClass8_Sub8_1.aClass8_Sub5_6.anInt4147;
        if (this.aClass8_Sub8_1.aClass8_Sub5_6.aClass8_Sub4_Sub2_Sub1Array1[local4] != null) {
            this.aClass8_Sub8_1.aClass8_Sub5_6.aClass8_Sub4_Sub2_Sub1Array1[local4].method6697();
        }
        this.aClass8_Sub8_1.aClass8_Sub5_6.aClass8_Sub4_Sub2_Sub1Array1[local4] = this;
        this.aShort91 = (short) this.aClass8_Sub8_1.aClass8_Sub5_6.anInt4147;
        this.aClass8_Sub8_1.aClass8_Sub5_6.anInt4147 = local4 + 1 & 0x1FFF;
        this.aClass8_Sub8_1.aClass130_11.method2787(this);
    }

    @OriginalMember(owner = "client!pp", name = "a", descriptor = "(JI)V")
    public void method6694(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1) {
        this.aShort96 = (short) (this.aShort96 - arg1);
        if (this.aShort96 <= 0) {
            this.method6697();
            return;
        }
        @Pc(17) int local17 = super.anInt7537 >> 12;
        @Pc(22) int local22 = super.anInt7534 >> 12;
        @Pc(27) int local27 = super.anInt7536 >> 12;
        @Pc(31) Class8_Sub5 local31 = this.aClass8_Sub8_1.aClass8_Sub5_6;
        @Pc(35) MeshEmitterType local35 = this.aClass8_Sub8_1.aMeshEmitterType_1;
        if (local35.fadeColour != 0) {
            @Pc(65) int local65;
            if (this.aShort93 - this.aShort96 <= local35.anInt9901) {
                local65 = (super.anInt7539 >> 8 & 0xFF00) + (this.anInt7541 >> 16 & 0xFF) + local35.anInt9931 * arg1;
                @Pc(82) int local82 = (super.anInt7539 & 0xFF00) + (this.anInt7541 >> 8 & 0xFF) + local35.anInt9920 * arg1;
                @Pc(99) int local99 = ((super.anInt7539 & 0xFF) << 8) + (this.anInt7541 & 0xFF) + local35.anInt9916 * arg1;
                if (local65 < 0) {
                    local65 = 0;
                } else if (local65 > 65535) {
                    local65 = 65535;
                }
                if (local82 < 0) {
                    local82 = 0;
                } else if (local82 > 65535) {
                    local82 = 65535;
                }
                if (local99 < 0) {
                    local99 = 0;
                } else if (local99 > 65535) {
                    local99 = 65535;
                }
                super.anInt7539 &= 0xFF000000;
                super.anInt7539 |= ((local65 & 0xFF00) << 8) + (local82 & 0xFF00) + (local99 >> 8 & 0xFF);
                this.anInt7541 &= 0xFF000000;
                this.anInt7541 |= ((local65 & 0xFF) << 16) + ((local82 & 0xFF) << 8) + (local99 & 0xFF);
            }
            if (this.aShort93 - this.aShort96 <= local35.anInt9925) {
                local65 = (super.anInt7539 >> 16 & 0xFF00) + (this.anInt7541 >> 24 & 0xFF) + local35.anInt9887 * arg1;
                if (local65 < 0) {
                    local65 = 0;
                } else if (local65 > 65535) {
                    local65 = 65535;
                }
                super.anInt7539 &= 0xFFFFFF;
                super.anInt7539 |= (local65 & 0xFF00) << 16;
                this.anInt7541 &= 0xFFFFFF;
                this.anInt7541 |= (local65 & 0xFF) << 24;
            }
        }
        if (local35.endSpeed != -1 && this.aShort93 - this.aShort96 <= local35.lb) {
            this.anInt7542 += local35.anInt9889 * arg1;
        }
        if (local35.endSize != -1 && this.aShort93 - this.aShort96 <= local35.anInt9909) {
            super.anInt7535 += local35.anInt9910 * arg1;
        }
        @Pc(296) double local296 = (double) this.aShort92;
        @Pc(300) double local300 = (double) this.aShort95;
        @Pc(304) double local304 = (double) this.aShort94;
        @Pc(306) boolean local306 = false;
        @Pc(317) int local317;
        @Pc(324) int local324;
        @Pc(331) int local331;
        @Pc(348) int local348;
        @Pc(356) long local356;
        if (local35.decelerationType == 1) {
            local317 = local17 - this.aClass8_Sub8_1.aClass177_1.anInt4271;
            local324 = local22 - this.aClass8_Sub8_1.aClass177_1.anInt4278;
            local331 = local27 - this.aClass8_Sub8_1.aClass177_1.anInt4273;
            local348 = (int) Math.sqrt((double) (local317 * local317 + local324 * local324 + local331 * local331)) >> 2;
            local356 = (long) (local35.decelerationRate * local348 * arg1);
            this.anInt7542 = (int) ((long) this.anInt7542 - ((long) this.anInt7542 * local356 >> 18));
        } else if (local35.decelerationType == 2) {
            local317 = local17 - this.aClass8_Sub8_1.aClass177_1.anInt4271;
            local324 = local22 - this.aClass8_Sub8_1.aClass177_1.anInt4278;
            local331 = local27 - this.aClass8_Sub8_1.aClass177_1.anInt4273;
            local348 = local317 * local317 + local324 * local324 + local331 * local331;
            local356 = (long) (local35.decelerationRate * local348 * arg1);
            this.anInt7542 = (int) ((long) this.anInt7542 - ((long) this.anInt7542 * local356 >> 28));
        }
        if (local35.localMagnets != null) {
            @Pc(437) Node local437 = local31.aDeque_22.tail;
            for (@Pc(440) Node local440 = local437.next; local440 != local437; local440 = local440.next) {
                @Pc(444) DoublyLinkedNode_Sub2_Sub5 local444 = (DoublyLinkedNode_Sub2_Sub5) local440;
                @Pc(447) MeshMagnetType local447 = local444.aMeshMagnetType_1;
                if (local447.visibility != 1) {
                    @Pc(453) boolean local453 = false;
                    for (@Pc(455) int local455 = 0; local455 < local35.localMagnets.length; local455++) {
                        if (local35.localMagnets[local455] == local447.id) {
                            local453 = true;
                            break;
                        }
                    }
                    if (local453) {
                        @Pc(480) double local480 = (double) (local17 - local444.anInt1827);
                        @Pc(486) double local486 = (double) (local22 - local444.anInt1824);
                        @Pc(492) double local492 = (double) (local27 - local444.anInt1821);
                        @Pc(504) double local504 = local480 * local480 + local486 * local486 + local492 * local492;
                        if (!(local504 > (double) local447.maxRange)) {
                            @Pc(513) double local513 = Math.sqrt(local504);
                            if (local513 == 0.0D) {
                                local513 = 1.0D;
                            }
                            @Pc(545) double local545 = (local480 * (double) local444.anInt1825 + local486 * (double) local447.dirY + local492 * (double) local444.anInt1823) * 65535.0D / ((double) local447.dirLength * local513);
                            if (!(local545 < (double) local447.cosTheta)) {
                                @Pc(553) double local553 = 0.0D;
                                if (local447.effectType == 1) {
                                    local553 = local513 / 16.0D * (double) local447.strength;
                                } else if (local447.effectType == 2) {
                                    local553 = local513 / 16.0D * (local513 / 16.0D) * (double) local447.strength;
                                }
                                if (local447.constantStrength != 0) {
                                    @Pc(678) double local678 = local480 / local513 * (double) local447.dirLength;
                                    @Pc(686) double local686 = local486 / local513 * (double) local447.dirLength;
                                    @Pc(694) double local694 = local492 / local513 * (double) local447.dirLength;
                                    if (local447.constantSpeed == 0) {
                                        local296 += local678 * (double) arg1;
                                        local300 += local686 * (double) arg1;
                                        local304 += local694 * (double) arg1;
                                        local306 = true;
                                    } else {
                                        super.anInt7537 = (int) ((double) super.anInt7537 + local678 * (double) arg1);
                                        super.anInt7534 = (int) ((double) super.anInt7534 + local686 * (double) arg1);
                                        super.anInt7536 = (int) ((double) super.anInt7536 + local694 * (double) arg1);
                                    }
                                } else if (local447.constantSpeed == 0) {
                                    local296 += ((double) local444.anInt1825 - local553) * (double) arg1;
                                    local300 += ((double) local447.dirY - local553) * (double) arg1;
                                    local304 += ((double) local444.anInt1823 - local553) * (double) arg1;
                                    local306 = true;
                                } else {
                                    super.anInt7537 = (int) ((double) super.anInt7537 + ((double) local444.anInt1825 - local553) * (double) arg1);
                                    super.anInt7534 = (int) ((double) super.anInt7534 + ((double) local447.dirY - local553) * (double) arg1);
                                    super.anInt7536 = (int) ((double) super.anInt7536 + ((double) local444.anInt1823 - local553) * (double) arg1);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (local35.generalMagnets != null) {
            for (local317 = 0; local317 < local35.generalMagnets.length; local317++) {
                @Pc(776) DoublyLinkedNode_Sub2_Sub5 local776 = (DoublyLinkedNode_Sub2_Sub5) Static519.aClass144_1.method3095((long) local35.generalMagnets[local317]);
                while (local776 != null) {
                    @Pc(780) MeshMagnetType local780 = local776.aMeshMagnetType_1;
                    @Pc(786) double local786 = (double) (local17 - local776.anInt1827);
                    @Pc(792) double local792 = (double) (local22 - local776.anInt1824);
                    @Pc(798) double local798 = (double) (local27 - local776.anInt1821);
                    @Pc(810) double local810 = local786 * local786 + local792 * local792 + local798 * local798;
                    if (local810 > (double) local780.maxRange) {
                        local776 = (DoublyLinkedNode_Sub2_Sub5) Static519.aClass144_1.method3096();
                    } else {
                        @Pc(825) double local825 = Math.sqrt(local810);
                        if (local825 == 0.0D) {
                            local825 = 1.0D;
                        }
                        @Pc(857) double local857 = (local786 * (double) local776.anInt1825 + local792 * (double) local780.dirY + local798 * (double) local776.anInt1823) * 65535.0D / ((double) local780.dirLength * local825);
                        if (local857 < (double) local780.cosTheta) {
                            local776 = (DoublyLinkedNode_Sub2_Sub5) Static519.aClass144_1.method3096();
                        } else {
                            @Pc(871) double local871 = 0.0D;
                            if (local780.effectType == 1) {
                                local871 = local825 / 16.0D * (double) local780.strength;
                            } else if (local780.effectType == 2) {
                                local871 = local825 / 16.0D * (local825 / 16.0D) * (double) local780.strength;
                            }
                            if (local780.constantStrength != 0) {
                                @Pc(996) double local996 = local786 / local825 * (double) local780.dirLength;
                                @Pc(1004) double local1004 = local792 / local825 * (double) local780.dirLength;
                                @Pc(1012) double local1012 = local798 / local825 * (double) local780.dirLength;
                                if (local780.constantSpeed == 0) {
                                    local296 += local996 * (double) arg1;
                                    local300 += local1004 * (double) arg1;
                                    local304 += local1012 * (double) arg1;
                                    local306 = true;
                                } else {
                                    super.anInt7537 = (int) ((double) super.anInt7537 + local996 * (double) arg1);
                                    super.anInt7534 = (int) ((double) super.anInt7534 + local1004 * (double) arg1);
                                    super.anInt7536 = (int) ((double) super.anInt7536 + local1012 * (double) arg1);
                                }
                            } else if (local780.constantSpeed == 0) {
                                local296 += ((double) local776.anInt1825 - local871) * (double) arg1;
                                local300 += ((double) local780.dirY - local871) * (double) arg1;
                                local304 += ((double) local776.anInt1823 - local871) * (double) arg1;
                                local306 = true;
                            } else {
                                super.anInt7537 = (int) ((double) super.anInt7537 + ((double) local776.anInt1825 - local871) * (double) arg1);
                                super.anInt7534 = (int) ((double) super.anInt7534 + ((double) local780.dirY - local871) * (double) arg1);
                                super.anInt7536 = (int) ((double) super.anInt7536 + ((double) local776.anInt1823 - local871) * (double) arg1);
                            }
                            local776 = (DoublyLinkedNode_Sub2_Sub5) Static519.aClass144_1.method3096();
                        }
                    }
                }
            }
        }
        if (local35.globalMagnets != null) {
            if (local35.anIntArray774 == null) {
                local35.anIntArray774 = new int[local35.globalMagnets.length];
                for (local317 = 0; local317 < local35.globalMagnets.length; local317++) {
                    MeshMagnetTypeList.get(local35.globalMagnets[local317]);
                    local35.anIntArray774[local317] = ((IntNode) MeshMagnetTypeList.table.get((long) local35.globalMagnets[local317])).value;
                }
            }
            for (local317 = 0; local317 < local35.anIntArray774.length; local317++) {
                @Pc(1137) MeshMagnetType local1137 = MeshMagnetTypeList.types[local35.anIntArray774[local317]];
                if (local1137.constantSpeed == 0) {
                    local296 += (double) (local1137.dirX * arg1);
                    local300 += (double) (local1137.dirY * arg1);
                    local304 += (double) (local1137.dirZ * arg1);
                    local306 = true;
                } else {
                    super.anInt7537 += local1137.dirX * arg1;
                    super.anInt7534 += local1137.dirY * arg1;
                    super.anInt7536 += local1137.dirZ * arg1;
                }
            }
        }
        if (local306) {
            while (true) {
                if (!(local296 > 32767.0D) && !(local300 > 32767.0D) && !(local304 > 32767.0D) && !(local296 < -32767.0D) && !(local300 < -32767.0D) && !(local304 < -32767.0D)) {
                    this.aShort92 = (short) (int) local296;
                    this.aShort95 = (short) (int) local300;
                    this.aShort94 = (short) (int) local304;
                    break;
                }
                local296 /= 2.0D;
                local300 /= 2.0D;
                local304 /= 2.0D;
                this.anInt7542 <<= 0x1;
            }
        }
        super.anInt7537 = (int) ((long) super.anInt7537 + ((long) this.aShort92 * (long) (this.anInt7542 << 2) >> 23) * (long) arg1);
        super.anInt7534 = (int) ((long) super.anInt7534 + ((long) this.aShort95 * (long) (this.anInt7542 << 2) >> 23) * (long) arg1);
        super.anInt7536 = (int) ((long) super.anInt7536 + ((long) this.aShort94 * (long) (this.anInt7542 << 2) >> 23) * (long) arg1);
    }

    @OriginalMember(owner = "client!pp", name = "a", descriptor = "(Lclient!ha;J)V")
    public void method6695(@OriginalArg(0) Toolkit arg0, @OriginalArg(1) long arg1) {
        @Pc(6) int local6 = super.anInt7537 >> Static52.anInt1066 + 12;
        @Pc(13) int local13 = super.anInt7536 >> Static52.anInt1066 + 12;
        @Pc(18) int local18 = super.anInt7534 >> 12;
        if (local18 > 0 || local18 < -262144 || local6 < 0 || local6 >= Static619.anInt1566 || local13 < 0 || local13 >= Static662.anInt9843) {
            this.method6697();
            return;
        }
        @Pc(40) Class8_Sub5 local40 = this.aClass8_Sub8_1.aClass8_Sub5_6;
        @Pc(44) MeshEmitterType local44 = this.aClass8_Sub8_1.aMeshEmitterType_1;
        @Pc(46) Ground[] local46 = Static246.aGroundArray1;
        @Pc(49) int local49 = local40.anInt4149;
        @Pc(58) Class291 local58 = Static334.aClass291ArrayArrayArray1[local40.anInt4149][local6][local13];
        if (local58 != null) {
            local49 = local58.aByte116;
        }
        @Pc(71) int local71 = local46[local49].method7869(local13, local6);
        @Pc(86) int local86;
        if (local49 < Static299.anInt4824 - 1) {
            local86 = local46[local49 + 1].method7869(local13, local6);
        } else {
            local86 = local71 - (0x8 << Static52.anInt1066);
        }
        if (local44.aBoolean764) {
            if (local44.minHeightLevel == -1 && local18 > local71) {
                this.method6697();
                return;
            }
            if (local44.minHeightLevel >= 0 && local18 > local46[local44.minHeightLevel].method7869(local13, local6)) {
                this.method6697();
                return;
            }
            if (local44.maxHeightLevel == -1 && local18 < local86) {
                this.method6697();
                return;
            }
            if (local44.maxHeightLevel >= 0 && local18 < local46[local44.maxHeightLevel + 1].method7869(local13, local6)) {
                this.method6697();
                return;
            }
        }
        @Pc(154) int local154;
        for (local154 = Static299.anInt4824 - 1; local154 > 0 && local18 > local46[local154].method7869(local13, local6); local154--) {
        }
        if (local44.collidesWithGround && local154 == 0 && local18 > local46[0].method7869(local13, local6)) {
            this.method6697();
        } else if (local154 == Static299.anInt4824 - 1 && local46[local154].method7869(local13, local6) - local18 > 0x8 << Static52.anInt1066) {
            this.method6697();
        } else {
            local58 = Static334.aClass291ArrayArrayArray1[local154][local6][local13];
            @Pc(261) int local261;
            if (local58 == null) {
                if (local154 == 0 || Static334.aClass291ArrayArrayArray1[0][local6][local13] == null) {
                    local58 = Static334.aClass291ArrayArrayArray1[0][local6][local13] = new Class291(0);
                }
                @Pc(251) boolean local251 = Static334.aClass291ArrayArrayArray1[0][local6][local13].aClass291_1 != null;
                if (local154 == 3 && local251) {
                    this.method6697();
                    return;
                }
                for (local261 = 1; local261 <= local154; local261++) {
                    if (Static334.aClass291ArrayArrayArray1[local261][local6][local13] == null) {
                        local58 = Static334.aClass291ArrayArrayArray1[local261][local6][local13] = new Class291(local261);
                        if (local251) {
                            local58.aByte116++;
                        }
                    }
                }
            }
            if (local44.collidesWithLocations) {
                @Pc(304) int local304 = super.anInt7537 >> 12;
                local261 = super.anInt7536 >> 12;
                @Pc(318) Class205 local318;
                if (local58.aClass8_Sub2_Sub3_2 != null) {
                    local318 = local58.aClass8_Sub2_Sub3_2.method9278(arg0, -105);
                    if (local318 != null && local318.method4631(local18, local261, local304)) {
                        this.method6697();
                        return;
                    }
                }
                if (local58.aClass8_Sub2_Sub3_1 != null) {
                    local318 = local58.aClass8_Sub2_Sub3_1.method9278(arg0, -120);
                    if (local318 != null && local318.method4631(local18, local261, local304)) {
                        this.method6697();
                        return;
                    }
                }
                if (local58.aClass8_Sub2_Sub2_1 != null) {
                    local318 = local58.aClass8_Sub2_Sub2_1.method9278(arg0, -109);
                    if (local318 != null && local318.method4631(local18, local261, local304)) {
                        this.method6697();
                        return;
                    }
                }
                for (@Pc(375) Class286 local375 = local58.aClass286_2; local375 != null; local375 = local375.aClass286_1) {
                    @Pc(382) Class205 local382 = local375.aClass8_Sub2_Sub1_1.method9278(arg0, -117);
                    if (local382 != null && local382.method4631(local18, local261, local304)) {
                        this.method6697();
                        return;
                    }
                }
            }
            local40.aClass230_1.aClass113_1.method2488(this);
        }
    }

    @OriginalMember(owner = "client!pp", name = "a", descriptor = "(Lclient!rf;IIIIIIIIIIIZZ)V")
    public void method6696(@OriginalArg(0) Class8_Sub8 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) boolean arg12, @OriginalArg(13) boolean arg13) {
        this.aClass8_Sub8_1 = arg0;
        super.anInt7537 = arg1 << 12;
        super.anInt7534 = arg2 << 12;
        super.anInt7536 = arg3 << 12;
        super.anInt7539 = arg9;
        this.aShort93 = this.aShort96 = (short) arg8;
        super.anInt7535 = arg10;
        super.anInt7540 = arg11;
        super.aBoolean574 = arg13;
        this.aShort92 = (short) arg4;
        this.aShort95 = (short) arg5;
        this.aShort94 = (short) arg6;
        this.anInt7542 = arg7;
        super.aByte122 = this.aClass8_Sub8_1.aMeshEmitter_1.aByte130;
        this.method6693();
    }

    @OriginalMember(owner = "client!pp", name = "b", descriptor = "()V")
    public void method6697() {
        this.aClass8_Sub8_1.aClass8_Sub5_6.aClass8_Sub4_Sub2_Sub1Array1[this.aShort91] = null;
        Static538.aClass8_Sub4_Sub2_Sub1Array2[Static559.anInt8410] = this;
        Static559.anInt8410 = Static559.anInt8410 + 1 & 0x3FF;
        this.method9274();
        this.method6686();
    }
}
