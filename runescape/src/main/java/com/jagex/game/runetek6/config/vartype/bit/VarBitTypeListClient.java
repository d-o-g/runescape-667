package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!hf")
public final class VarBitTypeListClient {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!qla", name = "a", descriptor = "Lclient!hf;")
    public static VarBitTypeListClient instance;

    @OriginalMember(owner = "client!kd", name = "b", descriptor = "(BI)I")
    private static int fileId(@OriginalArg(1) int id) {
        return id & 0x3FF;
    }

    @OriginalMember(owner = "client!qe", name = "a", descriptor = "(II)I")
    private static int groupId(@OriginalArg(1) int id) {
        return id >>> 10;
    }

    @OriginalMember(owner = "client!hf", name = "c", descriptor = "Lclient!dla;")
    public ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    public final ModeGame game;

    public final int languageId;

    public final int num;

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!hf", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarBitTypeListClient(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient == null) {
            this.num = 0;
        } else {
            @Pc(20) int lastGroup = this.configClient.groupSize() - 1;
            this.num = this.configClient.fileLimit(lastGroup);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(II)V")
    public void cacheReset(@OriginalArg(1) int capacity) {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
            this.recentUse = new ReferenceCache(capacity);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!hf", name = "c", descriptor = "(II)Lclient!eea;")
    public VarBitType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) VarBitType type;
        synchronized (this.recentUse) {
            type = (VarBitType) this.recentUse.get((long) id);
        }
        if (type != null) {
            return type;
        }

        @Pc(40) js5 local40 = this.configClient;
        @Pc(53) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(fileId(id), groupId(id));
        }
        type = new VarBitType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(77) ReferenceCache local77 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, (long) id);
            return type;
        }
    }

    @OriginalMember(owner = "client!hf", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }
}
