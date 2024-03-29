package rs2.client.loading.screen.op;

import com.jagex.Client;
import com.jagex.IndexedImage;
import com.jagex.graphics.Font;
import com.jagex.graphics.FontMetrics;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.instance.TextInstance;

@OriginalClass("client!fo")
public final class Text implements LoadingScreenOp {

    @OriginalMember(owner = "client!fo", name = "g", descriptor = "Lclient!da;")
    public Font font;

    @OriginalMember(owner = "client!fo", name = "l", descriptor = "Lclient!fea;")
    public final TextInstance instance;

    @OriginalMember(owner = "client!fo", name = "j", descriptor = "Lclient!sb;")
    public final js5 fontMetrics;

    @OriginalMember(owner = "client!fo", name = "n", descriptor = "Lclient!sb;")
    public final js5 loadingSprites;

    @OriginalMember(owner = "client!fo", name = "<init>", descriptor = "(Lclient!sb;Lclient!sb;Lclient!fea;)V")
    public Text(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) js5 fontMetrics, @OriginalArg(2) TextInstance instance) {
        this.instance = instance;
        this.fontMetrics = fontMetrics;
        this.loadingSprites = loadingSprites;
    }

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        @Pc(24) FontMetrics metrics = FontMetrics.loadFile(this.instance.font, this.fontMetrics);
        this.font = Toolkit.active.createFont(metrics, IndexedImage.load(this.loadingSprites, this.instance.font), true);
    }

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(27) int x = this.instance.horizontalAlignment.align(Client.loadingScreenWidth, this.instance.width) + this.instance.x;
        @Pc(41) int y = this.instance.verticalAlignment.align(Client.loadingScreenHeight, this.instance.height) + this.instance.y;
        this.font.renderLines(this.instance.text, x, y, 0, 0, this.instance.width, this.instance.height, this.instance.textHorizontalAlignment, this.instance.textVerticalAlignment, this.instance.verticalSpacing, this.instance.textColour, this.instance.shadowColour, null, null, null);
    }

    @OriginalMember(owner = "client!fo", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        @Pc(11) boolean ready = true;
        if (!this.loadingSprites.fileready(this.instance.font)) {
            ready = false;
        }
        if (!this.fontMetrics.fileready(this.instance.font)) {
            ready = false;
        }
        return ready;
    }
}
