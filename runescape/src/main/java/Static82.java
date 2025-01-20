import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static82 {

    @OriginalMember(owner = "client!cl", name = "a", descriptor = "(B)V")
    public static void method1593() {
        @Pc(7) int local7 = PlayerList.highResolutionCount;
        @Pc(9) int[] local9 = PlayerList.highResolutionSlots;
        for (@Pc(16) int local16 = 0; local16 < local7; local16++) {
            @Pc(24) PlayerEntity local24 = PlayerList.highResolutionPlayers[local9[local16]];
            if (local24 != null) {
                Static489.tick(false, local24);
            }
        }
    }
}
