import com.jagex.collect.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nw")
public final class Node_Sub40 extends Node {

    @OriginalMember(owner = "client!nw", name = "l", descriptor = "[I")
    public final int[] anIntArray531;

    @OriginalMember(owner = "client!nw", name = "<init>", descriptor = "(I)V")
    public Node_Sub40(@OriginalArg(0) int arg0) {
        this.anIntArray531 = new int[arg0];
    }
}
