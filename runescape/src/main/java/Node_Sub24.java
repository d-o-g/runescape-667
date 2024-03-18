import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hk")
public final class Node_Sub24 extends Node {

    @OriginalMember(owner = "client!hk", name = "k", descriptor = "Ljava/lang/String;")
    public String aString46;

    @OriginalMember(owner = "client!hk", name = "<init>", descriptor = "()V")
    public Node_Sub24() {
    }

    @OriginalMember(owner = "client!hk", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public Node_Sub24(@OriginalArg(0) String arg0) {
        this.aString46 = arg0;
    }
}
