package com.jagex.game.runetek6.config.invtype;

import com.jagex.core.datastruct.key.DoublyLinkedNode;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dba")
public final class InvType extends DoublyLinkedNode {

    @OriginalMember(owner = "client!dba", name = "v", descriptor = "I")
    public int size = 0;

    @OriginalMember(owner = "client!dba", name = "a", descriptor = "(ILclient!ge;B)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(1) Packet arg1) {
        if (code == 2) {
            this.size = arg1.g2();
        }
    }

    @OriginalMember(owner = "client!dba", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(11) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }
}
