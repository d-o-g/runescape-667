import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static142 {

    @OriginalMember(owner = "client!eha", name = "a", descriptor = "[[Z")
    public static boolean[][] aBooleanArrayArray1;

    @OriginalMember(owner = "client!eha", name = "d", descriptor = "Lclient!rt;")
    public static Class327 aClass327_1;

    @OriginalMember(owner = "client!eha", name = "e", descriptor = "[I")
    public static final int[] anIntArray225 = new int[32];

    @OriginalMember(owner = "client!eha", name = "a", descriptor = "(IIIII)V")
    public static void method2379(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
        if (arg2 - arg3 >= Static180.anInt2995 && Static111.anInt2219 >= arg2 + arg3 && arg0 - arg3 >= Static724.anInt10930 && arg0 + arg3 <= Static273.anInt4395) {
            Static265.method3858(arg2, arg1, arg3, arg0);
        } else {
            Static158.method2571(arg0, arg3, arg1, arg2);
        }
    }

}
