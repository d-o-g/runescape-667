import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static273 {

    @OriginalMember(owner = "client!ik", name = "M", descriptor = "I")
    public static int anInt4395 = 100;

    @OriginalMember(owner = "client!ik", name = "a", descriptor = "(IIII)I")
    public static int method3966(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (arg2 == arg0) {
            return arg2;
        }
        @Pc(14) int local14 = 128 - arg1;
        @Pc(29) int local29 = local14 * (arg2 & 0x7F) + (arg0 & 0x7F) * arg1 >> 7;
        @Pc(43) int local43 = (arg2 & 0x380) * local14 + (arg0 & 0x380) * arg1 >> 7;
        @Pc(57) int local57 = arg1 * (arg0 & 0xFC00) + local14 * (arg2 & 0xFC00) >> 7;
        return local43 & 0x380 | local57 & 0xFC00 | local29 & 0x7F;
    }
}
