import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.ProgressBarInstance;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!ea")
public abstract class ProgressBar implements LoadingScreenOp {

    @OriginalMember(owner = "client!ea", name = "b", descriptor = "J")
    public long lastChange;

    @OriginalMember(owner = "client!ea", name = "n", descriptor = "Lclient!da;")
    public Font font;

    @OriginalMember(owner = "client!ea", name = "l", descriptor = "I")
    public int lastPercentage;

    @OriginalMember(owner = "client!ea", name = "c", descriptor = "Lclient!is;")
    protected final ProgressBarInstance instance;

    @OriginalMember(owner = "client!ea", name = "h", descriptor = "Lclient!sb;")
    protected final js5 loadingSprites;

    @OriginalMember(owner = "client!ea", name = "e", descriptor = "Lclient!sb;")
    public final js5 fontMetrics;

    @OriginalMember(owner = "client!ea", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!is;)V")
    protected ProgressBar(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) ProgressBarInstance instance) {
        this.instance = instance;
        this.loadingSprites = loadingSprites;
        this.fontMetrics = fontMetrics;
    }

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(ZI)V")
    @Override
    public final void execute() {
        @Pc(18) int x = this.instance.horizontalAlignment.align(Client.loadingScreenWidth, this.instance.width) + this.instance.x;
        @Pc(32) int y = this.instance.verticalAlignment.align(Client.loadingScreenHeight, this.instance.height) + this.instance.y;
        this.drawBorder(x, y);
        this.drawBackground(x, y);
        @Pc(56) String text = Loading.renderer.getText();
        if (SystemTimer.safetime() - this.lastChange > 10000L) {
            text = text + " (" + Loading.renderer.getState().getStep() + ")";
        }
        this.font.renderCentre(text, x + this.instance.width / 2, y + (this.instance.height / 2) + this.instance.textOffsetX + 4, this.instance.textColour, 0xFFFFFFFF);
    }

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(ZIBI)V")
    protected abstract void drawBorder(@OriginalArg(1) int x, @OriginalArg(3) int y);

    @OriginalMember(owner = "client!ea", name = "c", descriptor = "(I)I")
    protected final int progress() {
        @Pc(9) int percentage = Loading.renderer.getPercentage();
        @Pc(13) int progress = percentage * 100;

        if (percentage == this.lastPercentage && percentage != 0) {
            @Pc(40) int nextPercentage = Loading.renderer.nextPercentage();

            if (nextPercentage > percentage) {
                @Pc(55) long elapsed = this.lastChange - Loading.renderer.getLastUpdate();

                if (elapsed > 0L) {
                    @Pc(72) long estimatedTime = (long) (nextPercentage - percentage) * ((elapsed * 10000L) / (long) percentage);
                    @Pc(81) long actualTime = (SystemTimer.safetime() - this.lastChange) * 10000L;

                    if (estimatedTime > actualTime) {
                        progress = (int) ((((long) (nextPercentage - percentage) * actualTime * 100L) / estimatedTime) + (long) (percentage * 100));
                    } else {
                        progress = nextPercentage * 100;
                    }
                }
            }
        } else {
            this.lastPercentage = percentage;
            this.lastChange = SystemTimer.safetime();
        }

        return progress;
    }

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(IIZI)V")
    protected abstract void drawBackground(@OriginalArg(0) int x, @OriginalArg(3) int y);

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        @Pc(21) FontMetrics metrics = FontMetrics.loadFile(this.fontMetrics, this.instance.font);
        this.font = Toolkit.active.createFont(metrics, IndexedImage.load(this.loadingSprites, this.instance.font), true);
    }

    @OriginalMember(owner = "client!ea", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        @Pc(5) boolean ready = true;
        if (!this.loadingSprites.fileready(this.instance.font)) {
            ready = false;
        }
        if (!this.fontMetrics.fileready(this.instance.font)) {
            ready = false;
        }
        return ready;
    }
}
