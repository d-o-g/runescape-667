import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static163 {

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "[[B")
    public static byte[][] aByteArrayArray36;

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "([II[III)V")
    public static void method8852(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3) {
        if (arg3 >= arg1) {
            return;
        }
        @Pc(15) int local15 = (arg1 + arg3) / 2;
        @Pc(17) int local17 = arg3;
        @Pc(21) int local21 = arg0[local15];
        arg0[local15] = arg0[arg1];
        arg0[arg1] = local21;
        @Pc(35) int local35 = arg2[local15];
        arg2[local15] = arg2[arg1];
        arg2[arg1] = local35;
        @Pc(53) int local53 = local21 == Integer.MAX_VALUE ? 0 : 1;
        for (@Pc(55) int local55 = arg3; local55 < arg1; local55++) {
            if ((local53 & local55) + local21 > arg0[local55]) {
                @Pc(74) int local74 = arg0[local55];
                arg0[local55] = arg0[local17];
                arg0[local17] = local74;
                @Pc(88) int local88 = arg2[local55];
                arg2[local55] = arg2[local17];
                arg2[local17++] = local88;
            }
        }
        arg0[arg1] = arg0[local17];
        arg0[local17] = local21;
        arg2[arg1] = arg2[local17];
        arg2[local17] = local35;
        method8852(arg0, local17 - 1, arg2, arg3);
        method8852(arg0, arg1, arg2, local17 + 1);
    }
}
