import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Calendar;

public final class Static120 {

    @OriginalMember(owner = "client!dn", name = "a", descriptor = "(ZIJI)Ljava/lang/String;")
    public static String method2198(@OriginalArg(2) long arg0, @OriginalArg(3) int arg1) {
        Static356.method5196(arg0);
        @Pc(10) Calendar local10 = Static260.aCalendar1;
        @Pc(20) int local20 = local10.get(5);
        @Pc(26) int local26 = local10.get(2) + 1;
        @Pc(38) int local38 = local10.get(1);
        @Pc(42) int local42 = local10.get(11);
        @Pc(46) int local46 = local10.get(12);
        return Integer.toString(local20 / 10) + local20 % 10 + "/" + local26 / 10 + local26 % 10 + "/" + local38 % 100 / 10 + local38 % 10 + " " + local42 / 10 + local42 % 10 + ":" + local46 / 10 + local46 % 10;
    }
}
