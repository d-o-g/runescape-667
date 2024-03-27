import com.jagex.LibraryList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!tba")
public final class ToolkitOption extends Option {

    @OriginalMember(owner = "client!tba", name = "e", descriptor = "Z")
    public boolean dflt = false;

    @OriginalMember(owner = "client!tba", name = "k", descriptor = "Z")
    public boolean active = true;

    @OriginalMember(owner = "client!tba", name = "<init>", descriptor = "(ILclient!kv;)V")
    public ToolkitOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!tba", name = "<init>", descriptor = "(Lclient!kv;)V")
    public ToolkitOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!tba", name = "b", descriptor = "(I)Z")
    public boolean isActive() {
        return this.active;
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        if (!super.options.getEnvironment().isSigned()) {
            super.value = 0;
        }
        if (super.value < 0 || super.value > 5) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        this.dflt = true;
        return super.options.getEnvironment().isSigned() ? 2 : 0;
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        this.dflt = false;
        super.value = value;
    }

    @OriginalMember(owner = "client!tba", name = "c", descriptor = "(B)Z")
    public boolean isCompatible() {
        return super.options.getEnvironment().isSigned();
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(ZB)V")
    public void setActive(@OriginalArg(0) boolean active) {
        this.active = active;
    }

    @OriginalMember(owner = "client!tba", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        if (super.options.getEnvironment().isSigned()) {
            return value == 3 && !LibraryList.isLoaded("jagdx") ? 3 : 2;
        } else {
            return 3;
        }
    }
}
