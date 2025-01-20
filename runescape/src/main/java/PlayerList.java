import com.jagex.HighResolutionPlayerUpdate;
import com.jagex.LowResolutionPlayerUpdate;
import com.jagex.core.constants.ChatLineType;
import com.jagex.core.constants.PlayerExtendedInfoFlag;
import com.jagex.core.io.BitPacket;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.MoveSpeed;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class PlayerList {

    public static final int COUNT = 2048;

    private static final int SKIPPED_LAST_CYCLE = 0x1;

    private static final int SKIPPED_THIS_CYCLE = 0x2;

    @OriginalMember(owner = "client!lf", name = "r", descriptor = "Z")
    public static boolean debug = false;

    @OriginalMember(owner = "client!tl", name = "f", descriptor = "[Lclient!ca;")
    public static final PlayerEntity[] highResolutionPlayers = new PlayerEntity[COUNT];

    @OriginalMember(owner = "client!hl", name = "d", descriptor = "[Lclient!tea;")
    public static final SnapShotPlayer[] lowResolutionPlayers = new SnapShotPlayer[COUNT];

    @OriginalMember(owner = "client!gia", name = "o", descriptor = "[I")
    public static final int[] highResolutionSlots = new int[COUNT];

    @OriginalMember(owner = "client!mt", name = "N", descriptor = "[I")
    public static final int[] lowResolutionSlots = new int[COUNT];

    @OriginalMember(owner = "client!kca", name = "O", descriptor = "[I")
    public static final int[] extendedInfoSlots = new int[COUNT];

    @OriginalMember(owner = "client!ml", name = "f", descriptor = "[B")
    public static final byte[] updateHistory = new byte[COUNT];

    @OriginalMember(owner = "client!ok", name = "q", descriptor = "[Lclient!ge;")
    public static final Packet[] appearances = new Packet[COUNT];

    @OriginalMember(owner = "client!eg", name = "i", descriptor = "[B")
    public static final byte[] pathSpeeds = new byte[COUNT];

    @OriginalMember(owner = "client!jt", name = "g", descriptor = "I")
    public static int activePlayerSlot = -1;

    @OriginalMember(owner = "client!km", name = "a", descriptor = "I")
    public static int highResolutionCount = 0;

    @OriginalMember(owner = "client!bma", name = "b", descriptor = "I")
    public static int lowResolutionCount = 0;

    @OriginalMember(owner = "client!uka", name = "y", descriptor = "I")
    public static int extendedInfoCount = 0;

    @OriginalMember(owner = "client!jp", name = "a", descriptor = "(BLclient!rka;I)V")
    public static void iteratePlayers(@OriginalArg(1) BitPacket bitPacket, @OriginalArg(2) int size) {
        extendedInfoCount = 0;
        debug = false;

        processInfo(bitPacket);
        processExtendedInfo(bitPacket);

        if (debug) {
            System.out.println("---endgpp---");
        }

        if (bitPacket.pos != size) {
            throw new RuntimeException("gpi1 pos:" + bitPacket.pos + " psize:" + size);
        }
    }

    @OriginalMember(owner = "client!ida", name = "a", descriptor = "(Lclient!rka;I)V")
    public static void processInfo(@OriginalArg(0) BitPacket bitPacket) {
        @Pc(10) int stationary = 0;

        /* nsn0 */
        bitPacket.enterBitMode();

        for (@Pc(12) int i = 0; i < highResolutionCount; i++) {
            @Pc(20) int slot = highResolutionSlots[i];

            if ((updateHistory[slot] & SKIPPED_LAST_CYCLE) == 0) {
                if (stationary > 0) {
                    updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    stationary--;
                } else {
                    @Pc(52) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    } else {
                        getHighResolutionPlayerPosition(slot, bitPacket);
                    }
                }
            }
        }

        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn0");
        }

        /* nsn1 */
        bitPacket.enterBitMode();

        for (@Pc(20) int i = 0; i < highResolutionCount; i++) {
            @Pc(52) int slot = highResolutionSlots[i];

            if ((updateHistory[slot] & SKIPPED_LAST_CYCLE) != 0) {
                if (stationary > 0) {
                    stationary--;
                    updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                } else {
                    @Pc(144) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    } else {
                        getHighResolutionPlayerPosition(slot, bitPacket);
                    }
                }
            }
        }

        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn1");
        }

        /* nsn2 */
        bitPacket.enterBitMode();

        for (@Pc(52) int i = 0; i < lowResolutionCount; i++) {
            @Pc(144) int slot = lowResolutionSlots[i];

            if ((updateHistory[slot] & SKIPPED_LAST_CYCLE) != 0) {
                if (stationary > 0) {
                    updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    stationary--;
                } else {
                    @Pc(243) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    } else if (getLowResolutionPlayerPosition(slot, bitPacket)) {
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    }
                }
            }
        }

        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn2");
        }

        /* nsn3 */

        bitPacket.enterBitMode();
        for (@Pc(144) int i = 0; i < lowResolutionCount; i++) {
            @Pc(243) int slot = lowResolutionSlots[i];

            if ((updateHistory[slot] & SKIPPED_LAST_CYCLE) == 0) {
                if (stationary > 0) {
                    stationary--;
                    updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                } else {
                    @Pc(351) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    } else if (getLowResolutionPlayerPosition(slot, bitPacket)) {
                        updateHistory[slot] |= SKIPPED_THIS_CYCLE;
                    }
                }
            }
        }

        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn3");
        }

        /* done */

        lowResolutionCount = 0;
        highResolutionCount = 0;

        for (@Pc(243) int i = 1; i < COUNT; i++) {
            updateHistory[i] = (byte) (updateHistory[i] >> 1);

            @Pc(433) PlayerEntity player = highResolutionPlayers[i];
            if (player == null) {
                lowResolutionSlots[lowResolutionCount++] = i;
            } else {
                highResolutionSlots[highResolutionCount++] = i;
            }
        }
    }

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(Lclient!rka;B)V")
    public static void processExtendedInfo(@OriginalArg(0) BitPacket bitPacket) {
        for (@Pc(10) int i = 0; i < extendedInfoCount; i++) {
            @Pc(18) int slot = extendedInfoSlots[i];
            @Pc(22) PlayerEntity player = highResolutionPlayers[slot];

            @Pc(26) int flags = bitPacket.g1();
            if ((flags & 0x80) != 0) {
                flags += bitPacket.g1() << 8;
            }
            if ((flags & 0x800) != 0) {
                flags += bitPacket.g1() << 16;
            }

            processExtendedInfo(player, slot, bitPacket, flags);
        }

        Static618.anInt9449++;
    }

    @OriginalMember(owner = "client!fa", name = "a", descriptor = "(ILclient!ca;ILclient!rka;I)V")
    public static void processExtendedInfo(@OriginalArg(1) PlayerEntity player, @OriginalArg(2) int slot, @OriginalArg(3) BitPacket bitPacket, @OriginalArg(4) int flags) {
        @Pc(7) byte tempSpeed = -1;

        if ((flags & PlayerExtendedInfoFlag.ANIMATE_WORN) != 0) {
            @Pc(15) int count = bitPacket.g1();
            @Pc(18) int[] animations = new int[count];
            @Pc(21) int[] delays = new int[count];
            @Pc(24) int[] slots = new int[count];

            for (@Pc(26) int i = 0; i < count; i++) {
                @Pc(32) int animation = bitPacket.g2();
                if (animation == 65535) {
                    animation = -1;
                }
                animations[i] = animation;
                delays[i] = bitPacket.g1_alt2();
                slots[i] = bitPacket.g2_alt3();
            }

            Static310.animateWorn(slots, animations, delays, player);
        }

        if ((flags & PlayerExtendedInfoFlag.ANIMATION) != 0) {
            @Pc(75) int[] animations = new int[4];
            for (@Pc(77) int j = 0; j < 4; j++) {
                animations[j] = bitPacket.ig2();

                if (animations[j] == 65535) {
                    animations[j] = -1;
                }
            }

            @Pc(108) int delay = bitPacket.g1_alt1();
            PathingEntity.animate(animations, delay, false, player);
        }

        if ((flags & PlayerExtendedInfoFlag.SPOTANIM2) != 0) {
            @Pc(15) int id = bitPacket.g2_alt3();
            @Pc(77) int heightAndDelay = bitPacket.g4_alt3();
            if (id == 65535) {
                id = -1;
            }

            @Pc(108) int data = bitPacket.g1_alt2();
            @Pc(141) int rotation = data & 0x7;
            @Pc(26) int wornSlot = data >> 3 & 0xF;
            if (wornSlot == 15) {
                wornSlot = -1;
            }
            @Pc(166) boolean loop = (data >> 7 & 0x1) == 1;

            player.setSpotAnim(2, rotation, loop, heightAndDelay, wornSlot, id);
        }

        if ((flags & PlayerExtendedInfoFlag.RECOL) != 0) {
            player.recolHue = bitPacket.g1b_alt3();
            player.recolSaturation = bitPacket.g1b_alt3();
            player.recolLightness = bitPacket.g1b_alt2();
            player.recolScale = (byte) bitPacket.g1();
            player.recolStart = TimeUtils.clock + bitPacket.g2_alt3();
            player.recolEnd = TimeUtils.clock + bitPacket.g2();
        }

        if ((flags & PlayerExtendedInfoFlag.TEMP_SPEED) != 0) {
            tempSpeed = bitPacket.g1b_alt2();
        }

        if ((flags & PlayerExtendedInfoFlag.TIMERBAR) != 0) {
            @Pc(15) int data = bitPacket.g2_alt2();
            player.timerbarStart = bitPacket.g1();
            player.timerbarGranularity = bitPacket.g1_alt2();
            player.timerbarSprite = (data & 0x8000) != 0;
            player.timerbarDuration = data & 0x7FFF;
            player.timerbarEnd = player.timerbarStart + player.timerbarDuration + TimeUtils.clock;
        }

        if ((flags & PlayerExtendedInfoFlag.SPOTANIM3) != 0) {
            @Pc(15) int id = bitPacket.ig2();
            @Pc(108) int heightAndDelay = bitPacket.g4_alt3();
            if (id == 65535) {
                id = -1;
            }

            @Pc(108) int data = bitPacket.g1_alt2();
            @Pc(141) int rotation = data & 0x7;
            @Pc(26) int wornSlot = data >> 3 & 0xF;
            if (wornSlot == 15) {
                wornSlot = -1;
            }
            @Pc(166) boolean loop = (data >> 7 & 0x1) == 1;

            player.setSpotAnim(3, rotation, loop, heightAndDelay, wornSlot, id);
        }

        if ((flags & PlayerExtendedInfoFlag.CLANMATE) != 0) {
            player.clanmate = bitPacket.g1_alt2() == 1;
        }

        if ((flags & PlayerExtendedInfoFlag.HITMARK) != 0) {
            @Pc(15) int count = bitPacket.g1();
            if (count > 0) {
                for (@Pc(77) int i = 0; i < count; i++) {
                    @Pc(141) int soakType = -1;
                    @Pc(26) int hitAmount = -1;
                    @Pc(108) int hitType = bitPacket.gsmart();
                    @Pc(32) int soakAmount = -1;

                    if (hitType == 32767) {
                        hitType = bitPacket.gsmart();
                        hitAmount = bitPacket.gsmart();
                        soakType = bitPacket.gsmart();
                        soakAmount = bitPacket.gsmart();
                    } else if (hitType == 32766) {
                        hitType = -1;
                    } else {
                        hitAmount = bitPacket.gsmart();
                    }

                    @Pc(436) int delay = bitPacket.gsmart();
                    @Pc(440) int healthPercentage = bitPacket.g1_alt2();
                    player.hit(soakAmount, delay, healthPercentage, hitAmount, TimeUtils.clock, soakType, hitType);
                }
            }
        }

        if ((flags & PlayerExtendedInfoFlag.WORN) != 0) {
            @Pc(15) int count = bitPacket.g1_alt3();
            @Pc(18) int[] wornTargets = new int[count];
            @Pc(21) int[] wornFlags = new int[count];

            for (@Pc(141) int i = 0; i < count; i++) {
                @Pc(26) int target = bitPacket.g2_alt2();

                if ((target & 0xC000) == 0xC000) {
                    @Pc(32) int local32 = bitPacket.g2();
                    wornTargets[i] = local32 | target << 16;
                } else {
                    wornTargets[i] = target;
                }

                wornFlags[i] = bitPacket.g2_alt2();
            }

            player.updateWornTargets(wornFlags, wornTargets);
        }

        if ((flags & PlayerExtendedInfoFlag.APPEARANCE) != 0) {
            @Pc(15) int count = bitPacket.g1_alt3();
            @Pc(540) byte[] data = new byte[count];
            @Pc(545) Packet appearance = new Packet(data);
            bitPacket.gdata(0, count, data);
            appearances[slot] = appearance;
            player.decodeAppearance(appearance);
        }

        if ((flags & PlayerExtendedInfoFlag.CHAT) != 0) {
            @Pc(574) String message = bitPacket.gjstr();

            if (message.charAt(0) == '~') {
                message = message.substring(1);
                ChatHistory.add(ChatLineType.PUBLIC, 0, player.getName(false, true), player.getNameUnfiltered(), player.displayName, message);
            } else if (player == PlayerEntity.self) {
                ChatHistory.add(ChatLineType.PUBLIC, 0, player.getName(false, true), player.getNameUnfiltered(), player.displayName, message);
            }

            player.setChatLine(message, 0, 0);
        }

        if ((flags & PlayerExtendedInfoFlag.P_ICON) != 0) {
            player.showPIcon = bitPacket.g1_alt3() == 1;
        }

        if ((flags & PlayerExtendedInfoFlag.SPEED) != 0) {
            pathSpeeds[slot] = bitPacket.g1b_alt3();
        }

        if ((flags & PlayerExtendedInfoFlag.TARGET) != 0) {
            @Pc(15) int target = bitPacket.g2_alt2();
            if (target == 65535) {
                target = -1;
            }

            player.target = target;
        }

        if ((flags & PlayerExtendedInfoFlag.EXACT_MOVE) != 0) {
            player.exactMoveX1 = bitPacket.g1b_alt3();
            player.exactMoveZ1 = bitPacket.g1b();
            player.exactMoveX2 = bitPacket.g1b_alt1();
            player.exactMoveZ2 = bitPacket.g1b_alt1();
            player.exactMoveT1 = bitPacket.ig2() + TimeUtils.clock;
            player.exactMoveT2 = bitPacket.g2_alt3() + TimeUtils.clock;
            player.exactMoveDirection = bitPacket.g1_alt1();

            if (player.moved) {
                player.pathPointer = 0;
                player.exactMoveZ2 += player.moveZ;
                player.exactMoveX1 += player.moveX;
                player.exactMoveZ1 += player.moveZ;
                player.exactMoveX2 += player.moveX;
            } else {
                player.exactMoveX2 += player.pathX[0];
                player.pathPointer = 1;
                player.exactMoveZ2 += player.pathZ[0];
                player.exactMoveZ1 += player.pathZ[0];
                player.exactMoveX1 += player.pathX[0];
            }

            player.animationPathPointer = 0;
        }

        if ((flags & PlayerExtendedInfoFlag.TURN) != 0) {
            player.turnAngle = bitPacket.g2();
            if (player.pathPointer == 0) {
                player.turn(player.turnAngle);
                player.turnAngle = -1;
            }
        }

        if ((flags & PlayerExtendedInfoFlag.SPOTANIM0) != 0) {
            @Pc(15) int id = bitPacket.g2();
            @Pc(77) int heightAndDelay = bitPacket.g4_alt1();
            if (id == 65535) {
                id = -1;
            }

            @Pc(108) int data = bitPacket.g1_alt1();
            @Pc(141) int rotation = data & 0x7;
            @Pc(26) int wornSlot = data >> 3 & 0xF;
            if (wornSlot == 15) {
                wornSlot = -1;
            }
            @Pc(166) boolean loop = (data >> 7 & 0x1) == 1;

            player.setSpotAnim(0, rotation, loop, heightAndDelay, wornSlot, id);
        }

        if ((flags & PlayerExtendedInfoFlag.SPOTANIM1) != 0) {
            @Pc(15) int id = bitPacket.g2_alt3();
            if (id == 65535) {
                id = -1;
            }

            @Pc(77) int heightAndDelay = bitPacket.g4_alt3();
            @Pc(108) int data = bitPacket.g1_alt2();
            @Pc(141) int rotation = data & 0x7;
            @Pc(26) int wornSlot = data >> 3 & 0xF;
            if (wornSlot == 15) {
                wornSlot = -1;
            }
            @Pc(166) boolean loop = (data >> 7 & 0x1) == 1;

            player.setSpotAnim(1, rotation, loop, heightAndDelay, wornSlot, id);
        }

        if (player.moved) {
            if (tempSpeed == MoveSpeed.INSTANT) {
                player.teleport(player.moveX, player.moveZ);
            } else {
                @Pc(985) byte speed;
                if (tempSpeed != -1) {
                    speed = tempSpeed;
                } else {
                    speed = pathSpeeds[slot];
                }

                PathingEntity.updateActionAnimator(player, speed);
                player.move(player.moveX, player.moveZ, speed);
            }
        }
    }

    @OriginalMember(owner = "client!tf", name = "a", descriptor = "(ILclient!rka;I)V")
    public static void getHighResolutionPlayerPosition(@OriginalArg(0) int slot, @OriginalArg(1) BitPacket bitPacket) {
        @Pc(16) boolean updateRequired = bitPacket.gbit(1) == 1;
        if (updateRequired) {
            extendedInfoSlots[extendedInfoCount++] = slot;
        }

        @Pc(33) int update = bitPacket.gbit(2);
        @Pc(37) PlayerEntity player = highResolutionPlayers[slot];
        if (update == HighResolutionPlayerUpdate.IDLE) {
            if (updateRequired) {
                player.moved = false;
            } else if (slot == activePlayerSlot) {
                throw new RuntimeException("s:lr");
            } else {
                @Pc(70) SnapShotPlayer snapShot = lowResolutionPlayers[slot] = new SnapShotPlayer();
                snapShot.coord = (player.level << 28) + ((WorldMap.areaBaseX + player.pathX[0] >> 6 << 14) + (WorldMap.areaBaseZ + player.pathZ[0] >> 6));
                if (player.turnAngle == -1) {
                    snapShot.direction = player.yaw.getValue(16383);
                } else {
                    snapShot.direction = player.turnAngle;
                }
                snapShot.target = player.target;
                snapShot.showPIcon = player.showPIcon;
                snapShot.clanmate = player.clanmate;
                if (player.soundRange > 0) {
                    Static76.method1552(player);
                }

                highResolutionPlayers[slot] = null;

                if (bitPacket.gbit(1) != 0) {
                    getLowResolutionPlayerPosition(slot, bitPacket);
                }
            }
        } else if (update == HighResolutionPlayerUpdate.WALK) {
            @Pc(165) int direction = bitPacket.gbit(3);

            @Pc(170) int x = player.pathX[0];
            @Pc(175) int z = player.pathZ[0];
            if (direction == 0) {
                z--;
                x--;
            } else if (direction == 1) {
                z--;
            } else if (direction == 2) {
                z--;
                x++;
            } else if (direction == 3) {
                x--;
            } else if (direction == 4) {
                x++;
            } else if (direction == 5) {
                z++;
                x--;
            } else if (direction == 6) {
                z++;
            } else if (direction == 7) {
                x++;
                z++;
            }

            if (updateRequired) {
                player.moveZ = z;
                player.moveX = x;
                player.moved = true;
            } else {
                player.move(x, z, pathSpeeds[slot]);
            }
        } else if (update == HighResolutionPlayerUpdate.RUN) {
            @Pc(165) int direction = bitPacket.gbit(4);

            @Pc(170) int x = player.pathX[0];
            @Pc(175) int z = player.pathZ[0];
            if (direction == 0) {
                x -= 2;
                z -= 2;
            } else if (direction == 1) {
                x--;
                z -= 2;
            } else if (direction == 2) {
                z -= 2;
            } else if (direction == 3) {
                x++;
                z -= 2;
            } else if (direction == 4) {
                z -= 2;
                x += 2;
            } else if (direction == 5) {
                z--;
                x -= 2;
            } else if (direction == 6) {
                x += 2;
                z--;
            } else if (direction == 7) {
                x -= 2;
            } else if (direction == 8) {
                x += 2;
            } else if (direction == 9) {
                x -= 2;
                z++;
            } else if (direction == 10) {
                x += 2;
                z++;
            } else if (direction == 11) {
                z += 2;
                x -= 2;
            } else if (direction == 12) {
                z += 2;
                x--;
            } else if (direction == 13) {
                z += 2;
            } else if (direction == 14) {
                z += 2;
                x++;
            } else if (direction == 15) {
                x += 2;
                z += 2;
            }

            if (updateRequired) {
                player.moveX = x;
                player.moveZ = z;
                player.moved = true;
            } else {
                player.move(x, z, pathSpeeds[slot]);
            }
        } else /* if (update == HighResolutionPlayerUpdate.TELEPORT) */ {
            @Pc(165) int outsideViewport = bitPacket.gbit(1);

            if (outsideViewport != 0) {
                @Pc(170) int delta = bitPacket.gbit(30);
                @Pc(175) int deltaLevel = delta >> 28;
                @Pc(539) int deltaX = (delta >> 14) & 0x3FFF;
                @Pc(551) int deltaZ = delta & 0x3FFF;

                @Pc(566) int x = ((player.pathX[0] + WorldMap.areaBaseX + deltaX) & 0x3FFF) - WorldMap.areaBaseX;
                @Pc(573) int z = ((player.pathZ[0] + WorldMap.areaBaseZ + deltaZ) & 0x3FFF) - WorldMap.areaBaseZ;

                if (updateRequired) {
                    player.moved = true;
                    player.moveZ = z;
                    player.moveX = x;
                } else {
                    player.move(x, z, pathSpeeds[slot]);
                }

                player.level = player.virtualLevel = (byte) ((deltaLevel + player.level) & 0x3);

                if (Static441.isBridgeAt(z, x)) {
                    player.virtualLevel++;
                }

                if (activePlayerSlot == slot) {
                    Camera.renderingLevel = player.level;
                }
            } else {
                @Pc(170) int delta = bitPacket.gbit(12);
                @Pc(175) int deltaLevel = delta >> 10;

                @Pc(539) int deltaX = delta >> 5 & 0x1F;
                if (deltaX > 15) {
                    deltaX -= 32;
                }

                @Pc(551) int deltaZ = delta & 0x1F;
                if (deltaZ > 15) {
                    deltaZ -= 32;
                }

                @Pc(566) int x = player.pathX[0] + deltaX;
                @Pc(573) int z = player.pathZ[0] + deltaZ;

                if (updateRequired) {
                    player.moveX = x;
                    player.moved = true;
                    player.moveZ = z;
                } else {
                    player.move(x, z, pathSpeeds[slot]);
                }

                player.level = player.virtualLevel = (byte) ((player.level + deltaLevel) & 0x3);

                if (Static441.isBridgeAt(z, x)) {
                    player.virtualLevel++;
                }

                if (slot == activePlayerSlot) {
                    if (player.level != Camera.renderingLevel) {
                        Static75.hasOpaqueStationaryEntities = true;
                    }

                    Camera.renderingLevel = player.level;
                }
            }
        }
    }

    @OriginalMember(owner = "client!ma", name = "a", descriptor = "(ILclient!rka;I)Z")
    public static boolean getLowResolutionPlayerPosition(@OriginalArg(0) int slot, @OriginalArg(1) BitPacket bitPacket) {
        @Pc(18) int update = bitPacket.gbit(2);

        if (update == LowResolutionPlayerUpdate.TRANSITION) {
            boolean updateRequired = bitPacket.gbit(1) != 0;
            if (updateRequired) {
                getLowResolutionPlayerPosition(slot, bitPacket);
            }

            @Pc(45) int deltaX = bitPacket.gbit(6);
            @Pc(127) int deltaY = bitPacket.gbit(6);

            @Pc(63) boolean blockUpdateRequired = bitPacket.gbit(1) == 1;
            if (blockUpdateRequired) {
                extendedInfoSlots[extendedInfoCount++] = slot;
            }

            if (highResolutionPlayers[slot] != null) {
                throw new RuntimeException("hr:lr");
            }

            @Pc(91) SnapShotPlayer snapshot = lowResolutionPlayers[slot];
            @Pc(99) PlayerEntity player = highResolutionPlayers[slot] = new PlayerEntity();

            player.slot = slot;

            if (appearances[slot] != null) {
                player.decodeAppearance(appearances[slot]);
            }

            player.turn(snapshot.direction, true);
            player.target = snapshot.target;

            @Pc(127) int coord = snapshot.coord;
            @Pc(131) int level = coord >> 28;
            @Pc(137) int x = coord >> 14 & 0xFF;
            @Pc(141) int z = coord & 0xFF;
            @Pc(149) int localX = ((x << 6) + deltaX) - WorldMap.areaBaseX;
            @Pc(161) int localZ = ((z << 6) + deltaY) - WorldMap.areaBaseZ;

            player.clanmate = snapshot.clanmate;
            player.showPIcon = snapshot.showPIcon;
            player.pathSpeed[0] = pathSpeeds[slot];

            player.level = player.virtualLevel = (byte) level;
            if (Static441.isBridgeAt(localZ, localX)) {
                player.virtualLevel++;
            }

            player.teleport(localX, localZ);
            player.moved = false;
            lowResolutionPlayers[slot] = null;
            return true;
        } else if (update == LowResolutionPlayerUpdate.CHANGE_LEVEL) {
            @Pc(45) int deltaLevel = bitPacket.gbit(2);
            @Pc(50) int coord = lowResolutionPlayers[slot].coord;
            lowResolutionPlayers[slot].coord = (((coord >> 28) + deltaLevel & 0x3) << 28) + (coord & 0xFFFFFFF);
            return false;
        } else if (update == LowResolutionPlayerUpdate.CHANGE_MAP) {
            @Pc(45) int data = bitPacket.gbit(5);
            @Pc(50) int deltaLevel = data >> 3;
            @Pc(257) int direction = data & 0x7;
            @Pc(262) int coord = lowResolutionPlayers[slot].coord;
            @Pc(271) int level = ((coord >> 28) + deltaLevel) & 0x3;
            @Pc(127) int x = (coord >> 14) & 0xFF;
            @Pc(131) int z = coord & 0xFF;

            if (direction == 0) {
                z--;
                x--;
            } else if (direction == 1) {
                z--;
            } else if (direction == 2) {
                x++;
                z--;
            } else if (direction == 3) {
                x--;
            } else if (direction == 4) {
                x++;
            } else if (direction == 5) {
                x--;
                z++;
            } else if (direction == 6) {
                z++;
            } else if (direction == 7) {
                x++;
                z++;
            }

            lowResolutionPlayers[slot].coord = (level << 28) + (x << 14) + z;
            return false;
        } else /* if (update == LowResolutionPlayerUpdate.TELEPORT) */ {
            @Pc(45) int data = bitPacket.gbit(18);
            @Pc(50) int deltaLevel = data >> 16;
            @Pc(257) int deltaX = (data >> 8) & 0xFF;
            @Pc(262) int deltaZ = data & 0xFF;
            @Pc(271) int coord = lowResolutionPlayers[slot].coord;
            @Pc(127) int level = ((coord >> 28) + deltaLevel) & 0x3;
            @Pc(131) int x = ((coord >> 14) + deltaX) & 0xFF;
            @Pc(137) int z = (coord + deltaZ) & 0xFF;
            lowResolutionPlayers[slot].coord = (level << 28) + (x << 14) + z;
            return false;
        }
    }

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(Lclient!rka;I)V")
    public static void getSnapShotPlayer(@OriginalArg(0) BitPacket bitPacket) {
        bitPacket.enterBitMode();
        @Pc(10) int slot = activePlayerSlot;

        @Pc(20) PlayerEntity self = PlayerEntity.self = highResolutionPlayers[slot] = new PlayerEntity();
        self.slot = slot;

        @Pc(28) int delta = bitPacket.gbit(30);
        @Pc(33) byte deltaLevel = (byte) (delta >> 28);
        @Pc(39) int deltaX = (delta >> 14) & 0x3FFF;
        @Pc(51) int deltaZ = delta & 0x3FFF;

        self.pathX[0] = deltaX - WorldMap.areaBaseX;
        self.x = (self.pathX[0] << 9) + (self.getSize() << 8);

        self.pathZ[0] = deltaZ - WorldMap.areaBaseZ;
        self.z = (self.pathZ[0] << 9) + (self.getSize() << 8);

        Camera.renderingLevel = self.level = self.virtualLevel = deltaLevel;
        if (Static441.isBridgeAt(self.pathZ[0], self.pathX[0])) {
            self.virtualLevel++;
        }

        if (appearances[slot] != null) {
            self.decodeAppearance(appearances[slot]);
        }

        highResolutionCount = 0;
        highResolutionSlots[highResolutionCount++] = slot;
        updateHistory[slot] = 0;
        lowResolutionCount = 0;

        for (@Pc(151) int i = 1; i < COUNT; i++) {
            if (slot != i) {
                @Pc(163) int coord = bitPacket.gbit(18);
                @Pc(167) int level = coord >> 16;
                @Pc(173) int x = (coord >> 8) & 0xFF;
                @Pc(177) int z = coord & 0xFF;

                @Pc(185) SnapShotPlayer snapShot = lowResolutionPlayers[i] = new SnapShotPlayer();
                snapShot.showPIcon = false;
                snapShot.target = -1;
                snapShot.coord = (level << 28) + (x << 14) + z;
                snapShot.direction = 0;
                snapShot.clanmate = false;

                lowResolutionSlots[lowResolutionCount++] = i;
                updateHistory[i] = 0;
            }
        }

        bitPacket.exitBitMode();
    }

    @OriginalMember(owner = "client!bv", name = "a", descriptor = "(Lclient!rka;I)I")
    public static int readStationary(@OriginalArg(0) BitPacket bitPacket) {
        @Pc(10) int type = bitPacket.gbit(2);
        @Pc(22) int result;
        if (type == 0) {
            result = 0;
        } else if (type == 1) {
            result = bitPacket.gbit(5);
        } else if (type == 2) {
            result = bitPacket.gbit(8);
        } else {
            result = bitPacket.gbit(11);
        }
        return result;
    }

    private PlayerList() {
        /* empty */
    }
}
