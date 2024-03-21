import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cl")
public final class Class70 {

    @OriginalMember(owner = "client!cl", name = "b", descriptor = "Lclient!da;")
    public Font aFont_1 = null;

    @OriginalMember(owner = "client!cl", name = "d", descriptor = "Lclient!ve;")
    public FontMetrics aFontMetrics_5 = null;

    @OriginalMember(owner = "client!cl", name = "<init>", descriptor = "(Lclient!da;)V")
    public Class70(@OriginalArg(0) Font arg0) {
        this.aFont_1 = arg0;
    }

    @OriginalMember(owner = "client!cl", name = "<init>", descriptor = "(Lclient!da;Lclient!ve;)V")
    public Class70(@OriginalArg(0) Font arg0, @OriginalArg(1) FontMetrics arg1) {
        this.aFont_1 = arg0;
        this.aFontMetrics_5 = arg1;
    }
}
