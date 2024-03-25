import org.openrs2.deob.annotation.OriginalMember;

public final class FriendsList {

    @OriginalMember(owner = "client!kha", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] names = new String[200];

    @OriginalMember(owner = "client!lma", name = "a", descriptor = "[I")
    public static final int[] worlds = new int[200];

    @OriginalMember(owner = "client!kg", name = "N", descriptor = "I")
    public static int count = 0;
}
