import com.jagex.game.news.NewsReader;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.BackgroundImageInstance;
import rs2.client.loading.screen.op.instance.FancyProgressBarInstance;
import rs2.client.loading.screen.op.instance.ImageInstance;
import rs2.client.loading.screen.op.instance.ClearScreenInstance;
import rs2.client.loading.screen.op.instance.ImageProgressBarInstance;
import rs2.client.loading.screen.op.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.op.instance.NewsInstance;
import rs2.client.loading.screen.op.instance.RotatingImageInstance;
import rs2.client.loading.screen.op.instance.SolidProgressBarInstance;
import rs2.client.loading.screen.op.instance.TextInstance;
import rs2.client.loading.screen.op.LoadingScreenOp;
import rs2.client.loading.screen.op.LoadingScreenOpType;
import rs2.client.loading.screen.op.News;
import rs2.client.loading.screen.op.Text;

@OriginalClass("client!we")
public final class LoadingScreenOpFactory {

    @OriginalMember(owner = "client!we", name = "f", descriptor = "Lclient!tu;")
    public NewsReader reader;

    @OriginalMember(owner = "client!we", name = "d", descriptor = "Lclient!sb;")
    public final js5 fontMetrics;

    @OriginalMember(owner = "client!we", name = "e", descriptor = "Lclient!sb;")
    public final js5 loadingSprites;

    @OriginalMember(owner = "client!we", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;)V")
    public LoadingScreenOpFactory(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics) {
        this.fontMetrics = fontMetrics;
        this.loadingSprites = loadingSprites;
    }

    @OriginalMember(owner = "client!we", name = "a", descriptor = "(ILclient!gja;)Lclient!jd;")
    public LoadingScreenOp create(@OriginalArg(1) LoadingScreenOpInstance instance) {
        if (instance == null) {
            return null;
        }

        @Pc(18) LoadingScreenOpType type = instance.type();
        if (type == LoadingScreenOpType.CLEAR_SCREEN) {
            return new ClearScreen((ClearScreenInstance) instance);
        } else if (type == LoadingScreenOpType.NEWS) {
            return new News(this.newsReader(), (NewsInstance) instance);
        } else if (type == LoadingScreenOpType.IMAGE) {
            return new Image(this.loadingSprites, (ImageInstance) instance);
        } else if (LoadingScreenOpType.ROTATING_IMAGE == type) {
            return new RotatingImage(this.loadingSprites, (RotatingImageInstance) instance);
        } else if (LoadingScreenOpType.SOLID_PROGRESS_BAR == type) {
            return new SolidProgressBar(this.loadingSprites, this.fontMetrics, (SolidProgressBarInstance) instance);
        } else if (LoadingScreenOpType.IMAGE_PROGRESS_BAR == type) {
            return new ImageProgressBar(this.loadingSprites, this.fontMetrics, (ImageProgressBarInstance) instance);
        } else if (LoadingScreenOpType.FANCY_PROGRESS_BAR == type) {
            return new FancyProgressBar(this.loadingSprites, this.fontMetrics, (FancyProgressBarInstance) instance);
        } else if (type == LoadingScreenOpType.TEXT) {
            return new Text(this.loadingSprites, this.fontMetrics, (TextInstance) instance);
        } else if (type == LoadingScreenOpType.BACKGROUND_IMAGE) {
            return new BackgroundImage(this.loadingSprites, (BackgroundImageInstance) instance);
        } else if (LoadingScreenOpType.ANIMATED_PROGRESS_BAR == type) {
            return new AnimatedProgressBar(this.loadingSprites, this.fontMetrics, (AnimatedProgressBarInstance) instance);
        } else {
            return null;
        }
    }

    @OriginalMember(owner = "client!we", name = "a", descriptor = "(B)Lclient!tu;")
    public NewsReader newsReader() {
        if (this.reader == null) {
            this.reader = new NewsReader();
        }
        return this.reader;
    }
}
