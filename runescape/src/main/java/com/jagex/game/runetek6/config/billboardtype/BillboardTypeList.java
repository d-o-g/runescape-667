package com.jagex.game.runetek6.config.billboardtype;

import com.jagex.core.datastruct.ref.ReferenceCache;
import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class BillboardTypeList {

    @OriginalMember(owner = "client!eq", name = "w", descriptor = "Lclient!dla;")
    public static final ReferenceCache recentUse = new ReferenceCache(64);

    @OriginalMember(owner = "client!ki", name = "h", descriptor = "Lclient!sb;")
    public static js5 configClient;

    @OriginalMember(owner = "client!ml", name = "c", descriptor = "(II)Lclient!uja;")
    public static BillboardType list(@OriginalArg(1) int id) {
        @Pc(10) BillboardType type = (BillboardType) recentUse.get(id);
        if (type != null) {
            return type;
        }

        @Pc(21) byte[] data = configClient.getfile(id, 0);
        type = new BillboardType();
        if (data != null) {
            type.decode(id, new Packet(data));
        }

        recentUse.put(type, id);
        return type;
    }

    private BillboardTypeList() {
        /* empty */
    }
}
