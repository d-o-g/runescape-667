import com.jagex.collect.Deque;
import com.jagex.collect.HashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sba")
public final class Class331 {

    @OriginalMember(owner = "client!sba", name = "i", descriptor = "Lclient!av;")
    public HashTable aHashTable_41;

    @OriginalMember(owner = "client!sba", name = "j", descriptor = "Lclient!ie;")
    public Deque.Node aNode_266;

    @OriginalMember(owner = "client!sba", name = "k", descriptor = "I")
    public int anInt8579 = 0;

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "()V")
    public Class331() {
    }

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "(Lclient!av;)V")
    public Class331(@OriginalArg(0) HashTable arg0) {
        this.aHashTable_41 = arg0;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(I)Lclient!ie;")
    public Deque.Node method7610() {
        @Pc(23) Deque.Node local23;
        if (this.anInt8579 > 0 && this.aHashTable_41.buckets[this.anInt8579 - 1] != this.aNode_266) {
            local23 = this.aNode_266;
            this.aNode_266 = local23.next;
            return local23;
        }
        while (this.aHashTable_41.bucketCount > this.anInt8579) {
            local23 = this.aHashTable_41.buckets[this.anInt8579++].next;
            if (this.aHashTable_41.buckets[this.anInt8579 - 1] != local23) {
                this.aNode_266 = local23.next;
                return local23;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(Z)Lclient!ie;")
    public Deque.Node method7613() {
        this.anInt8579 = 0;
        return this.method7610();
    }
}
