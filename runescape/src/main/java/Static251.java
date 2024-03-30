import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static251 {

    @OriginalMember(owner = "client!ho", name = "c", descriptor = "I")
    public static int anInt4037;

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "(III)Z")
    public static boolean method3550(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return Static590.method7746(arg1, arg0) | (arg0 & 0x70000) != 0 || Static42.method1054(arg1, arg0);
    }
}
