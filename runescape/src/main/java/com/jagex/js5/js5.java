package com.jagex.js5;

import com.jagex.core.compress.BzipDecompressor;
import com.jagex.core.compress.GzipDecompressor;
import com.jagex.core.constants.CompressionType;
import com.jagex.core.io.ByteArrayWrapper;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.Arrays;
import com.jagex.core.util.JagException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sb")
public final class js5 {

    @OriginalMember(owner = "client!pfa", name = "v", descriptor = "Z")
    public static final boolean REPORT_INVALID_IDS = false;

    @OriginalMember(owner = "client!kr", name = "g", descriptor = "Lclient!sb;")
    public static js5 ANIMS; // 0

    @OriginalMember(owner = "client!eha", name = "c", descriptor = "Lclient!sb;")
    public static js5 BASES; // 1

    @OriginalMember(owner = "client!ad", name = "b", descriptor = "Lclient!sb;")
    public static js5 CONFIG; // 2

    @OriginalMember(owner = "client!rha", name = "c", descriptor = "Lclient!sb;")
    public static js5 INTERFACES; // 3

    @OriginalMember(owner = "client!iq", name = "a", descriptor = "Lclient!sb;")
    public static js5 SYNTH_SOUNDS; // 4

    @OriginalMember(owner = "client!cu", name = "gb", descriptor = "Lclient!sb;")
    public static js5 MAPS; // 5

    @OriginalMember(owner = "client!mj", name = "u", descriptor = "Lclient!sb;")
    public static js5 MIDI_SONGS; // 6

    @OriginalMember(owner = "client!fs", name = "d", descriptor = "Lclient!sb;")
    public static js5 MODELS; // 7

    @OriginalMember(owner = "client!ws", name = "I", descriptor = "Lclient!sb;")
    public static js5 SPRITES; // 8

    @OriginalMember(owner = "client!qq", name = "g", descriptor = "Lclient!sb;")
    public static js5 TEXTURES; // 9

    @OriginalMember(owner = "client!oka", name = "l", descriptor = "Lclient!sb;")
    public static js5 BINARY; // 10

    @OriginalMember(owner = "client!kn", name = "g", descriptor = "Lclient!sb;")
    public static js5 MIDI_JINGLES; // 11

    @OriginalMember(owner = "client!bb", name = "d", descriptor = "Lclient!sb;")
    public static js5 CLIENTSCRIPTS; // 12

    @OriginalMember(owner = "client!wb", name = "Y", descriptor = "Lclient!sb;")
    public static js5 FONTMETRICS; // 13

    @OriginalMember(owner = "client!eka", name = "l", descriptor = "Lclient!sb;")
    public static js5 VORBIS; // 14

    @OriginalMember(owner = "client!mn", name = "b", descriptor = "Lclient!sb;")
    public static js5 js5_15; // TODO

    @OriginalMember(owner = "client!oia", name = "r", descriptor = "Lclient!sb;")
    public static js5 CONFIG_LOC; // 16

    @OriginalMember(owner = "client!ala", name = "b", descriptor = "Lclient!sb;")
    public static js5 CONFIG_ENUM; // 17

    @OriginalMember(owner = "client!kj", name = "a", descriptor = "Lclient!sb;")
    public static js5 CONFIG_NPC; // 18

    @OriginalMember(owner = "client!lv", name = "e", descriptor = "Lclient!sb;")
    public static js5 CONFIG_OBJ; // 19

    @OriginalMember(owner = "client!vca", name = "o", descriptor = "Lclient!sb;")
    public static js5 CONFIG_SEQ; // 20

    @OriginalMember(owner = "client!ij", name = "l", descriptor = "Lclient!sb;")
    public static js5 CONFIG_SPOT; // 21

    @OriginalMember(owner = "client!he", name = "k", descriptor = "Lclient!sb;")
    public static js5 CONFIG_STRUCT; // 22

    @OriginalMember(owner = "client!dn", name = "G", descriptor = "Lclient!sb;")
    public static js5 WORLDMAPDATA; // 23

    @OriginalMember(owner = "client!bu", name = "O", descriptor = "Lclient!sb;")
    public static js5 QUICKCHAT; // 24

    @OriginalMember(owner = "client!hk", name = "n", descriptor = "Lclient!sb;")
    public static js5 QUICKCHAT_GLOBAL; // 25

