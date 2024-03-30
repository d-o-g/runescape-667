import com.jagex.graphics.ClippingMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ii")
public final class JavaClippingMask extends ClippingMask {

    @OriginalMember(owner = "client!ii", name = "f", descriptor = "[I")
    public final int[] lineWidths;

    @OriginalMember(owner = "client!ii", name = "g", descriptor = "[I")
    public final int[] lineOffsets;

    @OriginalMember(owner = "client!ii", name = "<init>", descriptor = "(II[I[I)V")
    public JavaClippingMask(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int[] arg3) {
        this.lineWidths = arg3;
        this.lineOffsets = arg2;
    }
}
