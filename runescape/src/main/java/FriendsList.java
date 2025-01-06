import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.core.datastruct.LinkedList;
import com.jagex.core.io.Packet;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.game.LocalisedText;
import com.jagex.game.world.World;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class FriendsList {

    @OriginalMember(owner = "client!kha", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] names = new String[200];

    @OriginalMember(owner = "client!lma", name = "a", descriptor = "[I")
    public static final int[] worlds = new int[200];

    @OriginalMember(owner = "client!fda", name = "c", descriptor = "Lclient!fla;")
    public static final LinkedList notifications = new LinkedList();

    @OriginalMember(owner = "client!s", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] formerNames = new String[200];

    @OriginalMember(owner = "client!ne", name = "u", descriptor = "[Ljava/lang/String;")
    public static final String[] worldNames = new String[200];

    @OriginalMember(owner = "client!wla", name = "p", descriptor = "[I")
    public static final int[] ranks = new int[200];

    @OriginalMember(owner = "client!tm", name = "a", descriptor = "[Z")
    public static final boolean[] sameGameFlags = new boolean[200];

    @OriginalMember(owner = "client!nj", name = "g", descriptor = "[Z")
    public static final boolean[] referredFlags = new boolean[200];

    @OriginalMember(owner = "client!kg", name = "N", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!kr", name = "o", descriptor = "I")
    public static int lastTransmit = 0;

    @OriginalMember(owner = "client!ho", name = "l", descriptor = "I")
    public static int status = 0;

    @OriginalMember(owner = "client!lha", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean contains(@OriginalArg(0) int start, @OriginalArg(1) String name) {
        if (name == null) {
            return false;
        }
        for (@Pc(10) int i = start; i < count; i++) {
            if (name.equalsIgnoreCase(names[i])) {
                return true;
            }
        }
        return name.equalsIgnoreCase(PlayerEntity.self.nameUnfiltered);
    }

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(Ljava/lang/String;II)V")
    public static void setRank(@OriginalArg(0) String name, @OriginalArg(2) int rank) {
        @Pc(10) ServerConnection connection = ConnectionManager.active();
        @Pc(16) ClientMessage message = ClientMessage.create(ClientProt.FRIEND_SETRANK, connection.isaac);
        message.bitPacket.p1(Packet.pjstrlen(name) + 1);
        message.bitPacket.pjstr(name);
        message.bitPacket.p1_alt2(rank);
        connection.send(message);
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(Ljava/lang/String;Z)V")
    public static void add(@OriginalArg(0) String arg0) {
        if (arg0 == null) {
            return;
        }
        if (count >= 200 && !Client.isMember || count >= 200) {
            ChatHistory.addPrivateError(LocalisedText.FRIENDLIST_FULL.localise(Client.language));
            return;
        }
        @Pc(34) String local34 = NameTools.format(arg0);
        if (local34 == null) {
            return;
        }
        @Pc(81) String local81;
        for (@Pc(40) int local40 = 0; local40 < count; local40++) {
            @Pc(47) String local47 = NameTools.format(names[local40]);
            if (local47 != null && local47.equals(local34)) {
                ChatHistory.addPrivateError(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Client.language));
                return;
            }
            if (formerNames[local40] != null) {
                local81 = NameTools.format(formerNames[local40]);
                if (local81 != null && local81.equals(local34)) {
                    ChatHistory.addPrivateError(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Client.language));
                    return;
                }
            }
        }
        for (@Pc(115) int local115 = 0; local115 < IgnoreList.count; local115++) {
            local81 = NameTools.format(IgnoreList.names[local115]);
            if (local81 != null && local81.equals(local34)) {
                ChatHistory.addPrivateError(LocalisedText.REMOVEIGNORE1.localise(Client.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Client.language));
                return;
            }
            if (IgnoreList.formerNames[local115] != null) {
                @Pc(161) String local161 = NameTools.format(IgnoreList.formerNames[local115]);
                if (local161 != null && local161.equals(local34)) {
                    ChatHistory.addPrivateError(LocalisedText.REMOVEIGNORE1.localise(Client.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Client.language));
                    return;
                }
            }
        }
        if (NameTools.format(PlayerEntity.self.nameUnfiltered).equals(local34)) {
            ChatHistory.addPrivateError(LocalisedText.FRIENDCANTADDSELF.localise(Client.language));
            return;
        }
        @Pc(230) ServerConnection local230 = ConnectionManager.active();
        @Pc(236) ClientMessage local236 = ClientMessage.create(ClientProt.FRIENDLIST_ADD, local230.isaac);
        local236.bitPacket.p1(Packet.pjstrlen(arg0));
        local236.bitPacket.pjstr(arg0);
        local230.send(local236);
    }

    @OriginalMember(owner = "client!rca", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void delete(@OriginalArg(1) String arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(11) String local11 = NameTools.format(arg0);
        if (local11 == null) {
            return;
        }
        for (@Pc(22) int local22 = 0; local22 < count; local22++) {
            @Pc(27) String local27 = names[local22];
            @Pc(31) String local31 = NameTools.format(local27);
            if (Static585.method7682(arg0, local31, local27, local11)) {
                count--;
                for (@Pc(44) int local44 = local22; local44 < count; local44++) {
                    names[local44] = names[local44 + 1];
                    formerNames[local44] = formerNames[local44 + 1];
                    worlds[local44] = worlds[local44 + 1];
                    worldNames[local44] = worldNames[local44 + 1];
                    ranks[local44] = ranks[local44 + 1];
                    sameGameFlags[local44] = sameGameFlags[local44 + 1];
                    referredFlags[local44] = referredFlags[local44 + 1];
                }
                lastTransmit = World.tick;
                @Pc(118) ServerConnection local118 = ConnectionManager.active();
                @Pc(124) ClientMessage local124 = ClientMessage.create(ClientProt.FRIENDLIST_DEL, local118.isaac);
                local124.bitPacket.p1(Packet.pjstrlen(arg0));
                local124.bitPacket.pjstr(arg0);
                local118.send(local124);
                return;
            }
        }
    }
}
