import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static616 {

    @OriginalMember(owner = "client!tia", name = "L", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_223 = new Class225(40, -1);

    @OriginalMember(owner = "client!tia", name = "R", descriptor = "I")
    public static int anInt9417 = 0;

    @OriginalMember(owner = "client!tia", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;B)V")
    public static void method8283(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1) {
        Static470.anInt7113 = -1;
        Static524.aServerConnection_3 = ConnectionManager.LOBBY;
        Static299.anInt4825 = 1;
        Static238.method3471(false, arg1, false, arg0);
    }
}
