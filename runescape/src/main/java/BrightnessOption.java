import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qb")
public final class BrightnessOption extends Option {

    @OriginalMember(owner = "client!qb", name = "<init>", descriptor = "(ILclient!kv;)V")
    public BrightnessOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!qb", name = "<init>", descriptor = "(Lclient!kv;)V")
    public BrightnessOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value < 0 || super.value > 4) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!qb", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 3;
    }
}
