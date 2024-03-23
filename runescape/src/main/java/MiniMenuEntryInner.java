import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!cba")
public final class MiniMenuEntryInner extends Node2 {

    @OriginalMember(owner = "client!cba", name = "C", descriptor = "I")
    public int size;

    @OriginalMember(owner = "client!cba", name = "x", descriptor = "Ljava/lang/String;")
    public final String title;

    @OriginalMember(owner = "client!cba", name = "A", descriptor = "Lclient!jga;")
    public final Queue entries;

    @OriginalMember(owner = "client!cba", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public MiniMenuEntryInner(@OriginalArg(0) String title) {
        this.title = title;
        this.entries = new Queue();
    }

    @OriginalMember(owner = "client!cba", name = "d", descriptor = "(B)I")
    public int getAction() {
        return this.entries.sentinel.next2 == this.entries.sentinel ? -1 : ((MiniMenuEntry) this.entries.sentinel.next2).action;
    }

    @OriginalMember(owner = "client!cba", name = "b", descriptor = "(ILclient!pg;)Z")
    public boolean remove(@OriginalArg(1) MiniMenuEntry entry) {
        @Pc(15) int action = this.getAction();
        entry.unlink2();
        this.size--;

        if (this.size != 0) {
            return action != this.getAction();
        }

        this.unlink();
        this.unlink2();
        MiniMenu.innerCount--;
        MiniMenu.cache.put(this, entry.entryKey);
        return false;
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(ILclient!pg;)Z")
    public boolean add(@OriginalArg(1) MiniMenuEntry entry) {
        @Pc(5) boolean changedTypes = true;
        entry.unlink2();

        @Pc(21) MiniMenuEntry existing = (MiniMenuEntry) this.entries.first();
        while (existing != null) {
            if (MiniMenu.isActionBefore(entry.action, existing.action)) {
                Node2.attachBefore(entry, existing);
                this.size++;

                if (changedTypes) {
                    return false;
                }

                return true;
            }

            existing = (MiniMenuEntry) this.entries.next();
            changedTypes = false;
        }

        this.entries.add(entry);
        this.size++;
        return changedTypes;
    }
}
