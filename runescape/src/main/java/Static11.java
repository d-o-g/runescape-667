import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static11 {

    @OriginalMember(owner = "client!aga", name = "a", descriptor = "(I)V")
    public static void method146() {
        PlayerList.highResolutionCount = 0;
        for (@Pc(15) int local15 = 0; local15 < 2048; local15++) {
            PlayerList.appearances[local15] = null;
            PlayerList.pathSpeeds[local15] = 1;
            PlayerList.lowResolutionPlayers[local15] = null;
        }
    }
}
