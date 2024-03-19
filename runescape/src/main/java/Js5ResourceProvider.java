import com.jagex.collect.Deque;
import com.jagex.collect.HashTable;
import com.jagex.collect.Node;
import com.jagex.core.crypto.Whirlpool;
import com.jagex.core.util.SystemTimer;
import com.jagex.js5.*;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pm")
public final class Js5ResourceProvider extends ResourceProvider {

    private static final int FETCHGROUP_MODE_URGENT = 0;
    private static final int FETCHGROUP_MODE_VERIFY = 1;
    private static final int FETCHGROUP_MODE_PREFETCH = 2;

    @OriginalMember(owner = "client!pm", name = "t", descriptor = "[B")
    public byte[] groupStates;

    @OriginalMember(owner = "client!pm", name = "i", descriptor = "Lclient!pj;")
    public Js5Index index;

    @OriginalMember(owner = "client!pm", name = "M", descriptor = "Z")
    public boolean requestMissing;

    @OriginalMember(owner = "client!pm", name = "g", descriptor = "I")
    public int anInt7473 = 0;

    @OriginalMember(owner = "client!pm", name = "A", descriptor = "Lclient!av;")
    public final HashTable waiting = new HashTable(16);

    @OriginalMember(owner = "client!pm", name = "h", descriptor = "I")
    public int currentGroup = 0;

    @OriginalMember(owner = "client!pm", name = "F", descriptor = "Lclient!sia;")
    public final Deque groupRequests = new Deque();

    @OriginalMember(owner = "client!pm", name = "m", descriptor = "J")
    public long aLong239 = 0L;

    @OriginalMember(owner = "client!pm", name = "j", descriptor = "I")
    public final int archiveId;

    @OriginalMember(owner = "client!pm", name = "E", descriptor = "Lclient!af;")
    public final FileSystem_Client datafs;

    @OriginalMember(owner = "client!pm", name = "n", descriptor = "Z")
    public boolean verifyLocal;

    @OriginalMember(owner = "client!pm", name = "v", descriptor = "Lclient!sia;")
    public Deque passives;

    @OriginalMember(owner = "client!pm", name = "x", descriptor = "Z")
    public final boolean aBoolean569;

    @OriginalMember(owner = "client!pm", name = "K", descriptor = "Lclient!pla;")
    public final Js5WorkerThread netWorker;

    @OriginalMember(owner = "client!pm", name = "s", descriptor = "I")
    public final int anInt7463;

    @OriginalMember(owner = "client!pm", name = "D", descriptor = "I")
    public final int anInt7472;

    @OriginalMember(owner = "client!pm", name = "H", descriptor = "Lclient!iba;")
    public final CachedResourceWorker cacheWorker;

    @OriginalMember(owner = "client!pm", name = "O", descriptor = "[B")
    public final byte[] aByteArray89;

    @OriginalMember(owner = "client!pm", name = "B", descriptor = "Lclient!af;")
    public final FileSystem_Client indexStore;

    @OriginalMember(owner = "client!pm", name = "C", descriptor = "Lclient!tw;")
    public ResourceRequest indexRequest;

    @OriginalMember(owner = "client!pm", name = "<init>", descriptor = "(ILclient!af;Lclient!af;Lclient!pla;Lclient!iba;I[BIZ)V")
    public Js5ResourceProvider(@OriginalArg(0) int archiveId, @OriginalArg(1) FileSystem_Client datafs, @OriginalArg(2) FileSystem_Client indexStore, @OriginalArg(3) Js5WorkerThread arg3, @OriginalArg(4) CachedResourceWorker cacheWorker, @OriginalArg(5) int arg5, @OriginalArg(6) byte[] arg6, @OriginalArg(7) int arg7, @OriginalArg(8) boolean arg8) {
        this.archiveId = archiveId;
        this.datafs = datafs;
        if (this.datafs == null) {
            this.verifyLocal = false;
        } else {
            this.verifyLocal = true;
            this.passives = new Deque();
        }
        this.aBoolean569 = arg8;
        this.netWorker = arg3;
        this.anInt7463 = arg5;
        this.anInt7472 = arg7;
        this.cacheWorker = cacheWorker;
        this.aByteArray89 = arg6;
        this.indexStore = indexStore;
        if (this.indexStore != null) {
            this.indexRequest = this.cacheWorker.readUrgent(this.indexStore, this.archiveId);
        }
    }

