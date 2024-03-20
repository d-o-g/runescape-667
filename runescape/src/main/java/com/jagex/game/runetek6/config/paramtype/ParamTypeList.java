package com.jagex.game.runetek6.config.paramtype;

import com.jagex.collect.ref.ReferenceCache;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bo")
public final class ParamTypeList {

    @OriginalMember(owner = "client!mba", name = "F", descriptor = "Lclient!bo;")
    public static ParamTypeList instance;

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!bo", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    @OriginalMember(owner = "client!bo", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public ParamTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.configClient = configClient;
        if (this.configClient != null) {
            this.configClient.fileLimit(Js5ConfigGroup.PARAMTYPE);
        }
    }

    @OriginalMember(owner = "client!bo", name = "c", descriptor = "(I)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bo", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!bo", name = "a", descriptor = "(II)Lclient!po;")
    public ParamType list(@OriginalArg(0) int id) {
        @Pc(13) ReferenceCache local13 = this.recentUse;
        @Pc(23) ParamType type;
        synchronized (this.recentUse) {
            type = (ParamType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(37) js5 local37 = this.configClient;
        @Pc(46) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, Js5ConfigGroup.PARAMTYPE);
        }

        type = new ParamType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(70) ReferenceCache local70 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, (long) id);
            return type;
        }
    }
}
