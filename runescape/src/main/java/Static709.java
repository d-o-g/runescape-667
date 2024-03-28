import com.jagex.graphics.texture.Node_Sub1_Sub27;
import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static709 {

    @OriginalMember(owner = "client!wh", name = "F", descriptor = "I")
    public static int anInt10669 = 1;

    @OriginalMember(owner = "client!wh", name = "a", descriptor = "(IZIILclient!qha;)Lclient!gb;")
    public static Class93_Sub2_Sub1 method9251(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) GlToolkit arg3) {
        if (arg3.aBoolean597 || Node_Sub1_Sub27.method9150(arg1) && Node_Sub1_Sub27.method9150(arg0)) {
            return new Class93_Sub2_Sub1(arg3, 3553, arg2, arg1, arg0);
        } else if (arg3.aBoolean595) {
            return new Class93_Sub2_Sub1(arg3, 34037, arg2, arg1, arg0);
        } else {
            return new Class93_Sub2_Sub1(arg3, arg2, arg1, arg0, IntMath.nextPow2(arg1), IntMath.nextPow2(arg0));
        }
    }

}
