package com.jagex.game.runetek6.config.questtype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.Js5ConfigGroup;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bka")
public final class QuestTypeList {

    private static final int DEFAULT_CACHE_SIZE = 64;

    @OriginalMember(owner = "client!ija", name = "m", descriptor = "Lclient!bka;")
    public static QuestTypeList instance;

    @OriginalMember(owner = "client!bka", name = "d", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(DEFAULT_CACHE_SIZE);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!bka", name = "h", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!bka", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public QuestTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;

        if (this.configClient != null) {
            this.num = this.configClient.fileLimit(Js5ConfigGroup.QUESTTYPE);
        } else {
            this.num = 0;
        }
    }

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(B)V")
    public void cacheRemoveSoftReferences() {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(IB)Lclient!la;")
    public QuestType list(@OriginalArg(0) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) QuestType type;
        synchronized (this.recentUse) {
            type = (QuestType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 35);
        }

        type = new QuestType();
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        @Pc(66) ReferenceCache local66 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!bka", name = "a", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(1) int maxAge) {
        @Pc(11) ReferenceCache local11 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!bka", name = "b", descriptor = "(I)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }
}
