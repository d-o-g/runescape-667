import com.jagex.math.IntMath;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static469 {

    @OriginalMember(owner = "client!oq", name = "f", descriptor = "I")
    public static int anInt7072 = 0;

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(III[BILclient!qha;IZ)Lclient!gb;")
    public static Class93_Sub2_Sub1 method6359(@OriginalArg(0) int arg0, @OriginalArg(3) byte[] arg1, @OriginalArg(5) Toolkit_Sub3 arg2, @OriginalArg(6) int arg3) {
        if (arg2.aBoolean597 || Static700.method9150(arg3) && Static700.method9150(arg0)) {
            return new Class93_Sub2_Sub1(arg2, 3553, 6406, arg3, arg0, false, arg1, 6406);
        } else if (arg2.aBoolean595) {
            return new Class93_Sub2_Sub1(arg2, 34037, 6406, arg3, arg0, false, arg1, 6406);
        } else {
            return new Class93_Sub2_Sub1(arg2, 6406, arg3, arg0, IntMath.nextPow2(arg3), IntMath.nextPow2(arg0), arg1, 6406);
        }
    }

}
