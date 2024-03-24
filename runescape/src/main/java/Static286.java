import com.jagex.core.datastruct.key.IterableHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static286 {

    @OriginalMember(owner = "client!iw", name = "d", descriptor = "[I")
    public static int[] anIntArray358;

    @OriginalMember(owner = "client!iw", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___117 = new ServerProt(32, -1);

    @OriginalMember(owner = "client!iw", name = "f", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___118 = new ServerProt(95, 6);

    @OriginalMember(owner = "client!iw", name = "c", descriptor = "Lclient!av;")
    public static final IterableHashTable A_HASH_TABLE___23 = new IterableHashTable(32);

    @OriginalMember(owner = "client!iw", name = "a", descriptor = "(III)Z")
    public static boolean method4110(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return Static710.method6713(arg0, arg1) & Static240.method3483(arg1, arg0);
    }
}
