import com.jagex.Entity;
import com.jagex.graphics.PickingCylinder;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pea")
public final class Class8_Sub7 extends Entity {

    @OriginalMember(owner = "client!pea", name = "g", descriptor = "Lclient!eo;")
    public Renderable aRenderable_18;

    @OriginalMember(owner = "client!pea", name = "f", descriptor = "Z")
    public boolean aBoolean548;

    @OriginalMember(owner = "client!pea", name = "j", descriptor = "[Lclient!ima;")
    public PickingCylinder[] aPickingCylinderArray1;

    @OriginalMember(owner = "client!pea", name = "a", descriptor = "(Lclient!ha;BII)Z")
    public boolean method6496(@OriginalArg(0) Toolkit arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(10) int local10 = this.aRenderable_18.method9287();
        if (this.aPickingCylinderArray1 != null) {
            for (@Pc(15) int local15 = 0; local15 < this.aPickingCylinderArray1.length; local15++) {
                this.aPickingCylinderArray1[local15].anInt4502 <<= local10;
                if (this.aPickingCylinderArray1[local15].method4048(arg2, arg1) && this.aRenderable_18.method9279(arg1, arg2, false, arg0)) {
                    this.aPickingCylinderArray1[local15].anInt4502 >>= local10;
                    return true;
                }
                this.aPickingCylinderArray1[local15].anInt4502 >>= local10;
            }
        }
        return false;
    }
}
