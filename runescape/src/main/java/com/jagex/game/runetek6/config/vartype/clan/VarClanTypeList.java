package com.jagex.game.runetek6.config.vartype.clan;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!al")
public final class VarClanTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!ui", name = "y", descriptor = "Lclient!al;")
    public static VarClanTypeList instance;

    @OriginalMember(owner = "client!al", name = "b", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!al", name = "g", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!al", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarClanTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient != null) {
            this.num = this.configClient.fileLimit(Js5ConfigGroup.VAR_CLAN);
        } else {
            this.num = 0;
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(II)Lclient!sla;")
    public VarClanType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) VarClanType type;
        synchronized (this.recentUse) {
            type = (VarClanType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 54);
        }

        type = new VarClanType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(63) ReferenceCache local63 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(IB)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(11) ReferenceCache local11 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }
}
