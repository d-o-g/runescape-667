package com.jagex.game.runetek6.sound;

import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.Utf8;
import com.jagex.game.runetek6.sound.OggStream;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!un")
public final class OggKateStream extends OggStream {

    @OriginalMember(owner = "client!un", name = "J", descriptor = "Ljava/lang/String;")
    public String subtitle;

    @OriginalMember(owner = "client!un", name = "D", descriptor = "Ljava/lang/String;")
    public String language;

    @OriginalMember(owner = "client!un", name = "w", descriptor = "I")
    public int granuleRateDenominator;

    @OriginalMember(owner = "client!un", name = "x", descriptor = "F")
    public float endTime;

    @OriginalMember(owner = "client!un", name = "s", descriptor = "Ljava/lang/String;")
    public String category;

    @OriginalMember(owner = "client!un", name = "F", descriptor = "F")
    public float startTime;

    @OriginalMember(owner = "client!un", name = "r", descriptor = "I")
    public int granuleRateNumber;

    @OriginalMember(owner = "client!un", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggKateStream(@OriginalArg(0) OggStreamState state) {
        super(state);
    }

    @OriginalMember(owner = "client!un", name = "i", descriptor = "(I)F")
    public float getStartTime() {
        return this.startTime;
    }

    @OriginalMember(owner = "client!un", name = "c", descriptor = "(I)Ljava/lang/String;")
    public String getLanguage() {
        return this.language;
    }

    @OriginalMember(owner = "client!un", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    @Override
    protected void decode(@OriginalArg(1) OggPacket oggPacket) {
        if (super.packetNumber > 0 && !"SUB".equals(this.category)) {
            return;
        }

        @Pc(31) Packet packet = new Packet(oggPacket.getData());
        @Pc(35) int type = packet.g1();
        if (super.packetNumber > 8) {
            if (type == 0) {
                @Pc(47) long start = packet.ig8();
                @Pc(51) long duration = packet.ig8();
                @Pc(55) long backlink = packet.ig8();
                if (start < 0L || duration < 0L || backlink < 0L || start < backlink) {
                    throw new IllegalStateException();
                }

                this.endTime = (float) ((long) this.granuleRateDenominator * (start + duration)) / (float) this.granuleRateNumber;
                this.startTime = (float) ((long) this.granuleRateDenominator * start) / (float) this.granuleRateNumber;

                @Pc(121) int length = packet.ig4();
                if (length < 0 || packet.data.length - packet.pos < length) {
                    throw new IllegalStateException();
                }

                this.subtitle = Utf8.decode(length, packet.data, packet.pos);
            }
            if ((type | 0x80) != 0) {
                return;
            }
            return;
        }

        if ((type | 0x80) == 0) {
            throw new IllegalStateException();
        }

        if (super.packetNumber != 0) {
            return;
        }

        packet.pos += 23;
        this.granuleRateNumber = packet.ig4();
        this.granuleRateDenominator = packet.ig4();
        if (this.granuleRateNumber == 0 || this.granuleRateDenominator == 0) {
            throw new IllegalStateException();
        }

        @Pc(211) Packet stringPacket = new Packet(16);

        packet.gdata(0, 16, stringPacket.data);
        this.language = stringPacket.gjstr();
        stringPacket.pos = 0;

        packet.gdata(0, 16, stringPacket.data);
        this.category = stringPacket.gjstr();
    }

    @OriginalMember(owner = "client!un", name = "g", descriptor = "(I)Ljava/lang/String;")
    public String getSubtitle() {
        return this.subtitle;
    }

    @OriginalMember(owner = "client!un", name = "d", descriptor = "(I)F")
    public float getEndTime() {
        return this.endTime;
    }

    @OriginalMember(owner = "client!un", name = "b", descriptor = "(I)V")
    @Override
    public void stop() {
    }
}
