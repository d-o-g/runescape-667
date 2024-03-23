import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!gq")
public final class SmallTexturesOption extends Option {

    @OriginalMember(owner = "client!gq", name = "<init>", descriptor = "(ILclient!kv;)V")
    public SmallTexturesOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!gq", name = "<init>", descriptor = "(Lclient!kv;)V")
    public SmallTexturesOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        super.value = this.getDefaultValue();
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 3;
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return super.options.isLowDetail() ? 1 : 0;
    }

    @OriginalMember(owner = "client!gq", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }
}
