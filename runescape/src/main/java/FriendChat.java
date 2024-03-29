import com.jagex.ClientProt;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

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

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void kick(@OriginalArg(1) String arg0) {
        if (users == null) {
            return;
        }
        @Pc(21) ServerConnection local21 = ConnectionManager.active();
        @Pc(27) ClientMessage local27 = ClientMessage.create(ClientProt.CLAN_KICKUSER, local21.cipher);
        local27.bitPacket.p1(Packet.pjstrlen(arg0));
        local27.bitPacket.pjstr(arg0);
        local21.send(local27);
    }

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void join(@OriginalArg(1) String arg0) {
        if (arg0.equals("")) {
            return;
        }
        @Pc(16) ServerConnection local16 = ConnectionManager.active();
        @Pc(29) ClientMessage local29 = ClientMessage.create(ClientProt.FRIENDS_CHAT_CHANGE, local16.cipher);
        local29.bitPacket.p1(Packet.pjstrlen(arg0));
        local29.bitPacket.pjstr(arg0);
        local16.send(local29);
    }

    @OriginalMember(owner = "client!mi", name = "a", descriptor = "(I)V")
    public static void leave() {
        @Pc(10) ServerConnection local10 = ConnectionManager.active();
        @Pc(18) ClientMessage local18 = ClientMessage.create(ClientProt.FRIENDS_CHAT_CHANGE, local10.cipher);
        local18.bitPacket.p1(0);
        local10.send(local18);
    }
}
