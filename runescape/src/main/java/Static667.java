import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static667 {

    @OriginalMember(owner = "client!vc", name = "b", descriptor = "Lclient!kda;")
    public static final Class204 aClass204_15 = new Class204(8, 1);

    @OriginalMember(owner = "client!vc", name = "a", descriptor = "(ZZLjava/lang/String;I)V")
    public static void method8695(@OriginalArg(1) boolean arg0, @OriginalArg(2) String arg1, @OriginalArg(3) int arg2) {
        Static419.method5757();
        Static231.method3375();
        Static208.method3106();
        Static595.method7807(arg1, arg0, arg2);
        Static158.method2569();
        Static570.method7549(Static163.activeToolkit);
        Static469.method6358(Static163.activeToolkit);
        Static239.method3472(js5.SPRITES, Static163.activeToolkit);
        Static329.method1649();
        Static331.method4925(Static679.aSpriteArray14);
        Static469.method6362();
        Static296.updateFeatureMask();
        if (Static283.step == 3) {
            Static81.method1586(4);
        } else if (Static283.step == 7) {
            Static81.method1586(8);
        } else if (Static283.step == 9) {
            Static81.method1586(10);
        } else if (Static283.step == 11) {
            Static81.method1586(12);
        } else if (Static283.step == 1 || Static283.step == 2) {
            Static143.method3572();
        }
    }
}
