import com.jagex.Client;
import com.jagex.graphics.Sprite;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.ImageInstance;
import rs2.client.loading.screen.op.LoadingScreenOp;

@OriginalClass("client!nha")
public class Image implements LoadingScreenOp {

    @OriginalMember(owner = "client!nha", name = "i", descriptor = "Lclient!st;")
    protected Sprite sprite;

    @OriginalMember(owner = "client!nha", name = "f", descriptor = "Lclient!no;")
    protected final ImageInstance instance;

    @OriginalMember(owner = "client!nha", name = "n", descriptor = "Lclient!sb;")
    public final js5 loadingSprites;

    @OriginalMember(owner = "client!nha", name = "<init>", descriptor = "(Lclient!sb;Lclient!no;)V")
    public Image(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) ImageInstance instance) {
        this.instance = instance;
        this.loadingSprites = loadingSprites;
    }

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "(I)V")
    @Override
    public final void init() {
        this.sprite = Loading.sprite(this.instance.spriteId, this.loadingSprites);
    }

    @OriginalMember(owner = "client!nha", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(19) int x = this.instance.horizontalAlignment.align(Client.loadingScreenWidth, this.sprite.scaleWidth()) + this.instance.x;
        @Pc(34) int y = this.instance.verticalAlignment.align(Client.loadingScreenHeight, this.sprite.scaleHeight()) + this.instance.y;
        this.sprite.render(x, y);
    }

    @OriginalMember(owner = "client!nha", name = "b", descriptor = "(I)Z")
    @Override
    public final boolean ready() {
        return this.loadingSprites.fileready(this.instance.spriteId);
    }
}
