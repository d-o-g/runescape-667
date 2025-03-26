package com.jagex.game.runetek6.config.effecttype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fh")
public final class EffectTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!an", name = "b", descriptor = "Lclient!fh;")
    public static EffectTypeList instance;

    @OriginalMember(owner = "client!lfa", name = "a", descriptor = "(II)I")
    private static int groupId(@OriginalArg(0) int id) {
        return id >>> 8;
    }

    @OriginalMember(owner = "client!rl", name = "a", descriptor = "(II)I")
    private static int fileId(@OriginalArg(1) int id) {
        return id & 0xFF;
    }

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "I")
    public int featureMask;

    @OriginalMember(owner = "client!fh", name = "i", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    @OriginalMember(owner = "client!fh", name = "k", descriptor = "Lclient!dla;")
    public final ReferenceCache modelCache = new ReferenceCache(60);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!fh", name = "f", descriptor = "Lclient!sb;")
    public final js5 models;

    @OriginalMember(owner = "client!fh", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!fh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public EffectTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 models) {
        this.game = game;
        this.languageId = languageId;
        this.models = models;
        this.configClient = configClient;

        @Pc(26) int lastGroup = this.configClient.groupSize() - 1;
        this.num = this.configClient.fileLimit(lastGroup);
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(II)Lclient!lia;")
    public EffectType list(@OriginalArg(1) int id) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        @Pc(24) EffectType type;
        synchronized (this.recentUse) {
            type = (EffectType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(38) js5 local38 = this.configClient;
        @Pc(51) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(fileId(id), groupId(id));
        }

        type = new EffectType();
        type.id = id;
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(81) ReferenceCache local81 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(BI)V")
    public void setFeatureMask(@OriginalArg(1) int featureMask) {
        this.featureMask = featureMask;

        @Pc(9) ReferenceCache local9 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.reset();
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(Z)V")
    public void cacheRemoveSoftReferences() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local6 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!fh", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        @Pc(30) ReferenceCache local30 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!fh", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local6 = this.modelCache;
        synchronized (this.modelCache) {
            this.modelCache.reset();
        }
    }
}
