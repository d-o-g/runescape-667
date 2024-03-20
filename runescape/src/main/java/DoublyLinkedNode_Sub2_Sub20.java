import com.jagex.collect.LinkedHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vb")
public final class DoublyLinkedNode_Sub2_Sub20 extends LinkedHashTable.Node {

    @OriginalMember(owner = "client!vb", name = "t", descriptor = "Lclient!pja;")
    public final Class8_Sub2_Sub1_Sub5 aClass8_Sub2_Sub1_Sub5_1;

    @OriginalMember(owner = "client!vb", name = "<init>", descriptor = "(Lclient!pja;)V")
    public DoublyLinkedNode_Sub2_Sub20(@OriginalArg(0) Class8_Sub2_Sub1_Sub5 arg0) {
        this.aClass8_Sub2_Sub1_Sub5_1 = arg0;
    }
}
