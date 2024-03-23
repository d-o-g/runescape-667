import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static533 {

    @OriginalMember(owner = "client!qp", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___196 = new ServerProt(114, 4);

    @OriginalMember(owner = "client!qp", name = "f", descriptor = "[I")
    public static final int[] anIntArray628 = new int[1000];

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(B)V")
    public static void method7119() {
        for (@Pc(8) MiniMenuEntryInner local8 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local8 != null; local8 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
            if (local8.size > 1) {
                local8.size = 0;
                MiniMenu.cache.put(local8, ((MiniMenuEntry) local8.entries.sentinel.next2).entryKey);
                local8.entries.clear();
            }
        }
        MiniMenu.innerCount = 0;
        MiniMenu.entryCount = 0;
        MiniMenu.entry.clear();
        MiniMenu.categories.clear();
        MiniMenu.innerEntries.clear();
        MiniMenu.open = false;
    }
}
