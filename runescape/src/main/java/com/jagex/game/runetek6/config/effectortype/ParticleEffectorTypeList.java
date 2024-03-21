package com.jagex.game.runetek6.config.effectortype;

import com.jagex.core.datastruct.key.HashTable;
import com.jagex.core.datastruct.key.IntNode;
import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ParticleEffectorTypeList {

    @OriginalMember(owner = "client!lk", name = "a", descriptor = "[Lclient!ok;")
    public static final ParticleEffectorType[] types = new ParticleEffectorType[16];

    @OriginalMember(owner = "client!ps", name = "i", descriptor = "Lclient!av;")
    public static final HashTable table = new HashTable(16);

    @OriginalMember(owner = "client!wk", name = "h", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!lm", name = "k", descriptor = "I")
    private static int ptr = 0;

    @OriginalMember(owner = "client!jq", name = "g", descriptor = "Lclient!sb;")
    public static js5 configClient;

    @OriginalMember(owner = "client!qca", name = "a", descriptor = "(ZLclient!sb;)V")
    public static void setConfigClient(@OriginalArg(1) js5 configClient) {
        ParticleEffectorTypeList.configClient = configClient;
    }

    @OriginalMember(owner = "client!cc", name = "b", descriptor = "(II)Lclient!ok;")
    public static ParticleEffectorType get(@OriginalArg(1) int id) {
        @Pc(10) ParticleEffectorType type = (ParticleEffectorType) recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(21) byte[] data = configClient.getfile(id, 1);
        type = new ParticleEffectorType();
        type.id = id;
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        if (type.visibility == 2 && table.get(id) == null) {
            table.put(id, new IntNode(ptr));
            types[ptr++] = type;
        }

        recentUse.put(type, id);
        return type;
    }

    @OriginalMember(owner = "client!nfa", name = "a", descriptor = "(I)V")
    public static void cacheReset() {
        recentUse.reset();
    }

    private ParticleEffectorTypeList() {
        /* empty */
    }
}
