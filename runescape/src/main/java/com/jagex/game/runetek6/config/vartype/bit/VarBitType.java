package com.jagex.game.runetek6.config.vartype.bit;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!eea")
public final class VarBitType {

    @OriginalMember(owner = "client!iba", name = "j", descriptor = "[I")
    public static final int[] masklookup = new int[32];

    static {
        @Pc(73) int n = 2;

        for (@Pc(75) int i = 0; i < masklookup.length; i++) {
            masklookup[i] = n - 1;
            n += n;
        }
    }

    @OriginalMember(owner = "client!eea", name = "b", descriptor = "I")
    public int startBit;

    @OriginalMember(owner = "client!eea", name = "e", descriptor = "I")
    public int endBit;

    @OriginalMember(owner = "client!eea", name = "a", descriptor = "I")
    public int baseVar;

    @OriginalMember(owner = "client!eea", name = "a", descriptor = "(ILclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(11) int decode = packet.g1();
            if (decode == 0) {
                return;
            }

            this.decode(packet, decode);
        }
    }

    @OriginalMember(owner = "client!eea", name = "a", descriptor = "(ILclient!ge;I)V")
    public void decode(@OriginalArg(1) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.baseVar = packet.g2();
            this.startBit = packet.g1();
            this.endBit = packet.g1();
        }
    }
}
