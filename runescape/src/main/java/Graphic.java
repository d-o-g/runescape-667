import com.jagex.graphics.ClippingMask;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!he")
public final class Graphic {

    @OriginalMember(owner = "client!he", name = "j", descriptor = "Lclient!aa;")
    public final ClippingMask clippingMask;

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
    public Graphic(@OriginalArg(0) int scaleWidth, @OriginalArg(1) int scaleHeight, @OriginalArg(2) int[] lineWidths, @OriginalArg(3) int[] lineOffsets, @OriginalArg(4) ClippingMask clippingMask, @OriginalArg(5) int id) {
        this.clippingMask = clippingMask;
        this.lineWidths = lineWidths;
        this.lineOffsets = lineOffsets;
        this.scaleHeight = scaleHeight;
        this.id = id;
        this.scaleWidth = scaleWidth;
    }
}
