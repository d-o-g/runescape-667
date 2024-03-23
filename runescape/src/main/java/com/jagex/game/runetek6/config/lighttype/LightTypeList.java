package com.jagex.game.runetek6.config.lighttype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vga")
public final class LightTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!bka", name = "k", descriptor = "Lclient!vga;")
    public static LightTypeList instance;

    @OriginalMember(owner = "client!vga", name = "l", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!vga", name = "k", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!vga", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public LightTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.LIGHTTYPE);
    }

    @OriginalMember(owner = "client!vga", name = "b", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(IB)Lclient!vt;")
    public LightType list(@OriginalArg(0) int id) {
        @Pc(13) ReferenceCache local13 = this.recentUse;
        @Pc(23) LightType type;
        synchronized (this.recentUse) {
            type = (LightType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(37) js5 local37 = this.configClient;
        @Pc(46) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 31);
        }

        type = new LightType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(70) ReferenceCache local70 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!vga", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }
}
