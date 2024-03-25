package com.jagex.sound.midi;

import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.datastruct.key.Node;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import static com.jagex.sound.midi.Midi.CHANNEL_MASK;
import static com.jagex.sound.midi.Midi.FILE_BODY_LENGTH;
import static com.jagex.sound.midi.Midi.FILE_HEADER;
import static com.jagex.sound.midi.Midi.TRACK_HEADER;
import static com.jagex.sound.midi.MidiController.ALL_CONTROLLERS_OFF;
import static com.jagex.sound.midi.MidiController.ALL_NOTES_OFF;
import static com.jagex.sound.midi.MidiController.ALL_SOUND_OFF;
import static com.jagex.sound.midi.MidiController.BANK_SELECT_COARSE;
import static com.jagex.sound.midi.MidiController.BANK_SELECT_FINE;
import static com.jagex.sound.midi.MidiController.HOLD;
import static com.jagex.sound.midi.MidiController.MAIN_VOLUME_COARSE;
import static com.jagex.sound.midi.MidiController.MAIN_VOLUME_FINE;
import static com.jagex.sound.midi.MidiController.MODULATION_WHEEL_COARSE;
import static com.jagex.sound.midi.MidiController.MODULATION_WHEEL_FINE;
import static com.jagex.sound.midi.MidiController.NON_REGISTERED_PARAM_COARSE;
import static com.jagex.sound.midi.MidiController.NON_REGISTERED_PARAM_FINE;
import static com.jagex.sound.midi.MidiController.PAN_COARSE;
import static com.jagex.sound.midi.MidiController.PAN_FINE;
import static com.jagex.sound.midi.MidiController.PORTAMENTO_PEDAL;
import static com.jagex.sound.midi.MidiController.REGISTERED_PARAM_COARSE;
import static com.jagex.sound.midi.MidiController.REGISTERED_PARAM_FINE;
import static com.jagex.sound.midi.MidiStatus.CHANNEL_AFTERTOUCH;
import static com.jagex.sound.midi.MidiStatus.CONTROLLER;
import static com.jagex.sound.midi.MidiStatus.NOTE_AFTERTOUCH;
import static com.jagex.sound.midi.MidiStatus.NOTE_OFF;
import static com.jagex.sound.midi.MidiStatus.NOTE_ON;
import static com.jagex.sound.midi.MidiStatus.PITCH;
import static com.jagex.sound.midi.MidiStatus.PROGRAM_CHANGE;

@OriginalClass("client!bn")
public final class MidiSong extends Node {

    @OriginalMember(owner = "client!bn", name = "l", descriptor = "Lclient!av;")
    public IterableHashTable programs;

    @OriginalMember(owner = "client!bn", name = "k", descriptor = "[B")
    public final byte[] midiData;

