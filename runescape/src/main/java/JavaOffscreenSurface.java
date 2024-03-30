import com.jagex.graphics.OffscreenSurface;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!du")
public final class JavaOffscreenSurface implements OffscreenSurface {

    @OriginalMember(owner = "client!du", name = "i", descriptor = "Lclient!iaa;")
    public final JavaToolkit aClass19_Sub2_3;

    @OriginalMember(owner = "client!du", name = "a", descriptor = "[I")
    public final int[] raster;

    @OriginalMember(owner = "client!du", name = "n", descriptor = "I")
    public final int width;

    @OriginalMember(owner = "client!du", name = "g", descriptor = "I")
    public final int height;

    @OriginalMember(owner = "client!du", name = "l", descriptor = "Lclient!hia;")
    public Class165 aClass165_1;

    @OriginalMember(owner = "client!du", name = "b", descriptor = "[F")
    public float[] depthBuffer;

    @OriginalMember(owner = "client!du", name = "<init>", descriptor = "(Lclient!iaa;Lclient!st;Lclient!hia;)V")
    public JavaOffscreenSurface(@OriginalArg(0) JavaToolkit arg0, @OriginalArg(1) Sprite arg1, @OriginalArg(2) Class165 arg2) {
        this.aClass19_Sub2_3 = arg0;
        if (arg1 instanceof JavaRgbSprite) {
            @Pc(35) JavaRgbSprite local35 = (JavaRgbSprite) arg1;
            this.width = local35.anInt9302;
            this.height = local35.anInt9306;
            this.raster = local35.anIntArray32;
        } else if (arg1 instanceof JavaArgbSprite) {
            @Pc(13) JavaArgbSprite local13 = (JavaArgbSprite) arg1;
            this.raster = local13.anIntArray528;
            this.width = local13.anInt9302;
            this.height = local13.anInt9306;
        } else {
            throw new RuntimeException();
        }
        if (arg2 != null) {
            this.aClass165_1 = arg2;
            if (this.width != this.aClass165_1.anInt3961 || this.aClass165_1.anInt3960 != this.height) {
                throw new RuntimeException();
            }
            this.depthBuffer = this.aClass165_1.aFloatArray21;
        }
    }

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(IIIIIIZZ)V")
    @Override
    public void method9039(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(6) boolean arg4) {
        Static22.method588(0, arg2, this.aClass19_Sub2_3.mainDepthBuffer, arg4 ? this.aClass19_Sub2_3.surface.raster : null, this.aClass19_Sub2_3.surface.width, this.depthBuffer, this.width, 0, this.raster, arg3, arg0, arg1);
    }

    @OriginalMember(owner = "client!du", name = "b", descriptor = "(IIIIIIZZ)V")
    @Override
    public void method9040(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
        Static22.method588(arg5, arg2, this.depthBuffer, this.raster, this.width, this.aClass19_Sub2_3.mainDepthBuffer, this.aClass19_Sub2_3.surface.width, arg4, this.aClass19_Sub2_3.surface.raster, arg3, arg0, arg1);
    }
}
