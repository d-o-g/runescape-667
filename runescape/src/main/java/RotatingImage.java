import com.jagex.Client;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.loading.screen.instance.RotatingImageInstance;

@OriginalClass("client!bf")
public final class RotatingImage extends Image {

    @OriginalMember(owner = "client!bf", name = "t", descriptor = "I")
    public int angle = 0;

    @OriginalMember(owner = "client!bf", name = "<init>", descriptor = "(Lclient!sb;Lclient!hea;)V")
    public RotatingImage(@OriginalArg(0) js5 loadingSprites, @OriginalArg(1) RotatingImageInstance instance) {
        super(loadingSprites, instance);
    }

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(ZI)V")
    @Override
    public void execute() {
        @Pc(17) int x = super.instance.horizontalAlignment.align(Client.loadingScreenWidth, super.sprite.scaleWidth()) + super.instance.x;
        @Pc(32) int y = super.instance.verticalAlignment.align(Client.loadingScreenHeight, super.sprite.scaleHeight()) + super.instance.y;
        super.sprite.renderRotated((float) (super.sprite.scaleWidth() / 2 + x), (float) (super.sprite.scaleHeight() / 2 + y), 4096, this.angle);
        this.angle += ((RotatingImageInstance) super.instance).rotation;
    }
}
