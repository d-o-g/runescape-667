import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static446 {

    @OriginalMember(owner = "client!oaa", name = "p", descriptor = "[[[I")
    public static int[][][] anIntArrayArrayArray9;

    @OriginalMember(owner = "client!oaa", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray35 = new String[100];

    @OriginalMember(owner = "client!oaa", name = "a", descriptor = "(IIIZIIII)V")
    public static void method6094(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6) {
        @Pc(9) int local9 = arg5 + arg6;
        @Pc(19) int local19 = arg0 - arg5;
        for (@Pc(21) int local21 = arg6; local21 < local9; local21++) {
            Static696.method9037(arg1, arg2, arg4, Static723.anIntArrayArray266[local21]);
        }
        @Pc(45) int local45 = arg4 + arg5;
        @Pc(50) int local50 = arg1 - arg5;
        for (@Pc(52) int local52 = arg0; local52 > local19; local52--) {
            Static696.method9037(arg1, arg2, arg4, Static723.anIntArrayArray266[local52]);
        }
        for (@Pc(72) int local72 = local9; local72 <= local19; local72++) {
            @Pc(80) int[] local80 = Static723.anIntArrayArray266[local72];
            Static696.method9037(local45, arg2, arg4, local80);
            Static696.method9037(local50, arg3, local45, local80);
            Static696.method9037(arg1, arg2, local50, local80);
        }
    }
}
