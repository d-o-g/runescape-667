package com.jagex.game.runetek6.config.effectortype;

import com.jagex.core.io.Packet;
import com.jagex.math.Trig1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ok")
public final class ParticleEffectorType {

    @OriginalMember(owner = "client!ok", name = "d", descriptor = "I")
    public int strength;

    @OriginalMember(owner = "client!ok", name = "f", descriptor = "I")
    public int dirZ;

    @OriginalMember(owner = "client!ok", name = "b", descriptor = "I")
    public int cosTheta;

    @OriginalMember(owner = "client!ok", name = "n", descriptor = "J")
    public long maxRange;

    @OriginalMember(owner = "client!ok", name = "c", descriptor = "I")
    public int dirX;

    @OriginalMember(owner = "client!ok", name = "j", descriptor = "I")
    public int id;

    @OriginalMember(owner = "client!ok", name = "m", descriptor = "I")
    public int visibility;

    @OriginalMember(owner = "client!ok", name = "l", descriptor = "I")
    public int effectType;

    @OriginalMember(owner = "client!ok", name = "a", descriptor = "I")
    public int dirLength;

    @OriginalMember(owner = "client!ok", name = "e", descriptor = "I")
    public int dirY;

    @OriginalMember(owner = "client!ok", name = "k", descriptor = "I")
    public int angle;

    @OriginalMember(owner = "client!ok", name = "h", descriptor = "I")
    public int constantSpeed = 0;

    @OriginalMember(owner = "client!ok", name = "t", descriptor = "I")
    public int constantStrength = 0;

    @OriginalMember(owner = "client!ok", name = "i", descriptor = "Z")
    public boolean attract = false;

    @OriginalMember(owner = "client!ok", name = "a", descriptor = "(Lclient!ge;II)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(2) int code) {
        if (code == 1) {
            this.angle = packet.g2();
        } else if (code == 2) {
            packet.g1();
        } else if (code == 3) {
            this.dirX = packet.g4();
            this.dirY = packet.g4();
            this.dirZ = packet.g4();
        } else if (code == 4) {
            this.effectType = packet.g1();
            this.strength = packet.g4();
        } else if (code == 6) {
            this.visibility = packet.g1();
        } else if (code == 8) {
            this.constantSpeed = 1;
        } else if (code == 9) {
            this.constantStrength = 1;
        } else if (code == 10) {
            this.attract = true;
        }
    }

    @OriginalMember(owner = "client!ok", name = "b", descriptor = "(B)V")
    public void postDecode() {
        this.cosTheta = Trig1.COS[this.angle << 3];

        @Pc(15) long x = (long) this.dirX;
        @Pc(19) long y = (long) this.dirY;
        @Pc(23) long z = (long) this.dirZ;

        this.dirLength = (int) Math.sqrt((double) ((x * x) + (y * y) + (z * z)));

        if (this.strength == 0) {
            this.strength = 1;
        }

        if (this.effectType == 0) {
            this.maxRange = Integer.MAX_VALUE;
        } else if (this.effectType == 1) {
            this.maxRange = (long) ((this.dirLength * 8) / this.strength);
            this.maxRange *= this.maxRange;
        } else if (this.effectType == 2) {
            this.maxRange = (long) ((this.dirLength * 8) / this.strength);
        }

        if (this.attract) {
            this.dirLength *= -1;
        }
    }

    @OriginalMember(owner = "client!ok", name = "a", descriptor = "(BLclient!ge;)V")
    public void decode(@OriginalArg(1) Packet packet) {
        while (true) {
            @Pc(17) int code = packet.g1();
            if (code == 0) {
                return;
            }
            this.decode(packet, code);
        }
    }
}
