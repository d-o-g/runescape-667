import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static168 {

    @OriginalMember(owner = "client!fda", name = "f", descriptor = "I")
    public static int anInt2842;

    @OriginalMember(owner = "client!fda", name = "a", descriptor = "(IBIIIII)V")
    public static void method2637(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        if (Static180.anInt2995 <= arg5 && Static111.anInt2219 >= arg3 && Static724.anInt10930 <= arg4 && Static273.anInt4395 >= arg0) {
            if (arg2 == 1) {
                Static175.method2701(arg0, arg4, arg1, arg3, arg5);
            } else {
                Static548.method7253(arg1, arg5, arg3, arg0, arg2, arg4);
            }
        } else if (arg2 == 1) {
            Static385.method5420(arg0, arg5, arg1, arg3, arg4);
        } else {
            Static249.method3535(arg2, arg4, arg3, arg0, arg5, arg1);
        }
    }
}
