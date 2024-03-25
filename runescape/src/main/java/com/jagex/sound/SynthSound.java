package com.jagex.sound;

import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dw")
public final class SynthSound {

    public static final int INSTRUMENT_COUNT = 10;

    @OriginalMember(owner = "client!dw", name = "a", descriptor = "(Lclient!sb;II)Lclient!dw;")
    public static SynthSound get(@OriginalArg(0) js5 synthSounds, @OriginalArg(1) int groupId, @OriginalArg(2) int fileId) {
        @Pc(5) byte[] data = synthSounds.getfile(fileId, groupId);
        return data == null ? null : new SynthSound(new Packet(data));
    }

    @OriginalMember(owner = "client!dw", name = "a", descriptor = "[Lclient!ng;")
    public final Instrument[] instruments = new Instrument[INSTRUMENT_COUNT];

    @OriginalMember(owner = "client!dw", name = "c", descriptor = "I")
    public int loopStart;

    @OriginalMember(owner = "client!dw", name = "b", descriptor = "I")
    public int loopEnd;

    @OriginalMember(owner = "client!dw", name = "<init>", descriptor = "(Lclient!ge;)V")
    public SynthSound(@OriginalArg(0) Packet packet) {
        for (@Pc(7) int instrument = 0; instrument < INSTRUMENT_COUNT; instrument++) {
            @Pc(12) int active = packet.g1();

            if (active != 0) {
                packet.pos--;
                this.instruments[instrument] = new Instrument();
                this.instruments[instrument].decode(packet);
            }
        }

        this.loopStart = packet.g2();
        this.loopEnd = packet.g2();
    }

    @OriginalMember(owner = "client!dw", name = "<init>", descriptor = "()V")
    public SynthSound() {
    }

    @OriginalMember(owner = "client!dw", name = "b", descriptor = "()[B")
    public byte[] mix() {
        @Pc(1) int maxDuration = 0;
        for (@Pc(3) int i = 0; i < INSTRUMENT_COUNT; i++) {
            if (this.instruments[i] != null && this.instruments[i].duration + this.instruments[i].start > maxDuration) {
                maxDuration = this.instruments[i].duration + this.instruments[i].start;
            }
        }

        if (maxDuration == 0) {
            return new byte[0];
        }

        @Pc(49) int sampleCount = (maxDuration * 22050) / 1000;
        @Pc(52) byte[] mixed = new byte[sampleCount];

        for (@Pc(54) int i = 0; i < INSTRUMENT_COUNT; i++) {
            if (this.instruments[i] == null) {
                continue;
            }

            @Pc(70) int instrumentSamples = this.instruments[i].duration * 22050 / 1000;
            @Pc(80) int instrumentOffset = this.instruments[i].start * 22050 / 1000;
            @Pc(92) int[] samples = this.instruments[i].sythnesise(instrumentSamples, this.instruments[i].duration);

            for (@Pc(94) int j = 0; j < instrumentSamples; j++) {
                @Pc(107) int out = mixed[j + instrumentOffset] + (samples[j] >> 8);

                if (((out + 128) & 0xFFFFFF00) != 0) {
                    out = out >> 31 ^ 0x7F;
                }

                mixed[j + instrumentOffset] = (byte) out;
            }
        }

        return mixed;
    }

    @OriginalMember(owner = "client!dw", name = "c", descriptor = "()Lclient!sq;")
    public VariableRateSoundPacket sample() {
        @Pc(2) byte[] mixed = this.mix();
        return new VariableRateSoundPacket(22050, mixed, this.loopStart * 22050 / 1000, this.loopEnd * 22050 / 1000);
    }

    @OriginalMember(owner = "client!dw", name = "a", descriptor = "()I")
    public int delay() {
        @Pc(1) int offset = 9999999;
        for (@Pc(3) int i = 0; i < INSTRUMENT_COUNT; i++) {
            if (this.instruments[i] != null && this.instruments[i].start / 20 < offset) {
                offset = this.instruments[i].start / 20;
            }
        }

        if (this.loopStart < this.loopEnd && this.loopStart / 20 < offset) {
            offset = this.loopStart / 20;
        }

        if (offset == 9999999 || offset == 0) {
            return 0;
        }

        for (@Pc(55) int i = 0; i < INSTRUMENT_COUNT; i++) {
            if (this.instruments[i] != null) {
                this.instruments[i].start -= offset * 20;
            }
        }

        if (this.loopStart < this.loopEnd) {
            this.loopStart -= offset * 20;
            this.loopEnd -= offset * 20;
        }

        return offset;
    }
}
