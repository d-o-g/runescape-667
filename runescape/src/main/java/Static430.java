import com.jagex.graphics.FlipException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static430 {

    @OriginalMember(owner = "client!nja", name = "O", descriptor = "[I")
    public static int[] anIntArray519;

    @OriginalMember(owner = "client!nja", name = "K", descriptor = "F")
    public static float aFloat120;

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(I[[I)V")
    public static void method5815(@OriginalArg(1) int[][] arg0) {
        Static723.anIntArrayArray266 = arg0;
    }

    @OriginalMember(owner = "client!nja", name = "d", descriptor = "(B)V")
    public static void flip() throws FlipException {
        if (Static448.anInt6796 == 1) {
            Static74.aToolkit_4.flip(Static2.anInt45, Static312.anInt5001);
        } else {
            Static74.aToolkit_4.flip(0, 0);
        }
    }

}
