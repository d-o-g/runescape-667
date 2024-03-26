import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static41 {

    @OriginalMember(owner = "client!bg", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___20 = new ServerProt(96, 7);

    @OriginalMember(owner = "client!bg", name = "a", descriptor = "(II)Z")
    public static boolean method1027(@OriginalArg(0) int arg0) {
        return arg0 == 3 || arg0 == 4 || arg0 == 5 || arg0 == 6;
    }

}
