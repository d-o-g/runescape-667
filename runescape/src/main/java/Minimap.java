import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Minimap {

    @OriginalMember(owner = "client!sda", name = "g", descriptor = "I")
    public static int toggle = 0;

    @OriginalMember(owner = "client!vga", name = "j", descriptor = "I")
    public static int flagX = -1;

    @OriginalMember(owner = "client!gka", name = "n", descriptor = "I")
    public static int flagY = -1;

    @OriginalMember(owner = "client!aw", name = "a", descriptor = "(ILclient!ha;ILclient!hda;I)V")
    public static void draw(@OriginalArg(0) int y, @OriginalArg(1) Toolkit toolkit, @OriginalArg(3) Component component, @OriginalArg(4) int x) {
        @Pc(23) Graphic local23 = component.graphic(toolkit);
        if (local23 == null) {
            return;
        }
        @Pc(30) ClippingMask local30 = local23.aClippingMask;
        toolkit.KA(x, y, x + component.width, y - -component.height);
        if (toggle == 2 || toggle == 5 || Static12.aSprite_26 == null) {
            toolkit.A(-16777216, local30, x, y);
            return;
        }
        @Pc(90) int local90;
        @Pc(93) int local93;
        @Pc(87) int local87;
        @Pc(79) int local79;
        if (Static511.anInt7645 == 4) {
            local87 = (int) -Static171.aFloat64 & 0x3FFF;
            local79 = 4096;
            local93 = Static249.anInt4018;
            local90 = Static433.anInt6262;
        } else {
            local79 = 4096 - Static660.anInt9835 * 16;
            local87 = (int) -Static171.aFloat64 + Static29.anInt723 & 0x3FFF;
            local90 = Static556.self.anInt10690;
            local93 = Static556.self.anInt10694;
        }
        @Pc(120) int local120 = local90 / 128 + 208 + 48 - Static720.mapWidth * 2;
        @Pc(137) int local137 = Static501.mapHeight * 4 + 48 - local93 / 128 - (Static501.mapHeight - 104) * 2;
        Static12.aSprite_26.renderRotated((float) x + (float) component.width / 2.0F, (float) component.height / 2.0F + (float) y, (float) local120, (float) local137, local79, local87 << 2, local30, x, y);
        @Pc(190) int local190;
        @Pc(200) int local200;
        @Pc(211) int local211;
        @Pc(222) int local222;
        for (@Pc(171) IntNode local171 = (IntNode) Static612.A_DEQUE___67.first(); local171 != null; local171 = (IntNode) Static612.A_DEQUE___67.next()) {
            @Pc(178) int local178 = local171.value;
            local190 = (Static42.aClass255_2.anIntArray495[local178] >> 14 & 0x3FFF) - Static691.areaBaseX;
            local200 = (Static42.aClass255_2.anIntArray495[local178] & 0x3FFF) - Static116.areaBaseY;
            local211 = local190 * 4 + 2 - local90 / 128;
            local222 = local200 * 4 + 2 - local93 / 128;
            Static620.method8322(local222, x, local30, toolkit, Static42.aClass255_2.anIntArray496[local178], y, local211, component);
        }
        for (local190 = 0; local190 < Static536.anInt8148; local190++) {
            local200 = Static566.anIntArray654[local190] * 4 + 2 - local90 / 128;
            local211 = Static350.anIntArray433[local190] * 4 + 2 - local93 / 128;
            @Pc(287) LocType local287 = Static354.aLocTypeList_4.list(Static533.anIntArray628[local190]);
            if (local287.multiLocs != null) {
                local287 = local287.getMultiLoc(Static34.aClass304_1);
                if (local287 == null || local287.mapElement == -1) {
                    continue;
                }
            }
            Static620.method8322(local211, x, local30, toolkit, local287.mapElement, y, local200, component);
        }
        @Pc(381) int local381;
        @Pc(392) int local392;
        for (@Pc(334) ObjStack local334 = (ObjStack) Static497.stacks.first(); local334 != null; local334 = (ObjStack) Static497.stacks.next()) {
            local211 = (int) (local334.key >> 28 & 0x3L);
            if (Static643.anInt9604 == local211) {
                local222 = (int) (local334.key & 0x3FFFL) - Static691.areaBaseX;
                @Pc(370) int local370 = (int) (local334.key >> 14 & 0x3FFFL) - Static116.areaBaseY;
                local381 = local222 * 4 + 2 - local90 / 128;
                local392 = local370 * 4 + 2 - local93 / 128;
                Static6.method107(y, local30, Static471.aSpriteArray11[0], local392, local381, component, x);
            }
        }
        @Pc(490) int local490;
        for (local211 = 0; local211 < Static390.anInt6126; local211++) {
            @Pc(427) Node_Sub45 local427 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) Static103.anIntArray187[local211]);
            if (local427 != null) {
                @Pc(432) Class8_Sub2_Sub1_Sub2_Sub2 local432 = local427.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                if (local432.method9322() && local432.aByte144 == Static556.self.aByte144) {
                    @Pc(446) NPCType local446 = local432.aNPCType_1;
                    if (local446 != null && local446.multinpcs != null) {
                        local446 = local446.getMultiNPC(65535, Static34.aClass304_1);
                    }
                    if (local446 != null && local446.displayOnMiniMap && local446.interactive) {
                        local392 = local432.anInt10690 / 128 - local90 / 128;
                        local490 = local432.anInt10694 / 128 - local93 / 128;
                        if (local446.mapElement == -1) {
                            Static6.method107(y, local30, Static471.aSpriteArray11[1], local490, local392, component, x);
                        } else {
                            Static620.method8322(local490, x, local30, toolkit, local446.mapElement, y, local392, component);
                        }
                    }
                }
            }
        }
        local222 = Static338.anInt5564;
        @Pc(531) int[] local531 = Static210.anIntArray280;
        @Pc(585) int local585;
        @Pc(589) int local589;
        @Pc(622) int local622;
        for (local381 = 0; local381 < local222; local381++) {
            @Pc(541) PlayerEntity local541 = PlayerList.highResolutionPlayers[local531[local381]];
            if (local541 != null && local541.method1417() && !local541.aBoolean124 && Static556.self != local541 && local541.aByte144 == Static556.self.aByte144) {
                local490 = local541.anInt10690 / 128 - local90 / 128;
                local585 = local541.anInt10694 / 128 - local93 / 128;
                @Pc(587) boolean local587 = false;
                for (local589 = 0; local589 < Static327.anInt5392; local589++) {
                    if (local541.accountName.equals(Static330.aStringArray25[local589]) && Static371.anIntArray455[local589] != 0) {
                        local587 = true;
                        break;
                    }
                }
                @Pc(620) boolean local620 = false;
                for (local622 = 0; local622 < Static706.anInt10633; local622++) {
                    if (local541.accountName.equals(Static87.aClass241Array1[local622].aString66)) {
                        local620 = true;
                        break;
                    }
                }
                @Pc(652) boolean local652 = false;
                if (Static556.self.anInt1433 != 0 && local541.anInt1433 != 0 && Static556.self.anInt1433 == local541.anInt1433) {
                    local652 = true;
                }
                if (local541.aBoolean128) {
                    Static6.method107(y, local30, Static471.aSpriteArray11[6], local585, local490, component, x);
                } else if (local652) {
                    Static6.method107(y, local30, Static471.aSpriteArray11[4], local585, local490, component, x);
                } else if (local541.aBoolean125) {
                    Static6.method107(y, local30, Static471.aSpriteArray11[7], local585, local490, component, x);
                } else if (local587) {
                    Static6.method107(y, local30, Static471.aSpriteArray11[3], local585, local490, component, x);
                } else if (local620) {
                    Static6.method107(y, local30, Static471.aSpriteArray11[5], local585, local490, component, x);
                } else {
                    Static6.method107(y, local30, Static471.aSpriteArray11[2], local585, local490, component, x);
                }
            }
        }
        @Pc(788) Class254[] local788 = Static527.aClass254Array1;
        @Pc(878) int local878;
        for (local490 = 0; local490 < local788.length; local490++) {
            @Pc(796) Class254 local796 = local788[local490];
            if (local796 != null && local796.anInt6363 != 0 && TimeUtils.clock % 20 < 10) {
                @Pc(843) int local843;
                if (local796.anInt6363 == 1) {
                    @Pc(828) Node_Sub45 local828 = (Node_Sub45) Static18.A_HASH_TABLE___2.get((long) local796.anInt6366);
                    if (local828 != null) {
                        @Pc(833) Class8_Sub2_Sub1_Sub2_Sub2 local833 = local828.aClass8_Sub2_Sub1_Sub2_Sub2_2;
                        local843 = local833.anInt10690 / 128 - local90 / 128;
                        local622 = local833.anInt10694 / 128 - local93 / 128;
                        Static114.method2132(local843, x, 360000L, local30, local796.anInt6367, y, local622, component);
                    }
                }
                if (local796.anInt6363 == 2) {
                    local878 = local796.anInt6369 / 128 - local90 / 128;
                    local589 = local796.anInt6362 / 128 - local93 / 128;
                    @Pc(893) long local893 = (long) (local796.anInt6364 << 7);
                    @Pc(897) long local897 = local893 * local893;
                    Static114.method2132(local878, x, local897, local30, local796.anInt6367, y, local589, component);
                }
                if (local796.anInt6363 == 10 && local796.anInt6366 >= 0 && local796.anInt6366 < PlayerList.highResolutionPlayers.length) {
                    @Pc(932) PlayerEntity local932 = PlayerList.highResolutionPlayers[local796.anInt6366];
                    if (local932 != null) {
                        local589 = local932.anInt10690 / 128 - local90 / 128;
                        local843 = local932.anInt10694 / 128 - local93 / 128;
                        Static114.method2132(local589, x, 360000L, local30, local796.anInt6367, y, local843, component);
                    }
                }
            }
        }
        if (Static511.anInt7645 == 4) {
            return;
        }
        if (flagX != 0) {
            local585 = flagX * 4 + (Static556.self.boundSize((byte) 50) + -1) * 2 + 2 - local90 / 128;
            local878 = flagY * 4 + Static556.self.boundSize((byte) 127) * 2 + 2 - local93 / 128 - 2;
            Static6.method107(y, local30, Static691.aSpriteArray15[Static266.aBoolean583 ? 1 : 0], local878, local585, component, x);
        }
        if (!Static556.self.aBoolean124) {
            toolkit.method7971(3, 3, y + component.height / 2 - 1, component.width / 2 + x + -1, -1);
            return;
        }
    }

    @OriginalMember(owner = "client!uga", name = "a", descriptor = "(Lclient!hda;III)V")
    public static void drawCompass(@OriginalArg(0) Component component, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
        @Pc(8) Graphic graphic = component.graphic(Static163.activeToolkit);
        if (graphic == null) {
            return;
        }

        Static163.activeToolkit.KA(arg1, arg2, arg1 + component.width, arg2 + component.height);
        if (toggle >= 3) {
            Static163.activeToolkit.A(-16777216, graphic.aClippingMask, arg1, arg2);
        } else {
            Static12.aSprite_27.method8183((float) component.width / 2.0F + (float) arg1, (float) component.height / 2.0F + (float) arg2, ((int) -Static171.aFloat64 & 0x3FFF) << 2, graphic.aClippingMask, arg1, arg2);
        }
    }
}
