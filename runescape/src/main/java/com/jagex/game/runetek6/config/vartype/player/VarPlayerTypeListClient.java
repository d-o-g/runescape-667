package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!nh")
public final class VarPlayerTypeListClient {

    private static final int DEFAULT_CACHE_SIZE = 16;

    @OriginalMember(owner = "client!bda", name = "E", descriptor = "Lclient!nh;")
    public static VarPlayerTypeListClient instance;

    @OriginalMember(owner = "client!nh", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    public final ModeGame game;

    public final int languageId;

    @OriginalMember(owner = "client!nh", name = "f", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!nh", name = "d", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!nh", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarPlayerTypeListClient(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient == null) {
            this.num = 0;
        } else {
            this.num = this.configClient.fileLimit(16);
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(Z)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(II)Lclient!rha;")
    public VarPlayerType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) VarPlayerType type;
        synchronized (this.recentUse) {
            type = (VarPlayerType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 16);
        }
        type = new VarPlayerType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(63) ReferenceCache local63 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(13) ReferenceCache local13 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "(IB)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(11) ReferenceCache local11 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }
}
