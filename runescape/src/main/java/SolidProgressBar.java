import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.SolidProgressBarInstance;

@OriginalClass("client!gia")
public final class SolidProgressBar extends ProgressBar {

    @OriginalMember(owner = "client!gia", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!il;)V")
    public SolidProgressBar(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) SolidProgressBarInstance instance) {
        super(loadingSprites, fontMetrics, instance);
    }

    @OriginalMember(owner = "client!gia", name = "a", descriptor = "(ZIBI)V")
    @Override
    protected void drawBorder(@OriginalArg(1) int x, @OriginalArg(3) int y) {
        Toolkit.active.outlineRect(x - 2, y, super.instance.width + 4, super.instance.height + 2, ((SolidProgressBarInstance) super.instance).borderColour, 0);
        Toolkit.active.outlineRect(x - 1, y - -1, super.instance.width + 2, super.instance.height, 0, 0);
    }

    @OriginalMember(owner = "client!gia", name = "a", descriptor = "(IIZI)V")
    @Override
    protected void drawBackground(@OriginalArg(0) int x, @OriginalArg(3) int y) {
        @Pc(21) int width = (this.progress() * super.instance.width) / 10000;
        Toolkit.active.aa(x, y + 2, width, super.instance.height - 2, ((SolidProgressBarInstance) super.instance).backgroundColour, 0);
        Toolkit.active.aa(x + width, y + 2, super.instance.width - width, super.instance.height + -2, 0, 0);
    }
}
