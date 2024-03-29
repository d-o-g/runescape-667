import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static614 {

    @OriginalMember(owner = "client!th", name = "q", descriptor = "D")
    public static double aDouble22;

    @OriginalMember(owner = "client!th", name = "c", descriptor = "[F")
    public static final float[] aFloatArray67 = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F};

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(ZJ)I")
    public static int method8242(@OriginalArg(1) long arg0) {
        TimeUtils.method7276(arg0);
        return TimeUtils.aCalendar2.get(1);
    }

}
