import com.jagex.Client;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.op.LoadingScreenOp;
import rs2.client.loading.screen.op.instance.BackgroundImageInstance;

@OriginalClass("client!en")
public final class BackgroundImage implements LoadingScreenOp {

    @OriginalMember(owner = "client!en", name = "b", descriptor = "Lclient!st;")
    public Sprite sprite;

    @OriginalMember(owner = "client!en", name = "a", descriptor = "Lclient!sb;")
    public final js5 loadingSprites;

    @OriginalMember(owner = "client!en", name = "g", descriptor = "Lclient!jt;")
    public final BackgroundImageInstance instance;

    @OriginalMember(owner = "client!en", name = "<init>", descriptor = "(Lclient!sb;Lclient!jt;)V")
    public BackgroundImage(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) BackgroundImageInstance instance) {
        this.loadingSprites = loadingSprites;
        this.instance = instance;
    }

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(11) int maxWidth = Client.loadingScreenWidth >= GameShell.canvasWid ? Client.loadingScreenWidth : GameShell.canvasWid;
        @Pc(19) int maxHeight = GameShell.canvasHei <= Client.loadingScreenHeight ? Client.loadingScreenHeight : GameShell.canvasHei;
        @Pc(23) int spriteWidth = this.sprite.scaleWidth();
        @Pc(27) int spriteHeight = this.sprite.scaleHeight();
        @Pc(29) int x = 0;
        @Pc(31) int width = maxWidth;
        @Pc(37) int height = (maxWidth * spriteHeight) / spriteWidth;
        @Pc(44) int y = (maxHeight - height) / 2;
        if (maxHeight < height) {
            width = spriteWidth * maxHeight / spriteHeight;
            height = maxHeight;
            y = 0;
            x = (maxWidth - width) / 2;
        }
        this.sprite.render(x, y, width, height);
    }

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(I)V")
    @Override
    public void init() {
        this.sprite = Loading.sprite(this.instance.image, this.loadingSprites);
    }

    @OriginalMember(owner = "client!en", name = "b", descriptor = "(I)Z")
    @Override
    public boolean ready() {
        return this.loadingSprites.fileready(this.instance.image);
    }
}
