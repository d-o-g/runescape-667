import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!g")
public final class SpotShadowsOption extends Option {

    @OriginalMember(owner = "client!g", name = "<init>", descriptor = "(Lclient!kv;)V")
    public SpotShadowsOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!g", name = "<init>", descriptor = "(ILclient!kv;)V")
    public SpotShadowsOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!g", name = "c", descriptor = "(B)Z")
    public boolean isCompatible() {
        return !super.options.isLowDetail();
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.isLowDetail()) {
            super.value = 0;
        }
        if (super.value != 1 && super.value != 0) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return super.options.isLowDetail() ? 3 : 1;
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }
}
