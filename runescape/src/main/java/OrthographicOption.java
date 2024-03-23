import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dja")
public final class OrthographicOption extends Option {

    @OriginalMember(owner = "client!le", name = "a", descriptor = "(II)Z")
    public static boolean method5202(@OriginalArg(1) int value) {
        return value == 2 || value == 3;
    }

    @OriginalMember(owner = "client!dja", name = "<init>", descriptor = "(Lclient!kv;)V")
    public OrthographicOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!dja", name = "<init>", descriptor = "(ILclient!kv;)V")
    public OrthographicOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!dja", name = "c", descriptor = "(B)Z")
    public boolean isCompatible() {
        return true;
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (this.method2118()) {
            if (super.options.toolkit.isActive() && !ToolkitOption.isSoftware(super.options.toolkit.getValue())) {
                super.value = 1;
            }
            if (super.options.screenSize.getValue() == 1) {
                super.value = 1;
            }
        }
        if (super.value == 3) {
            super.value = 2;
        }
        if (super.value < 0 || super.value > 3) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!dja", name = "b", descriptor = "(B)Z")
    public boolean method2118() {
        return method5202(super.value);
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        if (method5202(value)) {
            if (super.options.toolkit.isActive() && !ToolkitOption.isSoftware(super.options.toolkit.getValue())) {
                return 3;
            }
            if (super.options.screenSize.getValue() == 1) {
                return 3;
            }
        }
        if (value == 3) {
            return 3;
        } else if (method5202(value)) {
            return 2;
        } else {
            return 1;
        }
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 0;
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(Z)I")
    public int method2120() {
        return super.value;
    }
}
