import com.jagex.core.crypto.Whirlpool;
import com.jagex.core.io.Packet;
import com.jagex.js5.NameHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pj")
public final class Js5Index {

    @OriginalMember(owner = "client!pj", name = "s", descriptor = "[I")
    public int[] fileLimits;

    @OriginalMember(owner = "client!pj", name = "t", descriptor = "[I")
    public int[] groupNames;

    @OriginalMember(owner = "client!pj", name = "e", descriptor = "[Lclient!eha;")
    public NameHashTable[] fileNameTables;

    @OriginalMember(owner = "client!pj", name = "n", descriptor = "[[I")
    public int[][] fileIds;

    @OriginalMember(owner = "client!pj", name = "q", descriptor = "I")
    public int version;

    @OriginalMember(owner = "client!pj", name = "r", descriptor = "[I")
    public int[] groupVersions;

    @OriginalMember(owner = "client!pj", name = "k", descriptor = "I")
    public int groupCount;

    @OriginalMember(owner = "client!pj", name = "b", descriptor = "[I")
    public int[] fileCounts;

    @OriginalMember(owner = "client!pj", name = "o", descriptor = "I")
    public int groupLimit;

    @OriginalMember(owner = "client!pj", name = "g", descriptor = "[[B")
    public byte[][] groupHashes;

    @OriginalMember(owner = "client!pj", name = "h", descriptor = "[I")
    public int[] groupCrcs;

    @OriginalMember(owner = "client!pj", name = "u", descriptor = "[I")
    public int[] groupIds;

    @OriginalMember(owner = "client!pj", name = "c", descriptor = "Lclient!eha;")
    public NameHashTable aNameHashTable_1;

    @OriginalMember(owner = "client!pj", name = "l", descriptor = "[[I")
    public int[][] fileNames;

    @OriginalMember(owner = "client!pj", name = "j", descriptor = "I")
    public final int crc;

    @OriginalMember(owner = "client!pj", name = "d", descriptor = "[B")
    public byte[] whirlpool;

    @OriginalMember(owner = "client!pj", name = "<init>", descriptor = "([BI[B)V")
    public Js5Index(@OriginalArg(0) byte[] data, @OriginalArg(1) int expectedCrc, @OriginalArg(2) byte[] expectedWhirlpool) {
        this.crc = Packet.getcrc(data.length, data);

        if (expectedCrc != this.crc) {
            throw new RuntimeException("Invalid CRC - expected:" + expectedCrc + " got:" + crc);
        }

        if (expectedWhirlpool != null) {
            if (expectedWhirlpool.length != 64) {
                throw new RuntimeException("Invalid expectedwhirlpool - must be 64 bytes long");
            }

            this.whirlpool = Whirlpool.digest(data, data.length, 0);

            for (@Pc(45) int i = 0; i < 64; i++) {
                if (expectedWhirlpool[i] != this.whirlpool[i]) {
                    throw new RuntimeException("Invalid Whirlpool - expected:" + js5.whirlpoolToString(expectedWhirlpool) + " got:" + js5.whirlpoolToString(whirlpool));
                }
            }
        }

        this.loadIndex(data);
    }

