import com.jagex.graphics.ToolkitType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nf")
public final class MaxScreenSizeOption extends Option {

    @OriginalMember(owner = "client!nf", name = "<init>", descriptor = "(Lclient!kv;)V")
    public MaxScreenSizeOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!nf", name = "<init>", descriptor = "(ILclient!kv;)V")
    public MaxScreenSizeOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!nf", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!nf", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.isLowDetail()) {
            super.value = 2;
        }
        if (super.value < 0 || super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!nf", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!nf", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        if (super.options.isLowDetail()) {
            return 2;
        } else if (super.options.toolkit.isActive() && ToolkitType.isSoftware(super.options.toolkit.getValue())) {
            return 1;
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!nf", name = "c", descriptor = "(B)Z")
    public boolean canMod() {
        return !super.options.isLowDetail();
    }

    @OriginalMember(owner = "client!nf", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return super.options.isLowDetail() ? 3 : 1;
    }
}
