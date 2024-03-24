import com.jagex.graphics.Ground;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static246 {

    @OriginalMember(owner = "client!hl", name = "h", descriptor = "D")
    public static double aDouble13;

    @OriginalMember(owner = "client!hl", name = "n", descriptor = "[Lclient!s;")
    public static Ground[] ground;

    @OriginalMember(owner = "client!hl", name = "e", descriptor = "I")
    public static int anInt3986;

    @OriginalMember(owner = "client!hl", name = "d", descriptor = "[Lclient!tea;")
    public static final Class350[] aClass350Array1 = new Class350[2048];

    @OriginalMember(owner = "client!hl", name = "a", descriptor = "(III)Z")
    public static boolean method3521(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0xC580) != 0;
    }

}
