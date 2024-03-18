import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nca")
public final class Node_Sub38 extends Node {

    @OriginalMember(owner = "client!nca", name = "p", descriptor = "I")
    public int anInt6379;

    @OriginalMember(owner = "client!nca", name = "<init>", descriptor = "()V")
    public Node_Sub38() {
    }

    @OriginalMember(owner = "client!nca", name = "<init>", descriptor = "(I)V")
    public Node_Sub38(@OriginalArg(0) int arg0) {
        this.anInt6379 = arg0;
    }
}
