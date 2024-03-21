package com.jagex.game.runetek6.config.emittertype;

import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ParticleEmitterTypeList {

    @OriginalMember(owner = "client!jba", name = "d", descriptor = "Lclient!dla;")
    private static final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!mt", name = "O", descriptor = "Lclient!sb;")
    public static js5 configClient;

    @OriginalMember(owner = "client!we", name = "a", descriptor = "(ZLclient!sb;)V")
    public static void setConfigClient(@OriginalArg(1) js5 configClient) {
        ParticleEmitterTypeList.configClient = configClient;
    }

    @OriginalMember(owner = "client!o", name = "a", descriptor = "(BI)Lclient!vaa;")
    public static ParticleEmitterType get(@OriginalArg(1) int id) {
        @Pc(10) ParticleEmitterType type = (ParticleEmitterType) recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(21) byte[] data = configClient.getfile(id, 0);
        type = new ParticleEmitterType();
        if (data != null) {
            type.decode(new Packet(data));
        }
        type.postDecode();

        recentUse.put(type, id);
        return type;
    }

    @OriginalMember(owner = "client!rla", name = "b", descriptor = "(I)V")
    public static void cacheReset() {
        recentUse.reset();
    }

    private ParticleEmitterTypeList() {
        /* empty */
    }
}
