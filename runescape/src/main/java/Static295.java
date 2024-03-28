import com.jagex.graphics.texture.Node_Sub1_Sub27;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static295 {

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(IIIBILclient!qha;)Lclient!gb;")
    public static Class93_Sub2_Sub1 method4353(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) GlToolkit arg4) {
        if (arg4.aBoolean597 || Node_Sub1_Sub27.method9150(arg2) && Node_Sub1_Sub27.method9150(arg1)) {
            return new Class93_Sub2_Sub1(arg4, 3553, arg0, arg3, arg2, arg1, true);
        } else if (arg4.aBoolean595) {
            return new Class93_Sub2_Sub1(arg4, 34037, arg0, arg3, arg2, arg1, true);
        } else {
            return new Class93_Sub2_Sub1(arg4, arg0, arg3, arg2, arg1, IntMath.nextPow2(arg2), IntMath.nextPow2(arg1), true);
        }
    }

    @OriginalMember(owner = "client!jga", name = "a", descriptor = "(IIIII)V")
    public static void method4354(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        if (Static62.waterColour != null) {
            Static62.waterColour[arg0][arg1] = arg2 | 0xFF000000;
        }
        if (Static272.waterDepth != null) {
            Static272.waterDepth[arg0][arg1] = (short) arg3;
        }
        if (Static421.waterBias != null) {
            Static421.waterBias[arg0][arg1] = (byte) arg4;
        }
    }
}
