import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!oq")
public final class CpuUsageOption extends Option {

    @OriginalMember(owner = "client!oq", name = "<init>", descriptor = "(ILclient!kv;)V")
    public CpuUsageOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!oq", name = "<init>", descriptor = "(Lclient!kv;)V")
    public CpuUsageOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value < 0 && super.value > 4) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!oq", name = "b", descriptor = "(Z)I")
    public int value() {
        return super.value;
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!oq", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return super.options.getEnvironment().cpuCount() > 1 ? 4 : 2;
    }
}
