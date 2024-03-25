import com.jagex.core.constants.HintArrowType;
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
    public static void draw(@OriginalArg(3) Component component, @OriginalArg(1) Toolkit toolkit, @OriginalArg(4) int screenX, @OriginalArg(0) int screenY) {
        @Pc(23) Graphic graphic = component.graphic(toolkit);
        if (graphic == null) {
            return;
        }

        @Pc(30) ClippingMask clippingMask = graphic.clippingMask;
        toolkit.KA(screenX, screenY, screenX + component.width, screenY + component.height);

        if (toggle == 2 || toggle == 5 || sprite == null) {
            toolkit.A(0xFF000000, clippingMask, screenX, screenY);
            return;
        }

        @Pc(90) int selfX;
        @Pc(93) int selfZ;
        @Pc(87) int yaw;
        @Pc(79) int scale;
        if (Camera.mode == 4) {
            yaw = (int) -Camera.playerCameraYaw & 0x3FFF;
            scale = 4096;
            selfZ = Camera.anInt4018;
            selfX = Camera.anInt6262;
        } else {
            scale = 4096 - Camera.scaleOffset * 16;
            yaw = (int) -Camera.playerCameraYaw + Camera.yawOffset & 0x3FFF;
            selfX = PlayerEntity.self.x;
            selfZ = PlayerEntity.self.z;
        }

        @Pc(120) int x = ((selfX / 128) + 208 + 48) - (Static720.mapWidth * 2);
        @Pc(137) int y = ((Static501.mapHeight * 4) + 48) - (selfZ / 128) - ((Static501.mapHeight - 104) * 2);
        sprite.renderRotated((float) screenX + ((float) component.width / 2.0F), ((float) component.height / 2.0F) + (float) screenY, (float) x, (float) y, scale, yaw << 2, clippingMask, screenX, screenY);

        for (@Pc(171) IntNode node = (IntNode) Static612.A_DEQUE___67.first(); node != null; node = (IntNode) Static612.A_DEQUE___67.next()) {
            @Pc(178) int local178 = node.value;
            @Pc(190) int local190 = (Static42.aMapElementList_2.coords[local178] >> 14 & 0x3FFF) - WorldMap.areaBaseX;
            @Pc(200) int local200 = (Static42.aMapElementList_2.coords[local178] & 0x3FFF) - WorldMap.areaBaseZ;
            @Pc(211) int local211 = local190 * 4 + 2 - selfX / 128;
            @Pc(222) int local222 = local200 * 4 + 2 - selfZ / 128;
            Static620.method8322(local222, screenX, clippingMask, toolkit, Static42.aMapElementList_2.functions[local178], screenY, local211, component);
        }

        for (@Pc(190) int i = 0; i < Static536.anInt8148; i++) {
            @Pc(200) int local200 = anIntArray654[i] * 4 + 2 - selfX / 128;
            @Pc(211) int local211 = Static350.anIntArray433[i] * 4 + 2 - selfZ / 128;
            @Pc(287) LocType local287 = LocTypeList.instance.list(Static533.anIntArray628[i]);
            if (local287.multiLocs != null) {
                local287 = local287.getMultiLoc(TimedVarDomain.instance);
                if (local287 == null || local287.mapElement == -1) {
                    continue;
                }
            }
            Static620.method8322(local211, screenX, clippingMask, toolkit, local287.mapElement, screenY, local200, component);
        }

        for (@Pc(334) ObjStack stack = (ObjStack) Static497.stacks.first(); stack != null; stack = (ObjStack) Static497.stacks.next()) {
            @Pc(211) int stackLevel = (int) (stack.key >> 28 & 0x3L);

            if (level == stackLevel) {
                @Pc(222) int local222 = (int) (stack.key & 0x3FFFL) - WorldMap.areaBaseX;
                @Pc(370) int local370 = (int) (stack.key >> 14 & 0x3FFFL) - WorldMap.areaBaseZ;
                @Pc(381) int local381 = local222 * 4 + 2 - selfX / 128;
                @Pc(392) int local392 = local370 * 4 + 2 - selfZ / 128;
                Static6.method107(screenY, clippingMask, Sprites.mapdots[0], local392, local381, component, screenX);
            }
        }

        for (@Pc(211) int i = 0; i < NPCList.localNpcCount; i++) {
            @Pc(427) NPCEntityNode node = (NPCEntityNode) NPCList.local.get(NPCList.localNpcIndices[i]);
            if (node == null) {
                continue;
            }

            @Pc(432) NPCEntity npc = node.npc;
            if (npc.hasType() && npc.level == PlayerEntity.self.level) {
                @Pc(446) NPCType type = npc.type;
                if (type != null && type.multinpcs != null) {
                    type = type.getMultiNPC(TimedVarDomain.instance);
                }

                if (type != null && type.displayOnMiniMap && type.interactive) {
                    @Pc(392) int npcX = (npc.x / 128) - (selfX / 128);
                    @Pc(490) int npcZ = (npc.z / 128) - (selfZ / 128);

                    if (type.mapElement != -1) {
                        Static620.method8322(npcZ, screenX, clippingMask, toolkit, type.mapElement, screenY, npcX, component);
                    } else {
                        Static6.method107(screenY, clippingMask, Sprites.mapdots[1], npcZ, npcX, component, screenX);
                    }
                }
            }
        }

        @Pc(222) int playerCount = PlayerList.highResolutionPlayerCount;
        @Pc(531) int[] playerIndices = PlayerList.highResolutionPlayerIndices;
        for (@Pc(381) int i = 0; i < playerCount; i++) {
            @Pc(541) PlayerEntity player = PlayerList.highResolutionPlayers[playerIndices[i]];
            if (player == null || !player.hasModel() || player.hideOnMap || PlayerEntity.self == player || player.level != PlayerEntity.self.level) {
                continue;
            }

            @Pc(490) int playerX = (player.x / 128) - (selfX / 128);
            @Pc(585) int playerZ = (player.z / 128) - (selfZ / 128);
            @Pc(587) boolean friend = false;
            for (@Pc(589) int j = 0; j < FriendsList.count; j++) {
                if (player.accountName.equals(FriendsList.names[j]) && FriendsList.worlds[j] != 0) {
                    friend = true;
                    break;
                }
            }

            @Pc(620) boolean chatmate = false;
            for (@Pc(622) int j = 0; j < FriendChat.count; j++) {
                if (player.accountName.equals(FriendChat.users[j].accountName)) {
                    chatmate = true;
                    break;
                }
            }

            @Pc(652) boolean teammate = false;
            if (PlayerEntity.self.team != 0 && player.team != 0 && PlayerEntity.self.team == player.team) {
                teammate = true;
            }

            if (player.showPIcon) {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[6], playerZ, playerX, component, screenX);
            } else if (teammate) {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[4], playerZ, playerX, component, screenX);
            } else if (player.clanmate) {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[7], playerZ, playerX, component, screenX);
            } else if (friend) {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[3], playerZ, playerX, component, screenX);
            } else if (chatmate) {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[5], playerZ, playerX, component, screenX);
            } else {
                Static6.method107(screenY, clippingMask, Sprites.mapdots[2], playerZ, playerX, component, screenX);
            }
        }

        @Pc(788) HintArrow[] hintArrows = Static527.hintArrows;

        for (@Pc(490) int i = 0; i < hintArrows.length; i++) {
            @Pc(796) HintArrow hintArrow = hintArrows[i];
            if (hintArrow == null || hintArrow.type == HintArrowType.CLEAR || TimeUtils.clock % 20 >= 10) {
                continue;
            }

            if (hintArrow.type == HintArrowType.NPC) {
                @Pc(828) NPCEntityNode node = (NPCEntityNode) NPCList.local.get(hintArrow.entity);

                if (node != null) {
                    @Pc(833) NPCEntity npc = node.npc;
                    @Pc(843) int arrowX = (npc.x / 128) - (selfX / 128);
                    @Pc(622) int arrowZ = (npc.z / 128) - (selfZ / 128);
                    Static114.method2132(arrowX, screenX, 360000L, clippingMask, hintArrow.sprite, screenY, arrowZ, component);
                }
            }

            if (hintArrow.type == HintArrowType.TILE_CENTRE) {
                @Pc(878) int arrowX = hintArrow.x / 128 - selfX / 128;
                @Pc(589) int arrowZ = hintArrow.z / 128 - selfZ / 128;
                @Pc(893) long distance = hintArrow.drawDistance << 7;
                @Pc(897) long distanceSquared = distance * distance;
                Static114.method2132(arrowX, screenX, distanceSquared, clippingMask, hintArrow.sprite, screenY, arrowZ, component);
            }

            if (hintArrow.type == HintArrowType.PLAYER && hintArrow.entity >= 0 && hintArrow.entity < PlayerList.highResolutionPlayers.length) {
                @Pc(932) PlayerEntity player = PlayerList.highResolutionPlayers[hintArrow.entity];

                if (player != null) {
                    @Pc(589) int arrowX = (player.x / 128) - (selfX / 128);
                    @Pc(843) int arrowZ = (player.z / 128) - (selfZ / 128);
                    Static114.method2132(arrowX, screenX, 360000L, clippingMask, hintArrow.sprite, screenY, arrowZ, component);
                }
            }
        }

        if (Camera.mode != 4) {
            if (flagX != 0) {
                @Pc(585) int arrowX = ((flagX * 4) + ((PlayerEntity.self.getSize() - 1) * 2) + 2) - (selfX / 128);
                @Pc(878) int arrowZ = ((flagY * 4) + (PlayerEntity.self.getSize() * 2) + 2) - (selfZ / 128) - 2;
                Static6.method107(screenY, clippingMask, Sprites.mapflag[flagSet ? 1 : 0], arrowZ, arrowX, component, screenX);
            }

            if (!PlayerEntity.self.hideOnMap) {
                toolkit.fillRect((component.width / 2) + screenX - 1, (screenY + (component.height / 2)) - 1, 3, 3, 0xFFFFFFFF);
            }
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
            Toolkit.active.A(-16777216, graphic.clippingMask, arg1, arg2);
        } else {
            Sprites.compass.method8183((float) component.width / 2.0F + (float) arg1, (float) component.height / 2.0F + (float) arg2, ((int) -Camera.playerCameraYaw & 0x3FFF) << 2, graphic.clippingMask, arg1, arg2);
        }
    }

    @OriginalMember(owner = "client!hk", name = "a", descriptor = "(I)V")
    public static void reset() {
        sprite = null;
        level = -1;
    }
}
