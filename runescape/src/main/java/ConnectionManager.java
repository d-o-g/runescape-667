import com.jagex.core.io.connection.Connection;
import org.openrs2.deob.annotation.OriginalMember;

public final class ConnectionManager {
    @OriginalMember(owner = "client!mn", name = "q", descriptor = "Lclient!gw;")
    public static final ServerConnection GAME = new ServerConnection();

    @OriginalMember(owner = "client!mn", name = "k", descriptor = "Lclient!gw;")
    public static final ServerConnection LOBBY = new ServerConnection();

    @OriginalMember(owner = "client!oo", name = "q", descriptor = "Lclient!vn;")
    public static Connection reconnect;

    @OriginalMember(owner = "client!lm", name = "b", descriptor = "(Z)V")
    public static void disconnect() {
        if (MainLogicManager.isAtLobbyScreen(MainLogicManager.step)) {
            Login.logout(false);
        } else {
            reconnect = GAME.connection;
            GAME.connection = null;
            MainLogicManager.setStep(14);
        }
    }
}
