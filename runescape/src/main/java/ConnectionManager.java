import org.openrs2.deob.annotation.OriginalMember;

public final class ConnectionManager {
    @OriginalMember(owner = "client!mn", name = "q", descriptor = "Lclient!gw;")
    public static final ServerConnection GAME = new ServerConnection();

    @OriginalMember(owner = "client!mn", name = "k", descriptor = "Lclient!gw;")
    public static final ServerConnection LOBBY = new ServerConnection();
}
