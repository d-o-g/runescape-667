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
    public static void method3198(@OriginalArg(0) int currentTick, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        for (@Pc(6) Node_Sub51 local6 = (Node_Sub51) Static460.A_DEQUE___40.first(); local6 != null; local6 = (Node_Sub51) Static460.A_DEQUE___40.next()) {
            Static632.method8366(currentTick, local6, arg3, arg2, arg1);
        }

        for (@Pc(42) Node_Sub51 local42 = (Node_Sub51) Static717.A_DEQUE___81.first(); local42 != null; local42 = (Node_Sub51) Static717.A_DEQUE___81.next()) {
            @Pc(51) BASType basType = local42.npc.method9317();
            @Pc(57) int animation = local42.npc.animator.getAnimationId();

            @Pc(46) byte movementSpeed = 1;
            if (animation == -1 || local42.npc.ready) {
                movementSpeed = 0;
            } else if (animation == basType.run || animation == basType.runFollowTurn180 || animation == basType.runFollowTurnCw || animation == basType.runFollowTurnCcw) {
                movementSpeed = 2;
            } else if (animation == basType.crawl || animation == basType.crawlFollowTurn180 || animation == basType.crawlFollowTurnCw || animation == basType.crawlFollowTurnCcw) {
                movementSpeed = 3;
            }

            if (local42.movementSpeed != movementSpeed) {
                @Pc(154) int currentSound = NPCEntity.currentSound(local42.npc);

                @Pc(158) NPCType npcType = local42.npc.type;
                if (npcType.multinpcs != null) {
                    npcType = npcType.getMultiNPC(TimedVarDomain.instance);
                }

                if (npcType == null || currentSound == -1) {
                    local42.movementSpeed = movementSpeed;
                    local42.vorbis = false;
                    local42.sound = -1;
                } else if (currentSound == local42.sound && local42.vorbis == npcType.vorbisSound) {
                    local42.movementSpeed = movementSpeed;
                    local42.soundVolume = npcType.soundVolume;
                } else {
                    @Pc(198) boolean local198 = false;

                    if (local42.aClass2_Sub6_Sub2_4 == null) {
                        local198 = true;
                    } else {
                        local42.soundVolume -= 512;

                        if (local42.soundVolume <= 0) {
                            Static336.aClass2_Sub6_Sub3_1.method5883(local42.aClass2_Sub6_Sub2_4);
                            local198 = true;
                            local42.aClass2_Sub6_Sub2_4 = null;
                        }
                    }

                    if (local198) {
                        local42.aClass2_Sub53_3 = null;
                        local42.aClass2_Sub49_Sub1_4 = null;
                        local42.vorbis = npcType.vorbisSound;
                        local42.soundVolume = npcType.soundVolume;
                        local42.movementSpeed = movementSpeed;
                        local42.sound = currentSound;
                    }
                }
            }

            local42.anInt9357 = local42.npc.anInt10690;
            local42.anInt9362 = local42.npc.anInt10690 + (local42.npc.boundSize((byte) 53) << 8);
            local42.anInt9352 = local42.npc.anInt10694;
            local42.anInt9349 = local42.npc.anInt10694 + (local42.npc.boundSize((byte) 68) << 8);

            Static632.method8366(currentTick, local42, arg3, arg2, arg1);
        }

        for (@Pc(329) Node_Sub51 local329 = (Node_Sub51) Static113.A_HASH_TABLE___12.first(); local329 != null; local329 = (Node_Sub51) Static113.A_HASH_TABLE___12.next()) {
            @Pc(338) BASType basType = local329.player.method9317();
            @Pc(154) int animation = local329.player.animator.getAnimationId();

            @Pc(333) byte movementSpeed = 1;
            if (animation == -1 || local329.player.ready) {
                movementSpeed = 0;
            } else if (animation == basType.run || animation == basType.runFollowTurn180 || basType.runFollowTurnCw == animation || animation == basType.runFollowTurnCcw) {
                movementSpeed = 2;
            } else if (basType.crawl == animation || animation == basType.crawlFollowTurn180 || basType.crawlFollowTurnCw == animation || animation == basType.crawlFollowTurnCcw) {
                movementSpeed = 3;
            }

            if (movementSpeed != local329.movementSpeed) {
                @Pc(448) int currentSound = PlayerEntity.method4870(local329.player);

                if (local329.sound == currentSound && local329.player.vorbis == local329.vorbis) {
                    local329.movementSpeed = movementSpeed;
                    local329.soundVolume = local329.player.soundVolume;
                } else {
                    @Pc(198) boolean local198 = false;

                    if (local329.aClass2_Sub6_Sub2_4 == null) {
                        local198 = true;
                    } else {
                        local329.soundVolume -= 512;

                        if (local329.soundVolume <= 0) {
                            Static336.aClass2_Sub6_Sub3_1.method5883(local329.aClass2_Sub6_Sub2_4);
                            local329.aClass2_Sub6_Sub2_4 = null;
                            local198 = true;
                        }
                    }

                    if (local198) {
                        local329.vorbis = local329.player.vorbis;
                        local329.sound = currentSound;
                        local329.soundVolume = local329.player.soundVolume;
                        local329.aClass2_Sub49_Sub1_4 = null;
                        local329.movementSpeed = movementSpeed;
                        local329.aClass2_Sub53_3 = null;
                    }
                }
            }

            local329.anInt9357 = local329.player.anInt10690;
            local329.anInt9362 = local329.player.anInt10690 + (local329.player.boundSize((byte) 127) << 8);
            local329.anInt9352 = local329.player.anInt10694;
            local329.anInt9349 = local329.player.anInt10694 + (local329.player.boundSize((byte) 62) << 8);

            Static632.method8366(currentTick, local329, arg3, arg2, arg1);
        }
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(ZIZI[Lclient!hda;I)V")
    public static void method3200(@OriginalArg(1) int arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Component[] arg3, @OriginalArg(5) int arg4) {
        for (@Pc(5) int local5 = 0; local5 < arg3.length; local5++) {
            @Pc(14) Component local14 = arg3[local5];
            if (local14 != null && local14.layer == arg4) {
                Static507.method6743(arg1, arg2, arg0, local14);
                Static470.method6383(local14, arg0, arg2, -8525);
                if (local14.scrollWidth - local14.width < local14.scrollX) {
                    local14.scrollX = local14.scrollWidth - local14.width;
                }
                if (local14.scrollX < 0) {
                    local14.scrollX = 0;
                }
                if (local14.scrollHeight - local14.height < local14.scrollY) {
                    local14.scrollY = local14.scrollHeight - local14.height;
                }
                if (local14.scrollY < 0) {
                    local14.scrollY = 0;
                }
                if (local14.type == 0) {
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
