package com.jagex.game.runetek6.config.meltype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ml")
public final class MapElementTypeList {

    public static final int DEFAULT_CACHE_SIZE = 128;

    @OriginalMember(owner = "client!sca", name = "a", descriptor = "Lclient!ml;")
    public static MapElementTypeList instance;

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "Lclient!dla;")
    public ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    @OriginalMember(owner = "client!ml", name = "o", descriptor = "Lclient!dla;")
    public ReferenceCache spriteCache = new ReferenceCache(64);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!ml", name = "n", descriptor = "Lclient!sb;")
    public final js5 sprites;

    @OriginalMember(owner = "client!ml", name = "g", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!ml", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public MapElementTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 sprites) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.sprites = sprites;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.MELTYPE);
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(12) ReferenceCache local12 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local12 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(III)V")
    public void setCaches(@OriginalArg(1) int recentUseSize, @OriginalArg(2) int spriteSize) {
        this.recentUse = new ReferenceCache(recentUseSize);
        this.spriteCache = new ReferenceCache(spriteSize);
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(BI)Lclient!el;")
    public MapElementType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) MapElementType type;
        synchronized (this.recentUse) {
            type = (MapElementType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 36);
        }

        type = new MapElementType();
        type.myList = this;
        type.id = id;
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        @Pc(72) ReferenceCache local72 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!ml", name = "a", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local6 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!ml", name = "b", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local6 = this.spriteCache;
        synchronized (this.spriteCache) {
            this.spriteCache.reset();
        }
    }
}
