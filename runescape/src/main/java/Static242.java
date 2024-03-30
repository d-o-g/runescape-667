import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static242 {

    @OriginalMember(owner = "client!hj", name = "i", descriptor = "I")
    public static int anInt3971 = 0;

    @OriginalMember(owner = "client!hj", name = "a", descriptor = "(BLclient!hw;)I")
    public static int method3499(@OriginalArg(1) Class172 arg0) {
        if (arg0 == Static285.aClass172_1) {
            return 9216;
        } else if (Static360.aClass172_3 == arg0) {
            return 34065;
        } else if (Static320.aClass172_2 == arg0) {
            return 34066;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
