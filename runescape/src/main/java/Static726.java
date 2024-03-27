import com.jagex.ClientProt;
import com.jagex.PrivateChatMode;
import com.jagex.core.stringtools.general.NameTools;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static726 {

    @OriginalMember(owner = "client!za", name = "k", descriptor = "Lclient!om;")
    public static PrivateChatMode privateChatMode;

    @OriginalMember(owner = "client!za", name = "a", descriptor = "(Ljava/lang/String;Z)V")
    public static void method9463(@OriginalArg(0) String arg0) {
        if (arg0 == null) {
            return;
        }
        @Pc(11) String local11 = NameTools.format(arg0);
        if (local11 == null) {
            return;
        }
        for (@Pc(25) int local25 = 0; local25 < IgnoreList.count; local25++) {
            @Pc(30) String local30 = IgnoreList.names[local25];
            @Pc(34) String local34 = NameTools.format(local30);
            if (Static585.method7682(arg0, local34, local30, local11)) {
                IgnoreList.count--;
                for (@Pc(47) int local47 = local25; local47 < IgnoreList.count; local47++) {
                    IgnoreList.names[local47] = IgnoreList.names[local47 + 1];
                    IgnoreList.accountNames[local47] = IgnoreList.accountNames[local47 + 1];
                    IgnoreList.formerNames[local47] = IgnoreList.formerNames[local47 + 1];
                    IgnoreList.formerAccountNames[local47] = IgnoreList.formerAccountNames[local47 + 1];
                    IgnoreList.temporary[local47] = IgnoreList.temporary[local47 + 1];
                }
                FriendsList.lastTransmit = World.tick;
                @Pc(101) ServerConnection local101 = ConnectionManager.active();
                @Pc(107) ClientMessage local107 = ClientMessage.create(ClientProt.IGNORELIST_DEL, local101.cipher);
                local107.bitPacket.p1(Static231.method3379(arg0));
                local107.bitPacket.pjstr(arg0);
                local101.send(local107);
                return;
            }
        }
    }
}
