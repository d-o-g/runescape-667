import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dl")
public final class RemoveRoofsOption extends Option {

    @OriginalMember(owner = "client!dl", name = "<init>", descriptor = "(Lclient!kv;)V")
    public RemoveRoofsOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!dl", name = "<init>", descriptor = "(ILclient!kv;)V")
    public RemoveRoofsOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!dl", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!dl", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.options.orthographic.method2118() && super.value == 2) {
            super.value = 1;
        }
        if (super.value < 0 || super.value > 2) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!dl", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 2;
    }

    @OriginalMember(owner = "client!dl", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!dl", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 1;
    }
}
