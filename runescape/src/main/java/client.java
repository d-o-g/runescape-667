import com.jagex.SignLink;
import com.jagex.SignedResource;
import com.jagex.core.constants.ModeGame;
import com.jagex.core.io.BufferedFile;
import com.jagex.core.io.BufferedSocket;
import com.jagex.core.io.Packet;
import com.jagex.core.util.JagException;
import com.jagex.core.util.SystemTimer;
import com.jagex.core.util.TimeUtils;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.npctype.NPCType;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.graphics.Exception_Sub1;
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

    @OriginalMember(owner = "client!gha", name = "t", descriptor = "[Lclient!mj;")
    public static final BufferedFile[] cacheIndexFiles = new BufferedFile[37];
    @OriginalMember(owner = "client!ha", name = "l", descriptor = "[Lclient!pm;")
    public static final Js5ResourceProvider[] js5ResourceProviders = new Js5ResourceProvider[37];
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

    @OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
    public static void main(@OriginalArg(0) String[] arg0) {
        try {
            if (arg0.length != 6) {
                Static426.method1016("Argument count");
            }
            Static527.aConnectionInfo_3 = new ConnectionInfo();
            Static527.aConnectionInfo_3.id = Integer.parseInt(arg0[0]);
            Static660.aConnectionInfo_4 = new ConnectionInfo();
            Static660.aConnectionInfo_4.id = Integer.parseInt(arg0[1]);
            Static2.aClass355_1 = Static16.aClass355_2;
            if (arg0[3].equals("live")) {
                Static598.aClass162_5 = Static523.aClass162_3;
            } else if (arg0[3].equals("rc")) {
                Static598.aClass162_5 = Static519.aClass162_4;
            } else if (arg0[3].equals("wip")) {
                Static598.aClass162_5 = Static225.aClass162_1;
            } else {
                Static426.method1016("modewhat");
            }
            Static51.anInt1052 = Static541.method7198(arg0[4]);
            if (Static51.anInt1052 == -1) {
                if (arg0[4].equals("english")) {
                    Static51.anInt1052 = 0;
                } else if (arg0[4].equals("german")) {
                    Static51.anInt1052 = 1;
                } else {
                    Static426.method1016("language");
                }
            }
            Static464.aBoolean533 = false;
            Static98.aBoolean191 = false;
            if (arg0[5].equals("game0")) {
                Static392.aModeGame_4 = ModeGame.RUNESCAPE;
            } else if (arg0[5].equals("game1")) {
                Static392.aModeGame_4 = ModeGame.STELLAR_DAWN;
            } else if (arg0[5].equals("game2")) {
                Static392.aModeGame_4 = ModeGame.GAME3;
            } else if (arg0[5].equals("game3")) {
                Static392.aModeGame_4 = ModeGame.GAME4;
            } else {
                Static426.method1016("game");
            }
            Static323.anInt5121 = 0;
            Static715.anInt10805 = 0;
            Static29.aBoolean61 = false;
            Static508.aBoolean582 = true;
            Static126.aBoolean200 = true;
            Static473.aBoolean539 = false;
            Static389.aString64 = null;
            Static338.anInt5562 = Static392.aModeGame_4.id;
            Static150.aString26 = "";
            Static265.aByteArray44 = null;
            Static584.anInt8634 = 0;
            Static416.aLong208 = 0L;
            @Pc(241) client local241 = new client();
            aClient1 = local241;
            local241.method1635(Static598.aClass162_5.method3469() + 32, Static392.aModeGame_4.domainName);
            Static353.aFrame10.setLocation(40, 40);
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
        if (GameShell.loaderApplet != null && Static434.aCanvas7 == null && !SignLink.instance.microsoftjava) {
            try {
                @Pc(25) Class local25 = GameShell.loaderApplet.getClass();
                @Pc(31) Field local31 = local25.getDeclaredField("canvas");
                Static434.aCanvas7 = (Canvas) local31.get(GameShell.loaderApplet);
                local31.set(GameShell.loaderApplet, (Object) null);
                if (Static434.aCanvas7 != null) {
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
        if (Static163.activeToolkit != null) {
            Static163.activeToolkit.free();
        }
        if (Static316.fsframe != null) {
            Static655.method8562(SignLink.instance, Static316.fsframe);
            Static316.fsframe = null;
        }
        Static405.A_SERVER_CONNECTION___2.close();
        Static405.A_SERVER_CONNECTION___1.close();
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
                Static283.step = 16;
                return;
            }

            if (js5WorkerThread.errors >= 4 && js5WorkerThread.response == Js5ResponseCode.DISCONNECTED) {
                this.error("js5crc");
                Static283.step = 16;
                return;
            }

            if (js5WorkerThread.errors >= 4 && Static181.method2778(Static283.step)) {
                if (js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL1 || js5WorkerThread.response == Js5ResponseCode.CONNECT_FULL2) {
                    this.error("js5connect_full");
                } else if (js5WorkerThread.response <= 0) {
                    this.error("js5io");
                } else if (netProxyError == null) {
                    this.error("js5connect");
                } else {
                    this.error("js5proxy_" + netProxyError.trim());
                }
                Static283.step = 16;
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
                if (Static181.method2778(Static283.step) || js5BufferedSocket.available() > 0) {
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
                @Pc(356) boolean loggedOut = Static181.method2778(Static283.step) || Static41.method1027(Static283.step) || Static620.method8321(Static283.step);
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
        if (Static283.step == 7 && !Static242.method3500() || Static283.step == 9 && Static169.anInt2855 == 42) {
            if (Static249.anInt4008 > 1) {
                Static249.anInt4008--;
                Static321.anInt5111 = Static642.anInt9599;
            }
            if (!Static400.aBoolean622) {
                Static79.method1578();
            }
            for (local46 = 0; local46 < 100 && Static236.method3451(Static405.A_SERVER_CONNECTION___1); local46++) {
            }
        }
        Static35.anInt800++;
        Static449.method6114(-1, -1, (Class158) null);
        Static65.method1473(-1, -1, (Class158) null);
        Static443.method5981();
        Static642.anInt9599++;
        for (local46 = 0; local46 < Static416.anInt6378; local46++) {
            @Pc(97) Class8_Sub2_Sub1_Sub2_Sub2 local97 = Static592.aClass2_Sub45Array1[local46].aClass8_Sub2_Sub1_Sub2_Sub2_2;
            if (local97 != null) {
                @Pc(103) byte local103 = local97.aNPCType_1.movementCapabilities;
                if ((local103 & 0x1) != 0) {
                    @Pc(114) int local114 = local97.method9302((byte) 48);
                    @Pc(142) int local142;
                    if ((local103 & 0x2) != 0 && local97.anInt10764 == 0 && Math.random() * 1000.0D < 10.0D) {
                        local142 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        @Pc(150) int local150 = (int) Math.round(Math.random() * 10.0D - 5.0D);
                        if (local142 != 0 || local150 != 0) {
                            @Pc(166) int local166 = local142 + local97.anIntArray879[0];
                            if (local166 < 0) {
                                local166 = 0;
                            } else if (local166 > Static720.mapWidth - local114 - 1) {
                                local166 = Static720.mapWidth - local114 - 1;
                            }
                            @Pc(203) int local203 = local150 + local97.anIntArray878[0];
                            if (local203 < 0) {
                                local203 = 0;
                            } else if (local203 > Static501.mapHeight - local114 - 1) {
                                local203 = Static501.mapHeight - local114 - 1;
                            }
                            @Pc(258) int local258 = Static521.method6870(local203, local114, true, 0, local97.anIntArray879[0], local114, Static480.anIntArray583, local114, local97.anIntArray878[0], -1, Static577.A_COLLISION_MAP_ARRAY_1[local97.aByte144], Static70.anIntArray147, local166, 0);
                            if (local258 > 0) {
                                if (local258 > 9) {
                                    local258 = 9;
                                }
                                for (@Pc(274) int local274 = 0; local274 < local258; local274++) {
                                    local97.anIntArray879[local274] = Static70.anIntArray147[local258 - local274 - 1];
                                    local97.anIntArray878[local274] = Static480.anIntArray583[local258 - local274 - 1];
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
        if ((Static283.step == 3 || Static283.step == 9 || Static283.step == 7) && (!Static242.method3500() || Static283.step == 9 && Static169.anInt2855 == 42) && Static6.anInt95 == 0) {
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
            @Pc(453) Node_Sub42 local453;
            @Pc(458) Class158 local458;
            @Pc(470) Class158 local470;
            do {
                local453 = (Node_Sub42) Static618.A_DEQUE___68.removeFirst();
                if (local453 == null) {
                    while (true) {
                        do {
                            local453 = (Node_Sub42) Static59.A_DEQUE___33.removeFirst();
                            if (local453 == null) {
                                while (true) {
                                    do {
                                        local453 = (Node_Sub42) Static521.A_DEQUE___44.removeFirst();
                                        if (local453 == null) {
                                            if (Static109.aClass158_3 != null) {
                                                Static603.method7899();
                                            }
                                            if (TimeUtils.clock % 1500 == 0) {
                                                Static314.method4562();
                                            }
                                            if (Static283.step == 7 && !Static242.method3500() || Static283.step == 9 && Static169.anInt2855 == 42) {
                                                Static320.method4598();
                                            }
                                            Static587.method7704();
                                            if (Static624.aBoolean727 && SystemTimer.safetime() - 60000L > Static98.aLong71) {
                                                Static266.method6777();
                                            }
                                            for (@Pc(672) Class8_Sub4_Sub1 local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.first(); local672 != null; local672 = (Class8_Sub4_Sub1) Static168.A_ENTITY_LIST___5.next()) {
                                                if ((long) local672.anInt6433 < SystemTimer.safetime() / 1000L - 5L) {
                                                    if (local672.aShort74 > 0) {
                                                        Static44.method1072(local672.aString72 + LocalisedText.FRIENDLOGIN.localise(Static51.anInt1052), "", 0, "", "", 5);
                                                    }
                                                    if (local672.aShort74 == 0) {
                                                        Static44.method1072(local672.aString72 + LocalisedText.FRIENDLOGOUT.localise(Static51.anInt1052), "", 0, "", "", 5);
                                                    }
                                                    local672.unlink();
                                                }
                                            }
                                            if (Static283.step == 7 && !Static242.method3500() || Static283.step == 9 && Static169.anInt2855 == 42) {
                                                if (Static283.step != 9 && Static405.A_SERVER_CONNECTION___1.connection == null) {
                                                    Static233.method3409(false);
                                                    return;
                                                }
                                                if (Static405.A_SERVER_CONNECTION___1 != null) {
                                                    Static405.A_SERVER_CONNECTION___1.idleWriteTicks++;
                                                    if (Static405.A_SERVER_CONNECTION___1.idleWriteTicks > 50) {
                                                        @Pc(823) ClientMessage local823 = Static293.method4335(Static415.aClass345_75, Static405.A_SERVER_CONNECTION___1.aClass186_1);
                                                        Static405.A_SERVER_CONNECTION___1.send(local823);
                                                    }
                                                    try {
                                                        Static405.A_SERVER_CONNECTION___1.flush();
                                                        return;
                                                    } catch (@Pc(832) IOException local832) {
                                                        if (Static283.step != 9) {
                                                            Static233.method3409(false);
                                                            return;
                                                        }
                                                        Static405.A_SERVER_CONNECTION___1.close();
                                                        return;
                                                    }
                                                }
                                            }
                                            return;
                                        }
                                        local458 = local453.aClass158_14;
                                        if (local458.anInt3741 < 0) {
                                            break;
                                        }
                                        local470 = Static145.method2412(local458.anInt3743);
                                    } while (local470 == null || local470.aClass158Array2 == null || local470.aClass158Array2.length <= local458.anInt3741 || local470.aClass158Array2[local458.anInt3741] != local458);
                                    Static472.method6420(local453);
                                }
                            }
                            local458 = local453.aClass158_14;
                            if (local458.anInt3741 < 0) {
                                break;
                            }
                            local470 = Static145.method2412(local458.anInt3743);
                        } while (local470 == null || local470.aClass158Array2 == null || local470.aClass158Array2.length <= local458.anInt3741 || local458 != local470.aClass158Array2[local458.anInt3741]);
                        Static472.method6420(local453);
                    }
                }
                local458 = local453.aClass158_14;
                if (local458.anInt3741 < 0) {
                    break;
                }
                local470 = Static145.method2412(local458.anInt3743);
            } while (local470 == null || local470.aClass158Array2 == null || local470.aClass158Array2.length <= local458.anInt3741 || local458 != local470.aClass158Array2[local458.anInt3741]);
            Static472.method6420(local453);
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
        if (Static283.step == 16) {
            return;
        }
        @Pc(20) long local20 = Static271.method3929() / 1000000L - Static206.aLong114;
        Static206.aLong114 = Static271.method3929() / 1000000L;
        @Pc(28) boolean local28 = Static576.method7611();
        if (local28 && Static501.aBoolean575 && Static719.aClass56_5 != null) {
            Static719.aClass56_5.method3592();
        }
        if (Static475.method6445(Static283.step)) {
            if (Static297.aLong153 != 0L && SystemTimer.safetime() > Static297.aLong153) {
                Static409.method5657(Static36.method978(3), Static560.anInt8429, false, Static433.anInt6258);
            } else if (!Static163.activeToolkit.method8001() && Static723.aBoolean827) {
                Static574.method7572();
            }
        }
        @Pc(110) int local110;
        @Pc(114) int local114;
        if (Static316.fsframe == null) {
            @Pc(98) Container local98;
            if (Static353.aFrame10 != null) {
                local98 = Static353.aFrame10;
            } else if (GameShell.loaderApplet == null) {
                local98 = Static149.anGameShell;
            } else {
                local98 = GameShell.loaderApplet;
            }
            local110 = local98.getSize().width;
            local114 = local98.getSize().height;
            if (local98 == Static353.aFrame10) {
                @Pc(120) Insets local120 = Static353.aFrame10.getInsets();
                local114 -= local120.bottom + local120.top;
                local110 -= local120.right + local120.left;
            }
            if (Static52.anInt1059 != local110 || local114 != Static54.anInt1084 || Static284.aBoolean355) {
                if (Static163.activeToolkit == null || Static163.activeToolkit.method7983()) {
                    Static712.method9329((byte) 11);
                } else {
                    Static52.anInt1059 = local110;
                    Static54.anInt1084 = local114;
                }
                Static297.aLong153 = SystemTimer.safetime() + 500L;
                Static284.aBoolean355 = false;
            }
        }
        if (Static316.fsframe != null && !Static91.aBoolean750 && Static475.method6445(Static283.step)) {
            Static409.method5657(Static400.instance.screenSize.getValue(), -1, false, -1);
        }
        @Pc(209) boolean local209 = false;
        if (Static664.aBoolean759) {
            local209 = true;
            Static664.aBoolean759 = false;
        }
        if (local209) {
            Static288.method4182();
        }
        if (Static163.activeToolkit != null && Static163.activeToolkit.method8001() || Static36.method978(3) != 1) {
            Static469.method6362();
        }
        if (Static181.method2778(Static283.step)) {
            Static523.method3447(local209);
        } else if (Static366.method5262(Static283.step)) {
            Static24.method680();
        } else if (Static384.method5393(Static283.step)) {
            Static24.method680();
        } else if (Static594.method7782(Static283.step)) {
            if (Static213.anInt3472 == 1) {
                if (Static593.anInt8763 > Static357.anInt6508) {
                    Static357.anInt6508 = Static593.anInt8763;
                }
                local110 = (Static357.anInt6508 - Static593.anInt8763) * 50 / Static357.anInt6508;
                Static694.method9028(Static163.activeToolkit, LocalisedText.LOADING.localise(Static51.anInt1052) + "<br>(" + local110 + "%)", true, Static694.aFontMetrics_13, Static437.aFont_9);
            } else if (Static213.anInt3472 == 2) {
                if (Static13.anInt150 > Static440.anInt6683) {
                    Static440.anInt6683 = Static13.anInt150;
                }
                local110 = (Static440.anInt6683 - Static13.anInt150) * 50 / Static440.anInt6683 + 50;
                Static694.method9028(Static163.activeToolkit, LocalisedText.LOADING.localise(Static51.anInt1052) + "<br>(" + local110 + "%)", true, Static694.aFontMetrics_13, Static437.aFont_9);
            } else {
                Static694.method9028(Static163.activeToolkit, LocalisedText.LOADING.localise(Static51.anInt1052), true, Static694.aFontMetrics_13, Static437.aFont_9);
            }
        } else if (Static283.step == 11) {
            Static686.method7930(local20);
        } else if (Static283.step == 14) {
            Static694.method9028(Static163.activeToolkit, LocalisedText.CONLOST.localise(Static51.anInt1052) + "<br>" + LocalisedText.ATTEMPTING_TO_REESTABLISH.localise(Static51.anInt1052), false, Static694.aFontMetrics_13, Static437.aFont_9);
        } else if (Static283.step == 15) {
            Static694.method9028(Static163.activeToolkit, LocalisedText.PLEASEWAIT.localise(Static51.anInt1052), false, Static694.aFontMetrics_13, Static437.aFont_9);
        }
        if (Static18.anInt251 == 3) {
            for (local110 = 0; local110 < Static122.anInt2339; local110++) {
                @Pc(478) Rectangle local478 = Node_Sub1_Sub28.aRectangleArray1[local110];
                if (Static359.aBooleanArray17[local110]) {
                    Static163.activeToolkit.method7945(local478.y, -65281, local478.width, local478.height, local478.x);
                } else if (Static469.aBooleanArray23[local110]) {
                    Static163.activeToolkit.method7945(local478.y, -65536, local478.width, local478.height, local478.x);
                } else {
                    Static163.activeToolkit.method7945(local478.y, -16711936, local478.width, local478.height, local478.x);
                }
            }
        }
        if (Static607.method8163()) {
            Static546.method7251(Static163.activeToolkit);
        }
        if (SignLink.instance.microsoftjava && Static475.method6445(Static283.step) && Static18.anInt251 == 0 && Static36.method978(3) == 1 && !local209) {
            local110 = 0;
            for (local114 = 0; local114 < Static122.anInt2339; local114++) {
                if (Static469.aBooleanArray23[local114]) {
                    Static469.aBooleanArray23[local114] = false;
                    Static663.aRectangleArray2[local110++] = Node_Sub1_Sub28.aRectangleArray1[local114];
                }
            }
            try {
                if (Static137.aBoolean210) {
                    Static700.method9148(local110, Static663.aRectangleArray2);
                } else {
                    Static163.activeToolkit.method8005(local110, Static663.aRectangleArray2);
                }
            } catch (@Pc(629) Exception_Sub1 local629) {
            }
        } else if (!Static181.method2778(Static283.step)) {
            for (local110 = 0; local110 < Static122.anInt2339; local110++) {
                Static469.aBooleanArray23[local110] = false;
            }
            try {
                if (Static137.aBoolean210) {
                    Static430.method5818();
                } else {
                    Static163.activeToolkit.method7984();
                }
            } catch (@Pc(666) Exception_Sub1 local666) {
                JagException.sendTrace(local666, local666.getMessage() + " (Recovered) " + this.method1648());
                Static32.method880(0, false);
            }
        }
        Static507.method6744();
        local110 = Static400.instance.aClass57_Sub21_1.method6360();
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
        if (Static400.instance.aClass57_Sub10_1.method3519() == 1 && Static283.step == 3 && Static377.anInt5930 != -1) {
            Static400.instance.method5104(0, Static400.instance.aClass57_Sub10_1);
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
        if (Static400.instance.aClass57_Sub29_1.method7915() != 2) {
            this.method1668();
            return;
        }
        try {
            this.method1668();
        } catch (@Pc(21) ThreadDeath local21) {
            throw local21;
        } catch (@Pc(24) Throwable local24) {
            JagException.sendTrace(local24, local24.getMessage() + " (Recovered) " + this.method1648());
            Static171.aBoolean245 = true;
            Static32.method880(0, false);
        }
    }

    @OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
    public void method1668() {
        if (Static283.step == 16) {
            return;
        }
        TimeUtils.clock++;
        if (TimeUtils.clock % 1000 == 1) {
            @Pc(27) GregorianCalendar local27 = new GregorianCalendar();
            Static178.anInt2947 = local27.get(11) * 600 + local27.get(12) * 10 + local27.get(13) / 6;
            Static493.aRandom1.setSeed((long) Static178.anInt2947);
        }
        Static405.A_SERVER_CONNECTION___2.recordStats();
        Static405.A_SERVER_CONNECTION___1.recordStats();
        this.tickJs5();
        if (Static228.js5MasterIndex != null) {
            Static228.js5MasterIndex.process();
        }
        Static601.method7865();
        Static236.method3453();
        Static334.aClass319_1.method8481();
        Static189.aClass120_1.method8841();
        if (Static163.activeToolkit != null) {
            Static163.activeToolkit.method7977((int) SystemTimer.safetime());
        }
        Static711.method9272();
        Static671.anInt10026 = 0;
        Static216.anInt3530 = 0;
        for (@Pc(94) Interface27 local94 = Static334.aClass319_1.method8478(); local94 != null; local94 = Static334.aClass319_1.method8478()) {
            @Pc(102) int local102 = local94.method2668();
            if (local102 == 2 || local102 == 3) {
                @Pc(118) char local118 = local94.method2666();
                if (Static647.method8468() && (local118 == '`' || local118 == '§' || local118 == '²')) {
                    if (Static607.method8163()) {
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
        Static611.anInt9341 = 0;
        for (@Pc(214) Node_Sub9 local214 = Static189.aClass120_1.method8851(); local214 != null; local214 = Static189.aClass120_1.method8851()) {
            @Pc(222) int local222 = local214.method5328();
            if (local222 == -1) {
                Static677.A_DEQUE___76.addLast(local214);
            } else if (local222 == 6) {
                Static611.anInt9341 += local214.method5332();
            } else if (Static278.method4070(local222)) {
                Static226.A_DEQUE___58.addLast(local214);
                if (Static226.A_DEQUE___58.size() > 10) {
                    Static226.A_DEQUE___58.removeFirst();
                }
            }
        }
        if (Static607.method8163()) {
            Static668.method8703();
        }
        if (Static181.method2778(Static283.step)) {
            Static709.method9252();
            Static199.method2977();
        } else if (Static594.method7782(Static283.step)) {
            Static489.method6548();
        }
        if (Static41.method1027(Static283.step) && !Static594.method7782(Static283.step)) {
            this.method1658();
            Static76.method1555();
            Static364.method5253();
        } else if (Static620.method8321(Static283.step) && !Static594.method7782(Static283.step)) {
            this.method1658();
            Static364.method5253();
        } else if (Static283.step == 13) {
            Static364.method5253();
        } else if (Static109.method2070(Static283.step) && !Static594.method7782(Static283.step)) {
            Static709.method9254();
        } else if (Static283.step == 14 || Static283.step == 15) {
            Static364.method5253();
            if (Static169.anInt2855 != -3 && Static169.anInt2855 != 2 && Static169.anInt2855 != 15) {
                if (Static283.step == 15) {
                    Static78.anInt1626 = Static169.anInt2855;
                    Static673.anInt10079 = Static356.anInt5780;
                    Static383.anInt6001 = Static329.anInt1749;
                    if (Static718.aBoolean823) {
                        Static430.method5817(Static459.aConnectionInfo_2.id, Static459.aConnectionInfo_2.address);
                        Static405.A_SERVER_CONNECTION___2.connection = null;
                        Static81.method1586(14);
                    } else {
                        Static233.method3409(Static461.aBoolean529);
                    }
                } else {
                    Static233.method3409(false);
                }
            }
        }
        Static369.method3851(Static163.activeToolkit);
        Static226.A_DEQUE___58.removeFirst();
    }

    @OriginalMember(owner = "client!client", name = "h", descriptor = "(I)V")
    @Override
    protected void method1647() {
        if (Static473.aBoolean539) {
            Static369.anInt4265 = 64;
        }
        @Pc(18) Frame local18 = new Frame("Jagex");
        local18.pack();
        local18.dispose();
        Static712.method9329((byte) 11);
        Static66.aCachedResourceWorker_1 = new CachedResourceWorker(SignLink.instance);
        js5WorkerThread = new Js5WorkerThread();
        Static545.method7241(new int[]{20, 260}, new int[]{1000, 100});
        if (Static446.aClass355_5 != Static2.aClass355_1) {
            Static163.aByteArrayArray36 = new byte[50][];
        }
        Static400.instance = Static720.method9398();
        if (Static2.aClass355_1 == Static446.aClass355_5) {
            Static527.aConnectionInfo_3.address = this.getCodeBase().getHost();
        } else if (Static179.method2769(Static2.aClass355_1)) {
            Static527.aConnectionInfo_3.address = this.getCodeBase().getHost();
            Static527.aConnectionInfo_3.defaultPort = Static527.aConnectionInfo_3.id + 40000;
            Static527.aConnectionInfo_3.alternatePort = Static527.aConnectionInfo_3.id + 50000;
            Static660.aConnectionInfo_4.defaultPort = Static660.aConnectionInfo_4.id + 40000;
            Static660.aConnectionInfo_4.alternatePort = Static660.aConnectionInfo_4.id + 50000;
        } else if (Static16.aClass355_2 == Static2.aClass355_1) {
            Static527.aConnectionInfo_3.address = "127.0.0.1";
            Static527.aConnectionInfo_3.defaultPort = Static527.aConnectionInfo_3.id + 40000;
            Static660.aConnectionInfo_4.address = "127.0.0.1";
            Static527.aConnectionInfo_3.alternatePort = Static527.aConnectionInfo_3.id + 50000;
            Static660.aConnectionInfo_4.defaultPort = Static660.aConnectionInfo_4.id + 40000;
            Static660.aConnectionInfo_4.alternatePort = Static660.aConnectionInfo_4.id + 50000;
        }
        gameConnection = Static527.aConnectionInfo_3;
        clientpalette = LocType.clientpalette = NPCType.clientpalette = ObjType.clientpalette = new short[256];
        if (Static392.aModeGame_4 == ModeGame.RUNESCAPE) {
            Static273.aBoolean340 = false;
        }
        try {
            Static175.aClipboard1 = aClient1.getToolkit().getSystemClipboard();
        } catch (@Pc(183) Exception local183) {
        }
        Static334.aClass319_1 = Static681.method8921(Static434.aCanvas7);
        Static189.aClass120_1 = Static70.method1513(Static434.aCanvas7);
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
        if (Static446.aClass355_5 != Static2.aClass355_1) {
            Static105.aBoolean196 = true;
        }
        Static484.aString85 = LocalisedText.LOADING.localise(Static51.anInt1052);
    }

    @OriginalMember(owner = "client!client", name = "a", descriptor = "(I)Ljava/lang/String;")
    @Override
    public String method1648() {
        @Pc(5) String local5 = null;
        try {
            local5 = "[1)" + Static691.anInt10367 + "," + Static116.anInt2270 + "," + Static720.mapWidth + "," + Static501.mapHeight + "|";
            if (Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2 != null) {
                local5 = local5 + "2)" + Static394.anInt6176 + "," + (Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.anIntArray879[0] + Static691.anInt10367) + "," + (Static116.anInt2270 + Static556.aClass8_Sub2_Sub1_Sub2_Sub1_2.anIntArray878[0]) + "|";
            }
            local5 = local5 + "3)" + Static400.instance.aClass57_Sub29_1.method7915() + "|4)" + Static400.instance.aClass57_Sub13_2.method4373() + "|5)" + Static36.method978(3) + "|6)" + Static680.anInt10289 + "," + Static380.anInt5979 + "|";
            local5 = local5 + "7)" + Static400.instance.lightDetail.getValue() + "|";
            local5 = local5 + "8)" + Static400.instance.aClass57_Sub12_1.method4364() + "|";
            local5 = local5 + "9)" + Static400.instance.aClass57_Sub26_1.method7463() + "|";
            local5 = local5 + "10)" + Static400.instance.textures.value() + "|";
            local5 = local5 + "11)" + Static400.instance.aClass57_Sub20_1.method6108() + "|";
            local5 = local5 + "12)" + Static400.instance.animatingBackground.value() + "|";
            local5 = local5 + "13)" + Static369.anInt4265 + "|";
            local5 = local5 + "14)" + Static283.step;
            if (Static292.aClass2_Sub43_2 != null) {
                local5 = local5 + "|15)" + Static292.aClass2_Sub43_2.anInt7610;
            }
            try {
                if (Static400.instance.aClass57_Sub29_1.method7915() == 2) {
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
                                    local5 = local5 + "|16)" + Long.toHexString(local369.getLong(local329));
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
            local5 = local5 + "]";
        } catch (@Pc(442) Throwable local442) {
        }
        return local5;
    }

    @OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
    @Override
    public void init() {
        if (!this.method1643()) {
            return;
        }
        Static527.aConnectionInfo_3 = new ConnectionInfo();
        Static527.aConnectionInfo_3.id = Integer.parseInt(this.getParameter("worldid"));
        Static660.aConnectionInfo_4 = new ConnectionInfo();
        Static660.aConnectionInfo_4.id = Integer.parseInt(this.getParameter("lobbyid"));
        Static660.aConnectionInfo_4.address = this.getParameter("lobbyaddress");
        Static2.aClass355_1 = Static463.method6279(Integer.parseInt(this.getParameter("modewhere")));
        if (Static16.aClass355_2 == Static2.aClass355_1) {
            Static2.aClass355_1 = Static425.aClass355_4;
        } else if (!Static179.method2769(Static2.aClass355_1) && Static446.aClass355_5 != Static2.aClass355_1) {
            Static2.aClass355_1 = Static446.aClass355_5;
        }
        Static598.aClass162_5 = Static624.method8329(Integer.parseInt(this.getParameter("modewhat")));
        if (Static225.aClass162_1 != Static598.aClass162_5 && Static598.aClass162_5 != Static519.aClass162_4 && Static523.aClass162_3 != Static598.aClass162_5) {
            Static598.aClass162_5 = Static523.aClass162_3;
        }
        try {
            Static51.anInt1052 = Integer.parseInt(this.getParameter("lang"));
        } catch (@Pc(110) Exception local110) {
            Static51.anInt1052 = 0;
        }
        @Pc(118) String local118 = this.getParameter("objecttag");
        if (local118 != null && local118.equals("1")) {
            Static464.aBoolean533 = true;
        } else {
            Static464.aBoolean533 = false;
        }
        @Pc(142) String local142 = this.getParameter("js");
        if (local142 != null && local142.equals("1")) {
            Static98.aBoolean191 = true;
        } else {
            Static98.aBoolean191 = false;
        }
        @Pc(166) String local166 = this.getParameter("advert");
        if (local166 != null && local166.equals("1")) {
            Static305.aBoolean372 = true;
        } else {
            Static305.aBoolean372 = false;
        }
        @Pc(190) String local190 = this.getParameter("game");
        if (local190 != null) {
            if (local190.equals("0")) {
                Static392.aModeGame_4 = ModeGame.RUNESCAPE;
            } else if (local190.equals("1")) {
                Static392.aModeGame_4 = ModeGame.STELLAR_DAWN;
            } else if (local190.equals("2")) {
                Static392.aModeGame_4 = ModeGame.GAME3;
            } else if (local190.equals("3")) {
                Static392.aModeGame_4 = ModeGame.GAME4;
            }
        }
        try {
            Static323.anInt5121 = Integer.parseInt(this.getParameter("affid"));
        } catch (@Pc(247) Exception local247) {
            Static323.anInt5121 = 0;
        }
        Static360.aString59 = this.getParameter("quiturl");
        Static150.aString26 = this.getParameter("settings");
        if (Static150.aString26 == null) {
            Static150.aString26 = "";
        }
        Static477.aBoolean543 = "1".equals(this.getParameter("under"));
        @Pc(281) String local281 = this.getParameter("country");
        if (local281 != null) {
            try {
                Static584.anInt8634 = Integer.parseInt(local281);
            } catch (@Pc(288) Exception local288) {
                Static584.anInt8634 = 0;
            }
        }
        Static338.anInt5562 = Integer.parseInt(this.getParameter("colourid"));
        if (Static338.anInt5562 < 0 || Static718.aColorArray3.length <= Static338.anInt5562) {
            Static338.anInt5562 = 0;
        }
        if (Integer.parseInt(this.getParameter("sitesettings_member")) == 1) {
            Static508.aBoolean582 = true;
            Static126.aBoolean200 = true;
        }
        @Pc(336) String local336 = this.getParameter("frombilling");
        if (local336 != null && local336.equals("true")) {
            Static29.aBoolean61 = true;
        }
        @Pc(356) String local356 = this.getParameter("sskey");
        if (local356 != null) {
            Static265.aByteArray44 = Static107.method2054(Static713.method9333(local356));
            if (Static265.aByteArray44.length < 16) {
                Static265.aByteArray44 = null;
            }
        }
        @Pc(382) String local382 = this.getParameter("force64mb");
        if (local382 != null && local382.equals("true")) {
            Static473.aBoolean539 = true;
        }
        @Pc(402) String local402 = this.getParameter("worldflags");
        if (local402 != null) {
            try {
                Static715.anInt10805 = Integer.parseInt(local402);
            } catch (@Pc(409) Exception local409) {
            }
        }
        @Pc(416) String local416 = this.getParameter("userFlow");
        if (local416 != null) {
            try {
                Static416.aLong208 = Long.parseLong(local416);
            } catch (@Pc(424) NumberFormatException local424) {
            }
        }
        Static389.aString64 = this.getParameter("additionalInfo");
        if (Static389.aString64 != null && Static389.aString64.length() > 50) {
            Static389.aString64 = null;
        }
        if (ModeGame.RUNESCAPE == Static392.aModeGame_4) {
            Static302.anInt4851 = 765;
            Static479.anInt7201 = 503;
        } else if (Static392.aModeGame_4 == ModeGame.STELLAR_DAWN) {
            Static479.anInt7201 = 480;
            Static302.anInt4851 = 640;
        }
        @Pc(473) String local473 = this.getParameter("hc");
        if (local473 != null && local473.equals("1")) {
            Static416.aBoolean473 = true;
        }
        aClient1 = this;
        this.method1640(Static302.anInt4851, Static598.aClass162_5.method3469() + 32, Static392.aModeGame_4.domainName, Static479.anInt7201);
    }

    @OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
    @Override
    protected void method1650() {
        if (Static400.instance.aClass57_Sub29_1.method7915() != 2) {
            this.method1666();
            return;
        }
        try {
            this.method1666();
        } catch (@Pc(21) ThreadDeath local21) {
            throw local21;
        } catch (@Pc(24) Throwable local24) {
            JagException.sendTrace(local24, local24.getMessage() + " (Recovered) " + this.method1648());
            Static171.aBoolean245 = true;
            Static32.method880(0, false);
        }
    }
}
