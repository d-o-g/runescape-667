import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.lang.ref.SoftReference;

@OriginalClass("client!wi")
public final class Node_Sub2_Sub14_Sub2 extends Node_Sub2_Sub14 {

    @OriginalMember(owner = "client!wi", name = "z", descriptor = "Ljava/lang/ref/SoftReference;")
    public final SoftReference aSoftReference2;

    @OriginalMember(owner = "client!wi", name = "<init>", descriptor = "(Ljava/lang/Object;I)V")
    public Node_Sub2_Sub14_Sub2(@OriginalArg(0) Object arg0, @OriginalArg(1) int arg1) {
        super(arg1);
        this.aSoftReference2 = new SoftReference(arg0);
    }

    @OriginalMember(owner = "client!wi", name = "c", descriptor = "(B)Ljava/lang/Object;")
    @Override
    public Object method9268() {
        return this.aSoftReference2.get();
    }

    @OriginalMember(owner = "client!wi", name = "d", descriptor = "(I)Z")
    @Override
    public boolean method9270() {
        return true;
    }
}