    @OriginalMember(owner = "client!bn", name = "<init>", descriptor = "(Lclient!ge;)V")
    public MidiSong(@OriginalArg(0) Packet packet) {
        packet.pos = packet.data.length - 3;
        @Pc(12) int tracks = packet.g1();
        @Pc(16) int timeDivision = packet.g2();
        @Pc(22) int midiLength = tracks * 10 + 14;
        packet.pos = 0;

        @Pc(27) int tempCount = 0;
        @Pc(29) int conrollerCount = 0;
        @Pc(31) int noteOnCount = 0;
        @Pc(33) int noteOffCount = 0;
        @Pc(35) int pitchBendCount = 0;
        @Pc(37) int channelAftertouchCount = 0;
        @Pc(39) int noteAftertouchCount = 0;
        @Pc(41) int bankSelectCount = 0;

        for (@Pc(43) int i = 0; i < tracks; i++) {
            @Pc(46) int lo = -1;

            while (true) {
                @Pc(50) int event = packet.g1();
                if (event != lo) {
                    midiLength++;
                }

                lo = event & CHANNEL_MASK;

                if (event == 7) {
                    break;
                } else if (event == 23) {
                    tempCount++;
                } else if (lo == 0) {
                    noteOnCount++;
                } else if (lo == 1) {
                    noteOffCount++;
                } else if (lo == 2) {
                    conrollerCount++;
                } else if (lo == 3) {
                    pitchBendCount++;
                } else if (lo == 4) {
                    channelAftertouchCount++;
                } else if (lo == 5) {
                    noteAftertouchCount++;
                } else if (lo == 6) {
                    bankSelectCount++;
                } else {
                    throw new RuntimeException();
                }
            }
        }

        midiLength += tempCount * 5;
        midiLength += (noteOnCount + noteOffCount + conrollerCount + pitchBendCount + noteAftertouchCount) * 2;
        midiLength += channelAftertouchCount + bankSelectCount;

        @Pc(46) int timePos = packet.pos;
        @Pc(50) int timeCount = tracks + tempCount + conrollerCount + noteOnCount + noteOffCount + pitchBendCount + channelAftertouchCount + noteAftertouchCount + bankSelectCount;
        for (@Pc(169) int i = 0; i < timeCount; i++) {
            packet.gVarInt();
        }
        midiLength += packet.pos - timePos;

        @Pc(188) int controllerPos = packet.pos;
        @Pc(190) int modulationWheelCoarseCount = 0;
        @Pc(192) int modulationWheelFineCount = 0;
        @Pc(194) int mainVolumeCoarseCount = 0;
        @Pc(196) int mainVolumeFineCount = 0;
        @Pc(198) int panCoarseCount = 0;
        @Pc(200) int panFineCount = 0;
        @Pc(202) int nonregisteredParamFineCount = 0;
        @Pc(204) int nonregisteredParamCoarseCount = 0;
        @Pc(206) int registeredParamFineCount = 0;
        @Pc(208) int registerdParamCoarseBitCount = 0;
        @Pc(210) int specialCount = 0;
        @Pc(212) int otherCount = 0;

        @Pc(214) int controllerType = 0;
        for (@Pc(216) int i = 0; i < conrollerCount; i++) {
            controllerType = controllerType + packet.g1() & 0x7F;

            if (controllerType == BANK_SELECT_COARSE || controllerType == BANK_SELECT_FINE) {
                bankSelectCount++;
            } else if (controllerType == MODULATION_WHEEL_COARSE) {
                modulationWheelCoarseCount++;
            } else if (controllerType == MODULATION_WHEEL_FINE) {
                modulationWheelFineCount++;
            } else if (controllerType == MAIN_VOLUME_COARSE) {
                mainVolumeCoarseCount++;
            } else if (controllerType == MAIN_VOLUME_FINE) {
                mainVolumeFineCount++;
            } else if (controllerType == PAN_COARSE) {
                panCoarseCount++;
            } else if (controllerType == PAN_FINE) {
                panFineCount++;
            } else if (controllerType == NON_REGISTERED_PARAM_FINE) {
                nonregisteredParamFineCount++;
            } else if (controllerType == NON_REGISTERED_PARAM_COARSE) {
                nonregisteredParamCoarseCount++;
            } else if (controllerType == REGISTERED_PARAM_FINE) {
                registeredParamFineCount++;
            } else if (controllerType == REGISTERED_PARAM_COARSE) {
                registerdParamCoarseBitCount++;
            } else if (controllerType == HOLD || controllerType == PORTAMENTO_PEDAL || controllerType == ALL_SOUND_OFF || controllerType == ALL_CONTROLLERS_OFF || controllerType == ALL_NOTES_OFF) {
                specialCount++;
            } else {
                otherCount++;
            }
        }

        @Pc(328) int eventPos = 0;

        @Pc(331) int specialPos = packet.pos;
        packet.pos += specialCount;

        @Pc(340) int noteAftertouchPos = packet.pos;
        packet.pos += noteAftertouchCount;

        @Pc(349) int channelAftertouchPos = packet.pos;
        packet.pos += channelAftertouchCount;

        @Pc(358) int pitchBendCoarsePos = packet.pos;
        packet.pos += pitchBendCount;

        @Pc(367) int modulationWheelCoarsePos = packet.pos;
        packet.pos += modulationWheelCoarseCount;

        @Pc(376) int mainVolumeCoarsePos = packet.pos;
        packet.pos += mainVolumeCoarseCount;

        @Pc(385) int panCoarsePos = packet.pos;
        packet.pos += panCoarseCount;

        @Pc(394) int noteCountPos = packet.pos;
        packet.pos += noteOnCount + noteOffCount + noteAftertouchCount;

        @Pc(407) int noteOnVelocityPos = packet.pos;
        packet.pos += noteOnCount;

        @Pc(416) int otherPos = packet.pos;
        packet.pos += otherCount;

        @Pc(425) int noteOffVelocityPos = packet.pos;
        packet.pos += noteOffCount;

        @Pc(434) int modulationWheelFinePos = packet.pos;
        packet.pos += modulationWheelFineCount;

        @Pc(443) int mainVolumeFinePos = packet.pos;
        packet.pos += mainVolumeFineCount;

        @Pc(452) int panFinePos = packet.pos;
        packet.pos += panFineCount;

        @Pc(461) int bankSelectPos = packet.pos;
        packet.pos += bankSelectCount;

        @Pc(470) int pitchBendFinePos = packet.pos;
        packet.pos += pitchBendCount;

        @Pc(479) int nonregisterParamFinePos = packet.pos;
        packet.pos += nonregisteredParamFineCount;

        @Pc(488) int nonregisteredParamCoarsePos = packet.pos;
        packet.pos += nonregisteredParamCoarseCount;

        @Pc(497) int registeredParamFinePos = packet.pos;
        packet.pos += registeredParamFineCount;

        @Pc(506) int registerdParamCoarseBitPos = packet.pos;
        packet.pos += registerdParamCoarseBitCount;

        @Pc(515) int tempPos = packet.pos;
        packet.pos += tempCount * 3;

        this.midiData = new byte[midiLength];
        @Pc(533) Packet midiPacket = new Packet(this.midiData);
        midiPacket.p4(FILE_HEADER);
        midiPacket.p4(FILE_BODY_LENGTH);
        midiPacket.p2(tracks > 1 ? 1 : 0);
        midiPacket.p2(tracks);
        midiPacket.p2(timeDivision);

        packet.pos = timePos;
        @Pc(564) int channel = 0;
        @Pc(566) int noteNumber = 0;
        @Pc(568) int noteOnVelocity = 0;
        @Pc(570) int noteOffVelocity = 0;
        @Pc(572) int pitch = 0;
        @Pc(574) int channelAftertouch = 0;
        @Pc(576) int noteAftertouch = 0;
        @Pc(579) int[] controllers = new int[128];
        controllerType = 0;

        for (@Pc(583) int i = 0; i < tracks; i++) {
            midiPacket.p4(TRACK_HEADER);
            midiPacket.pos += 4;

            @Pc(597) int pos = midiPacket.pos;
            @Pc(599) int lo = -1;

            while (true) {
                @Pc(603) int deltaTime = packet.gVarInt();
                midiPacket.pVarInt(deltaTime);

                @Pc(615) int event = packet.data[eventPos++] & 0xFF;
                @Pc(623) boolean distinct = event != lo;

                lo = event & CHANNEL_MASK;

                if (event == 7) {
                    if (distinct) {
                        midiPacket.p1(255);
                    }

                    midiPacket.p1(47);
                    midiPacket.p1(0);
                    break;
                }

                if (event == 23) {
                    if (distinct) {
                        midiPacket.p1(255);
                    }

                    midiPacket.p1(81);
                    midiPacket.p1(3);
                    midiPacket.p1(packet.data[tempPos++]);
                    midiPacket.p1(packet.data[tempPos++]);
                    midiPacket.p1(packet.data[tempPos++]);
                } else {
                    channel ^= event >> 4;

                    if (lo == 0) {
                        if (distinct) {
                            midiPacket.p1(channel + NOTE_ON);
                        }

                        noteNumber += packet.data[noteCountPos++];
                        noteOnVelocity += packet.data[noteOnVelocityPos++];

                        midiPacket.p1(noteNumber & 0x7F);
                        midiPacket.p1(noteOnVelocity & 0x7F);
                    } else if (lo == 1) {
                        if (distinct) {
                            midiPacket.p1(channel + NOTE_OFF);
                        }

                        noteNumber += packet.data[noteCountPos++];
                        noteOffVelocity += packet.data[noteOffVelocityPos++];

                        midiPacket.p1(noteNumber & 0x7F);
                        midiPacket.p1(noteOffVelocity & 0x7F);
                    } else if (lo == 2) {
                        if (distinct) {
                            midiPacket.p1(channel + CONTROLLER);
                        }

                        controllerType = controllerType + packet.data[controllerPos++] & 0x7F;
                        midiPacket.p1(controllerType);

                        @Pc(830) byte value;
                        if (controllerType == BANK_SELECT_COARSE || controllerType == BANK_SELECT_FINE) {
                            value = packet.data[bankSelectPos++];
                        } else if (controllerType == MODULATION_WHEEL_COARSE) {
                            value = packet.data[modulationWheelCoarsePos++];
                        } else if (controllerType == MODULATION_WHEEL_FINE) {
                            value = packet.data[modulationWheelFinePos++];
                        } else if (controllerType == MAIN_VOLUME_COARSE) {
                            value = packet.data[mainVolumeCoarsePos++];
                        } else if (controllerType == MAIN_VOLUME_FINE) {
                            value = packet.data[mainVolumeFinePos++];
                        } else if (controllerType == PAN_COARSE) {
                            value = packet.data[panCoarsePos++];
                        } else if (controllerType == PAN_FINE) {
                            value = packet.data[panFinePos++];
                        } else if (controllerType == NON_REGISTERED_PARAM_FINE) {
                            value = packet.data[nonregisterParamFinePos++];
                        } else if (controllerType == NON_REGISTERED_PARAM_COARSE) {
                            value = packet.data[nonregisteredParamCoarsePos++];
                        } else if (controllerType == REGISTERED_PARAM_FINE) {
                            value = packet.data[registeredParamFinePos++];
                        } else if (controllerType == REGISTERED_PARAM_COARSE) {
                            value = packet.data[registerdParamCoarseBitPos++];
                        } else if (controllerType == HOLD || controllerType == PORTAMENTO_PEDAL || controllerType == ALL_SOUND_OFF || controllerType == ALL_CONTROLLERS_OFF || controllerType == ALL_NOTES_OFF) {
                            value = packet.data[specialPos++];
                        } else {
                            value = packet.data[otherPos++];
                        }

                        @Pc(973) int controllerValue = value + controllers[controllerType];
                        controllers[controllerType] = controllerValue;
                        midiPacket.p1(controllerValue & 0x7F);
                    } else if (lo == 3) {
                        if (distinct) {
                            midiPacket.p1(channel + PITCH);
                        }

                        pitch += packet.data[pitchBendFinePos++];
                        pitch += packet.data[pitchBendCoarsePos++] << 7;

                        midiPacket.p1(pitch & 0x7F);
                        midiPacket.p1((pitch >> 7) & 0x7F);
                    } else if (lo == 4) {
                        if (distinct) {
                            midiPacket.p1(channel + CHANNEL_AFTERTOUCH);
                        }

                        channelAftertouch += packet.data[channelAftertouchPos++];
                        midiPacket.p1(channelAftertouch & 0x7F);
                    } else if (lo == 5) {
                        if (distinct) {
                            midiPacket.p1(channel + NOTE_AFTERTOUCH);
                        }

                        noteNumber += packet.data[noteCountPos++];
                        noteAftertouch += packet.data[noteAftertouchPos++];
                        midiPacket.p1(noteNumber & 0x7F);
                        midiPacket.p1(noteAftertouch & 0x7F);
                    } else if (lo == 6) {
                        if (distinct) {
                            midiPacket.p1(channel + PROGRAM_CHANGE);
                        }

                        midiPacket.p1(packet.data[bankSelectPos++]);
                    } else {
                        throw new RuntimeException();
                    }
                }
            }

            midiPacket.psize4(midiPacket.pos - pos);
        }
    }

