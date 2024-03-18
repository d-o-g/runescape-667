import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!vw")
public abstract class Node_Sub2_Sub14 extends Node_Sub2 {

    @OriginalMember(owner = "client!vw", name = "w", descriptor = "I")
    public final int anInt10683;

    @OriginalMember(owner = "client!vw", name = "<init>", descriptor = "(I)V")
    protected Node_Sub2_Sub14(@OriginalArg(0) int arg0) {
        this.anInt10683 = arg0;
    }

    @OriginalMember(owner = "client!vw", name = "c", descriptor = "(B)Ljava/lang/Object;")
    public abstract Object method9268();

    @OriginalMember(owner = "client!vw", name = "d", descriptor = "(I)Z")
    public abstract boolean method9270();
}
