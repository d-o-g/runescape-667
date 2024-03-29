import com.jagex.core.datastruct.key.Queue;
import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!cba")
public final class MiniMenuEntry extends Node2 {

    @OriginalMember(owner = "client!cba", name = "C", descriptor = "I")
    public int size;

    @OriginalMember(owner = "client!cba", name = "x", descriptor = "Ljava/lang/String;")
    public final String title;

    @OriginalMember(owner = "client!cba", name = "A", descriptor = "Lclient!jga;")
    public final Queue innerEntries;

    @OriginalMember(owner = "client!cba", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public MiniMenuEntry(@OriginalArg(0) String title) {
        this.title = title;
        this.innerEntries = new Queue();
    }

    @OriginalMember(owner = "client!cba", name = "d", descriptor = "(B)I")
    public int getAction() {
        return this.innerEntries.sentinel.next2 == this.innerEntries.sentinel ? -1 : ((MiniMenuEntryInner) this.innerEntries.sentinel.next2).action;
    }

    @OriginalMember(owner = "client!cba", name = "b", descriptor = "(ILclient!pg;)Z")
    public boolean remove(@OriginalArg(1) MiniMenuEntryInner entry) {
        @Pc(15) int action = this.getAction();
        entry.unlink2();
        this.size--;

        if (this.size != 0) {
            return action != this.getAction();
        }

        this.unlink();
        this.unlink2();
        MiniMenu.entryCount--;
        MiniMenu.cache.put(this, entry.entryKey);
        return false;
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(ILclient!pg;)Z")
    public boolean add(@OriginalArg(1) MiniMenuEntryInner inner) {
        @Pc(5) boolean changedTypes = true;
        inner.unlink2();

        @Pc(21) MiniMenuEntryInner existing = (MiniMenuEntryInner) this.innerEntries.first();
        while (existing != null) {
            if (MiniMenu.isActionBefore(inner.action, existing.action)) {
                Node2.addBefore(inner, existing);
                this.size++;

                if (changedTypes) {
                    return false;
                }

                return true;
            }

            existing = (MiniMenuEntryInner) this.innerEntries.next();
            changedTypes = false;
        }

        this.innerEntries.add(inner);
        this.size++;
        return changedTypes;
    }
}
