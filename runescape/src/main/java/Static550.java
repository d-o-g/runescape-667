import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static550 {

    @OriginalMember(owner = "client!rf", name = "n", descriptor = "I")
    public static int anInt8271;

    @OriginalMember(owner = "client!rf", name = "a", descriptor = "(BLclient!ca;II)V")
    public static void method7260(@OriginalArg(1) PlayerEntity arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(6) int[] local6 = new int[4];
        Arrays.set(local6, 0, local6.length, arg2);
        Static651.animate(local6, arg1, false, arg0);
    }

}
