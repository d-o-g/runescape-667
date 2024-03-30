import com.jagex.graphics.ToolkitType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dc")
public final class SkyboxesOption extends Option {

    @OriginalMember(owner = "client!dc", name = "<init>", descriptor = "(Lclient!kv;)V")
    public SkyboxesOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!dc", name = "<init>", descriptor = "(ILclient!kv;)V")
    public SkyboxesOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!dc", name = "b", descriptor = "(B)Z")
    public boolean canMod() {
        return ToolkitType.isHardware(super.options.toolkit.getValue());
    }

    @OriginalMember(owner = "client!dc", name = "a", descriptor = "(IB)I")
    @Override
    public int canSet(@OriginalArg(0) int value) {
        return ToolkitType.isHardware(super.options.toolkit.getValue()) ? 1 : 3;
    }

    @OriginalMember(owner = "client!dc", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (super.value < 0 || super.value > 1) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!dc", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!dc", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 1;
    }

    @OriginalMember(owner = "client!dc", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }
}
