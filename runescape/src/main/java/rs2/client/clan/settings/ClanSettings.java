package rs2.client.clan.settings;

import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.LongNode;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.datastruct.key.StringNode;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base37;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.Quicksort;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hi")
public final class ClanSettings {

    @OriginalMember(owner = "client!el", name = "T", descriptor = "Z")
    public static final boolean debug = false;

    @OriginalMember(owner = "client!ea", name = "m", descriptor = "Lclient!hi;")
    public static ClanSettings affined;

    @OriginalMember(owner = "client!cr", name = "d", descriptor = "Lclient!hi;")
    public static ClanSettings listened;

    @OriginalMember(owner = "client!hi", name = "O", descriptor = "B")
    public byte coinshare;

    @OriginalMember(owner = "client!hi", name = "m", descriptor = "I")
    public int affinedCount;

    @OriginalMember(owner = "client!hi", name = "n", descriptor = "Lclient!av;")
    public IterableHashTable extraSettings;

    @OriginalMember(owner = "client!hi", name = "J", descriptor = "[I")
    public int[] affinedJoinRuneday;

    @OriginalMember(owner = "client!hi", name = "d", descriptor = "B")
    public byte rankLootShare;

    @OriginalMember(owner = "client!hi", name = "t", descriptor = "I")
    public int bannedCount;

    @OriginalMember(owner = "client!hi", name = "b", descriptor = "[Ljava/lang/String;")
    public String[] affinedDisplayNames;

    @OriginalMember(owner = "client!hi", name = "Q", descriptor = "Z")
    public boolean useDisplayNames;

    @OriginalMember(owner = "client!hi", name = "h", descriptor = "J")
    public long owner;

    @OriginalMember(owner = "client!hi", name = "i", descriptor = "B")
    public byte rankKick;

    @OriginalMember(owner = "client!hi", name = "D", descriptor = "Z")
    public boolean allowNonMembers;

    @OriginalMember(owner = "client!hi", name = "N", descriptor = "B")
    public byte rankTalk;

    @OriginalMember(owner = "client!hi", name = "z", descriptor = "[J")
    public long[] bannedUserHashes;

    @OriginalMember(owner = "client!hi", name = "s", descriptor = "[I")
    public int[] affinedExtraInfo;

    @OriginalMember(owner = "client!hi", name = "P", descriptor = "Z")
    public boolean useHashes;

    @OriginalMember(owner = "client!hi", name = "B", descriptor = "[J")
    public long[] affinedUserHashes;

    @OriginalMember(owner = "client!hi", name = "w", descriptor = "[Ljava/lang/String;")
    public String[] bannedDisplayNames;

    @OriginalMember(owner = "client!hi", name = "K", descriptor = "[B")
    public byte[] affinedRanks;

    @OriginalMember(owner = "client!hi", name = "V", descriptor = "[I")
    public int[] sortedAffinedSlots;

    @OriginalMember(owner = "client!hi", name = "X", descriptor = "I")
    public int replacementOwnerSlot = -1;

    @OriginalMember(owner = "client!hi", name = "u", descriptor = "I")
    public int updateNum = 0;

    @OriginalMember(owner = "client!hi", name = "R", descriptor = "I")
    public int creationDate = 0;

    @OriginalMember(owner = "client!hi", name = "j", descriptor = "Ljava/lang/String;")
    public String name = null;

    @OriginalMember(owner = "client!hi", name = "M", descriptor = "I")
    public int currentOwnerSlot = -1;

    @OriginalMember(owner = "client!hi", name = "<init>", descriptor = "(Lclient!ge;)V")
    public ClanSettings(@OriginalArg(0) Packet packet) {
        this.decode(packet);
    }

    @OriginalMember(owner = "client!hi", name = "<init>", descriptor = "()V")
    public ClanSettings() {
    }

