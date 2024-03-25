import org.openrs2.deob.annotation.OriginalMember;

public final class FriendChat {
    @OriginalMember(owner = "client!wfa", name = "T", descriptor = "I")
    public static int count;

    @OriginalMember(owner = "client!cn", name = "i", descriptor = "[Lclient!mga;")
    public static FriendChatUser[] users;
}
