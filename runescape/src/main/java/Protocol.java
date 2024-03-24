import com.jagex.ChangeLocationRequest;
import com.jagex.SignLink;
import com.jagex.core.io.Packet;
import com.jagex.core.io.connection.Connection;
import com.jagex.core.stringtools.general.Base37;
import com.jagex.core.stringtools.general.Cp1252;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.core.util.JagException;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import com.jagex.game.compression.huffman.WordPack;
import com.jagex.game.runetek6.config.iftype.ServerActiveProperties;
import com.jagex.game.runetek6.config.iftype.SubInterface;
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

import java.io.IOException;

public final class Protocol {

    @OriginalMember(owner = "client!jfa", name = "a", descriptor = "(Lclient!gw;I)Z")
    public static boolean readServerMessage(@OriginalArg(0) ServerConnection arg0) throws IOException {
        @Pc(8) Connection local8 = arg0.connection;
        @Pc(11) PacketBuffer local11 = arg0.buffer;
        if (local8 == null) {
            return false;
        }
        @Pc(100) int local100;
        if (arg0.currentProt == null) {
            if (arg0.needsOpcode) {
                if (!local8.hasAvailable(1)) {
                    return false;
                }
                local8.read(arg0.buffer.data, 1, 0);
                arg0.anInt3646 = 0;
                arg0.read++;
                arg0.needsOpcode = false;
            }
            local11.pos = 0;
            if (local11.method7413()) {
                if (!local8.hasAvailable(1)) {
                    return false;
                }
                local8.read(arg0.buffer.data, 1, 1);
                arg0.read++;
                arg0.anInt3646 = 0;
            }
            arg0.needsOpcode = true;
            @Pc(96) ServerProt[] local96 = Static585.method7677();
            local100 = local11.method7421();
            if (local100 < 0 || local96.length <= local100) {
                throw new IOException("invo:" + local100 + " ip:" + local11.pos);
            }
            arg0.currentProt = local96[local100];
            arg0.currentPacketSize = arg0.currentProt.size;
        }
        if (arg0.currentPacketSize == -1) {
            if (!local8.hasAvailable(1)) {
                return false;
            }
            local8.read(local11.data, 1, 0);
            arg0.currentPacketSize = local11.data[0] & 0xFF;
            arg0.read++;
            arg0.anInt3646 = 0;
        }
        if (arg0.currentPacketSize == -2) {
            if (!local8.hasAvailable(2)) {
                return false;
            }
            local8.read(local11.data, 2, 0);
            local11.pos = 0;
            arg0.currentPacketSize = local11.g2();
            arg0.read += 2;
            arg0.anInt3646 = 0;
        }
        if (arg0.currentPacketSize > 0) {
            if (!local8.hasAvailable(arg0.currentPacketSize)) {
                return false;
            }
            local11.pos = 0;
            local8.read(local11.data, arg0.currentPacketSize, 0);
            arg0.read += arg0.currentPacketSize;
            arg0.anInt3646 = 0;
        }
        arg0.antepenultimateProt = arg0.penultimateProt;
        arg0.penultimateProt = arg0.aServerProt_92;
        arg0.aServerProt_92 = arg0.currentProt;
        @Pc(277) int local277;
        if (Static586.A_SERVER_PROT___215 == arg0.currentProt) {
            local277 = local11.g4_alt1();
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
            Static605.method7912(Static3.A_ZONE_PROT___1);
            arg0.currentProt = null;
            return true;
        } else if (ServerProt.A_SERVER_PROT___52 == arg0.currentProt) {
            Static605.method7912(Static77.A_ZONE_PROT___5);
            arg0.currentProt = null;
            return true;
        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___239) {
            local277 = local11.g4_alt2();
            local100 = local11.g1_alt1();
            Static574.method7573();
            DelayedStateChange.interfaceSetHide(local100, local277);
            arg0.currentProt = null;
            return true;
        } else if (Static347.A_SERVER_PROT___146 == arg0.currentProt) {
            Static605.method7912(Static420.A_ZONE_PROT___13);
            arg0.currentProt = null;
            return true;
        } else if (Static632.A_SERVER_PROT___229 == arg0.currentProt) {
            Static331.walkText = arg0.currentPacketSize <= 2 ? LocalisedText.WALKHERE.localise(client.language) : local11.gjstr();
            Static331.walkCursor = arg0.currentPacketSize <= 0 ? -1 : local11.g2();
            if (Static331.walkCursor == 65535) {
                Static331.walkCursor = -1;
            }
            arg0.currentProt = null;
            return true;
        } else if (arg0.currentProt == Static504.A_SERVER_PROT___188) {
            Static605.method7912(Static565.A_ZONE_PROT___8);
            arg0.currentProt = null;
            return true;
        } else {
            @Pc(446) boolean local446;
            if (arg0.currentProt == Static679.A_SERVER_PROT___247) {
                local446 = local11.g1_alt2() == 1;
                local100 = local11.g4_alt3();
                Static574.method7573();
                DelayedStateChange.interfaceSetClickMask(local100, local446);
                arg0.currentProt = null;
                return true;
            } else if (Static489.A_SERVER_PROT___185 == arg0.currentProt) {
                local277 = local11.g2_alt2();
                local100 = local11.g4_alt1();
                Static574.method7573();
                DelayedStateChange.interfaceSetScrollPosition(local277, local100);
                arg0.currentProt = null;
                return true;
            } else if (Static201.A_SERVER_PROT___206 == arg0.currentProt) {
                local277 = local11.g4_alt1();
                local100 = local11.g2_alt2();
                Static574.method7573();
                DelayedStateChange.interfaceSetVideo(local100, local277);
                arg0.currentProt = null;
                return true;
            } else {
                @Pc(526) int local526;
                if (arg0.currentProt == Static542.A_SERVER_PROT___199) {
                    local277 = local11.g2s_alt1();
                    local100 = local11.g2s_alt1();
                    local526 = local11.g4_alt3();
                    Static574.method7573();
                    DelayedStateChange.interfaceSetPosition(local100, local277, local526);
                    arg0.currentProt = null;
                    return true;
                } else if (arg0.currentProt == Static331.A_SERVER_PROT___139) {
                    Static400.lastClanSettingsTransmit = World.tick;
                    local446 = local11.g1() == 1;
                    if (arg0.currentPacketSize != 1) {
                        if (local446) {
                            Static128.aClass164_8 = new Class164(local11);
                        } else {
                            Static91.aClass164_9 = new Class164(local11);
                        }
                        arg0.currentProt = null;
                        return true;
                    }
                    arg0.currentProt = null;
                    if (local446) {
                        Static128.aClass164_8 = null;
                    } else {
                        Static91.aClass164_9 = null;
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
                        local446 = local11.g1() == 1;
                        local627 = local11.gjstr();
                        local629 = local627;
                        if (local446) {
                            local629 = local11.gjstr();
                        }
                        local639 = local11.g8();
                        local644 = local11.g2();
                        local649 = local11.g3();
                        local653 = local11.g1();
                        local657 = local11.g2();
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
                        if (!local665 && Static659.anInt9817 == 0) {
                            Static511.aLongArray17[Static97.anInt2001] = local663;
                            Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                            @Pc(737) String local737 = QuickChatPhraseTypeList.instance.method2950(local657).method3903(local11);
                            if (local653 == 2) {
                                Static662.method8625("<img=1>" + local629, "<img=1>" + local627, local657, local737, Base37.decodeName(local639), 0, local627, 20);
                            } else if (local653 == 1) {
                                Static662.method8625("<img=0>" + local629, "<img=0>" + local627, local657, local737, Base37.decodeName(local639), 0, local627, 20);
                            } else {
                                Static662.method8625(local629, local627, local657, local737, Base37.decodeName(local639), 0, local627, 20);
                            }
                        }
                        arg0.currentProt = null;
                        return true;
                    } else if (arg0.currentProt == Static688.A_SERVER_PROT___250) {
                        local446 = local11.g1() == 1;
                        @Pc(854) byte[] local854 = new byte[arg0.currentPacketSize - 1];
                        local11.gdata(0, arg0.currentPacketSize - 1, local854);
                        Static113.method2121(local854, local446);
                        arg0.currentProt = null;
                        return true;
                    } else {
                        @Pc(892) boolean local892;
                        if (arg0.currentProt == ServerProt.A_SERVER_PROT___85) {
                            local277 = local11.g4();
                            local892 = local11.g1() == 1;
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
                            local277 = local11.g2();
                            local931 = local11.g1b_alt1();
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
                                local446 = local11.g1() == 1;
                                local627 = local11.gjstr();
                                local983 = local11.g2();
                                local988 = local11.g3();
                                local992 = local11.g1();
                                local996 = local11.g2();
                                local1002 = (local983 << 32) + local988;
                                local1004 = false;
                                @Pc(1013) Node_Sub47 local1013 = local446 ? Static45.aClass2_Sub47_1 : Static674.aClass2_Sub47_3;
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
                                if (!local1004 && Static659.anInt9817 == 0) {
                                    Static511.aLongArray17[Static97.anInt2001] = local1002;
                                    Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                    local1090 = QuickChatPhraseTypeList.instance.method2950(local996).method3903(local11);
                                    local1097 = local446 ? 42 : 45;
                                    if (local992 == 2 || local992 == 3) {
                                        Static662.method8625("<img=1>" + local627, "<img=1>" + local627, local996, local1090, local1013.aString101, 0, local627, local1097);
                                    } else if (local992 == 1) {
                                        Static662.method8625("<img=0>" + local627, "<img=0>" + local627, local996, local1090, local1013.aString101, 0, local627, local1097);
                                    } else {
                                        Static662.method8625(local627, local627, local996, local1090, local1013.aString101, 0, local627, local1097);
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
                                Static324.reduceAttackPriority = local11.g1_alt3() == 1;
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static619.A_SERVER_PROT___34) {
                                Minimap.toggle = local11.g1();
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static416.A_SERVER_PROT___165) {
                                local277 = local11.g4_alt2();
                                local100 = local11.g2_alt2();
                                if (local100 == 65535) {
                                    local100 = -1;
                                }
                                Static574.method7573();
                                DelayedStateChange.method6462(local100, 1, -1, local277);
                                arg0.currentProt = null;
                                return true;
                            } else if (arg0.currentProt == Static286.A_SERVER_PROT___117) {
                                Static605.method7912(Static370.A_ZONE_PROT___11);
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
                                    while (local11.pos < arg0.currentPacketSize) {
                                        local446 = local11.g1() == 1;
                                        local627 = local11.gjstr();
                                        local629 = local11.gjstr();
                                        local1409 = local11.g2();
                                        local1413 = local11.g1();
                                        local1425 = local11.g1() == 1;
                                        local1427 = "";
                                        @Pc(1429) boolean local1429 = false;
                                        if (local1409 > 0) {
                                            local1427 = local11.gjstr();
                                            local1429 = local11.g1() == 1;
                                        }
                                        for (local1449 = 0; local1449 < Static327.anInt5392; local1449++) {
                                            if (local446) {
                                                if (local629.equals(Static330.aStringArray25[local1449])) {
                                                    Static330.aStringArray25[local1449] = local627;
                                                    local627 = null;
                                                    Static572.aStringArray42[local1449] = local629;
                                                    break;
                                                }
                                            } else if (local627.equals(Static330.aStringArray25[local1449])) {
                                                if (Static371.anIntArray455[local1449] != local1409) {
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
                                                    Static371.anIntArray455[local1449] = local1409;
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
                                        if (local627 != null && Static327.anInt5392 < 200) {
                                            Static330.aStringArray25[Static327.anInt5392] = local627;
                                            Static572.aStringArray42[Static327.anInt5392] = local629;
                                            Static371.anIntArray455[Static327.anInt5392] = local1409;
                                            Static419.aStringArray33[Static327.anInt5392] = local1427;
                                            Static715.anIntArray881[Static327.anInt5392] = local1413;
                                            Static623.aBooleanArray30[Static327.anInt5392] = local1429;
                                            Static429.aBooleanArray21[Static327.anInt5392] = local1425;
                                            Static327.anInt5392++;
                                        }
                                    }
                                    Static344.lastFriendTransmit = World.tick;
                                    Static251.anInt4036 = 2;
                                    local100 = Static327.anInt5392;
                                    while (local100 > 0) {
                                        local446 = true;
                                        local100--;
                                        for (local526 = 0; local526 < local100; local526++) {
                                            @Pc(1665) boolean local1665 = false;
                                            if (client.gameConnection.id != Static371.anIntArray455[local526] && client.gameConnection.id == Static371.anIntArray455[local526 + 1]) {
                                                local1665 = true;
                                            }
                                            if (!local1665 && Static371.anIntArray455[local526] == 0 && Static371.anIntArray455[local526 + 1] != 0) {
                                                local1665 = true;
                                            }
                                            if (!local1665 && !Static429.aBooleanArray21[local526] && Static429.aBooleanArray21[local526 + 1]) {
                                                local1665 = true;
                                            }
                                            if (local1665) {
                                                local1413 = Static371.anIntArray455[local526];
                                                Static371.anIntArray455[local526] = Static371.anIntArray455[local526 + 1];
                                                Static371.anIntArray455[local526 + 1] = local1413;
                                                local1750 = Static419.aStringArray33[local526];
                                                Static419.aStringArray33[local526] = Static419.aStringArray33[local526 + 1];
                                                Static419.aStringArray33[local526 + 1] = local1750;
                                                local1427 = Static330.aStringArray25[local526];
                                                Static330.aStringArray25[local526] = Static330.aStringArray25[local526 + 1];
                                                Static330.aStringArray25[local526 + 1] = local1427;
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
                                    local277 = local11.g1_alt3();
                                    local931 = local11.g1b_alt3();
                                    Static574.method7573();
                                    Static711.method9271(local931, local277);
                                    arg0.currentProt = null;
                                    return true;
                                } else if (ServerProt.VARBIT_LARGE == arg0.currentProt) {
                                    local277 = local11.g4();
                                    local100 = local11.g2();
                                    // g.trace("Received big varbit variable: " + var18 + " value:" + var4);
                                    TimedVarDomain.instance.updateVarBitValue(local277, local100);
                                    arg0.currentProt = null;
                                    return true;
                                } else {
                                    @Pc(1937) String local1937;
                                    if (arg0.currentProt == Static87.A_SERVER_PROT___37) {
                                        local1937 = local11.gjstr();
                                        local100 = local11.g2();
                                        local629 = QuickChatPhraseTypeList.instance.method2950(local100).method3903(local11);
                                        Static662.method8625(local1937, local1937, local100, local629, null, 0, local1937, 19);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (arg0.currentProt == Static526.A_SERVER_PROT___194) {
                                        local277 = local11.g2();
                                        if (local277 == 65535) {
                                            local277 = -1;
                                        }
                                        local100 = local11.g1();
                                        local526 = local11.g2();
                                        local1409 = local11.g1();
                                        local1413 = local11.g2();
                                        Static186.method2818(local277, local100, local1413, local526, local1409, false);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (Static618.A_SERVER_PROT___226 == arg0.currentProt) {
                                        local277 = local11.ig2();
                                        Static574.method7573();
                                        VideoTypeList.method9267(local277);
                                        arg0.currentProt = null;
                                        return true;
                                    } else if (arg0.currentProt == Static286.A_SERVER_PROT___118) {
                                        local277 = local11.g4_alt2();
                                        local100 = local11.g2_alt3();
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
                                            local277 = local11.g2();
                                            local100 = local11.g1();
                                            local2080 = (local100 & 0x1) == 1;
                                            Static205.method3089(local277, local2080);
                                            local1409 = local11.g2();
                                            for (local1413 = 0; local1413 < local1409; local1413++) {
                                                local2098 = local11.g1();
                                                if (local2098 == 255) {
                                                    local2098 = local11.g4();
                                                }
                                                local992 = local11.ig2();
                                                Static341.method5034(local2080, local2098, local1413, local992 - 1, local277);
                                            }
                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static663.A_SERVER_PROT___240 == arg0.currentProt) {
                                            local277 = local11.g4();
                                            Static439.aSignedResource_4 = SignLink.instance.lookupHostname(local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static312.A_SERVER_PROT___131 == arg0.currentProt) {
                                            local277 = local11.ig2();
                                            local100 = local11.g4();
                                            Static574.method7573();
                                            DelayedStateChange.setVarc(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static452.A_SERVER_PROT___173) {
                                            local277 = local11.g4_alt3();
                                            local100 = local11.g2();
                                            local526 = local11.g2_alt3();
                                            local1409 = local11.g2_alt2();
                                            Static574.method7573();
                                            DelayedStateChange.method6462(local1409 << 16 | local526, 7, local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static655.A_SERVER_PROT___237) {
                                            local277 = local11.g4();
                                            Static574.method7573();
                                            DelayedStateChange.method6462(PlayerList.activePlayerSlot, 5, 0, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (ServerProt.A_SERVER_PROT___147 == arg0.currentProt) {
                                            Login.logout(false);
                                            arg0.currentProt = null;
                                            return false;
                                        } else if (arg0.currentProt == Static291.A_SERVER_PROT___123) {
                                            Static466.method6325();
                                            arg0.currentProt = null;
                                            return false;
                                        } else if (arg0.currentProt == Static526.A_SERVER_PROT___195) {
                                            local277 = local11.g2();
                                            local100 = local11.g1();
                                            local2080 = (local100 & 0x1) == 1;
                                            while (arg0.currentPacketSize > local11.pos) {
                                                local1409 = local11.gsmart();
                                                local1413 = local11.g2();
                                                local2098 = 0;
                                                if (local1413 != 0) {
                                                    local2098 = local11.g1();
                                                    if (local2098 == 255) {
                                                        local2098 = local11.g4();
                                                    }
                                                }
                                                Static341.method5034(local2080, local2098, local1409, local1413 - 1, local277);
                                            }
                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static383.A_SERVER_PROT___155 == arg0.currentProt) {
                                            local1937 = local11.gjstr();
                                            @Pc(2379) Object[] local2379 = new Object[local1937.length() + 1];
                                            for (local526 = local1937.length() - 1; local526 >= 0; local526--) {
                                                if (local1937.charAt(local526) == 's') {
                                                    local2379[local526 + 1] = local11.gjstr();
                                                } else {
                                                    local2379[local526 + 1] = Integer.valueOf(local11.g4());
                                                }
                                            }
                                            local2379[0] = Integer.valueOf(local11.g4());
                                            Static574.method7573();
                                            @Pc(2442) HookRequest local2442 = new HookRequest();
                                            local2442.arguments = local2379;
                                            ScriptRunner.executeHookInner(local2442);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static356.A_SERVER_PROT___149) {
                                            local277 = local11.ig2();
                                            local100 = local11.g4();
                                            Static574.method7573();
                                            DelayedStateChange.interfaceSetGraphic(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static491.A_SERVER_PROT___254) {
                                            Static494.anInt7404 = local11.g2s();
                                            arg0.currentProt = null;
                                            Static321.lastMiscTransmit = World.tick;
                                            return true;
                                        } else if (Static608.A_SERVER_PROT___222 == arg0.currentProt) {
                                            local277 = local11.g2_alt3();
                                            local100 = local11.g1_alt3();
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
                                            Static708.method9230(local11.gjstr());
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___16) {
                                            local277 = local11.g1_alt2();
                                            @Pc(2579) int[] local2579 = new int[4];
                                            for (local526 = 0; local526 < 4; local526++) {
                                                local2579[local526] = local11.g2_alt3();
                                            }
                                            local1409 = local11.g2_alt2();
                                            @Pc(2608) NPCEntityNode local2608 = (NPCEntityNode) NPCList.local.get(local1409);
                                            if (local2608 != null) {
                                                Static651.animate(local2579, local277, true, local2608.npc);
                                            }
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static72.A_SERVER_PROT___35) {
                                            if (MainLogicManager.isAtLobbyScreen(MainLogicManager.step)) {
                                                Static249.anInt4008 = (int) ((float) local11.g2() * 2.5F);
                                            } else {
                                                Static249.anInt4008 = local11.g2() * 30;
                                            }
                                            arg0.currentProt = null;
                                            Static321.lastMiscTransmit = World.tick;
                                            return true;
                                        } else if (Static565.A_SERVER_PROT___76 == arg0.currentProt) {
                                            Static486.aByte115 = local11.g1b();
                                            arg0.currentProt = null;
                                            if (Static486.aByte115 == 0 || Static486.aByte115 == 1) {
                                                Static587.aBoolean663 = true;
                                            }
                                            return true;
                                        } else if (ServerProt.VARP_LARGE == arg0.currentProt) {
                                            local277 = local11.g4_alt3();
                                            local100 = local11.g2_alt2();
                                            // g.trace("Received big varp variable: " + var18 + " value:" + var4);
                                            TimedVarDomain.instance.updateVarp(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static229.A_SERVER_PROT___101) {
                                            Static39.lastClanChannelTransmit = World.tick;
                                            local446 = local11.g1() == 1;
                                            @Pc(2736) Class68 local2736 = new Class68(local11);
                                            @Pc(2740) Node_Sub47 local2740;
                                            if (local446) {
                                                local2740 = Static45.aClass2_Sub47_1;
                                            } else {
                                                local2740 = Static674.aClass2_Sub47_3;
                                            }
                                            local2736.method1581(local2740);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static587.A_SERVER_PROT___216 == arg0.currentProt) {
                                            local277 = local11.g4_alt2();
                                            local100 = local11.g2();
                                            Static574.method7573();
                                            DelayedStateChange.interfaceSetColour(local100, local277);
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static344.A_SERVER_PROT___144 == arg0.currentProt) {
                                            local277 = local11.g4_alt1();
                                            Static574.method7573();
                                            if (local277 == -1) {
                                                Static693.anInt10383 = -1;
                                                Static692.anInt10376 = -1;
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
                                                Static692.anInt10376 = (local100 << 9) + 256;
                                                if (local526 < 0) {
                                                    local526 = 0;
                                                } else if (local526 >= Static501.mapHeight) {
                                                    local526 = Static501.mapHeight;
                                                }
                                                Static693.anInt10383 = (local526 << 9) + 256;
                                            }
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (arg0.currentProt == Static491.A_SERVER_PROT___253) {
                                            Static696.method9035();
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (Static14.A_SERVER_PROT___5 == arg0.currentProt) {
                                            local277 = local11.g2();
                                            local931 = local11.g1b();
                                            if (Static279.anObjectArray35 == null) {
                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                            }
                                            Static279.anObjectArray35[local277] = Integer.valueOf(local931);
                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                            arg0.currentProt = null;
                                            return true;
                                        } else if (ServerProt.A_SERVER_PROT___18 == arg0.currentProt) {
                                            local277 = local11.g2();
                                            Static607.anInt9251 = -1;
                                            CutsceneManager.cutsceneId = local277;
                                            CutsceneManager.state = 1;
                                            js5.CUTSCENES.fileready(CutsceneManager.cutsceneId);
                                            local100 = local11.g2();
                                            Static322.anIntArrayArray265 = new int[local100][4];
                                            for (local526 = 0; local526 < local100; local526++) {
                                                for (local1409 = 0; local1409 < 4; local1409++) {
                                                    Static322.anIntArrayArray265[local526][local1409] = local11.g4();
                                                }
                                            }
                                            local1409 = local11.g1();
                                            Static518.aClass2_Sub21_18 = new Packet(local1409);
                                            Static518.aClass2_Sub21_18.pdata(local1409, local11.data, local11.pos);
                                            local11.pos += local1409;
                                            arg0.currentProt = null;
                                            return false;
                                        } else {
                                            @Pc(3044) byte[] local3044;
                                            if (ServerProt.A_SERVER_PROT___251 == arg0.currentProt) {
                                                if (GameShell.fsframe != null) {
                                                    InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                                                }
                                                local3044 = new byte[arg0.currentPacketSize];
                                                local11.method7416(local3044, arg0.currentPacketSize);
                                                local627 = Cp1252.decode(0, local3044, arg0.currentPacketSize);
                                                Static664.method8655(ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, local627, true, SignLink.instance);
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (arg0.currentProt == Static444.A_SERVER_PROT___169) {
                                                local446 = local11.g1() == 1;
                                                local627 = local11.gjstr();
                                                local629 = local627;
                                                if (local446) {
                                                    local629 = local11.gjstr();
                                                }
                                                local639 = local11.g2();
                                                local644 = local11.g3();
                                                local996 = local11.g1();
                                                local1449 = local11.g2();
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
                                                if (!local3136 && Static659.anInt9817 == 0) {
                                                    Static511.aLongArray17[Static97.anInt2001] = local3134;
                                                    Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                    local1090 = QuickChatPhraseTypeList.instance.method2950(local1449).method3903(local11);
                                                    if (local996 == 2) {
                                                        Static662.method8625("<img=1>" + local629, "<img=1>" + local627, local1449, local1090, null, 0, local627, 18);
                                                    } else if (local996 == 1) {
                                                        Static662.method8625("<img=0>" + local629, "<img=0>" + local627, local1449, local1090, null, 0, local627, 18);
                                                    } else {
                                                        Static662.method8625(local629, local627, local1449, local1090, null, 0, local627, 18);
                                                    }
                                                }
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (ServerProt.VARBIT_SMALL == arg0.currentProt) {
                                                local277 = local11.g1_alt3();
                                                local100 = local11.g2_alt2();
                                                // g.trace("Received small varbit variable: " + var18 + " value:" + var4);
                                                TimedVarDomain.instance.updateVarBitValue(local277, local100);
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (Static636.A_SERVER_PROT___230 == arg0.currentProt) {
                                                local277 = local11.g1_alt3();
                                                local100 = local11.g1_alt1();
                                                local526 = local11.g4_alt1();
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
                                                Static726.aClass280_7 = Static189.method2864(local11.g1());
                                                arg0.currentProt = null;
                                                return true;
                                            } else if (Static410.A_SERVER_PROT___163 == arg0.currentProt) {
                                                local277 = local11.g1_alt3();
                                                local100 = local11.g4();
                                                local526 = local11.ig2();
                                                local1409 = local11.ig2();
                                                Static574.method7573();
                                                DelayedStateChange.interfaceSetRecol(local277, local1409, local100, local526);
                                                arg0.currentProt = null;
                                                return true;
                                            } else {
                                                @Pc(3502) int local3502;
                                                @Pc(3582) String local3582;
                                                if (arg0.currentProt == Static266.A_SERVER_PROT___191) {
                                                    local446 = local11.g1() == 1;
                                                    local627 = local11.gjstr();
                                                    local983 = local11.g2();
                                                    local988 = local11.g3();
                                                    local992 = local11.g1();
                                                    local649 = (local983 << 32) + local988;
                                                    local1491 = false;
                                                    @Pc(3494) Node_Sub47 local3494 = local446 ? Static45.aClass2_Sub47_1 : Static674.aClass2_Sub47_3;
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
                                                    if (!local1491 && Static659.anInt9817 == 0) {
                                                        Static511.aLongArray17[Static97.anInt2001] = local649;
                                                        Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                        local3582 = Static130.method2280(WordPack.decode(local11));
                                                        local1021 = local446 ? 41 : 44;
                                                        if (local992 == 2 || local992 == 3) {
                                                            Static662.method8625("<img=1>" + local627, "<img=1>" + local627, -1, local3582, local3494.aString101, 0, local627, local1021);
                                                        } else if (local992 == 1) {
                                                            Static662.method8625("<img=0>" + local627, "<img=0>" + local627, -1, local3582, local3494.aString101, 0, local627, local1021);
                                                        } else {
                                                            Static662.method8625(local627, local627, -1, local3582, local3494.aString101, 0, local627, local1021);
                                                        }
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static618.A_SERVER_PROT___227) {
                                                    local277 = local11.g1();
                                                    local100 = local277 >> 5;
                                                    local526 = local277 & 0x1F;
                                                    if (local526 == 0) {
                                                        Static527.aClass254Array1[local100] = null;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    }
                                                    @Pc(3721) Class254 local3721 = new Class254();
                                                    local3721.anInt6363 = local526;
                                                    local3721.anInt6367 = local11.g1();
                                                    if (local3721.anInt6367 >= 0 && local3721.anInt6367 < Sprites.hintHeadicons.length) {
                                                        if (local3721.anInt6363 == 1 || local3721.anInt6363 == 10) {
                                                            local3721.anInt6366 = local11.g2();
                                                            local3721.anInt6360 = local11.g2();
                                                            local11.pos += 4;
                                                        } else if (local3721.anInt6363 >= 2 && local3721.anInt6363 <= 6) {
                                                            if (local3721.anInt6363 == 2) {
                                                                local3721.anInt6362 = 256;
                                                                local3721.anInt6369 = 256;
                                                            }
                                                            if (local3721.anInt6363 == 3) {
                                                                local3721.anInt6369 = 0;
                                                                local3721.anInt6362 = 256;
                                                            }
                                                            if (local3721.anInt6363 == 4) {
                                                                local3721.anInt6369 = 512;
                                                                local3721.anInt6362 = 256;
                                                            }
                                                            if (local3721.anInt6363 == 5) {
                                                                local3721.anInt6362 = 0;
                                                                local3721.anInt6369 = 256;
                                                            }
                                                            if (local3721.anInt6363 == 6) {
                                                                local3721.anInt6362 = 512;
                                                                local3721.anInt6369 = 256;
                                                            }
                                                            local3721.anInt6363 = 2;
                                                            local3721.anInt6368 = local11.g1();
                                                            local3721.anInt6369 += local11.g2() - WorldMap.areaBaseX << 9;
                                                            local3721.anInt6362 += local11.g2() - WorldMap.areaBaseZ << 9;
                                                            local3721.anInt6365 = local11.g1() << 2;
                                                            local3721.anInt6364 = local11.g2();
                                                        }
                                                        local3721.anInt6371 = local11.g2();
                                                        if (local3721.anInt6371 == 65535) {
                                                            local3721.anInt6371 = -1;
                                                        }
                                                        Static527.aClass254Array1[local100] = local3721;
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static428.A_SERVER_PROT___167) {
                                                    local277 = local11.g1_alt3();
                                                    Static574.method7573();
                                                    arg0.currentProt = null;
                                                    Static150.anInt2632 = local277;
                                                    return true;
                                                } else if (arg0.currentProt == Static309.A_SERVER_PROT___130) {
                                                    local11.pos += 28;
                                                    if (local11.checkcrc()) {
                                                        Static83.method1608(local11.pos - 28, local11);
                                                    }
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static303.A_SERVER_PROT___126) {
                                                    local277 = local11.ig2();
                                                    if (local277 == 65535) {
                                                        local277 = -1;
                                                    }
                                                    local100 = local11.g4();
                                                    local526 = local11.g4_alt3();
                                                    Static574.method7573();
                                                    DelayedStateChange.interfaceSetObject(local526, local100, local277);
                                                    @Pc(4005) ObjType local4005 = ObjTypeList.instance.list(local277);
                                                    DelayedStateChange.interfaceSetModelAngle(local4005.xan2d, local4005.zoom2d, local526, local4005.yan2d);
                                                    DelayedStateChange.interfaceSetModelOffset(local4005.zan2d, local526, local4005.yof2d, local4005.xof2d);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static208.A_SERVER_PROT___83) {
                                                    local277 = local11.g1_alt3();
                                                    local100 = local11.g2();
                                                    Static574.method7573();
                                                    VideoTypeList.method6802(true, local100, local277);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static479.A_SERVER_PROT___177) {
                                                    local446 = local11.g1_alt2() == 1;
                                                    Static574.method7573();
                                                    Static501.aBoolean576 = local446;
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (arg0.currentProt == Static557.A_SERVER_PROT___205) {
                                                    local277 = local11.g1();
                                                    if (local11.g1() == 0) {
                                                        Static105.aClass171Array1[local277] = new Class171();
                                                    } else {
                                                        local11.pos--;
                                                        Static105.aClass171Array1[local277] = new Class171(local11);
                                                    }
                                                    Static526.lastStockTransmit = World.tick;
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (Static334.A_SERVER_PROT___140 == arg0.currentProt) {
                                                    local277 = local11.g2_alt3();
                                                    Static574.method7573();
                                                    VideoManager.stop(local277);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else if (Static166.A_SERVER_PROT___63 == arg0.currentProt) {
                                                    Static605.method7912(Static668.A_ZONE_PROT___16);
                                                    arg0.currentProt = null;
                                                    return true;
                                                } else {
                                                    @Pc(4175) String local4175;
                                                    @Pc(4177) String local4177;
                                                    if (arg0.currentProt == Static408.A_SERVER_PROT___162) {
                                                        local277 = local11.gsmart();
                                                        local100 = local11.g4();
                                                        local526 = local11.g1();
                                                        local4175 = "";
                                                        local4177 = local4175;
                                                        if ((local526 & 0x1) != 0) {
                                                            local4175 = local11.gjstr();
                                                            if ((local526 & 0x2) == 0) {
                                                                local4177 = local4175;
                                                            } else {
                                                                local4177 = local11.gjstr();
                                                            }
                                                        }
                                                        local1750 = local11.gjstr();
                                                        if (local277 == 99) {
                                                            Static79.method1579(local1750);
                                                        } else if (local277 == 98) {
                                                            Static87.method1694(local1750);
                                                        } else if (local4177.equals("") || !Static71.method1524(local4177)) {
                                                            Static44.method1072(local1750, local4175, local100, local4175, local4177, local277);
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
                                                        local277 = local11.g2_alt3();
                                                        local627 = local11.gjstr();
                                                        Static574.method7573();
                                                        DelayedStateChange.setVarcstr(local277, local627);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (arg0.currentProt == Static231.A_SERVER_PROT___102) {
                                                        local277 = local11.g1_alt3();
                                                        local100 = local11.g1_alt1();
                                                        local526 = local11.g2_alt3();
                                                        local1409 = local11.g1_alt3();
                                                        local1413 = local11.g1_alt3();
                                                        Static574.method7573();
                                                        Static572.aBooleanArray29[local100] = true;
                                                        Static331.anIntArray403[local100] = local1409;
                                                        Static140.anIntArray222[local100] = local1413;
                                                        Static362.anIntArray450[local100] = local277;
                                                        Static194.anIntArray268[local100] = local526;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (ServerProt.SOUND_AREA == arg0.currentProt) {
                                                        Static605.method7912(Static481.A_ZONE_PROT___15);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static225.A_SERVER_PROT___90 == arg0.currentProt) {
                                                        Static436.anInt3849 = local11.g1();
                                                        for (local277 = 0; local277 < Static436.anInt3849; local277++) {
                                                            Static632.aStringArray44[local277] = local11.gjstr();
                                                            Static446.aStringArray35[local277] = local11.gjstr();
                                                            if (Static446.aStringArray35[local277].equals("")) {
                                                                Static446.aStringArray35[local277] = Static632.aStringArray44[local277];
                                                            }
                                                            Static10.aStringArray1[local277] = local11.gjstr();
                                                            Static316.aStringArray41[local277] = local11.gjstr();
                                                            if (Static316.aStringArray41[local277].equals("")) {
                                                                Static316.aStringArray41[local277] = Static10.aStringArray1[local277];
                                                            }
                                                            Static65.aBooleanArray2[local277] = false;
                                                        }
                                                        Static344.lastFriendTransmit = World.tick;
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static570.A_SERVER_PROT___208 == arg0.currentProt) {
                                                        Static605.method7912(Static379.A_ZONE_PROT___12);
                                                        arg0.currentProt = null;
                                                        return true;
                                                    } else if (Static273.A_SERVER_PROT___113 == arg0.currentProt) {
                                                        local277 = local11.g1_alt1();
                                                        local100 = local11.ig2();
                                                        if (local100 == 65535) {
                                                            local100 = -1;
                                                        }
                                                        local629 = local11.gjstr();
                                                        local1409 = local11.g1_alt2();
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
                                                            local277 = local11.g2_alt2();
                                                            if (local277 == 65535) {
                                                                local277 = -1;
                                                            }
                                                            local100 = local11.g4_alt3();
                                                            local526 = local11.g2();
                                                            if (local526 == 65535) {
                                                                local526 = -1;
                                                            }
                                                            local1409 = local11.ig2();
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
                                                            local277 = local11.g2();
                                                            local4669 = local11.g8();
                                                            if (Static279.anObjectArray35 == null) {
                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                            }
                                                            Static279.anObjectArray35[local277] = Long.valueOf(local4669);
                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else if (Static233.A_SERVER_PROT___104 == arg0.currentProt) {
                                                            local277 = local11.ig2();
                                                            local100 = local11.g2_alt3();
                                                            local526 = local11.g4();
                                                            Static574.method7573();
                                                            DelayedStateChange.method4347(local526, local277 + (local100 << 16));
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else if (arg0.currentProt == Static137.A_SERVER_PROT___56) {
                                                            Static605.method7912(Static328.A_ZONE_PROT___10);
                                                            arg0.currentProt = null;
                                                            return true;
                                                        } else {
                                                            @Pc(4857) boolean local4857;
                                                            if (arg0.currentProt == Static605.A_SERVER_PROT___220) {
                                                                local277 = local11.g2_alt2();
                                                                local100 = local11.g4_alt3();
                                                                local526 = local11.g1_alt1();
                                                                local1409 = local11.g1_alt1();
                                                                local1413 = local11.g2();
                                                                local2098 = local11.ig2();
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
                                                                            @Pc(5334) SpotAnimation local5334 = new SpotAnimation(local2098, local277, local653, local667, local1021, Static102.averageHeight(local653, -29754, local1097, local1021) - local1413, local1097, local657, local657, local3502, local3502, local992, local4806);
                                                                            Static346.A_HASH_TABLE___29.put(local3502 | local657 << 16, new SpotAnimationNode(local5334));
                                                                        }
                                                                    }
                                                                }
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static9.A_SERVER_PROT___3 == arg0.currentProt) {
                                                                local277 = local11.g4();
                                                                local100 = local11.ig2();
                                                                if (local100 == 65535) {
                                                                    local100 = -1;
                                                                }
                                                                Static574.method7573();
                                                                DelayedStateChange.method6462(local100, 2, -1, local277);
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static36.A_SERVER_PROT___15 == arg0.currentProt) {
                                                                Static480.method6468(local11, SignLink.instance, arg0.currentPacketSize);
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else if (Static193.A_SERVER_PROT___74 == arg0.currentProt) {
                                                                Static574.method7573();
                                                                Static693.method9012();
                                                                arg0.currentProt = null;
                                                                return true;
                                                            } else {
                                                                @Pc(5445) SubInterface local5445;
                                                                if (ServerProt.A_SERVER_PROT___47 == arg0.currentProt) {
                                                                    local277 = local11.g4_alt2();
                                                                    local100 = local11.g4_alt3();
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
                                                                    local277 = local11.g2_alt3();
                                                                    local100 = local11.g4_alt1();
                                                                    local526 = local11.g1();
                                                                    Static574.method7573();
                                                                    local5445 = (SubInterface) InterfaceManager.subInterfaces.get(local100);
                                                                    if (local5445 != null) {
                                                                        InterfaceManager.closeSubInterface(false, local5445.id != local277, local5445);
                                                                    }
                                                                    InterfaceManager.openSubInterface(local526, local277, local100, false);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static563.A_SERVER_PROT___207) {
                                                                    local277 = local11.g1_alt2();
                                                                    local100 = local11.g2_alt3() << 2;
                                                                    local526 = local11.g1_alt3();
                                                                    local1409 = local11.g1();
                                                                    local1413 = local11.g1_alt3();
                                                                    Static574.method7573();
                                                                    Static638.method8397(local1409, local277, local526, local100, local1413);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static671.A_SERVER_PROT___246 == arg0.currentProt) {
                                                                    Static703.anInt10571 = local11.g1();
                                                                    arg0.currentProt = null;
                                                                    Static321.lastMiscTransmit = World.tick;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static721.A_SERVER_PROT___259) {
                                                                    local277 = local11.g2_alt2();
                                                                    local100 = local11.g2_alt3();
                                                                    local526 = local11.g4_alt1();
                                                                    local1409 = local11.g2_alt3();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.interfaceSetModelAngle(local1409, local277, local526, local100);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static454.A_SERVER_PROT___174 == arg0.currentProt) {
                                                                    local1937 = local11.gjstr();
                                                                    local100 = local11.g2_alt2();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.setVarcstr(local100, local1937);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static663.A_SERVER_PROT___241) {
                                                                    local446 = local11.g1() == 1;
                                                                    local627 = local11.gjstr();
                                                                    local629 = local627;
                                                                    if (local446) {
                                                                        local629 = local11.gjstr();
                                                                    }
                                                                    local639 = local11.g2();
                                                                    local644 = local11.g3();
                                                                    local996 = local11.g1();
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
                                                                    if (!local1004 && Static659.anInt9817 == 0) {
                                                                        Static511.aLongArray17[Static97.anInt2001] = local1002;
                                                                        Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                                        local3582 = Static130.method2280(WordPack.decode(local11));
                                                                        if (local996 == 2) {
                                                                            Static662.method8625("<img=1>" + local629, "<img=1>" + local627, -1, local3582, null, 0, local627, 7);
                                                                        } else if (local996 == 1) {
                                                                            Static662.method8625("<img=0>" + local629, "<img=0>" + local627, -1, local3582, null, 0, local627, 7);
                                                                        } else {
                                                                            Static662.method8625(local629, local627, -1, local3582, null, 0, local627, 3);
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static606.A_SERVER_PROT___221) {
                                                                    local277 = local11.g1_alt3();
                                                                    local100 = local11.ig2();
                                                                    if (local100 == 65535) {
                                                                        local100 = -1;
                                                                    }
                                                                    local526 = local11.g1_alt2();
                                                                    Static63.method1427(local526, local100, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static699.A_SERVER_PROT___252 == arg0.currentProt) {
                                                                    local277 = local11.g2_alt2();
                                                                    if (local277 == 65535) {
                                                                        local277 = -1;
                                                                    }
                                                                    local100 = local11.g3_alt1();
                                                                    local526 = local11.g1_alt2();
                                                                    Static482.method6481(local526, local277, local100);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static272.A_SERVER_PROT___112 == arg0.currentProt) {
                                                                    if (GameShell.fsframe != null) {
                                                                        InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
                                                                    }
                                                                    local3044 = new byte[arg0.currentPacketSize];
                                                                    local11.method7416(local3044, arg0.currentPacketSize);
                                                                    local627 = Cp1252.decode(0, local3044, arg0.currentPacketSize);
                                                                    local629 = "opensn";
                                                                    if (!client.js || Static36.method980(SignLink.instance, local627, local629, 1).status == 2) {
                                                                        Static259.method3693(local627, local629, SignLink.instance, ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, true);
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static459.A_SERVER_PROT___175) {
                                                                    local277 = local11.g2();
                                                                    local100 = local11.g2();
                                                                    local526 = local11.g2();
                                                                    Static574.method7573();
                                                                    if (InterfaceList.interfaces[local277] != null) {
                                                                        for (local1409 = local100; local1409 < local526; local1409++) {
                                                                            local1413 = local11.g3();
                                                                            if (InterfaceList.interfaces[local277].length > local1409 && InterfaceList.interfaces[local277][local1409] != null) {
                                                                                InterfaceList.interfaces[local277][local1409].anInt3774 = local1413;
                                                                            }
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static266.A_SERVER_PROT___192) {
                                                                    local277 = local11.g4_alt2();
                                                                    local100 = local11.g2();
                                                                    local526 = local11.g4_alt3();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.method6462(local100, 5, local526, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___219) {
                                                                    Static605.method7912(Static84.A_ZONE_PROT___6);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static389.aServerProt_157 == arg0.currentProt) {
                                                                    local277 = local11.g2();
                                                                    if (local277 == 65535) {
                                                                        local277 = -1;
                                                                    }
                                                                    local100 = local11.g1();
                                                                    local526 = local11.g2();
                                                                    local1409 = local11.g1();
                                                                    Static186.method2818(local277, local100, 256, local526, local1409, true);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___19) {
                                                                    Static574.method7573();
                                                                    Static145.method2409();
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static91.A_SERVER_PROT___236) {
                                                                    Static308.method4482(local11, arg0.currentPacketSize);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static250.A_SERVER_PROT___105 == arg0.currentProt) {
                                                                    Static133.anInt2458 = local11.g1();
                                                                    Static87.anInt1806 = local11.g1();
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (Static31.A_SERVER_PROT___14 == arg0.currentProt) {
                                                                    Static626.anInt9476 = local11.g1b() << 3;
                                                                    Static270.anInt4354 = local11.g1b_alt3() << 3;
                                                                    Static87.anInt1810 = local11.g1();
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
                                                                    for (local6385 = (ChangeLocationRequest) Static159.aDeque_15.first(); local6385 != null; local6385 = (ChangeLocationRequest) Static159.aDeque_15.next()) {
                                                                        if (Static626.anInt9476 <= local6385.anInt4016 && Static626.anInt9476 + 8 > local6385.anInt4016 && local6385.anInt4006 >= Static270.anInt4354 && Static270.anInt4354 + 8 > local6385.anInt4006 && Static87.anInt1810 == local6385.anInt4010) {
                                                                            local6385.aBoolean309 = true;
                                                                        }
                                                                    }
                                                                    for (local6385 = (ChangeLocationRequest) Static227.aDeque_18.first(); local6385 != null; local6385 = (ChangeLocationRequest) Static227.aDeque_18.next()) {
                                                                        if (local6385.anInt4016 >= Static626.anInt9476 && Static626.anInt9476 + 8 > local6385.anInt4016 && local6385.anInt4006 >= Static270.anInt4354 && Static270.anInt4354 + 8 > local6385.anInt4006 && local6385.anInt4010 == Static87.anInt1810) {
                                                                            local6385.aBoolean309 = true;
                                                                        }
                                                                    }
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else if (arg0.currentProt == Static533.A_SERVER_PROT___196) {
                                                                    local277 = local11.g4_alt1();
                                                                    Static574.method7573();
                                                                    DelayedStateChange.method6462(-1, 3, -1, local277);
                                                                    arg0.currentProt = null;
                                                                    return true;
                                                                } else {
                                                                    @Pc(6565) boolean local6565;
                                                                    if (Static718.A_SERVER_PROT___258 == arg0.currentProt) {
                                                                        local446 = local11.g1() == 1;
                                                                        local627 = local11.gjstr();
                                                                        local629 = local627;
                                                                        if (local446) {
                                                                            local629 = local11.gjstr();
                                                                        }
                                                                        local1409 = local11.g1();
                                                                        local6565 = false;
                                                                        if (local1409 <= 1) {
                                                                            if (Static389.aBoolean459 && !Static34.aBoolean62 || Static617.aBoolean724) {
                                                                                local6565 = true;
                                                                            } else if (local1409 <= 1 && Static71.method1524(local629)) {
                                                                                local6565 = true;
                                                                            }
                                                                        }
                                                                        if (!local6565 && Static659.anInt9817 == 0) {
                                                                            local1750 = Static130.method2280(WordPack.decode(local11));
                                                                            if (local1409 == 2) {
                                                                                Static662.method8625("<img=1>" + local629, "<img=1>" + local627, -1, local1750, null, 0, local627, 24);
                                                                            } else if (local1409 == 1) {
                                                                                Static662.method8625("<img=0>" + local629, "<img=0>" + local627, -1, local1750, null, 0, local627, 24);
                                                                            } else {
                                                                                Static662.method8625(local629, local627, -1, local1750, null, 0, local627, 24);
                                                                            }
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static629.A_SERVER_PROT___228 == arg0.currentProt) {
                                                                        local277 = local11.g2();
                                                                        local627 = local11.gjstr();
                                                                        local2080 = local11.g1() == 1;
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
                                                                        local446 = local11.g1() == 1;
                                                                        if (arg0.currentPacketSize != 1) {
                                                                            if (local446) {
                                                                                Static45.aClass2_Sub47_1 = new Node_Sub47(local11);
                                                                            } else {
                                                                                Static674.aClass2_Sub47_3 = new Node_Sub47(local11);
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
                                                                        Static626.anInt9476 = local11.g1b_alt2() << 3;
                                                                        Static87.anInt1810 = local11.g1_alt1();
                                                                        Static270.anInt4354 = local11.g1b() << 3;
                                                                        while (local11.pos < arg0.currentPacketSize) {
                                                                            @Pc(6873) ZoneProt local6873 = Static559.method7419()[local11.g1()];
                                                                            Static605.method7912(local6873);
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static651.A_SERVER_PROT___235 == arg0.currentProt) {
                                                                        Static434.method5855();
                                                                        arg0.currentProt = null;
                                                                        return false;
                                                                    } else if (arg0.currentProt == Static41.A_SERVER_PROT___20) {
                                                                        local277 = local11.g4_alt3();
                                                                        local100 = local277 >> 28 & 0x3;
                                                                        local526 = local277 >> 14 & 0x3FFF;
                                                                        local1409 = local277 & 0x3FFF;
                                                                        local1413 = local11.g2_alt2();
                                                                        if (local1413 == 65535) {
                                                                            local1413 = -1;
                                                                        }
                                                                        local2098 = local11.g1_alt3();
                                                                        local992 = local2098 >> 2;
                                                                        local996 = local2098 & 0x3;
                                                                        local1449 = Static310.anIntArray379[local992];
                                                                        local1409 -= WorldMap.areaBaseZ;
                                                                        local526 -= WorldMap.areaBaseX;
                                                                        Static198.method2953(local100, local1409, local992, local1413, local526, local996, local1449);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static706.A_SERVER_PROT___255 == arg0.currentProt) {
                                                                        local277 = local11.g1();
                                                                        local892 = (local277 & 0x1) == 1;
                                                                        local629 = local11.gjstr();
                                                                        local4175 = local11.gjstr();
                                                                        if (local4175.equals("")) {
                                                                            local4175 = local629;
                                                                        }
                                                                        local4177 = local11.gjstr();
                                                                        local1750 = local11.gjstr();
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
                                                                        local277 = local11.g4_alt2();
                                                                        if (local277 != Static435.anInt6594) {
                                                                            Static435.anInt6594 = local277;
                                                                            ScriptRunner.executeTrigger(Static362.A_CLIENT_TRIGGER_TYPE___10, -1, -1);
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (Static550.A_SERVER_PROT___200 == arg0.currentProt) {
                                                                        local446 = local11.g1() == 1;
                                                                        local627 = local11.gjstr();
                                                                        local629 = local627;
                                                                        if (local446) {
                                                                            local629 = local11.gjstr();
                                                                        }
                                                                        local1409 = local11.g1();
                                                                        local1413 = local11.g2();
                                                                        local1425 = false;
                                                                        if (local1409 <= 1 && Static71.method1524(local629)) {
                                                                            local1425 = true;
                                                                        }
                                                                        if (!local1425 && Static659.anInt9817 == 0) {
                                                                            local1427 = QuickChatPhraseTypeList.instance.method2950(local1413).method3903(local11);
                                                                            if (local1409 == 2) {
                                                                                Static662.method8625("<img=1>" + local629, "<img=1>" + local627, local1413, local1427, null, 0, local627, 25);
                                                                            } else if (local1409 == 1) {
                                                                                Static662.method8625("<img=0>" + local629, "<img=0>" + local627, local1413, local1427, null, 0, local627, 25);
                                                                            } else {
                                                                                Static662.method8625(local629, local627, local1413, local1427, null, 0, local627, 25);
                                                                            }
                                                                        }
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static287.A_SERVER_PROT___119) {
                                                                        local277 = local11.g4();
                                                                        local100 = local11.g4();
                                                                        @Pc(7309) ClientMessage local7309 = ClientMessage.create(Static128.A_CLIENT_PROT___106, arg0.cipher);
                                                                        local7309.buffer.p4(local277);
                                                                        local7309.buffer.p4(local100);
                                                                        arg0.send(local7309);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else if (arg0.currentProt == Static84.A_SERVER_PROT___36) {
                                                                        Static605.method7912(Static450.A_ZONE_PROT___14);
                                                                        arg0.currentProt = null;
                                                                        return true;
                                                                    } else {
                                                                        @Pc(7394) Class241 local7394;
                                                                        if (arg0.currentProt == Static137.A_SERVER_PROT___57) {
                                                                            local1937 = local11.gjstr();
                                                                            local2080 = local11.g1() == 1;
                                                                            if (local2080) {
                                                                                local627 = local11.gjstr();
                                                                            } else {
                                                                                local627 = local1937;
                                                                            }
                                                                            local1409 = local11.g2();
                                                                            @Pc(7377) byte local7377 = local11.g1b();
                                                                            local1425 = false;
                                                                            if (local7377 == -128) {
                                                                                local1425 = true;
                                                                            }
                                                                            if (local1425) {
                                                                                if (Static706.anInt10633 == 0) {
                                                                                    arg0.currentProt = null;
                                                                                    return true;
                                                                                }
                                                                                for (local992 = 0; Static706.anInt10633 > local992 && (!Static87.aClass241Array1[local992].aString66.equals(local627) || local1409 != Static87.aClass241Array1[local992].anInt6148); local992++) {
                                                                                }
                                                                                if (local992 < Static706.anInt10633) {
                                                                                    while (Static706.anInt10633 - 1 > local992) {
                                                                                        Static87.aClass241Array1[local992] = Static87.aClass241Array1[local992 + 1];
                                                                                        local992++;
                                                                                    }
                                                                                    Static706.anInt10633--;
                                                                                    Static87.aClass241Array1[Static706.anInt10633] = null;
                                                                                }
                                                                            } else {
                                                                                local1427 = local11.gjstr();
                                                                                local7394 = new Class241();
                                                                                local7394.aString67 = local1937;
                                                                                local7394.aString66 = local627;
                                                                                local7394.aString68 = NameTools.format(local7394.aString66);
                                                                                local7394.anInt6148 = local1409;
                                                                                local7394.aString65 = local1427;
                                                                                local7394.aByte99 = local7377;
                                                                                for (local1449 = Static706.anInt10633 - 1; local1449 >= 0; local1449--) {
                                                                                    local653 = Static87.aClass241Array1[local1449].aString68.compareTo(local7394.aString68);
                                                                                    if (local653 == 0) {
                                                                                        Static87.aClass241Array1[local1449].anInt6148 = local1409;
                                                                                        Static87.aClass241Array1[local1449].aByte99 = local7377;
                                                                                        Static87.aClass241Array1[local1449].aString65 = local1427;
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
                                                                                if (Static87.aClass241Array1.length <= Static706.anInt10633) {
                                                                                    arg0.currentProt = null;
                                                                                    return true;
                                                                                }
                                                                                for (local653 = Static706.anInt10633 - 1; local653 > local1449; local653--) {
                                                                                    Static87.aClass241Array1[local653 + 1] = Static87.aClass241Array1[local653];
                                                                                }
                                                                                if (Static706.anInt10633 == 0) {
                                                                                    Static87.aClass241Array1 = new Class241[100];
                                                                                }
                                                                                Static87.aClass241Array1[local1449 + 1] = local7394;
                                                                                Static706.anInt10633++;
                                                                                if (local627.equals(PlayerEntity.self.accountName)) {
                                                                                    Static682.aByte142 = local7377;
                                                                                }
                                                                            }
                                                                            Static352.lastClanTransmit = World.tick;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___11) {
                                                                            local277 = local11.g2();
                                                                            local100 = local11.g4();
                                                                            if (Static279.anObjectArray35 == null) {
                                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                                            }
                                                                            Static279.anObjectArray35[local277] = Integer.valueOf(local100);
                                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (ServerProt.A_SERVER_PROT___54 == arg0.currentProt) {
                                                                            local277 = local11.g2();
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
                                                                            local526 = local11.g2();
                                                                            local1409 = local11.g1();
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
                                                                                if (!local1425 && Static659.anInt9817 == 0) {
                                                                                    local996 = -1;
                                                                                    if (local6565) {
                                                                                        local526 &= 0x7FFF;
                                                                                        @Pc(7827) Class21 local7827 = Static260.method3828(local11);
                                                                                        local996 = local7827.anInt521;
                                                                                        local1427 = local7827.aClass2_Sub2_Sub12_1.method3903(local11);
                                                                                    } else {
                                                                                        local1427 = Static130.method2280(WordPack.decode(local11));
                                                                                    }
                                                                                    local7724.method1413(local526 >> 8, local526 & 0xFF, local1427.trim());
                                                                                    if (local1409 == 1 || local1409 == 2) {
                                                                                        local1449 = local6565 ? 17 : 1;
                                                                                    } else {
                                                                                        local1449 = local6565 ? 17 : 2;
                                                                                    }
                                                                                    if (local1409 == 2) {
                                                                                        Static662.method8625("<img=1>" + local7724.method1422(), "<img=1>" + local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    } else if (local1409 == 1) {
                                                                                        Static662.method8625("<img=0>" + local7724.method1422(), "<img=0>" + local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    } else {
                                                                                        Static662.method8625(local7724.method1422(), local7724.getDisplayName(false, true), local996, local1427, null, 0, local7724.displayName, local1449);
                                                                                    }
                                                                                }
                                                                            }
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static19.A_SERVER_PROT___8) {
                                                                            local277 = local11.g2();
                                                                            if (local277 == 65535) {
                                                                                local277 = -1;
                                                                            }
                                                                            local100 = local11.g1();
                                                                            local526 = local11.g2();
                                                                            local1409 = local11.g1();
                                                                            local1413 = local11.g2();
                                                                            Static161.method2586(local1413, local526, local277, local100, local1409);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static590.A_SERVER_PROT___217 == arg0.currentProt) {
                                                                            arg0.currentProt = null;
                                                                            return false;
                                                                        } else if (Static155.A_SERVER_PROT___60 == arg0.currentProt) {
                                                                            local277 = local11.ig2();
                                                                            if (local277 == 65535) {
                                                                                local277 = -1;
                                                                            }
                                                                            local100 = local11.g4_alt3();
                                                                            local526 = local11.g2_alt2();
                                                                            if (local526 == 65535) {
                                                                                local526 = -1;
                                                                            }
                                                                            local1409 = local11.g4_alt1();
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
                                                                            local277 = local11.g2();
                                                                            local100 = local11.g4();
                                                                            local526 = local11.g2();
                                                                            local1409 = local11.g1_alt3();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetRetex(local526, local1409, local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static157.A_SERVER_PROT___61) {
                                                                            Static626.anInt9476 = local11.g1b_alt1() << 3;
                                                                            Static270.anInt4354 = local11.g1b() << 3;
                                                                            Static87.anInt1810 = local11.g1_alt3();
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static18.A_SERVER_PROT___7 == arg0.currentProt) {
                                                                            Static605.method7912(Static18.A_ZONE_PROT___2);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static207.A_SERVER_PROT___127 == arg0.currentProt) {
                                                                            local277 = local11.g2s_alt3();
                                                                            local100 = local11.g4_alt2();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetModelAnim(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static707.A_SERVER_PROT___256 == arg0.currentProt) {
                                                                            local277 = local11.g2_alt3();
                                                                            local100 = local11.g2_alt2();
                                                                            Static574.method7573();
                                                                            Static471.method6408(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static404.A_SERVER_PROT___161 == arg0.currentProt) {
                                                                            Static106.anInt2153 = local11.g3s();
                                                                            Static389.aBoolean459 = local11.g1() == 1;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static617.A_SERVER_PROT___224) {
                                                                            local277 = local11.g2_alt3();
                                                                            local931 = local11.g1b_alt3();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.setVarc(local931, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static468.A_SERVER_PROT___212) {
                                                                            local1937 = local11.gjstr();
                                                                            local627 = Static130.method2280(WordPack.decode(local11));
                                                                            Static44.method1072(local627, local1937, 0, local1937, local1937, 6);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static353.A_SERVER_PROT___233) {
                                                                            Static400.lastClanSettingsTransmit = World.tick;
                                                                            local446 = local11.g1() == 1;
                                                                            @Pc(8376) Class20 local8376 = new Class20(local11);
                                                                            @Pc(8380) Class164 local8380;
                                                                            if (local446) {
                                                                                local8380 = Static128.aClass164_8;
                                                                            } else {
                                                                                local8380 = Static91.aClass164_9;
                                                                            }
                                                                            local8376.method587(local8380);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___45) {
                                                                            local277 = local11.g4();
                                                                            local627 = local11.gjstr();
                                                                            Static574.method7573();
                                                                            DelayedStateChange.interfaceSetText(local277, local627);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == ServerProt.A_SERVER_PROT___53) {
                                                                            local277 = local11.ig2();
                                                                            local100 = local11.g1_alt2();
                                                                            local2080 = (local100 & 0x1) == 1;
                                                                            Static698.method9123(local2080, local277);
                                                                            Static322.anIntArray889[Static451.invUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static464.A_SERVER_PROT___176) {
                                                                            Static605.method7912(Static210.A_ZONE_PROT___9);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static269.A_SERVER_PROT___111) {
                                                                            NPCList.updateNpcs();
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (Static670.A_SERVER_PROT___245 == arg0.currentProt) {
                                                                            local277 = local11.g1_alt3();
                                                                            local100 = local11.g1_alt2();
                                                                            local526 = local11.g1_alt2();
                                                                            local1409 = local11.g1_alt2();
                                                                            local1413 = local11.g2_alt3() << 2;
                                                                            Static574.method7573();
                                                                            Static319.method4595(local526, true, local1409, local1413, local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static451.aServerProt_171) {
                                                                            Static352.lastClanTransmit = World.tick;
                                                                            if (arg0.currentPacketSize == 0) {
                                                                                arg0.currentProt = null;
                                                                                Static706.anInt10633 = 0;
                                                                                Static87.aClass241Array1 = null;
                                                                                Static723.aString129 = null;
                                                                                Static158.aString28 = null;
                                                                                return true;
                                                                            }
                                                                            Static158.aString28 = local11.gjstr();
                                                                            local446 = local11.g1() == 1;
                                                                            if (local446) {
                                                                                local11.gjstr();
                                                                            }
                                                                            local4669 = local11.g8();
                                                                            Static723.aString129 = Base37.decode(local4669);
                                                                            Static673.aByte140 = local11.g1b();
                                                                            local1409 = local11.g1();
                                                                            if (local1409 == 255) {
                                                                                arg0.currentProt = null;
                                                                                return true;
                                                                            }
                                                                            Static706.anInt10633 = local1409;
                                                                            @Pc(8611) Class241[] local8611 = new Class241[100];
                                                                            for (local2098 = 0; local2098 < Static706.anInt10633; local2098++) {
                                                                                local8611[local2098] = new Class241();
                                                                                local8611[local2098].aString67 = local11.gjstr();
                                                                                local446 = local11.g1() == 1;
                                                                                if (local446) {
                                                                                    local8611[local2098].aString66 = local11.gjstr();
                                                                                } else {
                                                                                    local8611[local2098].aString66 = local8611[local2098].aString67;
                                                                                }
                                                                                local8611[local2098].aString68 = NameTools.format(local8611[local2098].aString66);
                                                                                local8611[local2098].anInt6148 = local11.g2();
                                                                                local8611[local2098].aByte99 = local11.g1b();
                                                                                local8611[local2098].aString65 = local11.gjstr();
                                                                                if (local8611[local2098].aString66.equals(PlayerEntity.self.accountName)) {
                                                                                    Static682.aByte142 = local8611[local2098].aByte99;
                                                                                }
                                                                            }
                                                                            local1449 = Static706.anInt10633;
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
                                                                            Static87.aClass241Array1 = local8611;
                                                                            return true;
                                                                        } else if (Static722.A_SERVER_PROT___260 == arg0.currentProt) {
                                                                            Static605.method7912(ZoneProt.MAP_PROJANIM);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static215.A_SERVER_PROT___86) {
                                                                            local277 = local11.g1();
                                                                            local100 = local11.g1_alt1();
                                                                            if (local277 == 255) {
                                                                                local100 = -1;
                                                                                local277 = -1;
                                                                            }
                                                                            DelayedStateChange.setMapFlag(local100, local277);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static211.A_SERVER_PROT___143) {
                                                                            Static605.method7912(Static704.A_ZONE_PROT___17);
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static390.A_SERVER_PROT___158) {
                                                                            local277 = local11.g2();
                                                                            local627 = local11.gjstr();
                                                                            if (Static279.anObjectArray35 == null) {
                                                                                Static279.anObjectArray35 = new Object[VarClanSettingTypeList.instance.num];
                                                                            }
                                                                            Static279.anObjectArray35[local277] = local627;
                                                                            Static265.anIntArray328[Static710.varclanUpdateCount++ & 0x1F] = local277;
                                                                            arg0.currentProt = null;
                                                                            return true;
                                                                        } else if (arg0.currentProt == Static616.A_SERVER_PROT___223) {
                                                                            local446 = local11.g1() == 1;
                                                                            local627 = local11.gjstr();
                                                                            local629 = local627;
                                                                            if (local446) {
                                                                                local629 = local11.gjstr();
                                                                            }
                                                                            local639 = local11.g8();
                                                                            local644 = local11.g2();
                                                                            local649 = local11.g3();
                                                                            local653 = local11.g1();
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
                                                                            if (!local4857 && Static659.anInt9817 == 0) {
                                                                                Static511.aLongArray17[Static97.anInt2001] = local8945;
                                                                                Static97.anInt2001 = (Static97.anInt2001 + 1) % 100;
                                                                                @Pc(9032) String local9032 = Static130.method2280(WordPack.decode(local11));
                                                                                if (local653 == 2 || local653 == 3) {
                                                                                    Static662.method8625("<img=1>" + local629, "<img=1>" + local627, -1, local9032, Base37.decodeName(local639), 0, local627, 9);
                                                                                } else if (local653 == 1) {
                                                                                    Static662.method8625("<img=0>" + local629, "<img=0>" + local627, -1, local9032, Base37.decodeName(local639), 0, local627, 9);
                                                                                } else {
                                                                                    Static662.method8625(local629, local627, -1, local9032, Base37.decodeName(local639), 0, local627, 9);
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
        local22.buffer.p1(InterfaceManager.getWindowMode());
        local22.buffer.p2(GameShell.canvasWid);
        local22.buffer.p2(GameShell.canvasHei);
        local22.buffer.p1(ClientOptions.instance.antialiasingQuality.getValue());
        ConnectionManager.GAME.send(local22);
    }
}
