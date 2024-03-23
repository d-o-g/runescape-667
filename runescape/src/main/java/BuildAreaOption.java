import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!dma")
public final class BuildAreaOption extends Option {

    @OriginalMember(owner = "client!dma", name = "<init>", descriptor = "(ILclient!kv;)V")
    public BuildAreaOption(@OriginalArg(0) int value, @OriginalArg(1) ClientOptions options) {
        super(value, options);
    }

    @OriginalMember(owner = "client!dma", name = "<init>", descriptor = "(Lclient!kv;)V")
    public BuildAreaOption(@OriginalArg(0) ClientOptions options) {
        super(options);
    }

    @OriginalMember(owner = "client!dma", name = "a", descriptor = "(ZI)V")
    @Override
    protected void setValue(@OriginalArg(1) int value) {
        super.value = value;
    }

    @OriginalMember(owner = "client!dma", name = "a", descriptor = "(Z)I")
    public int getValue() {
        return super.value;
    }

    @OriginalMember(owner = "client!dma", name = "b", descriptor = "(B)Z")
    public boolean isCompatible() {
        @Pc(10) int heapSize = super.options.getEnvironment().getHeapSize();
        return heapSize >= 96;
    }

    @OriginalMember(owner = "client!dma", name = "a", descriptor = "(B)V")
    @Override
    public void validate() {
        @Pc(17) int heapSize = super.options.getEnvironment().getHeapSize();

        if (heapSize < 96) {
            super.value = 0;
        }
        if (super.value > 1 && heapSize < 128) {
            super.value = 1;
        }
        if (super.value > 2 && heapSize < 192) {
            super.value = 2;
        }
        if (super.value < 0 || super.value > 3) {
            super.value = this.getDefaultValue();
        }
    }

    @OriginalMember(owner = "client!dma", name = "a", descriptor = "(I)I")
    @Override
    protected int getDefaultValue() {
        return 0;
    }

    @OriginalMember(owner = "client!dma", name = "a", descriptor = "(IB)I")
    @Override
    public int getCompatibility(@OriginalArg(0) int value) {
        @Pc(10) int heapSize = super.options.getEnvironment().getHeapSize();

        if (heapSize < 96) {
            return 3;
        } else if (value > 1 && heapSize < 128) {
            return 3;
        } else if (value > 3 && heapSize < 192) {
            return 3;
        } else {
            return 1;
        }
    }
}