    @OriginalMember(owner = "client!gd", name = "H", descriptor = "Lclient!sb;")
    public static js5 MATERIALS; // 26

    @OriginalMember(owner = "client!co", name = "t", descriptor = "Lclient!sb;")
    public static js5 CONFIG_PARTICLE; // 27

    @OriginalMember(owner = "client!kka", name = "c", descriptor = "Lclient!sb;")
    public static js5 DEFAULTS; // 28

    @OriginalMember(owner = "client!ega", name = "p", descriptor = "Lclient!sb;")
    public static js5 CONFIG_BILLBOARD; // 29

    @OriginalMember(owner = "client!th", name = "n", descriptor = "Lclient!sb;")
    public static js5 DLLS; // 30

    @OriginalMember(owner = "client!ds", name = "k", descriptor = "Lclient!sb;")
    public static js5 SHADERS; // 31

    @OriginalMember(owner = "client!fia", name = "m", descriptor = "Lclient!sb;")
    public static js5 LOADING_SPRITES; // 32, 34

    @OriginalMember(owner = "client!qe", name = "b", descriptor = "Lclient!sb;")
    public static js5 LOADING_SCREENS; // 33

    @OriginalMember(owner = "client!pt", name = "s", descriptor = "Lclient!sb;")
    public static js5 CUTSCENES; // 35

    @OriginalMember(owner = "client!wh", name = "K", descriptor = "Lclient!sb;")
    public static js5 VIDEOS; // 36

    @OriginalMember(owner = "client!dj", name = "o", descriptor = "I")
    public static final int maxsize = 0;

    @OriginalMember(owner = "client!ska", name = "a", descriptor = "([BB)[B")
    public static byte[] decodeContainer(@OriginalArg(0) byte[] compressed) {
        @Pc(8) Packet packet = new Packet(compressed);
        @Pc(18) int ctype = packet.g1();
        @Pc(22) int clen = packet.g4();

        if ((clen < 0) || ((maxsize != 0) && (clen > maxsize))) {
            throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " maxsize=" + maxsize);
        } else if (ctype == CompressionType.NONE) {
            @Pc(98) byte[] decoded = new byte[clen];
            packet.gdata(0, clen, decoded);
            return decoded;
        } else {
            @Pc(44) int ulen = packet.g4();
            if ((ulen < 0) || ((maxsize != 0) && (ulen > maxsize))) {
                throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " ulen=" + ulen + " maxsize=" + maxsize);
            }

            @Pc(66) byte[] decoded = new byte[ulen];
            if (ctype == CompressionType.BZIP2) {
                BzipDecompressor.bunzip(decoded, ulen, compressed, clen);
            } else {
                @Pc(73) GzipDecompressor local73 = GzipDecompressor.INSTANCE;
                synchronized (GzipDecompressor.INSTANCE) {
                    GzipDecompressor.INSTANCE.gunzip(packet, decoded);
                }
            }

