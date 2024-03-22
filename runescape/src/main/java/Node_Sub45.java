import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qfa")
public final class Node_Sub45 extends Node {

    @OriginalMember(owner = "client!qfa", name = "l", descriptor = "Lclient!wj;")
    public final NPCEntity aClass8_Sub2_Sub1_Sub2_Sub2_2;

    @OriginalMember(owner = "client!qfa", name = "<init>", descriptor = "(Lclient!wj;)V")
    public Node_Sub45(@OriginalArg(0) NPCEntity arg0) {
        this.aClass8_Sub2_Sub1_Sub2_Sub2_2 = arg0;
    }
}
