import com.jagex.core.datastruct.key.IterableHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static113 {

    @OriginalMember(owner = "client!dja", name = "g", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___22 = new ClientProt(17, -1);

    @OriginalMember(owner = "client!dja", name = "h", descriptor = "Lclient!av;")
    public static final IterableHashTable A_HASH_TABLE___12 = new IterableHashTable(16);

    @OriginalMember(owner = "client!dja", name = "b", descriptor = "(II)V")
    public static void method2119(@OriginalArg(1) int arg0) {
        Static524.aServerConnection_3 = ConnectionManager.GAME;
        Static299.anInt4825 = 2;
        Static470.anInt7113 = arg0;
        Static238.method3471(Static319.aString51.equals(""), Static319.aString51, true, "");
    }

}
