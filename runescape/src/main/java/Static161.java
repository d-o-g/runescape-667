import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static161 {

    @OriginalMember(owner = "client!fa", name = "b", descriptor = "[[[J")
    public static long[][][] tileLightFlags;

    @OriginalMember(owner = "client!fa", name = "a", descriptor = "(IFFF)I")
    public static int method2589(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) float arg2) {
        @Pc(20) float local20 = arg1 < 0.0F ? -arg1 : arg1;
        @Pc(30) float local30 = arg2 < 0.0F ? -arg2 : arg2;
        @Pc(40) float local40 = arg0 < 0.0F ? -arg0 : arg0;
        if (local30 > local20 && local40 < local30) {
            return arg2 > 0.0F ? 0 : 1;
        } else if (local20 < local40 && local30 < local40) {
            return arg0 > 0.0F ? 2 : 3;
        } else if (arg1 > 0.0F) {
            return 4;
        } else {
            return 5;
        }
    }
}
