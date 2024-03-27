import com.jagex.Client;
import com.jagex.game.runetek6.config.defaults.GraphicsDefaults;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class MainLogicManager {
    public static final int STEP_LOADING = 0;
    public static final int STEP_LOADING_1 = 1;
    public static final int STEP_LOADING_2 = 2;
    public static final int STEP_LOGIN_SCREEN = 3;
    public static final int STEP_LOGIN_SCREEN_MAP_BUILD = 4;
    public static final int STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_LOBBY = 5;
    public static final int STEP_LOGGING_IN_FROM_LOGINSCREEN_TO_GAME = 6;
    public static final int STEP_LOBBY_SCREEN = 7;
    public static final int STEP_LOBBY_SCREEN_MAP_BUILD = 8;
    public static final int STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME = 9;
    public static final int STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME_MAP_BUILD = 10;
    public static final int STEP_GAME_SCREEN = 11;
    public static final int STEP_GAME_SCREEN_MAP_BUILD = 12;
    public static final int STEP_LOGGING_IN_FROM_GAMESCREEN_TO_LOBBY = 13;
    public static final int STEP_RECONNECTING = 14;
    public static final int STEP_SWITCH_WORLD = 15;
    public static final int STEP_ERROR = 16;

    @OriginalMember(owner = "client!it", name = "g", descriptor = "I")
    public static int step = 0;

    @OriginalMember(owner = "client!tka", name = "a", descriptor = "(BI)Z")
    public static boolean isAtLobbyScreen(@OriginalArg(1) int step) {
        return step == STEP_LOBBY_SCREEN
            || step == STEP_LOBBY_SCREEN_MAP_BUILD
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME
            || step == STEP_LOGGING_IN_FROM_LOBBYSCREEN_TO_GAME_MAP_BUILD;
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
            InterfaceManager.openLogin(GraphicsDefaults.instance.login_interface != InterfaceManager.topLevelInterface);
        }
        if (arg0 == 7) {
            InterfaceManager.openLobby(GraphicsDefaults.instance.lobby_interface != InterfaceManager.topLevelInterface);
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
            WorldMap.reset(true);
            js5.CONFIG.discardunpacked = 1;
            js5.CONFIG_ENUM.discardunpacked = 1;
            js5.CONFIG_LOC.discardunpacked = 1;
            js5.CONFIG_NPC.discardunpacked = 1;
            js5.CONFIG_OBJ.discardunpacked = 1;
            js5.CONFIG_SEQ.discardunpacked = 1;
            js5.CONFIG_SPOT.discardunpacked = 1;
        }
        if (arg0 == 12 || arg0 == 3) {
            Static314.tbrefresh();
        }
        @Pc(213) boolean local213 = arg0 == 2 || Static41.method1027(arg0) || isAtLobbyScreen(arg0);
        @Pc(235) boolean local235 = step == 2 || Static41.method1027(step) || isAtLobbyScreen(step);
        if (local235 != local213) {
            if (local213) {
                SoundManager.midiSong = Static597.anInt8821;
                if (ClientOptions.instance.loginVolume.getValue() == 0) {
                    Static312.method4541();
                } else {
                    Static57.method1225(Static597.anInt8821, ClientOptions.instance.loginVolume.getValue(), js5.MIDI_SONGS);
                    SoundManager.mixBussReset();
                }
                Client.js5WorkerThread.writeLoggedIn(false);
            } else {
                Static312.method4541();
                Client.js5WorkerThread.writeLoggedIn(true);
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

    @OriginalMember(owner = "client!od", name = "b", descriptor = "(I)V")
    public static void mapBuild() {
        if (step == 3) {
            setStep(4);
        } else if (step == 7) {
            setStep(8);
        } else if (step == 9) {
            setStep(10);
        } else if (step == 11) {
            setStep(12);
        }
    }

    @OriginalMember(owner = "client!rp", name = "b", descriptor = "(B)V")
    public static void method7465() {
        if (Static656.method6691(step)) {
            if (ServerConnection.LOBBY.connection == null) {
                setStep(5);
            } else {
                setStep(7);
            }
        } else if (step == 5 || step == 6) {
            setStep(3);
        } else if (step == 13) {
            setStep(3);
        }
    }
}
