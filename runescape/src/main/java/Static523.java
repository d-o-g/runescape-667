import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static523 {

    @OriginalMember(owner = "client!qi", name = "n", descriptor = "I")
    public static int anInt3882;

    @OriginalMember(owner = "client!qi", name = "m", descriptor = "I")
    public static int anInt3888;

    @OriginalMember(owner = "client!qi", name = "p", descriptor = "I")
    public static int anInt3885 = -1;

    @OriginalMember(owner = "client!qi", name = "a", descriptor = "(ZI)V")
    public static void method3447(@OriginalArg(0) boolean arg0) {
        if (Static449.aLoadingScreenRenderer_1 == null) {
            Static229.method3368();
        }
        if (arg0) {
            Static449.aLoadingScreenRenderer_1.repaint();
        }
    }

}
