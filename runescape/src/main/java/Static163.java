import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Date;

public final class Static163 {

    @OriginalMember(owner = "client!fb", name = "d", descriptor = "[[B")
    public static byte[][] aByteArrayArray36;

    @OriginalMember(owner = "client!fb", name = "a", descriptor = "(JI)Ljava/lang/String;")
    public static String method8846(@OriginalArg(0) long arg0) {
        debugconsole.GMT_CALENDAR.setTime(new Date(arg0));
        @Pc(19) int local19 = debugconsole.GMT_CALENDAR.get(7);
        @Pc(23) int local23 = debugconsole.GMT_CALENDAR.get(5);
        @Pc(27) int local27 = debugconsole.GMT_CALENDAR.get(2);
        @Pc(31) int local31 = debugconsole.GMT_CALENDAR.get(1);
        @Pc(35) int local35 = debugconsole.GMT_CALENDAR.get(11);
        @Pc(39) int local39 = debugconsole.GMT_CALENDAR.get(12);
        @Pc(43) int local43 = debugconsole.GMT_CALENDAR.get(13);
        return Static146.aStringArray8[local19 - 1] + ", " + local23 / 10 + local23 % 10 + "-" + Static361.aStringArray29[local27] + "-" + local31 + " " + local35 / 10 + local35 % 10 + ":" + local39 / 10 + local39 % 10 + ":" + local43 / 10 + local43 % 10 + " GMT";
    }

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
