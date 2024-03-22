import com.jagex.graphics.ClippingMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!he")
public final class Graphic {

    @OriginalMember(owner = "client!he", name = "j", descriptor = "Lclient!aa;")
    public final ClippingMask aClippingMask;

    @OriginalMember(owner = "client!he", name = "i", descriptor = "[I")
    public final int[] lineWidths;

    @OriginalMember(owner = "client!he", name = "e", descriptor = "[I")
    public final int[] lineOffsets;

    @OriginalMember(owner = "client!he", name = "h", descriptor = "I")
    public final int scaleHeight;

    @OriginalMember(owner = "client!he", name = "l", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!he", name = "b", descriptor = "I")
    public final int scaleWidth;

    @OriginalMember(owner = "client!he", name = "<init>", descriptor = "(II[I[ILclient!aa;I)V")
    public Graphic(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int[] arg3, @OriginalArg(4) ClippingMask arg4, @OriginalArg(5) int arg5) {
        this.aClippingMask = arg4;
        this.lineWidths = arg2;
        this.lineOffsets = arg3;
        this.scaleHeight = arg1;
        this.id = arg5;
        this.scaleWidth = arg0;
    }
}
