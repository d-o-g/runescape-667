import com.jagex.core.datastruct.key.IterableHashTable;
import org.openrs2.deob.annotation.OriginalMember;

public final class ClientInventoryList {

    @OriginalMember(owner = "client!iw", name = "c", descriptor = "Lclient!av;")
    public static final IterableHashTable recentUse = new IterableHashTable(32);

    @OriginalMember(owner = "client!sba", name = "b", descriptor = "(B)V")
    public static void cacheClear() {
        recentUse.clear();
    }

    private ClientInventoryList() {
        /* empty */
    }
}
