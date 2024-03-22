import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static366 {

    @OriginalMember(owner = "client!lja", name = "b", descriptor = "I")
    public static int statUpdateCount = 0;

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;BC)Ljava/lang/String;")
    public static String method5261(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
        @Pc(14) int local14 = arg0.length();
        @Pc(17) int local17 = arg1.length();
        @Pc(19) int local19 = local14;
        @Pc(23) int local23 = local17 - 1;
        if (local23 != 0) {
            @Pc(27) int local27 = 0;
            while (true) {
                local27 = arg0.indexOf(13, local27);
                if (local27 < 0) {
                    break;
                }
                local19 += local23;
                local27++;
            }
        }
        @Pc(48) StringBuffer local48 = new StringBuffer(local19);
        @Pc(50) int local50 = 0;
        while (true) {
            @Pc(55) int local55 = arg0.indexOf(13, local50);
            if (local55 < 0) {
                local48.append(arg0.substring(local50));
                return local48.toString();
            }
            local48.append(arg0.substring(local50, local55));
            local50 = local55 + 1;
            local48.append(arg1);
        }
    }

    @OriginalMember(owner = "client!lja", name = "a", descriptor = "(II)Z")
    public static boolean method5262(@OriginalArg(0) int arg0) {
        return arg0 == 3 || arg0 == 5 || arg0 == 6;
    }

}
