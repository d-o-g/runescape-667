package com.jagex.game.runetek6.config.defaults;

import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vl")
public final class WearposDefaults {

    @OriginalMember(owner = "client!dt", name = "a", descriptor = "Lclient!vl;")
    public static WearposDefaults instance;

    @OriginalMember(owner = "client!vl", name = "a", descriptor = "[I")
    public int[] animationHiddenLeftHandSlots;

    @OriginalMember(owner = "client!vl", name = "d", descriptor = "[I")
    public int[] animationHiddenRightHandSlots;

    @OriginalMember(owner = "client!vl", name = "j", descriptor = "[I")
    public int[] hidden;

    @OriginalMember(owner = "client!vl", name = "h", descriptor = "I")
    public int rightHandSlot = -1;

    @OriginalMember(owner = "client!vl", name = "g", descriptor = "I")
    public int leftHandSlot = -1;

    @OriginalMember(owner = "client!vl", name = "<init>", descriptor = "(Lclient!sb;)V")
    public WearposDefaults(@OriginalArg(0) js5 js5) {
        @Pc(12) byte[] data = js5.getfile(6);
        this.decode(new Packet(data));

        if (this.hidden == null) {
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!vl", name = "<init>", descriptor = "()V")
    public WearposDefaults() {
        this.hidden = new int[0];
    }

    @OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(12) int code = packet.g1();
            if (code == 0) {
                return;
            }

            if (code == 1) {
                @Pc(29) int count = packet.g1();
                this.hidden = new int[count];
                for (@Pc(35) int i = 0; i < this.hidden.length; i++) {
                    this.hidden[i] = packet.g1();
                }
            } else if (code == 3) {
                this.leftHandSlot = packet.g1();
            } else if (code == 4) {
                this.rightHandSlot = packet.g1();
            } else if (code == 5) {
                this.animationHiddenLeftHandSlots = new int[packet.g1()];
                for (@Pc(29) int i = 0; i < this.animationHiddenLeftHandSlots.length; i++) {
                    this.animationHiddenLeftHandSlots[i] = packet.g1();
                }
            } else if (code == 6) {
                this.animationHiddenRightHandSlots = new int[packet.g1()];
                for (@Pc(29) int i = 0; i < this.animationHiddenRightHandSlots.length; i++) {
                    this.animationHiddenRightHandSlots[i] = packet.g1();
                }
            }
        }
    }
}
