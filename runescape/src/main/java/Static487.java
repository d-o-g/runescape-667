import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static487 {

    @OriginalMember(owner = "client!pg", name = "a", descriptor = "(IIIII)I")
    public static int method6515(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3) {
        @Pc(7) int local7 = arg1 & 0xF;
        @Pc(23) int local23 = local7 >= 8 ? arg3 : arg2;
        @Pc(48) int local48 = local7 < 4 ? arg3 : local7 == 12 || local7 == 14 ? arg2 : arg0;
        return ((local7 & 0x1) == 0 ? local23 : -local23) + ((local7 & 0x2) == 0 ? local48 : -local48);
    }

}
