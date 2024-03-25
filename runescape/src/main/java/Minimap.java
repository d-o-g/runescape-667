import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.graphics.ClippingMask;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Minimap {

    @OriginalMember(owner = "client!rr", name = "F", descriptor = "[I")
    public static final int[] anIntArray654 = new int[1000];

    @OriginalMember(owner = "client!sda", name = "g", descriptor = "I")
    public static int toggle = 0;

    @OriginalMember(owner = "client!vga", name = "j", descriptor = "I")
    public static int flagX = -1;

    @OriginalMember(owner = "client!gka", name = "n", descriptor = "I")
    public static int flagY = -1;

    @OriginalMember(owner = "client!ah", name = "i", descriptor = "Lclient!st;")
    public static Sprite sprite;

    @OriginalMember(owner = "client!uf", name = "f", descriptor = "I")
    public static int level = -1;

    @OriginalMember(owner = "client!ifa", name = "h", descriptor = "Z")
    public static boolean flagSet = true;

    @OriginalMember(owner = "client!aw", name = "a", descriptor = "(ILclient!ha;ILclient!hda;I)V")
    public static void draw(@OriginalArg(0) int y, @OriginalArg(1) Toolkit toolkit, @OriginalArg(3) Component component, @OriginalArg(4) int x) {
        @Pc(23) Graphic local23 = component.graphic(toolkit);
        if (local23 == null) {
            return;
        }
        @Pc(30) ClippingMask local30 = local23.aClippingMask;
        toolkit.KA(x, y, x + component.width, y - -component.height);
        if (toggle == 2 || toggle == 5 || sprite == null) {
            toolkit.A(-16777216, local30, x, y);
            return;
        }
        @Pc(90) int local90;
        @Pc(93) int local93;
        @Pc(87) int local87;
        @Pc(79) int local79;
        if (Camera.mode == 4) {
            local87 = (int) -Camera.playerCameraYaw & 0x3FFF;
            local79 = 4096;
            local93 = Static249.anInt4018;
            local90 = Static433.anInt6262;
        } else {
            local79 = 4096 - Camera.scaleOffset * 16;
            local87 = (int) -Camera.playerCameraYaw + Camera.yawOffset & 0x3FFF;
            local90 = PlayerEntity.self.x;
            local93 = PlayerEntity.self.z;
        }
        @Pc(120) int local120 = local90 / 128 + 208 + 48 - Static720.mapWidth * 2;
        @Pc(137) int local137 = Static501.mapHeight * 4 + 48 - local93 / 128 - (Static501.mapHeight - 104) * 2;
        sprite.renderRotated((float) x + (float) component.width / 2.0F, (float) component.height / 2.0F + (float) y, (float) local120, (float) local137, local79, local87 << 2, local30, x, y);
        @Pc(190) int local190;
        @Pc(200) int local200;
        @Pc(211) int local211;
        @Pc(222) int local222;
        for (@Pc(171) IntNode local171 = (IntNode) Static612.A_DEQUE___67.first(); local171 != null; local171 = (IntNode) Static612.A_DEQUE___67.next()) {
            @Pc(178) int local178 = local171.value;
            local190 = (Static42.aMapElementList_2.anIntArray495[local178] >> 14 & 0x3FFF) - WorldMap.areaBaseX;
            local200 = (Static42.aMapElementList_2.anIntArray495[local178] & 0x3FFF) - WorldMap.areaBaseZ;
            local211 = local190 * 4 + 2 - local90 / 128;
            local222 = local200 * 4 + 2 - local93 / 128;
            Static620.method8322(local222, x, local30, toolkit, Static42.aMapElementList_2.anIntArray496[local178], y, local211, component);
        }
        for (local190 = 0; local190 < Static536.anInt8148; local190++) {
            local200 = anIntArray654[local190] * 4 + 2 - local90 / 128;
            local211 = Static350.anIntArray433[local190] * 4 + 2 - local93 / 128;
            @Pc(287) LocType local287 = LocTypeList.instance.list(Static533.anIntArray628[local190]);
            if (local287.multiLocs != null) {
                local287 = local287.getMultiLoc(TimedVarDomain.instance);
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
            if (level == local211) {
                local222 = (int) (local334.key & 0x3FFFL) - WorldMap.areaBaseX;
                @Pc(370) int local370 = (int) (local334.key >> 14 & 0x3FFFL) - WorldMap.areaBaseZ;
                local381 = local222 * 4 + 2 - local90 / 128;
                local392 = local370 * 4 + 2 - local93 / 128;
                Static6.method107(y, local30, Sprites.mapdots[0], local392, local381, component, x);
            }
        }
        @Pc(490) int local490;
        for (local211 = 0; local211 < NPCList.localNpcCount; local211++) {
            @Pc(427) NPCEntityNode local427 = (NPCEntityNode) NPCList.local.get(NPCList.localNpcIndices[local211]);
            if (local427 != null) {
                @Pc(432) NPCEntity local432 = local427.npc;
                if (local432.method9322() && local432.level == PlayerEntity.self.level) {
                    @Pc(446) NPCType local446 = local432.type;
                    if (local446 != null && local446.multinpcs != null) {
                        local446 = local446.getMultiNPC(TimedVarDomain.instance);
                    }
                    if (local446 != null && local446.displayOnMiniMap && local446.interactive) {
                        local392 = local432.x / 128 - local90 / 128;
                        local490 = local432.z / 128 - local93 / 128;
                        if (local446.mapElement == -1) {
                            Static6.method107(y, local30, Sprites.mapdots[1], local490, local392, component, x);
                        } else {
                            Static620.method8322(local490, x, local30, toolkit, local446.mapElement, y, local392, component);
                        }
                    }
                }
            }
        }
        local222 = PlayerList.highResolutionPlayerCount;
        @Pc(531) int[] local531 = PlayerList.highResolutionPlayerIndices;
        @Pc(585) int local585;
        @Pc(589) int local589;
        @Pc(622) int local622;
        for (local381 = 0; local381 < local222; local381++) {
            @Pc(541) PlayerEntity local541 = PlayerList.highResolutionPlayers[local531[local381]];
            if (local541 != null && local541.method1417() && !local541.hideOnMap && PlayerEntity.self != local541 && local541.level == PlayerEntity.self.level) {
                local490 = local541.x / 128 - local90 / 128;
                local585 = local541.z / 128 - local93 / 128;
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
                if (PlayerEntity.self.team != 0 && local541.team != 0 && PlayerEntity.self.team == local541.team) {
                    local652 = true;
                }
                if (local541.showPICon) {
                    Static6.method107(y, local30, Sprites.mapdots[6], local585, local490, component, x);
                } else if (local652) {
                    Static6.method107(y, local30, Sprites.mapdots[4], local585, local490, component, x);
                } else if (local541.clanmate) {
                    Static6.method107(y, local30, Sprites.mapdots[7], local585, local490, component, x);
                } else if (local587) {
                    Static6.method107(y, local30, Sprites.mapdots[3], local585, local490, component, x);
                } else if (local620) {
                    Static6.method107(y, local30, Sprites.mapdots[5], local585, local490, component, x);
                } else {
                    Static6.method107(y, local30, Sprites.mapdots[2], local585, local490, component, x);
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
                    @Pc(828) NPCEntityNode local828 = (NPCEntityNode) NPCList.local.get(local796.anInt6366);
                    if (local828 != null) {
                        @Pc(833) NPCEntity local833 = local828.npc;
                        local843 = local833.x / 128 - local90 / 128;
                        local622 = local833.z / 128 - local93 / 128;
                        Static114.method2132(local843, x, 360000L, local30, local796.anInt6367, y, local622, component);
                    }
                }
                if (local796.anInt6363 == 2) {
                    local878 = local796.anInt6369 / 128 - local90 / 128;
                    local589 = local796.anInt6362 / 128 - local93 / 128;
                    @Pc(893) long local893 = local796.anInt6364 << 7;
                    @Pc(897) long local897 = local893 * local893;
                    Static114.method2132(local878, x, local897, local30, local796.anInt6367, y, local589, component);
                }
                if (local796.anInt6363 == 10 && local796.anInt6366 >= 0 && local796.anInt6366 < PlayerList.highResolutionPlayers.length) {
                    @Pc(932) PlayerEntity local932 = PlayerList.highResolutionPlayers[local796.anInt6366];
                    if (local932 != null) {
                        local589 = local932.x / 128 - local90 / 128;
                        local843 = local932.z / 128 - local93 / 128;
                        Static114.method2132(local589, x, 360000L, local30, local796.anInt6367, y, local843, component);
                    }
                }
            }
        }
        if (Camera.mode == 4) {
            return;
        }
        if (flagX != 0) {
            local585 = flagX * 4 + (PlayerEntity.self.getSize() + -1) * 2 + 2 - local90 / 128;
            local878 = flagY * 4 + PlayerEntity.self.getSize() * 2 + 2 - local93 / 128 - 2;
            Static6.method107(y, local30, Sprites.mapflag[flagSet ? 1 : 0], local878, local585, component, x);
        }
        if (!PlayerEntity.self.hideOnMap) {
            toolkit.fillRect(3, 3, y + component.height / 2 - 1, component.width / 2 + x + -1, -1);
            return;
        }
    }

    @OriginalMember(owner = "client!uga", name = "a", descriptor = "(Lclient!hda;III)V")
    public static void drawCompass(@OriginalArg(0) Component component, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2) {
        @Pc(8) Graphic graphic = component.graphic(Toolkit.active);
        if (graphic == null) {
            return;
        }

        Toolkit.active.KA(arg1, arg2, arg1 + component.width, arg2 + component.height);
        if (toggle >= 3) {
            Toolkit.active.A(-16777216, graphic.aClippingMask, arg1, arg2);
        } else {
            Sprites.compass.method8183((float) component.width / 2.0F + (float) arg1, (float) component.height / 2.0F + (float) arg2, ((int) -Camera.playerCameraYaw & 0x3FFF) << 2, graphic.aClippingMask, arg1, arg2);
        }
    }

    @OriginalMember(owner = "client!hk", name = "a", descriptor = "(I)V")
    public static void reset() {
        sprite = null;
        level = -1;
    }
}
