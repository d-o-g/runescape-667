package com.jagex.game.runetek6.config.invtype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sfa")
public final class InvTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!ps", name = "d", descriptor = "Lclient!sfa;")
    public static InvTypeList instance;

    @OriginalMember(owner = "client!sfa", name = "c", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!sfa", name = "b", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!sfa", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public InvTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(Js5ConfigGroup.INVTYPE);
    }

    @OriginalMember(owner = "client!sfa", name = "a", descriptor = "(II)Lclient!dba;")
    public InvType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) InvType type;
        synchronized (this.recentUse) {
            type = (InvType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 5);
        }

        type = new InvType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(63) ReferenceCache local63 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }
}
