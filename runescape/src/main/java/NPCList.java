import com.jagex.core.datastruct.key.IterableHashTable;
import org.openrs2.deob.annotation.OriginalMember;

public final class NPCList {
    @OriginalMember(owner = "client!aka", name = "m", descriptor = "Lclient!av;")
    public static final IterableHashTable local = new IterableHashTable(64);

    private NPCList() {
        /* empty */
    }
}
