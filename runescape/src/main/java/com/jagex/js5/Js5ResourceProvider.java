package com.jagex.js5;

import com.jagex.collect.key.Deque;
import com.jagex.collect.key.Node;
import com.jagex.collect.key.HashTable;
import com.jagex.core.crypto.Whirlpool;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.zip.CRC32;

@OriginalClass("client!pm")
public final class Js5ResourceProvider extends ResourceProvider {

    private static final int FETCHGROUP_MODE_URGENT = 0;
    private static final int FETCHGROUP_MODE_VERIFY = 1;
    private static final int FETCHGROUP_MODE_PREFETCH = 2;

    @OriginalMember(owner = "client!afa", name = "h", descriptor = "Ljava/util/zip/CRC32;")
    private static final CRC32 CRC32 = new CRC32();

    @OriginalMember(owner = "client!pm", name = "t", descriptor = "[B")
    public byte[] groupStates;

    @OriginalMember(owner = "client!pm", name = "i", descriptor = "Lclient!pj;")
    public Js5Index index;

    @OriginalMember(owner = "client!pm", name = "M", descriptor = "Z")
    public boolean requestMissing;

    @OriginalMember(owner = "client!pm", name = "g", descriptor = "I")
    public int loaded = 0;

    @OriginalMember(owner = "client!pm", name = "A", descriptor = "Lclient!av;")
    public final HashTable waiting = new HashTable(16);

    @OriginalMember(owner = "client!pm", name = "h", descriptor = "I")
    public int currentGroup = 0;

    @OriginalMember(owner = "client!pm", name = "F", descriptor = "Lclient!sia;")
    public final Deque groupRequests = new Deque();

    @OriginalMember(owner = "client!pm", name = "m", descriptor = "J")
    public long nextOphanCheck = 0L;

    @OriginalMember(owner = "client!pm", name = "j", descriptor = "I")
    public final int archiveId;

    @OriginalMember(owner = "client!pm", name = "E", descriptor = "Lclient!af;")
    public final FileSystem_Client datafs;

    @OriginalMember(owner = "client!pm", name = "n", descriptor = "Z")
    public boolean verifyLocal;

    @OriginalMember(owner = "client!pm", name = "v", descriptor = "Lclient!sia;")
    public Deque passives;

    @OriginalMember(owner = "client!pm", name = "x", descriptor = "Z")
    public final boolean clearIdle;

    @OriginalMember(owner = "client!pm", name = "K", descriptor = "Lclient!pla;")
    public final Js5WorkerThread netWorker;

    @OriginalMember(owner = "client!pm", name = "s", descriptor = "I")
    public final int crc;

    @OriginalMember(owner = "client!pm", name = "D", descriptor = "I")
    public final int version;

    @OriginalMember(owner = "client!pm", name = "H", descriptor = "Lclient!iba;")
    public final CachedResourceWorker cacheWorker;

    @OriginalMember(owner = "client!pm", name = "O", descriptor = "[B")
    public final byte[] whirlpool;

    @OriginalMember(owner = "client!pm", name = "B", descriptor = "Lclient!af;")
    public final FileSystem_Client indexStore;

    @OriginalMember(owner = "client!pm", name = "C", descriptor = "Lclient!tw;")
    public ResourceRequest indexRequest;

    @OriginalMember(owner = "client!pm", name = "<init>", descriptor = "(ILclient!af;Lclient!af;Lclient!pla;Lclient!iba;I[BIZ)V")
    public Js5ResourceProvider(@OriginalArg(0) int archiveId, @OriginalArg(1) FileSystem_Client datafs, @OriginalArg(2) FileSystem_Client indexStore, @OriginalArg(3) Js5WorkerThread netWorker, @OriginalArg(4) CachedResourceWorker cacheWorker, @OriginalArg(5) int crc, @OriginalArg(6) byte[] whirlpool, @OriginalArg(7) int version, @OriginalArg(8) boolean clearIdle) {
        this.archiveId = archiveId;
        this.datafs = datafs;
        if (this.datafs == null) {
            this.verifyLocal = false;
        } else {
            this.verifyLocal = true;
            this.passives = new Deque();
        }
        this.clearIdle = clearIdle;
        this.netWorker = netWorker;
        this.crc = crc;
        this.version = version;
        this.cacheWorker = cacheWorker;
        this.whirlpool = whirlpool;
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
        request.key = groupId;
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
                        passive.unlink();
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
                            passive.key = this.currentGroup;
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
                        passive.unlink();
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
                            this.fetchgroup_inner(this.currentGroup, FETCHGROUP_MODE_PREFETCH);
                        }

