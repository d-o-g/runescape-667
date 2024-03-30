import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static637 {

    @OriginalMember(owner = "client!uc", name = "a", descriptor = "(III)Z")
    public static boolean method8387(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (arg0 & 0x40000) != 0 | Static194.method2908(arg0, arg1) || Static198.method2957(arg0, arg1);
    }
}
