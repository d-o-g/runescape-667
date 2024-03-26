import com.jagex.ChangeLocationRequest;
import com.jagex.SignLink;
import com.jagex.core.io.BitPacket;
import com.jagex.game.camera.Shake;
import com.jagex.core.constants.ChatLineType;
import com.jagex.core.constants.HintArrowType;
import com.jagex.core.constants.LocLayer;
import com.jagex.core.io.Packet;
import com.jagex.core.io.connection.Connection;
import com.jagex.core.stringtools.general.Base37;
import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.core.util.JagException;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import com.jagex.game.compression.huffman.WordPack;
import com.jagex.game.runetek6.config.bastype.BASType;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.iftype.SubInterface;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqReplayMode;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationType;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.delta.ClanChannelDelta;
import rs2.client.clan.settings.ClanSettings;

import java.io.IOException;

public final class Protocol {

    @OriginalMember(owner = "client!jr", name = "I", descriptor = "[I")
    public static final int[] LOC_LAYERS_BY_SHAPE = {
        /* 00 */ LocLayer.WALL,
        /* 01 */ LocLayer.WALL,
        /* 02 */ LocLayer.WALL,
        /* 03 */ LocLayer.WALL,
        /* 04 */ LocLayer.WALLDECOR,
        /* 05 */ LocLayer.WALLDECOR,
        /* 06 */ LocLayer.WALLDECOR,
        /* 07 */ LocLayer.WALLDECOR,
        /* 08 */ LocLayer.WALLDECOR,
        /* 09 */ LocLayer.GROUND,
        /* 10 */ LocLayer.GROUND,
        /* 11 */ LocLayer.GROUND,
        /* 12 */ LocLayer.GROUND,
        /* 13 */ LocLayer.GROUND,
        /* 14 */ LocLayer.GROUND,
        /* 15 */ LocLayer.GROUND,
        /* 16 */ LocLayer.GROUND,
        /* 17 */ LocLayer.GROUND,
        /* 18 */ LocLayer.GROUND,
        /* 19 */ LocLayer.GROUND,
        /* 20 */ LocLayer.GROUND,
        /* 21 */ LocLayer.GROUND,
        /* 22 */ LocLayer.GROUNDDECOR
    };