    @OriginalMember(owner = "client!pm", name = "c", descriptor = "(I)I")
    public int indexPercentage() {
        if (this.index() == null) {
            return this.indexRequest == null ? 0 : this.indexRequest.completePercentage();
        } else {
            return 100;
        }
    }

    @OriginalMember(owner = "client!pm", name = "f", descriptor = "(I)I")
    public int entryCount() {
        return this.index == null ? 0 : this.index.groupCount;
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(II)V")
    @Override
    public void requestGroup(@OriginalArg(1) int groupId) {
        if (this.datafs == null) {
            return;
        }

        for (@Pc(23) Node existing = this.groupRequests.first(); existing != null; existing = this.groupRequests.next()) {
            if (existing.key == (long) groupId) {
                return;
            }
        }

        @Pc(50) Node request = new Node();
        request.key = (long) groupId;
        this.groupRequests.addLast(request);
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(I)I")
    public int extrasCount() {
        if (this.index == null) {
            return 0;
        } else if (this.verifyLocal) {
            @Pc(29) Node node = this.passives.first();
            return node == null ? 0 : (int) node.key;
        } else {
            return this.index.groupCount;
        }
    }

    @OriginalMember(owner = "client!pm", name = "d", descriptor = "(I)V")
    public void processExtras() {
        if (this.passives != null) {
            if (this.index() == null) {
                return;
            }

            if (this.verifyLocal) {
                @Pc(33) boolean done = true;

                for (@Pc(38) Node passive = this.passives.first(); passive != null; passive = this.passives.next()) {
                    @Pc(44) int group = (int) passive.key;

                    if (this.groupStates[group] == 0) {
                        this.fetchgroup_inner(group, FETCHGROUP_MODE_VERIFY);
                    }

                    if (this.groupStates[group] == 0) {
                        done = false;
                    } else {
                        passive.remove();
                    }
                }

                while (this.index.fileCounts.length > this.currentGroup) {
                    if (this.index.fileCounts[this.currentGroup] == 0) {
                        this.currentGroup++;
                    } else {
                        if (this.cacheWorker.remaining >= 250) {
                            done = false;
                            break;
                        }

                        if (this.groupStates[this.currentGroup] == 0) {
                            this.fetchgroup_inner(this.currentGroup, FETCHGROUP_MODE_VERIFY);
                        }

                        if (this.groupStates[this.currentGroup] == 0) {
                            @Pc(147) Node passive = new Node();
                            passive.key = (long) this.currentGroup;
                            done = false;
                            this.passives.addLast(passive);
                        }

                        this.currentGroup++;
                    }
                }

                if (done) {
                    this.currentGroup = 0;
                    this.verifyLocal = false;
                }
            } else if (this.requestMissing) {
                @Pc(33) boolean done = true;

                for (@Pc(38) Node passive = this.passives.first(); passive != null; passive = this.passives.next()) {
                    @Pc(44) int group = (int) passive.key;

                    if (this.groupStates[group] != 1) {
                        this.fetchgroup_inner(group, FETCHGROUP_MODE_PREFETCH);
                    }

                    if (this.groupStates[group] == 1) {
                        passive.remove();
                    } else {
                        done = false;
                    }
                }

                while (this.index.fileCounts.length > this.currentGroup) {
                    if (this.index.fileCounts[this.currentGroup] == 0) {
                        this.currentGroup++;
                    } else {
                        if (this.netWorker.isPrefetchFull()) {
                            done = false;
                            break;
                        }

                        if (this.groupStates[this.currentGroup] != 1) {
                            this.fetchgroup_inner(this.currentGroup, 2);
                        }

                        if (this.groupStates[this.currentGroup] != 1) {
                            @Pc(147) Node local147 = new Node();
                            local147.key = (long) this.currentGroup;
                            this.passives.addLast(local147);
                            done = false;
                        }
                        this.currentGroup++;
                    }
                }
                if (done) {
                    this.currentGroup = 0;
                    this.requestMissing = false;
                }
            } else {
                this.passives = null;
            }
        }
        if (!this.aBoolean569 || SystemTimer.safetime() < this.aLong239) {
            return;
        }
        for (@Pc(366) ResourceRequest local366 = (ResourceRequest) this.waiting.first(); local366 != null; local366 = (ResourceRequest) this.waiting.next()) {
            if (!local366.incomplete) {
                if (local366.orphan) {
                    if (!local366.urgent) {
                        throw new RuntimeException();
                    }
                    local366.remove();
                } else {
                    local366.orphan = true;
                }
            }
        }
        this.aLong239 = SystemTimer.safetime() + 1000L;
    }

    @OriginalMember(owner = "client!pm", name = "d", descriptor = "(B)I")
    public int method6649() {
        return this.anInt7473;
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(IB)[B")
    @Override
    public byte[] fetchgroup(@OriginalArg(0) int groupId) {
        @Pc(9) ResourceRequest local9 = this.fetchgroup_inner(groupId, 0);
        if (local9 == null) {
            return null;
        } else {
            @Pc(26) byte[] local26 = local9.getData();
            local9.remove();
            return local26;
        }
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(III)Lclient!tw;")
    public ResourceRequest fetchgroup_inner(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(19) ResourceRequest local19 = (ResourceRequest) this.waiting.get((long) arg0);
        if (local19 != null && arg1 == 0 && !local19.urgent && local19.incomplete) {
            local19.remove();
            local19 = null;
        }
        if (local19 == null) {
            if (arg1 == 0) {
                if (this.datafs == null || this.groupStates[arg0] == -1) {
                    if (this.netWorker.isUrgentFull()) {
                        return null;
                    }
                    local19 = this.netWorker.requestIndex(this.archiveId, arg0, true, (byte) 2);
                } else {
                    local19 = this.cacheWorker.readUrgent(this.datafs, arg0);
                }
            } else if (arg1 == 1) {
                if (this.datafs == null) {
                    throw new RuntimeException();
                }
                local19 = this.cacheWorker.verify(this.datafs, arg0);
            } else if (arg1 == 2) {
                if (this.datafs == null) {
                    throw new RuntimeException();
                }
                if (this.groupStates[arg0] != -1) {
                    throw new RuntimeException();
                }
                if (this.netWorker.isPrefetchFull()) {
                    return null;
                }
                local19 = this.netWorker.requestIndex(this.archiveId, arg0, false, (byte) 2);
            } else {
                throw new RuntimeException();
            }
            this.waiting.put((long) arg0, local19);
        }
        if (local19.incomplete) {
            return null;
        }
        @Pc(194) byte[] local194 = local19.getData();
        @Pc(224) int local224;
        @Pc(254) byte[] local254;
        @Pc(263) byte[] local263;
        @Pc(265) int local265;
        @Pc(383) Js5WorkerRequestMessage local383;
        if (!(local19 instanceof Js5ResourceRequest)) {
            try {
                label157:
                {
                    if (local194 != null && local194.length > 2) {
                        Static10.aCRC32_1.reset();
                        Static10.aCRC32_1.update(local194, 0, local194.length - 2);
                        local224 = (int) Static10.aCRC32_1.getValue();
                        if (this.index.groupCrcs[arg0] != local224) {
                            throw new RuntimeException();
                        }
                        if (this.index.groupHashes == null || this.index.groupHashes[arg0] == null) {
                            break label157;
                        }
                        local254 = this.index.groupHashes[arg0];
                        local263 = Whirlpool.digest(local194, local194.length - 2, 0);
                        local265 = 0;
                        while (true) {
                            if (local265 >= 64) {
                                break label157;
                            }
                            if (local254[local265] != local263[local265]) {
                                throw new RuntimeException();
                            }
                            local265++;
                        }
                    }
                    throw new RuntimeException();
                }
                this.netWorker.errors = 0;
                this.netWorker.response = 0;
            } catch (@Pc(498) RuntimeException local498) {
                this.netWorker.reset();
                local19.remove();
                if (local19.urgent && !this.netWorker.isUrgentFull()) {
                    local383 = this.netWorker.requestIndex(this.archiveId, arg0, true, (byte) 2);
                    this.waiting.put((long) arg0, local383);
                }
                return null;
            }
            local194[local194.length - 2] = (byte) (this.index.groupVersions[arg0] >>> 8);
            local194[local194.length - 1] = (byte) this.index.groupVersions[arg0];
            if (this.datafs != null) {
                this.cacheWorker.write(local194, arg0, this.datafs);
                if (this.groupStates[arg0] != 1) {
                    this.anInt7473++;
                    this.groupStates[arg0] = 1;
                }
            }
            if (!local19.urgent) {
                local19.remove();
            }
            return local19;
        }
        try {
            if (local194 == null || local194.length <= 2) {
                throw new RuntimeException();
            }
            Static10.aCRC32_1.reset();
            Static10.aCRC32_1.update(local194, 0, local194.length - 2);
            local224 = (int) Static10.aCRC32_1.getValue();
            if (local224 != this.index.groupCrcs[arg0]) {
                throw new RuntimeException();
            }
            if (this.index.groupHashes != null && this.index.groupHashes[arg0] != null) {
                local254 = this.index.groupHashes[arg0];
                local263 = Whirlpool.digest(local194, local194.length - 2, 0);
                for (local265 = 0; local265 < 64; local265++) {
                    if (local263[local265] != local254[local265]) {
                        throw new RuntimeException();
                    }
                }
            }
            @Pc(307) int local307 = (local194[local194.length - 1] & 0xFF) + ((local194[local194.length - 2] & 0xFF) << 8);
            if (local307 != (this.index.groupVersions[arg0] & 0xFFFF)) {
                throw new RuntimeException();
            }
            if (this.groupStates[arg0] != 1) {
                this.anInt7473++;
                this.groupStates[arg0] = 1;
            }
            if (!local19.urgent) {
                local19.remove();
            }
            return local19;
        } catch (@Pc(355) Exception local355) {
            this.groupStates[arg0] = -1;
            local19.remove();
            if (local19.urgent && !this.netWorker.isUrgentFull()) {
                local383 = this.netWorker.requestIndex(this.archiveId, arg0, true, (byte) 2);
                this.waiting.put((long) arg0, local383);
            }
            return null;
        }
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(BI)I")
    @Override
    public int completePercentage(@OriginalArg(1) int groupId) {
        @Pc(19) ResourceRequest local19 = (ResourceRequest) this.waiting.get((long) groupId);
        return local19 == null ? 0 : local19.completePercentage();
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(Z)V")
    public void method6653() {
        if (this.passives == null || this.index() == null) {
            return;
        }
        for (@Pc(21) Node local21 = this.groupRequests.first(); local21 != null; local21 = this.groupRequests.next()) {
            @Pc(29) int local29 = (int) local21.key;
            if (local29 < 0 || local29 >= this.index.groupLimit || this.index.fileCounts[local29] == 0) {
                local21.remove();
            } else {
                if (this.groupStates[local29] == 0) {
                    this.fetchgroup_inner(local29, 1);
                }
                if (this.groupStates[local29] == -1) {
                    this.fetchgroup_inner(local29, 2);
                }
                if (this.groupStates[local29] == 1) {
                    local21.remove();
                }
            }
        }
    }

    @OriginalMember(owner = "client!pm", name = "b", descriptor = "(B)Lclient!pj;")
    @Override
    public Js5Index index() {
        if (this.index != null) {
            return this.index;
        }
        if (this.indexRequest == null) {
            if (this.netWorker.isUrgentFull()) {
                return null;
            }
            this.indexRequest = this.netWorker.requestIndex(255, this.archiveId, true, (byte) 0);
        }
        if (this.indexRequest.incomplete) {
            return null;
        }
        @Pc(53) byte[] local53 = this.indexRequest.getData();
        if (this.indexRequest instanceof Js5ResourceRequest) {
            try {
                if (local53 == null) {
                    throw new RuntimeException();
                }
                this.index = new Js5Index(local53, this.anInt7463, this.aByteArray89);
                if (this.anInt7472 != this.index.version) {
                    throw new RuntimeException();
                }
            } catch (@Pc(162) RuntimeException local162) {
                this.index = null;
                if (this.netWorker.isUrgentFull()) {
                    this.indexRequest = null;
                } else {
                    this.indexRequest = this.netWorker.requestIndex(255, this.archiveId, true, (byte) 0);
                }
                return null;
            }
        } else {
            try {
                if (local53 == null) {
                    throw new RuntimeException();
                }
                this.index = new Js5Index(local53, this.anInt7463, this.aByteArray89);
            } catch (@Pc(76) RuntimeException local76) {
                this.netWorker.reset();
                this.index = null;
                if (this.netWorker.isUrgentFull()) {
                    this.indexRequest = null;
                } else {
                    this.indexRequest = this.netWorker.requestIndex(255, this.archiveId, true, (byte) 0);
                }
                return null;
            }
            if (this.indexStore != null) {
                this.cacheWorker.write(local53, this.archiveId, this.indexStore);
            }
        }
        if (this.datafs != null) {
            this.groupStates = new byte[this.index.groupLimit];
            this.anInt7473 = 0;
        }
        this.indexRequest = null;
        return this.index;
    }

    @OriginalMember(owner = "client!pm", name = "c", descriptor = "(B)V")
    public void method6654() {
        if (this.datafs != null) {
            this.requestMissing = true;
            if (this.passives == null) {
                this.passives = new Deque();
            }
        }
    }
}
