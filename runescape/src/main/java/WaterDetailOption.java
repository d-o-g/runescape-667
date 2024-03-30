import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ro")
public final class WaterDetailOption extends Option {

    @OriginalMember(owner = "client!ro", name = "<init>", descriptor = "(ILclient!kv;)V")
    public WaterDetailOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!ro", name = "<init>", descriptor = "(Lclient!kv;)V")
    public WaterDetailOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!ro", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        if (super.options.isLowDetail()) {
            return 3;
        } else if (value == 0 || super.options.groundBlending.getValue() == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @OriginalMember(owner = "client!ro", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!ro", name = "b", descriptor = "(B)Z")
    public boolean canMod() {
        return !super.options.isLowDetail();
    }

    @OriginalMember(owner = "client!ro", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!ro", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.isLowDetail()) {
            super.value = 0;
        }
        if (super.value < 0 && super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!ro", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }
}
