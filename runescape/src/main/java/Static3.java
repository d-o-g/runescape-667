import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static3 {

    @OriginalMember(owner = "client!ab", name = "w", descriptor = "Z")
    public static boolean chooseSafeMode = false;

    @OriginalMember(owner = "client!ab", name = "d", descriptor = "(I)V")
    public static void method87(@OriginalArg(0) int arg0) {
        Static296.tileMinLevel = arg0;
        for (@Pc(3) int local3 = 0; local3 < Static619.tileMaxX; local3++) {
            for (@Pc(6) int local6 = 0; local6 < Static662.tileMaxZ; local6++) {
                if (Static334.activeTiles[arg0][local3][local6] == null) {
                    Static334.activeTiles[arg0][local3][local6] = new Tile(arg0);
                }
            }
        }
    }
}
