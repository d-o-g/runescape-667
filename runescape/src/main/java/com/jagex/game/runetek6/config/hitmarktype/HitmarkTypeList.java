package com.jagex.game.runetek6.config.hitmarktype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ld")
public final class HitmarkTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!rla", name = "e", descriptor = "Lclient!ld;")
    public static HitmarkTypeList instance;

    @OriginalMember(owner = "client!ld", name = "n", descriptor = "Lclient!dla;")
    public final ReferenceCache hitmarkCache = new ReferenceCache(20);

    @OriginalMember(owner = "client!ld", name = "d", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!ld", name = "l", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!ld", name = "g", descriptor = "Lclient!sb;")
    public final js5 sprites;

    private final int num;

    @OriginalMember(owner = "client!ld", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public HitmarkTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 sprites) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.sprites = sprites;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.HITMARKTYPE);
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local2 = this.hitmarkCache;
        synchronized (this.hitmarkCache) {
            this.hitmarkCache.reset();
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local2 = this.hitmarkCache;
        synchronized (this.hitmarkCache) {
            this.hitmarkCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local6 = this.hitmarkCache;
        synchronized (this.hitmarkCache) {
            this.hitmarkCache.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!ld", name = "b", descriptor = "(II)Lclient!pb;")
    public HitmarkType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) HitmarkType type;
        synchronized (this.recentUse) {
            type = (HitmarkType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, Js5ConfigGroup.HITMARKTYPE);
        }

        type = new HitmarkType();
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(66) ReferenceCache local66 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }
}
