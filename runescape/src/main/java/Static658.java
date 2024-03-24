import com.jagex.graphics.PointLight;
import com.jagex.graphics.PickingCylinder;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static658 {

    @OriginalMember(owner = "client!us", name = "n", descriptor = "I")
    public static int anInt9800;

    @OriginalMember(owner = "client!us", name = "a", descriptor = "(Lclient!eo;[Lclient!lca;)V")
    public static void method8591(@OriginalArg(0) Renderable arg0, @OriginalArg(1) PointLight[] arg1) {
        @Pc(6) int local6;
        if (Static442.aBoolean500) {
            local6 = arg0.method9288(arg1);
            Static665.aToolkit_15.method8009(local6, arg1);
        }
        if (Static693.aGroundArray2 == Static246.activeGround) {
            @Pc(28) int local28;
            if (arg0 instanceof PositionEntity) {
                local6 = ((PositionEntity) arg0).aShort131;
                local28 = ((PositionEntity) arg0).aShort132;
            } else {
                local6 = arg0.x >> Static52.anInt1066;
                local28 = arg0.z >> Static52.anInt1066;
            }
            Static665.aToolkit_15.EA(Static706.aGroundArray3[0].method7878(arg0.z, arg0.x), Static100.method1987(local6, local28), Static350.method5124(local6, local28), Static339.method5005(local6, local28));
        }
        @Pc(64) PickableEntity local64 = arg0.method9276(Static665.aToolkit_15);
        if (local64 == null) {
            return;
        }
        if (arg0.aBoolean813) {
            @Pc(74) PickingCylinder[] local74 = local64.aPickingCylinderArray1;
            for (@Pc(76) int local76 = 0; local76 < local74.length; local76++) {
                @Pc(81) PickingCylinder local81 = local74[local76];
                if (local81.aBoolean352) {
                    Static682.method8927(local81.anInt4505 - local81.anInt4502, local81.anInt4503 + local81.anInt4502, local81.anInt4504 - local81.anInt4502, local81.anInt4501 + local81.anInt4502);
                }
            }
        }
        if (local64.aBoolean548) {
            local64.aRenderable_18 = arg0;
            if (Static661.aBoolean457) {
                @Pc(127) Class213 local127 = Static514.aClass213_2;
                synchronized (Static514.aClass213_2) {
                    Static514.aClass213_2.method5008(local64);
                    return;
                }
            }
            Static514.aClass213_2.method5008(local64);
            return;
        }
        Static281.method4092(local64);
    }
}
