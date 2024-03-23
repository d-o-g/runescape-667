import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qka")
public final class LightDetailOption extends Option {

    @OriginalMember(owner = "client!qka", name = "<init>", descriptor = "(Lclient!kv;)V")
    public LightDetailOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!qka", name = "<init>", descriptor = "(ILclient!kv;)V")
    public LightDetailOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value != 1 && super.value != 0) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!qka", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 1;
    }
}
