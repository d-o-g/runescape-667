package com.jagex.game.runetek6.config.structtype;

import com.jagex.core.constants.ModeGame;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kq")
public final class StructTypeList {

    @OriginalMember(owner = "client!uka", name = "x", descriptor = "Lclient!kq;")
    public static StructTypeList instance;

    @OriginalMember(owner = "client!kq", name = "f", descriptor = "Lclient!dla;")
    public final ReferenceCache recentUse = new ReferenceCache(256);

    private final ModeGame game;

    private final int languageId;

    @OriginalMember(owner = "client!kq", name = "j", descriptor = "Lclient!sb;")
    public final js5 configClient;

    private final int num;

    @OriginalMember(owner = "client!kq", name = "<init>", descriptor = "(Lclient!ul;ILclient!sb;)V")
    public StructTypeList(@OriginalArg(0) ModeGame game, @OriginalArg(1) int languageId, @OriginalArg(2) js5 configClient) {
        this.game = game;
        this.languageId = languageId;
        this.configClient = configClient;
        this.num = this.configClient.fileLimit(26);
    }

    @OriginalMember(owner = "client!kq", name = "b", descriptor = "(Z)V")
    public void cacheReset() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.reset();
        }
    }

    @OriginalMember(owner = "client!kq", name = "b", descriptor = "(II)V")
    public void cacheClean(@OriginalArg(0) int maxAge) {
        @Pc(10) ReferenceCache local10 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.clean(maxAge);
        }
    }

    @OriginalMember(owner = "client!kq", name = "a", descriptor = "(II)Lclient!ab;")
    public StructType list(@OriginalArg(1) int id) {
        @Pc(6) ReferenceCache local6 = this.recentUse;
        @Pc(16) StructType type;
        synchronized (this.recentUse) {
            type = (StructType) this.recentUse.get(id);
        }
        if (type != null) {
            return type;
        }

        @Pc(30) js5 local30 = this.configClient;
        @Pc(39) byte[] data;
        synchronized (this.configClient) {
            data = this.configClient.getfile(id, 26);
        }

        type = new StructType();
        if (data != null) {
            type.decode(new Packet(data));
        }

        @Pc(71) ReferenceCache local71 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.put(type, id);
            return type;
        }
    }

    @OriginalMember(owner = "client!kq", name = "a", descriptor = "(Z)V")
    public void cacheRemoveSoftReferences() {
        @Pc(2) ReferenceCache local2 = this.recentUse;
        synchronized (this.recentUse) {
            this.recentUse.removeSoftReferences();
        }
    }
}
