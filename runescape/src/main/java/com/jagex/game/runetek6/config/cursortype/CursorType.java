package com.jagex.game.runetek6.config.cursortype;

import com.jagex.IndexedImage;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vla")
public final class CursorType {

    @OriginalMember(owner = "client!vla", name = "c", descriptor = "I")
    public int hotspotx;

    @OriginalMember(owner = "client!vla", name = "f", descriptor = "I")
    public int graphic;

    @OriginalMember(owner = "client!vla", name = "b", descriptor = "Lclient!nv;")
    public CursorTypeList myList;

    @OriginalMember(owner = "client!vla", name = "d", descriptor = "I")
    public int hotspoty;

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(Lclient!ge;II)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.graphic = packet.g2();
        } else if (code == 2) {
            this.hotspotx = packet.g1();
            this.hotspoty = packet.g1();
        } else {
            // logger.info("Error unrecognised .cursor config code: {}", (Object)Integer.valueOf(var2));
        }
    }

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(B)Lclient!wp;")
    public synchronized IndexedImage getCursor() {
        @Pc(13) IndexedImage cursor = (IndexedImage) this.myList.cursorCache.get(this.graphic);
        if (cursor != null) {
            return cursor;
        }
        cursor = IndexedImage.loadFirst(this.myList.aJs5_88, this.graphic, 0);
        if (cursor != null) {
            this.myList.cursorCache.put(cursor, this.graphic);
        }
        return cursor;
    }

    @OriginalMember(owner = "client!vla", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(16) int code = packet.g1();
            if (code == 0) {
                return;
            }
            this.decode(packet, code);
        }
    }
}
