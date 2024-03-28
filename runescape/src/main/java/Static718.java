import com.jagex.game.runetek6.config.flotype.FloorOverlayType;
import com.jagex.graphics.TextureMetrics;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static718 {

    @OriginalMember(owner = "client!wo", name = "r", descriptor = "Z")
    public static boolean aBoolean822 = false;

    @OriginalMember(owner = "client!wo", name = "a", descriptor = "(Lclient!re;BLclient!ha;)I")
    public static int method9367(@OriginalArg(0) FloorOverlayType arg0, @OriginalArg(2) Toolkit arg1) {
        if (arg0.blendColour != -1) {
            return arg0.blendColour;
        }
        if (arg0.texture != -1) {
            @Pc(31) TextureMetrics local31 = arg1.textureSource.getMetrics(arg0.texture);
            if (!local31.aBoolean240) {
                return local31.aShort37;
            }
        }
        return arg0.colour;
    }
}
