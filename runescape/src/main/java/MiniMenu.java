import com.jagex.core.constants.MiniMenuAction;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.iftype.TargetMask;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamType;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.Font;
import com.jagex.graphics.Matrix;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.keyboard.KeyboardMonitor;

public final class MiniMenu {
    @OriginalMember(owner = "client!vu", name = "f", descriptor = "Lclient!sia;")
    public static final Deque entry = new Deque();

    @OriginalMember(owner = "client!pha", name = "m", descriptor = "Lclient!av;")
    public static final IterableHashTable categories = new IterableHashTable(16);

    @OriginalMember(owner = "client!wn", name = "k", descriptor = "Lclient!dla;")
    public static final ReferenceCache cache = new ReferenceCache(30);

    @OriginalMember(owner = "client!la", name = "v", descriptor = "Lclient!jga;")
    public static final Queue innerEntries = new Queue();

    @OriginalMember(owner = "client!fp", name = "T", descriptor = "Z")
    public static final boolean debugOps = false;

    @OriginalMember(owner = "client!mk", name = "c", descriptor = "Z")
    public static boolean open = false;

    @OriginalMember(owner = "client!sn", name = "j", descriptor = "I")
    public static int entryCount = 0;

    @OriginalMember(owner = "client!bb", name = "c", descriptor = "I")
    public static int innerCount = 0;

    @OriginalMember(owner = "client!qja", name = "c", descriptor = "Lclient!pg;")
    public static MiniMenuEntry CANCEL;

    @OriginalMember(owner = "client!da", name = "o", descriptor = "Lclient!pg;")
    public static MiniMenuEntry topEntry;

