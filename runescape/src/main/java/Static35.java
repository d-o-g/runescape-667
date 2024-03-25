import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import com.jagex.sound.SynthSound;
import com.jagex.sound.VariableRateSoundPacket;
import com.jagex.sound.vorbis.VorbisSound;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static35 {

    @OriginalMember(owner = "client!bd", name = "Jb", descriptor = "I")
    public static int anInt813;

    @OriginalMember(owner = "client!bd", name = "Lb", descriptor = "I")
    public static int currentTick = 0;

    @OriginalMember(owner = "client!bd", name = "ub", descriptor = "[I")
    public static final int[] anIntArray58 = new int[3];

    @OriginalMember(owner = "client!bd", name = "c", descriptor = "(I)V")
    public static void method918() {
        for (@Pc(7) int local7 = 0; local7 < SoundManager.count; local7++) {
            @Pc(13) Sound local13 = SoundManager.sounds[local7];
            @Pc(15) boolean local15 = false;
            @Pc(179) int local179;
            if (local13.aClass2_Sub6_Sub2_2 == null) {
                local13.rate--;
                if (local13.rate < (local13.isVorbis() ? -1500 : -10)) {
                    local15 = true;
                } else {
                    if (local13.type == 1 && local13.synth == null) {
                        local13.synth = SynthSound.get(js5.SYNTH_SOUNDS, local13.id, 0);
                        if (local13.synth == null) {
                            continue;
                        }
                        local13.rate += local13.synth.delay();
                    } else if (local13.isVorbis() && (local13.vorbis == null || local13.packet == null)) {
                        if (local13.vorbis == null) {
                            local13.vorbis = VorbisSound.create(js5.VORBIS, local13.id);
                        }
                        if (local13.vorbis == null) {
                            continue;
                        }
                        if (local13.packet == null) {
                            local13.packet = local13.vorbis.method8502(new int[]{22050});
                            if (local13.packet == null) {
                                continue;
                            }
                        }
                    }
                    if (local13.rate < 0) {
                        @Pc(154) int local154 = 8192;
                        if (local13.delay == 0) {
                            local179 = local13.loops * (local13.type == 3 ? ClientOptions.instance.speechVolume.getValue() : ClientOptions.instance.soundVolume.getValue()) >> 2;
                        } else {
                            @Pc(188) int local188 = local13.delay >> 24 & 0x3;
                            if (local188 == PlayerEntity.self.level) {
                                @Pc(199) int local199 = (local13.delay & 0xFF) << 9;
                                @Pc(205) int local205 = PlayerEntity.self.getSize() << 8;
                                @Pc(212) int local212 = local13.delay >> 16 & 0xFF;
                                @Pc(224) int local224 = (local212 << 9) + local205 + 256 - PlayerEntity.self.x;
                                @Pc(231) int local231 = local13.delay >> 8 & 0xFF;
                                @Pc(243) int local243 = local205 + (local231 << 9) + 256 - PlayerEntity.self.z;
                                @Pc(251) int local251 = Math.abs(local224) + Math.abs(local243) - 512;
                                if (local199 < local251) {
                                    local13.rate = -99999;
                                    continue;
                                }
                                if (local251 < 0) {
                                    local251 = 0;
                                }
                                local179 = ClientOptions.instance.backgroundSoundVolume.getValue() * (local199 - local251) * local13.loops / local199 >> 2;
                                if (local13.entity != null && local13.entity instanceof PositionEntity) {
                                    @Pc(301) PositionEntity local301 = (PositionEntity) local13.entity;
                                    @Pc(304) short local304 = local301.z1;
                                    @Pc(307) short local307 = local301.x1;
                                }
                                if (local224 != 0 || local243 != 0) {
                                    @Pc(336) int local336 = -Camera.yaw - (int) (Math.atan2(local224, local243) * 2607.5945876176133D) - 4096 & 0x3FFF;
                                    if (local336 > 8192) {
                                        local336 = 16384 - local336;
                                    }
                                    @Pc(355) int local355;
                                    if (local251 <= 0) {
                                        local355 = 8192;
                                    } else if (local251 >= 4096) {
                                        local355 = 16384;
                                    } else {
                                        local355 = (8192 - local251) / 4096 + 8192;
                                    }
                                    local154 = (16384 - local355 >> 1) + local336 * local355 / 8192;
                                }
                            } else {
                                local179 = 0;
                            }
                        }
                        if (local179 > 0) {
                            @Pc(392) VariableRateSoundPacket local392 = null;
                            if (local13.type == 1) {
                                local392 = local13.synth.sample().resample(Static681.aSampleRateConverter_2);
                            } else if (local13.isVorbis()) {
                                local392 = local13.packet;
                            }
                            @Pc(422) Node_Sub6_Sub2 local422 = local13.aClass2_Sub6_Sub2_2 = Static730.method3346(local392, local13.range, local179, local154);
                            local422.method3318(local13.volume - 1);
                            Static336.activeStreams.method5882(local422);
                        }
                    }
                }
            } else if (!local13.aClass2_Sub6_Sub2_2.isLinked()) {
                local15 = true;
            }
            if (local15) {
                SoundManager.count--;
                for (local179 = local7; local179 < SoundManager.count; local179++) {
                    SoundManager.sounds[local179] = SoundManager.sounds[local179 + 1];
                }
                local7--;
            }
        }
        if (Static501.aBoolean575 && !Static52.method1157(126)) {
            if (ClientOptions.instance.musicVolume.getValue() != 0 && Static588.anInt8692 != -1) {
                if (Static8.aClass2_Sub6_Sub1_1 == null) {
                    Static611.method8229(Static588.anInt8692, ClientOptions.instance.musicVolume.getValue(), js5.MIDI_SONGS);
                } else {
                    Static273.method3961(Static8.aClass2_Sub6_Sub1_1, Static588.anInt8692, js5.MIDI_SONGS, ClientOptions.instance.musicVolume.getValue());
                }
            }
            Static8.aClass2_Sub6_Sub1_1 = null;
            Static501.aBoolean575 = false;
        } else if (ClientOptions.instance.musicVolume.getValue() != 0 && Static588.anInt8692 != -1 && !Static52.method1157(125)) {
            @Pc(551) ClientMessage local551 = ClientMessage.create(ClientProt.A_CLIENT_PROT___49, ConnectionManager.GAME.cipher);
            local551.bitPacket.p4(Static588.anInt8692);
            ConnectionManager.GAME.send(local551);
            Static588.anInt8692 = -1;
        }
    }

    @OriginalMember(owner = "client!bd", name = "a", descriptor = "(Lclient!ge;I)Lclient!lv;")
    public static Class235 method935(@OriginalArg(0) Packet arg0) {
        @Pc(7) int local7 = arg0.g1();
        @Pc(16) HorizontalAlignment local16 = HorizontalAlignment.values()[arg0.g1()];
        @Pc(25) VerticalAlignment local25 = VerticalAlignment.values()[arg0.g1()];
        @Pc(29) int local29 = arg0.g2s();
        @Pc(33) int local33 = arg0.g2s();
        @Pc(39) int local39 = arg0.g2();
        @Pc(43) int local43 = arg0.g2();
        @Pc(49) int local49 = arg0.g4();
        @Pc(53) int local53 = arg0.g4();
        @Pc(59) int local59 = arg0.g4();
        @Pc(69) boolean local69 = arg0.g1() == 1;
        return new Class235(local7, local16, local25, local29, local33, local39, local43, local49, local53, local59, local69);
    }
}
