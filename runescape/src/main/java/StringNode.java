import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hk")
public final class StringNode extends Node {

    @OriginalMember(owner = "client!hk", name = "k", descriptor = "Ljava/lang/String;")
    public String aString46;

    @OriginalMember(owner = "client!hk", name = "<init>", descriptor = "()V")
    public StringNode() {
    }

    @OriginalMember(owner = "client!hk", name = "<init>", descriptor = "(Ljava/lang/String;)V")
    public StringNode(@OriginalArg(0) String arg0) {
        this.aString46 = arg0;
    }
}
