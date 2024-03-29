import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sl")
public final class AnimatedProgressBar extends FancyProgressBar {

    @OriginalMember(owner = "client!sl", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!fw;)V")
    public AnimatedProgressBar(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) AnimatedProgressBarInstance instance) {
        super(loadingSprites, fontMetrics, instance);
    }

    @OriginalMember(owner = "client!sl", name = "a", descriptor = "(IIIII)V")
    @Override
    protected void drawCompleted(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(3) int width, @OriginalArg(4) int height) {
        @Pc(14) int barWidth = super.bar.scaleWidth();
        @Pc(26) int offsetX = ((AnimatedProgressBarInstance) super.instance).speed * AwtLoadingScreen.cycles() / 10 % barWidth;
        super.bar.renderTiled(x + offsetX - barWidth, y, barWidth + barWidth - offsetX, height);
    }
}
