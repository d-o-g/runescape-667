import org.openrs2.deob.annotation.OriginalMember;

public final class FriendChat {
    @OriginalMember(owner = "client!wfa", name = "T", descriptor = "I")
    public static int count;

    @OriginalMember(owner = "client!cn", name = "i", descriptor = "[Lclient!mga;")
    public static FriendChatUser[] users;

    @OriginalMember(owner = "client!vka", name = "h", descriptor = "B")
    public static byte rank;

    @OriginalMember(owner = "client!ev", name = "b", descriptor = "Ljava/lang/String;")
    public static String owner = null;

    @OriginalMember(owner = "client!wu", name = "z", descriptor = "Ljava/lang/String;")
    public static String name = null;

    @OriginalMember(owner = "client!vf", name = "I", descriptor = "B")
    public static byte kickRank;
}
