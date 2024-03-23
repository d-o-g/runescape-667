import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jha")
public final class AntialiasingMode extends Option {

    @OriginalMember(owner = "client!jha", name = "<init>", descriptor = "(Lclient!kv;)V")
    public AntialiasingMode(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!jha", name = "<init>", descriptor = "(ILclient!kv;)V")
    public AntialiasingMode(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return ToolkitOption.isHardware(super.options.toolkit.getValue()) ? 1 : 3;
    }

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.toolkit.isActive() && !ToolkitOption.isHardware(super.options.toolkit.getValue())) {
            super.value = 0;
        }
        if (super.value < 0 || super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!jha", name = "c", descriptor = "(B)Z")
    public boolean isCompatible() {
        return ToolkitOption.isHardware(super.options.toolkit.getValue());
    }

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!jha", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 0;
    }
}
