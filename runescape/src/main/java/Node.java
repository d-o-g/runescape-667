import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ie")
public class Node {

    @OriginalMember(owner = "client!ie", name = "f", descriptor = "J")
    public long aLong328;

    @OriginalMember(owner = "client!ie", name = "c", descriptor = "Lclient!ie;")
    public Node aNode_345;

    @OriginalMember(owner = "client!ie", name = "i", descriptor = "Lclient!ie;")
    public Node aNode_346;

    @OriginalMember(owner = "client!ie", name = "a", descriptor = "(B)V")
    public final void method9457() {
        if (this.aNode_345 != null) {
            this.aNode_345.aNode_346 = this.aNode_346;
            this.aNode_346.aNode_345 = this.aNode_345;
            this.aNode_346 = null;
            this.aNode_345 = null;
        }
    }

    @OriginalMember(owner = "client!ie", name = "e", descriptor = "(I)Z")
    public final boolean method9458() {
        return this.aNode_345 != null;
    }
}
