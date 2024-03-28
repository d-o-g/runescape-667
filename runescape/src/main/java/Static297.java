import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static297 {

    @OriginalMember(owner = "client!jha", name = "i", descriptor = "J")
    public static long aLong153 = 0L;

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(IIIII)V")
    public static void method4371(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        if (arg3 <= arg1) {
            Static696.method9037(arg1, arg2, arg3, Static723.anIntArrayArray266[arg0]);
        } else {
            Static696.method9037(arg3, arg2, arg1, Static723.anIntArrayArray266[arg0]);
        }
    }
}
