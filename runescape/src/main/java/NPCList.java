import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.MoveSpeed;
import com.jagex.game.runetek6.config.npctype.NPCTypeCustomisation;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class NPCList {

    private static final int UPDATE_READY = 0;

    private static final int UPDATE_WALK = 1;

    private static final int UPDATE_RUN_OR_CRAWL = 2;

    private static final int UPDATE_REMOVE = 3;

    private static final int FLAG_SPOTANIM_2 = 0x100000;

    private static final int FLAG_TARGET = 0x1;

    private static final int FLAG_SPOTANIM3 = 0x20000;

    private static final int FLAG_HITMARK = 0x40;

    private static final int FLAG_TIMERBAR = 0x100;

    private static final int FLAG_NAME = 0x40000;

    private static final int FLAG_SET_TYPE = 0x20;

    private static final int FLAG_CHAT = 0x2;

    private static final int FLAG_TURN_TO = 0x8;

    private static final int FLAG_COMBAT_LEVEL = 0x80000;

    private static final int FLAG_WORN = 0x2000;

    private static final int FLAG_CUSTOMISE_HEAD = 0x10000;

    private static final int FLAG_EXACT_MOVE = 0x400;

    private static final int FLAG_ANIMATE = 0x10;

    private static final int FLAG_CUSTOMISE = 0x800;

    private static final int FLAG_ANIMATE_WORN = 0x4000;

    private static final int FLAG_SPOTANIM1 = 0x1000;

    private static final int FLAG_SPOTANIM0 = 0x4;

    private static final int FLAG_RECOL = 0x200;

    @OriginalMember(owner = "client!aka", name = "m", descriptor = "Lclient!av;")
    public static final IterableHashTable local = new IterableHashTable(64);

    @OriginalMember(owner = "client!dm", name = "d", descriptor = "[I")
    public static final int[] pendingRemoval = new int[1000];

    @OriginalMember(owner = "client!dda", name = "c", descriptor = "[I")
    public static final int[] localNpcIndices = new int[1024];

    @OriginalMember(owner = "client!sla", name = "b", descriptor = "[Lclient!qfa;")
    public static final NPCEntityNode[] localNpcs = new NPCEntityNode[1024];

    @OriginalMember(owner = "client!oi", name = "q", descriptor = "[I")
    public static final int[] pendingBlockUpdate = new int[250];

    @OriginalMember(owner = "client!cj", name = "k", descriptor = "I")
    public static int removedCount = 0;

    @OriginalMember(owner = "client!cma", name = "M", descriptor = "I")
    public static int blockUpdateCount = 0;

    @OriginalMember(owner = "client!s", name = "o", descriptor = "I")
    public static int clock = 0;

    @OriginalMember(owner = "client!nca", name = "m", descriptor = "I")
    public static int newNpcCount = 0;

    @OriginalMember(owner = "client!mda", name = "H", descriptor = "I")
    public static int localNpcCount = 0;

    @OriginalMember(owner = "client!kt", name = "c", descriptor = "(I)V")
    public static void updateNpcs() {
        removedCount = 0;
        blockUpdateCount = 0;
        clock++;

        iterateNpcs();
        processNewNpcs();
        processExtendedInfo();

        @Pc(23) boolean local23 = false;
        for (@Pc(25) int i = 0; i < removedCount; i++) {
            @Pc(33) int index = pendingRemoval[i];
            @Pc(40) NPCEntityNode node = (NPCEntityNode) local.get(index);

            @Pc(43) NPCEntity npc = node.npc;
            if (npc.cutsceneClock != clock) {
                if (MiniMenu.open && MiniMenu.hasNpcOp(index)) {
                    MiniMenu.close();
                }
                if (npc.type.hasSounds()) {
                    Static58.method1259(npc);
                }
                npc.setupNewNPCType(null);
                node.unlink();
                local23 = true;
            }
        }

        if (local23) {
            newNpcCount = local.size();
            local.copyTo(localNpcs);
        }

        if (ConnectionManager.GAME.buffer.pos != ConnectionManager.GAME.currentPacketSize) {
            throw new RuntimeException("gnp1 pos:" + ConnectionManager.GAME.buffer.pos + " psize:" + ConnectionManager.GAME.currentPacketSize);
        }

        for (@Pc(33) int i = 0; i < localNpcCount; i++) {
            if (local.get(localNpcIndices[i]) == null) {
                throw new RuntimeException("gnp2 pos:" + i + " size:" + localNpcCount);
            }
        }

        if (newNpcCount - localNpcCount != 0) {
            throw new RuntimeException("gnp3 mis:" + (newNpcCount - localNpcCount));
        }

        for (@Pc(214) int i = 0; i < newNpcCount; i++) {
            if (localNpcs[i].npc.cutsceneClock != clock) {
                throw new RuntimeException("gnp4 uk:" + localNpcs[i].npc.id);
            }
        }
    }

    @OriginalMember(owner = "client!ica", name = "c", descriptor = "(Z)V")
    public static void iterateNpcs() {
        @Pc(8) PacketBuffer buffer = ConnectionManager.GAME.buffer;
        buffer.enterBitMode();

        @Pc(16) int count = buffer.readBits(8);
        if (localNpcCount > count) {
            for (@Pc(21) int i = count; i < localNpcCount; i++) {
                pendingRemoval[removedCount++] = localNpcIndices[i];
            }
        }

        if (count > localNpcCount) {
            throw new RuntimeException("gnpov1");
        }

        localNpcCount = 0;

        for (@Pc(21) int i = 0; i < count; i++) {
            @Pc(73) int index = localNpcIndices[i];
            @Pc(81) NPCEntity npc = ((NPCEntityNode) local.get(index)).npc;

            @Pc(86) int updateRequired = buffer.readBits(1);
            if (updateRequired == 0) {
                localNpcIndices[localNpcCount++] = index;
                npc.cutsceneClock = clock;
            } else {
                @Pc(108) int update = buffer.readBits(2);

                if (update == UPDATE_READY) {
                    localNpcIndices[localNpcCount++] = index;
                    npc.cutsceneClock = clock;
                    pendingBlockUpdate[blockUpdateCount++] = index;
                } else if (update == UPDATE_WALK) {
                    localNpcIndices[localNpcCount++] = index;
                    npc.cutsceneClock = clock;

                    @Pc(156) int direction = buffer.readBits(3);
                    npc.move(MoveSpeed.WALK, direction);

                    @Pc(166) int blockUpdateRequired = buffer.readBits(1);
                    if (blockUpdateRequired == 1) {
                        pendingBlockUpdate[blockUpdateCount++] = index;
                    }
                } else if (update == UPDATE_RUN_OR_CRAWL) {
                    localNpcIndices[localNpcCount++] = index;
                    npc.cutsceneClock = clock;

                    if (buffer.readBits(1) == 1) {
                        @Pc(156) int firstDirection = buffer.readBits(3);
                        npc.move(MoveSpeed.RUN, firstDirection);

                        @Pc(166) int secondDirection = buffer.readBits(3);
                        npc.move(MoveSpeed.RUN, secondDirection);
                    } else {
                        @Pc(156) int direction = buffer.readBits(3);
                        npc.move(MoveSpeed.CRAWL, direction);
                    }

                    @Pc(156) int blockUpdateRequired = buffer.readBits(1);
                    if (blockUpdateRequired == 1) {
                        pendingBlockUpdate[blockUpdateCount++] = index;
                    }
                } else if (update == UPDATE_REMOVE) {
                    pendingRemoval[removedCount++] = index;
                }
            }
        }
    }

    @OriginalMember(owner = "client!fa", name = "a", descriptor = "(I)V")
    public static void processNewNpcs() {
        @Pc(8) PacketBuffer buffer = ConnectionManager.GAME.buffer;
        while (buffer.bitsRemaining(ConnectionManager.GAME.currentPacketSize) >= 15) {
            @Pc(22) int id = buffer.readBits(15);
            if (id == 32767) {
                break;
            }

            @Pc(29) boolean turn = false;
            @Pc(36) NPCEntityNode node = (NPCEntityNode) local.get(id);
            @Pc(42) NPCEntity npc;

            if (node == null) {
                npc = new NPCEntity();
                npc.id = id;
                node = new NPCEntityNode(npc);
                local.put(id, node);
                localNpcs[newNpcCount++] = node;
                turn = true;
            }

            npc = node.npc;
            localNpcIndices[localNpcCount++] = id;
            npc.cutsceneClock = clock;

            if (npc.type != null && npc.type.hasSounds()) {
                Static58.method1259(npc);
            }

            @Pc(108) int yaw = ((buffer.readBits(3) + 4) << 11) & 0x3A6E;

            @Pc(113) int blockUpdateRequired = buffer.readBits(1);
            if (blockUpdateRequired == 1) {
                pendingBlockUpdate[blockUpdateCount++] = id;
            }

            @Pc(131) int deltaX = buffer.readBits(5);
            if (deltaX > 15) {
                deltaX -= 32;
            }

            @Pc(144) int level = buffer.readBits(2);

            npc.setupNewNPCType(NPCTypeList.instance.list(buffer.readBits(15)));

            @Pc(159) int deltaZ = buffer.readBits(5);
            if (deltaZ > 15) {
                deltaZ -= 32;
            }

            @Pc(170) int clearPath = buffer.readBits(1);
            npc.setSize(npc.type.size);
            npc.yawSpeed = npc.type.yawSpeed << 3;

            if (turn) {
                npc.turn(yaw, true);
            }

            npc.clearPath(clearPath == 1, deltaX + PlayerEntity.self.pathZ[0], deltaZ + PlayerEntity.self.pathX[0], level, npc.getSize());

            if (npc.type.hasSounds()) {
                Static89.method1714(npc.level, null, npc.pathX[0], npc.pathZ[0], npc, null, 0);
            }
        }

        buffer.exitBitMode();
    }

    @OriginalMember(owner = "client!qv", name = "a", descriptor = "(Z)V")
    public static void processExtendedInfo() {
        @Pc(15) PacketBuffer buffer = ConnectionManager.GAME.buffer;

        for (@Pc(17) int i = 0; i < blockUpdateCount; i++) {
            @Pc(23) int index = pendingBlockUpdate[i];
            @Pc(31) NPCEntity npc = ((NPCEntityNode) local.get(index)).npc;

            @Pc(35) int flags = buffer.g1();
            if ((flags & 0x80) != 0) {
                flags += buffer.g1() << 8;
            }
            if ((flags & 0x8000) != 0) {
                flags += buffer.g1() << 16;
            }

            if ((flags & FLAG_SPOTANIM_2) != 0) {
                @Pc(73) int id = buffer.g2();
                @Pc(77) int heightAndDelay = buffer.g4();
                if (id == 65535) {
                    id = -1;
                }

                @Pc(86) int data = buffer.g1_alt1();
                @Pc(90) int rotation = data & 0x7;
                @Pc(96) int wornSlot = data >> 3 & 0xF;
                if (wornSlot == 15) {
                    wornSlot = -1;
                }
                @Pc(117) boolean loop = (data >> 7 & 0x1) == 1;

                npc.setSpotAnim(2, rotation, loop, heightAndDelay, wornSlot, id);
            }

            if ((flags & FLAG_TARGET) != 0) {
                npc.target = buffer.ig2();

                if (npc.target == 65535) {
                    npc.target = -1;
                }
            }

            if ((flags & FLAG_SPOTANIM3) != 0) {
                @Pc(73) int id = buffer.g2();
                @Pc(77) int heightAndDelay = buffer.g4();
                if (id == 65535) {
                    id = -1;
                }

                @Pc(86) int data = buffer.g1();
                @Pc(90) int rotation = data & 0x7;
                @Pc(96) int wornSlot = data >> 3 & 0xF;
                if (wornSlot == 15) {
                    wornSlot = -1;
                }
                @Pc(117) boolean loop = (data >> 7 & 0x1) == 1;

                npc.setSpotAnim(3, rotation, loop, heightAndDelay, wornSlot, id);
            }

            if ((flags & FLAG_HITMARK) != 0) {
                @Pc(73) int count = buffer.g1_alt2();

                if (count > 0) {
                    for (@Pc(77) int j = 0; j < count; j++) {
                        @Pc(90) int soakType = -1;
                        @Pc(96) int hitAmount = -1;
                        @Pc(86) int hitType = buffer.gsmart();
                        @Pc(240) int soakAmount = -1;

                        if (hitType == 32767) {
                            hitType = buffer.gsmart();
                            hitAmount = buffer.gsmart();
                            soakType = buffer.gsmart();
                            soakAmount = buffer.gsmart();
                        } else if (hitType == 32766) {
                            hitType = -1;
                        } else {
                            hitAmount = buffer.gsmart();
                        }

                        @Pc(280) int delay = buffer.gsmart();
                        @Pc(284) int healthPercentage = buffer.g1();

                        npc.hit(soakAmount, delay, healthPercentage, hitAmount, TimeUtils.clock, soakType, hitType);
                    }
                }
            }

            if ((flags & FLAG_TIMERBAR) != 0) {
                @Pc(73) int data = buffer.g2_alt2();
                npc.timerbarStart = buffer.g1_alt2();
                npc.timerbarGranularity = buffer.g1_alt2();
                npc.timerbarDuration = data & 0x7FFF;
                npc.timerbarSprite = (data & 0x8000) != 0;
                npc.anInt10719 = npc.timerbarDuration + TimeUtils.clock + npc.timerbarStart;
            }

            if ((flags & FLAG_NAME) != 0) {
                npc.name = buffer.gjstr();

                if ("".equals(npc.name) || npc.name.equals(npc.type.name)) {
                    npc.name = npc.type.name;
                }
            }

            if ((flags & FLAG_SET_TYPE) != 0) {
                if (npc.type.hasSounds()) {
                    Static58.method1259(npc);
                }

                npc.setupNewNPCType(NPCTypeList.instance.list(buffer.ig2()));
                npc.setSize(npc.type.size);
                npc.yawSpeed = npc.type.yawSpeed << 3;

                if (npc.type.hasSounds()) {
                    Static89.method1714(npc.level, null, npc.pathX[0], npc.pathZ[0], npc, null, 0);
                }
            }

            if ((flags & FLAG_CHAT) != 0) {
                npc.chat(0, 0, buffer.gjstr());
            }

            if ((flags & FLAG_TURN_TO) != 0) {
                npc.turnToX = buffer.ig2();
                npc.turnToZ = buffer.ig2();
            }

            if ((flags & FLAG_COMBAT_LEVEL) != 0) {
                npc.combatLevel = buffer.ig2();

                if (npc.combatLevel == 65535) {
                    npc.combatLevel = npc.type.combatLevel;
                }
            }

            if ((flags & FLAG_WORN) != 0) {
                @Pc(73) int count = buffer.g1_alt1();
                @Pc(511) int[] wornTargets = new int[count];
                @Pc(514) int[] wornFlags = new int[count];
                for (@Pc(90) int j = 0; j < count; j++) {
                    @Pc(96) int target = buffer.g2();

                    if ((target & 0xC000) == 0xC000) {
                        @Pc(240) int local240 = buffer.g2_alt2();
                        wornTargets[j] = local240 | target << 16;
                    } else {
                        wornTargets[j] = target;
                    }

                    wornFlags[j] = buffer.g2();
                }

                npc.updateWornTargets(wornFlags, wornTargets);
            }

            if ((flags & FLAG_CUSTOMISE_HEAD) != 0) {
                @Pc(73) int count = npc.type.headModels.length;

                @Pc(77) int length = 0;
                if (npc.type.recol_d != null) {
                    length = npc.type.recol_d.length;
                }
                if (npc.type.retex_d != null) {
                    length = npc.type.retex_d.length;
                }

                @Pc(90) int customiseFlags = buffer.g1_alt3();
                if ((customiseFlags & 0x1) != 1) {
                    @Pc(608) int[] remodel_d = null;
                    if ((customiseFlags & 0x2) == 2) {
                        remodel_d = new int[count];

                        for (@Pc(240) int j = 0; j < count; j++) {
                            remodel_d[j] = buffer.g2_alt3();
                        }
                    }

                    @Pc(636) short[] recol_d = null;
                    if ((customiseFlags & 0x4) == 4) {
                        recol_d = new short[length];

                        for (@Pc(280) int j = 0; j < length; j++) {
                            recol_d[j] = (short) buffer.g2_alt2();
                        }
                    }

                    @Pc(665) short[] retex_d = null;
                    if ((customiseFlags & 0x8) == 8) {
                        retex_d = new short[0];
                        for (@Pc(284) int local284 = 0; local284 < 0; local284++) {
                            retex_d[local284] = (short) buffer.g2();
                        }
                    }

                    @Pc(708) long id = (long) npc.customiseHeadCount++ << 32 | (long) index;
                    new NPCTypeCustomisation(id, remodel_d, recol_d, retex_d);
                }
            }

            if ((flags & FLAG_EXACT_MOVE) != 0) {
                npc.exactMoveX1 = buffer.g1b_alt3();
                npc.exactMoveZ1 = buffer.g1b_alt3();
                npc.exactMoveX2 = buffer.g1b_alt2();
                npc.exactMoveZ2 = buffer.g1b_alt2();
                npc.exactMoveT1 = buffer.g2() + TimeUtils.clock;
                npc.exactMoveT2 = buffer.g2_alt3() + TimeUtils.clock;
                npc.exactMoveDirection = buffer.g1_alt3();

                npc.exactMoveZ2 += npc.pathZ[0];
                npc.pathPointer = 1;
                npc.exactMoveZ1 += npc.pathZ[0];
                npc.exactMoveX2 += npc.pathX[0];
                npc.animationPathPointer = 0;
                npc.exactMoveX1 += npc.pathX[0];
            }

            if ((flags & FLAG_ANIMATE) != 0) {
                @Pc(814) int[] animations = new int[4];
                for (@Pc(77) int j = 0; j < 4; j++) {
                    animations[j] = buffer.g2();

                    if (animations[j] == 65535) {
                        animations[j] = -1;
                    }
                }

                @Pc(86) int delay = buffer.g1();
                Static651.animate(animations, delay, true, npc);
            }

            if ((flags & FLAG_CUSTOMISE) != 0) {
                @Pc(73) int modelsLength = npc.type.models.length;

                @Pc(77) int recolLength = 0;
                if (npc.type.recol_d != null) {
                    recolLength = npc.type.recol_d.length;
                }

                @Pc(86) int retexLength = 0;
                if (npc.type.retex_d != null) {
                    retexLength = npc.type.retex_d.length;
                }

                @Pc(90) int customiseFlags = buffer.g1_alt3();
                if ((customiseFlags & 0x1) == 1) {
                    npc.customisation = null;
                } else {
                    @Pc(608) int[] remodel_d = null;
                    if ((customiseFlags & 0x2) == 2) {
                        remodel_d = new int[modelsLength];
                        for (@Pc(240) int j = 0; j < modelsLength; j++) {
                            remodel_d[j] = buffer.g2();
                        }
                    }

                    @Pc(636) short[] recol_d = null;
                    if ((customiseFlags & 0x4) == 4) {
                        recol_d = new short[recolLength];
                        for (@Pc(280) int j = 0; j < recolLength; j++) {
                            recol_d[j] = (short) buffer.g2();
                        }
                    }

                    @Pc(665) short[] retex_d = null;
                    if ((customiseFlags & 0x8) == 8) {
                        retex_d = new short[retexLength];
                        for (@Pc(284) int j = 0; j < retexLength; j++) {
                            retex_d[j] = (short) buffer.g2_alt3();
                        }
                    }

                    @Pc(708) long id = (long) index | (long) npc.customiseCount++ << 32;
                    npc.customisation = new NPCTypeCustomisation(id, remodel_d, recol_d, retex_d);
                }
            }

            if ((flags & FLAG_ANIMATE_WORN) != 0) {
                @Pc(73) int count = buffer.g1();
                @Pc(511) int[] animations = new int[count];
                @Pc(514) int[] delays = new int[count];
                @Pc(1031) int[] slots = new int[count];
                for (@Pc(96) int j = 0; j < count; j++) {
                    @Pc(240) int animation = buffer.ig2();
                    if (animation == 65535) {
                        animation = -1;
                    }
                    animations[j] = animation;
                    delays[j] = buffer.g1_alt1();
                    slots[j] = buffer.g2();
                }

                Static310.animateWorn(slots, animations, delays, npc);
            }

            if ((flags & FLAG_SPOTANIM1) != 0) {
                @Pc(73) int id = buffer.g2_alt2();
                @Pc(77) int heightAndDelay = buffer.g4();
                if (id == 65535) {
                    id = -1;
                }
                @Pc(86) int data = buffer.g1();
                @Pc(90) int rotation = data & 0x7;
                @Pc(96) int wornSlot = data >> 3 & 0xF;
                if (wornSlot == 15) {
                    wornSlot = -1;
                }
                @Pc(117) boolean loop = (data >> 7 & 0x1) == 1;
                npc.setSpotAnim(1, rotation, loop, heightAndDelay, wornSlot, id);
            }

            if ((flags & FLAG_SPOTANIM0) != 0) {
                @Pc(73) int id = buffer.ig2();
                @Pc(77) int heightAndDelay = buffer.g4_alt3();
                if (id == 65535) {
                    id = -1;
                }
                @Pc(86) int data = buffer.g1_alt2();
                @Pc(90) int rotation = data & 0x7;
                @Pc(96) int wornSlot = data >> 3 & 0xF;
                if (wornSlot == 15) {
                    wornSlot = -1;
                }
                @Pc(117) boolean loop = (data >> 7 & 0x1) == 1;
                npc.setSpotAnim(0, rotation, loop, heightAndDelay, wornSlot, id);
            }

            if ((flags & FLAG_RECOL) != 0) {
                npc.recolHue = buffer.g1b_alt1();
                npc.recolSaturation = buffer.g1b_alt3();
                npc.recolLightness = buffer.g1b();
                npc.recolScale = (byte) buffer.g1_alt3();
                npc.recolStart = TimeUtils.clock + buffer.ig2();
                npc.recolEnd = TimeUtils.clock + buffer.g2();
            }
        }
    }

    private NPCList() {
        /* empty */
    }
}
