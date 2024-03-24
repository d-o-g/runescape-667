import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static373 {

    @OriginalMember(owner = "client!lo", name = "g", descriptor = "I")
    public static int anInt5903;

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(I[[F[[S)[[S")
    public static short[][] method5300(@OriginalArg(1) float[][] arg0, @OriginalArg(2) short[][] arg1) {
        for (@Pc(3) int local3 = 0; local3 < arg0.length; local3++) {
            for (@Pc(9) int local9 = 0; local9 < arg1[local3].length; local9++) {
                arg1[local3][local9] = (short) (int) (arg0[local3][local9] * 16383.0F);
            }
        }
        anInt5903++;
        return arg1;
    }

}
