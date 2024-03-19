import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static703 {

    @OriginalMember(owner = "client!we", name = "c", descriptor = "I")
    public static int anInt10571 = 0;

    @OriginalMember(owner = "client!we", name = "b", descriptor = "Z")
    public static final boolean aBoolean798 = true;

    @OriginalMember(owner = "client!we", name = "a", descriptor = "(ZLclient!sb;)V")
    public static void method9169(@OriginalArg(1) js5 arg0) {
        js5.EMITTERS = arg0;
    }

    @OriginalMember(owner = "client!we", name = "a", descriptor = "(Lclient!aea;I)V")
    public static void method9171(@OriginalArg(0) Class8_Sub1 arg0) {
        arg0.aClass8_Sub2_Sub1_Sub2_1 = null;
        if (Static6.anInt94 < 20) {
            Static129.aClass130_3.method2787(arg0);
            Static6.anInt94++;
        }
    }
}
