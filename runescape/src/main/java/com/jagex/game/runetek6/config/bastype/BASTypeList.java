package com.jagex.game.runetek6.config.bastype;

import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.game.runetek6.config.defaults.WearposDefaults;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!qp")
public final class BASTypeList {

    @OriginalMember(owner = "client!qp", name = "h", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!qp", name = "g", descriptor = "Lclient!vl;")
    public final WearposDefaults wearposDefaults;

    public final ModeGame game;
    public final int languageId;
    public final int num;

    @OriginalMember(owner = "client!qp", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;Lclient!vl;)V")
    public BASTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient, @OriginalArg(3) WearposDefaults wearposDefaults) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(32);
        this.wearposDefaults = wearposDefaults;
    }

    @OriginalMember(owner = "client!qp", name = "b", descriptor = "(B)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(IZ)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(BI)Lclient!pda;")
    public BASType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) BASType type;
        synchronized (this.recentUse) {
            type = (BASType) this.recentUse.get((long) id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, Js5ConfigGroup.BASTYPE);
        }

        type = new BASType();
        type.typeList = this;
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(66) ReferenceCache local66 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, (long) id);
            return type;
        }
    }
}
