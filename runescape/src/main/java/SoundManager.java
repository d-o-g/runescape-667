import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.js5.js5;
import com.jagex.sound.SynthSound;
import com.jagex.sound.VariableRateSoundPacket;
import com.jagex.sound.vorbis.VorbisSound;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class SoundManager {
    @OriginalMember(owner = "client!oj", name = "n", descriptor = "Lclient!sia;")
    public static final Deque locSounds = new Deque();

    @OriginalMember(owner = "client!dja", name = "h", descriptor = "Lclient!av;")
    public static final IterableHashTable playerSounds = new IterableHashTable(16);

    @OriginalMember(owner = "client!wn", name = "f", descriptor = "Lclient!sia;")
    public static final Deque npcSounds = new Deque();

    @OriginalMember(owner = "client!mt", name = "L", descriptor = "[Lclient!eka;")
    public static Sound[] sounds = new Sound[50];

    @OriginalMember(owner = "client!bc", name = "c", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!kka", name = "d", descriptor = "Lclient!nn;")
    public static Node_Sub6_Sub3 activeStreams;

    @OriginalMember(owner = "client!sj", name = "e", descriptor = "I")
    public static int midiSong = -1;

    @OriginalMember(owner = "client!lka", name = "b", descriptor = "(B)V")
    public static void reset() {
        count = 0;
        sounds = new Sound[50];
    }

    @OriginalMember(owner = "client!dca", name = "a", descriptor = "(I)V")
    public static void method2000() {
        for (@Pc(8) PositionedSound sound = (PositionedSound) locSounds.first(); sound != null; sound = (PositionedSound) locSounds.next()) {
            if (sound.multi) {
                sound.update();
            }
        }
        for (@Pc(31) PositionedSound sound = (PositionedSound) npcSounds.first(); sound != null; sound = (PositionedSound) npcSounds.next()) {
            if (sound.multi) {
                sound.update();
            }
        }
    }

    @OriginalMember(owner = "client!pv", name = "a", descriptor = "(IIILclient!c;I)V")
    public static void method8312(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int level, @OriginalArg(3) LocType locType) {
        for (@Pc(18) PositionedSound sound = (PositionedSound) locSounds.first(); sound != null; sound = (PositionedSound) locSounds.next()) {
            if (sound.level == level && sound.x1 == x << 9 && sound.z1 == y << 9 && locType.id == sound.locType.id) {
                if (sound.stream != null) {
                    activeStreams.remove(sound.stream);
                    sound.stream = null;
                }
                if (sound.randomStream != null) {
                    activeStreams.remove(sound.randomStream);
                    sound.randomStream = null;
                }
                sound.unlink();
                return;
            }
        }
    }

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(ZI)V")
    public static void removeActiveStreams(@OriginalArg(0) boolean entities) {
        for (@Pc(8) PositionedSound sound = (PositionedSound) locSounds.first(); sound != null; sound = (PositionedSound) locSounds.next()) {
            if (sound.stream != null) {
                activeStreams.remove(sound.stream);
                sound.stream = null;
            }
            if (sound.randomStream != null) {
                activeStreams.remove(sound.randomStream);
                sound.randomStream = null;
            }
            sound.unlink();
        }

        if (entities) {
            for (@Pc(57) PositionedSound sound = (PositionedSound) npcSounds.first(); sound != null; sound = (PositionedSound) npcSounds.next()) {
                if (sound.stream != null) {
                    activeStreams.remove(sound.stream);
                    sound.stream = null;
                }
                sound.unlink();
            }

            for (@Pc(85) PositionedSound sound = (PositionedSound) playerSounds.first(); sound != null; sound = (PositionedSound) playerSounds.next()) {
                if (sound.stream != null) {
                    activeStreams.remove(sound.stream);
                    sound.stream = null;
                }
                sound.unlink();
            }
        } else {
        }
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(ILclient!tg;IIBI)V")
    public static void method8366(@OriginalArg(0) int clock, @OriginalArg(1) PositionedSound sound, @OriginalArg(2) int level, @OriginalArg(3) int x, @OriginalArg(5) int z) {
        if (sound.id == -1 && sound.randomIds == null) {
            return;
        }

        @Pc(23) int range = 0;
        @Pc(33) int volume = sound.volume * ClientOptions.instance.backgroundSoundVolume.getValue() >> 8;
        if (sound.x2 < x) {
            range = x - sound.x2;
        } else if (sound.x1 > x) {
            range = sound.x1 - x;
        }
        if (sound.z2 < z) {
            range += z - sound.z2;
        } else if (sound.z1 > z) {
            range += sound.z1 - z;
        }

        if (sound.rangeMax == 0 || range - 256 > sound.rangeMax || ClientOptions.instance.backgroundSoundVolume.getValue() == 0 || level != sound.level) {
            if (sound.stream != null) {
                activeStreams.remove(sound.stream);
                sound.stream = null;
                sound.vorbisSound = null;
                sound.packet = null;
            }
            if (sound.randomStream != null) {
                activeStreams.remove(sound.randomStream);
                sound.randomVorbisSound = null;
                sound.randomStream = null;
                sound.randomPacket = null;
            }
            return;
        }

        range -= 256;

        if (range < 0) {
            range = 0;
        }

        @Pc(172) int rangeDelta = sound.rangeMax - sound.minRange;
        if (rangeDelta < 0) {
            rangeDelta = sound.rangeMax;
        }

        @Pc(182) int soundRange = volume;
        @Pc(187) int local187 = range - sound.minRange;
        if (local187 > 0 && rangeDelta > 0) {
            soundRange = (rangeDelta - local187) * volume / rangeDelta;
        }

        PlayerEntity.self.getSize();
        @Pc(214) int soundRangeY = 8192;
        @Pc(225) int soundX = ((sound.x2 + sound.x1) / 2) - x;
        @Pc(236) int soundZ = ((sound.z2 + sound.z1) / 2) - z;
        if (soundX != 0 || soundZ != 0) {
            @Pc(264) int yaw = (-Camera.yaw - (int) (Math.atan2(soundX, soundZ) * 2607.5945876176133D) - 4096) & 0x3FFF;
            if (yaw > 8192) {
                yaw = 16384 - yaw;
            }

            @Pc(275) int soundY;
            if (range <= 0) {
                soundY = 8192;
            } else if (range >= 4096) {
                soundY = 16384;
            } else {
                soundY = ((range * 8192) / 4096) + 8192;
            }

            soundRangeY = ((16384 - soundY) >> 1) + ((yaw * soundY) / 8192);
        }

        if (sound.stream != null) {
            sound.stream.setRange(soundRange);
            sound.stream.setRangeY(soundRangeY);
        } else if (sound.id >= 0) {
            @Pc(264) int rate = sound.rateMax == 256 && sound.rateMin == 256 ? 256 : method2572(sound.rateMin, sound.rateMax);

            if (sound.vorbis) {
                if (sound.vorbisSound == null) {
                    sound.vorbisSound = VorbisSound.create(js5.VORBIS, sound.id);
                }

                if (sound.vorbisSound != null) {
                    if (sound.packet == null) {
                        sound.packet = sound.vorbisSound.method8502(new int[]{22050});
                    }

                    if (sound.packet != null) {
                        @Pc(391) SoundStream stream = SoundStream.create(sound.packet, rate, soundRange << 6, soundRangeY);
                        stream.setVolume(-1);
                        activeStreams.addFirst(stream);
                        sound.stream = stream;
                    }
                }
            } else {
                @Pc(408) SynthSound synth = SynthSound.get(js5.SYNTH_SOUNDS, sound.id, 0);

                if (synth != null) {
                    @Pc(415) VariableRateSoundPacket packet = synth.sample().resample(Static681.aSampleRateConverter_2);
                    @Pc(423) SoundStream stream = SoundStream.create(packet, rate, soundRange << 6, soundRangeY);
                    stream.setVolume(-1);
                    activeStreams.addFirst(stream);
                    sound.stream = stream;
                }
            }
        }

        if (sound.randomStream != null) {
            sound.randomStream.setRange(soundRange);
            sound.randomStream.setRangeY(soundRangeY);

            if (!sound.randomStream.isLinked()) {
                sound.randomStream = null;
                sound.randomVorbisSound = null;
                sound.randomPacket = null;
            }
        } else if (sound.randomIds != null && (sound.randomDelay -= clock) <= 0) {
            @Pc(264) int rate = sound.rateMax == 256 && sound.rateMin == 256 ? 256 : sound.rateMin + (int) ((double) (sound.rateMax - sound.rateMin) * Math.random());

            if (sound.random) {
                if (sound.randomVorbisSound == null) {
                    @Pc(275) int randomId = (int) (Math.random() * (double) sound.randomIds.length);
                    sound.randomVorbisSound = VorbisSound.create(js5.VORBIS, sound.randomIds[randomId]);
                }

                if (sound.randomVorbisSound != null) {
                    if (sound.randomPacket == null) {
                        sound.randomPacket = sound.randomVorbisSound.method8502(new int[]{22050});
                    }

                    if (sound.randomPacket != null) {
                        @Pc(391) SoundStream stream = SoundStream.create(sound.randomPacket, rate, soundRange << 6, soundRangeY);
                        stream.setVolume(0);
                        activeStreams.addFirst(stream);
                        sound.randomDelay = (int) ((double) (sound.delayMax - sound.delayMin) * Math.random()) + sound.delayMin;
                        sound.randomStream = stream;
                    }
                }
            } else {
                @Pc(275) int randomId = (int) ((double) sound.randomIds.length * Math.random());
                @Pc(536) SynthSound synth = SynthSound.get(js5.SYNTH_SOUNDS, sound.randomIds[randomId], 0);

                if (synth != null) {
                    @Pc(543) VariableRateSoundPacket packet = synth.sample().resample(Static681.aSampleRateConverter_2);
                    @Pc(551) SoundStream stream = SoundStream.create(packet, rate, soundRange << 6, soundRangeY);
                    stream.setVolume(0);
                    activeStreams.addFirst(stream);
                    sound.randomDelay = (int) (Math.random() * (double) (sound.delayMax - sound.delayMin)) + sound.delayMin;
                    sound.randomStream = stream;
                }
            }
        }
    }

    @OriginalMember(owner = "client!ew", name = "a", descriptor = "(III)I")
    public static int method2572(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(17) double max = Math.log(arg1) / Math.log(2.0D);
        @Pc(24) double min = Math.log(arg0) / Math.log(2.0D);
        @Pc(33) double local33 = min + Math.random() * (max - min);
        return (int) (Math.pow(2.0D, local33) + 0.5D);
    }

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(IILclient!cka;)V")
    public static void method4577(@OriginalArg(0) int arg0, @OriginalArg(2) SeqType arg1) {
        if (count >= 50 || (arg1 == null || arg1.soundInfo == null || arg1.soundInfo.length <= arg0 || arg1.soundInfo[arg0] == null)) {
            return;
        }
        @Pc(42) int local42 = arg1.soundInfo[arg0][0];
        @Pc(46) int local46 = local42 >> 8;
        @Pc(63) int local63;
        if (arg1.soundInfo[arg0].length > 1) {
            local63 = (int) (Math.random() * (double) arg1.soundInfo[arg0].length);
            if (local63 > 0) {
                local46 = arg1.soundInfo[arg0][local63];
            }
        }
        @Pc(81) int local81 = local42 >> 5 & 0x7;
        local63 = 256;
        if (arg1.anIntArray154 != null && arg1.anIntArray155 != null) {
            local63 = method2572(arg1.anIntArray154[arg0], arg1.anIntArray155[arg0]);
        }
        if (arg1.vorbisSound) {
            Static186.method2818(local46, local81, local63, 0, 255, false);
        } else {
            Static161.method2586(local63, 0, local46, local81, 255);
        }
    }

    @OriginalMember(owner = "client!bd", name = "c", descriptor = "(I)V")
    public static void method918() {
        for (@Pc(7) int local7 = 0; local7 < count; local7++) {
            @Pc(13) Sound local13 = sounds[local7];
            @Pc(15) boolean local15 = false;
            @Pc(179) int local179;
            if (local13.stream == null) {
                local13.range--;
                if (local13.range < (local13.isVorbis() ? -1500 : -10)) {
                    local15 = true;
                } else {
                    if (local13.type == 1 && local13.synth == null) {
                        local13.synth = SynthSound.get(js5.SYNTH_SOUNDS, local13.id, 0);
                        if (local13.synth == null) {
                            continue;
                        }
                        local13.range += local13.synth.delay();
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
                    if (local13.range < 0) {
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
                                    local13.range = -99999;
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
                            @Pc(422) SoundStream stream = local13.stream = SoundStream.create(local392, local13.rate, local179, local154);
                            stream.setVolume(local13.volume - 1);
                            activeStreams.addFirst(stream);
                        }
                    }
                }
            } else if (!local13.stream.isLinked()) {
                local15 = true;
            }
            if (local15) {
                count--;
                for (local179 = local7; local179 < count; local179++) {
                    sounds[local179] = sounds[local179 + 1];
                }
                local7--;
            }
        }
        if (Static501.aBoolean575 && !Static52.method1157(126)) {
            if (ClientOptions.instance.musicVolume.getValue() != 0 && midiSong != -1) {
                if (Static8.aClass2_Sub6_Sub1_1 == null) {
                    Static611.method8229(midiSong, ClientOptions.instance.musicVolume.getValue(), js5.MIDI_SONGS);
                } else {
                    Static273.method3961(Static8.aClass2_Sub6_Sub1_1, midiSong, js5.MIDI_SONGS, ClientOptions.instance.musicVolume.getValue());
                }
            }
            Static8.aClass2_Sub6_Sub1_1 = null;
            Static501.aBoolean575 = false;
        } else if (ClientOptions.instance.musicVolume.getValue() != 0 && midiSong != -1 && !Static52.method1157(125)) {
            @Pc(551) ClientMessage local551 = ClientMessage.create(ClientProt.A_CLIENT_PROT___49, ServerConnection.GAME.cipher);
            local551.bitPacket.p4(midiSong);
            ServerConnection.GAME.send(local551);
            midiSong = -1;
        }
    }

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(I)V")
    public static void mixBussReset() {
        mixBussSetLevel(255, -1);
    }

    @OriginalMember(owner = "client!sca", name = "a", descriptor = "(III)V")
    public static void mixBussSetLevel(@OriginalArg(0) int level, @OriginalArg(1) int channel) {
        if (Static96.anInt10171 != 0) {
            if (channel >= 0) {
                Static286.anIntArray358[channel] = level;
            } else {
                for (@Pc(23) int c = 0; c < 16; c++) {
                    Static286.anIntArray358[c] = level;
                }
            }
        }
        Static581.aClass2_Sub6_Sub1_3.method926(level, channel);
    }
}
