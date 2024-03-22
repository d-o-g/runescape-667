import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static624 {

    @OriginalMember(owner = "client!tn", name = "f", descriptor = "F")
    public static float aFloat198;

    @OriginalMember(owner = "client!tn", name = "i", descriptor = "Z")
    public static boolean varcSaveRecommended = false;

    @OriginalMember(owner = "client!tn", name = "k", descriptor = "I")
    public static int anInt9461 = -1;

    @OriginalMember(owner = "client!tn", name = "a", descriptor = "(IIIIIB)V")
    public static void method8330(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        if (Static180.anInt2995 <= arg1 && Static111.anInt2219 >= arg0 && arg4 >= Static724.anInt10930 && Static273.anInt4395 >= arg3) {
            Static561.method7437(arg4, arg2, arg1, arg3, arg0);
        } else {
            Static230.method3370(arg1, arg0, arg2, arg4, arg3);
        }
    }

    @OriginalMember(owner = "client!tn", name = "a", descriptor = "(ZIII)V")
    public static void teleport(@OriginalArg(1) int level, @OriginalArg(2) int y, @OriginalArg(3) int x) {
        @Pc(37) String command = "tele " + level + "," + (x >> 6) + "," + (y >> 6) + "," + (x & 0x3F) + "," + (y & 0x3F);
        System.out.println(command);
        Static231.executeComand(true, false, command);
    }
}