    @OriginalMember(owner = "client!hi", name = "b", descriptor = "(IIIII)I")
    public int doSetMemberExtraInfo(@OriginalArg(0) int value, @OriginalArg(1) int member, @OriginalArg(2) int endBit, @OriginalArg(3) int startBit) {
        @Pc(15) int startMask = (0x1 << startBit) - 1;
        @Pc(31) int endMask = endBit == 31 ? -1 : (0x1 << endBit + 1) - 1;
        @Pc(35) int mask = startMask ^ endMask;
        @Pc(39) int valueShifted = value << startBit;
        @Pc(43) int newValue = valueShifted & mask;
        @Pc(48) int currentValue = this.affinedExtraInfo[member];

        if (newValue == (mask & currentValue)) {
            return -1;
        } else {
            currentValue &= ~mask;
            this.affinedExtraInfo[member] = currentValue | newValue;
            return member;
        }
    }

    @OriginalMember(owner = "client!hi", name = "b", descriptor = "(BI)V")
    public void expandMembers(@OriginalArg(1) int count) {
        if (this.useHashes) {
            if (this.affinedUserHashes == null) {
                this.affinedUserHashes = new long[count];
            } else {
                Arrays.copy(this.affinedUserHashes, 0, this.affinedUserHashes = new long[count], 0, this.affinedCount);
            }
        }

        if (this.useDisplayNames) {
            if (this.affinedDisplayNames == null) {
                this.affinedDisplayNames = new String[count];
            } else {
                Arrays.copy(this.affinedDisplayNames, 0, this.affinedDisplayNames = new String[count], 0, this.affinedCount);
            }
        }

        if (this.affinedRanks == null) {
            this.affinedRanks = new byte[count];
        } else {
            Arrays.copy(this.affinedRanks, 0, this.affinedRanks = new byte[count], 0, this.affinedCount);
        }

        if (this.affinedExtraInfo == null) {
            this.affinedExtraInfo = new int[count];
        } else {
            Arrays.copy(this.affinedExtraInfo, 0, this.affinedExtraInfo = new int[count], 0, this.affinedCount);
        }

        if (this.affinedJoinRuneday == null) {
            this.affinedJoinRuneday = new int[count];
        } else {
            Arrays.copy(this.affinedJoinRuneday, 0, this.affinedJoinRuneday = new int[count], 0, this.affinedCount);
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(ILjava/lang/String;JI)V")
    public void doAddMember(@OriginalArg(1) String displayName, @OriginalArg(2) long userHash, @OriginalArg(3) int joinRuneday) {
        if (displayName != null && displayName.length() == 0) {
            displayName = null;
        }
        if (this.useHashes != userHash > 0L) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.useHashes + " but userhash:" + userHash);
        } else if (this.useDisplayNames == (displayName == null)) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.useDisplayNames + " but displayname:" + displayName);
        } else {
            if (userHash > 0L && (this.affinedUserHashes == null || this.affinedCount >= this.affinedUserHashes.length) || displayName != null && (this.affinedDisplayNames == null || this.affinedDisplayNames.length <= this.affinedCount)) {
                this.expandMembers(this.affinedCount + 5);
            }
            if (this.affinedUserHashes != null) {
                this.affinedUserHashes[this.affinedCount] = userHash;
            }
            if (this.affinedDisplayNames != null) {
                this.affinedDisplayNames[this.affinedCount] = displayName;
            }
            if (this.currentOwnerSlot == -1) {
                this.currentOwnerSlot = this.affinedCount;
                this.affinedRanks[this.affinedCount] = 126;
            } else {
                this.affinedRanks[this.affinedCount] = 0;
            }
            this.affinedExtraInfo[this.affinedCount] = 0;
            this.affinedJoinRuneday[this.affinedCount] = joinRuneday;
            this.sortedAffinedSlots = null;
            this.affinedCount++;
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BI)Ljava/lang/Long;")
    public Long getExtraSettingLong(@OriginalArg(1) int arg0) {
        if (this.extraSettings == null) {
            return null;
        } else {
            @Pc(16) Node setting = this.extraSettings.get(arg0);
            return setting != null && setting instanceof LongNode ? Long.valueOf(((LongNode) setting).value) : null;
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(Ljava/lang/String;B)I")
    public int affinedSlot(@OriginalArg(0) String displayName) {
        if (displayName == null || displayName.length() == 0) {
            return -1;
        }
        for (@Pc(18) int i = 0; i < this.affinedCount; i++) {
            if (this.affinedDisplayNames[i].equals(displayName)) {
                return i;
            }
        }
        return -1;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(Ljava/lang/String;IZ)Z")
    public boolean doSetExtraSettingString(@OriginalArg(0) String value, @OriginalArg(1) int id) {
        if (value == null) {
            value = "";
        } else if (value.length() > 80) {
            value = value.substring(0, 80);
        }

        if (this.extraSettings == null) {
            this.extraSettings = new IterableHashTable(4);
        } else {
            @Pc(32) Node node = this.extraSettings.get(id);

            if (node != null) {
                if (node instanceof StringNode) {
                    @Pc(42) StringNode setting = (StringNode) node;
                    if (setting.value.equals(value)) {
                        return false;
                    }

                    setting.value = value;
                    return true;
                }

                node.unlink();
            }
        }

        this.extraSettings.put(id, new StringNode(value));
        return true;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(B)V")
    public void findOwnerSlot() {
        if (this.affinedCount == 0) {
            this.replacementOwnerSlot = -1;
            this.currentOwnerSlot = -1;
        } else {
            this.replacementOwnerSlot = -1;
            this.currentOwnerSlot = -1;

            @Pc(32) int slot = 0;
            @Pc(37) byte rank = this.affinedRanks[0];
            for (@Pc(39) int i = 1; i < this.affinedCount; i++) {
                if (rank < this.affinedRanks[i]) {
                    if (rank == 125) {
                        this.replacementOwnerSlot = slot;
                    }

                    slot = i;
                    rank = this.affinedRanks[i];
                } else if (this.replacementOwnerSlot == -1 && this.affinedRanks[i] == 125) {
                    this.replacementOwnerSlot = i;
                }
            }

            this.currentOwnerSlot = slot;
            if (this.currentOwnerSlot != -1) {
                this.affinedRanks[this.currentOwnerSlot] = 126;
            }
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(II)Ljava/lang/String;")
    public String getExtraSettingString(@OriginalArg(1) int id) {
        if (this.extraSettings == null) {
            return null;
        } else {
            @Pc(24) Node setting = this.extraSettings.get(id);
            return setting != null && setting instanceof StringNode ? ((StringNode) setting).value : null;
        }
    }

    @OriginalMember(owner = "client!hi", name = "b", descriptor = "(II)V")
    public void doDeleteMember(@OriginalArg(0) int pos) {
        if (pos < 0 || this.affinedCount <= pos) {
            throw new RuntimeException("Invalid pos in doDeleteMember - pos:" + pos + " memberCount:" + this.affinedCount);
        }

        this.affinedCount--;
        this.sortedAffinedSlots = null;

        if (this.affinedCount == 0) {
            this.affinedExtraInfo = null;
            this.affinedDisplayNames = null;
            this.affinedRanks = null;
            this.replacementOwnerSlot = -1;
            this.affinedUserHashes = null;
            this.affinedJoinRuneday = null;
            this.currentOwnerSlot = -1;
        } else {
            Arrays.copy(this.affinedRanks, pos + 1, this.affinedRanks, pos, this.affinedCount - pos);
            Arrays.copy(this.affinedExtraInfo, pos + 1, this.affinedExtraInfo, pos, this.affinedCount - pos);
            Arrays.copy(this.affinedJoinRuneday, pos + 1, this.affinedJoinRuneday, pos, this.affinedCount - pos);

            if (this.affinedUserHashes != null) {
                Arrays.copy(this.affinedUserHashes, pos + 1, this.affinedUserHashes, pos, this.affinedCount - pos);
            }
            if (this.affinedDisplayNames != null) {
                Arrays.copy(this.affinedDisplayNames, pos + 1, this.affinedDisplayNames, pos, this.affinedCount - pos);
            }
            if (this.currentOwnerSlot == pos || this.replacementOwnerSlot == pos) {
                this.findOwnerSlot();
            }
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(Ljava/lang/String;JI)V")
    public void doAddBanned(@OriginalArg(0) String displayName, @OriginalArg(1) long userHash) {
        if (displayName != null && displayName.length() == 0) {
            displayName = null;
        }

        if (userHash > 0L != this.useHashes) {
            throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.useHashes + " but userhash:" + userHash);
        } else if (this.useDisplayNames == (displayName == null)) {
            throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.useDisplayNames + " but displayname:" + displayName);
        } else {
            if (userHash > 0L && (this.bannedUserHashes == null || this.bannedUserHashes.length <= this.bannedCount) || displayName != null && (this.bannedDisplayNames == null || this.bannedCount >= this.bannedDisplayNames.length)) {
                this.expandBans(this.bannedCount + 5);
            }
            if (this.bannedUserHashes != null) {
                this.bannedUserHashes[this.bannedCount] = userHash;
            }
            if (this.bannedDisplayNames != null) {
                this.bannedDisplayNames[this.bannedCount] = displayName;
            }
            this.bannedCount++;
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(I)[I")
    public int[] sortedAffinedSlots() {
        if (this.sortedAffinedSlots == null) {
            @Pc(14) String[] affinedDisplayNames = new String[this.affinedCount];
            this.sortedAffinedSlots = new int[this.affinedCount];

            @Pc(21) int i = 0;
            while (i < this.affinedCount) {
                affinedDisplayNames[i] = this.affinedDisplayNames[i];
                this.sortedAffinedSlots[i] = i++;
            }

            Quicksort.sort(affinedDisplayNames, this.sortedAffinedSlots);
        }

        return this.sortedAffinedSlots;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BIJ)Z")
    public boolean doSetExtraSettingLong(@OriginalArg(1) int id, @OriginalArg(2) long value) {
        if (this.extraSettings == null) {
            this.extraSettings = new IterableHashTable(4);
        } else {
            @Pc(29) Node node = this.extraSettings.get(id);

            if (node != null) {
                if (node instanceof LongNode) {
                    @Pc(39) LongNode setting = (LongNode) node;
                    if (setting.value == value) {
                        return false;
                    }

                    setting.value = value;
                    return true;
                }

                node.unlink();
            }
        }

        this.extraSettings.put(id, new LongNode(value));
        return true;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BBI)I")
    public int doSetMemberRank(@OriginalArg(0) byte rank, @OriginalArg(2) int member) {
        if (rank == 126 || rank == 127) {
            return -1;
        } else if (this.currentOwnerSlot == member && (this.replacementOwnerSlot == -1 || this.affinedRanks[this.replacementOwnerSlot] < 125)) {
            return -1;
        } else if (rank == this.affinedRanks[member]) {
            return -1;
        } else {
            this.affinedRanks[member] = rank;
            this.findOwnerSlot();
            return member;
        }
    }

    @OriginalMember(owner = "client!hi", name = "c", descriptor = "(II)Ljava/lang/Integer;")
    public Integer getExtraSettingInt(@OriginalArg(0) int id) {
        if (this.extraSettings == null) {
            return null;
        } else {
            @Pc(24) Node node = this.extraSettings.get(id);
            return node != null && node instanceof IntNode ? Integer.valueOf(((IntNode) node).value) : null;
        }
    }

    @OriginalMember(owner = "client!hi", name = "b", descriptor = "(IB)V")
    public void doDeleteBanned(@OriginalArg(0) int pos) {
        this.bannedCount--;

        if (this.bannedCount == 0) {
            this.bannedDisplayNames = null;
            this.bannedUserHashes = null;
        } else {
            if (this.bannedUserHashes != null) {
                Arrays.copy(this.bannedUserHashes, pos + 1, this.bannedUserHashes, pos, this.bannedCount - pos);
            }
            if (this.bannedDisplayNames != null) {
                Arrays.copy(this.bannedDisplayNames, pos + 1, this.bannedDisplayNames, pos, this.bannedCount - pos);
            }
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(IB)V")
    public void expandBans(@OriginalArg(0) int count) {
        if (this.useHashes) {
            if (this.bannedUserHashes == null) {
                this.bannedUserHashes = new long[count];
            } else {
                Arrays.copy(this.bannedUserHashes, 0, this.bannedUserHashes = new long[count], 0, this.bannedCount);
            }
        }

        if (this.useDisplayNames) {
            if (this.bannedDisplayNames == null) {
                this.bannedDisplayNames = new String[count];
            } else {
                Arrays.copy(this.bannedDisplayNames, 0, this.bannedDisplayNames = new String[count], 0, this.bannedCount);
            }
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(IIIII)Z")
    public boolean doSetExtraSettingVarbit(@OriginalArg(3) int id, @OriginalArg(2) int value, @OriginalArg(1) int startBit, @OriginalArg(0) int endBit) {
        @Pc(9) int maskLo = (0x1 << startBit) - 1;
        @Pc(23) int maskHi = endBit == 31 ? -1 : (0x1 << endBit + 1) - 1;

        @Pc(35) int mask = maskLo ^ maskHi;
        @Pc(39) int maskShifted = value << startBit;
        @Pc(43) int newValue = maskShifted & mask;

        if (this.extraSettings != null) {
            @Pc(63) Node node = this.extraSettings.get(id);

            if (node != null) {
                if (node instanceof IntNode) {
                    @Pc(73) IntNode setting = (IntNode) node;
                    if ((mask & setting.value) == newValue) {
                        return false;
                    }

                    setting.value &= ~mask;
                    setting.value |= newValue;
                    return true;
                }

                node.unlink();
            }
        } else {
            this.extraSettings = new IterableHashTable(4);
        }

        this.extraSettings.put(id, new IntNode(newValue));
        return true;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(ILclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        @Pc(9) int version = packet.g1();
        if (version < 1 || version > 5) {
            throw new RuntimeException("Unsupported ClanSettings version: " + version);
        }

        @Pc(37) int flags = packet.g1();
        if ((flags & 0x2) != 0) {
            this.useDisplayNames = true;
        }
        if ((flags & 0x1) != 0) {
            this.useHashes = true;
        }

        if (!this.useDisplayNames) {
            this.affinedDisplayNames = null;
            this.bannedDisplayNames = null;
        }
        if (!this.useHashes) {
            this.bannedUserHashes = null;
            this.affinedUserHashes = null;
        }

        this.updateNum = packet.g4();
        this.creationDate = packet.g4();
        if (version <= 3 && this.creationDate != 0) {
            this.creationDate += 16912800;
        }

        this.affinedCount = packet.g2();
        this.bannedCount = packet.g1();
        this.name = packet.gjstr();
        if (version >= 4) {
            packet.g4(); // last namechange timestamp
        }

        this.allowNonMembers = packet.g1() == 1;
        this.rankTalk = packet.g1b();
        this.rankKick = packet.g1b();
        this.rankLootShare = packet.g1b();
        this.coinshare = packet.g1b();

        if (this.affinedCount > 0) {
            if (this.useHashes && (this.affinedUserHashes == null || this.affinedUserHashes.length < this.affinedCount)) {
                this.affinedUserHashes = new long[this.affinedCount];
            }
            if (this.useDisplayNames && (this.affinedDisplayNames == null || this.affinedCount > this.affinedDisplayNames.length)) {
                this.affinedDisplayNames = new String[this.affinedCount];
            }
            if (this.affinedRanks == null || this.affinedRanks.length < this.affinedCount) {
                this.affinedRanks = new byte[this.affinedCount];
            }
            if (this.affinedExtraInfo == null || this.affinedCount > this.affinedExtraInfo.length) {
                this.affinedExtraInfo = new int[this.affinedCount];
            }
            if (this.affinedJoinRuneday == null || this.affinedCount > this.affinedJoinRuneday.length) {
                this.affinedJoinRuneday = new int[this.affinedCount];
            }

            for (@Pc(282) int i = 0; i < this.affinedCount; i++) {
                if (this.useHashes) {
                    this.affinedUserHashes[i] = packet.g8();
                }

                if (this.useDisplayNames) {
                    this.affinedDisplayNames[i] = packet.fastgstr();
                }

                this.affinedRanks[i] = packet.g1b();

                if (version >= 2) {
                    this.affinedExtraInfo[i] = packet.g4();
                }

                if (version >= 5) {
                    this.affinedJoinRuneday[i] = packet.g2();
                } else {
                    this.affinedJoinRuneday[i] = 0;
                }
            }

            this.findOwnerSlot();
        }

        if (this.bannedCount > 0) {
            if (this.useHashes && (this.bannedUserHashes == null || this.bannedUserHashes.length < this.bannedCount)) {
                this.bannedUserHashes = new long[this.bannedCount];
            }
            if (this.useDisplayNames && (this.bannedDisplayNames == null || this.bannedDisplayNames.length < this.bannedCount)) {
                this.bannedDisplayNames = new String[this.bannedCount];
            }

            for (@Pc(282) int i = 0; i < this.bannedCount; i++) {
                if (this.useHashes) {
                    this.bannedUserHashes[i] = packet.g8();
                }

                if (this.useDisplayNames) {
                    this.bannedDisplayNames[i] = packet.fastgstr();
                }
            }
        }

        if (version >= 3) {
            @Pc(282) int count = packet.g2();

            if (count > 0) {
                this.extraSettings = new IterableHashTable(count >= 16 ? 16 : IntMath.nextPow2(count));

                while (count-- > 0) {
                    @Pc(493) int idAndType = packet.g4();
                    @Pc(497) int id = idAndType & 0x3FFFFFFF;
                    @Pc(501) int type = idAndType >>> 30;

                    if (type == 0) {
                        @Pc(510) int value = packet.g4();
                        this.extraSettings.put(id, new IntNode(value));
                    } else if (type == 1) {
                        @Pc(533) long value = packet.g8();
                        this.extraSettings.put(id, new LongNode(value));
                    } else if (type == 2) {
                        @Pc(556) String value = packet.gjstr();
                        this.extraSettings.put(id, new StringNode(value));
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BIII)Ljava/lang/Integer;")
    public Integer getExtraSettingVarbit(@OriginalArg(1) int id, @OriginalArg(2) int endBit, @OriginalArg(3) int startBit) {
        if (this.extraSettings == null) {
            return null;
        }

        @Pc(16) Node node = this.extraSettings.get(id);
        if (node != null && node instanceof IntNode) {
            @Pc(50) int mask = endBit == 31 ? -1 : ((0x1 << (endBit + 1)) - 1);
            return Integer.valueOf((((IntNode) node).value & mask) >>> startBit);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(IIII)I")
    public int getAffinedExtraInfo(@OriginalArg(0) int startBit, @OriginalArg(2) int endBit, @OriginalArg(3) int id) {
        @Pc(27) int mask = endBit == 31 ? -1 : (0x1 << endBit + 1) - 1;
        return (this.affinedExtraInfo[id] & mask) >>> startBit;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(III)Z")
    public boolean doSetExtraSettingInt(@OriginalArg(0) int value, @OriginalArg(1) int id) {
        if (this.extraSettings != null) {
            @Pc(35) Node node = this.extraSettings.get(id);

            if (node != null) {
                if (node instanceof IntNode) {
                    @Pc(45) IntNode setting = (IntNode) node;
                    if (setting.value == value) {
                        return false;
                    }

                    setting.value = value;
                    return true;
                }

                node.unlink();
            }
        } else {
            this.extraSettings = new IterableHashTable(4);
        }

        this.extraSettings.put(id, new IntNode(value));
        return true;
    }

    public String prettyPrint() {
        StringBuilder builder = new StringBuilder();

        builder.append("Clan Name: ").append(name)
            .append("\ncurrentOwnerSlot: ").append(currentOwnerSlot)
            .append(", replacementOwnerSlot: ").append(replacementOwnerSlot)
            .append("\nallowNonMembers: ").append(allowNonMembers)
            .append(", rankTalk: ").append(rankTalk)
            .append(", rankKick: ").append(rankKick)
            .append(",  rankLootShare: ").append(rankLootShare);

        builder.append("\nMembers:");


        for (int i = 0; i < affinedCount; ++i) {
            builder.append("\n")
                .append(affinedUserHashes != null ? Base37.decode(affinedUserHashes[i]) : "null")
                .append(" - ")
                .append(affinedDisplayNames[i])
                .append(" - rank:")
                .append(affinedRanks[i]);
        }

        builder.append("\nBanned:");

        for (int i = 0; i < bannedCount; ++i) {
            builder.append("\n")
                .append(bannedUserHashes != null ? Base37.decode(bannedUserHashes[i]) : "null")
                .append(" - ")
                .append(bannedDisplayNames[i]);
        }

        return builder.toString();
    }
}