            return decoded;
        }
    }

    public static String whirlpoolToString(byte[] whirlpool) {
        StringBuffer buffer = new StringBuffer(whirlpool.length * 2 + 2);
        buffer.append("0x");

        byte[] bytes = whirlpool;
        int len = whirlpool.length;
        for (int i = 0; i < len; ++i) {
            byte b = bytes[i];

            if (b >= 0 && b < 16) {
                buffer.append("0" + StringTools.numberWithSign(b, 16, false));
            } else {
                buffer.append(StringTools.numberWithSign(b & 255, 16, false));
            }
        }

        return buffer.toString();
    }

    @OriginalMember(owner = "client!sb", name = "J", descriptor = "[Ljava/lang/Object;")
    public Object[] packed;

    @OriginalMember(owner = "client!sb", name = "K", descriptor = "[[Ljava/lang/Object;")
    public Object[][] unpacked;

    @OriginalMember(owner = "client!sb", name = "j", descriptor = "Lclient!pj;")
    public Js5Index index = null;

    @OriginalMember(owner = "client!sb", name = "H", descriptor = "Lclient!bm;")
    public final ResourceProvider provider;

    @OriginalMember(owner = "client!sb", name = "y", descriptor = "Z")
    public final boolean discardpacked;

    @OriginalMember(owner = "client!sb", name = "F", descriptor = "I")
    public int discardunpacked;

    @OriginalMember(owner = "client!sb", name = "<init>", descriptor = "(Lclient!bm;ZI)V")
    public js5(@OriginalArg(0) ResourceProvider provider, @OriginalArg(1) boolean discardpacked, @OriginalArg(2) int discardunpacked) {
        if (discardunpacked < 0 || discardunpacked > 2) {
            throw new IllegalArgumentException("js5: Invalid value " + discardunpacked + " supplied for discardunpacked");
        }

        this.provider = provider;
        this.discardpacked = discardpacked;
        this.discardunpacked = discardunpacked;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(ZBZ)V")
    public void clearNames(@OriginalArg(0) boolean groups, @OriginalArg(2) boolean files) {
        if (!this.indexReady()) {
            return;
        }
        if (groups) {
            this.index.groupNameTable = null;
            this.index.groupNames = null;
        }
        if (files) {
            this.index.fileNames = null;
            this.index.fileNameTables = null;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Z)I")
    public int indexCrc() {
        if (!this.indexReady()) {
            throw new IllegalStateException("Index not ready");
        }

        return this.index.crc;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;ZLjava/lang/String;)Z")
    public boolean fileExists(@OriginalArg(0) String groupName, @OriginalArg(2) String fileName) {
        if (!this.indexReady()) {
            return false;
        }

        @Pc(13) String groupNameLower = groupName.toLowerCase();
        @Pc(16) String fileNameLower = fileName.toLowerCase();
        @Pc(25) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
        if (groupId >= 0) {
            @Pc(41) int fileId = this.index.fileNameTables[groupId].find(StringTools.intHashCp1252(fileNameLower));
            return fileId >= 0;
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(BLjava/lang/String;)Z")
    public boolean fileready(@OriginalArg(1) String fileName) {
        @Pc(14) int groupId = this.getgroupid("");
        return groupId == -1 ? this.requestdownload(fileName, "") : this.requestdownload("", fileName);
    }

    @OriginalMember(owner = "client!sb", name = "e", descriptor = "(II)V")
    public void fetchGroup(@OriginalArg(0) int groupId) {
        if (this.discardpacked) {
            this.packed[groupId] = this.provider.fetchgroup(groupId);
        } else {
            this.packed[groupId] = ByteArrayWrapper.wrap(this.provider.fetchgroup(groupId));
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(ZI)I")
    public int completePercentage(@OriginalArg(1) int groupId) {
        if (this.isValidGroup(groupId)) {
            return this.packed[groupId] == null ? this.provider.completePercentage(groupId) : 100;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(IB)Z")
    public boolean fileready(@OriginalArg(0) int id) {
        if (!this.indexReady()) {
            return false;
        } else if (this.index.fileLimits.length == 1) {
            return this.requestdownload(id, 0);
        } else if (!this.isValidGroup(id)) {
            return false;
        } else if (this.index.fileLimits[id] == 1) {
            return this.requestdownload(0, id);
        } else {
            throw new RuntimeException("Unable to determine if id is groupid or fileid");
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(I)I")
    public int completePercentage() {
        if (!this.indexReady()) {
            return 0;
        }

        @Pc(18) int total = 0;
        @Pc(20) int percentage = 0;

        for (@Pc(22) int i = 0; i < this.packed.length; i++) {
            if (this.index.fileCounts[i] > 0) {
                total += 100;
                percentage += this.completePercentage(i);
            }
        }

        if (total == 0) {
            return 100;
        } else {
            return (percentage * 100) / total;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "([IIII)[B")
    public byte[] getfile(@OriginalArg(0) int[] key, @OriginalArg(1) int fileId, @OriginalArg(3) int groupId) {
        if (!this.isValidFile(fileId, groupId)) {
            return null;
        }

        if (this.unpacked[groupId] == null || this.unpacked[groupId][fileId] == null) {
            @Pc(33) boolean available = this.unpackFile(key, fileId, groupId);

            if (!available) {
                this.fetchGroup(groupId);

                available = this.unpackFile(key, fileId, groupId);
                if (!available) {
                    return null;
                }
            }
        }

        @Pc(61) byte[] data = ByteArrayWrapper.unwrap(false, this.unpacked[groupId][fileId]);

        if (this.discardunpacked == 1) {
            this.unpacked[groupId][fileId] = null;

            if (this.index.fileLimits[groupId] == 1) {
                this.unpacked[groupId] = null;
            }
        } else if (this.discardunpacked == 2) {
            this.unpacked[groupId] = null;
        }

        return data;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(IIB)Z")
    public boolean isValidFile(@OriginalArg(0) int fileId, @OriginalArg(1) int groupId) {
        if (!this.indexReady()) {
            return false;
        } else if (groupId >= 0 && fileId >= 0 && groupId < this.index.fileLimits.length && fileId < this.index.fileLimits[groupId]) {
            return true;
        } else if (REPORT_INVALID_IDS) {
            throw new IllegalArgumentException(groupId + "," + fileId);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(I[III)Z")
    public boolean unpackFile(@OriginalArg(1) int[] key, @OriginalArg(2) int fileId, @OriginalArg(3) int groupId) {
        if (!this.isValidGroup(groupId)) {
            return false;
        } else if (this.packed[groupId] == null) {
            return false;
        } else {
            @Pc(32) int count = this.index.fileCounts[groupId];
            @Pc(38) int[] ids = this.index.fileIds[groupId];

            if (this.unpacked[groupId] == null) {
                this.unpacked[groupId] = new Object[this.index.fileLimits[groupId]];
            }

            @Pc(60) Object[] groupData = this.unpacked[groupId];
            @Pc(62) boolean done = true;

            for (@Pc(64) int i = 0; i < count; i++) {
                @Pc(71) int id;
                if (ids == null) {
                    id = i;
                } else {
                    id = ids[i];
                }

                if (groupData[id] == null) {
                    done = false;
                    break;
                }
            }

            if (done) {
                return true;
            }

            @Pc(138) byte[] unpacked;
            if (key == null || key[0] == 0 && key[1] == 0 && key[2] == 0 && key[3] == 0) {
                unpacked = ByteArrayWrapper.unwrap(false, this.packed[groupId]);
            } else {
                unpacked = ByteArrayWrapper.unwrap(true, this.packed[groupId]);
                @Pc(152) Packet packet = new Packet(unpacked);
                packet.tinydec(key, packet.data.length);
            }

            @Pc(164) byte[] data;
            try {
                data = decodeContainer(unpacked);
            } catch (@Pc(166) RuntimeException exception) {
                throw JagException.wrap(exception, "T3 - " + (key != null) + "," + groupId + "," + unpacked.length + "," + Packet.getcrc(unpacked.length, unpacked) + "," + Packet.getcrc(unpacked.length - 2, unpacked) + "," + this.index.groupCrcs[groupId] + "," + this.index.crc);
            }

            if (this.discardpacked) {
                this.packed[groupId] = null;
            }

            if (count <= 1) {
                @Pc(243) int id;
                if (ids == null) {
                    id = 0;
                } else {
                    id = ids[0];
                }

                if (this.discardunpacked == 0) {
                    groupData[id] = ByteArrayWrapper.wrap(data);
                } else {
                    groupData[id] = data;
                }
            } else if (this.discardunpacked == 2) {
                @Pc(243) int pos = data.length;
                pos--;
                @Pc(279) int blocks = data[pos] & 0xFF;
                pos -= blocks * count * 4;
                @Pc(292) Packet packed = new Packet(data);
                @Pc(474) int size = 0;
                packed.pos = pos;
                @Pc(300) int target = 0;

                for (@Pc(303) int i = 0; i < blocks; i++) {
                    @Pc(305) int off = 0;
                    for (@Pc(363) int j = 0; j < count; j++) {
                        off += packed.g4();

                        @Pc(365) int id;
                        if (ids == null) {
                            id = j;
                        } else {
                            id = ids[j];
                        }

                        if (fileId == id) {
                            target = id;
                            size += off;
                        }
                    }
                }

                if (size == 0) {
                    return true;
                }

                @Pc(539) byte[] fileData = new byte[size];
                packed.pos = pos;
                size = 0;
                @Pc(363) int off = 0;

                for (@Pc(365) int i = 0; i < blocks; i++) {
                    @Pc(368) int len = 0;
                    for (@Pc(370) int j = 0; j < count; j++) {
                        len += packed.g4();

                        @Pc(566) int id;
                        if (ids == null) {
                            id = j;
                        } else {
                            id = ids[j];
                        }

                        if (id == fileId) {
                            Arrays.copy(data, off, fileData, size, len);
                            size += len;
                        }

                        off += len;
                    }
                }

                groupData[target] = fileData;
            } else {
                @Pc(243) int pos = data.length;
                pos--;
                @Pc(279) int blocks = data[pos] & 0xFF;
                pos -= blocks * count * 4;
                @Pc(292) Packet packet = new Packet(data);
                packet.pos = pos;

                @Pc(298) int[] sizes = new int[count];
                for (@Pc(300) int i = 0; i < blocks; i++) {
                    @Pc(303) int size = 0;
                    for (@Pc(305) int local305 = 0; local305 < count; local305++) {
                        size += packet.g4();
                        sizes[local305] += size;
                    }
                }

                @Pc(336) byte[][] files = new byte[count][];
                for (@Pc(305) int i = 0; i < count; i++) {
                    files[i] = new byte[sizes[i]];
                    sizes[i] = 0;
                }

                packet.pos = pos;
                @Pc(363) int off = 0;
                for (@Pc(365) int i = 0; i < blocks; i++) {
                    @Pc(368) int size = 0;
                    for (@Pc(370) int local370 = 0; local370 < count; local370++) {
                        size += packet.g4();
                        Arrays.copy(data, off, files[local370], sizes[local370], size);
                        sizes[local370] += size;
                        off += size;
                    }
                }

                for (@Pc(368) int i = 0; i < count; i++) {
                    @Pc(370) int id;
                    if (ids == null) {
                        id = i;
                    } else {
                        id = ids[i];
                    }

                    if (this.discardunpacked == 0) {
                        groupData[id] = ByteArrayWrapper.wrap(files[i]);
                    } else {
                        groupData[id] = files[i];
                    }
                }
            }

            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(III)Z")
    public boolean requestdownload(@OriginalArg(0) int fileId, @OriginalArg(1) int groupId) {
        if (!this.isValidFile(fileId, groupId)) {
            return false;
        } else if (this.unpacked[groupId] != null && this.unpacked[groupId][fileId] != null) {
            return true;
        } else if (this.packed[groupId] == null) {
            this.fetchGroup(groupId);
            return this.packed[groupId] != null;
        } else {
            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(Ljava/lang/String;I)Z")
    public boolean groupExists(@OriginalArg(0) String groupName) {
        if (this.indexReady()) {
            @Pc(21) String groupNameLower = groupName.toLowerCase();
            @Pc(30) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
            return groupId >= 0;
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(II)V")
    public void requestGroup(@OriginalArg(1) int groupId) {
        this.provider.requestGroup(groupId);
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(BI)[B")
    public byte[] getfile(@OriginalArg(1) int id) {
        if (!this.indexReady()) {
            return null;
        } else if (this.index.fileLimits.length == 1) {
            return this.getfile(id, 0);
        } else if (!this.isValidGroup(id)) {
            return null;
        } else if (this.index.fileLimits[id] == 1) {
            return this.getfile(0, id);
        } else {
            throw new RuntimeException("Unable to determine if id is groupid or fileid");
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;B)I")
    public int getgroupid(@OriginalArg(0) String groupName) {
        if (this.indexReady()) {
            @Pc(19) String groupNameLower = groupName.toLowerCase();
            @Pc(28) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
            return this.isValidGroup(groupId) ? groupId : -1;
        } else {
            return -1;
        }
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(B)Z")
    public boolean isComplete() {
        if (!this.indexReady()) {
            return false;
        }

        @Pc(24) boolean complete = true;

        for (@Pc(26) int i = 0; i < this.index.groupIds.length; i++) {
            @Pc(36) int groupId = this.index.groupIds[i];

            if (this.packed[groupId] == null) {
                this.fetchGroup(groupId);

                if (this.packed[groupId] == null) {
                    complete = false;
                }
            }
        }

        return complete;
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(B)V")
    public void discardUnpacked() {
        if (this.unpacked != null) {
            for (@Pc(4) int i = 0; i < this.unpacked.length; i++) {
                this.unpacked[i] = null;
            }
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(BLjava/lang/String;)I")
    public int completePercentage(@OriginalArg(1) String groupName) {
        if (this.indexReady()) {
            @Pc(24) String groupNameLower = groupName.toLowerCase();
            @Pc(33) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
            return this.completePercentage(groupId);
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(B)V")
    public void discardPacked() {
        if (this.packed != null) {
            for (@Pc(18) int i = 0; i < this.packed.length; i++) {
                this.packed[i] = null;
            }
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(ZII)[B")
    public byte[] getfile(@OriginalArg(1) int fileId, @OriginalArg(2) int groupId) {
        return this.getfile(null, fileId, groupId);
    }

    @OriginalMember(owner = "client!sb", name = "d", descriptor = "(BI)Z")
    public boolean isValidGroup(@OriginalArg(1) int groupId) {
        if (!this.indexReady()) {
            return false;
        } else if (groupId >= 0 && groupId < this.index.fileLimits.length && this.index.fileLimits[groupId] != 0) {
            return true;
        } else if (REPORT_INVALID_IDS) {
            throw new IllegalArgumentException(Integer.toString(groupId));
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(I)I")
    public int groupSize() {
        return this.indexReady() ? this.index.fileLimits.length : -1;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;I)Z")
    public boolean requestgroupdownload(@OriginalArg(0) String groupName) {
        if (this.indexReady()) {
            @Pc(13) String groupNameLower = groupName.toLowerCase();
            @Pc(22) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
            return this.requestgroupdownload(groupId);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(BI)I")
    public int getgroupid(@OriginalArg(1) int name) {
        if (this.indexReady()) {
            @Pc(17) int groupId = this.index.groupNameTable.find(name);
            return this.isValidGroup(groupId) ? groupId : -1;
        } else {
            return -1;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;I)[B")
    public byte[] getfile(@OriginalArg(0) String groupName, @OriginalArg(1) String fileName) {
        if (!this.indexReady()) {
            return null;
        }

        @Pc(13) String groupNameLower = groupName.toLowerCase();
        @Pc(16) String fileNameLower = fileName.toLowerCase();
        @Pc(25) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
        if (this.isValidGroup(groupId)) {
            @Pc(53) int local53 = this.index.fileNameTables[groupId].find(StringTools.intHashCp1252(fileNameLower));
            return this.getfile(local53, groupId);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(I)Z")
    public boolean indexReady() {
        if (this.index == null) {
            this.index = this.provider.index();
            if (this.index == null) {
                return false;
            }
            this.unpacked = new Object[this.index.groupLimit][];
            this.packed = new Object[this.index.groupLimit];
        }
        return true;
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(Ljava/lang/String;I)V")
    public void requestGroup(@OriginalArg(0) String groupName) {
        if (this.indexReady()) {
            @Pc(12) String local12 = groupName.toLowerCase();
            @Pc(29) int local29 = this.index.groupNameTable.find(StringTools.intHashCp1252(local12));
            this.requestGroup(local29);
        }
    }

    @OriginalMember(owner = "client!sb", name = "d", descriptor = "(II)[I")
    public int[] fileIds(@OriginalArg(0) int groupId) {
        if (!this.isValidGroup(groupId)) {
            return null;
        }

        @Pc(17) int[] fileIds = this.index.fileIds[groupId];
        if (fileIds == null) {
            fileIds = new int[this.index.fileCounts[groupId]];

            @Pc(28) int fileId = 0;
            while (fileId < fileIds.length) {
                fileIds[fileId] = fileId++;
            }
        }

        return fileIds;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(ZLjava/lang/String;Ljava/lang/String;)Z")
    public boolean requestdownload(@OriginalArg(1) String groupName, @OriginalArg(2) String fileName) {
        if (!this.indexReady()) {
            return false;
        }

        @Pc(13) String groupNameLower = groupName.toLowerCase();
        @Pc(16) String fileNameLower = fileName.toLowerCase();
        @Pc(25) int groupId = this.index.groupNameTable.find(StringTools.intHashCp1252(groupNameLower));
        if (this.isValidGroup(groupId)) {
            @Pc(44) int fileId = this.index.fileNameTables[groupId].find(StringTools.intHashCp1252(fileNameLower));
            return this.requestdownload(fileId, groupId);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(BI)V")
    public void discardUnpacked(@OriginalArg(1) int groupId) {
        if (this.isValidGroup(groupId) && this.unpacked != null) {
            this.unpacked[groupId] = null;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(II)Z")
    public boolean requestgroupdownload(@OriginalArg(1) int groupId) {
        if (!this.isValidGroup(groupId)) {
            return false;
        } else if (this.packed[groupId] == null) {
            this.fetchGroup(groupId);
            return this.packed[groupId] != null;
        } else {
            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(II)I")
    public int fileLimit(@OriginalArg(1) int groupId) {
        return this.isValidGroup(groupId) ? this.index.fileLimits[groupId] : 0;
    }
}
