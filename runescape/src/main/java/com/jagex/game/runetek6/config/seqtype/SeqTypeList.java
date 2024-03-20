package com.jagex.game.runetek6.config.seqtype;

import com.jagex.AnimFrameset;
import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bp")
public final class SeqTypeList {

    @OriginalMember(owner = "client!vca", name = "a", descriptor = "(II)I")
    private static int fileId(@OriginalArg(0) int id) {
        return id & 0x7F;
    }

    @OriginalMember(owner = "client!je", name = "b", descriptor = "(II)I")
    private static int groupId(@OriginalArg(1) int id) {
        return id >>> 7;
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!bp", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache framesets = new ReferenceCache(100);

    @OriginalMember(owner = "client!bp", name = "j", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!bp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;Lclient!sb;)V")
    public SeqTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 bases, @OriginalArg(4) js5 anims) {
        this.configClient = configClient;

        if (this.configClient != null) {
            @Pc(26) int lastGroup = this.configClient.groupSize() - 1;
            this.configClient.fileLimit(lastGroup);
        }

        AnimFrameset.initJs5(anims, bases);
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(IB)Lclient!cka;")
    public SeqType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) SeqType type;
        synchronized (this.recentUse) {
            type = (SeqType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(43) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(fileId(id), groupId(id));
        }

        type = new SeqType();
        type.id = id;
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        @Pc(73) ReferenceCache local73 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(II)V")
    public void cacheClean() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(5);
        }
        local6 = this.framesets;
        synchronized (this.framesets) {
            this.framesets.clean(5);
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local2 = this.framesets;
        synchronized (this.framesets) {
            this.framesets.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(7) ReferenceCache local7 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local7 = this.framesets;
        synchronized (this.framesets) {
            this.framesets.reset();
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(II)Lclient!rw;")
    public AnimFrameset getFrameset(@OriginalArg(0) int id) {
        @Pc(12) ReferenceCache local12 = this.framesets;
        synchronized (this.framesets) {
            @Pc(22) AnimFrameset frameset = (AnimFrameset) this.framesets.get(id);
            if (frameset == null) {
                frameset = new AnimFrameset(id);
                this.framesets.put(frameset, id);
            }

            return frameset.isReady() ? frameset : null;
        }
    }
}
