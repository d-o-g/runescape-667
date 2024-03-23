import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static240 {

    @OriginalMember(owner = "client!hi", name = "F", descriptor = "I")
    public static int anInt3955;

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BII)Z")
    public static boolean method3483(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x800) != 0;
    }

}
