package com.jagex.game.runetek6.config.skyboxspheretype;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!afa")
public final class SkyBoxSphereType {

    @OriginalMember(owner = "client!afa", name = "n", descriptor = "I")
    public int anInt124;

    @OriginalMember(owner = "client!afa", name = "o", descriptor = "I")
    public int anInt125;

    @OriginalMember(owner = "client!afa", name = "f", descriptor = "I")
    public int anInt126;

    @OriginalMember(owner = "client!afa", name = "l", descriptor = "I")
    public int anInt128;

    @OriginalMember(owner = "client!afa", name = "e", descriptor = "I")
    public int anInt129;

    @OriginalMember(owner = "client!afa", name = "g", descriptor = "I")
    public int anInt130;

    @OriginalMember(owner = "client!afa", name = "j", descriptor = "I")
    public int anInt132;

    @OriginalMember(owner = "client!afa", name = "d", descriptor = "I")
    public int anInt133;

    @OriginalMember(owner = "client!afa", name = "m", descriptor = "Z")
    public boolean aBoolean10;

    @OriginalMember(owner = "client!afa", name = "i", descriptor = "I")
    public int anInt123 = 8;

    @OriginalMember(owner = "client!afa", name = "k", descriptor = "I")
    public int anInt131 = 0xFFFFFF;

    @OriginalMember(owner = "client!afa", name = "a", descriptor = "(ILclient!ge;I)V")
    public void decode(@OriginalArg(0) int code, @OriginalArg(1) Packet packet) {
        if (code == 1) {
            this.anInt123 = packet.g2();
        } else if (code == 2) {
            this.aBoolean10 = true;
        } else if (code == 3) {
            this.anInt125 = packet.g2s();
            this.anInt130 = packet.g2s();
            this.anInt132 = packet.g2s();
        } else if (code == 4) {
            this.anInt129 = packet.g1();
        } else if (code == 5) {
            this.anInt124 = packet.g2();
        } else if (code == 6) {
            this.anInt131 = packet.g3();
        } else if (code == 7) {
            this.anInt128 = packet.g2s();
            this.anInt133 = packet.g2s();
            this.anInt126 = packet.g2s();
        }
    }

    @OriginalMember(owner = "client!afa", name = "a", descriptor = "(Lclient!ge;I)V")
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
