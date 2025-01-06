import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.iftype.TargetMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ThreeDView {

    @OriginalMember(owner = "client!hj", name = "a", descriptor = "(Ljava/lang/String;II)V")
    public static void doOpPlayer(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
        @Pc(5) int count = PlayerList.highResolutionPlayerCount;
        @Pc(7) int[] indices = PlayerList.highResolutionPlayerIndices;
        @Pc(9) boolean found = false;

        for (@Pc(19) int i = 0; i < count; i++) {
            @Pc(26) PlayerEntity player = PlayerList.highResolutionPlayers[indices[i]];

            if (player != null && PlayerEntity.self != player && player.nameUnfiltered != null && player.nameUnfiltered.equalsIgnoreCase(arg0)) {
                @Pc(47) ClientProt prot = null;
                if (arg1 == 1) {
                    prot = ClientProt.OPPLAYER1;
                } else if (arg1 == 4) {
                    prot = ClientProt.OPPLAYER4;
                } else if (arg1 == 5) {
                    prot = ClientProt.OPPLAYER5;
                } else if (arg1 == 6) {
                    prot = ClientProt.OPPLAYER6;
                } else if (arg1 == 7) {
                    prot = ClientProt.OPPLAYER7;
                } else if (arg1 == 9) {
                    prot = ClientProt.OPPLAYER9;
                }

                if (prot != null) {
                    @Pc(108) ClientMessage message = ClientMessage.create(prot, ServerConnection.GAME.isaac);
                    message.bitPacket.p1(0);
                    message.bitPacket.p2(indices[i]);
                    ServerConnection.GAME.send(message);
                }

                found = true;
                break;
            }
        }

        if (!found) {
            ChatHistory.addPrivateError(LocalisedText.UNABLETOFIND.localise(Client.language) + arg0);
        }
    }

    private ThreeDView() {
        /* empty */
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void doTargetPlayer(@OriginalArg(1) String arg0) {
        if (!InterfaceManager.targetMode || (InterfaceManager.targetMask & (TargetMask.TGT_SELF | TargetMask.TGT_PLAYER)) == 0) {
            return;
        }

        @Pc(22) boolean found = false;
        @Pc(24) int count = PlayerList.highResolutionPlayerCount;
        @Pc(26) int[] indices = PlayerList.highResolutionPlayerIndices;

        for (@Pc(28) int i = 0; i < count; i++) {
            @Pc(35) PlayerEntity player = PlayerList.highResolutionPlayers[indices[i]];

            if (player.nameUnfiltered != null && player.nameUnfiltered.equalsIgnoreCase(arg0) && (PlayerEntity.self == player && (InterfaceManager.targetMask & TargetMask.TGT_SELF) != 0 || (InterfaceManager.targetMask & TargetMask.TGT_PLAYER) != 0)) {
                @Pc(75) ClientMessage message = ClientMessage.create(ClientProt.OPPLAYERT, ServerConnection.GAME.isaac);
                message.bitPacket.p2_alt1(indices[i]);
                message.bitPacket.p4_alt1(InterfaceManager.targetSlot);
                message.bitPacket.p2(InterfaceManager.targetInvObj);
                message.bitPacket.p1_alt3(0);
                message.bitPacket.p2_alt3(InterfaceManager.targetComponent);
                ServerConnection.GAME.send(message);

                Static147.findPath(0, player.pathZ[0], player.getSize(), true, player.pathX[0], 0, -2, player.getSize());
                found = true;
                break;
            }
        }

        if (!found) {
            ChatHistory.addPrivateError(LocalisedText.UNABLETOFIND.localise(Client.language) + arg0);
        }

        if (InterfaceManager.targetMode) {
            InterfaceManager.endTargetMode();
        }
    }
}
