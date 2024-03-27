import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static572 {

    @OriginalMember(owner = "client!s", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray42 = new String[200];

    @OriginalMember(owner = "client!s", name = "a", descriptor = "(IIII)I")
    public static int method7867(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(15) int local15 = 255 - arg2;
        @Pc(33) int local33 = ((arg0 & 0xFF00) * arg2 & 0xFF0000 | (arg0 & 0xFF00FF) * arg2 & 0xFF00FF00) >>> 8;
        return local33 + ((local15 * (arg1 & 0xFF00) & 0xFF0000 | (arg1 & 0xFF00FF) * local15 & 0xFF00FF00) >>> 8);
    }

}
