package com.jagex.game;

import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vl")
public final class WearposDefaults {

    @OriginalMember(owner = "client!vl", name = "a", descriptor = "[I")
    public int[] animationHiddenLeftHandSlots;

    @OriginalMember(owner = "client!vl", name = "d", descriptor = "[I")
    public int[] animationHiddenRightHandSlots;

    @OriginalMember(owner = "client!vl", name = "j", descriptor = "[I")
    public int[] anIntArray821;

    @OriginalMember(owner = "client!vl", name = "h", descriptor = "I")
    public int rightHandSlot = -1;

    @OriginalMember(owner = "client!vl", name = "g", descriptor = "I")
    public int leftHandSlot = -1;


    @OriginalMember(owner = "client!vl", name = "<init>", descriptor = "(Lclient!sb;)V")
    public WearposDefaults(@OriginalArg(0) js5 arg0) {
        @Pc(12) byte[] local12 = arg0.getfile(6);
        this.method8929(new Packet(local12));
        if (this.anIntArray821 == null) {
            throw new RuntimeException("");
        }
    }

    @OriginalMember(owner = "client!vl", name = "<init>", descriptor = "()V")
    public WearposDefaults() {
        this.anIntArray821 = new int[0];
    }

    @OriginalMember(owner = "client!vl", name = "a", descriptor = "(ILclient!ge;)V")
    public void method8929(@OriginalArg(1) Packet arg0) {
        while (true) {
            @Pc(12) int local12 = arg0.g1();
            if (local12 == 0) {
                return;
            }
            @Pc(29) int local29;
            if (local12 == 1) {
                local29 = arg0.g1();
                this.anIntArray821 = new int[local29];
                for (@Pc(35) int local35 = 0; local35 < this.anIntArray821.length; local35++) {
                    this.anIntArray821[local35] = arg0.g1();
                }
            } else if (local12 == 3) {
                this.leftHandSlot = arg0.g1();
            } else if (local12 == 4) {
                this.rightHandSlot = arg0.g1();
            } else if (local12 == 5) {
                this.animationHiddenLeftHandSlots = new int[arg0.g1()];
                for (local29 = 0; local29 < this.animationHiddenLeftHandSlots.length; local29++) {
                    this.animationHiddenLeftHandSlots[local29] = arg0.g1();
                }
            } else if (local12 == 6) {
                this.animationHiddenRightHandSlots = new int[arg0.g1()];
                for (local29 = 0; local29 < this.animationHiddenRightHandSlots.length; local29++) {
                    this.animationHiddenRightHandSlots[local29] = arg0.g1();
                }
            }
        }
    }
}
