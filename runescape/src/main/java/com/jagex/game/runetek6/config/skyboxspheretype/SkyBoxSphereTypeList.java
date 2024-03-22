package com.jagex.game.runetek6.config.skyboxspheretype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dg")
public final class SkyBoxSphereTypeList {

    private static final int DEFAULT_CACHE_SIZE = 16;

    @OriginalMember(owner = "client!dg", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    public final ModeGame game;

    public final int languageId;

    @OriginalMember(owner = "client!dg", name = "h", descriptor = "Lclient!sb;")
    public final js5 configClient;

    public int num;

    @OriginalMember(owner = "client!dg", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public SkyBoxSphereTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.SKYBOXSPHERETYPE);
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(II)Lclient!afa;")
    public SkyBoxSphereType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) SkyBoxSphereType type;
        synchronized (this.recentUse) {
            type = (SkyBoxSphereType) this.recentUse.get((long) id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 30);
        }

        type = new SkyBoxSphereType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(63) ReferenceCache local63 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(14) ReferenceCache local14 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!dg", name = "a", descriptor = "(IB)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(9) ReferenceCache local9 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }
}
