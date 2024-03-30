import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ta")
public abstract class Option {

    @OriginalMember(owner = "client!ta", name = "c", descriptor = "Lclient!kv;")
    protected final ClientOptions options;

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "I")
    protected int value;

    @OriginalMember(owner = "client!ta", name = "<init>", descriptor = "(Lclient!kv;)V")
    public Option(@OriginalArg(0) ClientOptions options) {
        this.options = options;
        this.value = this.getDefaultValue();
    }

    @OriginalMember(owner = "client!ta", name = "<init>", descriptor = "(ILclient!kv;)V")
    public Option(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        this.value = value;
        this.options = options;
    }

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "(B)V")
    public abstract void validate();

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "(II)V")
    public final void setSafeValue(@OriginalArg(0) int value) {
        if (this.canSet(value) != 3) {
            this.setValue(value);
        }
    }

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "(IB)I")
    public abstract int canSet(@OriginalArg(0) int value);

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "(ZI)V")
    protected abstract void setValue(@OriginalArg(1) int value);

    @OriginalMember(owner = "client!ta", name = "a", descriptor = "(I)I")
    protected abstract int getDefaultValue();
}
