import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sba")
public final class Class331 {

    @OriginalMember(owner = "client!sba", name = "i", descriptor = "Lclient!av;")
    public Class28 aClass28_41;

    @OriginalMember(owner = "client!sba", name = "j", descriptor = "Lclient!ie;")
    public Node aNode_266;

    @OriginalMember(owner = "client!sba", name = "k", descriptor = "I")
    public int anInt8579 = 0;

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "()V")
    public Class331() {
    }

    @OriginalMember(owner = "client!sba", name = "<init>", descriptor = "(Lclient!av;)V")
    public Class331(@OriginalArg(0) Class28 arg0) {
        this.aClass28_41 = arg0;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(I)Lclient!ie;")
    public Node method7610() {
        @Pc(23) Node local23;
        if (this.anInt8579 > 0 && this.aClass28_41.aNodeArray1[this.anInt8579 - 1] != this.aNode_266) {
            local23 = this.aNode_266;
            this.aNode_266 = local23.next;
            return local23;
        }
        while (this.aClass28_41.anInt638 > this.anInt8579) {
            local23 = this.aClass28_41.aNodeArray1[this.anInt8579++].next;
            if (this.aClass28_41.aNodeArray1[this.anInt8579 - 1] != local23) {
                this.aNode_266 = local23.next;
                return local23;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(Z)Lclient!ie;")
    public Node method7613() {
        this.anInt8579 = 0;
        return this.method7610();
    }
}
