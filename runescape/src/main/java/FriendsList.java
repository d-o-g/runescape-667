import com.jagex.core.datastruct.LinkedList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class FriendsList {

    @OriginalMember(owner = "client!kha", name = "g", descriptor = "[Ljava/lang/String;")
    public static final String[] names = new String[200];

    @OriginalMember(owner = "client!lma", name = "a", descriptor = "[I")
    public static final int[] worlds = new int[200];

    @OriginalMember(owner = "client!fda", name = "c", descriptor = "Lclient!fla;")
    public static final LinkedList notifications = new LinkedList();

    @OriginalMember(owner = "client!s", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] formerNames = new String[200];

    @OriginalMember(owner = "client!ne", name = "u", descriptor = "[Ljava/lang/String;")
    public static final String[] worldNames = new String[200];

    @OriginalMember(owner = "client!wla", name = "p", descriptor = "[I")
    public static final int[] ranks = new int[200];

    @OriginalMember(owner = "client!tm", name = "a", descriptor = "[Z")
    public static final boolean[] sameGameFlags = new boolean[200];

    @OriginalMember(owner = "client!nj", name = "g", descriptor = "[Z")
    public static final boolean[] referredFlags = new boolean[200];

    @OriginalMember(owner = "client!kg", name = "N", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!kr", name = "o", descriptor = "I")
    public static int lastTransmit = 0;

    @OriginalMember(owner = "client!ho", name = "l", descriptor = "I")
    public static int status = 0;

    @OriginalMember(owner = "client!lha", name = "a", descriptor = "(ILjava/lang/String;)Z")
    public static boolean method5241(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
        if (arg1 == null) {
            return false;
        }
        for (@Pc(10) int local10 = arg0; local10 < count; local10++) {
            if (arg1.equalsIgnoreCase(names[local10])) {
                return true;
            }
        }
        return arg1.equalsIgnoreCase(PlayerEntity.self.accountName);
    }
}
