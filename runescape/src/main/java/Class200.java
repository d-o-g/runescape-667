import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.LoadingScreenOpType;

@OriginalClass("client!jt")
public final class Class200 implements LoadingScreenOpInstance {

    @OriginalMember(owner = "client!jt", name = "c", descriptor = "I")
    public final int anInt4996;

    @OriginalMember(owner = "client!jt", name = "<init>", descriptor = "(I)V")
    public Class200(@OriginalArg(0) int arg0) {
        this.anInt4996 = arg0;
    }

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "(I)Lclient!kda;")
    @Override
    public LoadingScreenOpType type() {
        return LoadingScreenOpType.BACKGROUND_IMAGE;
    }
}
