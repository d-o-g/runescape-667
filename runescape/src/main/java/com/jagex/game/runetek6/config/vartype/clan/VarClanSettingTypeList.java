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

@OriginalClass("client!sn")
public final class VarClanSettingTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!tt", name = "a", descriptor = "Lclient!sn;")
    public static VarClanSettingTypeList instance;

    @OriginalMember(owner = "client!sn", name = "e", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!sn", name = "l", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!sn", name = "d", descriptor = "I")
    public final int num;

    @OriginalMember(owner = "client!sn", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public VarClanSettingTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient == null) {
            this.num = 0;
        } else {
            this.num = this.configClient.fileLimit(Js5ConfigGroup.VAR_CLAN_SETTING);
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(Z)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(IB)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!sn", name = "b", descriptor = "(II)Lclient!fc;")
    public VarClanSettingType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) VarClanSettingType type;
        synchronized (this.recentUse) {
            type = (VarClanSettingType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 47);
        }

        type = new VarClanSettingType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(63) ReferenceCache local63 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }
}
