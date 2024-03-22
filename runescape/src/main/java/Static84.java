import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static84 {

    @OriginalMember(owner = "client!client", name = "wb", descriptor = "I")
    public static int anInt1775;

    // $FF: synthetic field
    @OriginalMember(owner = "client!client", name = "Eb", descriptor = "Ljava/lang/Class;")
    public static Class aClass5;

    @OriginalMember(owner = "client!client", name = "vb", descriptor = "Lclient!pc;")
    public static final Class287 aClass287_6 = new Class287(11, 8);

    @OriginalMember(owner = "client!client", name = "tb", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___36 = new ServerProt(28, 4);

    @OriginalMember(owner = "client!client", name = "a", descriptor = "()V")
    public static void method1652() {
        @Pc(1) int local1 = Static338.anInt5564;
        @Pc(3) int[] local3 = Static210.anIntArray280;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = Static219.aClass236Array1.length;
        } else {
            local9 = Static353.aBoolean734 ? local1 : local1 + Static390.anInt6126;
        }
        for (@Pc(21) int local21 = 0; local21 < local9; local21++) {
            @Pc(36) Class8_Sub2_Sub1_Sub2 local36;
            if (CutsceneManager.state == 3) {
                @Pc(29) Class236 local29 = Static219.aClass236Array1[local21];
                if (!local29.aBoolean455) {
                    continue;
                }
                local36 = local29.method5363();
            } else {
                if (local21 < local1) {
                    local36 = PlayerList.highResolutionPlayers[local3[local21]];
                } else {
                    local36 = ((Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local21 - local1])).aClass8_Sub2_Sub1_Sub2_Sub2_2;
                }
                if (local36.drawPriority < 0) {
                    continue;
                }
            }
            @Pc(68) int local68 = local36.boundSize((byte) 81);
            if ((local68 & 0x1) == 0) {
                if ((local36.x & 0x1FF) == 0 && (local36.z & 0x1FF) == 0) {
                    continue;
                }
            } else if ((local36.x & 0x1FF) == 256 && (local36.z & 0x1FF) == 256) {
                continue;
            }
            local36.anInt10691 = Static102.method2025(local36.level, -29754, local36.z, local36.x);
            Static102.method2026(local36, true);
        }
    }

    @OriginalMember(owner = "client!client", name = "n", descriptor = "(I)V")
    public static void method1654(@OriginalArg(0) int arg0) {
        @Pc(1) int local1 = Static338.anInt5564;
        @Pc(3) int[] local3 = Static210.anIntArray280;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = Static219.aClass236Array1.length;
        } else {
            local9 = Static353.aBoolean734 ? local1 : local1 + Static390.anInt6126;
        }
        for (@Pc(21) int local21 = 0; local21 < local9; local21++) {
            @Pc(36) Class8_Sub2_Sub1_Sub2 local36;
            if (CutsceneManager.state == 3) {
                @Pc(29) Class236 local29 = Static219.aClass236Array1[local21];
                if (!local29.aBoolean455) {
                    continue;
                }
                local36 = local29.method5363();
            } else {
                if (local21 < local1) {
                    local36 = PlayerList.highResolutionPlayers[local3[local21]];
                } else {
                    local36 = ((Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local21 - local1])).aClass8_Sub2_Sub1_Sub2_Sub2_2;
                }
                if (local36.level != arg0) {
                    continue;
                }
                if (local36.drawPriority < 0) {
                    local36.aBoolean816 = false;
                    continue;
                }
            }
            local36.anInt10735 = 0;
            @Pc(80) int local80 = local36.boundSize((byte) 121);
            if ((local80 & 0x1) == 0) {
                if ((local36.x & 0x1FF) != 0 || (local36.z & 0x1FF) != 0) {
                    local36.aBoolean816 = false;
                    continue;
                }
            } else if ((local36.x & 0x1FF) != 256 || (local36.z & 0x1FF) != 256) {
                local36.aBoolean816 = false;
                continue;
            }
            if (CutsceneManager.state != 3) {
                @Pc(135) int local135;
                @Pc(140) int local140;
                @Pc(166) int local166;
                if (local80 == 1) {
                    local135 = local36.x >> 9;
                    local140 = local36.z >> 9;
                    if (local36.drawPriority != Static341.anIntArrayArray133[local135][local140]) {
                        local36.aBoolean816 = true;
                        continue;
                    }
                    if (Static148.anIntArrayArray64[local135][local140] > 1) {
                        local166 = Static148.anIntArrayArray64[local135][local140]--;
                        local36.aBoolean816 = true;
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
                                if (local36.drawPriority == Static341.anIntArrayArray133[local221][local224]) {
                                    local166 = Static148.anIntArrayArray64[local221][local224]--;
                                }
                            }
                        }
                        local36.aBoolean816 = true;
                        continue;
                    }
                }
            }
            local36.aBoolean816 = false;
            local36.anInt10691 = Static102.method2025(local36.level, -29754, local36.z, local36.x);
            Static102.method2026(local36, true);
        }
    }

    @OriginalMember(owner = "client!client", name = "b", descriptor = "()V")
    public static void method1655() {
        @Pc(1) int local1 = Static338.anInt5564;
        @Pc(3) int[] local3 = Static210.anIntArray280;
        @Pc(8) int local8 = ClientOptions.instance.aClass57_Sub27_1.method7667();
        @Pc(30) boolean local30 = local8 == 1 && local1 > 200 || local8 == 0 && local1 > 50;
        @Pc(103) int local103;
        for (@Pc(32) int local32 = 0; local32 < local1; local32++) {
            @Pc(39) PlayerEntity local39 = PlayerList.highResolutionPlayers[local3[local32]];
            if (!local39.method1417()) {
                local39.drawPriority = -1;
            } else if (local39.aBoolean124) {
                local39.drawPriority = -1;
            } else {
                local39.method9294();
                if (local39.aShort131 >= 0 && local39.aShort132 >= 0 && local39.aShort134 < Static720.mapWidth && local39.aShort133 < Static501.mapHeight) {
                    local39.aBoolean129 = local39.ready ? local30 : false;
                    if (local39 == PlayerEntity.self) {
                        local39.drawPriority = Integer.MAX_VALUE;
                    } else {
                        local103 = 0;
                        if (!local39.aBoolean816) {
                            local103++;
                        }
                        if (local39.anInt10747 > TimeUtils.clock) {
                            local103 += 2;
                        }
                        local103 += 5 - local39.boundSize((byte) 67) << 2;
                        if (local39.aBoolean128 || local39.aBoolean125) {
                            local103 += 512;
                        } else {
                            if (Static150.anInt2632 == 0) {
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
        for (@Pc(155) int local155 = 0; local155 < Static390.anInt6126; local155++) {
            @Pc(166) NPCEntity local166 = ((Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local155])).aClass8_Sub2_Sub1_Sub2_Sub2_2;
            if (local166.method9322() && local166.type.isVisible(TimedVarDomain.instance)) {
                local166.method9294();
                if (local166.aShort131 >= 0 && local166.aShort132 >= 0 && local166.aShort134 < Static720.mapWidth && local166.aShort133 < Static501.mapHeight) {
                    @Pc(213) int local213 = 0;
                    if (!local166.aBoolean816) {
                        local213++;
                    }
                    if (local166.anInt10747 > TimeUtils.clock) {
                        local213 += 2;
                    }
                    local213 += 5 - local166.boundSize((byte) 88) << 2;
                    if (Static150.anInt2632 == 0) {
                        if (local166.type.isFollower) {
                            local213 += 64;
                        } else {
                            local213 += 128;
                        }
                    } else if (Static150.anInt2632 == 1) {
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
        for (local103 = 0; local103 < Static527.aClass254Array1.length; local103++) {
            @Pc(292) Class254 local292 = Static527.aClass254Array1[local103];
            if (local292 != null) {
                if (local292.anInt6363 == 1) {
                    @Pc(308) Node_Sub45 local308 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) local292.anInt6366);
                    if (local308 != null) {
                        @Pc(313) NPCEntity local313 = local308.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                        if (local313.drawPriority >= 0) {
                            local313.drawPriority += 2048;
                        }
                    }
                } else if (local292.anInt6363 == 10) {
                    @Pc(333) PlayerEntity local333 = PlayerList.highResolutionPlayers[local292.anInt6366];
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

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!pg;)V")
    public static void method1662(@OriginalArg(1) DoublyLinkedNode_Sub2_Sub16 arg0) {
        if (arg0 == null) {
            return;
        }
        Static693.A_DEQUE___79.addLast(arg0);
        MiniMenu.optionCount++;
        @Pc(33) DoublyLinkedNode_Sub2_Sub4 local33;
        if (arg0.aBoolean551 || "".equals(arg0.aString86)) {
            local33 = new DoublyLinkedNode_Sub2_Sub4(arg0.aString86);
            Static31.anInt767++;
        } else {
            @Pc(41) long local41 = arg0.aLong234;
            for (local33 = (DoublyLinkedNode_Sub2_Sub4) Static490.A_HASH_TABLE___34.get(local41); local33 != null && !local33.aString10.equals(arg0.aString86); local33 = (DoublyLinkedNode_Sub2_Sub4) Static490.A_HASH_TABLE___34.nextWithSameKey()) {
            }
            if (local33 == null) {
                local33 = (DoublyLinkedNode_Sub2_Sub4) Static717.A_WEIGHTED_CACHE___232.get(local41);
                if (local33 != null && !local33.aString10.equals(arg0.aString86)) {
                    local33 = null;
                }
                if (local33 == null) {
                    local33 = new DoublyLinkedNode_Sub2_Sub4(arg0.aString86);
                }
                Static490.A_HASH_TABLE___34.put(local41, local33);
                Static31.anInt767++;
            }
        }
        if (local33.method1471(arg0)) {
            Static385.method5424(local33);
        }
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "()V")
    public static void method1664() {
        Static172.anInt2893 = 0;
        for (@Pc(3) int local3 = 0; local3 < Static390.anInt6126; local3++) {
            @Pc(14) NPCEntity local14 = ((Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local3])).aClass8_Sub2_Sub1_Sub2_Sub2_2;
            if (local14.aBoolean816 && local14.method9304((byte) -123) != -1) {
                @Pc(34) int local34 = (local14.boundSize((byte) 63) - 1) * 256 + 252;
                @Pc(41) int local41 = local14.x - local34 >> 9;
                @Pc(48) int local48 = local14.z - local34 >> 9;
                @Pc(55) Class8_Sub2_Sub1_Sub2 local55 = Static184.method2798(local41, local48, local14.level);
                if (local55 != null) {
                    @Pc(60) int local60 = local55.anInt10740;
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
                    Static212.anIntArray283[Static172.anInt2893] = local14.anInt10740 + 2048;
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
            @Pc(6) int[] local6 = Static341.anIntArrayArray133[local1];
            for (@Pc(8) int local8 = 0; local8 < Static501.mapHeight; local8++) {
                local6[local8] = 0;
            }
        }
    }

    @OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
    public static void method1670(@OriginalArg(0) int arg0) {
        @Pc(1) int local1 = Static338.anInt5564;
        @Pc(3) int[] local3 = Static210.anIntArray280;
        @Pc(9) int local9;
        if (CutsceneManager.state == 3) {
            local9 = Static219.aClass236Array1.length;
        } else {
            local9 = local1 + Static390.anInt6126;
        }
        for (@Pc(16) int local16 = 0; local16 < local9; local16++) {
            @Pc(31) Class8_Sub2_Sub1_Sub2 local31;
            if (CutsceneManager.state == 3) {
                @Pc(24) Class236 local24 = Static219.aClass236Array1[local16];
                if (!local24.aBoolean455) {
                    continue;
                }
                local31 = local24.method5363();
            } else {
                if (local16 < local1) {
                    local31 = PlayerList.highResolutionPlayers[local3[local16]];
                } else {
                    local31 = ((Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local16 - local1])).aClass8_Sub2_Sub1_Sub2_Sub2_2;
                }
                if (local31.level != arg0 || local31.drawPriority < 0) {
                    continue;
                }
            }
            @Pc(69) int local69 = local31.boundSize((byte) 102);
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
                if (local31.drawPriority > Static341.anIntArrayArray133[local113][local118]) {
                    Static341.anIntArrayArray133[local113][local118] = local31.drawPriority;
                    Static148.anIntArrayArray64[local113][local118] = 1;
                } else if (local31.drawPriority == Static341.anIntArrayArray133[local113][local118]) {
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
                        if (local31.drawPriority > Static341.anIntArrayArray133[local198][local201]) {
                            Static341.anIntArrayArray133[local198][local201] = local31.drawPriority;
                            Static148.anIntArrayArray64[local198][local201] = 1;
                        } else if (local31.drawPriority == Static341.anIntArrayArray133[local198][local201]) {
                            local155 = Static148.anIntArrayArray64[local198][local201]++;
                        }
                    }
                }
            }
        }
    }
}
