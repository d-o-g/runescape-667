import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.game.LocalisedText;
import com.jagex.game.world.World;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class IgnoreList {

    @OriginalMember(owner = "client!oaa", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] namesUnfiltered = new String[100];

    @OriginalMember(owner = "client!ka", name = "h", descriptor = "[Ljava/lang/String;")
    public static final String[] formerNamesUnfiltered = new String[100];

    @OriginalMember(owner = "client!u", name = "l", descriptor = "[Ljava/lang/String;")
    public static final String[] names = new String[100];

    @OriginalMember(owner = "client!afa", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] formerNames = new String[100];

    @OriginalMember(owner = "client!cba", name = "D", descriptor = "[Z")
    public static final boolean[] temporary = new boolean[100];

    @OriginalMember(owner = "client!no", name = "c", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!cea", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean contains(@OriginalArg(1) String name) {
        if (name == null) {
            return false;
        }

        for (@Pc(16) int i = 0; i < count; i++) {
            if (name.equalsIgnoreCase(namesUnfiltered[i])) {
                return true;
            }
            if (name.equalsIgnoreCase(formerNamesUnfiltered[i])) {
                return true;
            }
        }

        return false;
    }

    private IgnoreList() {
        /* empty */
    }

    @OriginalMember(owner = "client!hd", name = "a", descriptor = "(ZLjava/lang/String;B)V")
    public static void add(@OriginalArg(1) String name, @OriginalArg(0) boolean temporary) {
        if (name == null) {
            return;
        }
        if (count >= 100) {
            ChatHistory.addPrivateError(LocalisedText.IGNORELISTFULL.localise(Client.language));
            return;
        }
        @Pc(27) String local27 = NameTools.format(name);
        if (local27 == null) {
            return;
        }

        @Pc(76) String local76;
        for (@Pc(33) int local33 = 0; local33 < count; local33++) {
            @Pc(40) String local40 = NameTools.format(names[local33]);
            if (local40 != null && local40.equals(local27)) {
                ChatHistory.addPrivateError(name + LocalisedText.IGNORELISTDUPE.localise(Client.language));
                return;
            }
            if (formerNames[local33] != null) {
                local76 = NameTools.format(formerNames[local33]);
                if (local76 != null && local76.equals(local27)) {
                    ChatHistory.addPrivateError(name + LocalisedText.IGNORELISTDUPE.localise(Client.language));
                    return;
                }
            }
        }
        for (@Pc(106) int local106 = 0; local106 < FriendsList.count; local106++) {
            local76 = NameTools.format(FriendsList.names[local106]);
            if (local76 != null && local76.equals(local27)) {
                ChatHistory.addPrivateError(LocalisedText.REMOVEFRIEND1.localise(Client.language) + name + LocalisedText.REMOVEFRIEND2.localise(Client.language));
                return;
            }
            if (FriendsList.formerNames[local106] != null) {
                @Pc(154) String local154 = NameTools.format(FriendsList.formerNames[local106]);
                if (local154 != null && local154.equals(local27)) {
                    ChatHistory.addPrivateError(LocalisedText.REMOVEFRIEND1.localise(Client.language) + name + LocalisedText.REMOVEFRIEND2.localise(Client.language));
                    return;
                }
            }
        }
        if (NameTools.format(PlayerEntity.self.nameUnfiltered).equals(local27)) {
            ChatHistory.addPrivateError(LocalisedText.IGNORECANTADDSELF.localise(Client.language));
            return;
        }
        @Pc(216) ServerConnection local216 = ConnectionManager.active();
        @Pc(222) ClientMessage local222 = ClientMessage.create(ClientProt.IGNORELIST_ADD, local216.isaac);
        local222.bitPacket.p1(Packet.pjstrlen(name) + 1);
        local222.bitPacket.pjstr(name);
        local222.bitPacket.p1(temporary ? 1 : 0);
        local216.send(local222);
    }

    @OriginalMember(owner = "client!za", name = "a", descriptor = "(Ljava/lang/String;Z)V")
    public static void delete(@OriginalArg(0) String arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(11) String local11 = NameTools.format(arg0);
        if (local11 == null) {
            return;
        }
        for (@Pc(25) int local25 = 0; local25 < count; local25++) {
            @Pc(30) String local30 = names[local25];
            @Pc(34) String local34 = NameTools.format(local30);
            if (Static585.method7682(arg0, local34, local30, local11)) {
                count--;
                for (@Pc(47) int local47 = local25; local47 < count; local47++) {
                    names[local47] = names[local47 + 1];
                    namesUnfiltered[local47] = namesUnfiltered[local47 + 1];
                    formerNames[local47] = formerNames[local47 + 1];
                    formerNamesUnfiltered[local47] = formerNamesUnfiltered[local47 + 1];
                    temporary[local47] = temporary[local47 + 1];
                }
                FriendsList.lastTransmit = World.tick;
                @Pc(101) ServerConnection local101 = ConnectionManager.active();
                @Pc(107) ClientMessage local107 = ClientMessage.create(ClientProt.IGNORELIST_DEL, local101.isaac);
                local107.bitPacket.p1(Packet.pjstrlen(arg0));
                local107.bitPacket.pjstr(arg0);
                local101.send(local107);
                return;
            }
        }
    }
}
