import com.jagex.graphics.ToolkitType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dja")
public final class OrthographicOption extends Option {

    @OriginalMember(owner = "client!dja", name = "<init>", descriptor = "(Lclient!kv;)V")
    public OrthographicOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!dja", name = "<init>", descriptor = "(ILclient!kv;)V")
    public OrthographicOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!mba", name = "a", descriptor = "(II)Z")
    public static boolean isSoftware(@OriginalArg(0) int value) {
        return value == 0 || value == 2;
    }

    @OriginalMember(owner = "client!dja", name = "c", descriptor = "(B)Z")
    public boolean canMod() {
        return true;
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (this.isToolkitCompatible()) {
            if (super.options.toolkit.isActive() && !isSoftware(super.options.toolkit.getValue())) {
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
    public boolean isToolkitCompatible() {
        return ToolkitType.is3d(super.value);
    }

    @OriginalMember(owner = "client!dja", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        if (ToolkitType.is3d(value)) {
            if (super.options.toolkit.isActive() && !isSoftware(super.options.toolkit.getValue())) {
                return 3;
            }
            if (super.options.screenSize.getValue() == 1) {
                return 3;
            }
        }
        if (value == 3) {
            return 3;
        } else if (ToolkitType.is3d(value)) {
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
    public int getValue() {
        return super.value;
    }
}
