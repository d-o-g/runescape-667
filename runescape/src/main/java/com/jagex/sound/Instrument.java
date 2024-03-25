package com.jagex.sound;

import com.jagex.core.io.Packet;
import com.jagex.core.util.Arrays;
import com.jagex.sound.Envelope;
import com.jagex.sound.Filter;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Random;

@OriginalClass("client!ng")
public final class Instrument {

    @OriginalMember(owner = "client!ng", name = "k", descriptor = "[I")
    public static final int[] NOISE = new int[32768];

    @OriginalMember(owner = "client!ng", name = "l", descriptor = "[I")
    public static final int[] SINE;

    @OriginalMember(owner = "client!ng", name = "y", descriptor = "[I")
    public static final int[] output = new int[220500];

    @OriginalMember(owner = "client!ng", name = "h", descriptor = "[I")
    public static final int[] pitchStep = new int[5];

    @OriginalMember(owner = "client!ng", name = "x", descriptor = "[I")
    public static final int[] phases = new int[5];

    @OriginalMember(owner = "client!ng", name = "e", descriptor = "[I")
    public static final int[] pitchBaseStep = new int[5];

    @OriginalMember(owner = "client!ng", name = "b", descriptor = "[I")
    public static final int[] delays = new int[5];

    @OriginalMember(owner = "client!ng", name = "p", descriptor = "[I")
    public static final int[] volumeStep = new int[5];

    static {
        @Pc(7) Random random = new Random(0L);
        for (@Pc(9) int i = 0; i < 32768; i++) {
            NOISE[i] = (random.nextInt() & 0x2) - 1;
        }

        SINE = new int[32768];
        for (@Pc(28) int i = 0; i < 32768; i++) {
            SINE[i] = (int) (Math.sin((double) i / 5215.1903D) * 16384.0D);
        }
    }

    @OriginalMember(owner = "client!ng", name = "v", descriptor = "Lclient!kl;")
    public Envelope pitchModAmpEnvelope;

    @OriginalMember(owner = "client!ng", name = "a", descriptor = "Lclient!kl;")
    public Envelope volumeModAmpEnvelope;

    @OriginalMember(owner = "client!ng", name = "f", descriptor = "Lclient!kl;")
    public Envelope gatingReleaseEnvelope;

    @OriginalMember(owner = "client!ng", name = "s", descriptor = "Lclient!kl;")
    public Envelope gatingAttackEnvelope;

    @OriginalMember(owner = "client!ng", name = "t", descriptor = "Lclient!kl;")
    public Envelope pitchEnvelope;

    @OriginalMember(owner = "client!ng", name = "i", descriptor = "Lclient!kl;")
    public Envelope pitchModEnvelope;

    @OriginalMember(owner = "client!ng", name = "w", descriptor = "Lclient!lj;")
    public Filter filter;

    @OriginalMember(owner = "client!ng", name = "q", descriptor = "Lclient!kl;")
    public Envelope volumeEnvelope;

    @OriginalMember(owner = "client!ng", name = "c", descriptor = "Lclient!kl;")
    public Envelope filterEnvelope;

    @OriginalMember(owner = "client!ng", name = "u", descriptor = "Lclient!kl;")
    public Envelope volumeModEnvelope;

    @OriginalMember(owner = "client!ng", name = "m", descriptor = "[I")
    public final int[] oscillationVolume = new int[5];

    @OriginalMember(owner = "client!ng", name = "r", descriptor = "I")
    public int delayTime = 0;

    @OriginalMember(owner = "client!ng", name = "o", descriptor = "[I")
    public final int[] oscillationDelay = new int[5];

    @OriginalMember(owner = "client!ng", name = "n", descriptor = "I")
    public int start = 0;

    @OriginalMember(owner = "client!ng", name = "j", descriptor = "[I")
    public final int[] oscillationPitchDelta = new int[5];

    @OriginalMember(owner = "client!ng", name = "d", descriptor = "I")
    public int duration = 500;

    @OriginalMember(owner = "client!ng", name = "g", descriptor = "I")
    public int delayFeedback = 100;

