import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static632 {

    @OriginalMember(owner = "client!u", name = "k", descriptor = "I")
    public static int anInt9503;

    @OriginalMember(owner = "client!u", name = "l", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray44 = new String[100];

    @OriginalMember(owner = "client!u", name = "e", descriptor = "[F")
    public static final float[] aFloatArray70 = new float[4];

    @OriginalMember(owner = "client!u", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___229 = new ServerProt(89, -1);

    @OriginalMember(owner = "client!u", name = "b", descriptor = "(III)Z")
    public static boolean method8364(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (arg0 & 0x800) != 0 | Static558.method2895(arg0, arg1) || Static198.method2957(arg0, arg1);
    }

    @OriginalMember(owner = "client!u", name = "a", descriptor = "(Lclient!eo;ZZ)V")
    public static void method8368(@OriginalArg(0) Entity arg0, @OriginalArg(2) boolean arg1) {
        arg0.aBoolean813 = arg1;
        if (Static661.aBoolean457) {
            Static684.aClass302Array1[Static684.aClass302Array1.length - 1].method6812(arg0);
        } else {
            Static658.method8591(arg0, Static501.aClass2_Sub7Array4);
        }
    }
}
