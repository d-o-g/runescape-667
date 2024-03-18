import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jl")
public final class Class145_Sub1 extends Class145 {

    @OriginalMember(owner = "client!jl", name = "<init>", descriptor = "()V")
    public Class145_Sub1() {
    }

    @OriginalMember(owner = "client!jl", name = "a", descriptor = "(Lclient!vw;I)Lclient!vw;")
    @Override
    public ReferenceNode method4433(@OriginalArg(0) ReferenceNode arg0) {
        return new SoftReferenceNode(arg0.get(), arg0.size);
    }
}
