import com.jagex.core.datastruct.key.Node2;
import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!aj")
public final class DoublyLinkedNode_Sub2__ extends Node2 {

    @OriginalMember(owner = "client!aj", name = "x", descriptor = "Ljava/lang/String;")
    public String aString1;

    @OriginalMember(owner = "client!aj", name = "A", descriptor = "I")
    public int anInt192;

    @OriginalMember(owner = "client!aj", name = "w", descriptor = "I")
    public int secondaryData;

    @OriginalMember(owner = "client!aj", name = "t", descriptor = "I")
    public int primaryData;

    @OriginalMember(owner = "client!aj", name = "<init>", descriptor = "(IJ)V")
    public DoublyLinkedNode_Sub2__(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1) {
        super.key = arg1 | (long) arg0 << 56;
    }

    @OriginalMember(owner = "client!aj", name = "g", descriptor = "(I)J")
    public long method201() {
        return super.key2 & Long.MAX_VALUE;
    }

    @OriginalMember(owner = "client!aj", name = "i", descriptor = "(I)V")
    public void method202() {
        super.key2 |= Long.MIN_VALUE;
        if (this.method201() == (long) 0) {
            Static138.A_QUEUE___6.add(this);
        }
    }

    @OriginalMember(owner = "client!aj", name = "a", descriptor = "(I)I")
    public int method203() {
        return (int) (super.key >>> 56 & 0xFFL);
    }

    @OriginalMember(owner = "client!aj", name = "h", descriptor = "(I)J")
    public long method204() {
        return super.key & 0xFFFFFFFFFFFFFFL;
    }

    @OriginalMember(owner = "client!aj", name = "c", descriptor = "(B)V")
    public void method205() {
        super.key2 = SystemTimer.safetime() + 500L | super.key2 & Long.MIN_VALUE;
        Static59.A_QUEUE___9.add(this);
    }
}
