package com.jagex.game.runetek6.config.paramtype;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Cp1252;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!po")
public final class ParamType {

    @OriginalMember(owner = "client!po", name = "c", descriptor = "I")
    public int defaultint;

    @OriginalMember(owner = "client!po", name = "a", descriptor = "C")
    public char type;

    @OriginalMember(owner = "client!po", name = "g", descriptor = "Ljava/lang/String;")
    public String defaultstr;

    @OriginalMember(owner = "client!po", name = "e", descriptor = "Z")
    public boolean autodisable = true;

    @OriginalMember(owner = "client!po", name = "b", descriptor = "(B)Z")
    public boolean isString() {
        return this.type == 's';
    }

    @OriginalMember(owner = "client!po", name = "a", descriptor = "(Lclient!ge;B)V")
    public void decode(@OriginalArg(0) Packet packet) {
        while (true) {
            @Pc(3) int code = packet.g1();
            if (code == 0) {
                return;
            }
            this.decode(code, packet);
        }
    }

    @OriginalMember(owner = "client!po", name = "a", descriptor = "(IILclient!ge;)V")
    public void decode(@OriginalArg(1) int code, @OriginalArg(2) Packet packet) {
        if (code == 1) {
            this.type = Cp1252.decodeChar(packet.g1b());
        } else if (code == 2) {
            this.defaultint = packet.g4();
        } else if (code == 4) {
            this.autodisable = false;
        } else if (code == 5) {
            this.defaultstr = packet.gjstr();
        }
    }
}
