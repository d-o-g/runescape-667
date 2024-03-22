package com.jagex.game.runetek6.config.vartype.player;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!rha")
public final class VarPlayerType {

    @OriginalMember(owner = "client!rha", name = "a", descriptor = "I")
    public int clientCode = 0;

    @OriginalMember(owner = "client!rha", name = "a", descriptor = "(BLclient!ge;I)V")
    public void decode(@OriginalArg(1) Packet packet, @OriginalArg(2) int code) {
        if (code == 5) {
            this.clientCode = packet.g2();
        }
    }

    @OriginalMember(owner = "client!rha", name = "a", descriptor = "(Lclient!ge;B)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(7) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(packet, code);
        }
    }
}
