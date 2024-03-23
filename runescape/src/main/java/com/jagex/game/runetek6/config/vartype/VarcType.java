package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!paa")
public final class VarcType {

    @OriginalMember(owner = "client!paa", name = "g", descriptor = "C")
    public char dataType;

    @OriginalMember(owner = "client!paa", name = "f", descriptor = "I")
    public int temporary = 1;

    @OriginalMember(owner = "client!paa", name = "a", descriptor = "(ILclient!ge;B)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(1) Packet packet) {
        if (code == 1) {
            this.dataType = Cp1252.decode(packet.g1b());
        } else if (code == 2) {
            this.temporary = 0;
        }
    }

    @OriginalMember(owner = "client!paa", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(13) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }
}
