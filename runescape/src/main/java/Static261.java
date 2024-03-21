import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static261 {

    @OriginalMember(owner = "client!ic", name = "a", descriptor = "Lclient!st;")
    public static Sprite aSprite_18;

    @OriginalMember(owner = "client!ic", name = "a", descriptor = "(I)V")
    public static void method3833() {
        InterfaceManager.dragChildren = null;
        if (Static137.aBoolean210 && Static36.method978(3) != 1) {
            Static294.method4339(0, Static283.step == 3 || Static283.step == 7, Static593.method7779(), Static58.method1260(), 0);
        }
        @Pc(46) int local46 = 0;
        @Pc(48) int local48 = 0;
        if (Static137.aBoolean210) {
            local46 = Static130.method2283();
            local48 = Static422.method5771();
        }
        Static534.method7120(Static377.anInt5930, local46, Static680.anInt10289 + local46, local48, local48, -1, local46, Static380.anInt5979 + local48);
        if (InterfaceManager.dragChildren != null) {
            InterfaceManager.draw(-1412584499, InterfaceManager.dragOffsetX, InterfaceManager.dragChildren, local46, local48, local48 + Static380.anInt5979, Static354.aComponent_8.rectangle, true, local46 + Static680.anInt10289, InterfaceManager.dragOffsetY);
            InterfaceManager.dragChildren = null;
        }
    }
}
