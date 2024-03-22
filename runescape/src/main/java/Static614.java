import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static614 {

    @OriginalMember(owner = "client!th", name = "q", descriptor = "D")
    public static double aDouble22;

    @OriginalMember(owner = "client!th", name = "c", descriptor = "[F")
    public static final float[] aFloatArray67 = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F};

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(ZJ)I")
    public static int method8242(@OriginalArg(1) long arg0) {
        Static551.method7276(arg0);
        return Static260.aCalendar2.get(1);
    }

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(JBI)Ljava/lang/String;")
    public static String method8243(@OriginalArg(0) long arg0, @OriginalArg(2) int arg1) {
        Static551.method7276(arg0);
        @Pc(17) int local17 = Static260.aCalendar2.get(5);
        @Pc(23) int local23 = Static260.aCalendar2.get(2) + 1;
        @Pc(27) int local27 = Static260.aCalendar2.get(1);
        return Integer.toString(local17 / 10) + local17 % 10 + "/" + local23 / 10 + local23 % 10 + "/" + local27 % 100 / 10 + local27 % 10;
    }

}
