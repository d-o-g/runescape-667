import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static220 {

    @OriginalMember(owner = "client!gq", name = "d", descriptor = "I")
    public static int anInt3562;

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(III)Z")
    public static boolean method3197(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x10000) != 0;
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(IBIII)V")
    public static void method3198(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        for (@Pc(6) Node_Sub51 local6 = (Node_Sub51) Static460.A_DEQUE___40.first(); local6 != null; local6 = (Node_Sub51) Static460.A_DEQUE___40.next()) {
            Static632.method8366(arg0, local6, arg3, arg2, arg1);
        }
        if (-123 <= -127) {
            return;
        }
        @Pc(154) int local154;
        @Pc(198) boolean local198;
        for (@Pc(42) Node_Sub51 local42 = (Node_Sub51) Static717.A_DEQUE___81.first(); local42 != null; local42 = (Node_Sub51) Static717.A_DEQUE___81.next()) {
            @Pc(46) byte local46 = 1;
            @Pc(51) BASType local51 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.method9317();
            @Pc(57) int local57 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.aAnimator_10.getAnimationId();
            if (local57 == -1 || local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.aBoolean817) {
                local46 = 0;
            } else if (local57 == local51.run || local57 == local51.runFollowTurn180 || local57 == local51.runFollowTurnCw || local51.runFollowTurnCcw == local57) {
                local46 = 2;
            } else if (local51.crawl == local57 || local57 == local51.crawlFollowTurn180 || local51.crawlFollowTurnCw == local57 || local57 == local51.crawlFollowTurnCcw) {
                local46 = 3;
            }
            if (local42.anInt9364 != local46) {
                local154 = Static497.method6629(local42.aClass8_Sub2_Sub1_Sub2_Sub2_3);
                @Pc(158) NPCType local158 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.aNPCType_1;
                if (local158.multinpcs != null) {
                    local158 = local158.getMultiNPC(65535, Static34.aClass304_1);
                }
                if (local158 == null || local154 == -1) {
                    local42.anInt9364 = local46;
                    local42.aBoolean714 = false;
                    local42.anInt9353 = -1;
                } else if (local154 == local42.anInt9353 && local42.aBoolean714 == local158.vorbisSound) {
                    local42.anInt9364 = local46;
                    local42.anInt9358 = local158.soundVolume;
                } else {
                    local198 = false;
                    if (local42.aClass2_Sub6_Sub2_4 == null) {
                        local198 = true;
                    } else {
                        local42.anInt9358 -= 512;
                        if (local42.anInt9358 <= 0) {
                            Static336.aClass2_Sub6_Sub3_1.method5883(local42.aClass2_Sub6_Sub2_4);
                            local198 = true;
                            local42.aClass2_Sub6_Sub2_4 = null;
                        }
                    }
                    if (local198) {
                        local42.aClass2_Sub53_3 = null;
                        local42.aClass2_Sub49_Sub1_4 = null;
                        local42.aBoolean714 = local158.vorbisSound;
                        local42.anInt9358 = local158.soundVolume;
                        local42.anInt9364 = local46;
                        local42.anInt9353 = local154;
                    }
                }
            }
            local42.anInt9357 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.anInt10690;
            local42.anInt9362 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.anInt10690 + (local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.method9302((byte) 53) << 8);
            local42.anInt9352 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.anInt10694;
            local42.anInt9349 = local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.anInt10694 + (local42.aClass8_Sub2_Sub1_Sub2_Sub2_3.method9302((byte) 68) << 8);
            Static632.method8366(arg0, local42, arg3, arg2, arg1);
        }
        for (@Pc(329) Node_Sub51 local329 = (Node_Sub51) Static113.A_HASH_TABLE___12.first(); local329 != null; local329 = (Node_Sub51) Static113.A_HASH_TABLE___12.next()) {
            @Pc(333) byte local333 = 1;
            @Pc(338) BASType local338 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.method9317();
            local154 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.aAnimator_10.getAnimationId();
            if (local154 == -1 || local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.aBoolean817) {
                local333 = 0;
            } else if (local154 == local338.run || local154 == local338.runFollowTurn180 || local338.runFollowTurnCw == local154 || local154 == local338.runFollowTurnCcw) {
                local333 = 2;
            } else if (local338.crawl == local154 || local154 == local338.crawlFollowTurn180 || local338.crawlFollowTurnCw == local154 || local154 == local338.crawlFollowTurnCcw) {
                local333 = 3;
            }
            if (local333 != local329.anInt9364) {
                @Pc(448) int local448 = Static326.method4870(local329.aClass8_Sub2_Sub1_Sub2_Sub1_3);
                if (local329.anInt9353 == local448 && local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.aBoolean126 == local329.aBoolean714) {
                    local329.anInt9364 = local333;
                    local329.anInt9358 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt1460;
                } else {
                    local198 = false;
                    if (local329.aClass2_Sub6_Sub2_4 == null) {
                        local198 = true;
                    } else {
                        local329.anInt9358 -= 512;
                        if (local329.anInt9358 <= 0) {
                            Static336.aClass2_Sub6_Sub3_1.method5883(local329.aClass2_Sub6_Sub2_4);
                            local329.aClass2_Sub6_Sub2_4 = null;
                            local198 = true;
                        }
                    }
                    if (local198) {
                        local329.aBoolean714 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.aBoolean126;
                        local329.anInt9353 = local448;
                        local329.anInt9358 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt1460;
                        local329.aClass2_Sub49_Sub1_4 = null;
                        local329.anInt9364 = local333;
                        local329.aClass2_Sub53_3 = null;
                    }
                }
            }
            local329.anInt9357 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt10690;
            local329.anInt9362 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt10690 + (local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.method9302((byte) 127) << 8);
            local329.anInt9352 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt10694;
            local329.anInt9349 = local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.anInt10694 + (local329.aClass8_Sub2_Sub1_Sub2_Sub1_3.method9302((byte) 62) << 8);
            Static632.method8366(arg0, local329, arg3, arg2, arg1);
        }
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(ZIZI[Lclient!hda;I)V")
    public static void method3200(@OriginalArg(1) int arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Class158[] arg3, @OriginalArg(5) int arg4) {
        for (@Pc(5) int local5 = 0; local5 < arg3.length; local5++) {
            @Pc(14) Class158 local14 = arg3[local5];
            if (local14 != null && local14.anInt3743 == arg4) {
                Static507.method6743(arg1, arg2, arg0, local14);
                Static470.method6383(local14, arg0, arg2, -8525);
                if (local14.anInt3769 - local14.anInt3802 < local14.anInt3809) {
                    local14.anInt3809 = local14.anInt3769 - local14.anInt3802;
                }
                if (local14.anInt3809 < 0) {
                    local14.anInt3809 = 0;
                }
                if (local14.anInt3742 - local14.anInt3746 < local14.anInt3768) {
                    local14.anInt3768 = local14.anInt3742 - local14.anInt3746;
                }
                if (local14.anInt3768 < 0) {
                    local14.anInt3768 = 0;
                }
                if (local14.anInt3820 == 0) {
                    Static134.method8956(local14, arg1);
                }
            }
        }
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(Lclient!cd;Lclient!sb;Lclient!sb;Lclient!sb;ILclient!bd;)Z")
    public static boolean method3201(@OriginalArg(0) Class56 arg0, @OriginalArg(1) js5 arg1, @OriginalArg(2) js5 arg2, @OriginalArg(3) js5 arg3, @OriginalArg(5) Node_Sub6_Sub1 arg4) {
        Static581.aClass2_Sub6_Sub1_3 = arg4;
        Static296.aJs5_61 = arg1;
        Static91.aJs5_117 = arg2;
        Static286.anIntArray358 = new int[16];
        Static426.aClass56_2 = arg0;
        Static86.aJs5_13 = arg3;
        for (@Pc(25) int local25 = 0; local25 < 16; local25++) {
            Static286.anIntArray358[local25] = 255;
        }
        return true;
    }
}
