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

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!bp", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache frameSets = new ReferenceCache(100);

    @OriginalMember(owner = "client!bp", name = "j", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!bp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;Lclient!sb;)V")
    public SeqTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 bases, @OriginalArg(4) js5 anims) {
        this.configClient = configClient;
        if (this.configClient != null) {
            @Pc(26) int local26 = this.configClient.groupSize() - 1;
            this.configClient.fileLimit(local26);
        }
        AnimFrameset.initJs5(anims, bases);
    }

    @OriginalMember(owner = "client!vca", name = "a", descriptor = "(II)I")
    public static int fileId(@OriginalArg(0) int arg0) {
        return arg0 & 0x7F;
    }

    @OriginalMember(owner = "client!je", name = "b", descriptor = "(II)I")
    public static int groupId(@OriginalArg(1) int arg0) {
        return arg0 >>> 7;
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(IB)Lclient!cka;")
    public SeqType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) SeqType local16;
        synchronized (this.recentUse) {
            local16 = (SeqType) this.recentUse.get((long) id);
        }
        if (local16 != null) {
            return local16;
        }
        @Pc(30) js5 local30 = this.configClient;
        @Pc(43) byte[] local43;
        synchronized (this.configClient) {
            local43 = this.configClient.getfile(fileId(id), groupId(id));
        }
        local16 = new SeqType();
        local16.id = id;
        if (local43 != null) {
            local16.method1585(new Packet(local43));
        }
        local16.method1584();
        @Pc(73) ReferenceCache local73 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(local16, (long) id);
            return local16;
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(II)V")
    public void method1163() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(5);
        }
        local6 = this.frameSets;
        synchronized (this.frameSets) {
            this.frameSets.clean(5);
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(I)V")
    public void method1164() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local2 = this.frameSets;
        synchronized (this.frameSets) {
            this.frameSets.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bp", name = "a", descriptor = "(B)V")
    public void method1165() {
        @Pc(7) ReferenceCache local7 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local7 = this.frameSets;
        synchronized (this.frameSets) {
            this.frameSets.reset();
        }
    }

    @OriginalMember(owner = "client!bp", name = "b", descriptor = "(II)Lclient!rw;")
    public AnimFrameset method1166(@OriginalArg(0) int arg0) {
        @Pc(12) ReferenceCache local12 = this.frameSets;
        synchronized (this.frameSets) {
            @Pc(22) AnimFrameset local22 = (AnimFrameset) this.frameSets.get((long) arg0);
            if (local22 == null) {
                local22 = new AnimFrameset(arg0);
                this.frameSets.put(local22, (long) arg0);
            }
            return local22.method7565() ? local22 : null;
        }
    }
}
