import org.openrs2.deob.annotation.OriginalMember;

public final class LobbyManager {

    @OriginalMember(owner = "client!ad", name = "a", descriptor = "I")
    public static int step = 0;

    private LobbyManager() {
        /* empty */
    }
}
