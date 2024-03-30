import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mga")
public final class FriendChatUser {

    @OriginalMember(owner = "client!mga", name = "a", descriptor = "B")
    public byte rank;

    @OriginalMember(owner = "client!mga", name = "d", descriptor = "Ljava/lang/String;")
    public String worldName;

    @OriginalMember(owner = "client!mga", name = "b", descriptor = "I")
    public int world;

    @OriginalMember(owner = "client!mga", name = "e", descriptor = "Ljava/lang/String;")
    public String usernameUnfiltered;

    @OriginalMember(owner = "client!mga", name = "c", descriptor = "Ljava/lang/String;")
    public String name;

    @OriginalMember(owner = "client!mga", name = "f", descriptor = "Ljava/lang/String;")
    public String usernameFormatted;
}
