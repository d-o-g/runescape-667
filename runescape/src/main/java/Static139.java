import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static139 {

    @OriginalMember(owner = "client!eg", name = "a", descriptor = "(BII)Z")
    public static boolean method2358(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x18) != 0 | (arg0 & 0x220) == 544;
    }
}
