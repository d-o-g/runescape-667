import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MiniMenu {
    @OriginalMember(owner = "client!mk", name = "c", descriptor = "Z")
    public static boolean open = false;

    @OriginalMember(owner = "client!cja", name = "l", descriptor = "I")
    public static int anInt1634;

    @OriginalMember(owner = "client!sn", name = "j", descriptor = "I")
    public static int optionCount = 0;

    @OriginalMember(owner = "client!cja", name = "b", descriptor = "(B)V")
    public static void reset() {
        for (@Pc(10) DoublyLinkedNode_Sub2_Sub4 local10 = (DoublyLinkedNode_Sub2_Sub4) Static350.A_QUEUE___8.first(); local10 != null; local10 = (DoublyLinkedNode_Sub2_Sub4) Static350.A_QUEUE___8.next()) {
            if (local10.anInt1534 > 1) {
                local10.anInt1534 = 0;
                Static717.A_WEIGHTED_CACHE___232.put(local10, ((DoublyLinkedNode_Sub2_Sub16) local10.aQueue_3.sentinel.next2).aLong234);
                local10.aQueue_3.clear();
            }
        }
        optionCount = 0;
        Static31.anInt767 = 0;
        if (98 != 98) {
            anInt1634 = 47;
        }
        Static693.A_DEQUE___79.clear();
        Static490.A_HASH_TABLE___34.clear();
        Static350.A_QUEUE___8.clear();
        Static84.method1662(Static525.aClass2_Sub2_Sub16_12);
    }

    @OriginalMember(owner = "client!nea", name = "a", descriptor = "(ILclient!hda;II)V")
    public static void addMiniMenuOptions(@OriginalArg(1) Component arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (InterfaceManager.isTargeting) {
            @Pc(16) ParamType local16 = Static610.anInt9329 == -1 ? null : Static523.instance.list(Static610.anInt9329);
            if (InterfaceManager.serverActiveProperties(arg0).isUseTarget() && (InterfaceManager.targetMask & 0x20) != 0 && (local16 == null || arg0.param(local16.defaultint, Static610.anInt9329) != local16.defaultint)) {
                addEntry(false, arg0.invObject, 0L, arg0.id, arg0.slot, InterfaceManager.targetVerb, 18, true, Cursor.targetEnter, InterfaceManager.targetedVerb + " -> " + arg0.opBase, (long) (arg0.id << 0 | arg0.slot), false);
            }
        }
        @Pc(106) String local106;
        for (@Pc(97) int local97 = 9; local97 >= 5; local97--) {
            local106 = InterfaceManager.getOp(arg0, local97);
            if (local106 != null) {
                addEntry(false, arg0.invObject, (long) (local97 + 1), arg0.id, arg0.slot, local106, 1002, true, Static372.method5292(local97, arg0), arg0.opBase, (long) (arg0.slot | arg0.id << 0), false);
            }
        }
        local106 = InterfaceManager.getComponentTargetVerb(arg0);
        if (local106 != null) {
            addEntry(false, arg0.invObject, 0L, arg0.id, arg0.slot, local106, 12, true, arg0.anInt3776, arg0.opBase, (long) (arg0.id << 0 | arg0.slot), false);
        }
        for (@Pc(193) int local193 = 4; local193 >= 0; local193--) {
            @Pc(204) String local204 = InterfaceManager.getOp(arg0, local193);
            if (local204 != null) {
                addEntry(false, arg0.invObject, (long) (local193 + 1), arg0.id, arg0.slot, local204, 20, true, Static372.method5292(local193, arg0), arg0.opBase, (long) (arg0.slot | arg0.id << 0), false);
            }
        }
        if (!InterfaceManager.serverActiveProperties(arg0).isPauseButton()) {
            return;
        }
        if (arg0.pauseText == null) {
            addEntry(false, arg0.invObject, 0L, arg0.id, arg0.slot, LocalisedText.CONTINUE.localise(Static51.language), 10, true, -1, "", (long) (arg0.slot | arg0.id << 0), false);
        } else {
            addEntry(false, arg0.invObject, 0L, arg0.id, arg0.slot, arg0.pauseText, 10, true, -1, "", (long) (arg0.slot | arg0.id << 0), false);
        }
    }

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(IIILclient!ha;)V")
    public static void addEntries3DView(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Toolkit arg2) {
        if (arg1 < 0 || arg0 < 0 || Static240.anInt3955 == 0 || Static275.anInt4424 == 0) {
            return;
        }
        @Pc(38) Matrix local38;
        @Pc(57) int local57;
        @Pc(45) int local45;
        @Pc(49) int local49;
        @Pc(53) int local53;
        @Pc(63) int local63;
        @Pc(69) int local69;
        if (InterfaceManager.aBoolean210) {
            Static713.method9331(false);
            local38 = arg2.method8017();
            @Pc(41) int[] local41 = arg2.Y();
            local45 = local41[1];
            local49 = local41[2];
            local53 = local41[3];
            local57 = local41[0];
            local63 = Static242.method3503(false) + arg1;
            local69 = Static580.method7649(false) + arg0;
        } else {
            arg2.DA(Static168.anInt2842, Static232.anInt3829, Static240.anInt3955, Static275.anInt4424);
            local49 = Static240.anInt3955;
            local53 = Static275.anInt4424;
            local45 = Static232.anInt3829;
            local57 = Static168.anInt2842;
            arg2.KA(InterfaceManager.optionsX, InterfaceManager.optionsY, Static240.anInt3955, Static275.anInt4424);
            local38 = arg2.createMatrix();
            local38.method7135(Static428.anInt6487, Static427.anInt6480, Static523.anInt3888, Static524.anInt8044, Static271.anInt4363, Static707.anInt10641);
            local63 = arg1;
            arg2.setCamera(local38);
            local69 = arg0;
        }
        Static501.method6716(true);
        if (local53 == 0) {
            local53 = 1;
        }
        if (local49 == 0) {
            local49 = 1;
        }
        @Pc(148) int local148;
        @Pc(177) int local177;
        @Pc(186) int local186;
        @Pc(286) int local286;
        @Pc(295) int local295;
        @Pc(306) int local306;
        @Pc(317) int local317;
        @Pc(140) int local140;
        @Pc(370) int local370;
        if (Static706.aGroundArray3 != null && (!InterfaceManager.isTargeting || (InterfaceManager.targetMask & 0x40) != 0)) {
            local140 = -1;
            @Pc(142) int local142 = -1;
            @Pc(145) int local145 = arg2.i();
            local148 = arg2.XA();
            @Pc(159) int local159;
            @Pc(168) int local168;
            if (Static504.aBoolean579) {
                local177 = local168 = Static582.anInt8627 * (local63 - local57) / local49;
                local159 = local186 = Static582.anInt8627 * (local69 - local45) / local53;
            } else {
                local159 = (local69 - local45) * local145 / local53;
                local168 = local148 * (local63 - local57) / local49;
                local177 = (local63 - local57) * local145 / local49;
                local186 = (local69 - local45) * local148 / local53;
            }
            @Pc(224) int[] local224 = new int[]{local177, local159, local145};
            @Pc(239) int[] local239 = new int[]{local168, local186, local148};
            local38.method7126(local224);
            local38.method7126(local239);
            @Pc(273) float local273 = Static394.method5543((float) local224[0], (float) local239[2], 4, (float) local224[2], (float) local239[1], (float) local224[1], (float) local239[0]);
            if (local273 > 0.0F) {
                local286 = local239[0] - local224[0];
                local295 = local239[2] - local224[2];
                local306 = (int) ((float) local224[0] + local273 * (float) local286);
                local317 = (int) ((float) local224[2] + local273 * (float) local295);
                local140 = local306 + (PlayerEntity.self.boundSize((byte) 111) - 1 << 8) >> 9;
                local142 = local317 + (PlayerEntity.self.boundSize((byte) 102) - 1 << 8) >> 9;
                @Pc(345) byte local345 = PlayerEntity.self.level;
                if (local345 < 3 && (Static280.tileFlags[1][local306 >> 9][local317 >> 9] & 0x2) != 0) {
                    local370 = local345 + 1;
                }
            }
            if (local140 != -1 && local142 != -1) {
                if (InterfaceManager.isTargeting && (InterfaceManager.targetMask & 0x40) != 0) {
                    @Pc(453) Component local453 = InterfaceList.getComponent(Static77.anInt1614, Static450.anInt6819);
                    if (local453 == null) {
                        InterfaceManager.endTargetMode();
                    } else {
                        addEntry(false, -1, 0L, local140, local142, InterfaceManager.targetVerb, 21, true, Cursor.targetEnter, " ->", (long) (local140 << 0 | local142), true);
                    }
                } else {
                    if (Static501.aBoolean576) {
                        addEntry(false, -1, 0L, local140, local142, LocalisedText.FACEHERE.localise(Static51.language), 11, true, -1, "", (long) (local142 | local140 << 0), true);
                    }
                    addEntry(false, -1, 0L, local140, local142, Static331.walkText, 58, true, Static331.walkCursor, "", (long) (local142 | local140 << 0), true);
                }
            }
        }
        if (InterfaceManager.aBoolean210) {
            Static480.method6469();
        }
        for (local140 = 0; local140 < (InterfaceManager.aBoolean210 ? 2 : 1); local140++) {
            @Pc(503) boolean local503 = local140 == 0;
            @Pc(510) Class213 local510 = local503 ? Static514.aClass213_2 : Static10.aClass213_1;
            local148 = arg1;
            local177 = arg0;
            if (InterfaceManager.aBoolean210) {
                Static713.method9331(local503);
                local148 = arg1 + Static242.method3503(local503);
                local177 = arg0 + Static580.method7649(local503);
            }
            @Pc(538) LinkedList local538 = local510.aLinkedList_8;
            for (@Pc(543) Class8_Sub7 local543 = (Class8_Sub7) local538.first(); local543 != null; local543 = (Class8_Sub7) local538.next()) {
                if ((Static273.aBoolean340 || local543.aRenderable_18.level == PlayerEntity.self.level) && local543.method6496(arg2, local177, local148)) {
                    @Pc(584) int local584;
                    if (local543.aRenderable_18 instanceof PositionEntity) {
                        local186 = ((PositionEntity) local543.aRenderable_18).aShort131;
                        local584 = ((PositionEntity) local543.aRenderable_18).aShort132;
                    } else {
                        local584 = local543.aRenderable_18.anInt10694 >> 9;
                        local186 = local543.aRenderable_18.anInt10690 >> 9;
                    }
                    @Pc(723) int local723;
                    @Pc(735) int local735;
                    @Pc(864) int local864;
                    @Pc(614) int local614;
                    if (local543.aRenderable_18 instanceof PlayerEntity) {
                        @Pc(610) PlayerEntity local610 = (PlayerEntity) local543.aRenderable_18;
                        local614 = local610.boundSize((byte) 50);
                        if ((local614 & 0x1) == 0 && (local610.anInt10690 & 0x1FF) == 0 && (local610.anInt10694 & 0x1FF) == 0 || (local614 & 0x1) == 1 && (local610.anInt10690 & 0x1FF) == 256 && (local610.anInt10694 & 0x1FF) == 256) {
                            local286 = local610.anInt10690 - (local610.boundSize((byte) 79) - 1 << 8);
                            local295 = local610.anInt10694 - (local610.boundSize((byte) 61) - 1 << 8);
                            for (local306 = 0; local306 < Static390.anInt6126; local306++) {
                                @Pc(690) Node_Sub45 local690 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local306]);
                                if (local690 != null) {
                                    @Pc(695) NPCEntity local695 = local690.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                                    if (TimeUtils.clock != local695.anInt10743 && local695.aBoolean816) {
                                        local723 = local695.anInt10690 - (local695.type.size - 1 << 8);
                                        local735 = local695.anInt10694 - (local695.type.size - 1 << 8);
                                        if (local286 <= local723 && local695.type.size <= local610.boundSize((byte) 126) - (local723 - local286 >> 9) && local735 >= local295 && local695.type.size <= local610.boundSize((byte) 121) - (local735 - local295 >> 9)) {
                                            Static651.method8517(local543.aRenderable_18.level != PlayerEntity.self.level, local695);
                                            local695.anInt10743 = TimeUtils.clock;
                                        }
                                    }
                                }
                            }
                            local317 = Static338.anInt5564;
                            @Pc(820) int[] local820 = Static210.anIntArray280;
                            for (local723 = 0; local723 < local317; local723++) {
                                @Pc(830) PlayerEntity local830 = PlayerList.highResolutionPlayers[local820[local723]];
                                if (local830 != null && local830.anInt10743 != TimeUtils.clock && local830 != local610 && local830.aBoolean816) {
                                    local864 = local830.anInt10690 - (local830.boundSize((byte) 123) - 1 << 8);
                                    @Pc(876) int local876 = local830.anInt10694 - (local830.boundSize((byte) 67) - 1 << 8);
                                    if (local864 >= local286 && local830.boundSize((byte) 71) <= local610.boundSize((byte) 110) - (local864 - local286 >> 9) && local876 >= local295 && local830.boundSize((byte) 79) <= local610.boundSize((byte) 100) - (local876 - local295 >> 9)) {
                                        Static414.method5696(local543.aRenderable_18.level != PlayerEntity.self.level, local830);
                                        local830.anInt10743 = TimeUtils.clock;
                                    }
                                }
                            }
                        }
                        if (TimeUtils.clock == local610.anInt10743) {
                            continue;
                        }
                        Static414.method5696(PlayerEntity.self.level != local543.aRenderable_18.level, local610);
                        local610.anInt10743 = TimeUtils.clock;
                    }
                    if (local543.aRenderable_18 instanceof NPCEntity) {
                        @Pc(988) NPCEntity local988 = (NPCEntity) local543.aRenderable_18;
                        if (local988.type != null) {
                            if ((local988.type.size & 0x1) == 0 && (local988.anInt10690 & 0x1FF) == 0 && (local988.anInt10694 & 0x1FF) == 0 || (local988.type.size & 0x1) == 1 && (local988.anInt10690 & 0x1FF) == 256 && (local988.anInt10694 & 0x1FF) == 256) {
                                local614 = local988.anInt10690 - (local988.type.size - 1 << 8);
                                local286 = local988.anInt10694 - (local988.type.size - 1 << 8);
                                for (local295 = 0; local295 < Static390.anInt6126; local295++) {
                                    @Pc(1081) Node_Sub45 local1081 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local295]);
                                    if (local1081 != null) {
                                        @Pc(1086) NPCEntity local1086 = local1081.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                                        if (local1086.anInt10743 != TimeUtils.clock && local1086 != local988 && local1086.aBoolean816) {
                                            local370 = local1086.anInt10690 - (local1086.type.size - 1 << 8);
                                            local723 = local1086.anInt10694 - (local1086.type.size - 1 << 8);
                                            if (local614 <= local370 && local988.type.size - (local370 - local614 >> 9) >= local1086.type.size && local723 >= local286 && local1086.type.size <= local988.type.size - (local723 - local286 >> 9)) {
                                                Static651.method8517(PlayerEntity.self.level != local543.aRenderable_18.level, local1086);
                                                local1086.anInt10743 = TimeUtils.clock;
                                            }
                                        }
                                    }
                                }
                                local306 = Static338.anInt5564;
                                @Pc(1216) int[] local1216 = Static210.anIntArray280;
                                for (local370 = 0; local370 < local306; local370++) {
                                    @Pc(1226) PlayerEntity local1226 = PlayerList.highResolutionPlayers[local1216[local370]];
                                    if (local1226 != null && local1226.anInt10743 != TimeUtils.clock && local1226.aBoolean816) {
                                        local735 = local1226.anInt10690 - (local1226.boundSize((byte) 125) - 1 << 8);
                                        local864 = local1226.anInt10694 - (local1226.boundSize((byte) 76) - 1 << 8);
                                        if (local614 <= local735 && local1226.boundSize((byte) 98) <= local988.type.size - (local735 - local614 >> 9) && local286 <= local864 && local1226.boundSize((byte) 127) <= local988.type.size - (local864 - local286 >> 9)) {
                                            Static414.method5696(PlayerEntity.self.level != local543.aRenderable_18.level, local1226);
                                            local1226.anInt10743 = TimeUtils.clock;
                                        }
                                    }
                                }
                            }
                            if (TimeUtils.clock == local988.anInt10743) {
                                continue;
                            }
                            Static651.method8517(PlayerEntity.self.level != local543.aRenderable_18.level, local988);
                            local988.anInt10743 = TimeUtils.clock;
                        }
                    }
                    if (local543.aRenderable_18 instanceof Class8_Sub2_Sub5_Sub1) {
                        @Pc(1385) int local1385 = local186 + Static691.areaBaseX;
                        local614 = Static116.areaBaseY + local584;
                        @Pc(1406) ObjStack local1406 = (ObjStack) Static497.stacks.get((long) (local614 << 14 | local543.aRenderable_18.level << 28 | local1385));
                        if (local1406 != null) {
                            local295 = 0;
                            for (@Pc(1416) ObjStackEntry local1416 = (ObjStackEntry) local1406.objs.last(); local1416 != null; local1416 = (ObjStackEntry) local1406.objs.previous()) {
                                @Pc(1424) ObjType local1424 = Static419.objTypeList.list(local1416.id);
                                if (InterfaceManager.isTargeting && PlayerEntity.self.level == local543.aRenderable_18.level) {
                                    @Pc(1451) ParamType local1451 = Static610.anInt9329 == -1 ? null : Static523.instance.list(Static610.anInt9329);
                                    if ((InterfaceManager.targetMask & 0x1) != 0 && (local1451 == null || local1424.param(Static610.anInt9329, local1451.defaultint) != local1451.defaultint)) {
                                        addEntry(false, -1, (long) local1416.id, local186, local584, InterfaceManager.targetVerb, 17, true, Cursor.targetEnter, InterfaceManager.targetedVerb + " -> <col=ff9040>" + local1424.name, (long) local295, false);
                                    }
                                }
                                if (local543.aRenderable_18.level == PlayerEntity.self.level) {
                                    @Pc(1525) String[] local1525 = local1424.op;
                                    for (local723 = local1525.length - 1; local723 >= 0; local723--) {
                                        if (local1525[local723] != null) {
                                            @Pc(1540) short local1540 = 0;
                                            local864 = Cursor.interaction;
                                            if (local723 == 0) {
                                                local1540 = 25;
                                            }
                                            if (local723 == 1) {
                                                local1540 = 5;
                                            }
                                            if (local723 == 2) {
                                                local1540 = 50;
                                            }
                                            if (local723 == 3) {
                                                local1540 = 6;
                                            }
                                            if (local723 == 4) {
                                                local1540 = 45;
                                            }
                                            if (local723 == 5) {
                                                local1540 = 1007;
                                            }
                                            if (local723 == local1424.cursor1op) {
                                                local864 = local1424.cursor1;
                                            }
                                            if (local723 == local1424.cursor2op) {
                                                local864 = local1424.cursor2;
                                            }
                                            addEntry(false, -1, (long) local1416.id, local186, local584, local1525[local723], local1540, true, local864, "<col=ff9040>" + local1424.name, (long) local295, false);
                                        }
                                    }
                                }
                                local295++;
                            }
                        }
                    }
                    if (local543.aRenderable_18 instanceof Location) {
                        @Pc(1654) Location local1654 = (Location) local543.aRenderable_18;
                        @Pc(1661) LocType local1661 = Static354.aLocTypeList_4.list(local1654.getId());
                        if (local1661.multiLocs != null) {
                            local1661 = local1661.getMultiLoc(TimedVarDomain.instance);
                        }
                        if (local1661 != null) {
                            if (InterfaceManager.isTargeting && PlayerEntity.self.level == local543.aRenderable_18.level) {
                                @Pc(1697) ParamType local1697 = Static610.anInt9329 == -1 ? null : Static523.instance.list(Static610.anInt9329);
                                if ((InterfaceManager.targetMask & 0x4) != 0 && (local1697 == null || local1661.param(local1697.defaultint, Static610.anInt9329) != local1697.defaultint)) {
                                    addEntry(false, -1, Static277.method4042(local1654, local584, local186), local186, local584, InterfaceManager.targetVerb, 60, true, Cursor.targetEnter, InterfaceManager.targetedVerb + " -> <col=00ffff>" + local1661.name, (long) local1654.hashCode(), false);
                                }
                            }
                            if (PlayerEntity.self.level == local543.aRenderable_18.level) {
                                @Pc(1763) String[] local1763 = local1661.ops;
                                if (local1763 != null) {
                                    for (local295 = local1763.length - 1; local295 >= 0; local295--) {
                                        if (local1763[local295] != null) {
                                            @Pc(1780) short local1780 = 0;
                                            local317 = Cursor.interaction;
                                            if (local295 == 0) {
                                                local1780 = 19;
                                            }
                                            if (local295 == 1) {
                                                local1780 = 13;
                                            }
                                            if (local295 == 2) {
                                                local1780 = 46;
                                            }
                                            if (local295 == 3) {
                                                local1780 = 8;
                                            }
                                            if (local295 == 4) {
                                                local1780 = 1010;
                                            }
                                            if (local295 == local1661.cursor1Op) {
                                                local317 = local1661.cursor1;
                                            }
                                            if (local295 == 5) {
                                                local1780 = 1008;
                                            }
                                            if (local1661.cursor2Op == local295) {
                                                local317 = local1661.cursor2;
                                            }
                                            addEntry(false, -1, Static277.method4042(local1654, local584, local186), local186, local584, local1763[local295], local1780, true, local317, "<col=00ffff>" + local1661.name, (long) local1654.hashCode(), false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (InterfaceManager.aBoolean210) {
                Static480.method6469();
            }
        }
        Static501.method6716(false);
    }

    @OriginalMember(owner = "client!om", name = "a", descriptor = "(Lclient!cg;I)V")
    public static void addEntityEntries(@OriginalArg(0) Class8_Sub2_Sub1_Sub2 arg0) {
        if (arg0 instanceof NPCEntity) {
            @Pc(5) NPCEntity local5 = (NPCEntity) arg0;
            if (local5.type != null) {
                Static651.method8517(PlayerEntity.self.level != local5.level, local5);
            }
        } else if (arg0 instanceof PlayerEntity) {
            @Pc(33) PlayerEntity local33 = (PlayerEntity) arg0;
            Static414.method5696(local33.level != PlayerEntity.self.level, local33);
        }
    }

    @OriginalMember(owner = "client!nca", name = "a", descriptor = "(ZIJIILjava/lang/String;IZILjava/lang/String;JBZ)V")
    public static void addEntry(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) long arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) String arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7, @OriginalArg(8) int arg8, @OriginalArg(9) String arg9, @OriginalArg(10) long arg10, @OriginalArg(12) boolean arg11) {
        if (!open && optionCount < 500) {
            @Pc(20) int local20 = arg8 == -1 ? Cursor.targetEnd : arg8;
            @Pc(36) DoublyLinkedNode_Sub2_Sub16 local36 = new DoublyLinkedNode_Sub2_Sub16(arg5, arg9, local20, arg6, arg1, arg2, arg3, arg4, arg7, arg0, arg10, arg11);
            Static84.method1662(local36);
        }
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(Z)Z")
    public static boolean topEntryIsIfButtonX1() {
        if (Static96.aClass2_Sub2_Sub16_13 == null) {
            return false;
        } else {
            if (Static96.aClass2_Sub2_Sub16_13.anInt7314 >= 2000) {
                Static96.aClass2_Sub2_Sub16_13.anInt7314 -= 2000;
            }
            return Static96.aClass2_Sub2_Sub16_13.anInt7314 == 1002;
        }
    }

    @OriginalMember(owner = "client!ci", name = "a", descriptor = "(I)Z")
    public static boolean isPopulated() {
        return optionCount > 0;
    }
}
