import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jh")
public final class HardShadowsOption extends Option {

    @OriginalMember(owner = "client!jh", name = "<init>", descriptor = "(ILclient!kv;)V")
    public HardShadowsOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!jh", name = "<init>", descriptor = "(Lclient!kv;)V")
    public HardShadowsOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!jh", name = "b", descriptor = "(B)Z")
    public boolean isCompatible() {
        if (super.options.isLowDetail()) {
            return false;
        } else {
            return super.options.textures.getvalue() != 0;
        }
    }

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 2;
    }

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        if (super.options.isLowDetail()) {
            return 3;
        } else if (super.options.textures.getvalue() == 0) {
            return 3;
        } else {
            return 1;
        }
    }

    @OriginalMember(owner = "client!jh", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.isLowDetail()) {
            super.value = 0;
        }
        if (super.options.textures.getvalue() == 0) {
            super.value = 0;
        }
        if (super.value < 0 || super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }
}
