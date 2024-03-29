import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.ImageProgressBarInstance;

@OriginalClass("client!lq")
public final class ImageProgressBar extends ProgressBar {

    @OriginalMember(owner = "client!lq", name = "t", descriptor = "Lclient!st;")
    public Sprite sprite;

    @OriginalMember(owner = "client!lq", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!gha;)V")
    public ImageProgressBar(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) ImageProgressBarInstance instance) {
        super(loadingSprites, fontMetrics, instance);
    }

    @OriginalMember(owner = "client!lq", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        super.init();
        this.sprite = Loading.sprite(((ImageProgressBarInstance) super.instance).sprite, super.loadingSprites);
    }

    @OriginalMember(owner = "client!lq", name = "a", descriptor = "(ZIBI)V")
    @Override
    protected void drawBorder(@OriginalArg(1) int x, @OriginalArg(3) int y) {
        Toolkit.active.outlineRect(x - 2, y, super.instance.width + 4, super.instance.height - -2, ((ImageProgressBarInstance) super.instance).colour, 0);
        Toolkit.active.outlineRect(x - 1, y - -1, super.instance.width + 2, super.instance.height, 0, 0);
    }

    @OriginalMember(owner = "client!lq", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        return super.ready() ? super.loadingSprites.fileready(((ImageProgressBarInstance) super.instance).sprite) : false;
    }

    @OriginalMember(owner = "client!lq", name = "a", descriptor = "(IIZI)V")
    @Override
    protected void drawBackground(@OriginalArg(0) int x, @OriginalArg(3) int y) {
        @Pc(13) int width = (this.progress() * super.instance.width) / 10000;
        @Pc(24) int[] clipping = new int[4];
        Toolkit.active.K(clipping);
        Toolkit.active.KA(x, y + 2, x - -width, y + super.instance.height);
        this.sprite.renderTiled(x, y + 2, super.instance.width, super.instance.height);
        Toolkit.active.KA(clipping[0], clipping[1], clipping[2], clipping[3]);
    }
}