                        if (this.groupStates[this.currentGroup] != 1) {
                            @Pc(147) Node node = new Node();
                            node.key = this.currentGroup;
                            this.passives.addLast(node);
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

        if (this.clearIdle && SystemTimer.safetime() >= this.nextOphanCheck) {
            for (@Pc(366) ResourceRequest request = (ResourceRequest) this.waiting.first(); request != null; request = (ResourceRequest) this.waiting.next()) {
                if (!request.incomplete) {
                    if (request.orphan) {
                        if (!request.urgent) {
                            throw new RuntimeException("Unexpected non-urgent orphan! archiveid:" + archiveId);
                        }
                        request.unlink();
                    } else {
                        request.orphan = true;
                    }
                }
            }

            this.nextOphanCheck = SystemTimer.safetime() + 1000L;
        }
    }

    @OriginalMember(owner = "client!pm", name = "d", descriptor = "(B)I")
    public int method6649() {
        return this.loaded;
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(IB)[B")
    @Override
    public byte[] fetchgroup(@OriginalArg(0) int groupId) {
        @Pc(9) ResourceRequest request = this.fetchgroup_inner(groupId, FETCHGROUP_MODE_URGENT);

        if (request == null) {
            return null;
        } else {
            @Pc(26) byte[] data = request.getData();
            request.unlink();
            return data;
        }
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(III)Lclient!tw;")
    public ResourceRequest fetchgroup_inner(@OriginalArg(0) int groupId, @OriginalArg(1) int mode) {
        @Pc(19) ResourceRequest request = (ResourceRequest) this.waiting.get((long) groupId);
        if (request != null && mode == 0 && !request.urgent && request.incomplete) {
            request.unlink();
            request = null;
        }

        if (request == null) {
            if (mode == FETCHGROUP_MODE_URGENT) {
                if (this.datafs != null && this.groupStates[groupId] != -1) {
                    request = this.cacheWorker.readUrgent(this.datafs, groupId);
                } else if (!this.netWorker.isUrgentFull()) {
                    request = this.netWorker.requestIndex(this.archiveId, groupId, true, (byte) 2);
                } else {
                    return null;
                }
            } else if (mode == FETCHGROUP_MODE_VERIFY) {
                if (this.datafs != null) {
                    request = this.cacheWorker.verify(this.datafs, groupId);
                } else {
                    throw new RuntimeException("fetchgroup_inner - VERIFY requested but no datafs available!");
                }
            } else if (mode == FETCHGROUP_MODE_PREFETCH) {
                if (this.datafs == null) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested but no datafs available!");
                } else if (this.groupStates[groupId] != -1) {
                    throw new RuntimeException("fetchgroup_inner - PREFETCH requested, but cache isn\'t known invalid!");
                } else if (this.netWorker.isPrefetchFull()) {
                    return null;
                } else {
                    request = this.netWorker.requestIndex(this.archiveId, groupId, false, (byte) 2);
                }
            } else {
                throw new RuntimeException("Invalid fetchgroup mode!");
            }

            this.waiting.put((long) groupId, request);
        }

        if (request.incomplete) {
            return null;
        }

        @Pc(194) byte[] data = request.getData();
        if (request instanceof Js5ResourceRequest) {
            try {
                if (data == null || data.length <= 2) {
                    throw new RuntimeException("Data not in cache - data:" + data);
                }

                CRC32.reset();
                CRC32.update(data, 0, data.length - 2);

                @Pc(224) int crc = (int) CRC32.getValue();
                if (crc != this.index.groupCrcs[groupId]) {
                    throw new RuntimeException("Disk fetch CRC incorrect");
                }

                if (this.index.groupHashes != null && this.index.groupHashes[groupId] != null) {
                    @Pc(254) byte[] expected = this.index.groupHashes[groupId];
                    @Pc(263) byte[] actual = Whirlpool.digest(data, data.length - 2, 0);

                    for (@Pc(265) int i = 0; i < 64; i++) {
                        if (actual[i] != expected[i]) {
                            throw new RuntimeException("Disk fetch Whirlpool incorrect");
                        }
                    }
                }

                @Pc(307) int version = (data[data.length - 1] & 0xFF) + ((data[data.length - 2] & 0xFF) << 8);
                if (version != (this.index.groupVersions[groupId] & 0xFFFF)) {
                    throw new RuntimeException("Version incorrect - wanted:" + index.groupVersions[groupId] + " got:" + version);
                }

                if (this.groupStates[groupId] != 1) {
                    this.loaded++;
                    this.groupStates[groupId] = 1;
                }

                if (!request.urgent) {
                    request.unlink();
                }

                return request;
            } catch (@Pc(355) Exception ignored) {
                this.groupStates[groupId] = -1;
                request.unlink();

                if (request.urgent && !this.netWorker.isUrgentFull()) {
                    @Pc(383) Js5WorkerRequestMessage message = this.netWorker.requestIndex(this.archiveId, groupId, true, (byte) 2);
                    this.waiting.put(groupId, message);
                }

                return null;
            }
        } else {
            try {
                if (data == null || data.length <= 2) {
                    throw new RuntimeException("Data from server too small - data:" + data);
                }

                CRC32.reset();
                CRC32.update(data, 0, data.length - 2);

                @Pc(224) int crc = (int) CRC32.getValue();
                if (this.index.groupCrcs[groupId] != crc) {
                    throw new RuntimeException("Net fetch CRC incorrect");
                }

                if (this.index.groupHashes != null && this.index.groupHashes[groupId] != null) {
                    @Pc(254) byte[] expected = this.index.groupHashes[groupId];
                    @Pc(263) byte[] actual = Whirlpool.digest(data, data.length - 2, 0);

                    for (@Pc(265) int i = 0; i < 64; i++) {
                        if (expected[i] != actual[i]) {
                            throw new RuntimeException("Whirlpool for group " + groupId + " incorrect - got:" + actual + " expected:" + expected);
                        }
                    }
                }

                this.netWorker.errors = 0;
                this.netWorker.response = Js5ResponseCode.OK;
            } catch (@Pc(498) RuntimeException ignored) {
                this.netWorker.reset();
                request.unlink();

                if (request.urgent && !this.netWorker.isUrgentFull()) {
                    @Pc(383) Js5WorkerRequestMessage message = this.netWorker.requestIndex(this.archiveId, groupId, true, (byte) 2);
                    this.waiting.put(groupId, message);
                }

                return null;
            }

            data[data.length - 2] = (byte) (this.index.groupVersions[groupId] >>> 8);
            data[data.length - 1] = (byte) (this.index.groupVersions[groupId]);

            if (this.datafs != null) {
                this.cacheWorker.write(data, groupId, this.datafs);

                if (this.groupStates[groupId] != 1) {
                    this.loaded++;
                    this.groupStates[groupId] = 1;
                }
            }

            if (!request.urgent) {
                request.unlink();
            }

            return request;
        }
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(BI)I")
    @Override
    public int completePercentage(@OriginalArg(1) int groupId) {
        @Pc(19) ResourceRequest request = (ResourceRequest) this.waiting.get(groupId);
        return request == null ? 0 : request.completePercentage();
    }

    @OriginalMember(owner = "client!pm", name = "a", descriptor = "(Z)V")
    public void processRequests() {
        if (this.passives == null || this.index() == null) {
            return;
        }

        for (@Pc(21) Node request = this.groupRequests.first(); request != null; request = this.groupRequests.next()) {
            @Pc(29) int group = (int) request.key;

            if (group < 0 || group >= this.index.groupLimit || this.index.fileCounts[group] == 0) {
                request.unlink();
            } else {
                if (this.groupStates[group] == 0) {
                    this.fetchgroup_inner(group, FETCHGROUP_MODE_VERIFY);
                }

                if (this.groupStates[group] == -1) {
                    this.fetchgroup_inner(group, FETCHGROUP_MODE_PREFETCH);
                }

                if (this.groupStates[group] == 1) {
                    request.unlink();
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

            this.indexRequest = this.netWorker.requestIndex(Js5Archive.ARCHIVESET, this.archiveId, true, (byte) 0);
        }

        if (this.indexRequest.incomplete) {
            return null;
        }

        @Pc(53) byte[] data = this.indexRequest.getData();
        if (this.indexRequest instanceof Js5ResourceRequest) {
            try {
                if (data == null) {
                    throw new RuntimeException("Index not found in disk cache");
                }
                this.index = new Js5Index(data, this.crc, this.whirlpool);

                if (this.version != this.index.version) {
                    throw new RuntimeException("Index version wrong - index.indexversion:" + index.version + " expected:" + version);
                }
            } catch (@Pc(162) RuntimeException ignored) {
                this.index = null;

                if (this.netWorker.isUrgentFull()) {
                    this.indexRequest = null;
                } else {
                    this.indexRequest = this.netWorker.requestIndex(Js5Archive.ARCHIVESET, this.archiveId, true, (byte) 0);
                }

                return null;
            }
        } else {
            try {
                if (data == null) {
                    throw new RuntimeException("Failed to download index from server!");
                }

                this.index = new Js5Index(data, this.crc, this.whirlpool);
            } catch (@Pc(76) RuntimeException local76) {
                this.netWorker.reset();
                this.index = null;

                if (this.netWorker.isUrgentFull()) {
                    this.indexRequest = null;
                } else {
                    this.indexRequest = this.netWorker.requestIndex(Js5Archive.ARCHIVESET, this.archiveId, true, (byte) 0);
                }

                return null;
            }

            if (this.indexStore != null) {
                this.cacheWorker.write(data, this.archiveId, this.indexStore);
            }
        }

        if (this.datafs != null) {
            this.groupStates = new byte[this.index.groupLimit];
            this.loaded = 0;
        }

        this.indexRequest = null;
        return this.index;
    }

    @OriginalMember(owner = "client!pm", name = "c", descriptor = "(B)V")
    public void requestMissing() {
        if (this.datafs != null) {
            this.requestMissing = true;

            if (this.passives == null) {
                this.passives = new Deque();
            }
        }
    }
}
