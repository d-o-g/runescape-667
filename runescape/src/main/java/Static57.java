import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static57 {

    @OriginalMember(owner = "client!bt", name = "q", descriptor = "F")
    public static float aFloat29;

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(FIIFI[FIIIIIF[FI)V")
    public static void method1224(@OriginalArg(0) float arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) float arg3, @OriginalArg(4) int arg4, @OriginalArg(5) float[] arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7, @OriginalArg(9) int arg8, @OriginalArg(10) int arg9, @OriginalArg(11) float arg10, @OriginalArg(12) float[] arg11, @OriginalArg(13) int arg12) {
        @Pc(5) int local5 = arg6 - arg4;
        @Pc(13) int local13 = arg2 - arg8;
        @Pc(17) int local17 = arg7 - arg9;
        @Pc(38) float local38 = arg11[2] * (float) local17 + (float) local13 * arg11[0] + arg11[1] * (float) local5;
        @Pc(59) float local59 = (float) local17 * arg11[5] + arg11[3] * (float) local13 + arg11[4] * (float) local5;
        @Pc(93) float local93 = arg11[8] * (float) local17 + (float) local5 * arg11[7] + arg11[6] * (float) local13;
        @Pc(133) float local133;
        @Pc(126) float local126;
        if (arg1 == 0) {
            local126 = arg10 + 0.5F - local93;
            local133 = local38 + arg0 + 0.5F;
        } else if (arg1 == 1) {
            local133 = arg0 + local38 + 0.5F;
            local126 = arg10 + local93 + 0.5F;
        } else if (arg1 == 2) {
            local133 = arg0 + 0.5F - local38;
            local126 = arg3 + 0.5F - local59;
        } else if (arg1 == 3) {
            local133 = local38 + arg0 + 0.5F;
            local126 = arg3 + 0.5F - local59;
        } else if (arg1 == 4) {
            local133 = arg10 + local93 + 0.5F;
            local126 = arg3 + 0.5F - local59;
        } else {
            local126 = arg3 + 0.5F - local59;
            local133 = arg10 + 0.5F - local93;
        }
        @Pc(227) float local227;
        if (arg12 == 1) {
            local227 = local133;
            local133 = -local126;
            local126 = local227;
        } else if (arg12 == 2) {
            local126 = -local126;
            local133 = -local133;
        } else if (arg12 == 3) {
            local227 = local133;
            local133 = local126;
            local126 = -local227;
        }
        arg5[1] = local126;
        arg5[0] = local133;
    }

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "([SB)[S")
    public static short[] method1230(@OriginalArg(0) short[] arg0) {
        if (arg0 == null) {
            return null;
        } else {
            @Pc(19) short[] local19 = new short[arg0.length];
            Arrays.copy(arg0, 0, local19, 0, arg0.length);
            return local19;
        }
    }

}