    @OriginalMember(owner = "client!ng", name = "a", descriptor = "(Lclient!ge;)V")
    public void decode(@OriginalArg(0) Packet packet) {
        this.pitchEnvelope = new Envelope();
        this.pitchEnvelope.decode(packet);

        this.volumeEnvelope = new Envelope();
        this.volumeEnvelope.decode(packet);

        @Pc(21) int used = packet.g1();
        if (used != 0) {
            packet.pos--;

            this.pitchModEnvelope = new Envelope();
            this.pitchModEnvelope.decode(packet);

            this.pitchModAmpEnvelope = new Envelope();
            this.pitchModAmpEnvelope.decode(packet);
        }

        used = packet.g1();
        if (used != 0) {
            packet.pos--;

            this.volumeModEnvelope = new Envelope();
            this.volumeModEnvelope.decode(packet);

            this.volumeModAmpEnvelope = new Envelope();
            this.volumeModAmpEnvelope.decode(packet);
        }

        used = packet.g1();
        if (used != 0) {
            packet.pos--;

            this.gatingReleaseEnvelope = new Envelope();
            this.gatingReleaseEnvelope.decode(packet);

            this.gatingAttackEnvelope = new Envelope();
            this.gatingAttackEnvelope.decode(packet);
        }

        for (@Pc(109) int i = 0; i < 10; i++) {
            @Pc(114) int volume = packet.gsmart();
            if (volume == 0) {
                break;
            }

            this.oscillationVolume[i] = volume;
            this.oscillationPitchDelta[i] = packet.gsmarts();
            this.oscillationDelay[i] = packet.gsmart();
        }

        this.delayTime = packet.gsmart();
        this.delayFeedback = packet.gsmart();
        this.duration = packet.g2();
        this.start = packet.g2();

        this.filter = new Filter();
        this.filterEnvelope = new Envelope();
        this.filter.decode(packet, this.filterEnvelope);
    }

