import org.openrs2.deob.annotation.OriginalMember;

public final class UserDetail {
    @OriginalMember(owner = "client!md", name = "K", descriptor = "Z")
    public static boolean underage = false;

    @OriginalMember(owner = "client!bca", name = "c", descriptor = "Z")
    public static boolean parentalChatConsent = false;

    @OriginalMember(owner = "client!nh", name = "a", descriptor = "Z")
    public static boolean activeSubscription;

    @OriginalMember(owner = "client!vi", name = "F", descriptor = "I")
    public static int lobbyRecoveryDay;

    @OriginalMember(owner = "client!paa", name = "h", descriptor = "I")
    public static int lobbyUnreadMessages;

    @OriginalMember(owner = "client!kda", name = "f", descriptor = "I")
    public static int lobbyLastLoginDay;

    @OriginalMember(owner = "client!mf", name = "a", descriptor = "I")
    public static int lastLoginAddress;

    @OriginalMember(owner = "client!kk", name = "k", descriptor = "I")
    public static int lobbyEmailStatus;

    @OriginalMember(owner = "client!tq", name = "a", descriptor = "I")
    public static int lobbyCCExpiry;

    @OriginalMember(owner = "client!uba", name = "b", descriptor = "I")
    public static int lobbyGraceExpiry;

    @OriginalMember(owner = "client!nea", name = "f", descriptor = "Z")
    public static boolean lobbyDOBRequested;

    @OriginalMember(owner = "client!dfa", name = "e", descriptor = "I")
    public static int dob;

    @OriginalMember(owner = "client!ud", name = "J", descriptor = "I")
    public static int lobbyMembersStats;

    @OriginalMember(owner = "client!nq", name = "f", descriptor = "I")
    public static int lobbyPlayAge;

    @OriginalMember(owner = "client!nm", name = "r", descriptor = "I")
    public static int lobbyJcoinsBalance;

    @OriginalMember(owner = "client!vla", name = "k", descriptor = "Z")
    public static boolean lobbyLoyalty;

    @OriginalMember(owner = "client!eda", name = "e", descriptor = "I")
    public static int lobbyLoyaltyBalance;

    private UserDetail() {
        /* empty */
    }
}
