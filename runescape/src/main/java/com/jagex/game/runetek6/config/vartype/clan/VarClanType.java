package com.jagex.game.runetek6.config.vartype.clan;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sla")
public final class VarClanType {

    @OriginalMember(owner = "client!sla", name = "h", descriptor = "I")
    public int startBit;

    @OriginalMember(owner = "client!sla", name = "g", descriptor = "I")
    public int baseVar;

    @OriginalMember(owner = "client!sla", name = "a", descriptor = "C")
    public char dataType;

    @OriginalMember(owner = "client!sla", name = "e", descriptor = "I")
    public int endBit;

    @OriginalMember(owner = "client!sla", name = "a", descriptor = "(ILclient!ge;Z)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(1) Packet packet) {
        if (code == 1) {
            this.dataType = Cp1252.decode(packet.g1b());
        } else if (code == 2) {
            this.baseVar = packet.g2();
            this.startBit = packet.g1();
            this.endBit = packet.g1();
        }
    }

    @OriginalMember(owner = "client!sla", name = "a", descriptor = "(Lclient!ge;I)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(14) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }
}
