package com.jagex.sound;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!kl")
public final class Envelope {

    @OriginalMember(owner = "client!kl", name = "j", descriptor = "I")
    public int start;

    @OriginalMember(owner = "client!kl", name = "h", descriptor = "I")
    public int end;

    @OriginalMember(owner = "client!kl", name = "e", descriptor = "I")
    public int form;

    @OriginalMember(owner = "client!kl", name = "g", descriptor = "I")
    public int anInt5478;

    @OriginalMember(owner = "client!kl", name = "i", descriptor = "I")
    public int anInt5479;

    @OriginalMember(owner = "client!kl", name = "c", descriptor = "I")
    public int anInt5480;

    @OriginalMember(owner = "client!kl", name = "a", descriptor = "I")
    public int anInt5481;

    @OriginalMember(owner = "client!kl", name = "b", descriptor = "I")
    public int anInt5482;

    @OriginalMember(owner = "client!kl", name = "k", descriptor = "I")
    public int anInt5474 = 2;

    @OriginalMember(owner = "client!kl", name = "d", descriptor = "[I")
    public int[] anIntArray407 = new int[2];

    @OriginalMember(owner = "client!kl", name = "f", descriptor = "[I")
    public int[] anIntArray408 = new int[2];

    @OriginalMember(owner = "client!kl", name = "<init>", descriptor = "()V")
    public Envelope() {
        this.anIntArray407[0] = 0;
        this.anIntArray407[1] = 65535;
        this.anIntArray408[0] = 0;
        this.anIntArray408[1] = 65535;
    }

    @OriginalMember(owner = "client!kl", name = "a", descriptor = "(Lclient!ge;)V")
    public void decodeShape(@OriginalArg(0) Packet packet) {
        this.anInt5474 = packet.g1();
        this.anIntArray407 = new int[this.anInt5474];
        this.anIntArray408 = new int[this.anInt5474];

        for (@Pc(16) int i = 0; i < this.anInt5474; i++) {
            this.anIntArray407[i] = packet.g2();
            this.anIntArray408[i] = packet.g2();
        }
    }

    @OriginalMember(owner = "client!kl", name = "a", descriptor = "()V")
    public void reset() {
        this.anInt5480 = 0;
        this.anInt5478 = 0;
        this.anInt5482 = 0;
        this.anInt5479 = 0;
        this.anInt5481 = 0;
    }

    @OriginalMember(owner = "client!kl", name = "a", descriptor = "(I)I")
    public int step(@OriginalArg(0) int arg0) {
        if (this.anInt5481 >= this.anInt5480) {
            this.anInt5479 = this.anIntArray408[this.anInt5478++] << 15;
            if (this.anInt5478 >= this.anInt5474) {
                this.anInt5478 = this.anInt5474 - 1;
            }
            this.anInt5480 = (int) ((double) this.anIntArray407[this.anInt5478] / 65536.0D * (double) arg0);
            if (this.anInt5480 > this.anInt5481) {
                this.anInt5482 = ((this.anIntArray408[this.anInt5478] << 15) - this.anInt5479) / (this.anInt5480 - this.anInt5481);
            }
        }
        this.anInt5479 += this.anInt5482;
        this.anInt5481++;
        return this.anInt5479 - this.anInt5482 >> 15;
    }

    @OriginalMember(owner = "client!kl", name = "b", descriptor = "(Lclient!ge;)V")
    public void decode(@OriginalArg(0) Packet packet) {
        this.form = packet.g1();
        this.start = packet.g4();
        this.end = packet.g4();
        this.decodeShape(packet);
    }
}
