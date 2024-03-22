import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static713 {

    @OriginalMember(owner = "client!wk", name = "a", descriptor = "(IZ)V")
    public static void method9331(@OriginalArg(1) boolean arg0) {
        Static712.aMatrix_11.method7128(Static74.aToolkit_4.method8017());
        @Pc(10) int[] local10 = Static74.aToolkit_4.Y();
        Static338.anInt5563 = local10[0];
        Static637.anInt9536 = local10[1];
        Static172.anInt2888 = local10[2];
        Static630.anInt9494 = local10[3];
        if (arg0) {
            Static74.aToolkit_4.DA(Static213.anInt3469, Static524.anInt8043, Static46.anInt1001, Static246.anInt3986);
            Static278.method4068(Static294.aDouble15);
        } else {
            Static74.aToolkit_4.DA(Static354.anInt5759, Static391.anInt6134, Static434.anInt6565, Static646.anInt9621);
            Static278.method4068(Static246.aDouble13);
        }
    }

}
