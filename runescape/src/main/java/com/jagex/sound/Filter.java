package com.jagex.sound;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lj")
public final class Filter {

    @OriginalMember(owner = "client!lj", name = "a", descriptor = "(F)F")
    private static float normalise(@OriginalArg(0) float f) {
        @Pc(7) float _f = (float) Math.pow(2.0D, f) * 32.703197F;
        return _f * 3.1415927F / 11025.0F;
    }

    @OriginalMember(owner = "client!lj", name = "h", descriptor = "[[F")
    public static final float[][] _coefficient = new float[2][8];

    @OriginalMember(owner = "client!lj", name = "e", descriptor = "[[I")
    public static final int[][] coefficient = new int[2][8];

    @OriginalMember(owner = "client!lj", name = "b", descriptor = "F")
    public static float _invUnity;

    @OriginalMember(owner = "client!lj", name = "d", descriptor = "I")
    public static int invUnity;

    @OriginalMember(owner = "client!lj", name = "a", descriptor = "[I")
    public final int[] unity = new int[2];

    @OriginalMember(owner = "client!lj", name = "f", descriptor = "[[[I")
    public final int[][][] pairMagnitude = new int[2][2][4];

    @OriginalMember(owner = "client!lj", name = "c", descriptor = "[I")
    public final int[] pairCounts = new int[2];

    @OriginalMember(owner = "client!lj", name = "g", descriptor = "[[[I")
    public final int[][][] pairPhase = new int[2][2][4];

    @OriginalMember(owner = "client!lj", name = "a", descriptor = "(IIF)F")
    public float adaptMagnitude(@OriginalArg(0) int direction, @OriginalArg(1) int phase, @OriginalArg(2) float off) {
        @Pc(30) float apha1 = (float) this.pairMagnitude[direction][0][phase] + (off * (float) (this.pairMagnitude[direction][1][phase] - this.pairMagnitude[direction][0][phase]));
        @Pc(34) float alpha2 = apha1 * 0.0015258789F;
        return 1.0F - (float) Math.pow(10.0D, -alpha2 / 20.0F);
    }

    @OriginalMember(owner = "client!lj", name = "a", descriptor = "(IF)I")
    public int compute(@OriginalArg(0) int direction, @OriginalArg(1) float off) {
        if (direction == 0) {
            @Pc(20) float local20 = (float) this.unity[0] + (float) (this.unity[1] - this.unity[0]) * off;
            @Pc(24) float local24 = local20 * 0.0030517578F;
            _invUnity = (float) Math.pow(0.1D, local24 / 20.0F);
            invUnity = (int) (_invUnity * 65536.0F);
        }

        if (this.pairCounts[direction] == 0) {
            return 0;
        }

        @Pc(20) float local20 = this.adaptMagnitude(direction, 0, off);
        _coefficient[direction][0] = -2.0F * local20 * (float) Math.cos(this.adaptPhase(direction, 0, off));
        _coefficient[direction][1] = local20 * local20;

        for (@Pc(77) int phase = 1; phase < this.pairCounts[direction]; phase++) {
            local20 = this.adaptMagnitude(direction, phase, off);
            @Pc(97) float a1 = -2.0F * local20 * (float) Math.cos(this.adaptPhase(direction, phase, off));
            @Pc(101) float a2 = local20 * local20;

            _coefficient[direction][phase * 2 + 1] = _coefficient[direction][phase * 2 - 1] * a2;
            _coefficient[direction][phase * 2] = _coefficient[direction][phase * 2 - 1] * a1 + _coefficient[direction][phase * 2 - 2] * a2;

            for (@Pc(157) int local157 = phase * 2 - 1; local157 >= 2; local157--) {
                _coefficient[direction][local157] += _coefficient[direction][local157 - 1] * a1 + _coefficient[direction][local157 - 2] * a2;
            }

            _coefficient[direction][1] += _coefficient[direction][0] * a1 + a2;
            _coefficient[direction][0] += a1;
        }

        if (direction == 0) {
            for (@Pc(226) int i = 0; i < this.pairCounts[0] * 2; i++) {
                _coefficient[0][i] *= _invUnity;
            }
        }

        for (@Pc(226) int i = 0; i < this.pairCounts[direction] * 2; i++) {
            coefficient[direction][i] = (int) (_coefficient[direction][i] * 65536.0F);
        }

        return this.pairCounts[direction] * 2;
    }

    @OriginalMember(owner = "client!lj", name = "a", descriptor = "(Lclient!ge;Lclient!kl;)V")
    public void decode(@OriginalArg(0) Packet packet, @OriginalArg(1) Envelope envelope) {
        @Pc(3) int pairCount = packet.g1();
        this.pairCounts[0] = pairCount >> 4;
        this.pairCounts[1] = pairCount & 0xF;

        if (pairCount == 0) {
            this.unity[0] = this.unity[1] = 0;
            return;
        }

        this.unity[0] = packet.g2();
        this.unity[1] = packet.g2();

        @Pc(37) int migrated = packet.g1();

        for (@Pc(39) int direction = 0; direction < 2; direction++) {
            for (@Pc(42) int term = 0; term < this.pairCounts[direction]; term++) {
                this.pairPhase[direction][0][term] = packet.g2();
                this.pairMagnitude[direction][0][term] = packet.g2();
            }
        }

        for (@Pc(42) int direction = 0; direction < 2; direction++) {
            for (@Pc(81) int phase = 0; phase < this.pairCounts[direction]; phase++) {
                if ((migrated & (0x1 << (direction * 4) << phase)) != 0) {
                    this.pairPhase[direction][1][phase] = packet.g2();
                    this.pairMagnitude[direction][1][phase] = packet.g2();
                } else {
                    this.pairPhase[direction][1][phase] = this.pairPhase[direction][0][phase];
                    this.pairMagnitude[direction][1][phase] = this.pairMagnitude[direction][0][phase];
                }
            }
        }

        if (migrated != 0 || this.unity[1] != this.unity[0]) {
            envelope.decodeShape(packet);
        }
    }

    @OriginalMember(owner = "client!lj", name = "b", descriptor = "(IIF)F")
    public float adaptPhase(@OriginalArg(0) int direction, @OriginalArg(1) int phase, @OriginalArg(2) float off) {
        @Pc(30) float f1 = (float) this.pairPhase[direction][0][phase] + (off * (float) (this.pairPhase[direction][1][phase] - this.pairPhase[direction][0][phase]));
        @Pc(34) float f2 = f1 * 1.2207031E-4F;
        return normalise(f2);
    }
}
