package com.jagex.sound.vorbis;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!tr")
public final class VorbisMapping {

    @OriginalMember(owner = "client!tr", name = "a", descriptor = "I")
    public final int anInt9477;

    @OriginalMember(owner = "client!tr", name = "d", descriptor = "I")
    public int mux;

    @OriginalMember(owner = "client!tr", name = "b", descriptor = "[I")
    public final int[] submapFloor;

    @OriginalMember(owner = "client!tr", name = "c", descriptor = "[I")
    public final int[] submapResidue;

    @OriginalMember(owner = "client!tr", name = "<init>", descriptor = "()V")
    public VorbisMapping() {
        VorbisSound.gbit(16);
        this.anInt9477 = VorbisSound.g1() == 0 ? 1 : VorbisSound.gbit(4) + 1;
        if (VorbisSound.g1() != 0) {
            VorbisSound.gbit(8);
        }
        VorbisSound.gbit(2);
        if (this.anInt9477 > 1) {
            this.mux = VorbisSound.gbit(4);
        }
        this.submapFloor = new int[this.anInt9477];
        this.submapResidue = new int[this.anInt9477];
        for (@Pc(42) int local42 = 0; local42 < this.anInt9477; local42++) {
            VorbisSound.gbit(8);
            this.submapFloor[local42] = VorbisSound.gbit(8);
            this.submapResidue[local42] = VorbisSound.gbit(8);
        }
    }
}
