import org.openrs2.deob.annotation.OriginalMember;

public final class PlayerList {
    @OriginalMember(owner = "client!tl", name = "f", descriptor = "[Lclient!ca;")
    public static final PlayerEntity[] highResolutionPlayers = new PlayerEntity[2048];

    @OriginalMember(owner = "client!jt", name = "g", descriptor = "I")
    public static int activePlayerSlot = -1;

    private PlayerList() {
        /* empty */
    }
}
