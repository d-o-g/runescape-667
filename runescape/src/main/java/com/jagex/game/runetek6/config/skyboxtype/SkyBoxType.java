package com.jagex.game.runetek6.config.skyboxtype;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ema")
public final class SkyBoxType {

    @OriginalMember(owner = "client!ema", name = "l", descriptor = "[I")
    public int[] sphereIds;

    @OriginalMember(owner = "client!ema", name = "b", descriptor = "I")
    public int anInt2621 = -1;

    @OriginalMember(owner = "client!ema", name = "m", descriptor = "I")
    public int anInt2624 = -1;

    @OriginalMember(owner = "client!ema", name = "g", descriptor = "I")
    public int texture = -1;

    @OriginalMember(owner = "client!ema", name = "h", descriptor = "I")
    public int anInt2625 = 0;

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(IILclient!ge;)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(2) Packet packet) {
        if (code == 1) {
            this.texture = packet.g2();
        } else if (code == 2) {
            this.sphereIds = new int[packet.g1()];
            for (@Pc(26) int local26 = 0; local26 < this.sphereIds.length; local26++) {
                this.sphereIds[local26] = packet.g2();
            }
        } else if (code == 3) {
            this.anInt2624 = packet.g1();
        } else if (code == 4) {
            this.anInt2625 = packet.g1();
        } else if (code == 5) {
            this.anInt2621 = packet.g2();
        }
    }

    @OriginalMember(owner = "client!ema", name = "a", descriptor = "(BLclient!ge;)V")
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
