import com.jagex.SignLink;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static150 {

    @OriginalMember(owner = "client!en", name = "h", descriptor = "I")
    public static int anInt2634;

    @OriginalMember(owner = "client!en", name = "d", descriptor = "[I")
    public static int[] anIntArray233;

    @OriginalMember(owner = "client!en", name = "i", descriptor = "I")
    public static int anInt2632 = 0;

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(B)V")
    public static void method2455() {
        Static173.method2690();
        Static517.method6822(ClientOptions.instance.aClass57_Sub17_1.method5667() == 1);
        Static719.aClass56_5 = Static638.method8394(SignLink.instance, 0, 22050, GameShell.canvas);
        Static697.method9120(Static48.method1100((Node_Sub6_Sub1) null));
        Static559.aClass56_3 = Static638.method8394(SignLink.instance, 1, 2048, GameShell.canvas);
        Static559.aClass56_3.method3582(Static336.aClass2_Sub6_Sub3_1);
    }

    @OriginalMember(owner = "client!en", name = "a", descriptor = "(BLclient!ge;)Lclient!hba;")
    public static Class154_Sub1 method2456(@OriginalArg(1) Packet arg0) {
        return new Class154_Sub1(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g3(), arg0.g1());
    }
}
