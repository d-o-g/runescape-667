import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static270 {

    @OriginalMember(owner = "client!iia", name = "q", descriptor = "I")
    public static int updateZoneZ;

    @OriginalMember(owner = "client!iia", name = "m", descriptor = "Lclient!fca;")
    public static Class123 aClass123_2 = null;

    @OriginalMember(owner = "client!iia", name = "a", descriptor = "(ZI)V")
    public static void method3920(@OriginalArg(0) boolean arg0) {
        if (debugconsole.currententry.length() == 0) {
            return;
        }
        debugconsole.addline("--> " + debugconsole.currententry);
        debugconsole.executeComand(false, arg0, debugconsole.currententry);
        Static625.anInt9472 = 0;
        if (!arg0) {
            debugconsole.currententryLength = 0;
            debugconsole.currententry = "";
        }
    }
}
