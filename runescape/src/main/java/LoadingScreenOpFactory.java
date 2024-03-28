import com.jagex.game.news.NewsReader;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.ImageInstance;
import rs2.client.loading.screen.instance.ClearScreenInstance;
import rs2.client.loading.screen.instance.LoadingScreenOpInstance;
import rs2.client.loading.screen.instance.NewsInstance;
import rs2.client.loading.screen.instance.RotatingImageInstance;
import rs2.client.loading.screen.op.LoadingScreenOp;
import rs2.client.loading.screen.op.LoadingScreenOpType;
import rs2.client.loading.screen.op.News;

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
    public LoadingScreenOp method9168(@OriginalArg(1) LoadingScreenOpInstance instance) {
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
            return new Class90_Sub1(this.loadingSprites, this.fontMetrics, (Class138_Sub3) instance);
        } else if (LoadingScreenOpType.IMAGE_PROGRESS_BAR == type) {
            return new Class90_Sub3(this.loadingSprites, this.fontMetrics, (Class138_Sub2) instance);
        } else if (LoadingScreenOpType.FANCY_PROGRESS_BAR == type) {
            return new Class90_Sub2(this.loadingSprites, this.fontMetrics, (Class138_Sub1) instance);
        } else if (type == LoadingScreenOpType.TEXT) {
            return new Class133(this.loadingSprites, this.fontMetrics, (Class125) instance);
        } else if (type == LoadingScreenOpType.BACKGROUND_IMAGE) {
            return new Class109(this.loadingSprites, (Class200) instance);
        } else if (LoadingScreenOpType.ANIMATED_PROGRESS_BAR == type) {
            return new Class90_Sub2_Sub1(this.loadingSprites, this.fontMetrics, (Class138_Sub1_Sub1) instance);
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