    @OriginalMember(owner = "client!pj", name = "a", descriptor = "([BZ)V")
    public void loadIndex(@OriginalArg(0) byte[] data) {
        @Pc(12) Packet packet = new Packet(js5.decodeContainer(data));

        @Pc(16) int protocol = packet.g1();
        if (protocol < 5 || protocol > 7) {
            throw new RuntimeException("Incorrect JS5 protocol number: " + protocol);
        }

        if (protocol >= 6) {
            this.version = packet.g4();
        } else {
            this.version = 0;
        }

        @Pc(54) int flags = packet.g1();
        @Pc(63) boolean hasNames = (flags & 0x1) != 0;
        @Pc(75) boolean hasHashes = (flags & 0x2) != 0;

        if (protocol >= 7) {
            this.groupCount = packet.gSmart2or4();
        } else {
            this.groupCount = packet.g2();
        }

        @Pc(101) int id = 0;
        @Pc(103) int lastGroup = -1;

        this.groupIds = new int[this.groupCount];

        if (protocol >= 7) {
            for (@Pc(115) int i = 0; i < this.groupCount; i++) {
                this.groupIds[i] = id += packet.gSmart2or4();

                if (this.groupIds[i] > lastGroup) {
                    lastGroup = this.groupIds[i];
                }
            }
        } else {
            for (@Pc(115) int i = 0; i < this.groupCount; i++) {
                this.groupIds[i] = id += packet.g2();

                if (lastGroup < this.groupIds[i]) {
                    lastGroup = this.groupIds[i];
                }
            }
        }

        this.groupLimit = lastGroup + 1;
        this.groupCrcs = new int[this.groupLimit];
        if (hasHashes) {
            this.groupHashes = new byte[this.groupLimit][];
        }
        this.groupVersions = new int[this.groupLimit];

        this.fileLimits = new int[this.groupLimit];
        this.fileCounts = new int[this.groupLimit];
        this.fileIds = new int[this.groupLimit][];

        if (hasNames) {
            this.groupNames = new int[this.groupLimit];

            for (@Pc(115) int i = 0; i < this.groupLimit; i++) {
                this.groupNames[i] = -1;
            }

            for (@Pc(265) int i = 0; i < this.groupCount; i++) {
                this.groupNames[this.groupIds[i]] = packet.g4();
            }

            this.aNameHashTable_1 = new NameHashTable(this.groupNames);
        }

        for (@Pc(115) int i = 0; i < this.groupCount; i++) {
            this.groupCrcs[this.groupIds[i]] = packet.g4();
        }

        if (hasHashes) {
            for (@Pc(265) int i = 0; i < this.groupCount; i++) {
                @Pc(339) byte[] hash = new byte[64];
                packet.gdata(0, 64, hash);
                this.groupHashes[this.groupIds[i]] = hash;
            }
        }

        for (@Pc(265) int i = 0; i < this.groupCount; i++) {
            this.groupVersions[this.groupIds[i]] = packet.g4();
        }

        if (protocol < 7) {
            for (@Pc(398) int i = 0; i < this.groupCount; i++) {
                this.fileCounts[this.groupIds[i]] = packet.g2();
            }

            for (@Pc(423) int i = 0; i < this.groupCount; i++) {
                @Pc(432) int groupId = this.groupIds[i];
                id = 0;
                @Pc(439) int fileCount = this.fileCounts[groupId];
                @Pc(441) int lastFile = -1;

                this.fileIds[groupId] = new int[fileCount];

                for (@Pc(449) int j = 0; j < fileCount; j++) {
                    @Pc(466) int fileId = this.fileIds[groupId][j] = id += packet.g2();

                    if (fileId > lastFile) {
                        lastFile = fileId;
                    }
                }

                this.fileLimits[groupId] = lastFile + 1;

                if (fileCount == lastFile + 1) {
                    this.fileIds[groupId] = null;
                }
            }
        } else {
            for (@Pc(398) int i = 0; i < this.groupCount; i++) {
                this.fileCounts[this.groupIds[i]] = packet.gSmart2or4();
            }

            for (@Pc(423) int i = 0; i < this.groupCount; i++) {
                @Pc(432) int groupId = this.groupIds[i];
                @Pc(439) int fileCount = this.fileCounts[groupId];
                id = 0;
                @Pc(441) int lastFile = -1;

                this.fileIds[groupId] = new int[fileCount];

                for (@Pc(449) int j = 0; j < fileCount; j++) {
                    @Pc(441) int fileId = this.fileIds[groupId][j] = id += packet.gSmart2or4();

                    if (fileId > lastFile) {
                        lastFile = fileId;
                    }
                }

                this.fileLimits[groupId] = lastFile + 1;

                if (lastFile + 1 == fileCount) {
                    this.fileIds[groupId] = null;
                }
            }
        }

        if (hasNames) {
            this.fileNameTables = new NameHashTable[lastGroup + 1];
            this.fileNames = new int[lastGroup + 1][];

            for (@Pc(398) int i = 0; i < this.groupCount; i++) {
                @Pc(423) int groupId = this.groupIds[i];
                @Pc(432) int fileCount = this.fileCounts[groupId];

                this.fileNames[groupId] = new int[this.fileLimits[groupId]];

                for (@Pc(439) int j = 0; j < this.fileLimits[groupId]; j++) {
                    this.fileNames[groupId][j] = -1;
                }

                for (@Pc(441) int j = 0; j < fileCount; j++) {
                    @Pc(449) int fileId;

                    if (this.fileIds[groupId] == null) {
                        fileId = j;
                    } else {
                        fileId = this.fileIds[groupId][j];
                    }

                    this.fileNames[groupId][fileId] = packet.g4();
                }

                this.fileNameTables[groupId] = new NameHashTable(this.fileNames[groupId]);
            }
        }
    }
}
