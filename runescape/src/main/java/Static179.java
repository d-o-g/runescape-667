import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static179 {

    @OriginalMember(owner = "client!fk", name = "o", descriptor = "I")
    public static int anInt2991;

    @OriginalMember(owner = "client!fk", name = "k", descriptor = "I")
    public static int playerCount = 0;

    @OriginalMember(owner = "client!fk", name = "a", descriptor = "(IIIIZIII)V")
    public static void method2770(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(5) int arg3, @OriginalArg(6) int arg4, @OriginalArg(7) int arg5) {
        if (ClientOptions.instance.soundVolume.getValue() != 0 && arg0 != 0 && Static33.anInt779 < 50 && arg5 != -1) {
            Static409.aClass104Array1[Static33.anInt779++] = new Class104((byte) 2, arg5, arg0, arg1, arg4, arg2, arg3, null);
        }
    }
}
