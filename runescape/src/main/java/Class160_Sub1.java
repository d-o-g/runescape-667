import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!hea")
public final class Class160_Sub1 extends Class160 {

    @OriginalMember(owner = "client!hea", name = "n", descriptor = "I")
    public final int anInt3853;

    @OriginalMember(owner = "client!hea", name = "<init>", descriptor = "(ILclient!wk;Lclient!ek;III)V")
    public Class160_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) HorizontalAlignment arg1, @OriginalArg(2) VerticalAlignment arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
        super(arg0, arg1, arg2, arg3, arg4);
        this.anInt3853 = arg5;
    }

    @OriginalMember(owner = "client!hea", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.ROTATING_IMAGE;
    }
}
