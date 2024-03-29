import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static40 {

    @OriginalMember(owner = "client!bfa", name = "a", descriptor = "(IIIIIIB)J")
    public static long method1026(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(4) int arg2) {
        TimeUtils.aCalendar1.clear();
        TimeUtils.aCalendar1.set(arg1, arg0, arg2, 12, 0, 0);
        return TimeUtils.aCalendar1.getTime().getTime();
    }
}
