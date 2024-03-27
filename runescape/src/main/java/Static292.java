import com.jagex.graphics.Ground;
import com.jagex.graphics.Shadow;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static292 {

    @OriginalMember(owner = "client!jea", name = "l", descriptor = "[I")
    public static int[] anIntArray387 = new int[1];

    @OriginalMember(owner = "client!jea", name = "a", descriptor = "(Lclient!r;III[Z)V")
    public static void method4618(@OriginalArg(0) Shadow arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean[] arg4) {
        if (Static246.ground == Static693.underwaterGround) {
            return;
        }
        @Pc(10) int local10 = Static706.floor[arg1].averageHeight(arg3, arg2);
        for (@Pc(12) int local12 = 0; local12 <= arg1; local12++) {
            if (arg4 == null || arg4[local12]) {
                @Pc(25) Ground local25 = Static706.floor[local12];
                if (local25 != null) {
                    local25.wa(arg0, arg2, local10 - local25.averageHeight(arg3, arg2), arg3, 0, false);
                }
            }
        }
    }
}
