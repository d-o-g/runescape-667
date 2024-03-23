import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!le")
public final class EnvironmentContext {

    @OriginalMember(owner = "client!le", name = "b", descriptor = "Z")
    public final boolean signed;

    @OriginalMember(owner = "client!le", name = "n", descriptor = "I")
    public final int cpuCount;

    @OriginalMember(owner = "client!le", name = "k", descriptor = "Z")
    public final boolean armCpu;

    @OriginalMember(owner = "client!le", name = "o", descriptor = "I")
    public final int heapSize;

    @OriginalMember(owner = "client!le", name = "<init>", descriptor = "(ZIIZ)V")
    public EnvironmentContext(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
        this.signed = arg0;
        this.cpuCount = arg2;
        this.armCpu = arg3;
        this.heapSize = arg1;
    }

    @OriginalMember(owner = "client!le", name = "d", descriptor = "(B)I")
    public int getHeapSize() {
        return this.heapSize;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(B)Z")
    public boolean isArmCpu() {
        return this.armCpu;
    }

    @OriginalMember(owner = "client!le", name = "c", descriptor = "(B)I")
    public int cpuCount() {
        return this.cpuCount;
    }

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(I)Z")
    public boolean isSigned() {
        return this.signed;
    }
}
