package com.jagex.js5;

import com.jagex.core.compress.BzipDecompressor;
import com.jagex.core.compress.GzipDecompressor;
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

    @OriginalMember(owner = "client!jq", name = "g", descriptor = "Lclient!sb;")
    public static js5 MAGNETS;

    @OriginalMember(owner = "client!mt", name = "O", descriptor = "Lclient!sb;")
    public static js5 EMITTERS;

    @OriginalMember(owner = "client!kka", name = "c", descriptor = "Lclient!sb;")
    public static js5 DEFAULTS; // 28

    @OriginalMember(owner = "client!dj", name = "o", descriptor = "I")
    public static final int maxsize = 0;
    @OriginalMember(owner = "client!qa", name = "q", descriptor = "Lclient!sb;")
    public static js5 aJs5_96;
    @OriginalMember(owner = "client!iha", name = "c", descriptor = "Lclient!sb;")
    public static js5 aJs5_58;

    @OriginalMember(owner = "client!ska", name = "a", descriptor = "([BB)[B")
    public static byte[] decodeContainer(@OriginalArg(0) byte[] compressed) {
        @Pc(8) Packet packet = new Packet(compressed);
        @Pc(18) int ctype = packet.g1();
        @Pc(22) int clen = packet.g4();

        if ((clen < 0) || ((maxsize != 0) && (clen > maxsize))) {
            throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " maxsize=" + maxsize);
        } else if (ctype == 0) {
            @Pc(98) byte[] decoded = new byte[clen];
            packet.gdata(0, clen, decoded);
            return decoded;
        } else {
            @Pc(44) int ulen = packet.g4();
            if ((ulen < 0) || ((maxsize != 0) && (ulen > maxsize))) {
                throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " ulen=" + ulen + " maxsize=" + maxsize);
            }

            @Pc(66) byte[] decoded = new byte[ulen];
            if (ctype == 1) {
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
        for(int i = 0; i < len; ++i) {
            byte b = bytes[i];

            if(b >= 0 && b < 16) {
                buffer.append("0" + StringTools.parseIntWithSign(b, 16, false));
            } else {
                buffer.append(StringTools.parseIntWithSign(b & 255, 16, false));
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
            throw new IllegalArgumentException("com.jagex.js5.js5: Invalid value " + discardunpacked + " supplied for discardunpacked");
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
    public boolean method7577(@OriginalArg(0) String groupName, @OriginalArg(2) String fileName) {
        if (!this.indexReady()) {
            return false;
        }

        @Pc(13) String groupNameLower = groupName.toLowerCase();
        @Pc(16) String fileNameLower = fileName.toLowerCase();
        @Pc(25) int local25 = this.index.groupNameTable.find(StringTools.hash(groupNameLower));
        if (local25 < 0) {
            return false;
        } else {
            @Pc(41) int local41 = this.index.fileNameTables[local25].find(StringTools.hash(fileNameLower));
            return local41 >= 0;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(BLjava/lang/String;)Z")
    public boolean method7578(@OriginalArg(1) String arg0) {
        @Pc(14) int local14 = this.getgroupid("");
        return local14 == -1 ? this.method7604(arg0, "") : this.method7604("", arg0);
    }

    @OriginalMember(owner = "client!sb", name = "e", descriptor = "(II)V")
    public void fetchGroup(@OriginalArg(0) int group) {
        if (this.discardpacked) {
            this.packed[group] = this.provider.fetchgroup(group);
        } else {
            this.packed[group] = ByteArrayWrapper.wrap(this.provider.fetchgroup(group));
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
    public boolean method7581(@OriginalArg(0) int arg0) {
        if (!this.indexReady()) {
            return false;
        } else if (this.index.fileLimits.length == 1) {
            return this.method7586(arg0, 0);
        } else if (!this.isValidGroup(arg0)) {
            return false;
        } else if (this.index.fileLimits[arg0] == 1) {
            return this.method7586(0, arg0);
        } else {
            throw new RuntimeException();
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(I)I")
    public int method7582() {
        if (!this.indexReady()) {
            return 0;
        }
        @Pc(18) int local18 = 0;
        @Pc(20) int local20 = 0;
        for (@Pc(22) int local22 = 0; local22 < this.packed.length; local22++) {
            if (this.index.fileCounts[local22] > 0) {
                local18 += 100;
                local20 += this.completePercentage(local22);
            }
        }
        if (local18 == 0) {
            return 100;
        } else {
            return local20 * 100 / local18;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "([IIII)[B")
    public byte[] getfile(@OriginalArg(0) int[] key, @OriginalArg(1) int file, @OriginalArg(3) int group) {
        if (!this.isValidFile(file, group)) {
            return null;
        }

        if (this.unpacked[group] == null || this.unpacked[group][file] == null) {
            @Pc(33) boolean available = this.unpackFile(key, file, group);

            if (!available) {
                this.fetchGroup(group);

                available = this.unpackFile(key, file, group);
                if (!available) {
                    return null;
                }
            }
        }

        @Pc(61) byte[] data = ByteArrayWrapper.unwrap(false, this.unpacked[group][file]);

        if (this.discardunpacked == 1) {
            this.unpacked[group][file] = null;

            if (this.index.fileLimits[group] == 1) {
                this.unpacked[group] = null;
            }
        } else if (this.discardunpacked == 2) {
            this.unpacked[group] = null;
        }

        return data;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(IIB)Z")
    public boolean isValidFile(@OriginalArg(0) int file, @OriginalArg(1) int group) {
        if (!this.indexReady()) {
            return false;
        } else if (group >= 0 && file >= 0 && group < this.index.fileLimits.length && file < this.index.fileLimits[group]) {
            return true;
        } else if (REPORT_INVALID_IDS) {
            throw new IllegalArgumentException(group + "," + file);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(I[III)Z")
    public boolean unpackFile(@OriginalArg(1) int[] key, @OriginalArg(2) int file, @OriginalArg(3) int group) {
        if (!this.isValidGroup(group)) {
            return false;
        } else if (this.packed[group] == null) {
            return false;
        } else {
            @Pc(32) int count = this.index.fileCounts[group];
            @Pc(38) int[] ids = this.index.fileIds[group];

            if (this.unpacked[group] == null) {
                this.unpacked[group] = new Object[this.index.fileLimits[group]];
            }

            @Pc(60) Object[] groupData = this.unpacked[group];
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
                unpacked = ByteArrayWrapper.unwrap(false, this.packed[group]);
            } else {
                unpacked = ByteArrayWrapper.unwrap(true, this.packed[group]);
                @Pc(152) Packet packet = new Packet(unpacked);
                packet.tinyenc(key, packet.data.length);
            }

            @Pc(164) byte[] local164;
            try {
                local164 = decodeContainer(unpacked);
            } catch (@Pc(166) RuntimeException exception) {
                throw JagException.wrap(exception, "T3 - " + (key != null) + "," + group + "," + unpacked.length + "," + Packet.getcrc(unpacked.length, unpacked) + "," + Packet.getcrc(unpacked.length - 2, unpacked) + "," + this.index.groupCrcs[group] + "," + this.index.crc);
            }

            if (this.discardpacked) {
                this.packed[group] = null;
            }

            @Pc(243) int local243;
            if (count <= 1) {
                if (ids == null) {
                    local243 = 0;
                } else {
                    local243 = ids[0];
                }
                if (this.discardunpacked == 0) {
                    groupData[local243] = ByteArrayWrapper.wrap(local164);
                } else {
                    groupData[local243] = local164;
                }
            } else {
                @Pc(279) int local279;
                @Pc(292) Packet local292;
                @Pc(300) int local300;
                @Pc(303) int local303;
                @Pc(305) int local305;
                @Pc(363) int local363;
                @Pc(365) int local365;
                @Pc(368) int local368;
                @Pc(370) int local370;
                if (this.discardunpacked == 2) {
                    local243 = local164.length;
                    local243--;
                    local279 = local164[local243] & 0xFF;
                    local243 -= local279 * count * 4;
                    local292 = new Packet(local164);
                    @Pc(474) int local474 = 0;
                    local292.pos = local243;
                    local300 = 0;
                    for (local303 = 0; local303 < local279; local303++) {
                        local305 = 0;
                        for (local363 = 0; local363 < count; local363++) {
                            local305 += local292.g4();
                            if (ids == null) {
                                local365 = local363;
                            } else {
                                local365 = ids[local363];
                            }
                            if (file == local365) {
                                local300 = local365;
                                local474 += local305;
                            }
                        }
                    }
                    if (local474 == 0) {
                        return true;
                    }
                    @Pc(539) byte[] local539 = new byte[local474];
                    local292.pos = local243;
                    local474 = 0;
                    local363 = 0;
                    for (local365 = 0; local365 < local279; local365++) {
                        local368 = 0;
                        for (local370 = 0; local370 < count; local370++) {
                            local368 += local292.g4();
                            @Pc(566) int local566;
                            if (ids == null) {
                                local566 = local370;
                            } else {
                                local566 = ids[local370];
                            }
                            if (local566 == file) {
                                Arrays.copy(local164, local363, local539, local474, local368);
                                local474 += local368;
                            }
                            local363 += local368;
                        }
                    }
                    groupData[local300] = local539;
                } else {
                    local243 = local164.length;
                    local243--;
                    local279 = local164[local243] & 0xFF;
                    local243 -= local279 * count * 4;
                    local292 = new Packet(local164);
                    local292.pos = local243;
                    @Pc(298) int[] local298 = new int[count];
                    for (local300 = 0; local300 < local279; local300++) {
                        local303 = 0;
                        for (local305 = 0; local305 < count; local305++) {
                            local303 += local292.g4();
                            local298[local305] += local303;
                        }
                    }
                    @Pc(336) byte[][] local336 = new byte[count][];
                    for (local305 = 0; local305 < count; local305++) {
                        local336[local305] = new byte[local298[local305]];
                        local298[local305] = 0;
                    }
                    local292.pos = local243;
                    local363 = 0;
                    for (local365 = 0; local365 < local279; local365++) {
                        local368 = 0;
                        for (local370 = 0; local370 < count; local370++) {
                            local368 += local292.g4();
                            Arrays.copy(local164, local363, local336[local370], local298[local370], local368);
                            local298[local370] += local368;
                            local363 += local368;
                        }
                    }
                    for (local368 = 0; local368 < count; local368++) {
                        if (ids == null) {
                            local370 = local368;
                        } else {
                            local370 = ids[local368];
                        }
                        if (this.discardunpacked == 0) {
                            groupData[local370] = ByteArrayWrapper.wrap(local336[local368]);
                        } else {
                            groupData[local370] = local336[local368];
                        }
                    }
                }
            }
            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(III)Z")
    public boolean method7586(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (!this.isValidFile(arg0, arg1)) {
            return false;
        } else if (this.unpacked[arg1] != null && this.unpacked[arg1][arg0] != null) {
            return true;
        } else if (this.packed[arg1] == null) {
            this.fetchGroup(arg1);
            return this.packed[arg1] != null;
        } else {
            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(Ljava/lang/String;I)Z")
    public boolean groupExists(@OriginalArg(0) String groupName) {
        if (this.indexReady()) {
            @Pc(21) String groupNameLower = groupName.toLowerCase();
            @Pc(30) int groupId = this.index.groupNameTable.find(StringTools.hash(groupNameLower));
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
            @Pc(28) int groupId = this.index.groupNameTable.find(StringTools.hash(groupNameLower));
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

        for (@Pc(26) int groupId = 0; groupId < this.index.groupIds.length; groupId++) {
            @Pc(36) int group = this.index.groupIds[groupId];

            if (this.packed[group] == null) {
                this.fetchGroup(group);

                if (this.packed[group] == null) {
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
            @Pc(33) int groupId = this.index.groupNameTable.find(StringTools.hash(groupNameLower));
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
    public byte[] getfile(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return this.getfile(null, arg0, arg1);
    }

    @OriginalMember(owner = "client!sb", name = "d", descriptor = "(BI)Z")
    public boolean isValidGroup(@OriginalArg(1) int group) {
        if (!this.indexReady()) {
            return false;
        } else if (group >= 0 && group < this.index.fileLimits.length && this.index.fileLimits[group] != 0) {
            return true;
        } else if (REPORT_INVALID_IDS) {
            throw new IllegalArgumentException(Integer.toString(group));
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(I)I")
    public int groupSize() {
        return this.indexReady() ? this.index.fileLimits.length : -1;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;I)Z")
    public boolean method7598(@OriginalArg(0) String arg0) {
        if (this.indexReady()) {
            @Pc(13) String local13 = arg0.toLowerCase();
            @Pc(22) int local22 = this.index.groupNameTable.find(StringTools.hash(local13));
            return this.method7607(local22);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(BI)I")
    public int method7599(@OriginalArg(1) int arg0) {
        if (this.indexReady()) {
            @Pc(17) int local17 = this.index.groupNameTable.find(arg0);
            return this.isValidGroup(local17) ? local17 : -1;
        } else {
            return -1;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;I)[B")
    public byte[] method7600(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
        if (!this.indexReady()) {
            return null;
        }
        @Pc(13) String local13 = arg0.toLowerCase();
        @Pc(16) String local16 = arg1.toLowerCase();
        @Pc(25) int local25 = this.index.groupNameTable.find(StringTools.hash(local13));
        if (this.isValidGroup(local25)) {
            @Pc(53) int local53 = this.index.fileNameTables[local25].find(StringTools.hash(local16));
            return this.getfile(local53, local25);
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
    public void method7602(@OriginalArg(0) String arg0) {
        if (this.indexReady()) {
            @Pc(12) String local12 = arg0.toLowerCase();
            @Pc(29) int local29 = this.index.groupNameTable.find(StringTools.hash(local12));
            this.requestGroup(local29);
        }
    }

    @OriginalMember(owner = "client!sb", name = "d", descriptor = "(II)[I")
    public int[] method7603(@OriginalArg(0) int arg0) {
        if (!this.isValidGroup(arg0)) {
            return null;
        }
        @Pc(17) int[] local17 = this.index.fileIds[arg0];
        if (local17 == null) {
            local17 = new int[this.index.fileCounts[arg0]];
            @Pc(28) int local28 = 0;
            while (local28 < local17.length) {
                local17[local28] = local28++;
            }
        }
        return local17;
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(ZLjava/lang/String;Ljava/lang/String;)Z")
    public boolean method7604(@OriginalArg(1) String arg0, @OriginalArg(2) String arg1) {
        if (!this.indexReady()) {
            return false;
        }
        @Pc(13) String local13 = arg0.toLowerCase();
        @Pc(16) String local16 = arg1.toLowerCase();
        @Pc(25) int local25 = this.index.groupNameTable.find(StringTools.hash(local13));
        if (this.isValidGroup(local25)) {
            @Pc(44) int local44 = this.index.fileNameTables[local25].find(StringTools.hash(local16));
            return this.method7586(local44, local25);
        } else {
            return false;
        }
    }

    @OriginalMember(owner = "client!sb", name = "c", descriptor = "(BI)V")
    public void method7605(@OriginalArg(1) int arg0) {
        if (this.isValidGroup(arg0) && this.unpacked != null) {
            this.unpacked[arg0] = null;
        }
    }

    @OriginalMember(owner = "client!sb", name = "b", descriptor = "(II)Z")
    public boolean method7607(@OriginalArg(1) int arg0) {
        if (!this.isValidGroup(arg0)) {
            return false;
        } else if (this.packed[arg0] == null) {
            this.fetchGroup(arg0);
            return this.packed[arg0] != null;
        } else {
            return true;
        }
    }

    @OriginalMember(owner = "client!sb", name = "a", descriptor = "(II)I")
    public int fileLimit(@OriginalArg(1) int arg0) {
        return this.isValidGroup(arg0) ? this.index.fileLimits[arg0] : 0;
    }
}
