import com.jagex.Client;
import com.jagex.core.stringtools.general.NameTools;
import com.jagex.game.LocalisedText;
import com.jagex.game.runetek6.config.loctype.LocTypeCustomisation;
import com.jagex.graphics.Ground;
import com.jagex.sound.midi.MidiSong;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static706 {

    @OriginalMember(owner = "client!wfa", name = "W", descriptor = "F")
    public static float aFloat217;

    @OriginalMember(owner = "client!wfa", name = "U", descriptor = "[Lclient!s;")
    public static Ground[] floor;

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(IILclient!gp;III)V")
    public static void method9220(@OriginalArg(0) int arg0, @OriginalArg(2) LocTypeCustomisation arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4) {
        if (arg4 < 1 || arg2 < 1 || arg4 > Static720.mapWidth - 2 || Static501.mapLength - 2 < arg2) {
            return;
        }
        if (Static334.activeTiles == null) {
            return;
        }
        @Pc(52) Location local52 = Static2.aMapRegion.getLoc(arg4, arg2, arg3, arg0);
        if (local52 == null) {
            return;
        }
        if (local52 instanceof DynamicLocation) {
            ((DynamicLocation) local52).customise(arg1);
            return;
        }
        if (!(local52 instanceof DynamicGroundDecor)) {
            if (local52 instanceof DynamicWall) {
                ((DynamicWall) local52).customise(arg1);
            } else if (local52 instanceof DynamicWallDecor) {
                ((DynamicWallDecor) local52).method6862(arg1);
                return;
            }
            return;
        }
        ((DynamicGroundDecor) local52).customise(arg1);
        return;
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(BLclient!bn;I)V")
    public static void method9221(@OriginalArg(1) MidiSong arg0, @OriginalArg(2) int arg1) {
        ClientOptions.instance.musicVolume.getValue();
        if (arg0 == null) {
            Static100.method1988();
        }
        Static719.aClass56_5.method3592();
        Static522.method7041(arg0);
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(IBII)Z")
    public static boolean method9224(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        Static107.aMatrix_3.method7124(arg2, arg1, arg0, Static35.anIntArray58);
        @Pc(13) int local13 = Static35.anIntArray58[2];
        if (local13 < 50) {
            return false;
        } else {
            Static35.anIntArray58[0] = Static35.anIntArray58[0] * Static1.anInt10797 / local13 + Static460.anInt6970;
            Static35.anIntArray58[2] = local13;
            Static35.anIntArray58[1] = Static407.anInt6286 + Static412.anInt6357 * Static35.anIntArray58[1] / local13;
            return true;
        }
    }

    @OriginalMember(owner = "client!wfa", name = "a", descriptor = "(Ljava/lang/String;Z)V")
    public static void method9225(@OriginalArg(0) String arg0) {
        if (arg0 == null) {
            return;
        }
        if (FriendsList.count >= 200 && !Client.isMember || FriendsList.count >= 200) {
            ChatHistory.addPrivateError(LocalisedText.FRIENDLIST_FULL.localise(Client.language));
            return;
        }
        @Pc(34) String local34 = NameTools.format(arg0);
        if (local34 == null) {
            return;
        }
        @Pc(81) String local81;
        for (@Pc(40) int local40 = 0; local40 < FriendsList.count; local40++) {
            @Pc(47) String local47 = NameTools.format(FriendsList.names[local40]);
            if (local47 != null && local47.equals(local34)) {
                ChatHistory.addPrivateError(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Client.language));
                return;
            }
            if (Static572.aStringArray42[local40] != null) {
                local81 = NameTools.format(Static572.aStringArray42[local40]);
                if (local81 != null && local81.equals(local34)) {
                    ChatHistory.addPrivateError(arg0 + LocalisedText.FRIENDLISTDUPE.localise(Client.language));
                    return;
                }
            }
        }
        for (@Pc(115) int local115 = 0; local115 < Static436.anInt3849; local115++) {
            local81 = NameTools.format(Static632.aStringArray44[local115]);
            if (local81 != null && local81.equals(local34)) {
                ChatHistory.addPrivateError(LocalisedText.REMOVEIGNORE1.localise(Client.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Client.language));
                return;
            }
            if (Static10.aStringArray1[local115] != null) {
                @Pc(161) String local161 = NameTools.format(Static10.aStringArray1[local115]);
                if (local161 != null && local161.equals(local34)) {
                    ChatHistory.addPrivateError(LocalisedText.REMOVEIGNORE1.localise(Client.language) + arg0 + LocalisedText.REMOVEIGNORE2.localise(Client.language));
                    return;
                }
            }
        }
        if (NameTools.format(PlayerEntity.self.accountName).equals(local34)) {
            ChatHistory.addPrivateError(LocalisedText.FRIENDCANTADDSELF.localise(Client.language));
            return;
        }
        @Pc(230) ServerConnection local230 = ConnectionManager.active();
        @Pc(236) ClientMessage local236 = ClientMessage.create(Static669.A_CLIENT_PROT___116, local230.cipher);
        local236.bitPacket.p1(Static231.method3379(arg0));
        local236.bitPacket.pjstr(arg0);
        local230.send(local236);
    }
}
