import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.FancyProgressBarInstance;

@OriginalClass("client!gr")
public class FancyProgressBar extends ProgressBar {

    @OriginalMember(owner = "client!gr", name = "x", descriptor = "Lclient!st;")
    public Sprite right;

    @OriginalMember(owner = "client!gr", name = "s", descriptor = "Lclient!st;")
    public Sprite left;

    @OriginalMember(owner = "client!gr", name = "z", descriptor = "Lclient!st;")
    public Sprite top;

    @OriginalMember(owner = "client!gr", name = "q", descriptor = "Lclient!st;")
    public Sprite bottom;

    @OriginalMember(owner = "client!gr", name = "r", descriptor = "Lclient!st;")
    public Sprite background;

    @OriginalMember(owner = "client!gr", name = "y", descriptor = "Lclient!st;")
    protected Sprite bar;

    @OriginalMember(owner = "client!gr", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!rk;)V")
    public FancyProgressBar(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) FancyProgressBarInstance instance) {
        super(loadingSprites, fontMetrics, instance);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(ZIBI)V")
    @Override
    protected final void drawBorder(@OriginalArg(1) int x, @OriginalArg(3) int y) {
        @Pc(8) int[] clipping = new int[4];
        Toolkit.active.K(clipping);
        Toolkit.active.KA(x, y, x + super.instance.width, super.instance.height + y);

        @Pc(30) int leftWidth = this.left.scaleWidth();
        @Pc(34) int leftHeight = this.left.scaleHeight();

        @Pc(38) int rightWidth = this.right.scaleWidth();
        @Pc(42) int rightHeight = this.right.scaleHeight();

        this.left.render(x, (super.instance.height - leftHeight) / 2 + y);
        this.right.render(super.instance.width + x - rightWidth, (-rightHeight + super.instance.height) / 2 + y);

        Toolkit.active.KA(x, y, super.instance.width + x, this.top.scaleHeight() + y);
        this.top.renderTiled(leftWidth + x, y, super.instance.width - rightWidth - leftWidth, super.instance.height);

        @Pc(112) int height = this.bottom.scaleHeight();

        Toolkit.active.KA(x, super.instance.height + y - height, x + super.instance.width, y + super.instance.height);
        this.bottom.renderTiled(leftWidth + x, super.instance.height + y + -height, super.instance.width - leftWidth - rightWidth, super.instance.height);

        Toolkit.active.KA(clipping[0], clipping[1], clipping[2], clipping[3]);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(IIZI)V")
    @Override
    protected final void drawBackground(@OriginalArg(0) int x, @OriginalArg(3) int y) {
        @Pc(9) int x1 = x + this.left.scaleWidth();
        @Pc(27) int x2 = x + super.instance.width - this.right.scaleWidth();
        @Pc(33) int y1 = this.top.scaleHeight() + y;
        @Pc(45) int y2 = y + super.instance.height - this.bottom.scaleHeight();
        @Pc(50) int width = x2 - x1;
        @Pc(55) int height = y2 - y1;
        @Pc(63) int progressWidth = (this.progress() * width) / 10000;

        @Pc(66) int[] clipping = new int[4];
        Toolkit.active.K(clipping);
        Toolkit.active.KA(x1, y1, progressWidth + x1, y2);

        this.drawCompleted(y1, x1, width, height);
        Toolkit.active.KA(progressWidth + x1, y1, x2, y2);
        this.background.renderTiled(x1, y1, width, height);

        Toolkit.active.KA(clipping[0], clipping[1], clipping[2], clipping[3]);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(IIIII)V")
    protected void drawCompleted(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(3) int width, @OriginalArg(4) int height) {
        this.bar.renderTiled(x, y, width, height);
    }

    @OriginalMember(owner = "client!gr", name = "a", descriptor = "(I)V")
    @Override
    public final void init() {
        super.init();
        @Pc(10) FancyProgressBarInstance local10 = (FancyProgressBarInstance) super.instance;
        this.bar = Loading.sprite(local10.bar, super.loadingSprites);
        this.background = Loading.sprite(local10.background, super.loadingSprites);
        this.left = Loading.sprite(local10.left, super.loadingSprites);
        this.right = Loading.sprite(local10.right, super.loadingSprites);
        this.top = Loading.sprite(local10.top, super.loadingSprites);
        this.bottom = Loading.sprite(local10.bottom, super.loadingSprites);
    }

    @OriginalMember(owner = "client!gr", name = "b", descriptor = "(I)Z")
    @Override
    public final boolean ready() {
        if (!super.ready()) {
            return false;
        }

        @Pc(14) FancyProgressBarInstance instance = (FancyProgressBarInstance) super.instance;
        if (!super.loadingSprites.fileready(instance.bar)) {
            return false;
        } else if (!super.loadingSprites.fileready(instance.background)) {
            return false;
        } else if (!super.loadingSprites.fileready(instance.left)) {
            return false;
        } else if (!super.loadingSprites.fileready(instance.right)) {
            return false;
        } else if (!super.loadingSprites.fileready(instance.top)) {
            return false;
        } else if (!super.loadingSprites.fileready(instance.bottom)) {
            return false;
        } else {
            return true;
        }
    }
}
