import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MainLogicManager {
    @OriginalMember(owner = "client!it", name = "g", descriptor = "I")
    public static int step = 0;

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "(BI)Z")
    public static boolean isAtLobbyScreen(@OriginalArg(1) int arg0) {
        return arg0 == 7 || arg0 == 8 || arg0 == 9 || arg0 == 10;
    }

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(IB)V")
    public static void setStep(@OriginalArg(0) int arg0) {
        if (step == arg0) {
            return;
        }
        if (arg0 == 14 || arg0 == 15) {
            Static670.method8735();
        }
        if (arg0 != 14 && ConnectionManager.reconnect != null) {
            ConnectionManager.reconnect.close();
            ConnectionManager.reconnect = null;
        }
        if (arg0 == 3) {
            InterfaceManager.openLogin(Static523.graphicsDefaults.login_interface != InterfaceManager.topLevelInterface);
        }
        if (arg0 == 7) {
            InterfaceManager.openLobby(Static523.graphicsDefaults.lobby_interface != InterfaceManager.topLevelInterface);
        }
        if (arg0 == 5 || arg0 == 13) {
            Static369.method3852();
        } else if (arg0 == 6 || arg0 == 9 && step != 10) {
            Static670.method8735();
        }
        if (isBuildingMap(step)) {
            js5.CONFIG.discardunpacked = 2;
            js5.CONFIG_ENUM.discardunpacked = 2;
            js5.CONFIG_LOC.discardunpacked = 2;
            js5.CONFIG_NPC.discardunpacked = 2;
            js5.CONFIG_OBJ.discardunpacked = 2;
            js5.CONFIG_SEQ.discardunpacked = 2;
            js5.CONFIG_SPOT.discardunpacked = 2;
        }
        if (isBuildingMap(arg0)) {
            Static593.anInt8763 = 0;
            Static357.anInt6508 = 1;
            Static440.anInt6683 = 1;
            Static213.anInt3472 = 0;
            Static13.anInt150 = 0;
            Static668.method8700(true);
            js5.CONFIG.discardunpacked = 1;
            js5.CONFIG_ENUM.discardunpacked = 1;
            js5.CONFIG_LOC.discardunpacked = 1;
            js5.CONFIG_NPC.discardunpacked = 1;
            js5.CONFIG_OBJ.discardunpacked = 1;
            js5.CONFIG_SEQ.discardunpacked = 1;
            js5.CONFIG_SPOT.discardunpacked = 1;
        }
        if (arg0 == 12 || arg0 == 3) {
            Static314.method4562();
        }
        @Pc(213) boolean local213 = arg0 == 2 || Static41.method1027(arg0) || isAtLobbyScreen(arg0);
        @Pc(235) boolean local235 = step == 2 || Static41.method1027(step) || isAtLobbyScreen(step);
        if (local235 != local213) {
            if (local213) {
                Static588.anInt8692 = Static597.anInt8821;
                if (ClientOptions.instance.loginVolume.getValue() == 0) {
                    Static312.method4541();
                } else {
                    Static57.method1225(Static597.anInt8821, ClientOptions.instance.loginVolume.getValue(), js5.MIDI_SONGS);
                    Static550.method7266();
                }
                client.js5WorkerThread.writeLoggedIn(false);
            } else {
                Static312.method4541();
                client.js5WorkerThread.writeLoggedIn(true);
            }
        }
        if (isBuildingMap(arg0) || arg0 == 14 || arg0 == 15) {
            Toolkit.active.method7969();
        }
        step = arg0;
    }

    @OriginalMember(owner = "client!dh", name = "b", descriptor = "(II)Z")
    public static boolean isAtGameScreen(@OriginalArg(0) int arg0) {
        return arg0 == 11 || arg0 == 12 || arg0 == 13;
    }

    @OriginalMember(owner = "client!fl", name = "a", descriptor = "(II)Z")
    public static boolean isLoading(@OriginalArg(0) int arg0) {
        return arg0 == 0 || arg0 == 1 || arg0 == 2;
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(II)Z")
    public static boolean isAtLoadingScreen(@OriginalArg(0) int arg0) {
        return arg0 == 3 || arg0 == 5 || arg0 == 6;
    }

    @OriginalMember(owner = "client!maa", name = "a", descriptor = "(IB)Z")
    public static boolean method5393(@OriginalArg(0) int arg0) {
        return arg0 == 7 || arg0 == 9;
    }

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(II)Z")
    public static boolean isBuildingMap(@OriginalArg(0) int arg0) {
        return arg0 == 4 || arg0 == 8 || arg0 == 12 || arg0 == 10;
    }
}
