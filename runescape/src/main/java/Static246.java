import com.jagex.graphics.Ground;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static246 {

    @OriginalMember(owner = "client!hl", name = "n", descriptor = "[Lclient!s;")
    public static Ground[] ground;

    @OriginalMember(owner = "client!hl", name = "a", descriptor = "(III)Z")
    public static boolean method3521(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0xC580) != 0;
    }

}
