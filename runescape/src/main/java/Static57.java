import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static57 {

    @OriginalMember(owner = "client!bt", name = "q", descriptor = "F")
    public static float aFloat29;

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
