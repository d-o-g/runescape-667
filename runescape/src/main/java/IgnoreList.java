import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class IgnoreList {

    @OriginalMember(owner = "client!oaa", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] accountNames = new String[100];

    @OriginalMember(owner = "client!ka", name = "h", descriptor = "[Ljava/lang/String;")
    public static final String[] formerAccountNames = new String[100];

    @OriginalMember(owner = "client!u", name = "l", descriptor = "[Ljava/lang/String;")
    public static final String[] names = new String[100];

    @OriginalMember(owner = "client!afa", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] formerNames = new String[100];

    @OriginalMember(owner = "client!cba", name = "D", descriptor = "[Z")
    public static final boolean[] temporary = new boolean[100];

    @OriginalMember(owner = "client!no", name = "c", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!cea", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean contains(@OriginalArg(1) String name) {
        if (name == null) {
            return false;
        }

        for (@Pc(16) int i = 0; i < count; i++) {
            if (name.equalsIgnoreCase(accountNames[i])) {
                return true;
            }
            if (name.equalsIgnoreCase(formerAccountNames[i])) {
                return true;
            }
        }

        return false;
    }

    private IgnoreList() {
        /* empty */
    }
}
