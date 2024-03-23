import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ls")
public final class GraphicsQuality extends Option {

    @OriginalMember(owner = "client!ls", name = "<init>", descriptor = "(ILclient!kv;)V")
    public GraphicsQuality(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!ls", name = "<init>", descriptor = "(Lclient!kv;)V")
    public GraphicsQuality(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!ls", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        return 1;
    }

    @OriginalMember(owner = "client!ls", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!ls", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value < 0 || super.value > 4) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!ls", name = "b", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!ls", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 0;
    }
}
