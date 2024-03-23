package com.jagex.game.runetek6.config.vartype.clan;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fc")
public final class VarClanSettingType {

    @OriginalMember(owner = "client!fc", name = "b", descriptor = "C")
    public char dataType;

    @OriginalMember(owner = "client!fc", name = "c", descriptor = "I")
    public int start;

    @OriginalMember(owner = "client!fc", name = "d", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!fc", name = "f", descriptor = "I")
    public int end;

    @OriginalMember(owner = "client!fc", name = "a", descriptor = "(ILclient!ge;B)V")
    public void decode(@OriginalArg(0) int arg0, @OriginalArg(1) Packet arg1) {
        if (arg0 == 1) {
            this.dataType = Cp1252.decode(arg1.g1b());
        } else if (arg0 == 3) {
            this.id = arg1.g2();
            this.start = arg1.g1();
            this.end = arg1.g1();
        }
    }

    @OriginalMember(owner = "client!fc", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(3) int code = packet.g1();
            if (code == 0) {
                return;
            }

            this.decode(code, packet);
        }
    }
}
