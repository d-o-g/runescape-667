import com.jagex.core.constants.ChatLineType;
import com.jagex.core.constants.PlayerExtendedInfoFlag;
import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.MoveSpeed;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class PlayerList {

    public static final int SKIPPED_LAST_CYCLE = 0x1;

    public static final int SKIPPED_THIS_CYCLE = 0x2;

    @OriginalMember(owner = "client!tl", name = "f", descriptor = "[Lclient!ca;")
    public static final PlayerEntity[] highResolutionPlayers = new PlayerEntity[2048];

    @OriginalMember(owner = "client!ml", name = "f", descriptor = "[B")
    public static final byte[] updateHistory = new byte[2048];

    @OriginalMember(owner = "client!gia", name = "o", descriptor = "[I")
    public static final int[] highResolutionPlayerIndices = new int[2048];

    @OriginalMember(owner = "client!mt", name = "N", descriptor = "[I")
    public static final int[] lowResolutionPlayerIndices = new int[2048];

    @OriginalMember(owner = "client!kca", name = "O", descriptor = "[I")
    public static final int[] extendedInfoIndices = new int[2048];

    @OriginalMember(owner = "client!hl", name = "d", descriptor = "[Lclient!tea;")
    public static final SnapShotPlayer[] lowResolutionPlayers = new SnapShotPlayer[2048];

    @OriginalMember(owner = "client!ok", name = "q", descriptor = "[Lclient!ge;")
    public static final Packet[] appearances = new Packet[2048];

    @OriginalMember(owner = "client!eg", name = "i", descriptor = "[B")
    public static final byte[] pathSpeeds = new byte[2048];

    @OriginalMember(owner = "client!jt", name = "g", descriptor = "I")
    public static int activePlayerSlot = -1;

    @OriginalMember(owner = "client!km", name = "a", descriptor = "I")
    public static int highResolutionPlayerCount = 0;

    @OriginalMember(owner = "client!bma", name = "b", descriptor = "I")
    public static int lowResolutionPlayerCount = 0;

    @OriginalMember(owner = "client!uka", name = "y", descriptor = "I")
    public static int extendedInfoUpdateCount = 0;

    @OriginalMember(owner = "client!lf", name = "r", descriptor = "Z")
    public static boolean debug = false;

    @OriginalMember(owner = "client!jp", name = "a", descriptor = "(BLclient!rka;I)V")
    public static void iteratePlayers(@OriginalArg(1) BitPacket bitPacket, @OriginalArg(2) int size) {
        extendedInfoUpdateCount = 0;
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
        bitPacket.enterBitMode();
        @Pc(10) int stationary = 0;
        for (@Pc(12) int i = 0; i < highResolutionPlayerCount; i++) {
            @Pc(20) int id = highResolutionPlayerIndices[i];

            if ((updateHistory[id] & SKIPPED_LAST_CYCLE) == 0) {
                if (stationary > 0) {
                    updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    stationary--;
                } else {
                    @Pc(52) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    } else {
                        method8217(id, bitPacket);
                    }
                }
            }
        }
        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn0");
        }

        bitPacket.enterBitMode();
        for (@Pc(20) int i = 0; i < highResolutionPlayerCount; i++) {
            @Pc(52) int id = highResolutionPlayerIndices[i];

            if ((updateHistory[id] & SKIPPED_LAST_CYCLE) != 0) {
                if (stationary > 0) {
                    stationary--;
                    updateHistory[id] |= SKIPPED_THIS_CYCLE;
                } else {
                    @Pc(144) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    } else {
                        method8217(id, bitPacket);
                    }
                }
            }
        }
        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn1");
        }

        bitPacket.enterBitMode();
        for (@Pc(52) int i = 0; i < lowResolutionPlayerCount; i++) {
            @Pc(144) int id = lowResolutionPlayerIndices[i];

            if ((updateHistory[id] & 0x1) != 0) {
                if (stationary > 0) {
                    updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    stationary--;
                } else {
                    @Pc(243) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    } else if (getLowResolutionPlayerPosition(id, bitPacket)) {
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    }
                }
            }
        }
        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn2");
        }

        bitPacket.enterBitMode();
        for (@Pc(144) int i = 0; i < lowResolutionPlayerCount; i++) {
            @Pc(243) int id = lowResolutionPlayerIndices[i];

            if ((updateHistory[id] & SKIPPED_LAST_CYCLE) == 0) {
                if (stationary > 0) {
                    stationary--;
                    updateHistory[id] |= SKIPPED_THIS_CYCLE;
                } else {
                    @Pc(351) int change = bitPacket.gbit(1);

                    if (change == 0) {
                        stationary = readStationary(bitPacket);
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    } else if (getLowResolutionPlayerPosition(id, bitPacket)) {
                        updateHistory[id] |= SKIPPED_THIS_CYCLE;
                    }
                }
            }
        }
        bitPacket.exitBitMode();

        if (stationary != 0) {
            throw new RuntimeException("nsn3");
        }

        lowResolutionPlayerCount = 0;
        highResolutionPlayerCount = 0;

        for (@Pc(243) int i = 1; i < 2048; i++) {
            updateHistory[i] = (byte) (updateHistory[i] >> 1);

            @Pc(433) PlayerEntity player = highResolutionPlayers[i];
            if (player == null) {
                lowResolutionPlayerIndices[lowResolutionPlayerCount++] = i;
            } else {
                highResolutionPlayerIndices[highResolutionPlayerCount++] = i;
            }
        }
    }

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(Lclient!rka;B)V")
    public static void processExtendedInfo(@OriginalArg(0) BitPacket bitPacket) {
        for (@Pc(10) int i = 0; i < extendedInfoUpdateCount; i++) {
            @Pc(18) int index = extendedInfoIndices[i];
            @Pc(22) PlayerEntity player = highResolutionPlayers[index];

            @Pc(26) int flags = bitPacket.g1();
            if ((flags & 0x80) != 0) {
                flags += bitPacket.g1() << 8;
            }
            if ((flags & 0x800) != 0) {
                flags += bitPacket.g1() << 16;
            }

            processExtendedInfo(player, index, bitPacket, flags);
        }

        Static618.anInt9449++;
    }

    @OriginalMember(owner = "client!fa", name = "a", descriptor = "(ILclient!ca;ILclient!rka;I)V")
    public static void processExtendedInfo(@OriginalArg(1) PlayerEntity player, @OriginalArg(2) int index, @OriginalArg(3) BitPacket bitPacket, @OriginalArg(4) int flags) {
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
            Static651.animate(animations, delay, false, player);
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
            appearances[index] = appearance;
            player.decodeAppearance(appearance);
        }

        if ((flags & PlayerExtendedInfoFlag.CHAT) != 0) {
            @Pc(574) String message = bitPacket.gjstr();

            if (message.charAt(0) == '~') {
                message = message.substring(1);
                ChatHistory.add(message, player.getDisplayName(false, true), 0, player.displayName, player.getAccountName(), ChatLineType.PUBLIC);
            } else if (player == PlayerEntity.self) {
                ChatHistory.add(message, player.getDisplayName(false, true), 0, player.displayName, player.getAccountName(), ChatLineType.PUBLIC);
            }

            player.method1413(0, 0, message);
        }

        if ((flags & PlayerExtendedInfoFlag.P_ICON) != 0) {
            player.showPIcon = bitPacket.g1_alt3() == 1;
        }

        if ((flags & PlayerExtendedInfoFlag.SPEED) != 0) {
            pathSpeeds[index] = bitPacket.g1b_alt3();
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
            player.anInt1467 = bitPacket.g2();
            if (player.pathPointer == 0) {
                player.method9305(player.anInt1467);
                player.anInt1467 = -1;
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
            if (tempSpeed == MoveSpeed.TELEPORT) {
                player.teleport(player.moveX, player.moveZ);
            } else {
                @Pc(985) byte speed;
                if (tempSpeed != -1) {
                    speed = tempSpeed;
                } else {
                    speed = pathSpeeds[index];
                }

                Static702.updateActionAnimator(player, speed);
                player.move(player.moveZ, player.moveX, speed);
            }
        }
    }

    @OriginalMember(owner = "client!ma", name = "a", descriptor = "(ILclient!rka;I)Z")
    public static boolean getLowResolutionPlayerPosition(@OriginalArg(0) int id, @OriginalArg(1) BitPacket bitPacket) {
        @Pc(18) int type = bitPacket.gbit(2);

        if (type == 0) {
            if (bitPacket.gbit(1) != 0) {
                getLowResolutionPlayerPosition(id, bitPacket);
            }

            @Pc(45) int deltaX = bitPacket.gbit(6);
            @Pc(127) int deltaY = bitPacket.gbit(6);
            @Pc(63) boolean updateRequired = bitPacket.gbit(1) == 1;
            if (updateRequired) {
                extendedInfoIndices[extendedInfoUpdateCount++] = id;
            }

            if (highResolutionPlayers[id] != null) {
                throw new RuntimeException("hr:lr");
            }

            @Pc(91) SnapShotPlayer snapshot = lowResolutionPlayers[id];
            @Pc(99) PlayerEntity player = highResolutionPlayers[id] = new PlayerEntity();
            player.id = id;
            if (appearances[id] != null) {
                player.decodeAppearance(appearances[id]);
            }

            player.turn(snapshot.direction, true);
            player.target = snapshot.target;

            @Pc(127) int coord = snapshot.coord;
            @Pc(131) int level = coord >> 28;
            @Pc(137) int x = coord >> 14 & 0xFF;
            @Pc(141) int z = coord & 0xFF;
            @Pc(149) int localX = (x << 6) + (deltaX - WorldMap.areaBaseX);
            @Pc(161) int localZ = (z << 6) + deltaY - WorldMap.areaBaseZ;

            player.clanmate = snapshot.clanmate;
            player.showPIcon = snapshot.showPIcon;
            player.pathSpeed[0] = pathSpeeds[id];

            player.level = player.virtualLevel = (byte) level;
            if (Static441.isBridgeAt(localZ, localX)) {
                player.virtualLevel++;
            }

            player.teleport(localX, localZ);
            player.moved = false;
            lowResolutionPlayers[id] = null;
            return true;
        } else if (type == 1) {
            @Pc(45) int deltaLevel = bitPacket.gbit(2);
            @Pc(50) int coord = lowResolutionPlayers[id].coord;
            lowResolutionPlayers[id].coord = (((coord >> 28) + deltaLevel & 0x3) << 28) + (coord & 0xFFFFFFF);
            return false;
        } else if (type == 2) {
            @Pc(45) int data = bitPacket.gbit(5);
            @Pc(50) int deltaLevel = data >> 3;
            @Pc(257) int direction = data & 0x7;
            @Pc(262) int coord = lowResolutionPlayers[id].coord;
            @Pc(271) int level = (coord >> 28) + deltaLevel & 0x3;
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

            lowResolutionPlayers[id].coord = (level << 28) + (x << 14) + z;
            return false;
        } else {
            @Pc(45) int data = bitPacket.gbit(18);
            @Pc(50) int deltaLevel = data >> 16;
            @Pc(257) int deltaX = (data >> 8) & 0xFF;
            @Pc(262) int deltaZ = data & 0xFF;
            @Pc(271) int coord = lowResolutionPlayers[id].coord;
            @Pc(127) int level = ((coord >> 28) + deltaLevel) & 0x3;
            @Pc(131) int x = ((coord >> 14) + deltaX) & 0xFF;
            @Pc(137) int z = (coord + deltaZ) & 0xFF;
            lowResolutionPlayers[id].coord = (level << 28) + (x << 14) + z;
            return false;
        }
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

    @OriginalMember(owner = "client!tf", name = "a", descriptor = "(ILclient!rka;I)V")
    public static void method8217(@OriginalArg(0) int arg0, @OriginalArg(1) BitPacket bitPacket) {
        @Pc(16) boolean local16 = bitPacket.gbit(1) == 1;
        if (local16) {
            extendedInfoIndices[extendedInfoUpdateCount++] = arg0;
        }
        @Pc(33) int local33 = bitPacket.gbit(2);
        @Pc(37) PlayerEntity local37 = highResolutionPlayers[arg0];
        if (local33 != 0) {
            @Pc(165) int local165;
            @Pc(170) int local170;
            @Pc(175) int local175;
            if (local33 == 1) {
                local165 = bitPacket.gbit(3);
                local170 = local37.pathX[0];
                local175 = local37.pathZ[0];
                if (local165 == 0) {
                    local175--;
                    local170--;
                } else if (local165 == 1) {
                    local175--;
                } else if (local165 == 2) {
                    local175--;
                    local170++;
                } else if (local165 == 3) {
                    local170--;
                } else if (local165 == 4) {
                    local170++;
                } else if (local165 == 5) {
                    local175++;
                    local170--;
                } else if (local165 == 6) {
                    local175++;
                } else if (local165 == 7) {
                    local170++;
                    local175++;
                }
                if (local16) {
                    local37.moveZ = local175;
                    local37.moveX = local170;
                    local37.moved = true;
                } else {
                    local37.move(local175, local170, pathSpeeds[arg0]);
                }
            } else if (local33 == 2) {
                local165 = bitPacket.gbit(4);
                local170 = local37.pathX[0];
                local175 = local37.pathZ[0];
                if (local165 == 0) {
                    local170 -= 2;
                    local175 -= 2;
                } else if (local165 == 1) {
                    local170--;
                    local175 -= 2;
                } else if (local165 == 2) {
                    local175 -= 2;
                } else if (local165 == 3) {
                    local170++;
                    local175 -= 2;
                } else if (local165 == 4) {
                    local175 -= 2;
                    local170 += 2;
                } else if (local165 == 5) {
                    local175--;
                    local170 -= 2;
                } else if (local165 == 6) {
                    local170 += 2;
                    local175--;
                } else if (local165 == 7) {
                    local170 -= 2;
                } else if (local165 == 8) {
                    local170 += 2;
                } else if (local165 == 9) {
                    local170 -= 2;
                    local175++;
                } else if (local165 == 10) {
                    local170 += 2;
                    local175++;
                } else if (local165 == 11) {
                    local175 += 2;
                    local170 -= 2;
                } else if (local165 == 12) {
                    local175 += 2;
                    local170--;
                } else if (local165 == 13) {
                    local175 += 2;
                } else if (local165 == 14) {
                    local175 += 2;
                    local170++;
                } else if (local165 == 15) {
                    local170 += 2;
                    local175 += 2;
                }
                if (local16) {
                    local37.moveX = local170;
                    local37.moveZ = local175;
                    local37.moved = true;
                } else {
                    local37.move(local175, local170, pathSpeeds[arg0]);
                }
            } else {
                local165 = bitPacket.gbit(1);
                @Pc(539) int local539;
                @Pc(551) int local551;
                @Pc(566) int local566;
                @Pc(573) int local573;
                if (local165 == 0) {
                    local170 = bitPacket.gbit(12);
                    local175 = local170 >> 10;
                    local539 = local170 >> 5 & 0x1F;
                    if (local539 > 15) {
                        local539 -= 32;
                    }
                    local551 = local170 & 0x1F;
                    if (local551 > 15) {
                        local551 -= 32;
                    }
                    local566 = local37.pathX[0] + local539;
                    local573 = local551 + local37.pathZ[0];
                    if (local16) {
                        local37.moveX = local566;
                        local37.moved = true;
                        local37.moveZ = local573;
                    } else {
                        local37.move(local573, local566, pathSpeeds[arg0]);
                    }
                    local37.level = local37.virtualLevel = (byte) (local37.level + local175 & 0x3);
                    if (Static441.isBridgeAt(local573, local566)) {
                        local37.virtualLevel++;
                    }
                    if (activePlayerSlot == arg0) {
                        if (local37.level != Camera.renderingLevel) {
                            Static75.hasOpaqueStationaryEntities = true;
                        }
                        Camera.renderingLevel = local37.level;
                    }
                } else {
                    local170 = bitPacket.gbit(30);
                    local175 = local170 >> 28;
                    local539 = local170 >> 14 & 0x3FFF;
                    local551 = local170 & 0x3FFF;
                    local566 = (local37.pathX[0] + WorldMap.areaBaseX + local539 & 0x3FFF) - WorldMap.areaBaseX;
                    local573 = (local551 + local37.pathZ[0] + WorldMap.areaBaseZ & 0x3FFF) - WorldMap.areaBaseZ;
                    if (local16) {
                        local37.moved = true;
                        local37.moveZ = local573;
                        local37.moveX = local566;
                    } else {
                        local37.move(local573, local566, pathSpeeds[arg0]);
                    }
                    local37.level = local37.virtualLevel = (byte) (local175 + local37.level & 0x3);
                    if (Static441.isBridgeAt(local573, local566)) {
                        local37.virtualLevel++;
                    }
                    if (activePlayerSlot == arg0) {
                        Camera.renderingLevel = local37.level;
                    }
                }
            }
        } else if (local16) {
            local37.moved = false;
        } else if (activePlayerSlot == arg0) {
            throw new RuntimeException("s:lr");
        } else {
            @Pc(70) SnapShotPlayer local70 = lowResolutionPlayers[arg0] = new SnapShotPlayer();
            local70.coord = (local37.level << 28) + ((WorldMap.areaBaseX + local37.pathX[0] >> 6 << 14) + (WorldMap.areaBaseZ + local37.pathZ[0] >> 6));
            if (local37.anInt1467 == -1) {
                local70.direction = local37.yaw.getValue(16383);
            } else {
                local70.direction = local37.anInt1467;
            }
            local70.target = local37.target;
            local70.showPIcon = local37.showPIcon;
            local70.clanmate = local37.clanmate;
            if (local37.soundRange > 0) {
                Static76.method1552(local37);
            }
            highResolutionPlayers[arg0] = null;
            if (bitPacket.gbit(1) != 0) {
                getLowResolutionPlayerPosition(arg0, bitPacket);
            }
        }
    }
}
