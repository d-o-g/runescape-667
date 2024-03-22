import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!le")
public final class EnvironmentContext {

    @OriginalMember(owner = "client!le", name = "b", descriptor = "Z")
    public final boolean aBoolean442;

    @OriginalMember(owner = "client!le", name = "n", descriptor = "I")
    public final int anInt5771;

    @OriginalMember(owner = "client!le", name = "k", descriptor = "Z")
    public final boolean aBoolean441;

    @OriginalMember(owner = "client!le", name = "o", descriptor = "I")
    public final int anInt5772;

    @OriginalMember(owner = "client!le", name = "<init>", descriptor = "(ZIIZ)V")
    public EnvironmentContext(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
        this.aBoolean442 = arg0;
        this.anInt5771 = arg2;
        this.aBoolean441 = arg3;
        this.anInt5772 = arg1;
    }

    @OriginalMember(owner = "client!le", name = "d", descriptor = "(B)I")
    public int method5197() {
        return this.anInt5772;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(B)Z")
    public boolean method5198() {
        return this.aBoolean441;
    }

    @OriginalMember(owner = "client!le", name = "c", descriptor = "(B)I")
    public int method5201() {
        return this.anInt5771;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(I)Z")
    public boolean method5203() {
        return this.aBoolean442;
    }
}
