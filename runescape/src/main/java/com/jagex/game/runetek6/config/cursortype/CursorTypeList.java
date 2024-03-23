package com.jagex.game.runetek6.config.cursortype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nv")
public final class CursorTypeList {

    @OriginalMember(owner = "client!ld", name = "i", descriptor = "Lclient!nv;")
    public static CursorTypeList instance;

    @OriginalMember(owner = "client!nv", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!nv", name = "g", descriptor = "Lclient!dla;")
    public final ReferenceCache cursorCache = new ReferenceCache(2);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "Lclient!sb;")
    public final js5 sprites;

    @OriginalMember(owner = "client!nv", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!nv", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!sb;)V")
    public CursorTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) js5 sprites) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.sprites = sprites;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.CURSORTYPE);
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(11) ReferenceCache local11 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
        local11 = this.cursorCache;
        synchronized (this.cursorCache) {
            this.cursorCache.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(9) ReferenceCache local9 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
        local9 = this.cursorCache;
        synchronized (this.cursorCache) {
            this.cursorCache.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!nv", name = "a", descriptor = "(II)Lclient!vla;")
    public CursorType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(18) CursorType type;
        synchronized (this.recentUse) {
            type = (CursorType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(32) js5 local32 = this.configClient;
        @Pc(41) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 33);
        }

        type = new CursorType();
        type.myList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(70) ReferenceCache local70 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!nv", name = "b", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(7) ReferenceCache local7 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
        local7 = this.cursorCache;
        synchronized (this.cursorCache) {
            this.cursorCache.reset();
        }
    }
}
