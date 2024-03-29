import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static19 {

    @OriginalMember(owner = "client!al", name = "a", descriptor = "(III)Z")
    public static boolean method264(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return Static340.method5011(arg1, arg0) | (arg1 & 0x70000) != 0 || Static598.method7828(arg1, arg0);
    }

}
