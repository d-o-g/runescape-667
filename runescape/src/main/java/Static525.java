import com.jagex.ClientProt;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.clan.channel.ClanChannel;
import rs2.client.clan.channel.ClanChannelUser;

public final class Static525 {

    @OriginalMember(owner = "client!qja", name = "p", descriptor = "I")
    public static int areaCenterZ;

    @OriginalMember(owner = "client!qja", name = "a", descriptor = "(IZI)V")
    public static void kick(@OriginalArg(2) int index, @OriginalArg(1) boolean affined) {
        @Pc(17) ClanChannel local17 = affined ? ClanChannel.affined : ClanChannel.listened;
        if (local17 == null || index < 0 || local17.userCount <= index) {
            return;
        }
        @Pc(43) ClanChannelUser local43 = local17.users[index];
        if (local43.rank != -1) {
            return;
        }
        @Pc(53) String local53 = local43.displayName;
        @Pc(56) ServerConnection local56 = ConnectionManager.active();
        @Pc(62) ClientMessage local62 = ClientMessage.create(ClientProt.CLANCHANNEL_KICKUSER, local56.isaac);
        local62.bitPacket.p1(Packet.pjstrlen(local53) + 3);
        local62.bitPacket.p1(affined ? 1 : 0);
        local62.bitPacket.p2(index);
        local62.bitPacket.pjstr(local53);
        local56.send(local62);
    }
}
