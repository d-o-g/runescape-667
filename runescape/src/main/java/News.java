import com.jagex.Client;
import com.jagex.game.news.NewsItem;
import com.jagex.graphics.Font;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!pga")
public final class News implements LoadingScreenOp {

    @OriginalMember(owner = "client!pga", name = "f", descriptor = "Lclient!lv;")
    public final NewsInstance instance;

    @OriginalMember(owner = "client!pga", name = "h", descriptor = "Lclient!tu;")
    public final NewsReader reader;

    @OriginalMember(owner = "client!pga", name = "<init>", descriptor = "(Lclient!tu;Lclient!lv;)V")
    public News(@OriginalArg(0) NewsReader reader, @OriginalArg(1) NewsInstance instance) {
        this.instance = instance;
        this.reader = reader;
    }

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(BLclient!da;Ljava/lang/String;III)I")
    public int renderText(@OriginalArg(1) Font font, @OriginalArg(2) String text, @OriginalArg(3) int x, @OriginalArg(5) int y) {
        return font.renderLines(0, null, this.instance.textColour, text, null, null, y + 5, this.instance.textShadowColour, 0, 0, x + 5, 0, 0, this.instance.width - 10, this.instance.height + -10);
    }

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(19) NewsItem item = this.reader.getItem(this.instance.item);
        if (item == null) {
            return;
        }

        @Pc(35) int x = this.instance.horizontalAlignment.align(Client.loadingScreenWidth, this.instance.width) + this.instance.x;
        @Pc(49) int y = this.instance.verticalAlignment.align(Client.loadingScreenHeight, this.instance.height) + this.instance.y;

        if (this.instance.aBoolean454) {
            Toolkit.active.outlineRect(x, y, this.instance.width, this.instance.height, this.instance.lineColour, 0);
        }

        y += this.renderText(Fonts.b12, item.title, x, y) * 12;
        y += 8;

        if (this.instance.aBoolean454) {
            Toolkit.active.line(x, y, this.instance.width + x - 1, y, this.instance.lineColour, 0);
        }
        y++;

        y += this.renderText(Fonts.b12, item.info, x, y) * 12;
        y += 5;

        @Pc(135) int local135 = y + this.renderText(Fonts.b12, item.description, x, y) * 12;
    }

    @OriginalMember(owner = "client!pga", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
    }

    @OriginalMember(owner = "client!pga", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        return this.reader.ready();
    }
}
