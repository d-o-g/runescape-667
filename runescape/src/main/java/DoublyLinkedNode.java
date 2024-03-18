import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cm")
public class DoublyLinkedNode extends Node {

    @OriginalMember(owner = "client!cm", name = "l", descriptor = "Lclient!cm;")
    public DoublyLinkedNode next2;

    @OriginalMember(owner = "client!cm", name = "s", descriptor = "Lclient!cm;")
    public DoublyLinkedNode prev2;

    @OriginalMember(owner = "client!cm", name = "m", descriptor = "J")
    public long key2;

    @OriginalMember(owner = "client!cm", name = "c", descriptor = "(I)V")
    public final void remove2() {
        if (this.prev2 != null) {
            this.prev2.next2 = this.next2;
            this.next2.prev2 = this.prev2;
            this.next2 = null;
            this.prev2 = null;
        }
    }

    @OriginalMember(owner = "client!cm", name = "b", descriptor = "(B)Z")
    public final boolean isLinked2() {
        return this.prev2 != null;
    }
}
