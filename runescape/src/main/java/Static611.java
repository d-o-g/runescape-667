import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static611 {

    @OriginalMember(owner = "client!tfa", name = "g", descriptor = "I")
    public static int anInt9335;

    @OriginalMember(owner = "client!tfa", name = "i", descriptor = "I")
    public static int mouseWheelRotation = 0;

    @OriginalMember(owner = "client!tfa", name = "c", descriptor = "(ZI)I")
    public static int method8228(@OriginalArg(1) int arg0) {
        @Pc(8) byte local8;
        if (arg0 > 12000) {
            local8 = 4;
            Static395.method9162();
        } else if (arg0 > 5000) {
            Static133.method2316();
            local8 = 3;
        } else if (arg0 > 2000) {
            Static75.method6239();
            local8 = 2;
        } else {
            local8 = 1;
            Static468.method7643();
        }
        if (ClientOptions.instance.aClass57_Sub29_1.method7915() != 2) {
            ClientOptions.instance.method5104(2, ClientOptions.instance.aClass57_Sub29_2);
            Static32.method880(2, false);
        }
        Static666.method8693(1);
        return local8;
    }

    @OriginalMember(owner = "client!tfa", name = "a", descriptor = "(IIILclient!sb;ZI)V")
    public static void method8229(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) js5 arg2) {
        Static184.method2797(0L, arg0, arg1, arg2);
    }
}
