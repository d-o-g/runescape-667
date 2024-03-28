import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static242 {

    @OriginalMember(owner = "client!hj", name = "i", descriptor = "I")
    public static int anInt3971 = 0;

    @OriginalMember(owner = "client!hj", name = "a", descriptor = "(BLclient!hw;)I")
    public static int method3499(@OriginalArg(1) Class172 arg0) {
        if (arg0 == Static285.aClass172_1) {
            return 9216;
        } else if (Static360.aClass172_3 == arg0) {
            return 34065;
        } else if (Static320.aClass172_2 == arg0) {
            return 34066;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @OriginalMember(owner = "client!hj", name = "a", descriptor = "(IZ)I")
    public static int method3503(@OriginalArg(1) boolean arg0) {
        @Pc(5) int local5 = Static448.anInt6796;
        if (local5 == 0) {
            return arg0 ? 0 : Static2.anInt45;
        } else if (local5 == 1) {
            return Static2.anInt45;
        } else if (local5 == 2) {
            return 0;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!hj", name = "a", descriptor = "(Ljava/lang/String;II)V")
    public static void method3504(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
        @Pc(5) int local5 = PlayerList.highResolutionPlayerCount;
        @Pc(7) int[] local7 = PlayerList.highResolutionPlayerIndices;
        @Pc(9) boolean local9 = false;
        for (@Pc(19) int local19 = 0; local19 < local5; local19++) {
            @Pc(26) PlayerEntity local26 = PlayerList.highResolutionPlayers[local7[local19]];
            if (local26 != null && PlayerEntity.self != local26 && local26.accountName != null && local26.accountName.equalsIgnoreCase(arg0)) {
                @Pc(47) ClientProt local47 = null;
                if (arg1 == 1) {
                    local47 = ClientProt.OPPLAYER1;
                } else if (arg1 == 4) {
                    local47 = ClientProt.OPPLAYER4;
                } else if (arg1 == 5) {
                    local47 = ClientProt.OPPLAYER5;
                } else if (arg1 == 6) {
                    local47 = ClientProt.OPPLAYER6;
                } else if (arg1 == 7) {
                    local47 = ClientProt.OPPLAYER7;
                } else if (arg1 == 9) {
                    local47 = ClientProt.OPPLAYER9;
                }
                if (local47 != null) {
                    @Pc(108) ClientMessage local108 = ClientMessage.create(local47, ServerConnection.GAME.cipher);
                    local108.bitPacket.p1(0);
                    local108.bitPacket.p2(local7[local19]);
                    ServerConnection.GAME.send(local108);
                }
                local9 = true;
                break;
            }
        }
        if (!local9) {
            ChatHistory.addPrivateError(LocalisedText.UNABLETOFIND.localise(Client.language) + arg0);
        }
    }
}