    @OriginalMember(owner = "client!ng", name = "a", descriptor = "(II)[I")
    public int[] sythnesise(@OriginalArg(0) int sampleCount, @OriginalArg(1) int deltaTime) {
        Arrays.clear(output, 0, sampleCount);
        if (deltaTime < 10) {
            return output;
        }

        @Pc(16) double d = (double) sampleCount / ((double) deltaTime + 0.0D);
        this.pitchEnvelope.reset();
        this.volumeEnvelope.reset();

        @Pc(24) int pitchModStep = 0;
        @Pc(26) int pitchModBaseStep = 0;
        @Pc(28) int pitchModPhase = 0;

        if (this.pitchModEnvelope != null) {
            this.pitchModEnvelope.reset();
            this.pitchModAmpEnvelope.reset();

            pitchModStep = (int) ((double) (this.pitchModEnvelope.end - this.pitchModEnvelope.start) * 32.768D / d);
            pitchModBaseStep = (int) ((double) this.pitchModEnvelope.start * 32.768D / d);
        }

        @Pc(63) int volumeModStep = 0;
        @Pc(65) int volumeModBaseStep = 0;
        @Pc(67) int volumeModPhase = 0;

        if (this.volumeModEnvelope != null) {
            this.volumeModEnvelope.reset();
            this.volumeModAmpEnvelope.reset();

            volumeModStep = (int) ((double) (this.volumeModEnvelope.end - this.volumeModEnvelope.start) * 32.768D / d);
            volumeModBaseStep = (int) ((double) this.volumeModEnvelope.start * 32.768D / d);
        }

        for (@Pc(102) int i = 0; i < 5; i++) {
            if (this.oscillationVolume[i] != 0) {
                phases[i] = 0;
                delays[i] = (int) ((double) this.oscillationDelay[i] * d);
                volumeStep[i] = (this.oscillationVolume[i] << 14) / 100;
                pitchStep[i] = (int) ((double) (this.pitchEnvelope.end - this.pitchEnvelope.start) * 32.768D * Math.pow(1.0057929410678534D, this.oscillationPitchDelta[i]) / d);
                pitchBaseStep[i] = (int) ((double) this.pitchEnvelope.start * 32.768D / d);
            }
        }

        for (@Pc(176) int i = 0; i < sampleCount; i++) {
            @Pc(182) int pitchChange = this.pitchEnvelope.step(sampleCount);
            @Pc(187) int volumeChange = this.volumeEnvelope.step(sampleCount);

            if (this.pitchModEnvelope != null) {
                @Pc(195) int mod = this.pitchModEnvelope.step(sampleCount);
                @Pc(200) int modAmp = this.pitchModAmpEnvelope.step(sampleCount);
                pitchChange += this.evaluateWave(pitchModPhase, modAmp, this.pitchModEnvelope.form) >> 1;
                pitchModPhase += (mod * pitchModStep >> 16) + pitchModBaseStep;
            }

            if (this.volumeModEnvelope != null) {
                @Pc(195) int mod = this.volumeModEnvelope.step(sampleCount);
                @Pc(200) int modAmp = this.volumeModAmpEnvelope.step(sampleCount);
                volumeChange = volumeChange * ((this.evaluateWave(volumeModPhase, modAmp, this.volumeModEnvelope.form) >> 1) + 32768) >> 15;
                volumeModPhase += (mod * volumeModStep >> 16) + volumeModBaseStep;
            }

            for (@Pc(195) int j = 0; j < 5; j++) {
                if (this.oscillationVolume[j] != 0) {
                    @Pc(200) int n = i + delays[j];

                    if (n < sampleCount) {
                        output[n] += this.evaluateWave(phases[j], volumeChange * volumeStep[j] >> 15, this.pitchEnvelope.form);
                        phases[j] += (pitchChange * pitchStep[j] >> 16) + pitchBaseStep[j];
                    }
                }
            }
        }

        if (this.gatingReleaseEnvelope != null) {
            this.gatingReleaseEnvelope.reset();
            this.gatingAttackEnvelope.reset();

            @Pc(182) int counter = 0;
            @Pc(339) boolean muted = true;

            for (@Pc(200) int i = 0; i < sampleCount; i++) {
                @Pc(347) int onStep = this.gatingReleaseEnvelope.step(sampleCount);
                @Pc(352) int offStep = this.gatingAttackEnvelope.step(sampleCount);

                @Pc(187) int threshold;
                if (muted) {
                    threshold = this.gatingReleaseEnvelope.start + ((this.gatingReleaseEnvelope.end - this.gatingReleaseEnvelope.start) * onStep >> 8);
                } else {
                    threshold = this.gatingReleaseEnvelope.start + ((this.gatingReleaseEnvelope.end - this.gatingReleaseEnvelope.start) * offStep >> 8);
                }

                counter += 256;

                if (counter >= threshold) {
                    counter = 0;
                    muted = !muted;
                }

                if (muted) {
                    output[i] = 0;
                }
            }
        }

        if (this.delayTime > 0 && this.delayFeedback > 0) {
            @Pc(182) int delay = (int) ((double) this.delayTime * d);

            for (@Pc(187) int i = delay; i < sampleCount; i++) {
                output[i] += (output[i - delay] * this.delayFeedback) / 100;
            }
        }

        if (this.filter.pairCounts[0] > 0 || this.filter.pairCounts[1] > 0) {
            this.filterEnvelope.reset();

            @Pc(182) int t = this.filterEnvelope.step(sampleCount + 1);
            @Pc(187) int M = this.filter.compute(0, (float) t / 65536.0F);
            @Pc(195) int N = this.filter.compute(1, (float) t / 65536.0F);

            if (sampleCount >= M + N) {
                @Pc(200) int n = 0;
                @Pc(347) int delay = N;

                if (N > sampleCount - M) {
                    delay = sampleCount - M;
                }

                while (n < delay) {
                    @Pc(352) int y = (int) ((long) output[n + M] * (long) Filter.invUnity >> 16);
                    for (@Pc(519) int i = 0; i < M; i++) {
                        y += (int) ((long) output[n + M - i - 1] * (long) Filter.coefficient[0][i] >> 16);
                    }
                    for (@Pc(549) int i = 0; i < n; i++) {
                        y -= (int) ((long) output[n - i - 1] * (long) Filter.coefficient[1][i] >> 16);
                    }

                    output[n] = y;
                    t = this.filterEnvelope.step(sampleCount + 1);
                    n++;
                }

                delay = 128;

                while (true) {
                    if (delay > sampleCount - M) {
                        delay = sampleCount - M;
                    }

                    while (n < delay) {
                        @Pc(352) int y = (int) ((long) output[n + M] * (long) Filter.invUnity >> 16);
                        for (@Pc(519) int i = 0; i < M; i++) {
                            y += (int) ((long) output[n + M - i - 1] * (long) Filter.coefficient[0][i] >> 16);
                        }
                        for (@Pc(549) int i = 0; i < N; i++) {
                            y -= (int) ((long) output[n - i - 1] * (long) Filter.coefficient[1][i] >> 16);
                        }

                        output[n] = y;
                        t = this.filterEnvelope.step(sampleCount + 1);
                        n++;
                    }

                    if (n >= sampleCount - M) {
                        while (n < sampleCount) {
                            @Pc(352) int y = 0;
                            for (@Pc(519) int local519 = n + M - sampleCount; local519 < M; local519++) {
                                y += (int) ((long) output[n + M - local519 - 1] * (long) Filter.coefficient[0][local519] >> 16);
                            }
                            for (@Pc(549) int local549 = 0; local549 < N; local549++) {
                                y -= (int) ((long) output[n - local549 - 1] * (long) Filter.coefficient[1][local549] >> 16);
                            }

                            output[n] = y;
                            t = this.filterEnvelope.step(sampleCount + 1);
                            n++;
                        }
                        break;
                    }

                    M = this.filter.compute(0, (float) t / 65536.0F);
                    N = this.filter.compute(1, (float) t / 65536.0F);
                    delay += 128;
                }
            }
        }

        for (@Pc(182) int y = 0; y < sampleCount; y++) {
            if (output[y] < -32768) {
                output[y] = -32768;
            }
            if (output[y] > 32767) {
                output[y] = 32767;
            }
        }
        return output;
    }

    @OriginalMember(owner = "client!ng", name = "a", descriptor = "(III)I")
    public int evaluateWave(@OriginalArg(0) int tphase, @OriginalArg(1) int amplitude, @OriginalArg(2) int table) {
        if (table == 1) {
            return (tphase & 0x7FFF) < 16384 ? amplitude : -amplitude;
        } else if (table == 2) {
            return SINE[tphase & 0x7FFF] * amplitude >> 14;
        } else if (table == 3) {
            return ((tphase & 0x7FFF) * amplitude >> 14) - amplitude;
        } else if (table == 4) {
            return NOISE[tphase / 2607 & 0x7FFF] * amplitude;
        } else {
            return 0;
        }
    }
}
