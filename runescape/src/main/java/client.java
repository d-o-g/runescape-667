import com.jagex.Client;
import com.jagex.SignLink;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.game.PathFinder;
import com.jagex.game.camera.CameraMode;
import com.jagex.game.camera.Shake;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.constants.ModeWhat;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.io.BufferedFile;
import com.jagex.core.io.BufferedSocket;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.Base64;
import com.jagex.core.stringtools.general.Url;
import com.jagex.core.util.JagException;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.bastype.BASTypeList;
import com.jagex.game.runetek6.config.cursortype.CursorTypeList;
import com.jagex.game.runetek6.config.flotype.FloorOverlayTypeList;
import com.jagex.game.runetek6.config.flutype.FloorUnderlayTypeList;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import com.jagex.game.runetek6.config.hitmarktype.HitmarkTypeList;
import com.jagex.game.runetek6.config.idktype.IDKTypeList;
import com.jagex.game.runetek6.config.lighttype.LightTypeList;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.meltype.MapElementTypeList;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.npctype.NPCTypeList;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import com.jagex.game.runetek6.config.questtype.QuestTypeList;
import com.jagex.game.runetek6.config.seqtype.SeqTypeList;
import com.jagex.game.runetek6.config.skyboxspheretype.SkyBoxSphereTypeList;
import com.jagex.game.runetek6.config.skyboxtype.SkyBoxTypeList;
import com.jagex.game.runetek6.config.spotanimationtype.SpotAnimationTypeList;
import com.jagex.game.runetek6.config.structtype.StructTypeList;
import com.jagex.game.runetek6.config.vartype.TimedVarDomain;
import com.jagex.game.runetek6.config.vartype.bit.VarBitTypeListClient;
import com.jagex.game.runetek6.config.vartype.clan.VarClanSettingTypeList;
import com.jagex.game.runetek6.config.vartype.clan.VarClanTypeList;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerTypeListClient;
import com.jagex.graphics.Exception_Sub1;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import com.jagex.js5.CachedResourceWorker;
import com.jagex.js5.FileSystem_Client;
import com.jagex.js5.Js5Archive;
import com.jagex.js5.Js5ResponseCode;
import com.jagex.js5.Js5State;
import com.jagex.js5.Js5WorkerThread;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.keyboard.KeyLog;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.GregorianCalendar;
import java.util.Vector;

@OriginalClass("client!client")
public final class client extends GameShell {

    @OriginalMember(owner = "client!jga", name = "k", descriptor = "Lclient!client;")
    public static client aClient1;