    @OriginalMember(owner = "client!jfa", name = "a", descriptor = "(Lclient!gw;I)Z")
    public static boolean readServerMessage(@OriginalArg(0) ServerConnection arg0) throws IOException {
        @Pc(8) Connection connection = arg0.connection;
        @Pc(11) BitPacket bitPacket = arg0.bitPacket;
        if (connection == null) {
            return false;
        }
        @Pc(100) int local100;
        if (arg0.currentProt == null) {
            if (arg0.needsOpcode) {
                if (!connection.hasAvailable(1)) {
                    return false;
                }
                connection.read(arg0.bitPacket.data, 1, 0);
                arg0.anInt3646 = 0;
                arg0.read++;
                arg0.needsOpcode = false;
            }
            bitPacket.pos = 0;
            if (bitPacket.largeOpcode()) {
                if (!connection.hasAvailable(1)) {
                    return false;
                }
                connection.read(arg0.bitPacket.data, 1, 1);
                arg0.read++;
                arg0.anInt3646 = 0;
            }
            arg0.needsOpcode = true;
            @Pc(96) ServerProt[] local96 = Static585.method7677();
            local100 = bitPacket.readOpcode();
            if (local100 < 0 || local96.length <= local100) {
                throw new IOException("invo:" + local100 + " ip:" + bitPacket.pos);
            }
            arg0.currentProt = local96[local100];
            arg0.currentPacketSize = arg0.currentProt.size;
        }
        if (arg0.currentPacketSize == -1) {
            if (!connection.hasAvailable(1)) {
                return false;
            }
            connection.read(bitPacket.data, 1, 0);
            arg0.currentPacketSize = bitPacket.data[0] & 0xFF;
            arg0.read++;
            arg0.anInt3646 = 0;
        }
        if (arg0.currentPacketSize == -2) {
            if (!connection.hasAvailable(2)) {
                return false;
            }
            connection.read(bitPacket.data, 2, 0);
            bitPacket.pos = 0;
            arg0.currentPacketSize = bitPacket.g2();
            arg0.read += 2;
            arg0.anInt3646 = 0;
        }
        if (arg0.currentPacketSize > 0) {
            if (!connection.hasAvailable(arg0.currentPacketSize)) {
                return false;
            }
            bitPacket.pos = 0;
            connection.read(bitPacket.data, arg0.currentPacketSize, 0);
            arg0.read += arg0.currentPacketSize;
            arg0.anInt3646 = 0;
        }
        arg0.antepenultimateProt = arg0.penultimateProt;
        arg0.penultimateProt = arg0.aServerProt_92;
        arg0.aServerProt_92 = arg0.currentProt;
        @Pc(277) int local277;
        if (Static586.A_SERVER_PROT___215 == arg0.currentProt) {
            local277 = bitPacket.g4_alt1();
            Static574.method7573();
            @Pc(287) SubInterface local287 = (SubInterface) InterfaceManager.subInterfaces.get(local277);
            if (local287 != null) {
                InterfaceManager.closeSubInterface(false, true, local287);
            }
            if (InterfaceManager.dialog != null) {
                InterfaceManager.redraw(InterfaceManager.dialog);
                InterfaceManager.dialog = null;
            }
            arg0.currentProt = null;
            return true;
        } else if (Static133.A_SERVER_PROT___55 == arg0.currentProt) {
            method7912(Static3.A_ZONE_PROT___1);
            arg0.currentProt = null;
            return true;
        } else if (ServerProt.A_SERVER_PROT___52 == arg0.currentProt) {
            method7912(Static77.A_ZONE_PROT___5);
            arg0.currentProt = null;
            return true;
        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___239) {
            local277 = bitPacket.g4_alt2();
            local100 = bitPacket.g1_alt1();
            Static574.method7573();
            DelayedStateChange.interfaceSetHide(local100, local277);
            arg0.currentProt = null;
            return true;
        } else if (Static347.A_SERVER_PROT___146 == arg0.currentProt) {
            method7912(Static420.A_ZONE_PROT___13);
            arg0.currentProt = null;
            return true;
        } else if (Static632.A_SERVER_PROT___229 == arg0.currentProt) {
            Static331.walkText = arg0.currentPacketSize <= 2 ? LocalisedText.WALKHERE.localise(client.language) : bitPacket.gjstr();
            Static331.walkCursor = arg0.currentPacketSize <= 0 ? -1 : bitPacket.g2();
            if (Static331.walkCursor == 65535) {
                Static331.walkCursor = -1;
            }
            arg0.currentProt = null;
            return true;
        } else if (arg0.currentProt == Static504.A_SERVER_PROT___188) {
            method7912(Static565.A_ZONE_PROT___8);
            arg0.currentProt = null;
            return true;
        } else {
            @Pc(446) boolean local446;
            if (arg0.currentProt == Static679.A_SERVER_PROT___247) {
                local446 = bitPacket.g1_alt2() == 1;
                local100 = bitPacket.g4_alt3();
                Static574.method7573();
                DelayedStateChange.interfaceSetClickMask(local100, local446);
                arg0.currentProt = null;
                return true;
            } else if (Static489.A_SERVER_PROT___185 == arg0.currentProt) {
                local277 = bitPacket.g2_alt2();
                local100 = bitPacket.g4_alt1();
                Static574.method7573();
                DelayedStateChange.interfaceSetScrollPosition(local277, local100);
                arg0.currentProt = null;
                return true;
            } else if (Static201.A_SERVER_PROT___206 == arg0.currentProt) {
                local277 = bitPacket.g4_alt1();
                local100 = bitPacket.g2_alt2();
                Static574.method7573();
                DelayedStateChange.interfaceSetVideo(local100, local277);
                arg0.currentProt = null;
                return true;
            } else {
                @Pc(526) int local526;
                if (arg0.currentProt == Static542.A_SERVER_PROT___199) {
                    local277 = bitPacket.g2s_alt1();
                    local100 = bitPacket.g2s_alt1();
                    local526 = bitPacket.g4_alt3();
                    Static574.method7573();
                    DelayedStateChange.interfaceSetPosition(local100, local277, local526);
                    arg0.currentProt = null;
                    return true;
                } else if (arg0.currentProt == Static331.A_SERVER_PROT___139) {
                    Static400.lastClanSettingsTransmit = World.tick;
                    local446 = bitPacket.g1() == 1;
                    if (arg0.currentPacketSize != 1) {
                        if (local446) {
                            Static128.aClanSettings_8 = new ClanSettings(bitPacket);
                        } else {
                            Static91.aClanSettings_9 = new ClanSettings(bitPacket);
                        }
                        arg0.currentProt = null;
                        return true;
                    }
                    arg0.currentProt = null;
                    if (local446) {
                        Static128.aClanSettings_8 = null;
                    } else {
                        Static91.aClanSettings_9 = null;
                    }
                    return true;
                } else {
                    @Pc(629) String local629;
                    @Pc(639) long local639;
                    @Pc(644) long local644;
                    @Pc(649) long local649;
                    @Pc(653) int local653;
                    @Pc(627) String local627;
                    @Pc(657) int local657;
                    @Pc(665) boolean local665;
                    @Pc(667) int local667;
                    if (arg0.currentProt == Static441.A_SERVER_PROT___168) {
                        local446 = bitPacket.g1() == 1;
                        local627 = bitPacket.gjstr();
                        local629 = local627;
                        if (local446) {
                            local629 = bitPacket.gjstr();
                        }
                        local639 = bitPacket.g8();
                        local644 = bitPacket.g2();
                        local649 = bitPacket.g3();
                        local653 = bitPacket.g1();
                        local657 = bitPacket.g2();
                        @Pc(663) long local663 = (local644 << 32) + local649;
                        local665 = false;
                        local667 = 0;
                        while (true) {
                            if (local667 >= 100) {
                                if (local653 <= 1 && Static71.method1524(local629)) {
                                    local665 = true;
                                }
                                break;
                            }
                            if (Static511.aLongArray17[local667] == local663) {
                                local665 = true;
                                break;
                            }
                            local667++;
                        }
                        if (!local665 && Static659.blockChat == 0) {
                            Static511.aLongArray17[Static97.anInt2001] = local663;
                            Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                            @Pc(737) String local737 = QuickChatPhraseTypeList.instance.get(local657).method3903(bitPacket);
                            if (local653 == 2) {
                                ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, local657, local737, Base37.decodeName(local639), 0, local627, ChatLineType.QUICKCHAT_FRIENDCHAT);
                            } else if (local653 == 1) {
                                ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, local657, local737, Base37.decodeName(local639), 0, local627, ChatLineType.QUICKCHAT_FRIENDCHAT);
                            } else {
                                ChatHistory.add(local629, local627, local657, local737, Base37.decodeName(local639), 0, local627, ChatLineType.QUICKCHAT_FRIENDCHAT);
                            }
                        }
                        arg0.currentProt = null;
                        return true;
                    } else if (arg0.currentProt == Static688.A_SERVER_PROT___250) {
                        local446 = bitPacket.g1() == 1;
                        @Pc(854) byte[] local854 = new byte[arg0.currentPacketSize - 1];
                        bitPacket.gdata(0, arg0.currentPacketSize - 1, local854);
                        WorldList.decodeWorldList(local854, local446);
                        arg0.currentProt = null;
                        return true;
                    } else {
                        @Pc(892) boolean local892;
                        if (arg0.currentProt == ServerProt.A_SERVER_PROT___85) {
                            local277 = bitPacket.g4();
                            local892 = bitPacket.g1() == 1;
                            if (Static684.aBoolean775 != local892 || Static134.anInt10326 != local277) {
                                Static134.anInt10326 = local277;
                                Static684.aBoolean775 = local892;
                                ScriptRunner.executeTrigger(Static232.A_CLIENT_TRIGGER_TYPE___6, -1, -1);
                            }
                            arg0.currentProt = null;
                            return true;
                        }
                        @Pc(931) byte local931;
                        if (ServerProt.VARP_SMALL == arg0.currentProt) {
                            local277 = bitPacket.g2();
                            local931 = bitPacket.g1b_alt1();
                            // g.trace("Received small varp variable: " + var18 + " value:" + var78);
                            TimedVarDomain.instance.updateVarp(local277, local931);
                            arg0.currentProt = null;
                            return true;
                        } else if (arg0.currentProt == Static283.A_SERVER_PROT___115) {
                            TimedVarDomain.instance.reset();
                            Static635.varpUpdateCount += 32;
                            arg0.currentProt = null;
                            return true;
                        } else {
                            @Pc(1097) int local1097;
                            @Pc(992) int local992;
                            @Pc(996) int local996;
                            @Pc(1004) boolean local1004;
                            @Pc(1002) long local1002;
                            @Pc(988) long local988;
                            @Pc(1021) int local1021;
                            @Pc(1090) String local1090;
                            @Pc(983) long local983;
                            if (Static224.A_SERVER_PROT___89 == arg0.currentProt) {
                                local446 = bitPacket.g1() == 1;
                                local627 = bitPacket.gjstr();
                                local983 = bitPacket.g2();
                                local988 = bitPacket.g3();
                                local992 = bitPacket.g1();
                                local996 = bitPacket.g2();
                                local1002 = (local983 << 32) + local988;
                                local1004 = false;
                                @Pc(1013) ClanChannel local1013 = local446 ? Static45.aClass2_Sub47_1 : Static674.aClass2_Sub47_3;
                                if (local1013 == null) {
                                    local1004 = true;
                                } else {
                                    label2238:
                                    {
                                        for (local1021 = 0; local1021 < 100; local1021++) {
                                            if (Static511.aLongArray17[local1021] == local1002) {
                                                local1004 = true;
                                                break label2238;
                                            }
                                        }
                                        if (local992 <= 1 && Static71.method1524(local627)) {
                                            local1004 = true;
                                        }
                                    }
                                }
                                if (!local1004 && Static659.blockChat == 0) {
                                    Static511.aLongArray17[Static97.anInt2001] = local1002;
                                    Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                    local1090 = QuickChatPhraseTypeList.instance.get(local996).method3903(bitPacket);
                                    local1097 = local446 ? ChatLineType.QUICKCHAT_CLANCHANNEL_AFFINED : ChatLineType.QUICKCHAT_CLANCHANNEL_UNAFFINED;
                                    if (local992 == 2 || local992 == 3) {
                                        ChatHistory.add("<img=1>" + local627, "<img=1>" + local627, local996, local1090, local1013.channelName, 0, local627, local1097);
                                    } else if (local992 == 1) {
                                        ChatHistory.add("<img=0>" + local627, "<img=0>" + local627, local996, local1090, local1013.channelName, 0, local627, local1097);
                                    } else {
                                        ChatHistory.add(local627, local627, local996, local1090, local1013.channelName, 0, local627, local1097);
                                    }
                                }
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static314.A_SERVER_PROT___132) {
                                for (local277 = 0; local277 < PlayerList.highResolutionPlayers.length; local277++) {
                                    if (PlayerList.highResolutionPlayers[local277] != null) {
                                        PlayerList.highResolutionPlayers[local277].actionAnimations = null;
                                        PlayerList.highResolutionPlayers[local277].actionAnimator.update(true, -1);
                                    }
                                }
                                for (local100 = 0; local100 < NPCList.newNpcCount; local100++) {
                                    NPCList.localNpcs[local100].npc.actionAnimations = null;
                                    NPCList.localNpcs[local100].npc.actionAnimator.update(true, -1);
                                }
                                arg0.currentProt = null;
                                return true;
                            } else if (Static232.A_SERVER_PROT___103 == arg0.currentProt) {
                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                arg0.currentProt = null;
                                return true;
                            } else if (Static346.A_SERVER_PROT___145 == arg0.currentProt) {
                                Static324.reduceAttackPriority = bitPacket.g1_alt3() == 1;
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static619.A_SERVER_PROT___34) {
                                Minimap.toggle = bitPacket.g1();
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static416.A_SERVER_PROT___165) {
                                local277 = bitPacket.g4_alt2();
                                local100 = bitPacket.g2_alt2();
                                if (local100 == 65535) {
                                    local100 = -1;
                                }
                                Static574.method7573();
                                DelayedStateChange.method6462(local100, 1, -1, local277);
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static286.A_SERVER_PROT___117) {
                                method7912(Static370.A_ZONE_PROT___11);
                                arg0.currentProt = null;
                                return true;
                            } else if (Static432.A_SERVER_PROT___10 == arg0.currentProt) {
                                Login.logout(InterfaceManager.lobbyOpened);
                                arg0.currentProt = null;
                                return false;
                            } else {
                                @Pc(1449) int local1449;
                                @Pc(1409) int local1409;
                                @Pc(1413) int local1413;
                                @Pc(1425) boolean local1425;
                                @Pc(1427) String local1427;
                                @Pc(1750) String local1750;
                                @Pc(1491) boolean local1491;
                                if (arg0.currentProt == Static320.A_SERVER_PROT___135) {
                                    while (bitPacket.pos < arg0.currentPacketSize) {
                                        local446 = bitPacket.g1() == 1;
                                        local627 = bitPacket.gjstr();
                                        local629 = bitPacket.gjstr();
                                        local1409 = bitPacket.g2();
                                        local1413 = bitPacket.g1();
                                        local1425 = bitPacket.g1() == 1;
                                        local1427 = "";
                                        @Pc(1429) boolean local1429 = false;
                                        if (local1409 > 0) {
                                            local1427 = bitPacket.gjstr();
                                            local1429 = bitPacket.g1() == 1;
                                        }
                                        for (local1449 = 0; local1449 < FriendsList.count; local1449++) {
                                            if (local446) {
                                                if (local629.equals(FriendsList.names[local1449])) {
                                                    FriendsList.names[local1449] = local627;
                                                    local627 = null;
                                                    Static572.aStringArray42[local1449] = local629;
                                                    break;
                                                }
                                            } else if (local627.equals(FriendsList.names[local1449])) {
                                                if (FriendsList.worlds[local1449] != local1409) {
                                                    local1491 = true;
                                                    for (@Pc(1496) Class8_Sub4_Sub1 local1496 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local1496 != null; local1496 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                        if (local1496.aString72.equals(local627)) {
                                                            if (local1409 != 0 && local1496.aShort74 == 0) {
                                                                local1491 = false;
                                                                local1496.unlink();
                                                            } else if (local1409 == 0 && local1496.aShort74 != 0) {
                                                                local1491 = false;
                                                                local1496.unlink();
                                                            }
                                                        }
                                                    }
                                                    if (local1491) {
                                                        Static168.A_ENTITY_LIST___5.add(new Class8_Sub4_Sub1(local627, local1409));
                                                    }
                                                    FriendsList.worlds[local1449] = local1409;
                                                }
                                                Static572.aStringArray42[local1449] = local629;
                                                Static419.aStringArray33[local1449] = local1427;
                                                Static715.anIntArray881[local1449] = local1413;
                                                Static623.aBooleanArray30[local1449] = local1429;
                                                local627 = null;
                                                Static429.aBooleanArray21[local1449] = local1425;
                                                break;
                                            }
                                        }
                                        if (local627 != null && FriendsList.count < 200) {
                                            FriendsList.names[FriendsList.count] = local627;
                                            Static572.aStringArray42[FriendsList.count] = local629;
                                            FriendsList.worlds[FriendsList.count] = local1409;
                                            Static419.aStringArray33[FriendsList.count] = local1427;
                                            Static715.anIntArray881[FriendsList.count] = local1413;
                                            Static623.aBooleanArray30[FriendsList.count] = local1429;
                                            Static429.aBooleanArray21[FriendsList.count] = local1425;
                                            FriendsList.count++;
                                        }
                                    }
                                    Static344.lastFriendTransmit = World.tick;
                                    Static251.anInt4036 = 2;
                                    local100 = FriendsList.count;
                                    while (local100 > 0) {
                                        local446 = true;
                                        local100--;
                                        for (local526 = 0; local526 < local100; local526++) {
                                            @Pc(1665) boolean local1665 = false;
                                            if (client.gameConnection.id != FriendsList.worlds[local526] && client.gameConnection.id == FriendsList.worlds[local526 + 1]) {
                                                local1665 = true;
                                            }
                                            if (!local1665 && FriendsList.worlds[local526] == 0 && FriendsList.worlds[local526 + 1] != 0) {
                                                local1665 = true;
                                            }
                                            if (!local1665 && !Static429.aBooleanArray21[local526] && Static429.aBooleanArray21[local526 + 1]) {
                                                local1665 = true;
                                            }
                                            if (local1665) {
                                                local1413 = FriendsList.worlds[local526];
                                                FriendsList.worlds[local526] = FriendsList.worlds[local526 + 1];
                                                FriendsList.worlds[local526 + 1] = local1413;
                                                local1750 = Static419.aStringArray33[local526];
                                                Static419.aStringArray33[local526] = Static419.aStringArray33[local526 + 1];
                                                Static419.aStringArray33[local526 + 1] = local1750;
                                                local1427 = FriendsList.names[local526];
                                                FriendsList.names[local526] = FriendsList.names[local526 + 1];
                                                FriendsList.names[local526 + 1] = local1427;
                                                @Pc(1786) String local1786 = Static572.aStringArray42[local526];
                                                Static572.aStringArray42[local526] = Static572.aStringArray42[local526 + 1];
                                                Static572.aStringArray42[local526 + 1] = local1786;
                                                local1449 = Static715.anIntArray881[local526];
                                                Static715.anIntArray881[local526] = Static715.anIntArray881[local526 + 1];
                                                Static715.anIntArray881[local526 + 1] = local1449;
                                                local1491 = Static623.aBooleanArray30[local526];
                                                Static623.aBooleanArray30[local526] = Static623.aBooleanArray30[local526 + 1];
                                                Static623.aBooleanArray30[local526 + 1] = local1491;
                                                local1004 = Static429.aBooleanArray21[local526];
                                                Static429.aBooleanArray21[local526] = Static429.aBooleanArray21[local526 + 1];
                                                local446 = false;
                                                Static429.aBooleanArray21[local526 + 1] = local1004;
                                            }
                                        }
                                        if (local446) {
                                            break;
                                        }
                                    }
                                    arg0.currentProt = null;
                                    return true;
                                } else if (Static207.A_SERVER_PROT___128 == arg0.currentProt) {
                                    local277 = bitPacket.g1_alt3();
                                    local931 = bitPacket.g1b_alt3();
                                    Static574.method7573();
                                    Static711.method9271(local931, local277);
                                    arg0.currentProt = null;
                                    return true;
                                } else if (ServerProt.VARBIT_LARGE == arg0.currentProt) {
                                    local277 = bitPacket.g4();
                                    local100 = bitPacket.g2();
                                    // g.trace("Received big varbit variable: " + var18 + " value:" + var4);
                                    TimedVarDomain.instance.updateVarBitValue(local277, local100);
                                    arg0.currentProt = null;
                                    return true;
                                } else {
                                    @Pc(1937) String local1937;
                                    if (arg0.currentProt == ServerProt.A_SERVER_PROT___37) {
                                        local1937 = bitPacket.gjstr();
                                        local100 = bitPacket.g2();
                                        local629 = QuickChatPhraseTypeList.instance.get(local100).method3903(bitPacket);
                                        ChatHistory.add(local1937, local1937, local100, local629, null, 0, local1937, ChatLineType.QUICKCHAT_PRIVATE_ECHO);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (arg0.currentProt == Static526.A_SERVER_PROT___194) {
                                        local277 = bitPacket.g2();
                                        if (local277 == 65535) {
                                            local277 = -1;
                                        }
                                        local100 = bitPacket.g1();
                                        local526 = bitPacket.g2();
                                        local1409 = bitPacket.g1();
                                        local1413 = bitPacket.g2();
                                        Static186.method2818(local277, local100, local1413, local526, local1409, false);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (Static618.A_SERVER_PROT___226 == arg0.currentProt) {
                                        local277 = bitPacket.ig2();
                                        Static574.method7573();
                                        VideoTypeList.method9267(local277);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (arg0.currentProt == Static286.A_SERVER_PROT___118) {
                                        local277 = bitPacket.g4_alt2();
                                        local100 = bitPacket.g2_alt3();
                                        if (local100 == 65535) {
                                            local100 = -1;
                                        }
                                        Static574.method7573();
                                        DelayedStateChange.interfaceSetTextFont(local277, local100);
                                        arg0.currentProt = null;
                                        return true;
                                    } else {
                                        @Pc(2080) boolean local2080;
                                        @Pc(2098) int local2098;
                                        if (arg0.currentProt == ServerProt.A_SERVER_PROT___43) {
                                            local277 = bitPacket.g2();
                                            local100 = bitPacket.g1();
                                            local2080 = (local100 & 0x1) == 1;
                                            Static205.method3089(local277, local2080);
                                            local1409 = bitPacket.g2();
                                            for (local1413 = 0; local1413 < local1409; local1413++) {
                                                local2098 = bitPacket.g1();
                                                if (local2098 == 255) {
                                                    local2098 = bitPacket.g4();
                                                }
                                                local992 = bitPacket.ig2();
                                                Static341.method5034(local2080, local2098, local1413, local992 - 1, local277);
                                            }
                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static663.A_SERVER_PROT___240 == arg0.currentProt) {
                                            local277 = bitPacket.g4();
                                            Static439.aSignedResource_4 = SignLink.instance.lookupHostname(local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static312.A_SERVER_PROT___131 == arg0.currentProt) {
                                            local277 = bitPacket.ig2();
                                            local100 = bitPacket.g4();
                                            Static574.method7573();
                                            DelayedStateChange.setVarc(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static452.A_SERVER_PROT___173) {
                                            local277 = bitPacket.g4_alt3();
                                            local100 = bitPacket.g2();
                                            local526 = bitPacket.g2_alt3();
                                            local1409 = bitPacket.g2_alt2();
                                            Static574.method7573();
                                            DelayedStateChange.method6462(local1409 << 16 | local526, 7, local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static655.A_SERVER_PROT___237) {
                                            local277 = bitPacket.g4();
                                            Static574.method7573();
                                            DelayedStateChange.method6462(PlayerList.activePlayerSlot, 5, 0, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (ServerProt.A_SERVER_PROT___147 == arg0.currentProt) {
                                            Login.logout(false);
                                            arg0.currentProt = null;
                                            return false;
                                        } else if (arg0.currentProt == Static291.A_SERVER_PROT___123) {
                                            Static466.rebuildRegion();
                                            arg0.currentProt = null;
                                            return false;
                                        } else if (arg0.currentProt == Static526.A_SERVER_PROT___195) {
                                            local277 = bitPacket.g2();
                                            local100 = bitPacket.g1();
                                            local2080 = (local100 & 0x1) == 1;
                                            while (arg0.currentPacketSize > bitPacket.pos) {
                                                local1409 = bitPacket.gsmart();
                                                local1413 = bitPacket.g2();
                                                local2098 = 0;
                                                if (local1413 != 0) {
                                                    local2098 = bitPacket.g1();
                                                    if (local2098 == 255) {
                                                        local2098 = bitPacket.g4();
                                                    }
                                                }
                                                Static341.method5034(local2080, local2098, local1409, local1413 - 1, local277);
                                            }
                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static383.A_SERVER_PROT___155 == arg0.currentProt) {
                                            local1937 = bitPacket.gjstr();
                                            @Pc(2379) Object[] local2379 = new Object[local1937.length() + 1];
                                            for (local526 = local1937.length() - 1; local526 >= 0; local526--) {
                                                if (local1937.charAt(local526) == 's') {
                                                    local2379[local526 + 1] = bitPacket.gjstr();
                                                } else {
                                                    local2379[local526 + 1] = Integer.valueOf(bitPacket.g4());
                                                }
                                            }
                                            local2379[0] = Integer.valueOf(bitPacket.g4());
                                            Static574.method7573();
                                            @Pc(2442) HookRequest local2442 = new HookRequest();
                                            local2442.arguments = local2379;
                                            ScriptRunner.executeHookInner(local2442);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static356.A_SERVER_PROT___149) {
                                            local277 = bitPacket.ig2();
                                            local100 = bitPacket.g4();
                                            Static574.method7573();
                                            DelayedStateChange.interfaceSetGraphic(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static491.A_SERVER_PROT___254) {
                                            Static494.anInt7404 = bitPacket.g2s();
                                            arg0.currentProt = null;
                                            Static321.lastMiscTransmit = World.tick;
                                            return true;
                                        } else if (Static608.A_SERVER_PROT___222 == arg0.currentProt) {
                                            local277 = bitPacket.g2_alt3();
                                            local100 = bitPacket.g1_alt3();
                                            Static574.method7573();
                                            if (local100 == 2) {
                                                Static322.method9441();
                                            }
                                            InterfaceManager.topLevelInterface = local277;
                                            InterfaceManager.restartInterfaceAnims(local277);
                                            InterfaceManager.refreshTopLevelInterface(false);
                                            ScriptRunner.executeOnLoad(InterfaceManager.topLevelInterface);
                                            for (local526 = 0; local526 < 100; local526++) {
                                                InterfaceManager.dirtyRectangles[local526] = true;
                                            }
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static641.A_SERVER_PROT___234 == arg0.currentProt) {
                                            Static708.method9230(bitPacket.gjstr());
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___16) {
                                            local277 = bitPacket.g1_alt2();
                                            @Pc(2579) int[] local2579 = new int[4];
                                            for (local526 = 0; local526 < 4; local526++) {
                                                local2579[local526] = bitPacket.g2_alt3();
                                            }
                                            local1409 = bitPacket.g2_alt2();
                                            @Pc(2608) NPCEntityNode local2608 = (NPCEntityNode) NPCList.local.get(local1409);
                                            if (local2608 != null) {
                                                Static651.animate(local2579, local277, true, local2608.npc);
                                            }
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static72.A_SERVER_PROT___35) {
                                            if (MainLogicManager.isAtLobbyScreen(MainLogicManager.step)) {
                                                Static249.anInt4008 = (int) ((float) bitPacket.g2() * 2.5F);
                                            } else {
                                                Static249.anInt4008 = bitPacket.g2() * 30;
                                            }
                                            arg0.currentProt = null;
                                            Static321.lastMiscTransmit = World.tick;
                                            return true;
                                        } else if (Static565.A_SERVER_PROT___76 == arg0.currentProt) {
                                            Static486.aByte115 = bitPacket.g1b();
                                            arg0.currentProt = null;
                                            if (Static486.aByte115 == 0 || Static486.aByte115 == 1) {
                                                Static587.aBoolean663 = true;
                                            }
                                            return true;
                                        } else if (ServerProt.VARP_LARGE == arg0.currentProt) {
                                            local277 = bitPacket.g4_alt3();
                                            local100 = bitPacket.g2_alt2();
                                            // g.trace("Received big varp variable: " + var18 + " value:" + var4);
                                            TimedVarDomain.instance.updateVarp(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static229.A_SERVER_PROT___101) {
                                            Static39.lastClanChannelTransmit = World.tick;
                                            local446 = bitPacket.g1() == 1;
                                            @Pc(2736) ClanChannelDelta local2736 = new ClanChannelDelta(bitPacket);
                                            @Pc(2740) ClanChannel local2740;
                                            if (local446) {
                                                local2740 = Static45.aClass2_Sub47_1;
                                            } else {
                                                local2740 = Static674.aClass2_Sub47_3;
                                            }
                                            local2736.applyToClanChannel(local2740);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static587.A_SERVER_PROT___216 == arg0.currentProt) {
                                            local277 = bitPacket.g4_alt2();
                                            local100 = bitPacket.g2();
                                            Static574.method7573();
                                            DelayedStateChange.interfaceSetColour(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static344.A_SERVER_PROT___144 == arg0.currentProt) {
                                            local277 = bitPacket.g4_alt1();
                                            Static574.method7573();
                                            if (local277 == -1) {
                                                Camera.anInt10383 = -1;
                                                Camera.anInt10376 = -1;
                                            } else {
                                                local100 = local277 >> 14 & 0x3FFF;
                                                local526 = local277 & 0x3FFF;
                                                local100 -= WorldMap.areaBaseX;
                                                if (local100 < 0) {
                                                    local100 = 0;
                                                } else if (Static720.mapWidth <= local100) {
                                                    local100 = Static720.mapWidth;
                                                }
                                                local526 -= WorldMap.areaBaseZ;
                                                Camera.anInt10376 = (local100 << 9) + 256;
                                                if (local526 < 0) {
                                                    local526 = 0;
                                                } else if (local526 >= Static501.mapHeight) {
                                                    local526 = Static501.mapHeight;
                                                }
                                                Camera.anInt10383 = (local526 << 9) + 256;
                                            }
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static491.A_SERVER_PROT___253) {
                                            Static696.method9035();
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static14.A_SERVER_PROT___5 == arg0.currentProt) {
                                            local277 = bitPacket.g2();
                                            local931 = bitPacket.g1b();
                                            if (Static279.anObjectArray35 == null) {
                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                            }
                                            Static279.anObjectArray35[local277] = Integer.valueOf(local931);
                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (ServerProt.A_SERVER_PROT___18 == arg0.currentProt) {
                                            local277 = bitPacket.g2();
                                            Static607.anInt9251 = -1;
                                            CutsceneManager.cutsceneId = local277;
                                            CutsceneManager.state = 1;
                                            js5.CUTSCENES.fileready(CutsceneManager.cutsceneId);
                                            local100 = bitPacket.g2();
                                            Static322.anIntArrayArray265 = new int[local100][4];
                                            for (local526 = 0; local526 < local100; local526++) {
                                                for (local1409 = 0; local1409 < 4; local1409++) {
                                                    Static322.anIntArrayArray265[local526][local1409] = bitPacket.g4();
                                                }
                                            }
                                            local1409 = bitPacket.g1();
                                            Static518.aClass2_Sub21_18 = new Packet(local1409);
                                            Static518.aClass2_Sub21_18.pdata(local1409, bitPacket.data, bitPacket.pos);
                                            bitPacket.pos += local1409;
                                            arg0.currentProt = null;
                                            return false;
                                        } else {
                                            @Pc(3044) byte[] local3044;
                                            if (ServerProt.A_SERVER_PROT___251 == arg0.currentProt) {
                                                if (GameShell.fsframe != null) {
                                                    InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                                                }
                                                local3044 = new byte[arg0.currentPacketSize];
                                                bitPacket.readEncrypted(local3044, arg0.currentPacketSize);
                                                local627 = Cp1252.decode(0, local3044, arg0.currentPacketSize);
                                                Static664.method8655(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local627, true, SignLink.instance);
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (arg0.currentProt == Static444.A_SERVER_PROT___169) {
                                                local446 = bitPacket.g1() == 1;
                                                local627 = bitPacket.gjstr();
                                                local629 = local627;
                                                if (local446) {
                                                    local629 = bitPacket.gjstr();
                                                }
                                                local639 = bitPacket.g2();
                                                local644 = bitPacket.g3();
                                                local996 = bitPacket.g1();
                                                local1449 = bitPacket.g2();
                                                @Pc(3134) long local3134 = local644 + (local639 << 32);
                                                @Pc(3136) boolean local3136 = false;
                                                local1021 = 0;
                                                while (true) {
                                                    if (local1021 >= 100) {
                                                        if (local996 <= 1 && Static71.method1524(local629)) {
                                                            local3136 = true;
                                                        }
                                                        break;
                                                    }
                                                    if (local3134 == Static511.aLongArray17[local1021]) {
                                                        local3136 = true;
                                                        break;
                                                    }
                                                    local1021++;
                                                }
                                                if (!local3136 && Static659.blockChat == 0) {
                                                    Static511.aLongArray17[Static97.anInt2001] = local3134;
                                                    Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                    local1090 = QuickChatPhraseTypeList.instance.get(local1449).method3903(bitPacket);
                                                    if (local996 == 2) {
                                                        ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, local1449, local1090, null, 0, local627, ChatLineType.QUICKCHAT_PRIVATE);
                                                    } else if (local996 == 1) {
                                                        ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, local1449, local1090, null, 0, local627, ChatLineType.QUICKCHAT_PRIVATE);
                                                    } else {
                                                        ChatHistory.add(local629, local627, local1449, local1090, null, 0, local627, ChatLineType.QUICKCHAT_PRIVATE);
                                                    }
                                                }
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (ServerProt.VARBIT_SMALL == arg0.currentProt) {
                                                local277 = bitPacket.g1_alt3();
                                                local100 = bitPacket.g2_alt2();
                                                // g.trace("Received small varbit variable: " + var18 + " value:" + var4);
                                                TimedVarDomain.instance.updateVarBitValue(local277, local100);
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (Static636.A_SERVER_PROT___230 == arg0.currentProt) {
                                                local277 = bitPacket.g1_alt3();
                                                local100 = bitPacket.g1_alt1();
                                                local526 = bitPacket.g4_alt1();
                                                Static237.anIntArray518[local100] = local526;
                                                Static581.anIntArray688[local100] = local277;
                                                Static498.anIntArray604[local100] = 1;
                                                local1409 = Static245.anIntArray773[local100] - 1;
                                                for (local1413 = 0; local1413 < local1409; local1413++) {
                                                    if (Static293.XP_TABLE[local1413] <= local526) {
                                                        Static498.anIntArray604[local100] = local1413 + 2;
                                                    }
                                                }
                                                Static395.anIntArray833[Static366.statUpdateCount++ & 0x1F] = local100;
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___129) {
                                                Static726.aClass280_7 = Static189.method2864(bitPacket.g1());
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (Static410.A_SERVER_PROT___163 == arg0.currentProt) {
                                                local277 = bitPacket.g1_alt3();
                                                local100 = bitPacket.g4();
                                                local526 = bitPacket.ig2();
                                                local1409 = bitPacket.ig2();
                                                Static574.method7573();
                                                DelayedStateChange.interfaceSetRecol(local277, local1409, local100, local526);
                                                arg0.currentProt = null;
                                                return true;
                                            } else {
                                                @Pc(3502) int local3502;
                                                @Pc(3582) String local3582;
                                                if (arg0.currentProt == Static266.A_SERVER_PROT___191) {
                                                    local446 = bitPacket.g1() == 1;
                                                    local627 = bitPacket.gjstr();
                                                    local983 = bitPacket.g2();
                                                    local988 = bitPacket.g3();
                                                    local992 = bitPacket.g1();
                                                    local649 = (local983 << 32) + local988;
                                                    local1491 = false;
                                                    @Pc(3494) ClanChannel local3494 = local446 ? Static45.aClass2_Sub47_1 : Static674.aClass2_Sub47_3;
                                                    if (local3494 == null) {
                                                        local1491 = true;
                                                    } else {
                                                        label2266:
                                                        {
                                                            for (local3502 = 0; local3502 < 100; local3502++) {
                                                                if (local649 == Static511.aLongArray17[local3502]) {
                                                                    local1491 = true;
                                                                    break label2266;
                                                                }
                                                            }
                                                            if (local992 <= 1) {
                                                                if (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724) {
                                                                    local1491 = true;
                                                                } else if (Static71.method1524(local627)) {
                                                                    local1491 = true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (!local1491 && Static659.blockChat == 0) {
                                                        Static511.aLongArray17[Static97.anInt2001] = local649;
                                                        Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                        local3582 = Static130.method2280(WordPack.decode(bitPacket));
                                                        local1021 = local446 ? ChatLineType.CLANCHANNEL_AFFINED : ChatLineType.CLANCHANNEL_UNAFFINED;
                                                        if (local992 == 2 || local992 == 3) {
                                                            ChatHistory.add("<img=1>" + local627, "<img=1>" + local627, -1, local3582, local3494.channelName, 0, local627, local1021);
                                                        } else if (local992 == 1) {
                                                            ChatHistory.add("<img=0>" + local627, "<img=0>" + local627, -1, local3582, local3494.channelName, 0, local627, local1021);
                                                        } else {
                                                            ChatHistory.add(local627, local627, -1, local3582, local3494.channelName, 0, local627, local1021);
                                                        }
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static618.A_SERVER_PROT___227) {
                                                    local277 = bitPacket.g1();
                                                    local100 = local277 >> 5;
                                                    local526 = local277 & 0x1F;
                                                    if (local526 == 0) {
                                                        Static527.hintArrows[local100] = null;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    }
                                                    @Pc(3721) HintArrow hintArrow = new HintArrow();
                                                    hintArrow.type = local526;
                                                    hintArrow.sprite = bitPacket.g1();
                                                    if (hintArrow.sprite >= 0 && hintArrow.sprite < Sprites.hintHeadicons.length) {
                                                        if (hintArrow.type == HintArrowType.NPC || hintArrow.type == HintArrowType.PLAYER) {
                                                            hintArrow.entity = bitPacket.g2();
                                                            hintArrow.flashRate = bitPacket.g2();
                                                            bitPacket.pos += 4;
                                                        } else if (hintArrow.type >= HintArrowType.TILE_CENTRE && hintArrow.type <= HintArrowType.TILE_NORTH) {
                                                            if (hintArrow.type == HintArrowType.TILE_CENTRE) {
                                                                hintArrow.z = 256;
                                                                hintArrow.x = 256;
                                                            }
                                                            if (hintArrow.type == HintArrowType.TILE_WEST) {
                                                                hintArrow.x = 0;
                                                                hintArrow.z = 256;
                                                            }
                                                            if (hintArrow.type == HintArrowType.TILE_EAST) {
                                                                hintArrow.x = 512;
                                                                hintArrow.z = 256;
                                                            }
                                                            if (hintArrow.type == HintArrowType.TILE_SOUTH) {
                                                                hintArrow.z = 0;
                                                                hintArrow.x = 256;
                                                            }
                                                            if (hintArrow.type == HintArrowType.TILE_NORTH) {
                                                                hintArrow.z = 512;
                                                                hintArrow.x = 256;
                                                            }

                                                            hintArrow.type = 2;
                                                            hintArrow.level = bitPacket.g1();
                                                            hintArrow.x += bitPacket.g2() - WorldMap.areaBaseX << 9;
                                                            hintArrow.z += bitPacket.g2() - WorldMap.areaBaseZ << 9;
                                                            hintArrow.y = bitPacket.g1() << 2;
                                                            hintArrow.drawDistance = bitPacket.g2();
                                                        }

                                                        hintArrow.model = bitPacket.g2();
                                                        if (hintArrow.model == 65535) {
                                                            hintArrow.model = -1;
                                                        }

                                                        Static527.hintArrows[local100] = hintArrow;
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static428.A_SERVER_PROT___167) {
                                                    local277 = bitPacket.g1_alt3();
                                                    Static574.method7573();
                                                    arg0.currentProt = null;
                                                    Static150.anInt2632 = local277;
                                                    return true;
                                                } else if (arg0.currentProt == Static309.A_SERVER_PROT___130) {
                                                    bitPacket.pos += 28;
                                                    if (bitPacket.checkcrc()) {
                                                        Static83.method1608(bitPacket.pos - 28, bitPacket);
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static303.A_SERVER_PROT___126) {
                                                    local277 = bitPacket.ig2();
                                                    if (local277 == 65535) {
                                                        local277 = -1;
                                                    }
                                                    local100 = bitPacket.g4();
                                                    local526 = bitPacket.g4_alt3();
                                                    Static574.method7573();
                                                    DelayedStateChange.interfaceSetObject(local526, local100, local277);
                                                    @Pc(4005) ObjType local4005 = ObjTypeList.instance.list(local277);
                                                    DelayedStateChange.interfaceSetModelAngle(local4005.xan2d, local4005.zoom2d, local526, local4005.yan2d);
                                                    DelayedStateChange.interfaceSetModelOffset(local4005.zan2d, local526, local4005.yof2d, local4005.xof2d);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static208.A_SERVER_PROT___83) {
                                                    local277 = bitPacket.g1_alt3();
                                                    local100 = bitPacket.g2();
                                                    Static574.method7573();
                                                    VideoTypeList.method6802(true, local100, local277);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static479.A_SERVER_PROT___177) {
                                                    local446 = bitPacket.g1_alt2() == 1;
                                                    Static574.method7573();
                                                    Static501.aBoolean576 = local446;
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static557.A_SERVER_PROT___205) {
                                                    local277 = bitPacket.g1();
                                                    if (bitPacket.g1() == 0) {
                                                        Static105.aClass171Array1[local277] = new Class171();
                                                    } else {
                                                        bitPacket.pos--;
                                                        Static105.aClass171Array1[local277] = new Class171(bitPacket);
                                                    }
                                                    Static526.lastStockTransmit = World.tick;
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (Static334.A_SERVER_PROT___140 == arg0.currentProt) {
                                                    local277 = bitPacket.g2_alt3();
                                                    Static574.method7573();
                                                    VideoManager.stop(local277);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (Static166.A_SERVER_PROT___63 == arg0.currentProt) {
                                                    method7912(Static668.A_ZONE_PROT___16);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else {
                                                    @Pc(4175) String local4175;
                                                    @Pc(4177) String local4177;
                                                    if (arg0.currentProt == Static408.A_SERVER_PROT___162) {
                                                        local277 = bitPacket.gsmart();
                                                        local100 = bitPacket.g4();
                                                        local526 = bitPacket.g1();
                                                        local4175 = "";
                                                        local4177 = local4175;
                                                        if ((local526 & 0x1) != 0) {
                                                            local4175 = bitPacket.gjstr();
                                                            if ((local526 & 0x2) == 0) {
                                                                local4177 = local4175;
                                                            } else {
                                                                local4177 = bitPacket.gjstr();
                                                            }
                                                        }
                                                        local1750 = bitPacket.gjstr();
                                                        if (local277 == ChatLineType.CONSOLE_PRINT) {
                                                            debugconsole.addline(local1750);
                                                        } else if (local277 == ChatLineType.CONSOLE_SET) {
                                                            debugconsole.set(local1750);
                                                        } else if (local4177.equals("") || !Static71.method1524(local4177)) {
                                                            ChatHistory.add(local1750, local4175, local100, local4175, local4177, local277);
                                                        } else {
                                                            arg0.currentProt = null;
                                                            return true;
                                                        }
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (arg0.currentProt == Static481.A_SERVER_PROT___178) {
                                                        arg0.currentProt = null;
                                                        Static279.anObjectArray35 = null;
                                                        return true;
                                                    } else if (Static51.A_SERVER_PROT___30 == arg0.currentProt) {
                                                        local277 = bitPacket.g2_alt3();
                                                        local627 = bitPacket.gjstr();
                                                        Static574.method7573();
                                                        DelayedStateChange.setVarcstr(local277, local627);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (arg0.currentProt == Static231.CAMERA_SHAKE) {
                                                        local277 = bitPacket.g1_alt3();
                                                        local100 = bitPacket.g1_alt1();
                                                        local526 = bitPacket.g2_alt3();
                                                        local1409 = bitPacket.g1_alt3();
                                                        local1413 = bitPacket.g1_alt3();
                                                        Static574.method7573();
                                                        Shake.enabled[local100] = true;
                                                        Shake.center[local100] = local1409;
                                                        Shake.amplitude[local100] = local1413;
                                                        Shake.frequency[local100] = local277;
                                                        Shake.time[local100] = local526;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (ServerProt.SOUND_AREA == arg0.currentProt) {
                                                        method7912(Static481.A_ZONE_PROT___15);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static225.A_SERVER_PROT___90 == arg0.currentProt) {
                                                        Static436.anInt3849 = bitPacket.g1();
                                                        for (local277 = 0; local277 < Static436.anInt3849; local277++) {
                                                            Static632.aStringArray44[local277] = bitPacket.gjstr();
                                                            Static446.aStringArray35[local277] = bitPacket.gjstr();
                                                            if (Static446.aStringArray35[local277].equals("")) {
                                                                Static446.aStringArray35[local277] = Static632.aStringArray44[local277];
                                                            }
                                                            Static10.aStringArray1[local277] = bitPacket.gjstr();
                                                            Static316.aStringArray41[local277] = bitPacket.gjstr();
                                                            if (Static316.aStringArray41[local277].equals("")) {
                                                                Static316.aStringArray41[local277] = Static10.aStringArray1[local277];
                                                            }
                                                            Static65.aBooleanArray2[local277] = false;
                                                        }
                                                        Static344.lastFriendTransmit = World.tick;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static570.A_SERVER_PROT___208 == arg0.currentProt) {
                                                        method7912(Static379.A_ZONE_PROT___12);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static273.A_SERVER_PROT___113 == arg0.currentProt) {
                                                        local277 = bitPacket.g1_alt1();
                                                        local100 = bitPacket.ig2();
                                                        if (local100 == 65535) {
                                                            local100 = -1;
                                                        }
                                                        local629 = bitPacket.gjstr();
                                                        local1409 = bitPacket.g1_alt2();
                                                        if (local1409 >= 1 && local1409 <= 8) {
                                                            if (local629.equalsIgnoreCase("null")) {
                                                                local629 = null;
                                                            }
                                                            MiniMenu.playerOps[local1409 - 1] = local629;
                                                            Static147.playerOpCursors[local1409 - 1] = local100;
                                                            Static601.playerOpsReducedPriority[local1409 - 1] = local277 == 0;
                                                        }
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else {
                                                        @Pc(4611) ServerActiveProperties local4611;
                                                        @Pc(4597) ServerActiveProperties local4597;
                                                        if (arg0.currentProt == Static161.A_SERVER_PROT___62) {
                                                            local277 = bitPacket.g2_alt2();
                                                            if (local277 == 65535) {
                                                                local277 = -1;
                                                            }
                                                            local100 = bitPacket.g4_alt3();
                                                            local526 = bitPacket.g2();
                                                            if (local526 == 65535) {
                                                                local526 = -1;
                                                            }
                                                            local1409 = bitPacket.ig2();
                                                            Static574.method7573();
                                                            for (local1413 = local277; local1413 <= local526; local1413++) {
                                                                local644 = (long) local1413 + ((long) local100 << 32);
                                                                local4597 = (ServerActiveProperties) InterfaceManager.serverActiveProperties.get(local644);
                                                                if (local4597 != null) {
                                                                    local4611 = new ServerActiveProperties(local4597.events, local1409);
                                                                    local4597.unlink();
                                                                } else if (local1413 == -1) {
                                                                    local4611 = new ServerActiveProperties(InterfaceList.list(local100).serverActiveProperties.events, local1409);
                                                                } else {
                                                                    local4611 = new ServerActiveProperties(0, local1409);
                                                                }
                                                                InterfaceManager.serverActiveProperties.put(local644, local4611);
                                                            }
                                                            arg0.currentProt = null;
                                                            return true;
                                                        }
                                                        @Pc(4669) long local4669;
                                                        if (arg0.currentProt == ServerProt.A_SERVER_PROT___125) {
                                                            local277 = bitPacket.g2();
                                                            local4669 = bitPacket.g8();
                                                            if (Static279.anObjectArray35 == null) {
                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                            }
                                                            Static279.anObjectArray35[local277] = Long.valueOf(local4669);
                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else if (Static233.A_SERVER_PROT___104 == arg0.currentProt) {
                                                            local277 = bitPacket.ig2();
                                                            local100 = bitPacket.g2_alt3();
                                                            local526 = bitPacket.g4();
                                                            Static574.method7573();
                                                            DelayedStateChange.method4347(local526, local277 + (local100 << 16));
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else if (arg0.currentProt == Static137.A_SERVER_PROT___56) {
                                                            method7912(Static328.A_ZONE_PROT___10);
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else {
                                                            @Pc(4857) boolean local4857;
                                                            if (arg0.currentProt == Static605.A_SERVER_PROT___220) {
                                                                local277 = bitPacket.g2_alt2();
                                                                local100 = bitPacket.g4_alt3();
                                                                local526 = bitPacket.g1_alt1();
                                                                local1409 = bitPacket.g1_alt1();
                                                                local1413 = bitPacket.g2();
                                                                local2098 = bitPacket.ig2();
                                                                if (local2098 == 65535) {
                                                                    local2098 = -1;
                                                                }
                                                                local992 = local1409 & 0x7;
                                                                local996 = local1409 >> 3 & 0xF;
                                                                if (local996 == 15) {
                                                                    local996 = -1;
                                                                }
                                                                @Pc(4806) boolean local4806 = (local1409 >> 7 & 0x1) == 1;
                                                                if (local100 >> 30 == 0) {
                                                                    @Pc(4943) int replayMode;
                                                                    @Pc(4911) SeqType local4911;
                                                                    @Pc(4888) SpotAnimationType local4888;
                                                                    @Pc(4905) SeqType local4905;
                                                                    if (local100 >> 29 != 0) {
                                                                        local653 = local100 & 0xFFFF;
                                                                        @Pc(5032) NPCEntityNode local5032 = (NPCEntityNode) NPCList.local.get(local653);
                                                                        if (local5032 != null) {
                                                                            @Pc(5037) NPCEntity local5037 = local5032.npc;
                                                                            @Pc(5042) EntitySpotAnimation local5042 = local5037.spotAnims[local526];
                                                                            if (local2098 == 65535) {
                                                                                local2098 = -1;
                                                                            }
                                                                            local665 = true;
                                                                            local667 = local5042.id;
                                                                            if (local2098 != -1 && local667 != -1) {
                                                                                if (local667 == local2098) {
                                                                                    local4888 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    if (local4888.loopSeq && local4888.seq != -1) {
                                                                                        local4905 = SeqTypeList.instance.list(local4888.seq);
                                                                                        @Pc(5134) int local5134 = local4905.replayMode;
                                                                                        if (local5134 == SeqReplayMode.STOP || local5134 == SeqReplayMode.RESTART_LOOP) {
                                                                                            local665 = false;
                                                                                        } else if (local5134 == SeqReplayMode.RESET) {
                                                                                            local665 = true;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    local4888 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    @Pc(5078) SpotAnimationType local5078 = SpotAnimationTypeList.instance.list(local667);
                                                                                    if (local4888.seq != -1 && local5078.seq != -1) {
                                                                                        local4911 = SeqTypeList.instance.list(local4888.seq);
                                                                                        @Pc(5102) SeqType local5102 = SeqTypeList.instance.list(local5078.seq);
                                                                                        if (local4911.priority < local5102.priority) {
                                                                                            local665 = false;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (local665) {
                                                                                local5042.wornSlot = local996;
                                                                                local5042.height = local1413;
                                                                                local5042.id = local2098;
                                                                                if (local2098 == -1) {
                                                                                    local5042.animator.update(true, -1);
                                                                                } else {
                                                                                    local4888 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    replayMode = local4888.loopSeq ? 0 : 2;
                                                                                    if (local4806) {
                                                                                        replayMode = 1;
                                                                                    }
                                                                                    local5042.animator.update(local4888.seq, local277, replayMode, false);
                                                                                }
                                                                            }
                                                                        }
                                                                    } else if (local100 >> 28 != 0) {
                                                                        local653 = local100 & 0xFFFF;
                                                                        @Pc(4839) PlayerEntity local4839;
                                                                        if (local653 == PlayerList.activePlayerSlot) {
                                                                            local4839 = PlayerEntity.self;
                                                                        } else {
                                                                            local4839 = PlayerList.highResolutionPlayers[local653];
                                                                        }
                                                                        if (local4839 != null) {
                                                                            @Pc(4850) EntitySpotAnimation local4850 = local4839.spotAnims[local526];
                                                                            if (local2098 == 65535) {
                                                                                local2098 = -1;
                                                                            }
                                                                            local4857 = true;
                                                                            local1097 = local4850.id;
                                                                            @Pc(4883) SpotAnimationType local4883;
                                                                            if (local2098 != -1 && local1097 != -1) {
                                                                                if (local2098 == local1097) {
                                                                                    local4883 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    if (local4883.loopSeq && local4883.seq != -1) {
                                                                                        @Pc(4940) SeqType local4940 = SeqTypeList.instance.list(local4883.seq);
                                                                                        replayMode = local4940.replayMode;
                                                                                        if (replayMode == SeqReplayMode.STOP || replayMode == SeqReplayMode.RESTART_LOOP) {
                                                                                            local4857 = false;
                                                                                        } else if (replayMode == SeqReplayMode.RESET) {
                                                                                            local4857 = true;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    local4883 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    local4888 = SpotAnimationTypeList.instance.list(local1097);
                                                                                    if (local4883.seq != -1 && local4888.seq != -1) {
                                                                                        local4905 = SeqTypeList.instance.list(local4883.seq);
                                                                                        local4911 = SeqTypeList.instance.list(local4888.seq);
                                                                                        if (local4911.priority > local4905.priority) {
                                                                                            local4857 = false;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (local4857) {
                                                                                local4850.wornSlot = local996;
                                                                                local4850.height = local1413;
                                                                                local4850.rotation = local992;
                                                                                local4850.id = local2098;
                                                                                if (local2098 == -1) {
                                                                                    local4850.animator.update(true, -1);
                                                                                } else {
                                                                                    local4883 = SpotAnimationTypeList.instance.list(local2098);
                                                                                    @Pc(5006) int local5006 = local4883.loopSeq ? 0 : 2;
                                                                                    if (local4806) {
                                                                                        local5006 = 1;
                                                                                    }
                                                                                    local4850.animator.update(local4883.seq, local277, local5006, false);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                } else {
                                                                    local653 = local100 >> 28 & 0x3;
                                                                    local657 = (local100 >> 14 & 0x3FFF) - WorldMap.areaBaseX;
                                                                    local3502 = (local100 & 0x3FFF) - WorldMap.areaBaseZ;
                                                                    if (local657 >= 0 && local3502 >= 0 && local657 < Static720.mapWidth && local3502 < Static501.mapHeight) {
                                                                        if (local2098 == -1) {
                                                                            @Pc(5270) SpotAnimationNode local5270 = (SpotAnimationNode) Static346.A_HASH_TABLE___29.get(local657 << 16 | local3502);
                                                                            if (local5270 != null) {
                                                                                local5270.spotAnimation.runParticleSystem();
                                                                                local5270.unlink();
                                                                            }
                                                                        } else {
                                                                            local1021 = local657 * 512 + 256;
                                                                            local1097 = local3502 * 512 + 256;
                                                                            local667 = local653;
                                                                            if (local653 < 3 && Static441.isBridgeAt(local3502, local657)) {
                                                                                local667 = local653 + 1;
                                                                            }
                                                                            @Pc(5334) SpotAnimation local5334 = new SpotAnimation(local2098, local277, local653, local667, local1021, Static102.averageHeight(local653, local1097, local1021) - local1413, local1097, local657, local657, local3502, local3502, local992, local4806);
                                                                            Static346.A_HASH_TABLE___29.put(local3502 | local657 << 16, new SpotAnimationNode(local5334));
                                                                        }
                                                                    }
                                                                }
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static9.A_SERVER_PROT___3 == arg0.currentProt) {
                                                                local277 = bitPacket.g4();
                                                                local100 = bitPacket.ig2();
                                                                if (local100 == 65535) {
                                                                    local100 = -1;
                                                                }
                                                                Static574.method7573();
                                                                DelayedStateChange.method6462(local100, 2, -1, local277);
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static36.A_SERVER_PROT___15 == arg0.currentProt) {
                                                                Static480.method6468(bitPacket, SignLink.instance, arg0.currentPacketSize);
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static193.A_SERVER_PROT___74 == arg0.currentProt) {
                                                                Static574.method7573();
                                                                Camera.reset();
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else {
                                                                @Pc(5445) SubInterface local5445;
                                                                if (ServerProt.A_SERVER_PROT___47 == arg0.currentProt) {
                                                                    local277 = bitPacket.g4_alt2();
                                                                    local100 = bitPacket.g4_alt3();
                                                                    Static574.method7573();
                                                                    @Pc(5438) SubInterface local5438 = (SubInterface) InterfaceManager.subInterfaces.get(local100);
                                                                    local5445 = (SubInterface) InterfaceManager.subInterfaces.get(local277);
                                                                    if (local5445 != null) {
                                                                        InterfaceManager.closeSubInterface(false, local5438 == null || local5438.id != local5445.id, local5445);
                                                                    }
                                                                    if (local5438 != null) {
                                                                        local5438.unlink();
                                                                        InterfaceManager.subInterfaces.put(local277, local5438);
                                                                    }
                                                                    @Pc(5487) Component local5487 = InterfaceList.list(local100);
                                                                    if (local5487 != null) {
                                                                        InterfaceManager.redraw(local5487);
                                                                    }
                                                                    local5487 = InterfaceList.list(local277);
                                                                    if (local5487 != null) {
                                                                        InterfaceManager.redraw(local5487);
                                                                        InterfaceManager.calculateLayerDimensions(local5487, true);
                                                                    }
                                                                    if (InterfaceManager.topLevelInterface != -1) {
                                                                        InterfaceManager.runHookImmediate(InterfaceManager.IMMEDIATE_HOOK_TYPE_SUBCHANGE, InterfaceManager.topLevelInterface);
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___49) {
                                                                    local277 = bitPacket.g2_alt3();
                                                                    local100 = bitPacket.g4_alt1();
                                                                    local526 = bitPacket.g1();
                                                                    Static574.method7573();
                                                                    local5445 = (SubInterface) InterfaceManager.subInterfaces.get(local100);
                                                                    if (local5445 != null) {
                                                                        InterfaceManager.closeSubInterface(false, local5445.id != local277, local5445);
                                                                    }
                                                                    InterfaceManager.openSubInterface(local526, local277, local100, false);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static563.A_SERVER_PROT___207) {
                                                                    local277 = bitPacket.g1_alt2();
                                                                    local100 = bitPacket.g2_alt3() << 2;
                                                                    local526 = bitPacket.g1_alt3();
                                                                    local1409 = bitPacket.g1();
                                                                    local1413 = bitPacket.g1_alt3();
                                                                    Static574.method7573();
                                                                    Static638.method8397(local1409, local277, local526, local100, local1413);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static671.A_SERVER_PROT___246 == arg0.currentProt) {
                                                                    Static703.anInt10571 = bitPacket.g1();
                                                                    arg0.currentProt = null;
                                                                    Static321.lastMiscTransmit = World.tick;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static721.A_SERVER_PROT___259) {
                                                                    local277 = bitPacket.g2_alt2();
                                                                    local100 = bitPacket.g2_alt3();
                                                                    local526 = bitPacket.g4_alt1();
                                                                    local1409 = bitPacket.g2_alt3();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.interfaceSetModelAngle(local1409, local277, local526, local100);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static454.A_SERVER_PROT___174 == arg0.currentProt) {
                                                                    local1937 = bitPacket.gjstr();
                                                                    local100 = bitPacket.g2_alt2();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.setVarcstr(local100, local1937);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static663.A_SERVER_PROT___241) {
                                                                    local446 = bitPacket.g1() == 1;
                                                                    local627 = bitPacket.gjstr();
                                                                    local629 = local627;
                                                                    if (local446) {
                                                                        local629 = bitPacket.gjstr();
                                                                    }
                                                                    local639 = bitPacket.g2();
                                                                    local644 = bitPacket.g3();
                                                                    local996 = bitPacket.g1();
                                                                    local1002 = local644 + (local639 << 32);
                                                                    local1004 = false;
                                                                    local3502 = 0;
                                                                    while (true) {
                                                                        if (local3502 >= 100) {
                                                                            if (local996 <= 1) {
                                                                                if (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724) {
                                                                                    local1004 = true;
                                                                                } else if (Static71.method1524(local629)) {
                                                                                    local1004 = true;
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                        if (Static511.aLongArray17[local3502] == local1002) {
                                                                            local1004 = true;
                                                                            break;
                                                                        }
                                                                        local3502++;
                                                                    }
                                                                    if (!local1004 && Static659.blockChat == 0) {
                                                                        Static511.aLongArray17[Static97.anInt2001] = local1002;
                                                                        Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                                        local3582 = Static130.method2280(WordPack.decode(bitPacket));
                                                                        if (local996 == 2) {
                                                                            ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, -1, local3582, null, 0, local627, ChatLineType.PRIVATE_RANK);
                                                                        } else if (local996 == 1) {
                                                                            ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, -1, local3582, null, 0, local627, ChatLineType.PRIVATE_RANK);
                                                                        } else {
                                                                            ChatHistory.add(local629, local627, -1, local3582, null, 0, local627, ChatLineType.PRIVATE);
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static606.A_SERVER_PROT___221) {
                                                                    local277 = bitPacket.g1_alt3();
                                                                    local100 = bitPacket.ig2();
                                                                    if (local100 == 65535) {
                                                                        local100 = -1;
                                                                    }
                                                                    local526 = bitPacket.g1_alt2();
                                                                    Static63.method1427(local526, local100, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (ServerProt.A_SERVER_PROT___252 == arg0.currentProt) {
                                                                    local277 = bitPacket.g2_alt2();
                                                                    if (local277 == 65535) {
                                                                        local277 = -1;
                                                                    }
                                                                    local100 = bitPacket.g3_alt1();
                                                                    local526 = bitPacket.g1_alt2();
                                                                    Static482.method6481(local526, local277, local100);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static272.A_SERVER_PROT___112 == arg0.currentProt) {
                                                                    if (GameShell.fsframe != null) {
                                                                        InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                                                                    }
                                                                    local3044 = new byte[arg0.currentPacketSize];
                                                                    bitPacket.readEncrypted(local3044, arg0.currentPacketSize);
                                                                    local627 = Cp1252.decode(0, local3044, arg0.currentPacketSize);
                                                                    local629 = "opensn";
                                                                    if (!client.js || Static36.method980(SignLink.instance, local627, local629, 1).status == 2) {
                                                                        Static259.method3693(local627, local629, SignLink.instance, ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, true);
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___175) {
                                                                    local277 = bitPacket.g2();
                                                                    local100 = bitPacket.g2();
                                                                    local526 = bitPacket.g2();
                                                                    Static574.method7573();
                                                                    if (InterfaceList.interfaces[local277] != null) {
                                                                        for (local1409 = local100; local1409 < local526; local1409++) {
                                                                            local1413 = bitPacket.g3();
                                                                            if (InterfaceList.interfaces[local277].length > local1409 && InterfaceList.interfaces[local277][local1409] != null) {
                                                                                InterfaceList.interfaces[local277][local1409].anInt3774 = local1413;
                                                                            }
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static266.A_SERVER_PROT___192) {
                                                                    local277 = bitPacket.g4_alt2();
                                                                    local100 = bitPacket.g2();
                                                                    local526 = bitPacket.g4_alt3();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.method6462(local100, 5, local526, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___219) {
                                                                    method7912(Static84.A_ZONE_PROT___6);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static389.aServerProt_157 == arg0.currentProt) {
                                                                    local277 = bitPacket.g2();
                                                                    if (local277 == 65535) {
                                                                        local277 = -1;
                                                                    }
                                                                    local100 = bitPacket.g1();
                                                                    local526 = bitPacket.g2();
                                                                    local1409 = bitPacket.g1();
                                                                    Static186.method2818(local277, local100, 256, local526, local1409, true);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___19) {
                                                                    Static574.method7573();
                                                                    Camera.smoothReset();
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static91.A_SERVER_PROT___236) {
                                                                    PlayerList.iteratePlayers(bitPacket, arg0.currentPacketSize);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static250.A_SERVER_PROT___105 == arg0.currentProt) {
                                                                    Static133.anInt2458 = bitPacket.g1();
                                                                    Static87.anInt1806 = bitPacket.g1();
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static31.A_SERVER_PROT___14 == arg0.currentProt) {
                                                                    Static626.anInt9476 = bitPacket.g1b() << 3;
                                                                    Static270.anInt4354 = bitPacket.g1b_alt3() << 3;
                                                                    Static87.anInt1810 = bitPacket.g1();
                                                                    for (@Pc(6277) ObjStack local6277 = (ObjStack) Static497.stacks.first(); local6277 != null; local6277 = (ObjStack) Static497.stacks.next()) {
                                                                        local100 = (int) (local6277.key >> 28 & 0x3L);
                                                                        local526 = (int) (local6277.key & 0x3FFFL);
                                                                        local1409 = local526 - WorldMap.areaBaseX;
                                                                        local1413 = (int) (local6277.key >> 14 & 0x3FFFL);
                                                                        local2098 = local1413 - WorldMap.areaBaseZ;
                                                                        if (Static87.anInt1810 == local100 && local1409 >= Static626.anInt9476 && Static626.anInt9476 + 8 > local1409 && local2098 >= Static270.anInt4354 && Static270.anInt4354 + 8 > local2098) {
                                                                            local6277.unlink();
                                                                            if (local1409 >= 0 && local2098 >= 0 && Static720.mapWidth > local1409 && local2098 < Static501.mapHeight) {
                                                                                Static468.updateObjCount(Static87.anInt1810, local2098, local1409);
                                                                            }
                                                                        }
                                                                    }
                                                                    @Pc(6385) ChangeLocationRequest local6385;
                                                                    for (local6385 = (ChangeLocationRequest) Static159.changes.first(); local6385 != null; local6385 = (ChangeLocationRequest) Static159.changes.next()) {
                                                                        if (Static626.anInt9476 <= local6385.x && Static626.anInt9476 + 8 > local6385.x && local6385.z >= Static270.anInt4354 && Static270.anInt4354 + 8 > local6385.z && Static87.anInt1810 == local6385.anInt4010) {
                                                                            local6385.aBoolean309 = true;
                                                                        }
                                                                    }
                                                                    for (local6385 = (ChangeLocationRequest) Static227.customisations.first(); local6385 != null; local6385 = (ChangeLocationRequest) Static227.customisations.next()) {
                                                                        if (local6385.x >= Static626.anInt9476 && Static626.anInt9476 + 8 > local6385.x && local6385.z >= Static270.anInt4354 && Static270.anInt4354 + 8 > local6385.z && local6385.anInt4010 == Static87.anInt1810) {
                                                                            local6385.aBoolean309 = true;
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static533.A_SERVER_PROT___196) {
                                                                    local277 = bitPacket.g4_alt1();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.method6462(-1, 3, -1, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else {
                                                                    @Pc(6565) boolean local6565;
                                                                    if (Static718.A_SERVER_PROT___258 == arg0.currentProt) {
                                                                        local446 = bitPacket.g1() == 1;
                                                                        local627 = bitPacket.gjstr();
                                                                        local629 = local627;
                                                                        if (local446) {
                                                                            local629 = bitPacket.gjstr();
                                                                        }
                                                                        local1409 = bitPacket.g1();
                                                                        local6565 = false;
                                                                        if (local1409 <= 1) {
                                                                            if (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724) {
                                                                                local6565 = true;
                                                                            } else if (local1409 <= 1 && Static71.method1524(local629)) {
                                                                                local6565 = true;
                                                                            }
                                                                        }
                                                                        if (!local6565 && Static659.blockChat == 0) {
                                                                            local1750 = Static130.method2280(WordPack.decode(bitPacket));
                                                                            if (local1409 == 2) {
                                                                                ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, -1, local1750, null, 0, local627, ChatLineType.PLAYER_GROUP);
                                                                            } else if (local1409 == 1) {
                                                                                ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, -1, local1750, null, 0, local627, ChatLineType.PLAYER_GROUP);
                                                                            } else {
                                                                                ChatHistory.add(local629, local627, -1, local1750, null, 0, local627, ChatLineType.PLAYER_GROUP);
                                                                            }
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static629.A_SERVER_PROT___228 == arg0.currentProt) {
                                                                        local277 = bitPacket.g2();
                                                                        local627 = bitPacket.gjstr();
                                                                        local2080 = bitPacket.g1() == 1;
                                                                        Static718.aBoolean823 = local2080;
                                                                        Static459.aConnectionInfo_2 = client.gameConnection;
                                                                        Static430.method5817(local277, local627);
                                                                        MainLogicManager.setStep(15);
                                                                        arg0.currentProt = null;
                                                                        return false;
                                                                    } else if (arg0.currentProt == Static370.A_SERVER_PROT___152) {
                                                                        if (InterfaceManager.topLevelInterface != -1) {
                                                                            InterfaceManager.runHookImmediate(InterfaceManager.IMMEDIATE_HOOK_TYPE_DIALOGABORT, InterfaceManager.topLevelInterface);
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static411.A_SERVER_PROT___164) {
                                                                        Static251.anInt4036 = 1;
                                                                        Static344.lastFriendTransmit = World.tick;
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static384.A_SERVER_PROT___156) {
                                                                        Static39.lastClanChannelTransmit = World.tick;
                                                                        local446 = bitPacket.g1() == 1;
                                                                        if (arg0.currentPacketSize != 1) {
                                                                            if (local446) {
                                                                                Static45.aClass2_Sub47_1 = new ClanChannel(bitPacket);
                                                                            } else {
                                                                                Static674.aClass2_Sub47_3 = new ClanChannel(bitPacket);
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        }
                                                                        if (local446) {
                                                                            Static45.aClass2_Sub47_1 = null;
                                                                        } else {
                                                                            Static674.aClass2_Sub47_3 = null;
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static446.A_SERVER_PROT___170 == arg0.currentProt) {
                                                                        Static626.anInt9476 = bitPacket.g1b_alt2() << 3;
                                                                        Static87.anInt1810 = bitPacket.g1_alt1();
                                                                        Static270.anInt4354 = bitPacket.g1b() << 3;
                                                                        while (bitPacket.pos < arg0.currentPacketSize) {
                                                                            @Pc(6873) ZoneProt local6873 = Static559.method7419()[bitPacket.g1()];
                                                                            method7912(local6873);
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static651.A_SERVER_PROT___235 == arg0.currentProt) {
                                                                        Static434.method5855();
                                                                        arg0.currentProt = null;
                                                                        return false;
                                                                    } else if (arg0.currentProt == Static41.A_SERVER_PROT___20) {
                                                                        local277 = bitPacket.g4_alt3();
                                                                        local100 = local277 >> 28 & 0x3;
                                                                        local526 = local277 >> 14 & 0x3FFF;
                                                                        local1409 = local277 & 0x3FFF;
                                                                        local1413 = bitPacket.g2_alt2();
                                                                        if (local1413 == 65535) {
                                                                            local1413 = -1;
                                                                        }
                                                                        local2098 = bitPacket.g1_alt3();
                                                                        local992 = local2098 >> 2;
                                                                        local996 = local2098 & 0x3;
                                                                        local1449 = LOC_LAYERS_BY_SHAPE[local992];
                                                                        local1409 -= WorldMap.areaBaseZ;
                                                                        local526 -= WorldMap.areaBaseX;
                                                                        Static198.method2953(local100, local1409, local992, local1413, local526, local996, local1449);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static706.A_SERVER_PROT___255 == arg0.currentProt) {
                                                                        local277 = bitPacket.g1();
                                                                        local892 = (local277 & 0x1) == 1;
                                                                        local629 = bitPacket.gjstr();
                                                                        local4175 = bitPacket.gjstr();
                                                                        if (local4175.equals("")) {
                                                                            local4175 = local629;
                                                                        }
                                                                        local4177 = bitPacket.gjstr();
                                                                        local1750 = bitPacket.gjstr();
                                                                        if (local1750.equals("")) {
                                                                            local1750 = local4177;
                                                                        }
                                                                        if (local892) {
                                                                            for (local992 = 0; local992 < Static436.anInt3849; local992++) {
                                                                                if (Static446.aStringArray35[local992].equals(local1750)) {
                                                                                    Static632.aStringArray44[local992] = local629;
                                                                                    Static446.aStringArray35[local992] = local4175;
                                                                                    Static10.aStringArray1[local992] = local4177;
                                                                                    Static316.aStringArray41[local992] = local1750;
                                                                                    break;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            Static632.aStringArray44[Static436.anInt3849] = local629;
                                                                            Static446.aStringArray35[Static436.anInt3849] = local4175;
                                                                            Static10.aStringArray1[Static436.anInt3849] = local4177;
                                                                            Static316.aStringArray41[Static436.anInt3849] = local1750;
                                                                            Static65.aBooleanArray2[Static436.anInt3849] = (local277 & 0x2) == 2;
                                                                            Static436.anInt3849++;
                                                                        }
                                                                        Static344.lastFriendTransmit = World.tick;
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static331.A_SERVER_PROT___138 == arg0.currentProt) {
                                                                        local277 = bitPacket.g4_alt2();
                                                                        if (local277 != Static435.anInt6594) {
                                                                            Static435.anInt6594 = local277;
                                                                            ScriptRunner.executeTrigger(Static362.A_CLIENT_TRIGGER_TYPE___10, -1, -1);
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static550.A_SERVER_PROT___200 == arg0.currentProt) {
                                                                        local446 = bitPacket.g1() == 1;
                                                                        local627 = bitPacket.gjstr();
                                                                        local629 = local627;
                                                                        if (local446) {
                                                                            local629 = bitPacket.gjstr();
                                                                        }
                                                                        local1409 = bitPacket.g1();
                                                                        local1413 = bitPacket.g2();
                                                                        local1425 = false;
                                                                        if (local1409 <= 1 && Static71.method1524(local629)) {
                                                                            local1425 = true;
                                                                        }
                                                                        if (!local1425 && Static659.blockChat == 0) {
                                                                            local1427 = QuickChatPhraseTypeList.instance.get(local1413).method3903(bitPacket);
                                                                            if (local1409 == 2) {
                                                                                ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, local1413, local1427, null, 0, local627, ChatLineType.QUICKCHAT_PLAYER_GROUP);
                                                                            } else if (local1409 == 1) {
                                                                                ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, local1413, local1427, null, 0, local627, ChatLineType.QUICKCHAT_PLAYER_GROUP);
                                                                            } else {
                                                                                ChatHistory.add(local629, local627, local1413, local1427, null, 0, local627, ChatLineType.QUICKCHAT_PLAYER_GROUP);
                                                                            }
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static287.A_SERVER_PROT___119) {
                                                                        local277 = bitPacket.g4();
                                                                        local100 = bitPacket.g4();
                                                                        @Pc(7309) ClientMessage local7309 = ClientMessage.create(Static128.A_CLIENT_PROT___106, arg0.cipher);
                                                                        local7309.bitPacket.p4(local277);
                                                                        local7309.bitPacket.p4(local100);
                                                                        arg0.send(local7309);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static84.A_SERVER_PROT___36) {
                                                                        method7912(Static450.A_ZONE_PROT___14);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else {
                                                                        @Pc(7394) FriendChatUser local7394;
                                                                        if (arg0.currentProt == Static137.A_SERVER_PROT___57) {
                                                                            local1937 = bitPacket.gjstr();
                                                                            local2080 = bitPacket.g1() == 1;
                                                                            if (local2080) {
                                                                                local627 = bitPacket.gjstr();
                                                                            } else {
                                                                                local627 = local1937;
                                                                            }
                                                                            local1409 = bitPacket.g2();
                                                                            @Pc(7377) byte local7377 = bitPacket.g1b();
                                                                            local1425 = false;
                                                                            if (local7377 == -128) {
                                                                                local1425 = true;
                                                                            }
                                                                            if (local1425) {
                                                                                if (FriendChat.count == 0) {
                                                                                    arg0.currentProt = null;
                                                                                    return true;
                                                                                }
                                                                                for (local992 = 0; FriendChat.count > local992 && (!FriendChat.users[local992].accountName.equals(local627) || local1409 != FriendChat.users[local992].anInt6148); local992++) {
                                                                                }
                                                                                if (local992 < FriendChat.count) {
                                                                                    while (FriendChat.count - 1 > local992) {
                                                                                        FriendChat.users[local992] = FriendChat.users[local992 + 1];
                                                                                        local992++;
                                                                                    }
                                                                                    FriendChat.count--;
                                                                                    FriendChat.users[FriendChat.count] = null;
                                                                                }
                                                                            } else {
                                                                                local1427 = bitPacket.gjstr();
                                                                                local7394 = new FriendChatUser();
                                                                                local7394.aString67 = local1937;
                                                                                local7394.accountName = local627;
                                                                                local7394.aString68 = NameTools.format(local7394.accountName);
                                                                                local7394.anInt6148 = local1409;
                                                                                local7394.aString65 = local1427;
                                                                                local7394.aByte99 = local7377;
                                                                                for (local1449 = FriendChat.count - 1; local1449 >= 0; local1449--) {
                                                                                    local653 = FriendChat.users[local1449].aString68.compareTo(local7394.aString68);
                                                                                    if (local653 == 0) {
                                                                                        FriendChat.users[local1449].anInt6148 = local1409;
                                                                                        FriendChat.users[local1449].aByte99 = local7377;
                                                                                        FriendChat.users[local1449].aString65 = local1427;
                                                                                        if (local627.equals(PlayerEntity.self.accountName)) {
                                                                                            Static682.aByte142 = local7377;
                                                                                        }
                                                                                        Static352.lastClanTransmit = World.tick;
                                                                                        arg0.currentProt = null;
                                                                                        return true;
                                                                                    }
                                                                                    if (local653 < 0) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                if (FriendChat.users.length <= FriendChat.count) {
                                                                                    arg0.currentProt = null;
                                                                                    return true;
                                                                                }
                                                                                for (local653 = FriendChat.count - 1; local653 > local1449; local653--) {
                                                                                    FriendChat.users[local653 + 1] = FriendChat.users[local653];
                                                                                }
                                                                                if (FriendChat.count == 0) {
                                                                                    FriendChat.users = new FriendChatUser[100];
                                                                                }
                                                                                FriendChat.users[local1449 + 1] = local7394;
                                                                                FriendChat.count++;
                                                                                if (local627.equals(PlayerEntity.self.accountName)) {
                                                                                    Static682.aByte142 = local7377;
                                                                                }
                                                                            }
                                                                            Static352.lastClanTransmit = World.tick;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___11) {
                                                                            local277 = bitPacket.g2();
                                                                            local100 = bitPacket.g4();
                                                                            if (Static279.anObjectArray35 == null) {
                                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                                            }
                                                                            Static279.anObjectArray35[local277] = Integer.valueOf(local100);
                                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (ServerProt.A_SERVER_PROT___54 == arg0.currentProt) {
                                                                            local277 = bitPacket.g2();
                                                                            @Pc(7724) PlayerEntity local7724;
                                                                            if (local277 == PlayerList.activePlayerSlot) {
                                                                                local7724 = PlayerEntity.self;
                                                                            } else {
                                                                                local7724 = PlayerList.highResolutionPlayers[local277];
                                                                            }
                                                                            if (local7724 == null) {
                                                                                arg0.currentProt = null;
                                                                                return true;
                                                                            }
                                                                            local526 = bitPacket.g2();
                                                                            local1409 = bitPacket.g1();
                                                                            local6565 = (local526 & 0x8000) != 0;
                                                                            if (local7724.accountName != null && local7724.playerModel != null) {
                                                                                local1425 = false;
                                                                                if (local1409 <= 1) {
                                                                                    if (!local6565 && (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724)) {
                                                                                        local1425 = true;
                                                                                    } else if (Static71.method1524(local7724.accountName)) {
                                                                                        local1425 = true;
                                                                                    }
                                                                                }
                                                                                if (!local1425 && Static659.blockChat == 0) {
                                                                                    local996 = -1;
                                                                                    if (local6565) {
                                                                                        local526 &= 0x7FFF;
                                                                                        @Pc(7827) Class21 local7827 = Static260.method3828(bitPacket);
                                                                                        local996 = local7827.anInt521;
                                                                                        local1427 = local7827.aClass2_Sub2_Sub12_1.method3903(bitPacket);
                                                                                    } else {
                                                                                        local1427 = Static130.method2280(WordPack.decode(bitPacket));
                                                                                    }
                                                                                    local7724.method1413(local526 >> 8, local526 & 0xFF, local1427.trim());
                                                                                    if (local1409 == 1 || local1409 == 2) {
                                                                                        local1449 = local6565 ? ChatLineType.QUICKCHAT_PUBLIC : ChatLineType.PUBLIC_RANK;
                                                                                    } else {
                                                                                        local1449 = local6565 ? ChatLineType.QUICKCHAT_PUBLIC : ChatLineType.PUBLIC;
                                                                                    }
                                                                                    if (local1409 == 2) {
                                                                                        ChatHistory.add("<img=1>" + local7724.getAccountName(), "<img=1>" + local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    } else if (local1409 == 1) {
                                                                                        ChatHistory.add("<img=0>" + local7724.getAccountName(), "<img=0>" + local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    } else {
                                                                                        ChatHistory.add(local7724.getAccountName(), local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    }
                                                                                }
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static19.A_SERVER_PROT___8) {
                                                                            local277 = bitPacket.g2();
                                                                            if (local277 == 65535) {
                                                                                local277 = -1;
                                                                            }
                                                                            local100 = bitPacket.g1();
                                                                            local526 = bitPacket.g2();
                                                                            local1409 = bitPacket.g1();
                                                                            local1413 = bitPacket.g2();
                                                                            Static161.method2586(local1413, local526, local277, local100, local1409);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static590.A_SERVER_PROT___217 == arg0.currentProt) {
                                                                            arg0.currentProt = null;
                                                                            return false;
                                                                        } else if (Static155.A_SERVER_PROT___60 == arg0.currentProt) {
                                                                            local277 = bitPacket.ig2();
                                                                            if (local277 == 65535) {
                                                                                local277 = -1;
                                                                            }
                                                                            local100 = bitPacket.g4_alt3();
                                                                            local526 = bitPacket.g2_alt2();
                                                                            if (local526 == 65535) {
                                                                                local526 = -1;
                                                                            }
                                                                            local1409 = bitPacket.g4_alt1();
                                                                            Static574.method7573();
                                                                            for (local1413 = local277; local1413 <= local526; local1413++) {
                                                                                local644 = (long) local1413 + ((long) local100 << 32);
                                                                                local4597 = (ServerActiveProperties) InterfaceManager.serverActiveProperties.get(local644);
                                                                                if (local4597 != null) {
                                                                                    local4611 = new ServerActiveProperties(local1409, local4597.targetParam);
                                                                                    local4597.unlink();
                                                                                } else if (local1413 == -1) {
                                                                                    local4611 = new ServerActiveProperties(local1409, InterfaceList.list(local100).serverActiveProperties.targetParam);
                                                                                } else {
                                                                                    local4611 = new ServerActiveProperties(local1409, -1);
                                                                                }
                                                                                InterfaceManager.serverActiveProperties.put(local644, local4611);
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___257) {
                                                                            local277 = bitPacket.g2();
                                                                            local100 = bitPacket.g4();
                                                                            local526 = bitPacket.g2();
                                                                            local1409 = bitPacket.g1_alt3();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetRetex(local526, local1409, local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static157.A_SERVER_PROT___61) {
                                                                            Static626.anInt9476 = bitPacket.g1b_alt1() << 3;
                                                                            Static270.anInt4354 = bitPacket.g1b() << 3;
                                                                            Static87.anInt1810 = bitPacket.g1_alt3();
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static18.A_SERVER_PROT___7 == arg0.currentProt) {
                                                                            method7912(Static18.A_ZONE_PROT___2);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static207.A_SERVER_PROT___127 == arg0.currentProt) {
                                                                            local277 = bitPacket.g2s_alt3();
                                                                            local100 = bitPacket.g4_alt2();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetModelAnim(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static707.A_SERVER_PROT___256 == arg0.currentProt) {
                                                                            local277 = bitPacket.g2_alt3();
                                                                            local100 = bitPacket.g2_alt2();
                                                                            Static574.method7573();
                                                                            Static471.method6408(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static404.A_SERVER_PROT___161 == arg0.currentProt) {
                                                                            Static106.anInt2153 = bitPacket.g3s();
                                                                            Static389.aBoolean459 = bitPacket.g1() == 1;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static617.A_SERVER_PROT___224) {
                                                                            local277 = bitPacket.g2_alt3();
                                                                            local931 = bitPacket.g1b_alt3();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.setVarc(local931, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.MESSAGE_PRIVATE_ECHO) {
                                                                            local1937 = bitPacket.gjstr();
                                                                            local627 = Static130.method2280(WordPack.decode(bitPacket));
                                                                            ChatHistory.add(local627, local1937, 0, local1937, local1937, ChatLineType.PRIVATE_ECHO);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static353.A_SERVER_PROT___233) {
                                                                            Static400.lastClanSettingsTransmit = World.tick;
                                                                            local446 = bitPacket.g1() == 1;
                                                                            @Pc(8376) Class20 local8376 = new Class20(bitPacket);
                                                                            @Pc(8380) ClanSettings local8380;
                                                                            if (local446) {
                                                                                local8380 = Static128.aClanSettings_8;
                                                                            } else {
                                                                                local8380 = Static91.aClanSettings_9;
                                                                            }
                                                                            local8376.method587(local8380);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___45) {
                                                                            local277 = bitPacket.g4();
                                                                            local627 = bitPacket.gjstr();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetText(local277, local627);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___53) {
                                                                            local277 = bitPacket.ig2();
                                                                            local100 = bitPacket.g1_alt2();
                                                                            local2080 = (local100 & 0x1) == 1;
                                                                            Static698.method9123(local2080, local277);
                                                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static464.A_SERVER_PROT___176) {
                                                                            method7912(Static210.A_ZONE_PROT___9);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static269.A_SERVER_PROT___111) {
                                                                            NPCList.updateNpcs();
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (ServerProt.CAM_MOVETO == arg0.currentProt) {
                                                                            local277 = bitPacket.g1_alt3();
                                                                            local100 = bitPacket.g1_alt2();
                                                                            local526 = bitPacket.g1_alt2();
                                                                            local1409 = bitPacket.g1_alt2();
                                                                            local1413 = bitPacket.g2_alt3() << 2;
                                                                            Static574.method7573();
                                                                            Camera.moveTo(local526, true, local1409, local1413, local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static451.aServerProt_171) {
                                                                            Static352.lastClanTransmit = World.tick;
                                                                            if (arg0.currentPacketSize == 0) {
                                                                                arg0.currentProt = null;
                                                                                FriendChat.count = 0;
                                                                                FriendChat.users = null;
                                                                                Static723.aString129 = null;
                                                                                Static158.aString28 = null;
                                                                                return true;
                                                                            }
                                                                            Static158.aString28 = bitPacket.gjstr();
                                                                            local446 = bitPacket.g1() == 1;
                                                                            if (local446) {
                                                                                bitPacket.gjstr();
                                                                            }
                                                                            local4669 = bitPacket.g8();
                                                                            Static723.aString129 = Base37.decode(local4669);
                                                                            Static673.aByte140 = bitPacket.g1b();
                                                                            local1409 = bitPacket.g1();
                                                                            if (local1409 == 255) {
                                                                                arg0.currentProt = null;
                                                                                return true;
                                                                            }
                                                                            FriendChat.count = local1409;
                                                                            @Pc(8611) FriendChatUser[] local8611 = new FriendChatUser[100];
                                                                            for (local2098 = 0; local2098 < FriendChat.count; local2098++) {
                                                                                local8611[local2098] = new FriendChatUser();
                                                                                local8611[local2098].aString67 = bitPacket.gjstr();
                                                                                local446 = bitPacket.g1() == 1;
                                                                                if (local446) {
                                                                                    local8611[local2098].accountName = bitPacket.gjstr();
                                                                                } else {
                                                                                    local8611[local2098].accountName = local8611[local2098].aString67;
                                                                                }
                                                                                local8611[local2098].aString68 = NameTools.format(local8611[local2098].accountName);
                                                                                local8611[local2098].anInt6148 = bitPacket.g2();
                                                                                local8611[local2098].aByte99 = bitPacket.g1b();
                                                                                local8611[local2098].aString65 = bitPacket.gjstr();
                                                                                if (local8611[local2098].accountName.equals(PlayerEntity.self.accountName)) {
                                                                                    Static682.aByte142 = local8611[local2098].aByte99;
                                                                                }
                                                                            }
                                                                            local1449 = FriendChat.count;
                                                                            while (local1449 > 0) {
                                                                                @Pc(8729) boolean local8729 = true;
                                                                                local1449--;
                                                                                for (local653 = 0; local653 < local1449; local653++) {
                                                                                    if (local8611[local653].aString68.compareTo(local8611[local653 + 1].aString68) > 0) {
                                                                                        local7394 = local8611[local653];
                                                                                        local8611[local653] = local8611[local653 + 1];
                                                                                        local8611[local653 + 1] = local7394;
                                                                                        local8729 = false;
                                                                                    }
                                                                                }
                                                                                if (local8729) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            FriendChat.users = local8611;
                                                                            return true;
                                                                        } else if (Static722.A_SERVER_PROT___260 == arg0.currentProt) {
                                                                            method7912(ZoneProt.MAP_PROJANIM);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static215.A_SERVER_PROT___86) {
                                                                            local277 = bitPacket.g1();
                                                                            local100 = bitPacket.g1_alt1();
                                                                            if (local277 == 255) {
                                                                                local100 = -1;
                                                                                local277 = -1;
                                                                            }
                                                                            DelayedStateChange.setMapFlag(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static211.A_SERVER_PROT___143) {
                                                                            method7912(Static704.A_ZONE_PROT___17);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static390.A_SERVER_PROT___158) {
                                                                            local277 = bitPacket.g2();
                                                                            local627 = bitPacket.gjstr();
                                                                            if (Static279.anObjectArray35 == null) {
                                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                                            }
                                                                            Static279.anObjectArray35[local277] = local627;
                                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static616.A_SERVER_PROT___223) {
                                                                            local446 = bitPacket.g1() == 1;
                                                                            local627 = bitPacket.gjstr();
                                                                            local629 = local627;
                                                                            if (local446) {
                                                                                local629 = bitPacket.gjstr();
                                                                            }
                                                                            local639 = bitPacket.g8();
                                                                            local644 = bitPacket.g2();
                                                                            local649 = bitPacket.g3();
                                                                            local653 = bitPacket.g1();
                                                                            @Pc(8945) long local8945 = local649 + (local644 << 32);
                                                                            local4857 = false;
                                                                            local1097 = 0;
                                                                            while (true) {
                                                                                if (local1097 >= 100) {
                                                                                    if (local653 <= 1) {
                                                                                        if (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724) {
                                                                                            local4857 = true;
                                                                                        } else if (Static71.method1524(local629)) {
                                                                                            local4857 = true;
                                                                                        }
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                if (Static511.aLongArray17[local1097] == local8945) {
                                                                                    local4857 = true;
                                                                                    break;
                                                                                }
                                                                                local1097++;
                                                                            }
                                                                            if (!local4857 && Static659.blockChat == 0) {
                                                                                Static511.aLongArray17[Static97.anInt2001] = local8945;
                                                                                Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                                                @Pc(9032) String local9032 = Static130.method2280(WordPack.decode(bitPacket));
                                                                                if (local653 == 2 || local653 == 3) {
                                                                                    ChatHistory.add("<img=1>" + local629, "<img=1>" + local627, -1, local9032, Base37.decodeName(local639), 0, local627, ChatLineType.FRIENDCHANNEL);
                                                                                } else if (local653 == 1) {
                                                                                    ChatHistory.add("<img=0>" + local629, "<img=0>" + local627, -1, local9032, Base37.decodeName(local639), 0, local627, ChatLineType.FRIENDCHANNEL);
                                                                                } else {
                                                                                    ChatHistory.add(local629, local627, -1, local9032, Base37.decodeName(local639), 0, local627, ChatLineType.FRIENDCHANNEL);
                                                                                }
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else {
                                                                            JagException.sendTrace(null, "T1 - " + (arg0.currentProt == null ? -1 : arg0.currentProt.getOpcode()) + "," + (arg0.penultimateProt == null ? -1 : arg0.penultimateProt.getOpcode()) + "," + (arg0.antepenultimateProt == null ? -1 : arg0.antepenultimateProt.getOpcode()) + " - " + arg0.currentPacketSize);
                                                                            Login.logout(false);
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private Protocol() {
        /* empty */
    }

    @OriginalMember(owner = "client!lma", name = "b", descriptor = "(I)V")
    public static void sendWindowStatus() {
        @Pc(22) ClientMessage local22 = ClientMessage.create(Static587.A_CLIENT_PROT___105, ConnectionManager.GAME.cipher);
        local22.bitPacket.p1(InterfaceManager.getWindowMode());
        local22.bitPacket.p2(GameShell.canvasWid);
        local22.bitPacket.p2(GameShell.canvasHei);
        local22.bitPacket.p1(ClientOptions.instance.antialiasingQuality.getValue());
        ConnectionManager.GAME.send(local22);
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(ILclient!pc;)V")
    public static void method7912(@OriginalArg(1) ZoneProt arg0) {
        @Pc(8) BitPacket bitPacket = ConnectionManager.GAME.bitPacket;
        @Pc(15) int local15;
        @Pc(21) int local21;
        @Pc(25) int local25;
        @Pc(34) int local34;
        @Pc(38) int local38;
        @Pc(42) int local42;
        @Pc(46) int local46;
        @Pc(52) int local52;
        if (arg0 == Static704.A_ZONE_PROT___17) {
            local15 = bitPacket.g1();
            local21 = (local15 & 0x7) + Static270.anInt4354;
            local25 = WorldMap.areaBaseZ + local21;
            local34 = Static626.anInt9476 + (local15 >> 4 & 0x7);
            local38 = WorldMap.areaBaseX + local34;
            local42 = bitPacket.g2();
            local46 = bitPacket.g2();
            local52 = bitPacket.g2();
            if (Static497.stacks != null) {
                @Pc(69) ObjStack local69 = (ObjStack) Static497.stacks.get(Static87.anInt1810 << 28 | local25 << 14 | local38);
                if (local69 != null) {
                    for (@Pc(77) ObjStackEntry local77 = (ObjStackEntry) local69.objs.first(); local77 != null; local77 = (ObjStackEntry) local69.objs.next()) {
                        if ((local42 & 0x7FFF) == local77.id && local77.count == local46) {
                            local77.unlink();
                            local77.count = local52;
                            Static2.sortAllObjs(Static87.anInt1810, local25, local38, local77);
                            break;
                        }
                    }
                    if (local34 >= 0 && local21 >= 0 && Static720.mapWidth > local34 && Static501.mapHeight > local21) {
                        Static468.updateObjCount(Static87.anInt1810, local21, local34);
                    }
                }
            }
            return;
        }
        @Pc(212) int local212;
        @Pc(219) int local219;
        @Pc(290) int local290;
        @Pc(353) int local353;
        @Pc(217) int local217;
        @Pc(322) int local322;
        if (Static379.A_ZONE_PROT___12 == arg0) {
            local15 = bitPacket.g1_alt1();
            local21 = local15 >> 2;
            local25 = LOC_LAYERS_BY_SHAPE[local21];
            local34 = bitPacket.g1();
            local38 = bitPacket.g1_alt3();
            local42 = Static626.anInt9476 + (local38 >> 4 & 0x7);
            local46 = (local38 & 0x7) + Static270.anInt4354;
            local52 = bitPacket.ig2();
            if (local21 == 11) {
                local21 = 10;
            }
            @Pc(210) LocType local210 = LocTypeList.instance.list(local52);
            local212 = 0;
            if (local210.modelShapes != null) {
                local217 = -1;
                for (local219 = 0; local219 < local210.modelShapes.length; local219++) {
                    if (local210.modelShapes[local219] == local21) {
                        local217 = local219;
                        break;
                    }
                }
                local212 = local210.models[local217].length;
            }
            local217 = 0;
            if (local210.recol_d != null) {
                local217 = local210.recol_d.length;
            }
            local219 = 0;
            if (local210.retex_d != null) {
                local219 = local210.retex_d.length;
            }
            if ((local34 & 0x1) == 1) {
                Static296.method4361(null, Static87.anInt1810, local25, local42, local46);
            } else {
                @Pc(278) int[] local278 = null;
                if ((local34 & 0x2) == 2) {
                    local278 = new int[local212];
                    for (local290 = 0; local290 < local212; local290++) {
                        local278[local290] = bitPacket.g2();
                    }
                }
                @Pc(310) short[] local310 = null;
                if ((local34 & 0x4) == 4) {
                    local310 = new short[local217];
                    for (local322 = 0; local322 < local217; local322++) {
                        local310[local322] = (short) bitPacket.g2();
                    }
                }
                @Pc(343) short[] local343 = null;
                if ((local34 & 0x8) == 8) {
                    local343 = new short[local219];
                    for (local353 = 0; local353 < local219; local353++) {
                        local343[local353] = (short) bitPacket.g2();
                    }
                }
                Static296.method4361(new LocTypeCustomisation(Static356.aLong177++, local278, local310, local343), Static87.anInt1810, local25, local42, local46);
            }
        } else if (arg0 == Static420.A_ZONE_PROT___13) {
            local15 = bitPacket.g2_alt3();
            if (local15 == 65535) {
                local15 = -1;
            }
            local21 = bitPacket.g1_alt1();
            local25 = Static626.anInt9476 + (local21 >> 4 & 0x7);
            local34 = (local21 & 0x7) + Static270.anInt4354;
            local38 = bitPacket.g1();
            local42 = local38 >> 2;
            local46 = local38 & 0x3;
            local52 = LOC_LAYERS_BY_SHAPE[local42];
            Static198.method2953(Static87.anInt1810, local34, local42, local15, local25, local46, local52);
        } else if (arg0 == Static328.A_ZONE_PROT___10) {
            local15 = bitPacket.g2();
            local21 = bitPacket.g1();
            LocTypeList.instance.list(local15).loadedModels(local21);
        } else {
            @Pc(537) int local537;
            if (arg0 == Static481.A_ZONE_PROT___15) {
                local15 = bitPacket.g1();
                local21 = Static626.anInt9476 + (local15 >> 4 & 0x7);
                local25 = (local15 & 0x7) + Static270.anInt4354;
                local34 = bitPacket.g2();
                if (local34 == 65535) {
                    local34 = -1;
                }
                local38 = bitPacket.g1();
                local42 = local38 >> 4 & 0xF;
                local46 = local38 & 0x7;
                local52 = bitPacket.g1();
                local537 = bitPacket.g1();
                local212 = bitPacket.g2();
                if (local21 >= 0 && local25 >= 0 && local21 < Static720.mapWidth && Static501.mapHeight > local25) {
                    local217 = local42 + 1;
                    if (local21 - local217 <= PlayerEntity.self.pathX[0] && local217 + local21 >= PlayerEntity.self.pathX[0] && PlayerEntity.self.pathZ[0] >= local25 - local217 && local217 + local25 >= PlayerEntity.self.pathZ[0]) {
                        Static165.method2608(local537, local52, local34, local46, local212, local42 + (local25 << 8) + (Static87.anInt1810 << 24) + (local21 << 16));
                    }
                }
            } else if (arg0 == Static450.A_ZONE_PROT___14) {
                local15 = bitPacket.g1();
                local21 = Static626.anInt9476 + (local15 >> 4 & 0x7);
                local25 = (local15 & 0x7) + Static270.anInt4354;
                local34 = bitPacket.g1();
                local38 = local34 >> 2;
                local42 = local34 & 0x3;
                local46 = LOC_LAYERS_BY_SHAPE[local38];
                local52 = bitPacket.g2_alt2();
                if (Static55.method1218(Static117.areaMode) || local21 >= 0 && local25 >= 0 && Static720.mapWidth > local21 && Static501.mapHeight > local25) {
                    Static553.method7289(local42, local52, local46, local21, Static87.anInt1810, local38, local25);
                }
            } else {
                @Pc(812) int local812;
                if (arg0 == Static3.A_ZONE_PROT___1) {
                    local15 = bitPacket.g1();
                    local21 = Static626.anInt9476 * 2 + (local15 >> 4 & 0xF);
                    local25 = (local15 & 0xF) + Static270.anInt4354 * 2;
                    local34 = bitPacket.g1();
                    @Pc(764) boolean local764 = (local34 & 0x1) != 0;
                    @Pc(773) boolean local773 = (local34 & 0x2) != 0;
                    local46 = local773 ? local34 >> 2 : -1;
                    local52 = bitPacket.g1b() + local21;
                    local537 = local25 + bitPacket.g1b();
                    local212 = bitPacket.g2s();
                    local217 = bitPacket.g2s();
                    local219 = bitPacket.g2();
                    local812 = bitPacket.g1();
                    if (local773) {
                        local812 = (byte) local812;
                    } else {
                        local812 *= 4;
                    }
                    local290 = bitPacket.g1() * 4;
                    local322 = bitPacket.g2();
                    local353 = bitPacket.g2();
                    @Pc(843) int local843 = bitPacket.g1();
                    @Pc(847) int local847 = bitPacket.g2();
                    if (local843 == 255) {
                        local843 = -1;
                    }
                    if (local21 >= 0 && local25 >= 0 && local21 < Static720.mapWidth * 2 && local25 < Static720.mapWidth * 2 && local52 >= 0 && local537 >= 0 && Static501.mapHeight * 2 > local52 && Static501.mapHeight * 2 > local537 && local219 != 65535) {
                        local52 = local52 * 256;
                        local847 <<= 0x2;
                        local25 = local25 * 256;
                        local537 *= 256;
                        local812 <<= 0x2;
                        local290 <<= 0x2;
                        local21 *= 256;
                        if (local212 != 0 && local46 != -1) {
                            @Pc(948) PathingEntity local948 = null;
                            @Pc(957) int local957;
                            if (local212 >= 0) {
                                local957 = local212 - 1;
                                @Pc(964) NPCEntityNode local964 = (NPCEntityNode) NPCList.local.get(local957);
                                if (local964 != null) {
                                    local948 = local964.npc;
                                }
                            } else {
                                local957 = -local212 - 1;
                                if (local957 == PlayerList.activePlayerSlot) {
                                    local948 = PlayerEntity.self;
                                } else {
                                    local948 = PlayerList.highResolutionPlayers[local957];
                                }
                            }
                            if (local948 != null) {
                                @Pc(991) BASType local991 = local948.getBASType();
                                if (local991.wornTransformations != null && local991.wornTransformations[local46] != null) {
                                    local812 -= local991.wornTransformations[local46][1];
                                }
                                if (local991.graphicOffsets != null && local991.graphicOffsets[local46] != null) {
                                    local812 -= local991.graphicOffsets[local46][1];
                                }
                            }
                        }
                        @Pc(1053) ProjectileAnimation local1053 = new ProjectileAnimation(local219, Static87.anInt1810, Static87.anInt1810, local21, local25, local812, local322 + TimeUtils.clock, TimeUtils.clock + local353, local843, local847, local212, local217, local290, local764, local46);
                        local1053.target(Static102.averageHeight(Static87.anInt1810, local537, local52) - local290, local322 + TimeUtils.clock, local537, local52);
                        Static505.projectiles.addLast(new ProjectileAnimationNode(local1053));
                    }
                } else if (Static77.A_ZONE_PROT___5 == arg0) {
                    local15 = bitPacket.g2_alt2();
                    local21 = bitPacket.g1_alt1();
                    local25 = Static270.anInt4354 + (local21 & 0x7);
                    local34 = local25 + WorldMap.areaBaseZ;
                    local38 = Static626.anInt9476 + (local21 >> 4 & 0x7);
                    local42 = WorldMap.areaBaseX + local38;
                    local46 = bitPacket.ig2();
                    local52 = bitPacket.g2();
                    if (local15 != PlayerList.activePlayerSlot) {
                        @Pc(1151) boolean local1151 = local38 >= 0 && local25 >= 0 && Static720.mapWidth > local38 && local25 < Static501.mapHeight;
                        if (local1151 || Static55.method1218(Static117.areaMode)) {
                            Static2.sortAllObjs(Static87.anInt1810, local34, local42, new ObjStackEntry(local46, local52));
                            if (local1151) {
                                Static468.updateObjCount(Static87.anInt1810, local25, local38);
                            }
                        }
                    }
                } else if (Static84.A_ZONE_PROT___6 == arg0) {
                    local15 = bitPacket.g1();
                    local21 = (local15 >> 4 & 0x7) + Static626.anInt9476;
                    local25 = (local15 & 0x7) + Static270.anInt4354;
                    local34 = bitPacket.g2();
                    if (local34 == 65535) {
                        local34 = -1;
                    }
                    local38 = bitPacket.g1();
                    local42 = local38 >> 4 & 0xF;
                    local46 = local38 & 0x7;
                    local52 = bitPacket.g1();
                    local537 = bitPacket.g1();
                    local212 = bitPacket.g2();
                    if (local21 >= 0 && local25 >= 0 && Static720.mapWidth > local21 && Static501.mapHeight > local25) {
                        local217 = local42 + 1;
                        if (PlayerEntity.self.pathX[0] >= local21 - local217 && local217 + local21 >= PlayerEntity.self.pathX[0] && PlayerEntity.self.pathZ[0] >= local25 - local217 && PlayerEntity.self.pathZ[0] <= local25 + local217) {
                            Static179.method2770(local46, local52, local42 + (local25 << 8) + (Static87.anInt1810 << 24) + (local21 << 16), local212, local537, local34);
                        }
                    }
                } else if (arg0 == Static565.A_ZONE_PROT___8) {
                    local15 = bitPacket.g2();
                    local21 = bitPacket.g1();
                    local25 = (local21 & 0x7) + Static270.anInt4354;
                    local34 = local25 + WorldMap.areaBaseZ;
                    local38 = (local21 >> 4 & 0x7) + Static626.anInt9476;
                    local42 = local38 + WorldMap.areaBaseX;
                    @Pc(1389) ObjStack local1389 = (ObjStack) Static497.stacks.get(local34 << 14 | Static87.anInt1810 << 28 | local42);
                    if (local1389 != null) {
                        for (@Pc(1399) ObjStackEntry local1399 = (ObjStackEntry) local1389.objs.first(); local1399 != null; local1399 = (ObjStackEntry) local1389.objs.next()) {
                            if (local1399.id == (local15 & 0x7FFF)) {
                                local1399.unlink();
                                break;
                            }
                        }
                        if (local1389.objs.isEmpty()) {
                            local1389.unlink();
                        }
                        if (local38 >= 0 && local25 >= 0 && local38 < Static720.mapWidth && local25 < Static501.mapHeight) {
                            Static468.updateObjCount(Static87.anInt1810, local25, local38);
                        }
                    }
                } else if (Static370.A_ZONE_PROT___11 == arg0) {
                    bitPacket.g1();
                    local15 = bitPacket.g1();
                    local21 = Static626.anInt9476 + (local15 >> 4 & 0x7);
                    local25 = (local15 & 0x7) + Static270.anInt4354;
                    local34 = bitPacket.g2();
                    local38 = bitPacket.g1();
                    local42 = bitPacket.g3();
                    @Pc(1511) String local1511 = bitPacket.gjstr();
                    Static540.method6539(Static87.anInt1810, local34, local1511, local42, local38, local21, local25);
                } else if (ZoneProt.MAP_PROJANIM == arg0) {
                    local15 = bitPacket.g1();
                    @Pc(1540) boolean local1540 = (local15 & 0x80) != 0;
                    local25 = Static626.anInt9476 + (local15 >> 3 & 0x7);
                    local34 = (local15 & 0x7) + Static270.anInt4354;
                    local38 = local25 + bitPacket.g1b();
                    local42 = local34 + bitPacket.g1b();
                    local46 = bitPacket.g2s();
                    local52 = bitPacket.g2();
                    local537 = bitPacket.g1() * 4;
                    local212 = bitPacket.g1() * 4;
                    local217 = bitPacket.g2();
                    local219 = bitPacket.g2();
                    local812 = bitPacket.g1();
                    local290 = bitPacket.g2();
                    if (local812 == 255) {
                        local812 = -1;
                    }
                    if (local25 >= 0 && local34 >= 0 && Static720.mapWidth > local25 && local34 < Static501.mapHeight && local38 >= 0 && local42 >= 0 && Static720.mapWidth > local38 && local42 < Static501.mapHeight && local52 != 65535) {
                        local42 = local42 * 512 + 256;
                        local290 <<= 0x2;
                        local537 <<= 0x2;
                        local25 = local25 * 512 + 256;
                        local212 <<= 0x2;
                        local38 = local38 * 512 + 256;
                        local34 = local34 * 512 + 256;
                        @Pc(1728) ProjectileAnimation projectile = new ProjectileAnimation(local52, Static87.anInt1810, Static87.anInt1810, local25, local34, local537, local217 + TimeUtils.clock, local219 + TimeUtils.clock, local812, local290, 0, local46, local212, local1540, -1);
                        projectile.target(Static102.averageHeight(Static87.anInt1810, local42, local38) - local212, TimeUtils.clock + local217, local42, local38);
                        Static505.projectiles.addLast(new ProjectileAnimationNode(projectile));
                    }
                } else if (Static210.A_ZONE_PROT___9 == arg0) {
                    local15 = bitPacket.g1_alt2();
                    local21 = Static626.anInt9476 + (local15 >> 4 & 0x7);
                    local25 = (local15 & 0x7) + Static270.anInt4354;
                    local34 = bitPacket.g1();
                    local38 = local34 >> 2;
                    local42 = local34 & 0x3;
                    local46 = LOC_LAYERS_BY_SHAPE[local38];
                    if (Static55.method1218(Static117.areaMode) || local21 >= 0 && local25 >= 0 && Static720.mapWidth > local21 && local25 < Static501.mapHeight) {
                        Static553.method7289(local42, -1, local46, local21, Static87.anInt1810, local38, local25);
                    }
                } else if (Static18.A_ZONE_PROT___2 == arg0) {
                    local15 = bitPacket.g1_alt2();
                    local21 = Static270.anInt4354 + (local15 & 0x7);
                    local25 = local21 + WorldMap.areaBaseZ;
                    local34 = (local15 >> 4 & 0x7) + Static626.anInt9476;
                    local38 = WorldMap.areaBaseX + local34;
                    local42 = bitPacket.g2_alt2();
                    local46 = bitPacket.g2();
                    @Pc(1886) boolean local1886 = local34 >= 0 && local21 >= 0 && local34 < Static720.mapWidth && local21 < Static501.mapHeight;
                    if (local1886 || Static55.method1218(Static117.areaMode)) {
                        Static2.sortAllObjs(Static87.anInt1810, local25, local38, new ObjStackEntry(local42, local46));
                        if (local1886) {
                            Static468.updateObjCount(Static87.anInt1810, local21, local34);
                        }
                    }
                } else if (arg0 == Static668.A_ZONE_PROT___16) {
                    local15 = bitPacket.g1();
                    local21 = Static626.anInt9476 + (local15 >> 4 & 0x7);
                    local25 = (local15 & 0x7) + Static270.anInt4354;
                    local34 = bitPacket.g2();
                    if (local34 == 65535) {
                        local34 = -1;
                    }
                    local38 = bitPacket.g1();
                    local42 = bitPacket.g2();
                    local46 = bitPacket.g1();
                    if (local21 >= 0 && local25 >= 0 && local21 < Static720.mapWidth && Static501.mapHeight > local25) {
                        if (local34 == -1) {
                            @Pc(2004) SpotAnimationNode local2004 = (SpotAnimationNode) Static346.A_HASH_TABLE___29.get(local21 << 16 | local25);
                            if (local2004 != null) {
                                local2004.spotAnimation.runParticleSystem();
                                local2004.unlink();
                                return;
                            }
                        } else {
                            local52 = local21 * 512 + 256;
                            local537 = local25 * 512 + 256;
                            local212 = Static87.anInt1810;
                            if (local212 < 3 && Static441.isBridgeAt(local25, local21)) {
                                local212++;
                            }
                            @Pc(2065) SpotAnimation local2065 = new SpotAnimation(local34, local42, Static87.anInt1810, local212, local52, Static102.averageHeight(Static87.anInt1810, local537, local52) - local38, local537, local21, local21, local25, local25, local46, false);
                            Static346.A_HASH_TABLE___29.put(local21 << 16 | local25, new SpotAnimationNode(local2065));
                        }
                    }
                } else {
                    JagException.sendTrace(null, "T3 - " + arg0);
                    Login.logout(false);
                }
            }
        }
    }
}
