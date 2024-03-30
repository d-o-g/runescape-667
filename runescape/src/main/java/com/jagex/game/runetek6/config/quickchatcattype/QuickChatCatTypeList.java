package com.jagex.game.runetek6.config.quickchatcattype;

import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gt")
public final class QuickChatCatTypeList {

    @OriginalMember(owner = "client!cd", name = "c", descriptor = "Lclient!gt;")
    public static QuickChatCatTypeList instance;

    @OriginalMember(owner = "client!gt", name = "g", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(64);

    public final int languageId;

    @OriginalMember(owner = "client!gt", name = "c", descriptor = "Lclient!sb;")
    public final js5 quickchatGlobal;

    @OriginalMember(owner = "client!gt", name = "f", descriptor = "Lclient!sb;")
    public final js5 clientConfig;

    public int num = 0;

    public int globalNum = 0;

    @OriginalMember(owner = "client!gt", name = "<init>", descriptor = "(ILclient!sb;Lclient!sb;)V")
    public QuickChatCatTypeList(@OriginalArg(0) int languageId, @OriginalArg(1) js5 clientConfig, @OriginalArg(2) js5 quickchatGlobal) {
        this.languageId = languageId;
        this.quickchatGlobal = quickchatGlobal;
        this.clientConfig = clientConfig;

        if (this.clientConfig != null) {
            this.num = this.clientConfig.fileLimit(0);
        }

        if (this.quickchatGlobal != null) {
            this.globalNum = this.quickchatGlobal.fileLimit(0);
        }
    }

    @OriginalMember(owner = "client!gt", name = "a", descriptor = "(BI)Lclient!bq;")
    public QuickChatCatType list(@OriginalArg(1) int id) {
        @Pc(11) QuickChatCatType type = (QuickChatCatType) this.recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(28) byte[] data;
        if (id < 32768) {
            data = this.clientConfig.getfile(id, 0);
        } else {
            data = this.quickchatGlobal.getfile(id & 0x7FFF, 0);
        }

        type = new QuickChatCatType();
        if (data != null) {
            type.decode(new Packet(data));
        }
        if (id >= 32768) {
            type.postDecode();
        }

        this.recentUse.put(type, id);
        return type;
    }
}
