import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static390 {

    @OriginalMember(owner = "client!mda", name = "x", descriptor = "[I")
    public static final int[] anIntArray476 = new int[]{1, 4, 1, 2, 1};

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(III)Z")
    public static boolean method5495(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static483.method6488(arg1, arg0) | (arg0 & 0x60000) != 0 || Static198.method2957(arg0, arg1) || Static319.method4594(arg0, arg1);
    }
}
