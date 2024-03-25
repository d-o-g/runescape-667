import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static316 {

    @OriginalMember(owner = "client!ka", name = "f", descriptor = "Z")
    public static boolean aBoolean644;

    @OriginalMember(owner = "client!ka", name = "h", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray41 = new String[100];

    @OriginalMember(owner = "client!ka", name = "a", descriptor = "(IIIIIIIIII)V")
    public static void method7478(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5, @OriginalArg(7) int arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8) {
        if (arg0 >= Static180.anInt2995 && arg0 <= Static111.anInt2219 && Static180.anInt2995 <= arg8 && Static111.anInt2219 >= arg8 && arg4 >= Static180.anInt2995 && arg4 <= Static111.anInt2219 && Static180.anInt2995 <= arg7 && arg7 <= Static111.anInt2219 && arg6 >= Static724.anInt10930 && arg6 <= Static273.anInt4395 && arg1 >= Static724.anInt10930 && Static273.anInt4395 >= arg1 && arg2 >= Static724.anInt10930 && arg2 <= Static273.anInt4395 && arg5 >= Static724.anInt10930 && arg5 <= Static273.anInt4395) {
            Static181.method2780(arg6, arg1, arg3, arg4, arg0, arg2, arg5, arg8, arg7);
        } else {
            Static188.method2856(arg6, arg3, arg5, arg2, arg4, arg1, arg8, arg0, arg7);
        }
    }

}
