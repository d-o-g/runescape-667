import com.jagex.core.stringtools.general.StringTools;
import com.jagex.core.util.JagException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.DataInputStream;
import java.net.URL;

public final class Static240 {

    @OriginalMember(owner = "client!hi", name = "F", descriptor = "I")
    public static int anInt3955;

    @OriginalMember(owner = "client!hi", name = "A", descriptor = "Lclient!it;")
    public static final Class184 aClass184_9 = new Class184(4, 1, 1, 1);

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(BII)Z")
    public static boolean method3483(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x800) != 0;
    }

    @OriginalMember(owner = "client!hi", name = "a", descriptor = "(Ljava/lang/Throwable;Ljava/lang/String;I)V")
    public static void sendTrace(@OriginalArg(0) Throwable cause, @OriginalArg(1) String message) {
        try {
            @Pc(12) String trace = "";
            if (cause != null) {
                trace = JagException.stackTrace(cause);
            }

            if (message != null) {
                if (cause != null) {
                    trace = trace + " | ";
                }
                trace = trace + message;
            }

            JagException.print(trace);
            trace = StringTools.replace(trace, ":", "%3a");
            trace = StringTools.replace(trace, "@", "%40");
            trace = StringTools.replace(trace, "&", "%26");
            trace = StringTools.replace(trace, "#", "%23");

            if (Static631.sourceApplet != null) {
                @Pc(131) SignedResource resource = Static284.aSignLink_4.openStream(new URL(Static631.sourceApplet.getCodeBase(), "clienterror.ws?c=" + Static373.clientBuild + "&u=" + (Static515.playerDisplayName == null ? String.valueOf(Static292.playerDisplayNameEncoded) : Static515.playerDisplayName) + "&v1=" + SignLink.javaVendor + "&v2=" + SignLink.javaVersion + "&e=" + trace));
                while (resource.status == 0) {
                    Static638.sleep(1L);
                }
                if (resource.status == 1) {
                    @Pc(148) DataInputStream input = (DataInputStream) resource.result;
                    input.read();
                    input.close();
                }
            }
        } catch (@Pc(155) Exception ignored) {
            /* empty */
        }
    }
}
