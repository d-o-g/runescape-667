import com.jagex.core.constants.MainLogicStep;
import com.jagex.core.io.connection.Connection;
import org.openrs2.deob.annotation.OriginalMember;

public final class ConnectionManager {

    @OriginalMember(owner = "client!oo", name = "q", descriptor = "Lclient!vn;")
    public static Connection reconnect;

    @OriginalMember(owner = "client!lm", name = "b", descriptor = "(Z)V")
    public static void disconnect() {
        if (MainLogicStep.isAtLobbyScreen(MainLogicManager.step)) {
            LoginManager.logout(false);
        } else {
            reconnect = ServerConnection.GAME.connection;
            ServerConnection.GAME.connection = null;
            MainLogicManager.setStep(14);
        }
    }

    @OriginalMember(owner = "client!vca", name = "a", descriptor = "(B)Lclient!gw;")
    public static ServerConnection active() {
        return MainLogicStep.isAtLobbyScreen(MainLogicManager.step) ? ServerConnection.LOBBY : ServerConnection.GAME;
    }
}
