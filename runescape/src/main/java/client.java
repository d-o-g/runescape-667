import com.jagex.SignLink;
import com.jagex.SignedResource;
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
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.graphics.Exception_Sub1;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.CachedResourceWorker;
import com.jagex.js5.FileSystem_Client;
import com.jagex.js5.Js5Archive;
import com.jagex.js5.Js5ResourceProvider;
import com.jagex.js5.Js5ResponseCode;
import com.jagex.js5.Js5State;
import com.jagex.js5.Js5WorkerThread;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

import java.awt.Canvas;
import java.awt.Color;
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

    public static final int BUILD = 667;

    @OriginalMember(owner = "client!gha", name = "t", descriptor = "[Lclient!mj;")
    public static final BufferedFile[] cacheIndexFiles = new BufferedFile[37];

    @OriginalMember(owner = "client!ha", name = "l", descriptor = "[Lclient!pm;")
    public static final Js5ResourceProvider[] js5ResourceProviders = new Js5ResourceProvider[37];

    @OriginalMember(owner = "client!kla", name = "kb", descriptor = "[Ljava/awt/Color;")
    public static final Color[] OUTLINE_COLOURS = {
        new Color(0x8C1111),
        new Color(0xFFFFFF),
        new Color(0xFF3905),
        new Color(0xFF3905)
    };

    @OriginalMember(owner = "client!wo", name = "y", descriptor = "[Ljava/awt/Color;")
    public static final Color[] FILL_COLOURS = new Color[]{
        new Color(0x8C1111),
        new Color(0x323232),
        new Color(0x323232),
        new Color(0x323232)
    };

    @OriginalMember(owner = "client!jga", name = "k", descriptor = "Lclient!client;")
    public static client aClient1;

    @OriginalMember(owner = "client!po", name = "h", descriptor = "Lclient!pla;")
    public static Js5WorkerThread js5WorkerThread;

    @OriginalMember(owner = "client!lm", name = "r", descriptor = "I")
    public static int netWorkerDelay = 0;

    @OriginalMember(owner = "client!kr", name = "f", descriptor = "Lclient!lja;")
    public static ConnectionInfo gameConnection;

    @OriginalMember(owner = "client!qha", name = "Kf", descriptor = "I")
    public static int js5Errors = 0;

    @OriginalMember(owner = "client!cs", name = "r", descriptor = "I")
    public static int js5State = 0;

    @OriginalMember(owner = "client!qca", name = "z", descriptor = "Lclient!oba;")
    public static SignedResource js5Socket;

    @OriginalMember(owner = "client!lr", name = "c", descriptor = "Ljava/lang/String;")
    public static String netProxyError = null;

    @OriginalMember(owner = "client!vea", name = "J", descriptor = "Lclient!nk;")
    public static BufferedSocket js5BufferedSocket;

    @OriginalMember(owner = "client!via", name = "O", descriptor = "J")
    public static long js5HandshakeTime;

    @OriginalMember(owner = "client!ffa", name = "e", descriptor = "Lclient!mj;")
    public static BufferedFile cacheDat;

    @OriginalMember(owner = "client!aca", name = "c", descriptor = "Lclient!mj;")
    public static BufferedFile metaFile;

    @OriginalMember(owner = "client!ila", name = "i", descriptor = "Lclient!af;")
    public static FileSystem_Client metaCache;

    @OriginalMember(owner = "client!vr", name = "d", descriptor = "Lclient!mj;")
    public static BufferedFile uidDat;

    @OriginalMember(owner = "client!uc", name = "n", descriptor = "[S")
    public static short[] clientpalette;

    @OriginalMember(owner = "client!mf", name = "c", descriptor = "Lclient!ul;")
    public static ModeGame modeGame = null;

    @OriginalMember(owner = "client!km", name = "c", descriptor = "I")
    public static int colourId = 0;

    @OriginalMember(owner = "client!aaa", name = "T", descriptor = "Lclient!tka;")
    public static ModeWhere modeWhere;

    @OriginalMember(owner = "client!ss", name = "h", descriptor = "Lclient!hh;")
    public static ModeWhat modeWhat;

    @OriginalMember(owner = "client!bma", name = "c", descriptor = "I")
    public static int language = 0;

    @OriginalMember(owner = "client!ol", name = "I", descriptor = "Z")
    public static boolean objectTag = false;

    @OriginalMember(owner = "client!db", name = "W", descriptor = "Z")
    public static boolean js = false;

    @OriginalMember(owner = "client!jm", name = "h", descriptor = "Z")
    public static boolean advert = false;

    @OriginalMember(owner = "client!kda", name = "j", descriptor = "I")
    public static int affid = 0;

    @OriginalMember(owner = "client!lg", name = "h", descriptor = "Ljava/lang/String;")
    public static String quitUrl;

    @OriginalMember(owner = "client!en", name = "f", descriptor = "Ljava/lang/String;")
    public static String settings = null;

    @OriginalMember(owner = "client!pb", name = "l", descriptor = "Z")
    public static boolean under13 = false;

    @OriginalMember(owner = "client!sga", name = "i", descriptor = "I")
    public static int country;

    @OriginalMember(owner = "client!b", name = "K", descriptor = "Z")
    public static boolean fromBilling = false;

    @OriginalMember(owner = "client!ov", name = "b", descriptor = "Z")
    public static boolean force64mb = false;

    @OriginalMember(owner = "client!wla", name = "k", descriptor = "I")
    public static int worldFlags = 0;

    @OriginalMember(owner = "client!iea", name = "i", descriptor = "[B")
    public static byte[] ssKey = null;

    @OriginalMember(owner = "client!nca", name = "q", descriptor = "J")
    public static long userFlow = 0L;

    @OriginalMember(owner = "client!md", name = "G", descriptor = "Ljava/lang/String;")
    public static String addtionalInfo = null;

    @OriginalMember(owner = "client!nca", name = "k", descriptor = "Z")
    public static boolean hc = false;

    @OriginalMember(owner = "client!jk", name = "J", descriptor = "I")
    public static int loadingScreenWidth = 765;

    @OriginalMember(owner = "client!pc", name = "b", descriptor = "I")
    public static int loadingScreenHeight = 503;

    @OriginalMember(owner = "client!df", name = "l", descriptor = "Z")
    public static boolean displayFps = false;

    @OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
    public static void main(@OriginalArg(0) String[] arg0) {
        try {
            if (arg0.length != 6) {
                Static426.method1016("Argument count");
            }
            Login.worldInfo = new ConnectionInfo();
            Login.worldInfo.id = Integer.parseInt(arg0[0]);
            Login.lobbyInfo = new ConnectionInfo();
            Login.lobbyInfo.id = Integer.parseInt(arg0[1]);
            modeWhere = ModeWhere.LOCAL;
            if (arg0[3].equals("live")) {
                modeWhat = ModeWhat.LIVE;
            } else if (arg0[3].equals("rc")) {
                modeWhat = ModeWhat.RC;
            } else if (arg0[3].equals("wip")) {
                modeWhat = ModeWhat.WIP;
            } else {
                Static426.method1016("modewhat");
            }
            language = Static541.method7198(arg0[4]);
            if (language == -1) {
                if (arg0[4].equals("english")) {
                    language = 0;
                } else if (arg0[4].equals("german")) {
                    language = 1;
                } else {
                    Static426.method1016("language");
                }
            }
            objectTag = false;
            js = false;
            if (arg0[5].equals("game0")) {
                modeGame = ModeGame.RUNESCAPE;
            } else if (arg0[5].equals("game1")) {
                modeGame = ModeGame.STELLAR_DAWN;
            } else if (arg0[5].equals("game2")) {
                modeGame = ModeGame.GAME3;
            } else if (arg0[5].equals("game3")) {
                modeGame = ModeGame.GAME4;
            } else {
                Static426.method1016("game");
            }
            affid = 0;
            worldFlags = 0;
            fromBilling = false;
            Static508.isMember = true;
            Static126.aBoolean200 = true;
            force64mb = false;
            addtionalInfo = null;
            colourId = modeGame.id;
            settings = "";
            ssKey = null;
            country = 0;
            userFlow = 0L;
            @Pc(241) client local241 = new client();
            aClient1 = local241;
            local241.method1635(modeWhat.getId() + 32, modeGame.domainName);
            GameShell.frame.setLocation(40, 40);
        } catch (@Pc(265) Exception local265) {
            JagException.sendTrace(local265, (String) null);
        }
    }

    @OriginalMember(owner = "client!dh", name = "a", descriptor = "(ZIII)Lclient!sb;")
    public static js5 createJs5(@OriginalArg(0) boolean discardpacked, @OriginalArg(1) int archiveId, @OriginalArg(2) int discardunpacked) {
        @Pc(5) FileSystem_Client fileSystem = null;
        if (cacheDat != null) {
            fileSystem = new FileSystem_Client(archiveId, cacheDat, cacheIndexFiles[archiveId], 1000000);
        }
        js5ResourceProviders[archiveId] = Static228.js5MasterIndex.getProvider(fileSystem, archiveId, metaCache);
        js5ResourceProviders[archiveId].requestMissing();
        return new js5(js5ResourceProviders[archiveId], discardpacked, discardunpacked);
    }

    @OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
    @Override
    public synchronized void method1641() {
        if (GameShell.loaderApplet != null && Static434.canvas == null && !SignLink.instance.microsoftjava) {
            try {
                @Pc(25) Class local25 = GameShell.loaderApplet.getClass();
                @Pc(31) Field local31 = local25.getDeclaredField("canvas");
                Static434.canvas = (Canvas) local31.get(GameShell.loaderApplet);
                local31.set(GameShell.loaderApplet, (Object) null);
                if (Static434.canvas != null) {
                    return;
                }
            } catch (@Pc(45) Exception local45) {
            }
        }
        super.method1641();
    }

    @OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
    @Override
    protected void method1633() {
        if (Static624.aBoolean727) {
            Static266.method6777();
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
        js5WorkerThread.close();
        Static66.aCachedResourceWorker_1.close();
        if (Static151.aClass226_20 != null) {
            Static151.aClass226_20.method5243();
            Static151.aClass226_20 = null;
        }
        try {
            cacheDat.close();
            for (@Pc(66) int local66 = 0; local66 < 37; local66++) {
                cacheIndexFiles[local66].close();
            }
            metaFile.close();
            uidDat.close();
            Static314.method4567();
        } catch (@Pc(91) Exception local91) {
        }
    }

    @OriginalMember(owner = "client!client", name = "q", descriptor = "(I)V")
    public void js5Tick() {
        if (js5Errors < js5WorkerThread.errors) {
            gameConnection.rotateMethods();

            netWorkerDelay = ((js5WorkerThread.errors * 50) - 50) * 5;
            if (netWorkerDelay > 3000) {
                netWorkerDelay = 3000;
            }

            if (js5WorkerThread.errors >= 2 && js5WorkerThread.response == Js5ResponseCode.CONNECT_OUTOFDATE) {
                this.error("js5connect_outofdate");
                MainLogicManager.step = 16;
                return;
            }

            if (js5WorkerThread.errors >= 4 && js5WorkerThread.response == Js5ResponseCode.DISCONNECTED) {
                this.error("js5crc");
                MainLogicManager.step = 16;
                return;
            }

            if (js5WorkerThread.errors >= 4 && Static181.method2778(MainLogicManager.step)) {
                if (js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL1 || js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL2) {
                    this.error("js5connect_full");
                } else if (js5WorkerThread.response <= 0) {
                    this.error("js5io");
                } else if (netProxyError == null) {
                    this.error("js5connect");
                } else {
                    this.error("js5proxy_" + netProxyError.trim());
                }
                MainLogicManager.step = 16;
                return;
            }
        }

        js5Errors = js5WorkerThread.errors;

        if (netWorkerDelay > 0) {
            netWorkerDelay--;
            return;
        }

        try {
            if (js5State == Js5State.INIT) {
                js5Socket = gameConnection.openSocket(SignLink.instance);
                js5State++;
            }

            if (js5State == Js5State.WAITING_CONNECTION_OPENED) {
                if (js5Socket.status == 2) {
                    if (js5Socket.result != null) {
                        netProxyError = (String) js5Socket.result;
                    }

                    this.updateJs5Response(1000);
                    return;
                }

                if (js5Socket.status == 1) {
                    js5State++;
                }
            }

            if (js5State == Js5State.SEND_HEADER) {
                js5BufferedSocket = new BufferedSocket((Socket) js5Socket.result, SignLink.instance, 25000);
                @Pc(251) Packet packet = new Packet(5);
                packet.p1(LoginProt.INIT_JS5REMOTE_CONNECTION.opcode);
                packet.p4(667);
                js5BufferedSocket.write(5, packet.data);
                js5State++;
                js5HandshakeTime = SystemTimer.safetime();
            }

            if (js5State == Js5State.WAITING_FIRST_RESPONSE) {
                if (Static181.method2778(MainLogicManager.step) || js5BufferedSocket.available() > 0) {
                    @Pc(296) int response = js5BufferedSocket.read();
                    if (response != 0) {
                        this.updateJs5Response(response);
                        return;
                    }

                    js5State++;
                } else if (SystemTimer.safetime() - js5HandshakeTime > 30000L) {
                    this.updateJs5Response(1001);
                    return;
                }
            }

            if (js5State == Js5State.WAITING_LOADING_REQUIREMENTS) {
                @Pc(356) boolean loggedOut = Static181.method2778(MainLogicManager.step) || Static41.method1027(MainLogicManager.step) || MainLogicManager.isAtLobbyScreen(MainLogicManager.step);
                @Pc(359) LoadingRequirement[] requirements = Static566.method7467();
                @Pc(367) Packet packet = new Packet(requirements.length * 4);
                js5BufferedSocket.read(packet.data.length, 0, packet.data);
                for (@Pc(378) int i = 0; i < requirements.length; i++) {
                    requirements[i].setSize(packet.g4());
                }
                js5WorkerThread.setSocket(!loggedOut, js5BufferedSocket);
                js5State = Js5State.INIT;
                js5BufferedSocket = null;
                js5Socket = null;
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
        InterfaceManager.setOptions(-1, -1, (Component) null);
        WorldMap.setOptions(-1, -1, (Component) null);
        Static443.method5981();
        World.tick++;
        for (local46 = 0; local46 < Static416.anInt6378; local46++) {
            @Pc(97) NPCEntity local97 = Static592.aClass2_Sub45Array1[local46].aClass8_Sub2_Sub1_Sub2_Sub2_2;
            if (local97 != null) {
                @Pc(103) byte local103 = local97.type.movementCapabilities;
                if ((local103 & 0x1) != 0) {
                    @Pc(114) int local114 = local97.boundSize((byte) 48);
                    @Pc(142) int local142;
                    if ((local103 & 0x2) != 0 && local97.anInt10764 == 0 && Math.random() * 1000.0D < 10.0D) {
                        local142 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        @Pc(150) int local150 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        if (local142 != 0 || local150 != 0) {
                            @Pc(166) int local166 = local142 + local97.pathX[0];
                            if (local166 < 0) {
                                local166 = 0;
                            } else if (local166 > Static720.mapWidth - local114 - 1) {
                                local166 = Static720.mapWidth - local114 - 1;
                            }
                            @Pc(203) int local203 = local150 + local97.pathY[0];
                            if (local203 < 0) {
                                local203 = 0;
                            } else if (local203 > Static501.mapHeight - local114 - 1) {
                                local203 = Static501.mapHeight - local114 - 1;
                            }
                            @Pc(258) int local258 = Static521.method6870(local203, local114, true, 0, local97.pathX[0], local114, Static480.anIntArray583, local114, local97.pathY[0], -1, Static577.A_COLLISION_MAP_ARRAY_1[local97.level], Static70.anIntArray147, local166, 0);
                            if (local258 > 0) {
                                if (local258 > 9) {
                                    local258 = 9;
                                }
                                for (@Pc(274) int local274 = 0; local274 < local258; local274++) {
                                    local97.pathX[local274] = Static70.anIntArray147[local258 - local274 - 1];
                                    local97.pathY[local274] = Static480.anIntArray583[local258 - local274 - 1];
                                    local97.aByteArray111[local274] = 1;
                                }
                                local97.anInt10764 = local258;
                            }
                        }
                    }
                    Static256.method3638(local97, true);
                    local142 = Static112.method2104(local97);
                    Static145.method2410(local97);
                    Static651.method8513(Static521.anInt7756, local142, Static524.anInt8042, local97);
                    Static702.method9166(local97, Static521.anInt7756);
                    Static50.method6638(local97);
                }
            }
        }
        if ((MainLogicManager.step == 3 || MainLogicManager.step == 9 || MainLogicManager.step == 7) && (!Static242.method3500() || MainLogicManager.step == 9 && Static169.anInt2855 == 42) && Static6.anInt95 == 0) {
            if (Static511.anInt7645 == 2) {
                Static592.method7761();
            } else {
                Static583.method7659();
            }
            if (Static170.anInt2864 >> 9 < 14 || Static170.anInt2864 >> 9 >= Static720.mapWidth - 14 || Static110.anInt2186 >> 9 < 14 || Static110.anInt2186 >> 9 >= Static501.mapHeight - 14) {
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
                                            if (Static624.aBoolean727 && SystemTimer.safetime() - 60000L > Static98.aLong71) {
                                                Static266.method6777();
                                            }
                                            for (@Pc(672) Class8_Sub4_Sub1 local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local672 != null; local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                if ((long) local672.anInt6433 < SystemTimer.safetime() / 1000L - 5L) {
                                                    if (local672.aShort74 > 0) {
                                                        Static44.method1072(local672.aString72 + LocalisedText.FRIENDLOGIN.localise(language), "", 0, "", "", 5);
                                                    }
                                                    if (local672.aShort74 == 0) {
                                                        Static44.method1072(local672.aString72 + LocalisedText.FRIENDLOGOUT.localise(language), "", 0, "", "", 5);
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
        @Pc(7) boolean workerTick = js5WorkerThread.tick();

        if (!workerTick) {
            this.js5Tick();
        }
    }

    @OriginalMember(owner = "client!client", name = "e", descriptor = "(B)V")
    @Override
    protected void method1637() {
    }

    @OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
    public void method1666() {
        if (MainLogicManager.step == 16) {
            return;
        }
        @Pc(20) long local20 = Static271.method3929() / 1000000L - Static206.aLong114;
        Static206.aLong114 = Static271.method3929() / 1000000L;
        @Pc(28) boolean local28 = Static576.method7611();
        if (local28 && Static501.aBoolean575 && Static719.aClass56_5 != null) {
            Static719.aClass56_5.method3592();
        }
        if (Static475.method6445(MainLogicManager.step)) {
            if (Static297.aLong153 != 0L && SystemTimer.safetime() > Static297.aLong153) {
                Static409.method5657(InterfaceManager.getWindowMode(), Static560.anInt8429, false, Static433.anInt6258);
            } else if (!Toolkit.active.method8001() && Static723.aBoolean827) {
                Static574.method7572();
            }
        }
        @Pc(110) int local110;
        @Pc(114) int local114;
        if (GameShell.fsframe == null) {
            @Pc(98) Container local98;
            if (GameShell.frame != null) {
                local98 = GameShell.frame;
            } else if (GameShell.loaderApplet == null) {
                local98 = GameShell.instance;
            } else {
                local98 = GameShell.loaderApplet;
            }
            local110 = local98.getSize().width;
            local114 = local98.getSize().height;
            if (local98 == GameShell.frame) {
                @Pc(120) Insets local120 = GameShell.frame.getInsets();
                local114 -= local120.bottom + local120.top;
                local110 -= local120.right + local120.left;
            }
            if (GameShell.frameWid != local110 || local114 != GameShell.frameHei || Static284.aBoolean355) {
                if (Toolkit.active == null || Toolkit.active.method7983()) {
                    Static712.method9329((byte) 11);
                } else {
                    GameShell.frameWid = local110;
                    GameShell.frameHei = local114;
                }
                Static297.aLong153 = SystemTimer.safetime() + 500L;
                Static284.aBoolean355 = false;
            }
        }
        if (GameShell.fsframe != null && !Static91.aBoolean750 && Static475.method6445(MainLogicManager.step)) {
            Static409.method5657(ClientOptions.instance.screenSize.getValue(), -1, false, -1);
        }
        @Pc(209) boolean local209 = false;
        if (Static664.aBoolean759) {
            local209 = true;
            Static664.aBoolean759 = false;
        }
        if (local209) {
            Static288.method4182();
        }
        if (Toolkit.active != null && Toolkit.active.method8001() || InterfaceManager.getWindowMode() != 1) {
            InterfaceManager.redrawAll();
        }
        if (Static181.method2778(MainLogicManager.step)) {
            Static523.method3447(local209);
        } else if (Static366.method5262(MainLogicManager.step)) {
            InterfaceManager.method680();
        } else if (Static384.method5393(MainLogicManager.step)) {
            InterfaceManager.method680();
        } else if (Static594.method7782(MainLogicManager.step)) {
            if (Static213.anInt3472 == 1) {
                if (Static593.anInt8763 > Static357.anInt6508) {
                    Static357.anInt6508 = Static593.anInt8763;
                }
                local110 = (Static357.anInt6508 - Static593.anInt8763) * 50 / Static357.anInt6508;
                Static694.method9028(Toolkit.active, LocalisedText.LOADING.localise(language) + "<br>(" + local110 + "%)", true, Fonts.p12Metrics, Fonts.p12);
            } else if (Static213.anInt3472 == 2) {
                if (Static13.anInt150 > Static440.anInt6683) {
                    Static440.anInt6683 = Static13.anInt150;
                }
                local110 = (Static440.anInt6683 - Static13.anInt150) * 50 / Static440.anInt6683 + 50;
                Static694.method9028(Toolkit.active, LocalisedText.LOADING.localise(language) + "<br>(" + local110 + "%)", true, Fonts.p12Metrics, Fonts.p12);
            } else {
                Static694.method9028(Toolkit.active, LocalisedText.LOADING.localise(language), true, Fonts.p12Metrics, Fonts.p12);
            }
        } else if (MainLogicManager.step == 11) {
            InterfaceManager.method7930(local20);
        } else if (MainLogicManager.step == 14) {
            Static694.method9028(Toolkit.active, LocalisedText.CONLOST.localise(language) + "<br>" + LocalisedText.ATTEMPTING_TO_REESTABLISH.localise(language), false, Fonts.p12Metrics, Fonts.p12);
        } else if (MainLogicManager.step == 15) {
            Static694.method9028(Toolkit.active, LocalisedText.PLEASEWAIT.localise(language), false, Fonts.p12Metrics, Fonts.p12);
        }
        if (InterfaceManager.rectDebug == 3) {
            for (local110 = 0; local110 < InterfaceManager.boundaryCount; local110++) {
                @Pc(478) Rectangle local478 = InterfaceManager.boundaries[local110];
                if (InterfaceManager.currentlyDirtyRect[local110]) {
                    Toolkit.active.method7945(local478.y, -65281, local478.width, local478.height, local478.x);
                } else if (InterfaceManager.flipDirtyRect[local110]) {
                    Toolkit.active.method7945(local478.y, -65536, local478.width, local478.height, local478.x);
                } else {
                    Toolkit.active.method7945(local478.y, -16711936, local478.width, local478.height, local478.x);
                }
            }
        }
        if (debugconsole.isOpen()) {
            Static546.method7251(Toolkit.active);
        }
        if (SignLink.instance.microsoftjava && Static475.method6445(MainLogicManager.step) && InterfaceManager.rectDebug == 0 && InterfaceManager.getWindowMode() == 1 && !local209) {
            local110 = 0;
            for (local114 = 0; local114 < InterfaceManager.boundaryCount; local114++) {
                if (InterfaceManager.flipDirtyRect[local114]) {
                    InterfaceManager.flipDirtyRect[local114] = false;
                    Static663.aRectangleArray2[local110++] = InterfaceManager.boundaries[local114];
                }
            }
            try {
                if (InterfaceManager.aBoolean210) {
                    Static700.method9148(local110, Static663.aRectangleArray2);
                } else {
                    Toolkit.active.method8005(local110, Static663.aRectangleArray2);
                }
            } catch (@Pc(629) Exception_Sub1 local629) {
            }
        } else if (!Static181.method2778(MainLogicManager.step)) {
            for (local110 = 0; local110 < InterfaceManager.boundaryCount; local110++) {
                InterfaceManager.flipDirtyRect[local110] = false;
            }
            try {
                if (InterfaceManager.aBoolean210) {
                    Static430.method5818();
                } else {
                    Toolkit.active.method7984();
                }
            } catch (@Pc(666) Exception_Sub1 local666) {
                JagException.sendTrace(local666, local666.getMessage() + " (Recovered) " + this.getErrorTrace());
                Static32.method880(0, false);
            }
        }
        VideoTypeList.method6744();
        local110 = ClientOptions.instance.aClass57_Sub21_1.method6360();
        if (local110 == 0) {
            TimeUtils.sleep(15L);
        } else if (local110 == 1) {
            TimeUtils.sleep(10L);
        } else if (local110 == 2) {
            TimeUtils.sleep(5L);
        } else if (local110 == 3) {
            TimeUtils.sleep(2L);
        }
        if (Static666.aBoolean766) {
            Static614.method8245();
        }
        if (ClientOptions.instance.aClass57_Sub10_1.method3519() == 1 && MainLogicManager.step == 3 && InterfaceManager.topLevelInterface != -1) {
            ClientOptions.instance.method5104(0, ClientOptions.instance.aClass57_Sub10_1);
            Static666.method8693(1);
        }
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(ZI)V")
    public void updateJs5Response(@OriginalArg(1) int response) {
        js5Socket = null;
        js5WorkerThread.response = response;
        js5BufferedSocket = null;
        js5WorkerThread.errors++;
        js5State = 0;
    }

    @OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
    @Override
    protected void method1645() {
        if (ClientOptions.instance.toolkit.value() != 2) {
            this.method1668();
            return;
        }
        try {
            this.method1668();
        } catch (@Pc(21) ThreadDeath local21) {
            throw local21;
        } catch (@Pc(24) Throwable local24) {
            JagException.sendTrace(local24, local24.getMessage() + " (Recovered) " + this.getErrorTrace());
            Static171.aBoolean245 = true;
            Static32.method880(0, false);
        }
    }

    @OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
    public void method1668() {
        if (MainLogicManager.step == 16) {
            return;
        }
        TimeUtils.clock++;
        if (TimeUtils.clock % 1000 == 1) {
            @Pc(27) GregorianCalendar local27 = new GregorianCalendar();
            Static178.anInt2947 = local27.get(11) * 600 + local27.get(12) * 10 + local27.get(13) / 6;
            Static493.aRandom1.setSeed((long) Static178.anInt2947);
        }
        ConnectionManager.GAME.recordStats();
        ConnectionManager.LOBBY.recordStats();
        this.tickJs5();
        if (Static228.js5MasterIndex != null) {
            Static228.js5MasterIndex.process();
        }
        Static601.method7865();
        VideoTypeList.method3453();
        KeyMonitor.instance.method8481();
        MouseMonitor.instance.record();
        if (Toolkit.active != null) {
            Toolkit.active.method7977((int) SystemTimer.safetime());
        }
        Static711.method9272();
        Static671.anInt10026 = 0;
        Static216.anInt3530 = 0;
        for (@Pc(94) Interface27 local94 = KeyMonitor.instance.method8478(); local94 != null; local94 = KeyMonitor.instance.method8478()) {
            @Pc(102) int local102 = local94.method2668();
            if (local102 == 2 || local102 == 3) {
                @Pc(118) char local118 = local94.method2666();
                if (Static647.method8468() && (local118 == '`' || local118 == '§' || local118 == '²')) {
                    if (debugconsole.isOpen()) {
                        Static129.method2279();
                    } else {
                        Static455.method6224();
                    }
                } else if (Static671.anInt10026 < 128) {
                    Static194.anInterface27Array1[Static671.anInt10026] = local94;
                    Static671.anInt10026++;
                }
            } else if (local102 == 0 && Static216.anInt3530 < 75) {
                Static591.anInterface27Array2[Static216.anInt3530] = local94;
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
        if (Static181.method2778(MainLogicManager.step)) {
            Static709.method9252();
            Static199.doneslowupdate();
        } else if (Static594.method7782(MainLogicManager.step)) {
            Static489.method6548();
        }
        if (Static41.method1027(MainLogicManager.step) && !Static594.method7782(MainLogicManager.step)) {
            this.method1658();
            Static76.method1555();
            Static364.method5253();
        } else if (MainLogicManager.isAtLobbyScreen(MainLogicManager.step) && !Static594.method7782(MainLogicManager.step)) {
            this.method1658();
            Static364.method5253();
        } else if (MainLogicManager.step == 13) {
            Static364.method5253();
        } else if (MainLogicManager.isAtGameScreen(MainLogicManager.step) && !Static594.method7782(MainLogicManager.step)) {
            Static709.method9254();
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
                        Login.logout(Static461.aBoolean529);
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
        if (force64mb) {
            ClientOptions.maxmemory = 64;
        }
        @Pc(18) Frame local18 = new Frame("Jagex");
        local18.pack();
        local18.dispose();
        Static712.method9329((byte) 11);
        Static66.aCachedResourceWorker_1 = new CachedResourceWorker(SignLink.instance);
        js5WorkerThread = new Js5WorkerThread();
        Static545.method7241(new int[]{20, 260}, new int[]{1000, 100});
        if (ModeWhere.LIVE != modeWhere) {
            Static163.aByteArrayArray36 = new byte[50][];
        }
        ClientOptions.instance = Static720.method9398();
        if (modeWhere == ModeWhere.LIVE) {
            Login.worldInfo.address = this.getCodeBase().getHost();
        } else if (ModeWhere.isPrivate(modeWhere)) {
            Login.worldInfo.address = this.getCodeBase().getHost();
            Login.worldInfo.defaultPort = Login.worldInfo.id + 40000;
            Login.worldInfo.alternatePort = Login.worldInfo.id + 50000;
            Login.lobbyInfo.defaultPort = Login.lobbyInfo.id + 40000;
            Login.lobbyInfo.alternatePort = Login.lobbyInfo.id + 50000;
        } else if (ModeWhere.LOCAL == modeWhere) {
            Login.worldInfo.address = "127.0.0.1";
            Login.worldInfo.defaultPort = Login.worldInfo.id + 40000;
            Login.lobbyInfo.address = "127.0.0.1";
            Login.worldInfo.alternatePort = Login.worldInfo.id + 50000;
            Login.lobbyInfo.defaultPort = Login.lobbyInfo.id + 40000;
            Login.lobbyInfo.alternatePort = Login.lobbyInfo.id + 50000;
        }
        gameConnection = Login.worldInfo;
        clientpalette = LocType.clientpalette = NPCType.clientpalette = ObjType.clientpalette = new short[256];
        if (modeGame == ModeGame.RUNESCAPE) {
            Static273.aBoolean340 = false;
        }
        try {
            Static175.aClipboard1 = aClient1.getToolkit().getSystemClipboard();
        } catch (@Pc(183) Exception local183) {
        }
        KeyMonitor.instance = Static681.method8921(Static434.canvas);
        MouseMonitor.instance = MouseMonitor.create(Static434.canvas);
        try {
            if (SignLink.instance.cacheDat != null) {
                cacheDat = new BufferedFile(SignLink.instance.cacheDat, 5200, 0);
                for (@Pc(205) int i = 0; i < 37; i++) {
                    cacheIndexFiles[i] = new BufferedFile(SignLink.instance.cacheIndex[i], 6000, 0);
                }
                metaFile = new BufferedFile(SignLink.instance.masterIndex, 6000, 0);
                metaCache = new FileSystem_Client(Js5Archive.ARCHIVESET, cacheDat, metaFile, 500000);
                uidDat = new BufferedFile(SignLink.instance.uidFile, 24, 0);
                SignLink.instance.masterIndex = null;
                SignLink.instance.cacheIndex = null;
                SignLink.instance.cacheDat = null;
                SignLink.instance.uidFile = null;
            }
        } catch (@Pc(275) IOException local275) {
            metaFile = null;
            metaCache = null;
            uidDat = null;
            cacheDat = null;
        }

        if (ModeWhere.LIVE != modeWhere) {
            displayFps = true;
        }

        Static484.aString85 = LocalisedText.LOADING.localise(language);
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(I)Ljava/lang/String;")
    @Override
    public String getErrorTrace() {
        @Pc(5) String trace = null;
        try {
            trace = "[1)" + WorldMap.areaBaseX + "," + WorldMap.areaBaseY + "," + Static720.mapWidth + "," + Static501.mapHeight + "|";

            if (PlayerEntity.self != null) {
                trace = trace + "2)" + Camera.renderingLevel + "," + (PlayerEntity.self.pathX[0] + WorldMap.areaBaseX) + "," + (WorldMap.areaBaseY + PlayerEntity.self.pathY[0]) + "|";
            }

            trace = trace + "3)" + ClientOptions.instance.toolkit.value() + "|4)" + ClientOptions.instance.antialiasingMode.value() + "|5)" + InterfaceManager.getWindowMode() + "|6)" + GameShell.canvasWid + "," + GameShell.canvasHei + "|";
            trace = trace + "7)" + ClientOptions.instance.lightDetail.value() + "|";
            trace = trace + "8)" + ClientOptions.instance.hardShadows.value() + "|";
            trace = trace + "9)" + ClientOptions.instance.waterDetail.value() + "|";
            trace = trace + "10)" + ClientOptions.instance.textures.value() + "|";
            trace = trace + "11)" + ClientOptions.instance.bloom.value() + "|";
            trace = trace + "12)" + ClientOptions.instance.animatingBackground.value() + "|";
            trace = trace + "13)" + ClientOptions.maxmemory + "|";
            trace = trace + "14)" + MainLogicManager.step;

            if (SystemInfo.instance != null) {
                trace = trace + "|15)" + SystemInfo.instance.totalMemory;
            }

            try {
                if (ClientOptions.instance.toolkit.value() == 2) {
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

        modeWhere = ModeWhere.fromId(Integer.parseInt(this.getParameter("modewhere")));
        if (ModeWhere.LOCAL == modeWhere) {
            modeWhere = ModeWhere.WIP;
        } else if (!ModeWhere.isPrivate(modeWhere) && ModeWhere.LIVE != modeWhere) {
            modeWhere = ModeWhere.LIVE;
        }

        modeWhat = ModeWhat.fromId(Integer.parseInt(this.getParameter("modewhat")));
        if (ModeWhat.WIP != modeWhat && modeWhat != ModeWhat.RC && ModeWhat.LIVE != modeWhat) {
            modeWhat = ModeWhat.LIVE;
        }

        try {
            language = Integer.parseInt(this.getParameter("lang"));
        } catch (@Pc(110) Exception local110) {
            language = 0;
        }

        @Pc(118) String objectTagParam = this.getParameter("objecttag");
        if (objectTagParam != null && objectTagParam.equals("1")) {
            objectTag = true;
        } else {
            objectTag = false;
        }

        @Pc(142) String jsParam = this.getParameter("js");
        if (jsParam != null && jsParam.equals("1")) {
            js = true;
        } else {
            js = false;
        }

        @Pc(166) String advertParam = this.getParameter("advert");
        if (advertParam != null && advertParam.equals("1")) {
            advert = true;
        } else {
            advert = false;
        }

        @Pc(190) String gameParam = this.getParameter("game");
        if (gameParam != null) {
            if (gameParam.equals("0")) {
                modeGame = ModeGame.RUNESCAPE;
            } else if (gameParam.equals("1")) {
                modeGame = ModeGame.STELLAR_DAWN;
            } else if (gameParam.equals("2")) {
                modeGame = ModeGame.GAME3;
            } else if (gameParam.equals("3")) {
                modeGame = ModeGame.GAME4;
            }
        }

        try {
            affid = Integer.parseInt(this.getParameter("affid"));
        } catch (@Pc(247) Exception ignored) {
            affid = 0;
        }

        quitUrl = this.getParameter("quiturl");

        settings = this.getParameter("settings");
        if (settings == null) {
            settings = "";
        }

        under13 = "1".equals(this.getParameter("under"));

        @Pc(281) String countryParam = this.getParameter("country");
        if (countryParam != null) {
            try {
                country = Integer.parseInt(countryParam);
            } catch (@Pc(288) Exception ignored) {
                country = 0;
            }
        }

        colourId = Integer.parseInt(this.getParameter("colourid"));
        if (colourId < 0 || FILL_COLOURS.length <= colourId) {
            colourId = 0;
        }

        if (Integer.parseInt(this.getParameter("sitesettings_member")) == 1) {
            Static508.isMember = true;
            Static126.aBoolean200 = true;
        }

        @Pc(336) String fromBillingParam = this.getParameter("frombilling");
        if (fromBillingParam != null && fromBillingParam.equals("true")) {
            fromBilling = true;
        }

        @Pc(356) String ssKeyParam = this.getParameter("sskey");
        if (ssKeyParam != null) {
            ssKey = Base64.encode(Url.decode(ssKeyParam));

            if (ssKey.length < 16) {
                ssKey = null;
            }
        }

        @Pc(382) String force64mbParam = this.getParameter("force64mb");
        if (force64mbParam != null && force64mbParam.equals("true")) {
            force64mb = true;
        }

        @Pc(402) String worldflagsParam = this.getParameter("worldflags");
        if (worldflagsParam != null) {
            try {
                worldFlags = Integer.parseInt(worldflagsParam);
            } catch (@Pc(409) Exception ignored) {
                /* empty */
            }
        }

        @Pc(416) String userFlowParam = this.getParameter("userFlow");
        if (userFlowParam != null) {
            try {
                userFlow = Long.parseLong(userFlowParam);
            } catch (@Pc(424) NumberFormatException local424) {
            }
        }

        addtionalInfo = this.getParameter("additionalInfo");
        if (addtionalInfo != null && addtionalInfo.length() > 50) {
            addtionalInfo = null;
        }

        if (ModeGame.RUNESCAPE == modeGame) {
            loadingScreenWidth = 765;
            loadingScreenHeight = 503;
        } else if (modeGame == ModeGame.STELLAR_DAWN) {
            loadingScreenHeight = 480;
            loadingScreenWidth = 640;
        }

        @Pc(473) String hcParam = this.getParameter("hc");
        if (hcParam != null && hcParam.equals("1")) {
            hc = true;
        }

        aClient1 = this;
        this.startApplet(BUILD, loadingScreenWidth, modeWhat.getId() + 32, modeGame.domainName, Js5Archive.COUNT, loadingScreenHeight);
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
    @Override
    protected void method1650() {
        if (ClientOptions.instance.toolkit.value() != 2) {
            this.method1666();
            return;
        }
        try {
            this.method1666();
        } catch (@Pc(21) ThreadDeath local21) {
            throw local21;
        } catch (@Pc(24) Throwable local24) {
            JagException.sendTrace(local24, local24.getMessage() + " (Recovered) " + this.getErrorTrace());
            Static171.aBoolean245 = true;
            Static32.method880(0, false);
        }
    }
}
