import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hr")
public final class LoadingSequenceOption extends Option {

    @OriginalMember(owner = "client!hr", name = "<init>", descriptor = "(Lclient!kv;)V")
    public LoadingSequenceOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!hr", name = "<init>", descriptor = "(ILclient!kv;)V")
    public LoadingSequenceOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!hr", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!hr", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 0;
    }

    @OriginalMember(owner = "client!hr", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!hr", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!hr", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
    }
}