    @OriginalMember(owner = "client!cja", name = "b", descriptor = "(B)V")
    public static void reset() {
        for (@Pc(10) MiniMenuEntryInner inner = (MiniMenuEntryInner) innerEntries.first(); inner != null; inner = (MiniMenuEntryInner) innerEntries.next()) {
            if (inner.size > 1) {
                inner.size = 0;
                cache.put(inner, ((MiniMenuEntry) inner.entries.sentinel.next2).entryKey);
                inner.entries.clear();
            }
        }
        entryCount = 0;
        innerCount = 0;
        entry.clear();
        categories.clear();
        innerEntries.clear();
        addEntryInner(CANCEL);
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
        if (Static706.aGroundArray3 != null && (!InterfaceManager.targeting || (InterfaceManager.targetMask & 0x40) != 0)) {
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
                if (InterfaceManager.targeting && (InterfaceManager.targetMask & 0x40) != 0) {
                    @Pc(453) Component local453 = InterfaceList.getComponent(InterfaceManager.targetComponent, InterfaceManager.targetSlot);
                    if (local453 == null) {
                        InterfaceManager.endTargetMode();
                    } else {
                        addEntry(false, -1, 0L, local140, local142, InterfaceManager.targetVerb, 21, true, InterfaceManager.targetEnterCursor, " ->", local140 << 0 | local142, true);
                    }
                } else {
                    if (Static501.aBoolean576) {
                        addEntry(false, -1, 0L, local140, local142, LocalisedText.FACEHERE.localise(client.language), 11, true, -1, "", local142 | local140 << 0, true);
                    }
                    addEntry(false, -1, 0L, local140, local142, Static331.walkText, 58, true, Static331.walkCursor, "", local142 | local140 << 0, true);
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
                        local584 = local543.aRenderable_18.z >> 9;
                        local186 = local543.aRenderable_18.x >> 9;
                    }
                    @Pc(723) int local723;
                    @Pc(735) int local735;
                    @Pc(864) int local864;
                    @Pc(614) int local614;
                    if (local543.aRenderable_18 instanceof PlayerEntity) {
                        @Pc(610) PlayerEntity local610 = (PlayerEntity) local543.aRenderable_18;
                        local614 = local610.boundSize((byte) 50);
                        if ((local614 & 0x1) == 0 && (local610.x & 0x1FF) == 0 && (local610.z & 0x1FF) == 0 || (local614 & 0x1) == 1 && (local610.x & 0x1FF) == 256 && (local610.z & 0x1FF) == 256) {
                            local286 = local610.x - (local610.boundSize((byte) 79) - 1 << 8);
                            local295 = local610.z - (local610.boundSize((byte) 61) - 1 << 8);
                            for (local306 = 0; local306 < Static390.anInt6126; local306++) {
                                @Pc(690) Node_Sub45 local690 = (Node_Sub45) Static18.A_HASH_TABLE___2.get(Static103.anIntArray187[local306]);
                                if (local690 != null) {
                                    @Pc(695) NPCEntity local695 = local690.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                                    if (TimeUtils.clock != local695.anInt10743 && local695.aBoolean816) {
                                        local723 = local695.x - (local695.type.size - 1 << 8);
                                        local735 = local695.z - (local695.type.size - 1 << 8);
                                        if (local286 <= local723 && local695.type.size <= local610.boundSize((byte) 126) - (local723 - local286 >> 9) && local735 >= local295 && local695.type.size <= local610.boundSize((byte) 121) - (local735 - local295 >> 9)) {
                                            method8517(local543.aRenderable_18.level != PlayerEntity.self.level, local695);
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
                                    local864 = local830.x - (local830.boundSize((byte) 123) - 1 << 8);
                                    @Pc(876) int local876 = local830.z - (local830.boundSize((byte) 67) - 1 << 8);
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
                            if ((local988.type.size & 0x1) == 0 && (local988.x & 0x1FF) == 0 && (local988.z & 0x1FF) == 0 || (local988.type.size & 0x1) == 1 && (local988.x & 0x1FF) == 256 && (local988.z & 0x1FF) == 256) {
                                local614 = local988.x - (local988.type.size - 1 << 8);
                                local286 = local988.z - (local988.type.size - 1 << 8);
                                for (local295 = 0; local295 < Static390.anInt6126; local295++) {
                                    @Pc(1081) Node_Sub45 local1081 = (Node_Sub45) Static18.A_HASH_TABLE___2.get(Static103.anIntArray187[local295]);
                                    if (local1081 != null) {
                                        @Pc(1086) NPCEntity local1086 = local1081.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                                        if (local1086.anInt10743 != TimeUtils.clock && local1086 != local988 && local1086.aBoolean816) {
                                            local370 = local1086.x - (local1086.type.size - 1 << 8);
                                            local723 = local1086.z - (local1086.type.size - 1 << 8);
                                            if (local614 <= local370 && local988.type.size - (local370 - local614 >> 9) >= local1086.type.size && local723 >= local286 && local1086.type.size <= local988.type.size - (local723 - local286 >> 9)) {
                                                method8517(PlayerEntity.self.level != local543.aRenderable_18.level, local1086);
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
                                        local735 = local1226.x - (local1226.boundSize((byte) 125) - 1 << 8);
                                        local864 = local1226.z - (local1226.boundSize((byte) 76) - 1 << 8);
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
                            method8517(PlayerEntity.self.level != local543.aRenderable_18.level, local988);
                            local988.anInt10743 = TimeUtils.clock;
                        }
                    }
                    if (local543.aRenderable_18 instanceof Class8_Sub2_Sub5_Sub1) {
                        @Pc(1385) int local1385 = local186 + WorldMap.areaBaseX;
                        local614 = WorldMap.areaBaseZ + local584;
                        @Pc(1406) ObjStack local1406 = (ObjStack) Static497.stacks.get(local614 << 14 | local543.aRenderable_18.level << 28 | local1385);
                        if (local1406 != null) {
                            local295 = 0;
                            for (@Pc(1416) ObjStackEntry local1416 = (ObjStackEntry) local1406.objs.last(); local1416 != null; local1416 = (ObjStackEntry) local1406.objs.previous()) {
                                @Pc(1424) ObjType local1424 = ObjTypeList.instance.list(local1416.id);
                                if (InterfaceManager.targeting && PlayerEntity.self.level == local543.aRenderable_18.level) {
                                    @Pc(1451) ParamType local1451 = InterfaceManager.targetParam == -1 ? null : ParamTypeList.instance.list(InterfaceManager.targetParam);
                                    if ((InterfaceManager.targetMask & 0x1) != 0 && (local1451 == null || local1424.param(InterfaceManager.targetParam, local1451.defaultint) != local1451.defaultint)) {
                                        addEntry(false, -1, local1416.id, local186, local584, InterfaceManager.targetVerb, 17, true, InterfaceManager.targetEnterCursor, InterfaceManager.targetedVerb + " -> <col=ff9040>" + local1424.name, local295, false);
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
                                            addEntry(false, -1, local1416.id, local186, local584, local1525[local723], local1540, true, local864, "<col=ff9040>" + local1424.name, local295, false);
                                        }
                                    }
                                }
                                local295++;
                            }
                        }
                    }
                    if (local543.aRenderable_18 instanceof Location) {
                        @Pc(1654) Location local1654 = (Location) local543.aRenderable_18;
                        @Pc(1661) LocType local1661 = LocTypeList.instance.list(local1654.getId());
                        if (local1661.multiLocs != null) {
                            local1661 = local1661.getMultiLoc(TimedVarDomain.instance);
                        }
                        if (local1661 != null) {
                            if (InterfaceManager.targeting && PlayerEntity.self.level == local543.aRenderable_18.level) {
                                @Pc(1697) ParamType local1697 = InterfaceManager.targetParam == -1 ? null : ParamTypeList.instance.list(InterfaceManager.targetParam);
                                if ((InterfaceManager.targetMask & 0x4) != 0 && (local1697 == null || local1661.param(local1697.defaultint, InterfaceManager.targetParam) != local1697.defaultint)) {
                                    addEntry(false, -1, Static277.method4042(local1654, local584, local186), local186, local584, InterfaceManager.targetVerb, 60, true, InterfaceManager.targetEnterCursor, InterfaceManager.targetedVerb + " -> <col=00ffff>" + local1661.name, local1654.hashCode(), false);
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
                                            addEntry(false, -1, Static277.method4042(local1654, local584, local186), local186, local584, local1763[local295], local1780, true, local317, "<col=00ffff>" + local1661.name, local1654.hashCode(), false);
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
            @Pc(5) NPCEntity npc = (NPCEntity) arg0;
            if (npc.type != null) {
                method8517(PlayerEntity.self.level != npc.level, npc);
            }
        } else if (arg0 instanceof PlayerEntity) {
            @Pc(33) PlayerEntity player = (PlayerEntity) arg0;
            Static414.method5696(player.level != PlayerEntity.self.level, player);
        }
    }

    @OriginalMember(owner = "client!nca", name = "a", descriptor = "(ZIJIILjava/lang/String;IZILjava/lang/String;JBZ)V")
    public static void addEntry(@OriginalArg(0) boolean arg0, @OriginalArg(1) int invObject, @OriginalArg(2) long arg2, @OriginalArg(3) int id, @OriginalArg(4) int slot, @OriginalArg(5) String targetVerb, @OriginalArg(6) int action, @OriginalArg(7) boolean arg7, @OriginalArg(8) int cursor, @OriginalArg(9) String opBase, @OriginalArg(10) long key, @OriginalArg(12) boolean arg11) {
        if (!open && entryCount < 500) {
            @Pc(20) int targetEndCursor = cursor != -1 ? cursor : InterfaceManager.targetEndCursor;
            @Pc(36) MiniMenuEntry entry = new MiniMenuEntry(targetVerb, opBase, targetEndCursor, action, invObject, arg2, id, slot, arg7, arg0, key, arg11);
            addEntryInner(entry);
        }
    }

    @OriginalMember(owner = "client!gfa", name = "a", descriptor = "(Z)Z")
    public static boolean topEntryIsIfButtonX1() {
        if (topEntry == null) {
            return false;
        } else {
            if (topEntry.action >= 2000) {
                topEntry.action -= 2000;
            }
            return topEntry.action == MiniMenuAction.IF_BUTTONX1;
        }
    }

    @OriginalMember(owner = "client!ci", name = "a", descriptor = "(I)Z")
    public static boolean isPopulated() {
        return entryCount > 0;
    }

    @OriginalMember(owner = "client!cv", name = "b", descriptor = "(B)V")
    public static void openButtons() {
        for (@Pc(4) MiniMenuEntry entry = (MiniMenuEntry) MiniMenu.entry.first(); entry != null; entry = (MiniMenuEntry) MiniMenu.entry.next()) {
            if (MiniMenuAction.isButtonOp(entry.action)) {
                open(entry);
            }
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!pg;)V")
    public static void addEntryInner(@OriginalArg(1) MiniMenuEntry entry) {
        if (entry == null) {
            return;
        }

        MiniMenu.entry.addLast(entry);
        entryCount++;

        @Pc(33) MiniMenuEntryInner inner;
        if (entry.independent || "".equals(entry.opBase)) {
            inner = new MiniMenuEntryInner(entry.opBase);
            innerCount++;
        } else {
            @Pc(41) long key = entry.entryKey;
            for (inner = (MiniMenuEntryInner) categories.get(key); inner != null && !inner.title.equals(entry.opBase); inner = (MiniMenuEntryInner) categories.nextWithSameKey()) {
            }

            if (inner == null) {
                inner = (MiniMenuEntryInner) cache.get(key);
                if (inner != null && !inner.title.equals(entry.opBase)) {
                    inner = null;
                }
                if (inner == null) {
                    inner = new MiniMenuEntryInner(entry.opBase);
                }

                categories.put(key, inner);
                innerCount++;
            }
        }

        if (inner.add(entry)) {
            reposition(inner);
        }
    }

    @OriginalMember(owner = "client!mb", name = "a", descriptor = "(Lclient!cba;B)V")
    public static void reposition(@OriginalArg(0) MiniMenuEntryInner inner) {
        @Pc(5) boolean inserted = false;
        inner.unlink2();

        for (@Pc(21) MiniMenuEntryInner child = (MiniMenuEntryInner) innerEntries.first(); child != null; child = (MiniMenuEntryInner) innerEntries.next()) {
            if (isActionBefore(inner.getAction(), child.getAction())) {
                inserted = true;
                Node2.attachAfter(child, inner);
                break;
            }
        }

        if (!inserted) {
            innerEntries.add(inner);
        }
    }

    @OriginalMember(owner = "client!rd", name = "a", descriptor = "(BII)Z")
    public static boolean isActionBefore(@OriginalArg(1) int curr, @OriginalArg(2) int prev) {
        if (prev >= 1000 && curr < 1000) {
            return true;
        } else if (prev >= 1000 || curr >= 1000) {
            return prev >= 1000 && curr >= 1000;
        } else if (MiniMenuAction.isTarget(curr)) {
            return true;
        } else if (!MiniMenuAction.isTarget(prev)) {
            return true;
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!hj", name = "c", descriptor = "(I)V")
    public static void setCancelEntry() {
        CANCEL = new MiniMenuEntry(LocalisedText.CANCEL.localise(client.language), "", InterfaceManager.targetEndCursor, 1012, -1, 0L, 0, 0, true, false, 0L, true);
    }

    @OriginalMember(owner = "client!vj", name = "a", descriptor = "(ILclient!pg;)V")
    public static void open(@OriginalArg(1) MiniMenuEntry entry) {
        if (open) {
            return;
        }

        entry.unlink();
        entryCount--;

        if (entry.independent) {
            for (@Pc(22) MiniMenuEntryInner inner = (MiniMenuEntryInner) innerEntries.first(); inner != null; inner = (MiniMenuEntryInner) innerEntries.next()) {
                if (!inner.title.equals(entry.opBase)) {
                    continue;
                }

                @Pc(31) boolean found = false;
                for (@Pc(37) MiniMenuEntry other = (MiniMenuEntry) inner.entries.first(); other != null; other = (MiniMenuEntry) inner.entries.next()) {
                    if (other == entry) {
                        found = true;

                        if (inner.remove(entry)) {
                            reposition(inner);
                        }

                        break;
                    }
                }

                if (found) {
                    break;
                }
            }
        } else {
            @Pc(79) long key = entry.entryKey;
            @Pc(85) MiniMenuEntryInner inner;
            for (inner = (MiniMenuEntryInner) categories.get(key); inner != null; inner = (MiniMenuEntryInner) categories.nextWithSameKey()) {
                if (inner.title.equals(entry.opBase)) {
                    break;
                }
            }

            if (inner != null && inner.remove(entry)) {
                reposition(inner);
            }
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(IZLclient!wj;)V")
    public static void method8517(@OriginalArg(1) boolean differentLevel, @OriginalArg(2) NPCEntity npc) {
        if (entryCount >= 400) {
            return;
        }

        @Pc(21) NPCType type = npc.type;
        @Pc(24) String npcName = npc.aString128;
        if (type.multinpcs != null) {
            type = type.getMultiNPC(TimedVarDomain.instance);
            if (type == null) {
                return;
            }
            npcName = type.name;
        }

        if (!type.interactive) {
            return;
        }

        if (npc.combatLevel != 0) {
            @Pc(67) String text = ModeGame.STELLAR_DAWN == client.modeGame ? LocalisedText.RATING.localise(client.language) : LocalisedText.LEVEL.localise(client.language);
            npcName = npcName + colourCode(PlayerEntity.self.combatLevel, npc.combatLevel) + " (" + text + npc.combatLevel + ")";
        }

        if (InterfaceManager.targeting && !differentLevel) {
            @Pc(113) ParamType param = InterfaceManager.targetParam != -1 ? ParamTypeList.instance.list(InterfaceManager.targetParam) : null;

            if ((InterfaceManager.targetMask & TargetMask.TGT_NPC) != 0 && (param == null || type.param(InterfaceManager.targetParam, param.defaultint) != param.defaultint)) {
                addEntry(false, -1, npc.id, 0, 0, InterfaceManager.targetVerb, MiniMenuAction.TGT_NPC, true, InterfaceManager.targetEnterCursor, InterfaceManager.targetedVerb + " -> <col=ffff00>" + npcName, npc.id, false);
            }
        }

        if (differentLevel) {
            return;
        }

        @Pc(176) String[] ops = type.op;
        if (debugOps) {
            ops = prefixWithNum(ops);
        }
        if (ops == null) {
            return;
        }

        for (@Pc(189) int op = ops.length - 1; op >= 0; op--) {
            if (ops[op] != null && (type.aByte107 == 0 || !ops[op].equalsIgnoreCase(LocalisedText.ATTACK.localise(client.language)) && !ops[op].equalsIgnoreCase(LocalisedText.EXAMINE.localise(client.language)))) {
                @Pc(226) short action = 0;
                @Pc(228) int cursor = Cursor.interaction;

                if (op == 0) {
                    action = MiniMenuAction.OPNPC1;
                }
                if (op == 1) {
                    action = MiniMenuAction.OPNPC2;
                }
                if (op == 2) {
                    action = MiniMenuAction.OPNPC3;
                }
                if (op == 3) {
                    action = MiniMenuAction.OPNPC4;
                }
                if (op == 4) {
                    action = MiniMenuAction.OPNPC5;
                }
                if (op == 5) {
                    action = MiniMenuAction.OPNPC6;
                }

                if (op == type.cursor1Op) {
                    cursor = type.cursor1;
                }
                if (type.cursor2Op == op) {
                    cursor = type.cursor2;
                }

                addEntry(false, -1, npc.id, 0, 0, ops[op], action, true, ops[op].equalsIgnoreCase(LocalisedText.ATTACK.localise(client.language)) ? type.attackCursor : cursor, "<col=ffff00>" + npcName, npc.id, false);
            }
        }

        if (type.aByte107 == 1) {
            for (@Pc(341) int op = 0; op < ops.length; op++) {
                if (ops[op] != null && (ops[op].equalsIgnoreCase(LocalisedText.ATTACK.localise(client.language)) || ops[op].equalsIgnoreCase(LocalisedText.EXAMINE.localise(client.language)))) {
                    @Pc(372) short offset = 0;
                    if (npc.combatLevel > PlayerEntity.self.combatLevel) {
                        offset = 2000;
                    }

                    @Pc(385) short action = 0;
                    @Pc(387) int cursor = Cursor.interaction;

                    if (op == 0) {
                        action = MiniMenuAction.OPNPC1;
                    }
                    if (op == 1) {
                        action = MiniMenuAction.OPNPC2;
                    }
                    if (op == 2) {
                        action = MiniMenuAction.OPNPC3;
                    }
                    if (op == 3) {
                        action = MiniMenuAction.OPNPC4;
                    }
                    if (op == 4) {
                        action = MiniMenuAction.OPNPC5;
                    }
                    if (op == 5) {
                        action = MiniMenuAction.OPNPC6;
                    }

                    if (type.cursor1Op == op) {
                        cursor = type.cursor1;
                    }
                    if (action != 0) {
                        action += offset;
                    }
                    if (type.cursor2Op == op) {
                        cursor = type.cursor2;
                    }

                    addEntry(false, -1, npc.id, 0, 0, ops[op], action, true, ops[op].equalsIgnoreCase(LocalisedText.ATTACK.localise(client.language)) ? type.attackCursor : cursor, "<col=ffff00>" + npcName, npc.id, false);
                }
            }
        }
    }

    @OriginalMember(owner = "client!vu", name = "b", descriptor = "(III)Ljava/lang/String;")
    public static String colourCode(@OriginalArg(1) int ourLevel, @OriginalArg(2) int theirLevel) {
        @Pc(8) int delta = ourLevel - theirLevel;

        if (delta < -9) {
            return "<col=ff0000>";
        } else if (delta < -6) {
            return "<col=ff3000>";
        } else if (delta < -3) {
            return "<col=ff7000>";
        } else if (delta < 0) {
            return "<col=ffb000>";
        } else if (delta > 9) {
            return "<col=00ff00>";
        } else if (delta > 6) {
            return "<col=40ff00>";
        } else if (delta > 3) {
            return "<col=80ff00>";
        } else if (delta > 0) {
            return "<col=c0ff00>";
        } else {
            return "<col=ffff00>";
        }
    }

    @OriginalMember(owner = "client!hl", name = "a", descriptor = "(I[Ljava/lang/String;)[Ljava/lang/String;")
    public static String[] prefixWithNum(@OriginalArg(1) String[] ops) {
        @Pc(6) String[] prefixed = new String[5];
        for (@Pc(8) int i = 0; i < 5; i++) {
            prefixed[i] = i + ": ";

            if (ops != null && ops[i] != null) {
                prefixed[i] = prefixed[i] + ops[i];
            }
        }
        return prefixed;
    }

    @OriginalMember(owner = "client!rj", name = "a", descriptor = "(Lclient!ha;I)V")
    public static void method7301(@OriginalArg(0) Toolkit arg0) {
        if (entryCount < 2 && !InterfaceManager.targeting || InterfaceManager.dragSource != null) {
            return;
        }

        @Pc(63) String text;
        if (InterfaceManager.targeting && entryCount < 2) {
            text = InterfaceManager.targetVerb + LocalisedText.MINISEPARATOR.localise(client.language) + InterfaceManager.targetedVerb + " ->";
        } else if (Static209.aBoolean269 && KeyboardMonitor.instance.isPressed(81) && entryCount > 2) {
            text = Static518.method9293(Static470.aClass2_Sub2_Sub16_10);
        } else {
            @Pc(55) MiniMenuEntry local55 = Static470.aClass2_Sub2_Sub16_10;
            if (local55 == null) {
                return;
            }
            text = Static518.method9293(local55);
            @Pc(65) int[] local65 = null;
            if (Static245.method8635(local55.action)) {
                local65 = ObjTypeList.instance.list((int) local55.aLong233).quests;
            } else if (local55.anInt7317 != -1) {
                local65 = ObjTypeList.instance.list(local55.anInt7317).quests;
            } else if (Static598.method7825(local55.action)) {
                @Pc(93) Node_Sub45 local93 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((int) local55.aLong233);
                if (local93 != null) {
                    @Pc(98) NPCEntity local98 = local93.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                    @Pc(101) NPCType local101 = local98.type;
                    if (local101.multinpcs != null) {
                        local101 = local101.getMultiNPC(TimedVarDomain.instance);
                    }
                    if (local101 != null) {
                        local65 = local101.quests;
                    }
                }
            } else if (Static523.method3444(local55.action)) {
                @Pc(131) LocType local131 = LocTypeList.instance.list((int) (local55.aLong233 >>> 32 & 0x7FFFFFFFL));
                if (local131.multiLocs != null) {
                    local131 = local131.getMultiLoc(TimedVarDomain.instance);
                }
                if (local131 != null) {
                    local65 = local131.quests;
                }
            }
            if (local65 != null) {
                text = text + Static72.method1527(local65);
            }
        }

        if (entryCount > 2) {
            text = text + "<col=ffffff> / " + (entryCount - 2) + LocalisedText.MOREOPTIONS.localise(client.language);
        }

        if (WorldMap.optionsComponent != null) {
            @Pc(232) Font local232 = WorldMap.optionsComponent.font(arg0);
            if (local232 == null) {
                local232 = Fonts.b12;
            }
            local232.renderRandom(Static329.anIntArray163, WorldMap.optionsComponent.horizontalAlignment, WorldMap.optionsComponent.width, Static460.anIntArray554, WorldMap.optionsComponent.colour, WorldMap.optionsComponent.height, Static493.aRandom1, text, WorldMap.optionsX, WorldMap.optionsComponent.shadow, Static186.aSpriteArray5, Static178.anInt2947, WorldMap.optionsY, WorldMap.optionsComponent.verticalAlignment);
            Static585.method7670(Static329.anIntArray163[2], Static329.anIntArray163[0], Static329.anIntArray163[3], Static329.anIntArray163[1]);
        } else if (InterfaceManager.optionsComponent != null && client.modeGame == ModeGame.RUNESCAPE) {
            @Pc(299) int local299 = Fonts.b12.renderRandom(Static186.aSpriteArray5, Static178.anInt2947, 0xFFFFFF, InterfaceManager.optionsY + 16, text, Static460.anIntArray554, 0, Static493.aRandom1, InterfaceManager.optionsX + 4);
            Static585.method7670(local299 + Fonts.b12Metrics.stringWidth(text), InterfaceManager.optionsX - -4, 16, InterfaceManager.optionsY);
        }
    }
}
