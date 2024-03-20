import com.jagex.graphics.PointLight;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!sm")
public final class Node_Sub7_Sub2 extends PointLight {

    @OriginalMember(owner = "client!sm", name = "<init>", descriptor = "(IIIIIF)V")
    public Node_Sub7_Sub2(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) float arg5) {
        super(arg0, arg1, arg2, arg3, arg4, arg5);
    }

    @OriginalMember(owner = "client!sm", name = "a", descriptor = "(IIII)V")
    @Override
    public void setPosition(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        super.z = arg1;
        super.x = arg0;
        super.y = arg2;
    }

    @OriginalMember(owner = "client!sm", name = "a", descriptor = "(BF)V")
    @Override
    public void method8433(@OriginalArg(1) float arg0) {
        super.intensity = arg0;
    }
}
