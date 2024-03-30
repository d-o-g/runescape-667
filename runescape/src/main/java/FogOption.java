import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mea")
public final class FogOption extends Option {

    @OriginalMember(owner = "client!mea", name = "<init>", descriptor = "(Lclient!kv;)V")
    public FogOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!mea", name = "<init>", descriptor = "(ILclient!kv;)V")
    public FogOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!mea", name = "b", descriptor = "(B)Z")
    public boolean canMod() {
        return true;
    }

    @OriginalMember(owner = "client!mea", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!mea", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!mea", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return value == 0 || super.options.groundBlending.getValue() == 1 ? 1 : 2;
    }

    @OriginalMember(owner = "client!mea", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!mea", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value != 0 && super.options.groundBlending.getValue() != 1) {
            super.value = 0;
        }
        if (super.value < 0 || super.value > 1) {
            super.value = this.getDefaultValue();
        }
    }
}
