import com.jagex.core.constants.HintArrowType;
import com.jagex.core.constants.LocShapes;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.runetek6.config.loctype.LocInteractivity;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.msitype.MSIType;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
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
        if (Camera.mode == CameraMode.MODE_FOUR) {
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
            if (local287.multiloc != null) {
                local287 = local287.getMultiLoc(TimedVarDomain.instance);
                if (local287 == null || local287.mapelement == -1) {
                    continue;
                }
            }
            Static620.method8322(local211, screenX, clippingMask, toolkit, local287.mapelement, screenY, local200, component);
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

    @OriginalMember(owner = "client!fn", name = "a", descriptor = "(Lclient!ha;IIIIIIII)V")
    public static void drawLocs(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int wallColour, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int drawX, @OriginalArg(5) int drawY, @OriginalArg(7) int arg6, @OriginalArg(8) int doorColour) {
        @Pc(9) Location loc = (Location) Static302.getWall(arg6, arg2, arg3);

        if (loc != null) {
            @Pc(20) LocType type = LocTypeList.instance.list(loc.getId());
            @Pc(26) int rotation = loc.getRotation() & 0x3;
            @Pc(30) int shape = loc.getShape();

            if (type.msi == -1) {
                @Pc(45) int colour = wallColour;
                if (type.active > LocInteractivity.NONINTERACTIVE) {
                    colour = doorColour;
                }

                if (shape == LocShapes.WALL_STRAIGHT || shape == LocShapes.WALL_L) {
                    if (rotation == 0) {
                        toolkit.verticalLine(4, drawY, colour, drawX);
                    } else if (rotation == 1) {
                        toolkit.horizontalLine(drawY, colour, drawX, 4);
                    } else if (rotation == 2) {
                        toolkit.verticalLine(4, drawY, colour, drawX + 3);
                    } else if (rotation == 3) {
                        toolkit.horizontalLine(drawY + 3, colour, drawX, 4);
                    }
                }

                if (shape == LocShapes.WALL_SQUARECORNER) {
                    if (rotation == 0) {
                        toolkit.fillRect(drawX, drawY, 1, 1, colour);
                    } else if (rotation == 1) {
                        toolkit.fillRect(drawX + 3, drawY, 1, 1, colour);
                    } else if (rotation == 2) {
                        toolkit.fillRect(drawX + 3, drawY + 3, 1, 1, colour);
                    } else if (rotation == 3) {
                        toolkit.fillRect(drawX, drawY + 3, 1, 1, colour);
                    }
                }

                if (shape == LocShapes.WALL_L) {
                    if (rotation == 0) {
                        toolkit.horizontalLine(drawY, colour, drawX, 4);
                    } else if (rotation == 1) {
                        toolkit.verticalLine(4, drawY, colour, drawX + 3);
                    } else if (rotation == 2) {
                        toolkit.horizontalLine(drawY + 3, colour, drawX, 4);
                    } else if (rotation == 3) {
                        toolkit.verticalLine(4, drawY, colour, drawX);
                    }
                }
            } else {
                drawMsi(type, rotation, toolkit, drawX, drawY);
            }
        }

        loc = (Location) Static578.getEntity(arg6, arg2, arg3, Static185.locClass == null ? (Static185.locClass = Static185.getClass("Location")) : Static185.locClass);
        if (loc != null) {
            @Pc(20) LocType type = LocTypeList.instance.list(loc.getId());
            @Pc(26) int rotation = loc.getRotation() & 0x3;
            @Pc(30) int shape = loc.getShape();

            if (type.msi != -1) {
                drawMsi(type, rotation, toolkit, drawX, drawY);
            } else if (shape == LocShapes.WALL_DIAGONAL) {
                @Pc(45) int colour = 0xffEEEEEE;
                if (type.active > 0) {
                    colour = 0xFFEE0000;
                }

                if (rotation == 0 || rotation == 2) {
                    toolkit.line(drawY, drawY + 3, drawX + 3, colour, drawX);
                } else {
                    toolkit.line(drawY + 3, drawY, drawX + 3, colour, drawX);
                }
            }
        }

        loc = (Location) Static687.getGroundDecor(arg6, arg2, arg3);
        if (loc != null) {
            @Pc(20) LocType type = LocTypeList.instance.list(loc.getId());
            @Pc(26) int rotation = loc.getRotation() & 0x3;

            if (type.msi != -1) {
                drawMsi(type, rotation, toolkit, drawX, drawY);
            }
        }
    }

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(Lclient!c;BILclient!ha;II)V")
    public static void drawMsi(@OriginalArg(0) LocType locType, @OriginalArg(2) int rotation, @OriginalArg(3) Toolkit arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        @Pc(9) MSIType msiType = MSITypeList.instance.list(locType.msi);
        if (msiType.image == -1) {
            return;
        }

        if (locType.msirotate) {
            @Pc(24) int msiRotation = rotation + locType.msiRotateOffset;
            rotation = msiRotation & 0x3;
        } else {
            rotation = 0;
        }

        @Pc(39) Sprite sprite = msiType.sprite(rotation, arg2, locType.msiflip);
        if (sprite == null) {
            return;
        }

        @Pc(46) int width = locType.width;
        @Pc(49) int length = locType.length;
        if ((rotation & 0x1) == 1) {
            width = locType.length;
            length = locType.width;
        }

        @Pc(72) int spriteWidth = sprite.scaleWidth();
        @Pc(75) int spriteHeight = sprite.scaleHeight();
        if (msiType.enlarge) {
            spriteHeight = length * 4;
            spriteWidth = width * 4;
        }

        if (msiType.colour != 0) {
            sprite.render(arg3, arg4 - (length - 1) * 4, spriteWidth, spriteHeight, 0, msiType.colour | 0xFF000000, 1);
        } else {
            sprite.render(arg3, arg4 + 4 - length * 4, spriteWidth, spriteHeight);
        }
    }

    @OriginalMember(owner = "client!baa", name = "a", descriptor = "(Lclient!ha;IIII[S[B)V")
    public static void drawMsiMultiple(@OriginalArg(0) Toolkit toolkit, @OriginalArg(1) int drawX, @OriginalArg(2) int drawY, @OriginalArg(3) int widthMultiplier, @OriginalArg(4) int heightMultiplier, @OriginalArg(5) short[] locIds, @OriginalArg(6) byte[] rotations) {
        if (locIds == null) {
            return;
        }

        for (@Pc(4) int i = 0; i < locIds.length; i++) {
            @Pc(14) LocType locType = WorldMap.locTypeList.list(locIds[i] & 0xFFFF);

            @Pc(17) int msi = locType.msi;
            if (msi == -1) {
                continue;
            }

            @Pc(25) MSIType msiType = WorldMap.msiTypeList.list(msi);
            @Pc(49) Sprite sprite = msiType.sprite(locType.msirotate ? ((rotations[i] >> 6) & 0x3) : 0, toolkit, locType.msiflip ? locType.mirror : false);

            if (sprite != null) {
                @Pc(58) int spriteWidth = (widthMultiplier * sprite.scaleWidth()) >> 2;
                @Pc(65) int spriteHeight = (heightMultiplier * sprite.scaleHeight()) >> 2;

                if (msiType.enlarge) {
                    @Pc(71) int locWidth = locType.width;
                    @Pc(74) int locLength = locType.length;

                    if ((rotations[i] >> 6 & 0x1) == 1) {
                        @Pc(85) int temp = locWidth;
                        locWidth = locLength;
                        locLength = temp;
                    }

                    spriteWidth = locWidth * widthMultiplier;
                    spriteHeight = locLength * heightMultiplier;
                }

                if (spriteWidth != 0 && spriteHeight != 0) {
                    if (msiType.colour != 0) {
                        sprite.render(drawX, drawY + heightMultiplier - spriteHeight, spriteWidth, spriteHeight, 0, msiType.colour | 0xFF000000, 1);
                    } else {
                        sprite.render(drawX, drawY + heightMultiplier - spriteHeight, spriteWidth, spriteHeight);
                    }
                }
            }
        }
    }
}
