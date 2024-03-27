import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static533 {

    @OriginalMember(owner = "client!qp", name = "d", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___196 = new ServerProt(114, 4);

    @OriginalMember(owner = "client!qp", name = "a", descriptor = "(B)V")
    public static void method7119() {
        for (@Pc(8) MiniMenuEntry local8 = (MiniMenuEntry) MiniMenu.entryQueue.first(); local8 != null; local8 = (MiniMenuEntry) MiniMenu.entryQueue.next()) {
            if (local8.size > 1) {
                local8.size = 0;
                MiniMenu.cache.put(local8, ((MiniMenuEntryInner) local8.innerEntries.sentinel.next2).entryKey);
                local8.innerEntries.clear();
            }
        }
        MiniMenu.entryCount = 0;
        MiniMenu.innerEntryCount = 0;
        MiniMenu.innerEntryQueue.clear();
        MiniMenu.entryTable.clear();
        MiniMenu.entryQueue.clear();
        MiniMenu.open = false;
    }
}
