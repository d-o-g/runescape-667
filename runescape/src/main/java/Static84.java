import com.jagex.Static148;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static84 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!client", name = "Eb", descriptor = "Ljava/lang/Class;")
    public static Class aClass5;

    @OriginalMember(owner = "client!client", name = "a", descriptor = "()V")
    public static void method1652() {
        @Pc(1) int local1 = PlayerList.highResolutionCount;
        @Pc(3) int[] local3 = PlayerList.highResolutionSlots;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = CutsceneManager.actors.length;
        } else {
            local9 = Static353.noNpcs ? local1 : local1 + NPCList.size;
        }
        for (@Pc(21) int local21 = 0; local21 < local9; local21++) {
            @Pc(36) PathingEntity local36;
            if (CutsceneManager.state == 3) {
                @Pc(29) Actor local29 = CutsceneManager.actors[local21];
                if (!local29.initialised) {
                    continue;
                }
                local36 = local29.entity();
            } else {
                if (local21 < local1) {
                    local36 = PlayerList.highResolutionPlayers[local3[local21]];
                } else {
                    local36 = ((NPCEntityNode) NPCList.local.get(NPCList.slots[local21 - local1])).npc;
                }
                if (local36.drawPriority < 0) {
                    continue;
                }
            }
            @Pc(68) int local68 = local36.getSize();
            if ((local68 & 0x1) == 0) {
                if ((local36.x & 0x1FF) == 0 && (local36.z & 0x1FF) == 0) {
                    continue;
                }
            } else if ((local36.x & 0x1FF) == 256 && (local36.z & 0x1FF) == 256) {
                continue;
            }
            local36.y = Static102.averageHeight(local36.level, local36.x, local36.z);
            Static102.method2026(local36, true);
        }
    }

    @OriginalMember(owner = "client!client", name = "n", descriptor = "(I)V")
    public static void method1654(@OriginalArg(0) int arg0) {
        @Pc(1) int local1 = PlayerList.highResolutionCount;
        @Pc(3) int[] local3 = PlayerList.highResolutionSlots;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = CutsceneManager.actors.length;
        } else {
            local9 = Static353.noNpcs ? local1 : local1 + NPCList.size;
        }
        for (@Pc(21) int local21 = 0; local21 < local9; local21++) {
            @Pc(36) PathingEntity local36;
            if (CutsceneManager.state == 3) {
                @Pc(29) Actor local29 = CutsceneManager.actors[local21];
                if (!local29.initialised) {
                    continue;
                }
                local36 = local29.entity();
            } else {
                if (local21 < local1) {
                    local36 = PlayerList.highResolutionPlayers[local3[local21]];
                } else {
                    local36 = ((NPCEntityNode) NPCList.local.get(NPCList.slots[local21 - local1])).npc;
                }
                if (local36.level != arg0) {
                    continue;
                }
                if (local36.drawPriority < 0) {
                    local36.visible = false;
                    continue;
                }
            }
            local36.anInt10735 = 0;
            @Pc(80) int local80 = local36.getSize();
            if ((local80 & 0x1) == 0) {
                if ((local36.x & 0x1FF) != 0 || (local36.z & 0x1FF) != 0) {
                    local36.visible = false;
                    continue;
                }
            } else if ((local36.x & 0x1FF) != 256 || (local36.z & 0x1FF) != 256) {
                local36.visible = false;
                continue;
            }
            if (CutsceneManager.state != 3) {
                @Pc(135) int local135;
                @Pc(140) int local140;
                @Pc(166) int local166;
                if (local80 == 1) {
                    local135 = local36.x >> 9;
                    local140 = local36.z >> 9;
                    if (local36.drawPriority != Static341.entityDrawPriorities[local135][local140]) {
                        local36.visible = true;
                        continue;
                    }
                    if (Static148.anIntArrayArray64[local135][local140] > 1) {
                        local166 = Static148.anIntArrayArray64[local135][local140]--;
                        local36.visible = true;
                        continue;
                    }
                } else {
                    local135 = (local80 - 1) * 256 + 252;
                    local140 = local36.x - local135 >> 9;
                    @Pc(196) int local196 = local36.z - local135 >> 9;
                    @Pc(203) int local203 = local36.x + local135 >> 9;
                    @Pc(210) int local210 = local36.z + local135 >> 9;
                    if (!Static426.method1017(local203, local210, local140, local196, local36.drawPriority)) {
                        for (@Pc(221) int local221 = local140; local221 <= local203; local221++) {
                            for (@Pc(224) int local224 = local196; local224 <= local210; local224++) {
                                if (local36.drawPriority == Static341.entityDrawPriorities[local221][local224]) {
                                    local166 = Static148.anIntArrayArray64[local221][local224]--;
                                }
                            }
                        }
                        local36.visible = true;
                        continue;
                    }
                }
            }
            local36.visible = false;
            local36.y = Static102.averageHeight(local36.level, local36.x, local36.z);
            Static102.method2026(local36, true);
        }
    }

    @OriginalMember(owner = "client!client", name = "b", descriptor = "()V")
    public static void method1655() {
        @Pc(1) int local1 = PlayerList.highResolutionCount;
        @Pc(3) int[] local3 = PlayerList.highResolutionSlots;
        @Pc(8) int local8 = ClientOptions.instance.idleAnimations.getValue();
        @Pc(30) boolean local30 = local8 == 1 && local1 > 200 || local8 == 0 && local1 > 50;
        @Pc(103) int local103;
        for (@Pc(32) int local32 = 0; local32 < local1; local32++) {
            @Pc(39) PlayerEntity local39 = PlayerList.highResolutionPlayers[local3[local32]];
            if (!local39.hasModel()) {
                local39.drawPriority = -1;
            } else if (local39.hideOnMap) {
                local39.drawPriority = -1;
            } else {
                local39.updateBounds();
                if (local39.x1 >= 0 && local39.z1 >= 0 && local39.x2 < Static720.mapWidth && local39.z2 < Static501.mapLength) {
                    local39.aBoolean129 = local39.ready ? local30 : false;
                    if (local39 == PlayerEntity.self) {
                        local39.drawPriority = Integer.MAX_VALUE;
                    } else {
                        local103 = 0;
                        if (!local39.visible) {
                            local103++;
                        }
                        if (local39.healthClock > TimeUtils.clock) {
                            local103 += 2;
                        }
                        local103 += 5 - local39.getSize() << 2;
                        if (local39.showPIcon || local39.clanmate) {
                            local103 += 512;
                        } else {
                            if (Static150.drawOrder == 0) {
                                local103 += 32;
                            } else {
                                local103 += 128;
                            }
                            local103 += 256;
                        }
                        local39.drawPriority = local103 + 1;
                    }
                } else {
                    local39.drawPriority = -1;
                }
            }
        }
        for (@Pc(155) int local155 = 0; local155 < NPCList.size; local155++) {
            @Pc(166) NPCEntity local166 = ((NPCEntityNode) NPCList.local.get(NPCList.slots[local155])).npc;
            if (local166.hasType() && local166.type.isVisible(TimedVarDomain.instance)) {
                local166.updateBounds();
                if (local166.x1 >= 0 && local166.z1 >= 0 && local166.x2 < Static720.mapWidth && local166.z2 < Static501.mapLength) {
                    @Pc(213) int local213 = 0;
                    if (!local166.visible) {
                        local213++;
                    }
                    if (local166.healthClock > TimeUtils.clock) {
                        local213 += 2;
                    }
                    local213 += 5 - local166.getSize() << 2;
                    if (Static150.drawOrder == 0) {
                        if (local166.type.isFollower) {
                            local213 += 64;
                        } else {
                            local213 += 128;
                        }
                    } else if (Static150.drawOrder == 1) {
                        if (local166.type.isFollower) {
                            local213 += 32;
                        } else {
                            local213 += 64;
                        }
                    }
                    if (local166.type.renderHighPriority) {
                        local213 += 1024;
                    } else if (!local166.type.aBoolean503) {
                        local213 += 256;
                    }
                    local166.drawPriority = local213 + 1;
                } else {
                    local166.drawPriority = -1;
                }
            } else {
                local166.drawPriority = -1;
            }
        }
        for (local103 = 0; local103 < Static527.hintArrows.length; local103++) {
            @Pc(292) HintArrow local292 = Static527.hintArrows[local103];
            if (local292 != null) {
                if (local292.type == 1) {
                    @Pc(308) NPCEntityNode local308 = (NPCEntityNode) NPCList.local.get(local292.entity);
                    if (local308 != null) {
                        @Pc(313) NPCEntity local313 = local308.npc;
                        if (local313.drawPriority >= 0) {
                            local313.drawPriority += 2048;
                        }
                    }
                } else if (local292.type == 10) {
                    @Pc(333) PlayerEntity local333 = PlayerList.highResolutionPlayers[local292.entity];
                    if (local333 != null && local333 != PlayerEntity.self && local333.drawPriority >= 0) {
                        local333.drawPriority += 2048;
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hda;)Lclient!hda;")
    public static Component method1657(@OriginalArg(0) Component arg0) {
        @Pc(4) int local4 = InterfaceManager.serverActiveProperties(arg0).getDragDepth();
        if (local4 == 0) {
            return null;
        }
        for (@Pc(11) int local11 = 0; local11 < local4; local11++) {
            arg0 = InterfaceList.list(arg0.layer);
            if (arg0 == null) {
                return null;
            }
        }
        return arg0;
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "()V")
    public static void method1664() {
        Static172.anInt2893 = 0;
        for (@Pc(3) int local3 = 0; local3 < NPCList.size; local3++) {
            @Pc(14) NPCEntity local14 = ((NPCEntityNode) NPCList.local.get(NPCList.slots[local3])).npc;
            if (local14.visible && local14.method9304((byte) -123) != -1) {
                @Pc(34) int local34 = (local14.getSize() - 1) * 256 + 252;
                @Pc(41) int local41 = local14.x - local34 >> 9;
                @Pc(48) int local48 = local14.z - local34 >> 9;
                @Pc(55) PathingEntity local55 = Static184.method2798(local41, local48, local14.level);
                if (local55 != null) {
                    @Pc(60) int local60 = local55.slot;
                    if (local55 instanceof NPCEntity) {
                        local60 += 2048;
                    }
                    if (local55.anInt10735 == 0 && local55.method9304((byte) -121) != -1) {
                        Static324.anIntArray390[Static172.anInt2893] = local60;
                        Static212.anIntArray283[Static172.anInt2893] = local60;
                        Static172.anInt2893++;
                        local55.anInt10735++;
                    }
                    Static324.anIntArray390[Static172.anInt2893] = local60;
                    Static212.anIntArray283[Static172.anInt2893] = local14.slot + 2048;
                    Static172.anInt2893++;
                    local55.anInt10735++;
                }
            }
        }
        Static163.method8852(Static212.anIntArray283, Static172.anInt2893 - 1, Static324.anIntArray390, 0);
    }

    @OriginalMember(owner = "client!client", name = "d", descriptor = "()V")
    public static void method1665() {
        for (@Pc(1) int local1 = 0; local1 < Static720.mapWidth; local1++) {
            @Pc(6) int[] local6 = Static341.entityDrawPriorities[local1];
            for (@Pc(8) int local8 = 0; local8 < Static501.mapLength; local8++) {
                local6[local8] = 0;
            }
        }
    }

    @OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
    public static void method1670(@OriginalArg(0) int arg0) {
        @Pc(1) int local1 = PlayerList.highResolutionCount;
        @Pc(3) int[] local3 = PlayerList.highResolutionSlots;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = CutsceneManager.actors.length;
        } else {
            local9 = local1 + NPCList.size;
        }
        for (@Pc(16) int local16 = 0; local16 < local9; local16++) {
            @Pc(31) PathingEntity local31;
            if (CutsceneManager.state == 3) {
                @Pc(24) Actor local24 = CutsceneManager.actors[local16];
                if (!local24.initialised) {
                    continue;
                }
                local31 = local24.entity();
            } else {
                if (local16 < local1) {
                    local31 = PlayerList.highResolutionPlayers[local3[local16]];
                } else {
                    local31 = ((NPCEntityNode) NPCList.local.get(NPCList.slots[local16 - local1])).npc;
                }
                if (local31.level != arg0 || local31.drawPriority < 0) {
                    continue;
                }
            }
            @Pc(69) int local69 = local31.getSize();
            if ((local69 & 0x1) == 0) {
                if ((local31.x & 0x1FF) != 0 || (local31.z & 0x1FF) != 0) {
                    continue;
                }
            } else if ((local31.x & 0x1FF) != 256 || (local31.z & 0x1FF) != 256) {
                continue;
            }
            @Pc(113) int local113;
            @Pc(118) int local118;
            @Pc(155) int local155;
            if (local69 == 1) {
                local113 = local31.x >> 9;
                local118 = local31.z >> 9;
                if (local31.drawPriority > Static341.entityDrawPriorities[local113][local118]) {
                    Static341.entityDrawPriorities[local113][local118] = local31.drawPriority;
                    Static148.anIntArrayArray64[local113][local118] = 1;
                } else if (local31.drawPriority == Static341.entityDrawPriorities[local113][local118]) {
                    local155 = Static148.anIntArrayArray64[local113][local118]++;
                }
            } else {
                local113 = (local69 - 1) * 256 + 60;
                local118 = local31.x - local113 >> 9;
                @Pc(182) int local182 = local31.z - local113 >> 9;
                @Pc(189) int local189 = local31.x + local113 >> 9;
                @Pc(196) int local196 = local31.z + local113 >> 9;
                for (@Pc(198) int local198 = local118; local198 <= local189; local198++) {
                    for (@Pc(201) int local201 = local182; local201 <= local196; local201++) {
                        if (local31.drawPriority > Static341.entityDrawPriorities[local198][local201]) {
                            Static341.entityDrawPriorities[local198][local201] = local31.drawPriority;
                            Static148.anIntArrayArray64[local198][local201] = 1;
                        } else if (local31.drawPriority == Static341.entityDrawPriorities[local198][local201]) {
                            local155 = Static148.anIntArrayArray64[local198][local201]++;
                        }
                    }
                }
            }
        }
    }
}