    @OriginalMember(owner = "client!bn", name = "b", descriptor = "()V")
    public void computePrograms() {
        if (this.programs != null) {
            return;
        }

        this.programs = new IterableHashTable(16);

        @Pc(13) int[] extPrograms = new int[16];
        @Pc(16) int[] programs = new int[16];

        extPrograms[9] = programs[9] = 0x80;

        @Pc(30) MidiSequence sequence = new MidiSequence(this.midiData);
        @Pc(33) int tracks = sequence.trackCount();
        for (@Pc(35) int i = 0; i < tracks; i++) {
            sequence.switchTrack(i);
            sequence.step(i);
            sequence.updatePosition(i);
        }

        while (true) {
            @Pc(52) int track = sequence.activeTrack();
            @Pc(57) int delta = sequence.trackDeltas[track];

            while (sequence.trackDeltas[track] == delta) {
                sequence.switchTrack(track);
                @Pc(65) int event = sequence.nextEvent(track);

                if (event == 1) {
                    sequence.endTrack();
                    sequence.updatePosition(track);

                    if (sequence.isComplete()) {
                        return;
                    } else {
                        break;
                    }
                }

                @Pc(84) int status = event & 0xF0;

                if (status == CONTROLLER) {
                    @Pc(91) int channel = event & CHANNEL_MASK;
                    @Pc(97) int controller = (event >> 8) & 0x7F;
                    @Pc(103) int value = (event >> 16) & 0x7F;

                    if (controller == 0) {
                        extPrograms[channel] = (extPrograms[channel] & ~0x1FC000) + (value << 14);
                    }

                    if (controller == 32) {
                        extPrograms[channel] = (extPrograms[channel] & ~0x3F80) + (value << 7);
                    }
                }

                if (status == PROGRAM_CHANGE) {
                    @Pc(91) int channel = event & CHANNEL_MASK;
                    @Pc(97) int program = (event >> 8) & 0x7F;
                    programs[channel] = extPrograms[channel] + program;
                }

                if (status == NOTE_ON) {
                    @Pc(91) int channel = event & CHANNEL_MASK;
                    @Pc(97) int note = (event >> 8) & 0x7F;
                    @Pc(103) int velocity = (event >> 16) & 0x7F;

                    if (velocity > 0) {
                        @Pc(182) int program = programs[channel];
                        @Pc(190) MidiProgramNode node = (MidiProgramNode) this.programs.get(program);

                        if (node == null) {
                            node = new MidiProgramNode(new byte[128]);
                            this.programs.put(program, node);
                        }

                        node.notes[note] = 1;
                    }
                }

                sequence.step(track);
                sequence.updatePosition(track);
            }
        }
    }

    @OriginalMember(owner = "client!bn", name = "a", descriptor = "()V")
    public void resetPrograms() {
        this.programs = null;
    }
}