    @OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
    public static void main(@OriginalArg(0) String[] arg0) {
        try {
            if (arg0.length != 6) {
                Client.error("Argument count");
            }
            Login.worldInfo = new ConnectionInfo();
            Login.worldInfo.id = Integer.parseInt(arg0[0]);
            Login.lobbyInfo = new ConnectionInfo();
            Login.lobbyInfo.id = Integer.parseInt(arg0[1]);
            Client.modeWhere = ModeWhere.LOCAL;
            if (arg0[3].equals("live")) {
                Client.modeWhat = ModeWhat.LIVE;
            } else if (arg0[3].equals("rc")) {
                Client.modeWhat = ModeWhat.RC;
            } else if (arg0[3].equals("wip")) {
                Client.modeWhat = ModeWhat.WIP;
            } else {
                Client.error("modewhat");
            }
            Client.language = Static541.method7198(arg0[4]);
            if (Client.language == -1) {
                if (arg0[4].equals("english")) {
                    Client.language = 0;
                } else if (arg0[4].equals("german")) {
                    Client.language = 1;
                } else {
                    Client.error("language");
                }
            }
            Client.objectTag = false;
            Client.js = false;
            if (arg0[5].equals("game0")) {
                Client.modeGame = ModeGame.RUNESCAPE;
            } else if (arg0[5].equals("game1")) {
                Client.modeGame = ModeGame.STELLAR_DAWN;
            } else if (arg0[5].equals("game2")) {
                Client.modeGame = ModeGame.GAME3;
            } else if (arg0[5].equals("game3")) {
                Client.modeGame = ModeGame.GAME4;
            } else {
                Client.error("game");
            }
            Client.affid = 0;
            Client.worldFlags = 0;
            Client.fromBilling = false;
            Client.isMember = true;
            Client.aBoolean200 = true;
            Client.force64mb = false;
            Client.addtionalInfo = null;
            Client.colourId = Client.modeGame.id;
            Client.settings = "";
            Client.ssKey = null;
            Client.country = 0;
            Client.userFlow = 0L;
            @Pc(241) client local241 = new client();
            aClient1 = local241;
            local241.method1635(Client.modeWhat.getId() + 32, Client.modeGame.domainName);
            frame.setLocation(40, 40);
        } catch (@Pc(265) Exception local265) {
            JagException.sendTrace(local265, null);
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(ZIII)Lclient!sb;")
    public static js5 createJs5(@OriginalArg(0) boolean discardpacked, @OriginalArg(1) int archiveId, @OriginalArg(2) int discardunpacked) {
        @Pc(5) FileSystem_Client fileSystem = null;
        if (Client.cacheDat != null) {
            fileSystem = new FileSystem_Client(archiveId, Client.cacheDat, Client.cacheIndexFiles[archiveId], 1000000);
        }
        Client.js5ResourceProviders[archiveId] = Static228.js5MasterIndex.getProvider(fileSystem, archiveId, Client.metaCache);
        Client.js5ResourceProviders[archiveId].requestMissing();
        return new js5(Client.js5ResourceProviders[archiveId], discardpacked, discardunpacked);
    }

    @OriginalMember(owner = "client!th", name = "b", descriptor = "(I)V")
    public static void cacheClean() {
        FloorOverlayTypeList.instance.cacheClean(5);
        FloorUnderlayTypeList.instance.cacheClean(5);
        IDKTypeList.instance.cacheClean(5);
        LocTypeList.instance.cacheClean(5);
        NPCTypeList.instance.cacheClean(5);
        ObjTypeList.instance.cacheClean(5);
        SeqTypeList.instance.cacheClean(5);
        SpotAnimationTypeList.instance.cacheClean(5);
        VarBitTypeListClient.instance.cacheClean(5);
        VarPlayerTypeListClient.instance.cacheClean(5);
        VarClanSettingTypeList.instance.cacheClean(5);
        VarClanTypeList.instance.cacheClean(5);
        BASTypeList.instance.cacheClean(5);
        MapElementTypeList.instance.cacheClean(5);
        MSITypeList.instance.cacheClean(5);
        ParamTypeList.instance.cacheClean(5);
        QuestTypeList.instance.cacheClean(5);
        SkyBoxTypeList.instance.cacheClean(5);
        SkyBoxSphereTypeList.instance.cacheClean(5);
        LightTypeList.instance.cacheClean(5);
        CursorTypeList.instance.cacheClean(5);
        StructTypeList.instance.cacheClean(5);
        HitmarkTypeList.instance.cacheClean(5);
        PlayerModel.cacheClean(5);
        Component.cacheClean(50);
        FontTypeList.cacheClean(50);
        PlayerEntity.cacheClean(5);
        ShadowList.cacheClean(5);
        Sprites.hitbarCache.clean(5);
        Sprites.timerbarCache.clean(5);
        Sprites.mobilisingArmiesCache.clean(5);
        MiniMenu.questCache.clean(5);
        ScriptRunner.A_WEIGHTED_CACHE___156.clean(5);
    }

    @OriginalMember(owner = "client!bda", name = "a", descriptor = "(IB)V")
    public static void method977(@OriginalArg(0) int id) {
        SoundManager.method2000();

        @Pc(16) int clientCode = VarPlayerTypeListClient.instance.list(id).clientCode;
        if (clientCode == 0) {
            return;
        }

        @Pc(25) int value = TimedVarDomain.instance.varValues[id];
        if (clientCode == 5) {
            Client.mouseButtons = value;
        }
        if (clientCode == 6) {
            Client.disableChatEffects = value;
        }
    }

    @OriginalMember(owner = "client!wh", name = "i", descriptor = "(I)V")
    public static void method9254() {
        if (Static249.anInt4008 > 1) {
            Static249.anInt4008--;
            Static321.lastMiscTransmit = World.tick;
        }
        if (ConnectionManager.GAME.errored) {
            ConnectionManager.GAME.errored = false;
            ConnectionManager.disconnect();
            return;
        }
        if (!MiniMenu.open) {
            MiniMenu.reset();
        }
        for (@Pc(34) int local34 = 0; local34 < 100 && Static236.readPacket(ConnectionManager.GAME); local34++) {
        }
        if (MainLogicManager.step != 11) {
            return;
        }
        @Pc(71) ClientMessage local71;
        @Pc(80) int local80;
        while (Static232.method3400()) {
            local71 = ClientMessage.create(ClientProt.A_CLIENT_PROT___110, ConnectionManager.GAME.cipher);
            local71.bitPacket.p1(0);
            local80 = local71.bitPacket.pos;
            Static437.method5915(local71.bitPacket);
            local71.bitPacket.psize1(local71.bitPacket.pos - local80);
            ConnectionManager.GAME.send(local71);
        }
        if (Static211.aClass2_Sub12_3 == null) {
            if (Static675.aLong307 <= SystemTimer.safetime()) {
                Static211.aClass2_Sub12_3 = Static151.aClass226_20.method5245(Client.gameConnection.address);
            }
        } else if (Static211.aClass2_Sub12_3.anInt1631 != -1) {
            local71 = ClientMessage.create(Static50.A_CLIENT_PROT___90, ConnectionManager.GAME.cipher);
            local71.bitPacket.p2(Static211.aClass2_Sub12_3.anInt1631);
            ConnectionManager.GAME.send(local71);
            Static211.aClass2_Sub12_3 = null;
            Static675.aLong307 = SystemTimer.safetime() + 30000L;
        }
        @Pc(166) MouseLog local166 = (MouseLog) Static226.mouseLogs.first();
        @Pc(181) int local181;
        @Pc(208) int local208;
        @Pc(226) int local226;
        @Pc(282) int local282;
        @Pc(288) int local288;
        @Pc(300) int local300;
        @Pc(179) ClientMessage local179;
        if (local166 != null || Static56.aLong38 < SystemTimer.safetime() - 2000L) {
            local179 = null;
            local181 = 0;
            for (@Pc(186) MouseLog local186 = (MouseLog) Static677.A_DEQUE___76.first(); local186 != null && (local179 == null || local179.bitPacket.pos - local181 < 240); local186 = (MouseLog) Static677.A_DEQUE___76.next()) {
                local186.unlink();
                local208 = local186.getY();
                if (local208 < -1) {
                    local208 = -1;
                } else if (local208 > 65534) {
                    local208 = 65534;
                }
                local226 = local186.getX();
                if (local226 < -1) {
                    local226 = -1;
                } else if (local226 > 65534) {
                    local226 = 65534;
                }
                if (Static172.anInt2890 != local226 || local208 != Static634.anInt9516) {
                    if (local179 == null) {
                        local179 = ClientMessage.create(Static603.A_CLIENT_PROT___109, ConnectionManager.GAME.cipher);
                        local179.bitPacket.p1(0);
                        local181 = local179.bitPacket.pos;
                    }
                    local282 = local226 - Static172.anInt2890;
                    Static172.anInt2890 = local226;
                    local288 = local208 - Static634.anInt9516;
                    Static634.anInt9516 = local208;
                    local300 = (int) ((local186.getTime() - Static56.aLong38) / 20L);
                    if (local300 < 8 && local282 >= -32 && local282 <= 31 && local288 >= -32 && local288 <= 31) {
                        local282 += 32;
                        local288 += 32;
                        local179.bitPacket.p2((local300 << 12) + (local282 << 6) + local288);
                    } else if (local300 < 32 && local282 >= -128 && local282 <= 127 && local288 >= -128 && local288 <= 127) {
                        local179.bitPacket.p1(local300 + 128);
                        local282 += 128;
                        local288 += 128;
                        local179.bitPacket.p2(local288 + (local282 << 8));
                    } else if (local300 >= 32) {
                        local179.bitPacket.p2(local300 + 57344);
                        if (local226 == 1 || local208 == -1) {
                            local179.bitPacket.p4(Integer.MIN_VALUE);
                        } else {
                            local179.bitPacket.p4(local226 | local208 << 16);
                        }
                    } else {
                        local179.bitPacket.p1(local300 + 192);
                        if (local226 == 1 || local208 == -1) {
                            local179.bitPacket.p4(Integer.MIN_VALUE);
                        } else {
                            local179.bitPacket.p4(local208 << 16 | local226);
                        }
                    }
                    Static56.aLong38 = local186.getTime();
                }
            }
            if (local179 != null) {
                local179.bitPacket.psize1(local179.bitPacket.pos - local181);
                ConnectionManager.GAME.send(local179);
            }
        }
        @Pc(541) int local541;
        if (local166 != null) {
            @Pc(527) long local527 = (local166.getTime() - Static180.aLong108) / 50L;
            if (local527 > 32767L) {
                local527 = 32767L;
            }
            Static180.aLong108 = local166.getTime();
            local541 = local166.getY();
            if (local541 < 0) {
                local541 = 0;
            } else if (local541 > 65535) {
                local541 = 65535;
            }
            local208 = local166.getX();
            if (local208 < 0) {
                local208 = 0;
            } else if (local208 > 65535) {
                local208 = 65535;
            }
            @Pc(581) byte local581 = 0;
            if (local166.getType() == 2) {
                local581 = 1;
            }
            local282 = (int) local527;
            @Pc(603) ClientMessage local603 = ClientMessage.create(Static111.A_CLIENT_PROT___21, ConnectionManager.GAME.cipher);
            local603.bitPacket.p2_alt3(local581 << 15 | local282);
            local603.bitPacket.p4_alt2(local208 | local541 << 16);
            ConnectionManager.GAME.send(local603);
        }
        @Pc(660) long local660;
        if (Static216.anInt3530 > 0) {
            local179 = ClientMessage.create(Static187.A_CLIENT_PROT___36, ConnectionManager.GAME.cipher);
            local179.bitPacket.p1(Static216.anInt3530 * 3);
            for (local181 = 0; local181 < Static216.anInt3530; local181++) {
                @Pc(652) KeyLog local652 = Static591.AN_KEYBOARD_EVENT_ARRAY_2[local181];
                local660 = (local652.getTime() - Static351.aLong173) / 50L;
                if (local660 > 65535L) {
                    local660 = 65535L;
                }
                Static351.aLong173 = local652.getTime();
                local179.bitPacket.p1(local652.getKeyCode());
                local179.bitPacket.p2((int) local660);
            }
            ConnectionManager.GAME.send(local179);
        }
        if (Static232.anInt3764 > 0) {
            Static232.anInt3764--;
        }
        if (Static273.aBoolean339 && Static232.anInt3764 <= 0) {
            Static273.aBoolean339 = false;
            Static232.anInt3764 = 20;
            local179 = ClientMessage.create(ClientProt.A_CLIENT_PROT___47, ConnectionManager.GAME.cipher);
            local179.bitPacket.p2((int) Static479.aFloat123 >> 3);
            local179.bitPacket.p2((int) Camera.playerCameraYaw >> 3);
            ConnectionManager.GAME.send(local179);
        }
        if (focus != Static50.aBoolean565) {
            Static50.aBoolean565 = focus;
            local179 = ClientMessage.create(Static621.A_CLIENT_PROT___113, ConnectionManager.GAME.cipher);
            local179.bitPacket.p1(focus ? 1 : 0);
            ConnectionManager.GAME.send(local179);
        }
        if (!Static503.sentPreferences) {
            local179 = ClientMessage.create(Static600.A_CLIENT_PROT___108, ConnectionManager.GAME.cipher);
            local179.bitPacket.p1(0);
            local181 = local179.bitPacket.pos;
            @Pc(810) Packet local810 = ClientOptions.instance.encode();
            local179.bitPacket.pdata(local810.pos, local810.data, 0);
            local179.bitPacket.psize1(local179.bitPacket.pos - local181);
            ConnectionManager.GAME.send(local179);
            Static503.sentPreferences = true;
        }
        if (Static334.activeTiles != null) {
            if (Camera.mode == CameraMode.MODE_FIXED) {
                Camera.moveToTick();
            } else if (Camera.mode == CameraMode.MODE_SPLINE) {
                Camera.splineTick();
            }
        }
        if (Static494.aBoolean563) {
            Static494.aBoolean563 = false;
        } else {
            Static288.aFloat83 /= 2.0F;
        }
        if (Static15.aBoolean17) {
            Static15.aBoolean17 = false;
        } else {
            Static552.aFloat207 /= 2.0F;
        }
        Static630.method8358();
        if (MainLogicManager.step != 11) {
            return;
        }
        Static159.method2575();
        Static271.method3930();
        SoundManager.method918();
        ConnectionManager.GAME.anInt3646++;
        if (ConnectionManager.GAME.anInt3646 > 750) {
            ConnectionManager.disconnect();
            return;
        }
        if (CutsceneManager.state == 0) {
            Static82.method1593();
            Static13.method158();
        } else {
            if (CutsceneManager.state == 1 && Static360.method5230(CutsceneManager.cutsceneId)) {
                Static266.method6774();
                CutsceneManager.state = 2;
            }
            if (CutsceneManager.state == 2 && MainLogicManager.step != 12) {
                CutsceneVarDomain.cache.clear();
                Static440.anInt6680 = 0;
                CutsceneManager.clock = TimeUtils.clock;
                CutsceneManager.state = 3;
                Static457.method6231();
            }
            if (CutsceneManager.state == 3) {
                local80 = TimeUtils.clock - CutsceneManager.clock;
                if (Static401.aCutsceneActionArray1.length > Static440.anInt6680) {
                    do {
                        @Pc(982) CutsceneAction local982 = Static401.aCutsceneActionArray1[Static440.anInt6680];
                        if (local982.startTime > local80) {
                            break;
                        }
                        local982.execute();
                    } while (CutsceneManager.state == 3 && ++Static440.anInt6680 < Static401.aCutsceneActionArray1.length);
                }
                if (CutsceneManager.state == 3) {
                    for (local181 = 0; local181 < CutsceneManager.actors.length; local181++) {
                        @Pc(1027) Actor local1027 = CutsceneManager.actors[local181];
                        if (local1027.initialised) {
                            @Pc(1034) PathingEntity local1034 = local1027.entity();
                            Static489.tick(true, local1034);
                        }
                    }
                }
            }
        }
        Static90.method1733();
        if (!Static288.aBoolean356) {
            Static598.method7827();
            Static288.aBoolean356 = true;
        }
        for (local80 = TimedVarDomain.instance.removeNext(true); local80 != -1; local80 = TimedVarDomain.instance.removeNext(false)) {
            method977(local80);
            Static142.anIntArray225[Static635.varpUpdateCount++ & 0x1F] = local80;
        }
        for (@Pc(1099) DelayedStateChange change = DelayedStateChange.removeFirst(); change != null; change = DelayedStateChange.removeFirst()) {
            local541 = change.getType();
            local660 = change.getValue();
            if (local541 == 1) {
                Static511.varcs[(int) local660] = change.primaryData;
                Static624.varcSaveRecommended |= Static118.permVarcs[(int) local660];
                Static278.anIntArray350[Static52.varcUpdateCount++ & 0x1F] = (int) local660;
            } else if (local541 == 2) {
                Static37.aStringArray4[(int) local660] = change.stringData;
                Static268.anIntArray332[Static455.varcstrUpdateCount++ & 0x1F] = (int) local660;
            } else {
                @Pc(1143) Component local1143;
                if (local541 == 3) {
                    local1143 = InterfaceList.list((int) local660);
                    if (!change.stringData.equals(local1143.text)) {
                        local1143.text = change.stringData;
                        InterfaceManager.redraw(local1143);
                    }
                } else {
                    @Pc(1739) int local1739;
                    if (local541 == 4) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = change.primaryData;
                        local300 = change.secondaryData;
                        local1739 = change.tertiaryData;
                        if (local288 != local1143.objType || local300 != local1143.obj || local1739 != local1143.objData) {
                            local1143.objData = local1739;
                            local1143.objType = local288;
                            local1143.obj = local300;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 5) {
                        local1143 = InterfaceList.list((int) local660);
                        if (local1143.modelAnimation != change.primaryData) {
                            if (change.primaryData == -1) {
                                local1143.animator = null;
                            } else {
                                if (local1143.animator == null) {
                                    local1143.animator = new ComponentAnimator();
                                }
                                local1143.animator.update(true, change.primaryData);
                            }
                            local1143.modelAnimation = change.primaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 6) {
                        local282 = change.primaryData;
                        local288 = local282 >> 10 & 0x1F;
                        local300 = local282 >> 5 & 0x1F;
                        local1739 = local282 & 0x1F;
                        @Pc(1751) int local1751 = (local300 << 11) + (local288 << 19) + (local1739 << 3);
                        @Pc(1756) Component local1756 = InterfaceList.list((int) local660);
                        if (local1756.colour != local1751) {
                            local1756.colour = local1751;
                            InterfaceManager.redraw(local1756);
                        }
                    } else if (local541 == 7) {
                        local1143 = InterfaceList.list((int) local660);
                        @Pc(1701) boolean local1701 = change.primaryData == 1;
                        if (local1701 != local1143.hidden) {
                            local1143.hidden = local1701;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 8) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.modelAngleX || change.secondaryData != local1143.modelAngleY || local1143.modelZoom != change.tertiaryData) {
                            local1143.modelAngleX = change.primaryData;
                            local1143.modelAngleY = change.secondaryData;
                            local1143.modelZoom = change.tertiaryData;
                            if (local1143.invObject != -1) {
                                if (local1143.anInt3800 > 0) {
                                    local1143.modelZoom = local1143.modelZoom * 32 / local1143.anInt3800;
                                } else if (local1143.baseWidth > 0) {
                                    local1143.modelZoom = local1143.modelZoom * 32 / local1143.baseWidth;
                                }
                            }
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 9) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.invObject || change.secondaryData != local1143.invCount) {
                            local1143.invCount = change.secondaryData;
                            local1143.invObject = change.primaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 10) {
                        local1143 = InterfaceList.list((int) local660);
                        if (change.primaryData != local1143.anInt3736 || local1143.anInt3804 != change.secondaryData || change.tertiaryData != local1143.modelAngleZ) {
                            local1143.anInt3736 = change.primaryData;
                            local1143.anInt3804 = change.secondaryData;
                            local1143.modelAngleZ = change.tertiaryData;
                            InterfaceManager.redraw(local1143);
                        }
                    } else if (local541 == 11) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.postTypeVertical = 0;
                        local1143.positionY = local1143.basePosY = change.secondaryData;
                        local1143.positionX = local1143.basePosX = change.primaryData;
                        local1143.posTypeHorizontal = 0;
                        InterfaceManager.redraw(local1143);
                    } else if (local541 == 12) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = change.primaryData;
                        if (local1143 != null && local1143.type == 0) {
                            if (local288 > local1143.scrollHeight - local1143.height) {
                                local288 = local1143.scrollHeight - local1143.height;
                            }
                            if (local288 < 0) {
                                local288 = 0;
                            }
                            if (local1143.scrollY != local288) {
                                local1143.scrollY = local288;
                                InterfaceManager.redraw(local1143);
                            }
                        }
                    } else if (local541 == 14) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.graphic = change.primaryData;
                    } else if (local541 == 15) {
                        Minimap.flagY = change.secondaryData;
                        Minimap.flagSet = true;
                        Minimap.flagX = change.primaryData;
                    } else if (local541 == 16) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.fontGraphic = change.primaryData;
                    } else if (local541 == 20) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.fontMonospaced = change.primaryData == 1;
                    } else if (local541 == 21) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.clickMask = change.primaryData == 1;
                    } else if (local541 == 17) {
                        local1143 = InterfaceList.list((int) local660);
                        local1143.video = change.primaryData;
                    } else if (local541 == 18) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = (int) (local660 >> 32);
                        local1143.setRecol((short) change.secondaryData, local288, (short) change.primaryData);
                    } else if (local541 == 19) {
                        local1143 = InterfaceList.list((int) local660);
                        local288 = (int) (local660 >> 32);
                        local1143.setRetex((short) change.primaryData, local288, (short) change.secondaryData);
                    }
                }
            }
        }
        Static35.currentTick++;
        if (Static616.crossType != 0) {
            Static481.crossDuration += 20;
            if (Static481.crossDuration >= 400) {
                Static616.crossType = 0;
            }
        }
        if (Static67.aComponent_10 != null) {
            Static499.anInt7501++;
            if (Static499.anInt7501 >= 15) {
                InterfaceManager.redraw(Static67.aComponent_10);
                Static67.aComponent_10 = null;
            }
        }
        WorldMap.component = null;
        InterfaceManager.aBoolean428 = false;
        Static702.aBoolean797 = false;
        InterfaceManager.dragTarget = null;
        WorldMap.setOptions(-1, -1, null);
        if (!InterfaceManager.targetMode) {
            InterfaceManager.targetEndCursor = -1;
        }
        Static443.method5981();
        World.tick++;
        if (WorldMap.clicked) {
            @Pc(1980) ClientMessage local1980 = ClientMessage.create(Static133.A_CLIENT_PROT___26, ConnectionManager.GAME.cipher);
            local1980.bitPacket.p4_alt3(WorldMap.clickedY | WorldMap.clickedLevel << 28 | WorldMap.clickedX << 14);
            ConnectionManager.GAME.send(local1980);
            WorldMap.clicked = false;
        }
        while (true) {
            @Pc(2006) HookRequest local2006;
            @Pc(2026) Component local2026;
            @Pc(2011) Component local2011;
            do {
                local2006 = (HookRequest) Static618.A_DEQUE___68.removeFirst();
                if (local2006 == null) {
                    while (true) {
                        do {
                            local2006 = (HookRequest) Static59.A_DEQUE___33.removeFirst();
                            if (local2006 == null) {
                                while (true) {
                                    do {
                                        local2006 = (HookRequest) Static521.A_DEQUE___44.removeFirst();
                                        if (local2006 == null) {
                                            if (WorldMap.component == null) {
                                                Static460.anInt6964 = 0;
                                            }
                                            if (InterfaceManager.dragSource != null) {
                                                Static603.method7899();
                                            }
                                            if (Static608.staffModLevel > 0 && KeyboardMonitor.instance.isPressed(82) && KeyboardMonitor.instance.isPressed(81) && Static611.mouseWheelRotation != 0) {
                                                local541 = PlayerEntity.self.level - Static611.mouseWheelRotation;
                                                if (local541 < 0) {
                                                    local541 = 0;
                                                } else if (local541 > 3) {
                                                    local541 = 3;
                                                }
                                                Static624.teleport(local541, PlayerEntity.self.pathZ[0] + WorldMap.areaBaseZ, WorldMap.areaBaseX - -PlayerEntity.self.pathX[0]);
                                            }
                                            Static320.method4598();
                                            for (local541 = 0; local541 < 5; local541++) {
                                                @Pc(2246) int local2246 = Shake.time[local541]++;
                                            }
                                            if (Static624.varcSaveRecommended && Static98.lastVarcSave < SystemTimer.safetime() - 60000L) {
                                                Static266.saveVarcs();
                                            }
                                            for (@Pc(2281) Class8_Sub4_Sub1 local2281 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local2281 != null; local2281 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                if (SystemTimer.safetime() / 1000L - 5L > (long) local2281.anInt6433) {
                                                    if (local2281.aShort74 > 0) {
                                                        ChatHistory.add(local2281.aString72 + LocalisedText.FRIENDLOGIN.localise(Client.language), "", 0, "", "", 5);
                                                    }
                                                    if (local2281.aShort74 == 0) {
                                                        ChatHistory.add(local2281.aString72 + LocalisedText.FRIENDLOGOUT.localise(Client.language), "", 0, "", "", 5);
                                                    }
                                                    local2281.unlink();
                                                }
                                            }
                                            if (14590 != 14590) {
                                                Camera.moveToZ = -107;
                                            }
                                            Static392.anInt6143++;
                                            if (Static392.anInt6143 > 500) {
                                                Static392.anInt6143 = 0;
                                                local226 = (int) (Math.random() * 8.0D);
                                                if ((local226 & 0x2) == 2) {
                                                    Static145.anInt2561 += Static374.anInt5906;
                                                }
                                                if ((local226 & 0x1) == 1) {
                                                    Static508.anInt7627 += Static555.anInt8305;
                                                }
                                                if ((local226 & 0x4) == 4) {
                                                    Static288.anInt4621 += Static709.anInt10669;
                                                }
                                            }
                                            if (Static508.anInt7627 < -50) {
                                                Static555.anInt8305 = 2;
                                            }
                                            if (Static508.anInt7627 > 50) {
                                                Static555.anInt8305 = -2;
                                            }
                                            if (Static145.anInt2561 < -55) {
                                                Static374.anInt5906 = 2;
                                            }
                                            if (Static288.anInt4621 < -40) {
                                                Static709.anInt10669 = 1;
                                            }
                                            if (Static145.anInt2561 > 55) {
                                                Static374.anInt5906 = -2;
                                            }
                                            Static439.anInt6675++;
                                            if (Static288.anInt4621 > 40) {
                                                Static709.anInt10669 = -1;
                                            }
                                            if (Static439.anInt6675 > 500) {
                                                Static439.anInt6675 = 0;
                                                local226 = (int) (Math.random() * 8.0D);
                                                if ((local226 & 0x1) == 1) {
                                                    Camera.yawOffset += Static653.anInt9718;
                                                }
                                                if ((local226 & 0x2) == 2) {
                                                    Camera.scaleOffset += Static171.anInt2887;
                                                }
                                            }
                                            if (Camera.yawOffset < -60) {
                                                Static653.anInt9718 = 2;
                                            }
                                            if (Camera.yawOffset > 60) {
                                                Static653.anInt9718 = -2;
                                            }
                                            if (Camera.scaleOffset < -20) {
                                                Static171.anInt2887 = 1;
                                            }
                                            ConnectionManager.GAME.idleWriteTicks++;
                                            if (Camera.scaleOffset > 10) {
                                                Static171.anInt2887 = -1;
                                            }
                                            if (ConnectionManager.GAME.idleWriteTicks > 50) {
                                                @Pc(2571) ClientMessage local2571 = ClientMessage.create(ClientProt.NO_TIMEOUT, ConnectionManager.GAME.cipher);
                                                ConnectionManager.GAME.send(local2571);
                                            }
                                            if (Static252.aBoolean316) {
                                                Static143.method3571();
                                                Static252.aBoolean316 = false;
                                            }
                                            try {
                                                ConnectionManager.GAME.flush();
                                                return;
                                            } catch (@Pc(2588) IOException local2588) {
                                                ConnectionManager.disconnect();
                                                return;
                                            }
                                        }
                                        local2011 = local2006.source;
                                        if (local2011.id < 0) {
                                            break;
                                        }
                                        local2026 = InterfaceList.list(local2011.layer);
                                    } while (local2026 == null || local2026.staticComponents == null || local2026.staticComponents.length <= local2011.id || local2011 != local2026.staticComponents[local2011.id]);
                                    ScriptRunner.executeHookInner(local2006);
                                }
                            }
                            local2011 = local2006.source;
                            if (local2011.id < 0) {
                                break;
                            }
                            local2026 = InterfaceList.list(local2011.layer);
                        } while (local2026 == null || local2026.staticComponents == null || local2011.id >= local2026.staticComponents.length || local2026.staticComponents[local2011.id] != local2011);
                        ScriptRunner.executeHookInner(local2006);
                    }
                }
                local2011 = local2006.source;
                if (local2011.id < 0) {
                    break;
                }
                local2026 = InterfaceList.list(local2011.layer);
            } while (local2026 == null || local2026.staticComponents == null || local2026.staticComponents.length <= local2011.id || local2026.staticComponents[local2011.id] != local2011);
            ScriptRunner.executeHookInner(local2006);
        }
    }

    @OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
    @Override
    public synchronized void addcanvas() {
        if (GameShell.loaderApplet != null && GameShell.canvas == null && !SignLink.instance.microsoftjava) {
            try {
                @Pc(25) Class local25 = GameShell.loaderApplet.getClass();
                @Pc(31) Field local31 = local25.getDeclaredField("canvas");
                GameShell.canvas = (Canvas) local31.get(GameShell.loaderApplet);
                local31.set(GameShell.loaderApplet, null);
                if (GameShell.canvas != null) {
                    return;
                }
            } catch (@Pc(45) Exception local45) {
            }
        }
        super.addcanvas();
    }

    @OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
    @Override
    protected void mainquit() {
        if (Static624.varcSaveRecommended) {
            Static266.saveVarcs();
        }

        Static419.method5757();

        if (Toolkit.active != null) {
            Toolkit.active.free();
        }

        if (GameShell.fsframe != null) {
            Static655.method8562(SignLink.instance, GameShell.fsframe);
            GameShell.fsframe = null;
        }

        ConnectionManager.GAME.close();
        ConnectionManager.LOBBY.close();
        Static173.method2690();
        Client.js5WorkerThread.close();
        Static66.aCachedResourceWorker_1.close();

        if (Static151.aClass226_20 != null) {
            Static151.aClass226_20.method5243();
            Static151.aClass226_20 = null;
        }

        try {
            Client.cacheDat.close();
            for (@Pc(66) int i = 0; i < Js5Archive.COUNT; i++) {
                Client.cacheIndexFiles[i].close();
            }
            Client.metaFile.close();
            Client.uidDat.close();
            Static314.method4567();
        } catch (@Pc(91) Exception local91) {
        }
    }

    @OriginalMember(owner = "client!client", name = "q", descriptor = "(I)V")
    public void js5Tick() {
        if (Client.js5Errors < Client.js5WorkerThread.errors) {
            Client.gameConnection.rotateMethods();

            Client.netWorkerDelay = ((Client.js5WorkerThread.errors * 50) - 50) * 5;
            if (Client.netWorkerDelay > 3000) {
                Client.netWorkerDelay = 3000;
            }

            if (Client.js5WorkerThread.errors >= 2 && Client.js5WorkerThread.response == Js5ResponseCode.CONNECT_OUTOFDATE) {
                this.error("js5connect_outofdate");
                MainLogicManager.step = 16;
                return;
            }

            if (Client.js5WorkerThread.errors >= 4 && Client.js5WorkerThread.response == Js5ResponseCode.DISCONNECTED) {
                this.error("js5crc");
                MainLogicManager.step = 16;
                return;
            }

            if (Client.js5WorkerThread.errors >= 4 && MainLogicManager.isLoading(MainLogicManager.step)) {
                if (Client.js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL1 || Client.js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL2) {
                    this.error("js5connect_full");
                } else if (Client.js5WorkerThread.response <= 0) {
                    this.error("js5io");
                } else if (Client.netProxyError == null) {
                    this.error("js5connect");
                } else {
                    this.error("js5proxy_" + Client.netProxyError.trim());
                }
                MainLogicManager.step = 16;
                return;
            }
        }

        Client.js5Errors = Client.js5WorkerThread.errors;

        if (Client.netWorkerDelay > 0) {
            Client.netWorkerDelay--;
            return;
        }

        try {
            if (Client.js5State == Js5State.INIT) {
                Client.js5Socket = Client.gameConnection.openSocket(SignLink.instance);
                Client.js5State++;
            }

            if (Client.js5State == Js5State.WAITING_CONNECTION_OPENED) {
                if (Client.js5Socket.status == 2) {
                    if (Client.js5Socket.result != null) {
                        Client.netProxyError = (String) Client.js5Socket.result;
                    }

                    this.updateJs5Response(1000);
                    return;
                }

                if (Client.js5Socket.status == 1) {
                    Client.js5State++;
                }
            }

            if (Client.js5State == Js5State.SEND_HEADER) {
                Client.js5BufferedSocket = new BufferedSocket((Socket) Client.js5Socket.result, SignLink.instance, 25000);
                @Pc(251) Packet packet = new Packet(5);
                packet.p1(LoginProt.INIT_JS5REMOTE_CONNECTION.opcode);
                packet.p4(667);
                Client.js5BufferedSocket.write(5, packet.data);
                Client.js5State++;
                Client.js5HandshakeTime = SystemTimer.safetime();
            }

            if (Client.js5State == Js5State.WAITING_FIRST_RESPONSE) {
                if (MainLogicManager.isLoading(MainLogicManager.step) || Client.js5BufferedSocket.available() > 0) {
                    @Pc(296) int response = Client.js5BufferedSocket.read();
                    if (response != 0) {
                        this.updateJs5Response(response);
                        return;
                    }

                    Client.js5State++;
                } else if (SystemTimer.safetime() - Client.js5HandshakeTime > 30000L) {
                    this.updateJs5Response(1001);
                    return;
                }
            }

            if (Client.js5State == Js5State.WAITING_LOADING_REQUIREMENTS) {
                @Pc(356) boolean loggedOut = MainLogicManager.isLoading(MainLogicManager.step) || Static41.method1027(MainLogicManager.step) || MainLogicManager.isAtLobbyScreen(MainLogicManager.step);
                @Pc(359) LoadingRequirement[] requirements = LoadingRequirement.values();
                @Pc(367) Packet packet = new Packet(requirements.length * 4);
                Client.js5BufferedSocket.read(packet.data.length, 0, packet.data);
                for (@Pc(378) int i = 0; i < requirements.length; i++) {
                    requirements[i].setSize(packet.g4());
                }
                Client.js5WorkerThread.setSocket(!loggedOut, Client.js5BufferedSocket);
                Client.js5State = Js5State.INIT;
                Client.js5BufferedSocket = null;
                Client.js5Socket = null;
            }
        } catch (@Pc(417) IOException ignored) {
            this.updateJs5Response(1002);
        }
    }

    @OriginalMember(owner = "client!client", name = "p", descriptor = "(I)V")
    public void method1658() {
        @Pc(46) int local46;
        if (MainLogicManager.step == 7 && !Static242.method3500() || MainLogicManager.step == 9 && Static169.anInt2855 == 42) {
            if (Static249.anInt4008 > 1) {
                Static249.anInt4008--;
                Static321.lastMiscTransmit = World.tick;
            }
            if (!MiniMenu.open) {
                MiniMenu.reset();
            }
            for (local46 = 0; local46 < 100 && Static236.readPacket(ConnectionManager.LOBBY); local46++) {
            }
        }
        Static35.currentTick++;
        InterfaceManager.setOptions(-1, -1, null);
        WorldMap.setOptions(-1, -1, null);
        Static443.method5981();
        World.tick++;
        for (local46 = 0; local46 < NPCList.newNpcCount; local46++) {
            @Pc(97) NPCEntity local97 = NPCList.localNpcs[local46].npc;
            if (local97 != null) {
                @Pc(103) byte local103 = local97.type.movementCapabilities;
                if ((local103 & 0x1) != 0) {
                    @Pc(114) int local114 = local97.getSize();
                    @Pc(142) int local142;
                    if ((local103 & 0x2) != 0 && local97.pathPointer == 0 && Math.random() * 1000.0D < 10.0D) {
                        local142 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        @Pc(150) int local150 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        if (local142 != 0 || local150 != 0) {
                            @Pc(166) int local166 = local142 + local97.pathX[0];
                            if (local166 < 0) {
                                local166 = 0;
                            } else if (local166 > Static720.mapWidth - local114 - 1) {
                                local166 = Static720.mapWidth - local114 - 1;
                            }
                            @Pc(203) int local203 = local150 + local97.pathZ[0];
                            if (local203 < 0) {
                                local203 = 0;
                            } else if (local203 > Static501.mapLength - local114 - 1) {
                                local203 = Static501.mapLength - local114 - 1;
                            }
                            @Pc(258) int local258 = PathFinder.findPath(Static577.collisionMaps[local97.level], Static480.anIntArray583, Static70.anIntArray147, local97.pathX[0], local97.pathZ[0], local114, local166, local203, local114, local114, -1, 0, 0, true);
                            if (local258 > 0) {
                                if (local258 > 9) {
                                    local258 = 9;
                                }
                                for (@Pc(274) int local274 = 0; local274 < local258; local274++) {
                                    local97.pathX[local274] = Static70.anIntArray147[local258 - local274 - 1];
                                    local97.pathZ[local274] = Static480.anIntArray583[local258 - local274 - 1];
                                    local97.pathSpeed[local274] = 1;
                                }
                                local97.pathPointer = local258;
                            }
                        }
                    }
                    Static256.movementTick(local97, true);
                    local142 = Static112.turnTick(local97);
                    Static145.wornTargetTick(local97);
                    Static651.basTick(Static521.anInt7756, local142, Static524.anInt8042, local97);
                    Static702.updateActionAnimator(local97, Static521.anInt7756);
                    Static50.animationTick(local97);
                }
            }
        }
        if ((MainLogicManager.step == 3 || MainLogicManager.step == 9 || MainLogicManager.step == 7) && (!Static242.method3500() || MainLogicManager.step == 9 && Static169.anInt2855 == 42) && Static6.anInt95 == 0) {
            if (Camera.mode == CameraMode.MODE_FIXED) {
                Camera.moveToTick();
            } else {
                Camera.splineTick();
            }

            if (Camera.x >> 9 < 14 || Camera.x >> 9 >= Static720.mapWidth - 14 || Camera.z >> 9 < 14 || Camera.z >> 9 >= Static501.mapLength - 14) {
                Static54.method1179();
            }
        }
        while (true) {
            @Pc(453) HookRequest local453;
            @Pc(458) Component local458;
            @Pc(470) Component local470;
            do {
                local453 = (HookRequest) Static618.A_DEQUE___68.removeFirst();
                if (local453 == null) {
                    while (true) {
                        do {
                            local453 = (HookRequest) Static59.A_DEQUE___33.removeFirst();
                            if (local453 == null) {
                                while (true) {
                                    do {
                                        local453 = (HookRequest) Static521.A_DEQUE___44.removeFirst();
                                        if (local453 == null) {
                                            if (InterfaceManager.dragSource != null) {
                                                Static603.method7899();
                                            }
                                            if (TimeUtils.clock % 1500 == 0) {
                                                Static314.method4562();
                                            }
                                            if (MainLogicManager.step == 7 && !Static242.method3500() || MainLogicManager.step == 9 && Static169.anInt2855 == 42) {
                                                Static320.method4598();
                                            }
                                            Static587.method7704();
                                            if (Static624.varcSaveRecommended && SystemTimer.safetime() - 60000L > Static98.lastVarcSave) {
                                                Static266.saveVarcs();
                                            }
                                            for (@Pc(672) Class8_Sub4_Sub1 local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local672 != null; local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                if ((long) local672.anInt6433 < SystemTimer.safetime() / 1000L - 5L) {
                                                    if (local672.aShort74 > 0) {
                                                        ChatHistory.add(local672.aString72 + LocalisedText.FRIENDLOGIN.localise(Client.language), "", 0, "", "", 5);
                                                    }
                                                    if (local672.aShort74 == 0) {
                                                        ChatHistory.add(local672.aString72 + LocalisedText.FRIENDLOGOUT.localise(Client.language), "", 0, "", "", 5);
                                                    }
                                                    local672.unlink();
                                                }
                                            }
                                            if (MainLogicManager.step == 7 && !Static242.method3500() || MainLogicManager.step == 9 && Static169.anInt2855 == 42) {
                                                if (MainLogicManager.step != 9 && ConnectionManager.LOBBY.connection == null) {
                                                    Login.logout(false);
                                                    return;
                                                }
                                                if (ConnectionManager.LOBBY != null) {
                                                    ConnectionManager.LOBBY.idleWriteTicks++;
                                                    if (ConnectionManager.LOBBY.idleWriteTicks > 50) {
                                                        @Pc(823) ClientMessage local823 = ClientMessage.create(ClientProt.NO_TIMEOUT, ConnectionManager.LOBBY.cipher);
                                                        ConnectionManager.LOBBY.send(local823);
                                                    }
                                                    try {
                                                        ConnectionManager.LOBBY.flush();
                                                        return;
                                                    } catch (@Pc(832) IOException local832) {
                                                        if (MainLogicManager.step != 9) {
                                                            Login.logout(false);
                                                            return;
                                                        }
                                                        ConnectionManager.LOBBY.close();
                                                        return;
                                                    }
                                                }
                                            }
                                            return;
                                        }
                                        local458 = local453.source;
                                        if (local458.id < 0) {
                                            break;
                                        }
                                        local470 = InterfaceList.list(local458.layer);
                                    } while (local470 == null || local470.staticComponents == null || local470.staticComponents.length <= local458.id || local470.staticComponents[local458.id] != local458);
                                    ScriptRunner.executeHookInner(local453);
                                }
                            }
                            local458 = local453.source;
                            if (local458.id < 0) {
                                break;
                            }
                            local470 = InterfaceList.list(local458.layer);
                        } while (local470 == null || local470.staticComponents == null || local470.staticComponents.length <= local458.id || local458 != local470.staticComponents[local458.id]);
                        ScriptRunner.executeHookInner(local453);
                    }
                }
                local458 = local453.source;
                if (local458.id < 0) {
                    break;
                }
                local470 = InterfaceList.list(local458.layer);
            } while (local470 == null || local470.staticComponents == null || local470.staticComponents.length <= local458.id || local458 != local470.staticComponents[local458.id]);
            ScriptRunner.executeHookInner(local453);
        }
    }

    @OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
    public void tickJs5() {
        @Pc(7) boolean workerTick = Client.js5WorkerThread.tick();

        if (!workerTick) {
            this.js5Tick();
        }
    }

    @OriginalMember(owner = "client!client", name = "e", descriptor = "(B)V")
    @Override
    protected void method1637() {
    }

    @OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
    public void mainredraw() {
        if (MainLogicManager.step == 16) {
            return;
        }

        @Pc(20) long local20 = (Static271.method3929() / 1000000L) - Static206.aLong114;
        Static206.aLong114 = Static271.method3929() / 1000000L;

        @Pc(28) boolean local28 = Static576.method7611();
        if (local28 && Static501.aBoolean575 && Static719.aClass56_5 != null) {
            Static719.aClass56_5.method3592();
        }

        if (Static475.method6445(MainLogicManager.step)) {
            if (Static297.aLong153 != 0L && SystemTimer.safetime() > Static297.aLong153) {
                InterfaceManager.changeWindowMode(InterfaceManager.getWindowMode(), Static560.anInt8429, false, Static433.anInt6258);
            } else if (!Toolkit.active.method8001() && GameShell.canvasReplaceRecommended) {
                Static574.method7572();
            }
        }

        if (GameShell.fsframe == null) {
            @Pc(98) Container topContainer;
            if (frame != null) {
                topContainer = frame;
            } else if (GameShell.loaderApplet == null) {
                topContainer = GameShell.instance;
            } else {
                topContainer = GameShell.loaderApplet;
            }

            @Pc(110) int width = topContainer.getSize().width;
            @Pc(114) int height = topContainer.getSize().height;
            if (topContainer == frame) {
                @Pc(120) Insets insets = frame.getInsets();
                height -= insets.bottom + insets.top;
                width -= insets.right + insets.left;
            }

            if (Client.frameWid != width || height != Client.frameHei || Static284.aBoolean355) {
                if (Toolkit.active == null || Toolkit.active.method7983()) {
                    Static712.method9329((byte) 11);
                } else {
                    Client.frameWid = width;
                    Client.frameHei = height;
                }

                Static297.aLong153 = SystemTimer.safetime() + 500L;
                Static284.aBoolean355 = false;
            }
        }

        if (GameShell.fsframe != null && !GameShell.focus && Static475.method6445(MainLogicManager.step)) {
            InterfaceManager.changeWindowMode(ClientOptions.instance.screenSizeDefault.getValue(), -1, false, -1);
        }

        @Pc(209) boolean local209 = false;
        if (fullredraw) {
            local209 = true;
            fullredraw = false;
        }

        if (local209) {
            Static288.repaintMargins();
        }

        if (Toolkit.active != null && Toolkit.active.method8001() || InterfaceManager.getWindowMode() != 1) {
            InterfaceManager.redrawAll();
        }

        if (MainLogicManager.isLoading(MainLogicManager.step)) {
            Static523.method3447(local209);
        } else if (MainLogicManager.isAtLoadingScreen(MainLogicManager.step)) {
            InterfaceManager.method680();
        } else if (MainLogicManager.method5393(MainLogicManager.step)) {
            InterfaceManager.method680();
        } else if (MainLogicManager.isBuildingMap(MainLogicManager.step)) {
            if (Static213.anInt3472 == 1) {
                if (Static593.anInt8763 > Static357.anInt6508) {
                    Static357.anInt6508 = Static593.anInt8763;
                }

                @Pc(110) int local110 = (Static357.anInt6508 - Static593.anInt8763) * 50 / Static357.anInt6508;
                Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(Client.language) + "<br>(" + local110 + "%)", true, Fonts.p12Metrics, Fonts.p12);
            } else if (Static213.anInt3472 == 2) {
                if (Static13.anInt150 > Static440.anInt6683) {
                    Static440.anInt6683 = Static13.anInt150;
                }

                @Pc(110) int local110 = (Static440.anInt6683 - Static13.anInt150) * 50 / Static440.anInt6683 + 50;
                Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(Client.language) + "<br>(" + local110 + "%)", true, Fonts.p12Metrics, Fonts.p12);
            } else {
                Static694.drawLoadingText(Toolkit.active, LocalisedText.LOADING.localise(Client.language), true, Fonts.p12Metrics, Fonts.p12);
            }
        } else if (MainLogicManager.step == 11) {
            InterfaceManager.method7930(local20);
        } else if (MainLogicManager.step == 14) {
            Static694.drawLoadingText(Toolkit.active, LocalisedText.CONLOST.localise(Client.language) + "<br>" + LocalisedText.ATTEMPTING_TO_REESTABLISH.localise(Client.language), false, Fonts.p12Metrics, Fonts.p12);
        } else if (MainLogicManager.step == 15) {
            Static694.drawLoadingText(Toolkit.active, LocalisedText.PLEASEWAIT.localise(Client.language), false, Fonts.p12Metrics, Fonts.p12);
        }

        if (InterfaceManager.rectDebug == 3) {
            for (@Pc(110) int local110 = 0; local110 < InterfaceManager.rectangleCount; local110++) {
                @Pc(478) Rectangle rectangle = InterfaceManager.rectangles[local110];

                if (InterfaceManager.currentlyDirtyRect[local110]) {
                    Toolkit.active.method7945(rectangle.y, 0xFFFF00FF, rectangle.width, rectangle.height, rectangle.x);
                } else if (InterfaceManager.flipDirtyRect[local110]) {
                    Toolkit.active.method7945(rectangle.y, 0xFFFF0000, rectangle.width, rectangle.height, rectangle.x);
                } else {
                    Toolkit.active.method7945(rectangle.y, 0xFF00FF00, rectangle.width, rectangle.height, rectangle.x);
                }
            }
        }

        if (debugconsole.isOpen()) {
            debugconsole.draw(Toolkit.active);
        }

        if (SignLink.instance.microsoftjava && Static475.method6445(MainLogicManager.step) && InterfaceManager.rectDebug == 0 && InterfaceManager.getWindowMode() == 1 && !local209) {
            @Pc(110) int rectangle = 0;

            for (@Pc(114) int i = 0; i < InterfaceManager.rectangleCount; i++) {
                if (InterfaceManager.flipDirtyRect[i]) {
                    InterfaceManager.flipDirtyRect[i] = false;
                    Static663.aRectangleArray2[rectangle++] = InterfaceManager.rectangles[i];
                }
            }

            try {
                if (InterfaceManager.aBoolean210) {
                    Static700.method9148(rectangle, Static663.aRectangleArray2);
                } else {
                    Toolkit.active.method8005(rectangle, Static663.aRectangleArray2);
                }
            } catch (@Pc(629) Exception_Sub1 ignored) {
                /* empty */
            }
        } else if (!MainLogicManager.isLoading(MainLogicManager.step)) {
            for (@Pc(110) int i = 0; i < InterfaceManager.rectangleCount; i++) {
                InterfaceManager.flipDirtyRect[i] = false;
            }

            try {
                if (InterfaceManager.aBoolean210) {
                    Static430.method5818();
                } else {
                    Toolkit.active.flip();
                }
            } catch (@Pc(666) Exception_Sub1 cause) {
                JagException.sendTrace(cause, cause.getMessage() + " (Recovered) " + this.getErrorTrace());
                Static32.setToolkit(ToolkitType.JAVA, false);
            }
        }

        VideoManager.unpause();

        @Pc(110) int cpuUsage = ClientOptions.instance.cpuUsage.value();
        if (cpuUsage == 0) {
            TimeUtils.sleep(15L);
        } else if (cpuUsage == 1) {
            TimeUtils.sleep(10L);
        } else if (cpuUsage == 2) {
            TimeUtils.sleep(5L);
        } else if (cpuUsage == 3) {
            TimeUtils.sleep(2L);
        }

        if (Client.cleanCaches) {
            cacheClean();
        }

        if (ClientOptions.instance.safeMode.getValue() == 1 && MainLogicManager.step == 3 && InterfaceManager.topLevelInterface != -1) {
            ClientOptions.instance.update(0, ClientOptions.instance.safeMode);
            ClientOptions.save();
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(ZI)V")
    public void updateJs5Response(@OriginalArg(1) int response) {
        Client.js5Socket = null;
        Client.js5WorkerThread.response = response;
        Client.js5BufferedSocket = null;
        Client.js5WorkerThread.errors++;
        Client.js5State = 0;
    }

    @OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
    @Override
    protected void mainloop() {
        if (ClientOptions.instance.toolkit.getValue() != ToolkitType.SSE) {
            this.gameTick();
            return;
        }

        try {
            this.gameTick();
        } catch (@Pc(21) ThreadDeath death) {
            throw death;
        } catch (@Pc(24) Throwable cause) {
            JagException.sendTrace(cause, cause.getMessage() + " (Recovered) " + this.getErrorTrace());
            Static171.graphicsError = true;
            Static32.setToolkit(ToolkitType.JAVA, false);
        }
    }

    @OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
    public void gameTick() {
        if (MainLogicManager.step == 16) {
            return;
        }
        TimeUtils.clock++;
        if (TimeUtils.clock % 1000 == 1) {
            @Pc(27) GregorianCalendar local27 = new GregorianCalendar();
            Static178.anInt2947 = local27.get(11) * 600 + local27.get(12) * 10 + local27.get(13) / 6;
            Static493.aRandom1.setSeed(Static178.anInt2947);
        }
        ConnectionManager.GAME.recordStats();
        ConnectionManager.LOBBY.recordStats();
        this.tickJs5();
        if (Static228.js5MasterIndex != null) {
            Static228.js5MasterIndex.process();
        }
        Static601.method7865();
        VideoManager.tick();
        KeyboardMonitor.instance.record();
        MouseMonitor.instance.record();
        if (Toolkit.active != null) {
            Toolkit.active.method7977((int) SystemTimer.safetime());
        }
        Static711.method9272();
        Static671.anInt10026 = 0;
        Static216.anInt3530 = 0;
        for (@Pc(94) KeyLog local94 = KeyboardMonitor.instance.removeFirstRecorded(); local94 != null; local94 = KeyboardMonitor.instance.removeFirstRecorded()) {
            @Pc(102) int local102 = local94.getType();
            if (local102 == 2 || local102 == 3) {
                @Pc(118) char local118 = local94.getKeyChar();
                if (Static647.method8468() && (local118 == '`' || local118 == '§' || local118 == '²')) {
                    if (debugconsole.isOpen()) {
                        Static129.method2279();
                    } else {
                        Static455.method6224();
                    }
                } else if (Static671.anInt10026 < 128) {
                    Static194.AN_KEYBOARD_EVENT_ARRAY_1[Static671.anInt10026] = local94;
                    Static671.anInt10026++;
                }
            } else if (local102 == 0 && Static216.anInt3530 < 75) {
                Static591.AN_KEYBOARD_EVENT_ARRAY_2[Static216.anInt3530] = local94;
                Static216.anInt3530++;
            }
        }
        Static611.mouseWheelRotation = 0;
        for (@Pc(214) MouseLog local214 = MouseMonitor.instance.removeFirstLog(); local214 != null; local214 = MouseMonitor.instance.removeFirstLog()) {
            @Pc(222) int local222 = local214.getType();
            if (local222 == -1) {
                Static677.A_DEQUE___76.addLast(local214);
            } else if (local222 == 6) {
                Static611.mouseWheelRotation += local214.getExtra();
            } else if (Static278.method4070(local222)) {
                Static226.mouseLogs.addLast(local214);
                if (Static226.mouseLogs.size() > 10) {
                    Static226.mouseLogs.removeFirst();
                }
            }
        }
        if (debugconsole.isOpen()) {
            Static668.method8703();
        }
        if (MainLogicManager.isLoading(MainLogicManager.step)) {
            Static709.method9252();
            Static199.doneslowupdate();
        } else if (MainLogicManager.isBuildingMap(MainLogicManager.step)) {
            Static489.method6548();
        }
        if (Static41.method1027(MainLogicManager.step) && !MainLogicManager.isBuildingMap(MainLogicManager.step)) {
            this.method1658();
            Static76.method1555();
            Static364.method5253();
        } else if (MainLogicManager.isAtLobbyScreen(MainLogicManager.step) && !MainLogicManager.isBuildingMap(MainLogicManager.step)) {
            this.method1658();
            Static364.method5253();
        } else if (MainLogicManager.step == 13) {
            Static364.method5253();
        } else if (MainLogicManager.isAtGameScreen(MainLogicManager.step) && !MainLogicManager.isBuildingMap(MainLogicManager.step)) {
            method9254();
        } else if (MainLogicManager.step == 14 || MainLogicManager.step == 15) {
            Static364.method5253();
            if (Static169.anInt2855 != -3 && Static169.anInt2855 != 2 && Static169.anInt2855 != 15) {
                if (MainLogicManager.step == 15) {
                    Static78.anInt1626 = Static169.anInt2855;
                    Static673.anInt10079 = Static356.anInt5780;
                    Static383.anInt6001 = Static329.anInt1749;
                    if (Static718.aBoolean823) {
                        Static430.method5817(Static459.aConnectionInfo_2.id, Static459.aConnectionInfo_2.address);
                        ConnectionManager.GAME.connection = null;
                        MainLogicManager.setStep(14);
                    } else {
                        Login.logout(InterfaceManager.lobbyOpened);
                    }
                } else {
                    Login.logout(false);
                }
            }
        }
        Static369.method3851(Toolkit.active);
        Static226.mouseLogs.removeFirst();
    }

    @OriginalMember(owner = "client!client", name = "h", descriptor = "(I)V")
    @Override
    protected void method1647() {
        if (Client.force64mb) {
            GameShell.maxmemory = 64;
        }
        @Pc(18) Frame local18 = new Frame("Jagex");
        local18.pack();
        local18.dispose();
        Static712.method9329((byte) 11);
        Static66.aCachedResourceWorker_1 = new CachedResourceWorker(SignLink.instance);
        Client.js5WorkerThread = new Js5WorkerThread();
        Static545.method7241(new int[]{20, 260}, new int[]{1000, 100});
        if (ModeWhere.LIVE != Client.modeWhere) {
            Static163.aByteArrayArray36 = new byte[50][];
        }
        ClientOptions.instance = Static720.method9398();
        if (Client.modeWhere == ModeWhere.LIVE) {
            Login.worldInfo.address = this.getCodeBase().getHost();
        } else if (ModeWhere.isPrivate(Client.modeWhere)) {
            Login.worldInfo.address = this.getCodeBase().getHost();
            Login.worldInfo.defaultPort = Login.worldInfo.id + 40000;
            Login.worldInfo.alternatePort = Login.worldInfo.id + 50000;
            Login.lobbyInfo.defaultPort = Login.lobbyInfo.id + 40000;
            Login.lobbyInfo.alternatePort = Login.lobbyInfo.id + 50000;
        } else if (ModeWhere.LOCAL == Client.modeWhere) {
            Login.worldInfo.address = "127.0.0.1";
            Login.worldInfo.defaultPort = Login.worldInfo.id + 40000;
            Login.lobbyInfo.address = "127.0.0.1";
            Login.worldInfo.alternatePort = Login.worldInfo.id + 50000;
            Login.lobbyInfo.defaultPort = Login.lobbyInfo.id + 40000;
            Login.lobbyInfo.alternatePort = Login.lobbyInfo.id + 50000;
        }
        Client.gameConnection = Login.worldInfo;
        Client.clientpalette = LocType.clientpalette = NPCType.clientpalette = ObjType.clientpalette = new short[256];
        if (Client.modeGame == ModeGame.RUNESCAPE) {
            Static273.aBoolean340 = false;
        }
        try {
            Static175.aClipboard1 = aClient1.getToolkit().getSystemClipboard();
        } catch (@Pc(183) Exception local183) {
        }
        KeyboardMonitor.instance = Static681.method8921(GameShell.canvas);
        MouseMonitor.instance = MouseMonitor.create(GameShell.canvas);
        try {
            if (SignLink.instance.cacheDat != null) {
                Client.cacheDat = new BufferedFile(SignLink.instance.cacheDat, 5200, 0);
                for (@Pc(205) int i = 0; i < 37; i++) {
                    Client.cacheIndexFiles[i] = new BufferedFile(SignLink.instance.cacheIndex[i], 6000, 0);
                }
                Client.metaFile = new BufferedFile(SignLink.instance.masterIndex, 6000, 0);
                Client.metaCache = new FileSystem_Client(Js5Archive.ARCHIVESET, Client.cacheDat, Client.metaFile, 500000);
                Client.uidDat = new BufferedFile(SignLink.instance.uidFile, 24, 0);
                SignLink.instance.masterIndex = null;
                SignLink.instance.cacheIndex = null;
                SignLink.instance.cacheDat = null;
                SignLink.instance.uidFile = null;
            }
        } catch (@Pc(275) IOException local275) {
            Client.metaFile = null;
            Client.metaCache = null;
            Client.uidDat = null;
            Client.cacheDat = null;
        }

        if (ModeWhere.LIVE != Client.modeWhere) {
            Client.displayFps = true;
        }

        Static484.aString85 = LocalisedText.LOADING.localise(Client.language);
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(I)Ljava/lang/String;")
    @Override
    public String getErrorTrace() {
        @Pc(5) String trace = null;
        try {
            trace = "[1)" + WorldMap.areaBaseX + "," + WorldMap.areaBaseZ + "," + Static720.mapWidth + "," + Static501.mapLength + "|";

            if (PlayerEntity.self != null) {
                trace = trace + "2)" + Camera.renderingLevel + "," + (PlayerEntity.self.pathX[0] + WorldMap.areaBaseX) + "," + (WorldMap.areaBaseZ + PlayerEntity.self.pathZ[0]) + "|";
            }

            trace = trace + "3)" + ClientOptions.instance.toolkit.getValue() + "|4)" + ClientOptions.instance.antialiasingMode.getValue() + "|5)" + InterfaceManager.getWindowMode() + "|6)" + GameShell.canvasWid + "," + GameShell.canvasHei + "|";
            trace = trace + "7)" + ClientOptions.instance.lightDetail.getValue() + "|";
            trace = trace + "8)" + ClientOptions.instance.hardShadows.getValue() + "|";
            trace = trace + "9)" + ClientOptions.instance.waterDetail.getValue() + "|";
            trace = trace + "10)" + ClientOptions.instance.textures.getValue() + "|";
            trace = trace + "11)" + ClientOptions.instance.bloom.getValue() + "|";
            trace = trace + "12)" + ClientOptions.instance.animateBackground.getValue() + "|";
            trace = trace + "13)" + GameShell.maxmemory + "|";
            trace = trace + "14)" + MainLogicManager.step;

            if (SystemInfo.instance != null) {
                trace = trace + "|15)" + SystemInfo.instance.totalMemory;
            }

            try {
                if (ClientOptions.instance.toolkit.getValue() == ToolkitType.SSE) {
                    @Pc(273) Class local273 = Class.forName("java.lang.ClassLoader");
                    @Pc(279) Field local279 = local273.getDeclaredField("nativeLibraries");
                    @Pc(284) Class local284 = Class.forName("java.lang.reflect.AccessibleObject");
                    @Pc(296) Method local296 = local284.getDeclaredMethod("setAccessible", Boolean.TYPE);
                    local296.invoke(local279, Boolean.TRUE);
                    @Pc(322) Vector local322 = (Vector) local279.get((Static84.aClass5 == null ? (Static84.aClass5 = Class.forName("client")) : Static84.aClass5).getClassLoader());
                    for (@Pc(324) int local324 = 0; local324 < local322.size(); local324++) {
                        try {
                            @Pc(329) Object local329 = local322.elementAt(local324);
                            @Pc(336) Field local336 = local329.getClass().getDeclaredField("name");
                            local296.invoke(local336, Boolean.TRUE);
                            try {
                                @Pc(351) String local351 = (String) local336.get(local329);
                                if (local351 != null && local351.indexOf("sw3d.dll") != -1) {
                                    @Pc(369) Field local369 = local329.getClass().getDeclaredField("handle");
                                    local296.invoke(local369, Boolean.TRUE);
                                    trace = trace + "|16)" + Long.toHexString(local369.getLong(local329));
                                    local296.invoke(local369, Boolean.FALSE);
                                }
                            } catch (@Pc(407) Throwable local407) {
                            }
                            local296.invoke(local336, Boolean.FALSE);
                        } catch (@Pc(419) Throwable local419) {
                        }
                    }
                }
            } catch (@Pc(431) Throwable local431) {
            }
            trace = trace + "]";
        } catch (@Pc(442) Throwable local442) {
        }
        return trace;
    }

    @OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
    @Override
    public void init() {
        if (!this.checkhost()) {
            return;
        }

        Login.worldInfo = new ConnectionInfo();
        Login.worldInfo.id = Integer.parseInt(this.getParameter("worldid"));

        Login.lobbyInfo = new ConnectionInfo();
        Login.lobbyInfo.id = Integer.parseInt(this.getParameter("lobbyid"));
        Login.lobbyInfo.address = this.getParameter("lobbyaddress");

        Client.modeWhere = ModeWhere.fromId(Integer.parseInt(this.getParameter("modewhere")));
        if (ModeWhere.LOCAL == Client.modeWhere) {
            Client.modeWhere = ModeWhere.WIP;
        } else if (!ModeWhere.isPrivate(Client.modeWhere) && ModeWhere.LIVE != Client.modeWhere) {
            Client.modeWhere = ModeWhere.LIVE;
        }

        Client.modeWhat = ModeWhat.fromId(Integer.parseInt(this.getParameter("modewhat")));
        if (ModeWhat.WIP != Client.modeWhat && Client.modeWhat != ModeWhat.RC && ModeWhat.LIVE != Client.modeWhat) {
            Client.modeWhat = ModeWhat.LIVE;
        }

        try {
            Client.language = Integer.parseInt(this.getParameter("lang"));
        } catch (@Pc(110) Exception local110) {
            Client.language = 0;
        }

        @Pc(118) String objectTagParam = this.getParameter("objecttag");
        if (objectTagParam != null && objectTagParam.equals("1")) {
            Client.objectTag = true;
        } else {
            Client.objectTag = false;
        }

        @Pc(142) String jsParam = this.getParameter("js");
        if (jsParam != null && jsParam.equals("1")) {
            Client.js = true;
        } else {
            Client.js = false;
        }

        @Pc(166) String advertParam = this.getParameter("advert");
        if (advertParam != null && advertParam.equals("1")) {
            Client.advert = true;
        } else {
            Client.advert = false;
        }

        @Pc(190) String gameParam = this.getParameter("game");
        if (gameParam != null) {
            if (gameParam.equals("0")) {
                Client.modeGame = ModeGame.RUNESCAPE;
            } else if (gameParam.equals("1")) {
                Client.modeGame = ModeGame.STELLAR_DAWN;
            } else if (gameParam.equals("2")) {
                Client.modeGame = ModeGame.GAME3;
            } else if (gameParam.equals("3")) {
                Client.modeGame = ModeGame.GAME4;
            }
        }

        try {
            Client.affid = Integer.parseInt(this.getParameter("affid"));
        } catch (@Pc(247) Exception ignored) {
            Client.affid = 0;
        }

        Client.quitUrl = this.getParameter("quiturl");

        Client.settings = this.getParameter("settings");
        if (Client.settings == null) {
            Client.settings = "";
        }

        Client.under13 = "1".equals(this.getParameter("under"));

        @Pc(281) String countryParam = this.getParameter("country");
        if (countryParam != null) {
            try {
                Client.country = Integer.parseInt(countryParam);
            } catch (@Pc(288) Exception ignored) {
                Client.country = 0;
            }
        }

        Client.colourId = Integer.parseInt(this.getParameter("colourid"));
        if (Client.colourId < 0 || Client.FILL_COLOURS.length <= Client.colourId) {
            Client.colourId = 0;
        }

        if (Integer.parseInt(this.getParameter("sitesettings_member")) == 1) {
            Client.isMember = true;
            Client.aBoolean200 = true;
        }

        @Pc(336) String fromBillingParam = this.getParameter("frombilling");
        if (fromBillingParam != null && fromBillingParam.equals("true")) {
            Client.fromBilling = true;
        }

        @Pc(356) String ssKeyParam = this.getParameter("sskey");
        if (ssKeyParam != null) {
            Client.ssKey = Base64.encode(Url.decode(ssKeyParam));

            if (Client.ssKey.length < 16) {
                Client.ssKey = null;
            }
        }

        @Pc(382) String force64mbParam = this.getParameter("force64mb");
        if (force64mbParam != null && force64mbParam.equals("true")) {
            Client.force64mb = true;
        }

        @Pc(402) String worldflagsParam = this.getParameter("worldflags");
        if (worldflagsParam != null) {
            try {
                Client.worldFlags = Integer.parseInt(worldflagsParam);
            } catch (@Pc(409) Exception ignored) {
                /* empty */
            }
        }

        @Pc(416) String userFlowParam = this.getParameter("userFlow");
        if (userFlowParam != null) {
            try {
                Client.userFlow = Long.parseLong(userFlowParam);
            } catch (@Pc(424) NumberFormatException ignored) {
                /* empty */
            }
        }

        Client.addtionalInfo = this.getParameter("additionalInfo");
        if (Client.addtionalInfo != null && Client.addtionalInfo.length() > 50) {
            Client.addtionalInfo = null;
        }

        if (ModeGame.RUNESCAPE == Client.modeGame) {
            Client.loadingScreenWidth = 765;
            Client.loadingScreenHeight = 503;
        } else if (Client.modeGame == ModeGame.STELLAR_DAWN) {
            Client.loadingScreenHeight = 480;
            Client.loadingScreenWidth = 640;
        }

        @Pc(473) String hcParam = this.getParameter("hc");
        if (hcParam != null && hcParam.equals("1")) {
            Client.hc = true;
        }

        aClient1 = this;
        this.startApplet(Client.BUILD, Client.loadingScreenWidth, Client.modeWhat.getId() + 32, Client.modeGame.domainName, Js5Archive.COUNT, Client.loadingScreenHeight);
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
    @Override
    protected void draw() {
        if (ClientOptions.instance.toolkit.getValue() != ToolkitType.SSE) {
            this.mainredraw();
            return;
        }

        try {
            this.mainredraw();
        } catch (@Pc(21) ThreadDeath death) {
            throw death;
        } catch (@Pc(24) Throwable cause) {
            JagException.sendTrace(cause, cause.getMessage() + " (Recovered) " + this.getErrorTrace());
            Static171.graphicsError = true;
            Static32.setToolkit(ToolkitType.JAVA, false);
        }
    }
}
