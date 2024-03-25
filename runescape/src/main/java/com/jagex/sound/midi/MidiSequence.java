package com.jagex.sound.midi;

import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import static com.jagex.sound.midi.Midi.TRACK_HEADER;

@OriginalClass("client!bha")
public final class MidiSequence {

    @OriginalMember(owner = "client!bha", name = "c", descriptor = "[B")
    public static final byte[] EVENT_LENGTHS = {
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    @OriginalMember(owner = "client!bha", name = "e", descriptor = "[I")
    public int[] trackDeltas;

    @OriginalMember(owner = "client!bha", name = "b", descriptor = "J")
    public long globalDelay;

    @OriginalMember(owner = "client!bha", name = "d", descriptor = "[I")
    public int[] trackOffsets;

    @OriginalMember(owner = "client!bha", name = "g", descriptor = "I")
    public int timeDivision;

    @OriginalMember(owner = "client!bha", name = "f", descriptor = "I")
    public int tempo;

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "[I")
    public int[] tracks;

    @OriginalMember(owner = "client!bha", name = "i", descriptor = "[I")
    public int[] eventHistory;

    @OriginalMember(owner = "client!bha", name = "h", descriptor = "Lclient!ge;")
    public final Packet packet = new Packet(null);

    @OriginalMember(owner = "client!bha", name = "<init>", descriptor = "()V")
    public MidiSequence() {
    }

