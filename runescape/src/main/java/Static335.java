import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static335 {

    @OriginalMember(owner = "client!kk", name = "k", descriptor = "I")
    public static int anInt5462;

    @OriginalMember(owner = "client!kk", name = "a", descriptor = "(II)V")
    public static void setFeatureMask(@OriginalArg(1) int arg0) {
        Static108.anInt2168 = arg0;
        Static312.A_WEIGHTED_CACHE___106.reset();
    }

    @OriginalMember(owner = "client!kk", name = "a", descriptor = "(IIZ)Z")
    public static boolean method4946(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (arg1 & 0x10) != 0;
    }
}
