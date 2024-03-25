import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static55 {

    @OriginalMember(owner = "client!br", name = "z", descriptor = "I")
    public static int disableChatEffects = 0;

    @OriginalMember(owner = "client!br", name = "b", descriptor = "(II)Z")
    public static boolean method1218(@OriginalArg(0) int arg0) {
        return arg0 == 3 || arg0 == 4;
    }
}
