import com.jagex.ClientProt;
import com.jagex.js5.js5;
import com.jagex.sound.Sound;
import com.jagex.sound.SoundStream;
import com.jagex.sound.SoundType;
import com.jagex.sound.SynthSound;
import com.jagex.sound.VariableRateSoundPacket;
import com.jagex.sound.vorbis.VorbisSound;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class AudioRenderer {

    @OriginalMember(owner = "client!bd", name = "c", descriptor = "(I)V")
    public static void render() {
        for (@Pc(7) int i = 0; i < SoundManager.count; i++) {
            @Pc(13) Sound sound = SoundManager.sounds[i];
            @Pc(15) boolean stopped = false;

            if (sound.stream != null) {
                if (!sound.stream.isLinked()) {
                    stopped = true;
                }
            } else {
                sound.delay--;

                if (sound.delay < (sound.isVorbis() ? -1500 : -10)) {
                    stopped = true;
                } else {
                    if (sound.type == SoundType.SYNTH && sound.synth == null) {
                        sound.synth = SynthSound.get(js5.SYNTH_SOUNDS, sound.id, 0);

                        if (sound.synth == null) {
                            continue;
                        }

                        sound.delay += sound.synth.delay();
                    } else if (sound.isVorbis() && (sound.vorbis == null || sound.packet == null)) {
                        if (sound.vorbis == null) {
                            sound.vorbis = VorbisSound.create(js5.VORBIS, sound.id);
                        }

                        if (sound.vorbis == null) {
                            continue;
                        }

                        if (sound.packet == null) {
                            sound.packet = sound.vorbis.method8502(new int[]{22050});
                            if (sound.packet == null) {
                                continue;
                            }
                        }
                    }

                    if (sound.delay < 0) {
                        @Pc(154) int calculatedRange = 8192;
                        @Pc(179) int volume;

                        if (sound.coord == 0) {
                            volume = sound.volume * (sound.type == SoundType.VORBIS_VOICE_OVER ? ClientOptions.instance.speechVolume.getValue() : ClientOptions.instance.soundVolume.getValue()) >> 2;
                        } else {
                            @Pc(188) int level = (sound.coord >> 24) & 0x3;

                            if (level == PlayerEntity.self.level) {
                                @Pc(199) int soundRange = (sound.coord & 0xFF) << 9;
                                @Pc(205) int size = PlayerEntity.self.getSize() << 8;
                                @Pc(212) int soundX = sound.coord >> 16 & 0xFF;
                                @Pc(224) int x = (soundX << 9) + size + 256 - PlayerEntity.self.x;
                                @Pc(231) int soundZ = sound.coord >> 8 & 0xFF;
                                @Pc(243) int y = size + (soundZ << 9) + 256 - PlayerEntity.self.z;
                                @Pc(251) int minRange = Math.abs(x) + Math.abs(y) - 512;

                                if (soundRange < minRange) {
                                    sound.delay = -99999;
                                    continue;
                                }

                                if (minRange < 0) {
                                    minRange = 0;
                                }

                                volume = ClientOptions.instance.backgroundSoundVolume.getValue() * (soundRange - minRange) * sound.volume / soundRange >> 2;

                                if (sound.entity != null && sound.entity instanceof PositionEntity) {
                                    @Pc(301) PositionEntity entity = (PositionEntity) sound.entity;
                                    @Pc(304) short z1 = entity.z1;
                                    @Pc(307) short x1 = entity.x1;
                                }

                                if (x != 0 || y != 0) {
                                    @Pc(336) int local336 = -Camera.yaw - (int) (Math.atan2(x, y) * 2607.5945876176133D) - 4096 & 0x3FFF;
                                    if (local336 > 8192) {
                                        local336 = 16384 - local336;
                                    }
                                    @Pc(355) int local355;
                                    if (minRange <= 0) {
                                        local355 = 8192;
                                    } else if (minRange >= 4096) {
                                        local355 = 16384;
                                    } else {
                                        local355 = (8192 - minRange) / 4096 + 8192;
                                    }

                                    calculatedRange = (16384 - local355 >> 1) + local336 * local355 / 8192;
                                }
                            } else {
                                volume = 0;
                            }
                        }

                        if (volume > 0) {
                            @Pc(392) VariableRateSoundPacket packet = null;
                            if (sound.type == SoundType.SYNTH) {
                                packet = sound.synth.sample().resample(Static681.aSampleRateConverter_2);
                            } else if (sound.isVorbis()) {
                                packet = sound.packet;
                            }

                            @Pc(422) SoundStream stream = sound.stream = SoundStream.create(packet, sound.rate, volume, calculatedRange);
                            stream.setLoops(sound.loops - 1);
                            SoundManager.activeStreams.addFirst(stream);
                        }
                    }
                }
            }

            if (stopped) {
                SoundManager.count--;
                for (@Pc(179) int local179 = i; local179 < SoundManager.count; local179++) {
                    SoundManager.sounds[local179] = SoundManager.sounds[local179 + 1];
                }
                i--;
            }
        }

        if (Static501.aBoolean575 && !Static52.method1157(126)) {
            if (ClientOptions.instance.musicVolume.getValue() != 0 && SongManager.playing != -1) {
                if (Static8.aClass2_Sub6_Sub1_1 == null) {
                    SongManager.method8229(SongManager.playing, ClientOptions.instance.musicVolume.getValue(), js5.MIDI_SONGS);
                } else {
                    SongManager.method3961(Static8.aClass2_Sub6_Sub1_1, SongManager.playing, js5.MIDI_SONGS, ClientOptions.instance.musicVolume.getValue());
                }
            }

            Static8.aClass2_Sub6_Sub1_1 = null;
            Static501.aBoolean575 = false;
        } else if (ClientOptions.instance.musicVolume.getValue() != 0 && SongManager.playing != -1 && !Static52.method1157(125)) {
            @Pc(551) ClientMessage local551 = ClientMessage.create(ClientProt.SOUND_SONGEND, ServerConnection.GAME.cipher);
            local551.bitPacket.p4(SongManager.playing);
            ServerConnection.GAME.send(local551);
            SongManager.playing = -1;
        }
    }
    private AudioRenderer() {
        /* empty */
    }

    @OriginalMember(owner = "client!sca", name = "a", descriptor = "(III)V")
    public static void mixBussSetLevel(@OriginalArg(0) int level, @OriginalArg(1) int channel) {
        if (SongManager.anInt10171 != 0) {
            if (channel >= 0) {
                Static286.anIntArray358[channel] = level;
            } else {
                for (@Pc(23) int c = 0; c < 16; c++) {
                    Static286.anIntArray358[c] = level;
                }
            }
        }
        Static581.mixBuss.method926(level, channel);
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(I)V")
    public static void mixBussReset() {
        mixBussSetLevel(255, -1);
    }
}
