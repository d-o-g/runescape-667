import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lo")
public final class CustomCursors extends Option {

    @OriginalMember(owner = "client!lo", name = "<init>", descriptor = "(Lclient!kv;)V")
    public CustomCursors(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!lo", name = "<init>", descriptor = "(ILclient!kv;)V")
    public CustomCursors(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value != 1 && super.value != 0) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!lo", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }
}
