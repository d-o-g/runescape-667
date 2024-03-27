import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static577 {

    @OriginalMember(owner = "client!sca", name = "e", descriptor = "I")
    public static int anInt8587 = 0;

    @OriginalMember(owner = "client!sca", name = "b", descriptor = "(III)Z")
    public static boolean method7616(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x70000) != 0 | Static119.method2175(arg1, arg0) || Static42.method1054(arg1, arg0);
    }
}
