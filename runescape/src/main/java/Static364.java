import com.jagex.Client;
import com.jagex.Constants;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.SignLink;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.crypto.Isaac;
import com.jagex.core.io.BitPacket;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base37;
import com.jagex.core.util.JavaScript;
import com.jagex.core.util.SystemTimer;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementType;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.graphics.ToolkitType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public final class Static364 {

    @OriginalMember(owner = "client!lia", name = "r", descriptor = "Lclient!rt;")
    public static Class327 aClass327_4;

    @OriginalMember(owner = "client!lia", name = "p", descriptor = "D")
    public static double aDouble17;

    @OriginalMember(owner = "client!cja", name = "l", descriptor = "I")
    public static int anInt1634;

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(Z)Lclient!fu;")
    public static MapElementListEntry method5248() {
        if (WorldMap.elements == null || Static444.A_DEQUE_ITERATOR___1 == null) {
            return null;
        }
        for (@Pc(17) MapElementListEntry local17 = (MapElementListEntry) Static444.A_DEQUE_ITERATOR___1.next(); local17 != null; local17 = (MapElementListEntry) Static444.A_DEQUE_ITERATOR___1.next()) {
            @Pc(30) MapElementType local30 = WorldMap.mapElementTypeList.list(local17.id);
            if (local30 != null && local30.aBoolean217 && local30.variableTest(WorldMap.varDomain)) {
                return local17;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(IFFILclient!tk;[BFIBFIIIF)V")
    public static void method5251(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Class59 arg3, @OriginalArg(5) byte[] arg4, @OriginalArg(6) float arg5, @OriginalArg(9) float arg6, @OriginalArg(12) int arg7, @OriginalArg(13) float arg8) {
        @Pc(17) float[] local17 = new float[16384];
        @Pc(22) int local22;
        @Pc(48) int local48;
        for (@Pc(19) int local19 = 0; local19 < 8; local19++) {
            local22 = arg7;
            arg3.method1509(arg0 / (float) 128, arg8 * 127.0F, local17, 0, arg6 / (float) 16, arg2, arg1 / (float) 128);
            for (local48 = 0; local48 < 16384; local48++) {
                arg4[local22] = (byte) (int) ((float) arg4[local22] + local17[local48]);
                local22++;
            }
            arg1 *= 2.0F;
            arg0 *= 2.0F;
            arg6 *= 2.0F;
            arg8 *= arg5;
        }
        local22 = arg7;
        for (local48 = 0; local48 < 16384; local48++) {
            arg4[local22] = (byte) (arg4[local22] + 127);
            local22++;
        }
    }

    @OriginalMember(owner = "client!lia", name = "a", descriptor = "(B)V")
    public static void method5253() {
        if (Static135.anInt8223 == 0 || Static135.anInt8223 == 10) {
            return;
        }
        try {
            @Pc(25) short local25;
            if (Static76.anInt1601 == 0) {
                local25 = 250;
            } else {
                local25 = 2000;
            }
            if (Static299.anInt4825 != 2 || Static135.anInt8223 != 20 && Static169.anInt2855 != 42) {
                Static330.anInt5434++;
            }
            if (Static311.aBoolean384 && Static135.anInt8223 >= 6) {
                local25 = 6000;
            }
            if (local25 < Static330.anInt5434) {
                Static524.aServerConnection_3.close();
                if (Static76.anInt1601 >= 3) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(-5);
                    return;
                }
                if (Static299.anInt4825 == 2) {
                    Client.gameConnection.rotateMethods();
                } else {
                    Login.lobbyInfo.rotateMethods();
                }
                Static135.anInt8223 = 1;
                Static330.anInt5434 = 0;
                Static76.anInt1601++;
            }
            if (Static135.anInt8223 == 1) {
                if (Static299.anInt4825 == 2) {
                    Static524.aServerConnection_3.gameSocketRequest = Client.gameConnection.openSocket(SignLink.instance);
                } else {
                    Static524.aServerConnection_3.gameSocketRequest = Login.lobbyInfo.openSocket(SignLink.instance);
                }
                Static135.anInt8223 = 2;
            }
            @Pc(186) ClientMessage local186;
            @Pc(203) int local203;
            @Pc(250) int local250;
            if (Static135.anInt8223 == 2) {
                if (Static524.aServerConnection_3.gameSocketRequest.status == 2) {
                    throw new IOException();
                }
                if (Static524.aServerConnection_3.gameSocketRequest.status != 1) {
                    return;
                }
                Static524.aServerConnection_3.connection = Static99.method1975((Socket) Static524.aServerConnection_3.gameSocketRequest.result);
                Static524.aServerConnection_3.gameSocketRequest = null;
                Static524.aServerConnection_3.clear();
                local186 = Static273.method3962();
                if (Static311.aBoolean384) {
                    local186.bitPacket.p1(LoginProt.A_LOGIN_PROT___64.opcode);
                    local186.bitPacket.p2(0);
                    local203 = local186.bitPacket.pos;
                    local186.bitPacket.p4(667);
                    if (Static299.anInt4825 == 2) {
                        local186.bitPacket.p1(MainLogicManager.step == 14 ? 1 : 0);
                    }
                    @Pc(229) Packet local229 = Static570.method7552();
                    local229.p1(Static129.anInt2409);
                    local229.p2((int) (Math.random() * 9.9999999E7D));
                    local229.p1(Client.language);
                    local229.p4(Client.affid);
                    for (local250 = 0; local250 < 6; local250++) {
                        local229.p4((int) (Math.random() * 9.9999999E7D));
                    }
                    local229.p8(Static571.aLong269);
                    local229.p1(Client.modeGame.id);
                    local229.p1((int) (Math.random() * 9.9999999E7D));
                    local229.rsaenc(Static374.LOGIN_RSA_MODULUS, Static262.LOGIN_RSA_EXPONENT);
                    local186.bitPacket.pdata(local229.pos, local229.data, 0);
                    local186.bitPacket.psize2(local186.bitPacket.pos - local203);
                } else {
                    local186.bitPacket.p1(LoginProt.A_LOGIN_PROT___53.opcode);
                }
                Static524.aServerConnection_3.send(local186);
                Static524.aServerConnection_3.flush();
                Static135.anInt8223 = 3;
            }
            @Pc(360) int local360;
            if (Static135.anInt8223 == 3) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(1)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                local360 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                if (local360 != 0) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(local360);
                    Static524.aServerConnection_3.close();
                    Static564.method7465();
                    return;
                }
                if (Static311.aBoolean384) {
                    Static135.anInt8223 = 4;
                } else {
                    Static135.anInt8223 = 8;
                }
            }
            if (Static135.anInt8223 == 4) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(2)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 2, 0);
                Static524.aServerConnection_3.bitPacket.pos = 0;
                Static524.aServerConnection_3.bitPacket.pos = Static524.aServerConnection_3.bitPacket.g2();
                Static135.anInt8223 = 5;
            }
            if (Static135.anInt8223 == 5) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(Static524.aServerConnection_3.bitPacket.pos)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, Static524.aServerConnection_3.bitPacket.pos, 0);
                Static524.aServerConnection_3.bitPacket.tinydec(Static219.xteaKey);
                Static524.aServerConnection_3.bitPacket.pos = 0;
                @Pc(465) String local465 = Static524.aServerConnection_3.bitPacket.gjstr2();
                Static524.aServerConnection_3.bitPacket.pos = 0;
                @Pc(473) String local473 = "opensn";
                if (!Client.js || Static36.method980(SignLink.instance, local465, local473, 1).status == 2) {
                    Static259.method3693(local465, local473, SignLink.instance, ClientOptions.instance.toolkit.getValue() == ToolkitType.GL, true);
                }
                Static135.anInt8223 = 6;
            }
            if (Static135.anInt8223 == 6) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(1)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                if ((Static524.aServerConnection_3.bitPacket.data[0] & 0xFF) == 1) {
                    Static135.anInt8223 = 7;
                }
            }
            if (Static135.anInt8223 == 7) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(16)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 16, 0);
                Static524.aServerConnection_3.bitPacket.pos = 16;
                Static524.aServerConnection_3.bitPacket.tinydec(Static219.xteaKey);
                Static524.aServerConnection_3.bitPacket.pos = 0;
                Static449.aString75 = Static319.aString51 = Base37.decode(Static524.aServerConnection_3.bitPacket.g8());
                Static430.aLong209 = Static524.aServerConnection_3.bitPacket.g8();
                Static135.anInt8223 = 8;
            }
            @Pc(618) BitPacket local618;
            if (Static135.anInt8223 == 8) {
                Static524.aServerConnection_3.bitPacket.pos = 0;
                Static524.aServerConnection_3.clear();
                local186 = Static273.method3962();
                local618 = local186.bitPacket;
                @Pc(646) int local646;
                @Pc(672) Packet local672;
                @Pc(627) LoginProt local627;
                if (Static299.anInt4825 == 2) {
                    if (Static311.aBoolean384) {
                        local627 = LoginProt.A_LOGIN_PROT___65;
                    } else {
                        local627 = LoginProt.A_LOGIN_PROT___55;
                    }
                    local618.p1(local627.opcode);
                    local618.p2(0);
                    local250 = local618.pos;
                    local646 = local618.pos;
                    if (!Static311.aBoolean384) {
                        local618.p4(667);
                        local618.p1(MainLogicManager.step == 14 ? 1 : 0);
                        local646 = local618.pos;
                        local672 = Static659.method8608();
                        local618.pdata(local672.pos, local672.data, 0);
                        local646 = local618.pos;
                        local618.pjstr(Static449.aString75);
                    }
                    local618.p1(Static470.anInt7113);
                    local618.p1(InterfaceManager.getWindowMode());
                    local618.p2(GameShell.canvasWid);
                    local618.p2(GameShell.canvasHei);
                    local618.p1(ClientOptions.instance.antialiasingQuality.getValue());
                    Static176.method6690(local618);
                    local618.pjstr(Client.settings);
                    local618.p4(Client.affid);
                    local672 = ClientOptions.instance.encode();
                    local618.p1(local672.pos);
                    local618.pdata(local672.pos, local672.data, 0);
                    Static503.sentPreferences = true;
                    @Pc(748) Packet local748 = new Packet(SystemInfo.instance.size());
                    SystemInfo.instance.encode(local748);
                    local618.pdata(local748.data.length, local748.data, 0);
                    local618.p4(Static334.anInt5456);
                    local618.p8(Client.userFlow);
                    local618.p1(Client.addtionalInfo == null ? 0 : 1);
                    if (Client.addtionalInfo != null) {
                        local618.pjstr(Client.addtionalInfo);
                    }
                    local618.p1(Static183.method2796("jagtheora") ? 1 : 0);
                    local618.p1(Client.js ? 1 : 0);
                    local618.p1(Client.hc ? 1 : 0);
                    Static169.method2647(local618);
                    local618.tinyenc(Static219.xteaKey, local646, local618.pos);
                    local618.psize2(local618.pos - local250);
                } else {
                    if (Static311.aBoolean384) {
                        local627 = LoginProt.A_LOGIN_PROT___65;
                    } else {
                        local627 = LoginProt.A_LOGIN_PROT___57;
                    }
                    local618.p1(local627.opcode);
                    local618.p2(0);
                    local250 = local618.pos;
                    local646 = local618.pos;
                    if (!Static311.aBoolean384) {
                        local618.p4(667);
                        local672 = Static659.method8608();
                        local618.pdata(local672.pos, local672.data, 0);
                        local646 = local618.pos;
                        local618.pjstr(Static449.aString75);
                    }
                    local618.p1(Client.modeGame.id);
                    local618.p1(Client.language);
                    Static176.method6690(local618);
                    local618.pjstr(Client.settings);
                    local618.p4(Client.affid);
                    Static169.method2647(local618);
                    local618.tinyenc(Static219.xteaKey, local646, local618.pos);
                    local618.psize2(local618.pos - local250);
                }
                Static524.aServerConnection_3.send(local186);
                Static524.aServerConnection_3.flush();
                Static524.aServerConnection_3.cipher = new Isaac(Static219.xteaKey);
                for (@Pc(938) int local938 = 0; local938 < 4; local938++) {
                    Static219.xteaKey[local938] += 50;
                }
                Static524.aServerConnection_3.bitPacket.initIsaac(Static219.xteaKey);
                Static219.xteaKey = null;
                Static135.anInt8223 = 9;
            }
            if (Static135.anInt8223 == 9) {
                if (!Static524.aServerConnection_3.connection.hasAvailable(1)) {
                    return;
                }
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                local360 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                if (local360 == 21) {
                    Static135.anInt8223 = 12;
                } else if (local360 == 29 || local360 == 45) {
                    Static135.anInt8223 = 18;
                    anInt1634 = local360;
                } else if (local360 == 1) {
                    Static135.anInt8223 = 10;
                    Static342.method4464(local360);
                    return;
                } else if (local360 == 2) {
                    Static135.anInt8223 = 13;
                } else if (local360 == 15) {
                    Static135.anInt8223 = 19;
                    Static524.aServerConnection_3.currentPacketSize = -2;
                } else if (local360 == 23 && Static76.anInt1601 < 3) {
                    Static330.anInt5434 = 0;
                    Static135.anInt8223 = 1;
                    Static76.anInt1601++;
                    Static524.aServerConnection_3.connection.close();
                    Static524.aServerConnection_3.connection = null;
                    return;
                } else if (local360 == 42) {
                    Static135.anInt8223 = 20;
                    Static342.method4464(local360);
                    return;
                } else if (!Static561.aBoolean640 || Static311.aBoolean384 || Static129.anInt2409 == -1 || local360 != 35) {
                    Static135.anInt8223 = 0;
                    Static342.method4464(local360);
                    Static524.aServerConnection_3.connection.close();
                    Static524.aServerConnection_3.connection = null;
                    Static564.method7465();
                    return;
                } else {
                    Static311.aBoolean384 = true;
                    Static135.anInt8223 = 1;
                    Static330.anInt5434 = 0;
                    Static524.aServerConnection_3.connection.close();
                    Static524.aServerConnection_3.connection = null;
                    return;
                }
            }
            if (Static135.anInt8223 == 11) {
                Static524.aServerConnection_3.clear();
                local186 = Static273.method3962();
                local618 = local186.bitPacket;
                local618.setIsaac(Static524.aServerConnection_3.cipher);
                local618.startPacket(LoginProt.GAMELOGIN_CONTINUE.opcode);
                Static524.aServerConnection_3.send(local186);
                Static524.aServerConnection_3.flush();
                Static135.anInt8223 = 9;
            } else if (Static135.anInt8223 == 12) {
                if (Static524.aServerConnection_3.connection.hasAvailable(1)) {
                    Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                    local360 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                    Static135.anInt8223 = 0;
                    Static118.anInt2292 = local360 * 50;
                    Static342.method4464(21);
                    Static524.aServerConnection_3.connection.close();
                    Static524.aServerConnection_3.connection = null;
                    Static564.method7465();
                }
            } else if (Static135.anInt8223 == 20) {
                if (Static524.aServerConnection_3.connection.hasAvailable(2)) {
                    Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 2, 0);
                    Static660.anInt9837 = (Static524.aServerConnection_3.bitPacket.data[1] & 0xFF) + ((Static524.aServerConnection_3.bitPacket.data[0] & 0xFF) << 8);
                    Static135.anInt8223 = 9;
                }
            } else if (Static135.anInt8223 == 18) {
                if (anInt1634 == 29) {
                    if (!Static524.aServerConnection_3.connection.hasAvailable(1)) {
                        return;
                    }
                    Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                    Static329.anInt1749 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                } else if (anInt1634 == 45) {
                    if (!Static524.aServerConnection_3.connection.hasAvailable(3)) {
                        return;
                    }
                    Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 3, 0);
                    Static356.anInt5780 = (Static524.aServerConnection_3.bitPacket.data[2] & 0xFF) + ((Static524.aServerConnection_3.bitPacket.data[1] & 0xFF) << 8);
                    Static329.anInt1749 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                } else {
                    throw new IllegalStateException("Login step 18 not valid for pendingResponse=" + anInt1634);
                }
                Static135.anInt8223 = 0;
                Static342.method4464(anInt1634);
                Static524.aServerConnection_3.connection.close();
                Static524.aServerConnection_3.connection = null;
                Static564.method7465();
            } else if (Static135.anInt8223 != 13) {
                @Pc(1435) BitPacket local1435;
                if (Static135.anInt8223 == 14) {
                    local1435 = Static524.aServerConnection_3.bitPacket;
                    if (Static299.anInt4825 == 2) {
                        if (!Static524.aServerConnection_3.connection.hasAvailable(Static94.anInt1961)) {
                            return;
                        }
                        Static524.aServerConnection_3.connection.read(local1435.data, Static94.anInt1961, 0);
                        local1435.pos = 0;
                        Static608.staffModLevel = local1435.g1();
                        Static38.anInt928 = local1435.g1();
                        Static389.aBoolean459 = local1435.g1() == 1;
                        Static34.aBoolean62 = local1435.g1() == 1;
                        Static298.aBoolean369 = local1435.g1() == 1;
                        Static617.aBoolean724 = local1435.g1() == 1;
                        PlayerList.activePlayerSlot = local1435.g2();
                        Client.aBoolean200 = local1435.g1() == 1;
                        Static106.anInt2153 = local1435.g3s();
                        Static174.mapMembers = local1435.g1() == 1;
                        Static416.aString71 = local1435.gjstr();
                        LocTypeList.instance.setAllowMembers(Static174.mapMembers);
                        ObjTypeList.instance.setAllowMembers(Static174.mapMembers);
                        NPCTypeList.instance.setAllowMembers(Static174.mapMembers);
                    } else if (Static524.aServerConnection_3.connection.hasAvailable(Static94.anInt1961)) {
                        Static524.aServerConnection_3.connection.read(local1435.data, Static94.anInt1961, 0);
                        local1435.pos = 0;
                        Static608.staffModLevel = local1435.g1();
                        Static38.anInt928 = local1435.g1();
                        Static389.aBoolean459 = local1435.g1() == 1;
                        Static34.aBoolean62 = local1435.g1() == 1;
                        Static298.aBoolean369 = local1435.g1() == 1;
                        Static416.aLong207 = local1435.g8();
                        Static94.aLong70 = Static416.aLong207 - SystemTimer.safetime() - local1435.g5();
                        local203 = local1435.g1();
                        Client.aBoolean200 = (local203 & 0x1) != 0;
                        Static425.aBoolean482 = (local203 & 0x2) != 0;
                        Static435.anInt6594 = local1435.g4();
                        Static684.aBoolean775 = local1435.g1() == 1;
                        Static134.anInt10326 = local1435.g4();
                        Static677.anInt10234 = local1435.g2();
                        Static476.anInt7175 = local1435.g2();
                        Static323.anInt5118 = local1435.g2();
                        Static392.anInt6141 = local1435.g4();
                        Static439.aSignedResource_4 = SignLink.instance.lookupHostname(Static392.anInt6141);
                        Static335.anInt5462 = local1435.g1();
                        Static626.anInt9473 = local1435.g2();
                        Static636.anInt9527 = local1435.g2();
                        Static420.aBoolean479 = local1435.g1() == 1;
                        PlayerEntity.self.accountName = PlayerEntity.self.displayName = Constants.playerDisplayName = local1435.gjstr2();
                        Static639.anInt9571 = local1435.g1();
                        Static438.anInt6640 = local1435.g4();
                        Static587.aBoolean663 = local1435.g1() == 1;
                        Static668.aConnectionInfo_5 = new ConnectionInfo();
                        Static668.aConnectionInfo_5.id = local1435.g2();
                        if (Static668.aConnectionInfo_5.id == 65535) {
                            Static668.aConnectionInfo_5.id = -1;
                        }
                        Static668.aConnectionInfo_5.address = local1435.gjstr2();
                        if (ModeWhere.LIVE != Client.modeWhere) {
                            Static668.aConnectionInfo_5.defaultPort = Static668.aConnectionInfo_5.id + 40000;
                            Static668.aConnectionInfo_5.alternatePort = Static668.aConnectionInfo_5.id + 50000;
                        }
                        if (ModeWhere.LOCAL != Client.modeWhere && (Client.modeWhere != ModeWhere.WTQA || Static608.staffModLevel < 2) && Client.gameConnection.equalTo(Login.worldInfo)) {
                            Static152.method9273();
                        }
                    } else {
                        return;
                    }
                    if (Static389.aBoolean459 && !Static298.aBoolean369 || Client.aBoolean200) {
                        try {
                            JavaScript.call("zap", GameShell.loaderApplet);
                        } catch (@Pc(1850) Throwable local1850) {
                            if (Client.advert) {
                                try {
                                    GameShell.loaderApplet.getAppletContext().showDocument(new URL(GameShell.loaderApplet.getCodeBase(), "blank.ws"), "tbi");
                                } catch (@Pc(1868) Exception local1868) {
                                }
                            }
                        }
                    } else {
                        try {
                            JavaScript.call("unzap", GameShell.loaderApplet);
                        } catch (@Pc(1879) Throwable local1879) {
                        }
                    }
                    if (Client.modeWhere == ModeWhere.LIVE) {
                        try {
                            JavaScript.call("loggedin", GameShell.loaderApplet);
                        } catch (@Pc(1892) Throwable local1892) {
                        }
                    }
                    if (Static299.anInt4825 != 2) {
                        Static135.anInt8223 = 0;
                        Static342.method4464(2);
                        Static249.method3538();
                        MainLogicManager.setStep(7);
                        Static524.aServerConnection_3.currentProt = null;
                        return;
                    }
                    Static135.anInt8223 = 16;
                }
                if (Static135.anInt8223 == 16) {
                    if (!Static524.aServerConnection_3.connection.hasAvailable(3)) {
                        return;
                    }
                    Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 3, 0);
                    Static135.anInt8223 = 17;
                }
                if (Static135.anInt8223 == 17) {
                    local1435 = Static524.aServerConnection_3.bitPacket;
                    local1435.pos = 0;
                    if (local1435.largeOpcode()) {
                        if (!Static524.aServerConnection_3.connection.hasAvailable(1)) {
                            return;
                        }
                        Static524.aServerConnection_3.connection.read(local1435.data, 1, 3);
                    }
                    Static524.aServerConnection_3.currentProt = Static585.method7677()[local1435.readOpcode()];
                    Static524.aServerConnection_3.currentPacketSize = local1435.g2();
                    Static135.anInt8223 = 15;
                }
                if (Static135.anInt8223 == 15) {
                    if (Static524.aServerConnection_3.connection.hasAvailable(Static524.aServerConnection_3.currentPacketSize)) {
                        Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, Static524.aServerConnection_3.currentPacketSize, 0);
                        Static524.aServerConnection_3.bitPacket.pos = 0;
                        local360 = Static524.aServerConnection_3.currentPacketSize;
                        Static135.anInt8223 = 0;
                        Static342.method4464(2);
                        Static254.method3605();
                        PlayerList.getSnapShotPlayer(Static524.aServerConnection_3.bitPacket);
                        Static62.areaCenterX = -1;
                        if (Static524.aServerConnection_3.currentProt == Static291.A_SERVER_PROT___123) {
                            Static466.rebuildRegion();
                        } else {
                            Static434.method5855();
                        }
                        if (Static524.aServerConnection_3.bitPacket.pos != local360) {
                            throw new RuntimeException("lswp pos:" + Static524.aServerConnection_3.bitPacket.pos + " psize:" + local360);
                        }
                        Static524.aServerConnection_3.currentProt = null;
                    }
                } else if (Static135.anInt8223 == 19) {
                    if (Static524.aServerConnection_3.currentPacketSize == -2) {
                        if (!Static524.aServerConnection_3.connection.hasAvailable(2)) {
                            return;
                        }
                        Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 2, 0);
                        Static524.aServerConnection_3.bitPacket.pos = 0;
                        Static524.aServerConnection_3.currentPacketSize = Static524.aServerConnection_3.bitPacket.g2();
                    }
                    if (Static524.aServerConnection_3.connection.hasAvailable(Static524.aServerConnection_3.currentPacketSize)) {
                        Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, Static524.aServerConnection_3.currentPacketSize, 0);
                        Static524.aServerConnection_3.bitPacket.pos = 0;
                        Static135.anInt8223 = 0;
                        local360 = Static524.aServerConnection_3.currentPacketSize;
                        Static342.method4464(15);
                        Static94.method1841();
                        PlayerList.getSnapShotPlayer(Static524.aServerConnection_3.bitPacket);
                        if (local360 != Static524.aServerConnection_3.bitPacket.pos) {
                            throw new RuntimeException("lswpr pos:" + Static524.aServerConnection_3.bitPacket.pos + " psize:" + local360);
                        }
                        Static524.aServerConnection_3.currentProt = null;
                    }
                }
            } else if (Static524.aServerConnection_3.connection.hasAvailable(1)) {
                Static524.aServerConnection_3.connection.read(Static524.aServerConnection_3.bitPacket.data, 1, 0);
                Static94.anInt1961 = Static524.aServerConnection_3.bitPacket.data[0] & 0xFF;
                Static135.anInt8223 = 14;
            }
        } catch (@Pc(2184) IOException local2184) {
            Static524.aServerConnection_3.close();
            if (Static76.anInt1601 < 3) {
                if (Static299.anInt4825 == 2) {
                    Client.gameConnection.rotateMethods();
                } else {
                    Login.lobbyInfo.rotateMethods();
                }
                Static135.anInt8223 = 1;
                Static76.anInt1601++;
                Static330.anInt5434 = 0;
            } else {
                Static135.anInt8223 = 0;
                Static342.method4464(-4);
                Static564.method7465();
            }
        }
    }
}
