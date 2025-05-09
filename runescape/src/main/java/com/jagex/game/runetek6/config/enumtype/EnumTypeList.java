package com.jagex.game.runetek6.config.enumtype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vka")
public final class EnumTypeList {

    private static final int DEFAULT_CACHE_SIZE = 128;

    @OriginalMember(owner = "client!tk", name = "d", descriptor = "Lclient!vka;")
    public static EnumTypeList instance;

    @OriginalMember(owner = "client!fq", name = "a", descriptor = "(II)I")
    private static int groupId(@OriginalArg(1) int id) {
        return id >>> 8;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(BI)I")
    private static int fileId(@OriginalArg(1) int id) {
        return id & 0xFF;
    }

    @OriginalMember(owner = "client!vka", name = "j", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!vka", name = "d", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!vka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public EnumTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient != null) {
            @Pc(20) int lastGroup = this.configClient.groupSize() - 1;
            this.num = this.configClient.fileLimit(lastGroup);
        } else {
            this.num = 0;
        }
    }

    @OriginalMember(owner = "client!vka", name = "a", descriptor = "(II)Lclient!bt;")
    public EnumType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) EnumType type;
        synchronized (this.recentUse) {
            type = (EnumType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(40) byte[] data = this.configClient.getfile(fileId(id), groupId(id));
        type = new EnumType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(66) ReferenceCache local66 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }
}