    @OriginalMember(owner = "client!bha", name = "<init>", descriptor = "([B)V")
    public MidiSequence(@OriginalArg(0) byte[] data) {
        this.decode(data);
    }

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "()Z")
    public boolean isPlaying() {
        return this.packet.data != null;
    }

    @OriginalMember(owner = "client!bha", name = "c", descriptor = "(I)J")
    public long delayForDelta(@OriginalArg(0) int delta) {
        return this.globalDelay + ((long) delta * (long) this.tempo);
    }

    @OriginalMember(owner = "client!bha", name = "b", descriptor = "(I)I")
    public int nextEvent(@OriginalArg(0) int track) {
        return this.nextEventData(track);
    }

    @OriginalMember(owner = "client!bha", name = "f", descriptor = "(I)V")
    public void updatePosition(@OriginalArg(0) int track) {
        this.tracks[track] = this.packet.pos;
    }

    @OriginalMember(owner = "client!bha", name = "f", descriptor = "()V")
    public void finish() {
        this.packet.data = null;
        this.trackOffsets = null;
        this.tracks = null;
        this.trackDeltas = null;
        this.eventHistory = null;
    }

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "(II)I")
    public int nextEventData(@OriginalArg(0) int track, @OriginalArg(1) int event) {
        if (event == 255) {
            @Pc(7) int type = this.packet.g1();
            @Pc(12) int length = this.packet.gVarInt();

            if (type == 47) {
                this.packet.pos += length;
                return 1;
            } else if (type == 81) {
                @Pc(32) int newTempo = this.packet.g3();
                length -= 3;

                @Pc(38) int delta = this.trackDeltas[track];
                this.globalDelay += (long) delta * (long) (this.tempo - newTempo);
                this.tempo = newTempo;
                this.packet.pos += length;
                return 2;
            } else {
                this.packet.pos += length;
                return 3;
            }
        } else {
            @Pc(78) byte length = EVENT_LENGTHS[event - 128];

            @Pc(12) int value = event;
            if (length >= 1) {
                value = event | this.packet.g1() << 8;
            }
            if (length >= 2) {
                value |= this.packet.g1() << 16;
            }

            return value;
        }
    }

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "([B)V")
    public void decode(@OriginalArg(0) byte[] data) {
        this.packet.data = data;
        this.packet.pos = 10;

        @Pc(12) int tracks = this.packet.g2();
        this.timeDivision = this.packet.g2();

        this.tempo = 500000;
        this.trackOffsets = new int[tracks];

        @Pc(27) int t = 0;
        while (t < tracks) {
            @Pc(33) int chunkId = this.packet.g4();
            @Pc(38) int chunkSize = this.packet.g4();

            if (chunkId == TRACK_HEADER) {
                this.trackOffsets[t] = this.packet.pos;
                t++;
            }

            this.packet.pos += chunkSize;
        }

        this.globalDelay = 0L;

        this.tracks = new int[tracks];
        for (@Pc(33) int i = 0; i < tracks; i++) {
            this.tracks[i] = this.trackOffsets[i];
        }

        this.trackDeltas = new int[tracks];
        this.eventHistory = new int[tracks];
    }

    @OriginalMember(owner = "client!bha", name = "c", descriptor = "()I")
    public int activeTrack() {
        @Pc(3) int count = this.tracks.length;
        @Pc(5) int track = -1;
        @Pc(7) int min = Integer.MAX_VALUE;
        for (@Pc(9) int i = 0; i < count; i++) {
            if (this.tracks[i] >= 0 && this.trackDeltas[i] < min) {
                track = i;
                min = this.trackDeltas[i];
            }
        }
        return track;
    }

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "(I)V")
    public void switchTrack(@OriginalArg(0) int arg0) {
        this.packet.pos = this.tracks[arg0];
    }

    @OriginalMember(owner = "client!bha", name = "d", descriptor = "()V")
    public void endTrack() {
        this.packet.pos = -1;
    }

    @OriginalMember(owner = "client!bha", name = "a", descriptor = "(J)V")
    public void reset(@OriginalArg(0) long delay) {
        this.globalDelay = delay;

        @Pc(6) int count = this.tracks.length;
        for (@Pc(8) int i = 0; i < count; i++) {
            this.trackDeltas[i] = 0;
            this.eventHistory[i] = 0;
            this.packet.pos = this.trackOffsets[i];
            this.step(i);
            this.tracks[i] = this.packet.pos;
        }
    }

    @OriginalMember(owner = "client!bha", name = "d", descriptor = "(I)I")
    public int nextEventData(@OriginalArg(0) int track) {
        @Pc(7) byte event = this.packet.data[this.packet.pos];

        @Pc(13) int historicalEvent;
        if (event < 0) {
            historicalEvent = event & 0xFF;
            this.eventHistory[track] = historicalEvent;
            this.packet.pos++;
        } else {
            historicalEvent = this.eventHistory[track];
        }

        if (historicalEvent != 240 && historicalEvent != 247) {
            return this.nextEventData(track, historicalEvent);
        }

        @Pc(42) int length = this.packet.gVarInt();
        if (historicalEvent == 0xf7 && length > 0) {
            @Pc(57) int nextEvent = this.packet.data[this.packet.pos] & 0xFF;

            if (nextEvent >= 241 && nextEvent <= 243 || nextEvent == 246 || nextEvent == 248 || nextEvent >= 250 && nextEvent <= 252 || nextEvent == 254) {
                this.packet.pos++;
                this.eventHistory[track] = nextEvent;
                return this.nextEventData(track, nextEvent);
            }
        }

        this.packet.pos += length;
        return 0;
    }

    @OriginalMember(owner = "client!bha", name = "b", descriptor = "()Z")
    public boolean isComplete() {
        @Pc(3) int count = this.tracks.length;
        for (@Pc(5) int i = 0; i < count; i++) {
            if (this.tracks[i] >= 0) {
                return false;
            }
        }
        return true;
    }

    @OriginalMember(owner = "client!bha", name = "e", descriptor = "(I)V")
    public void step(@OriginalArg(0) int track) {
        @Pc(4) int deltaTime = this.packet.gVarInt();
        this.trackDeltas[track] += deltaTime;
    }

    @OriginalMember(owner = "client!bha", name = "g", descriptor = "()I")
    public int trackCount() {
        return this.tracks.length;
    }
}
