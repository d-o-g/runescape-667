import com.jagex.SignLink;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.ClientInfo;

public final class Static529 {

    @OriginalMember(owner = "client!qla", name = "a", descriptor = "Lclient!hf;")
    public static Class161 aClass161_1;

    @OriginalMember(owner = "client!qla", name = "d", descriptor = "I")
    public static int anInt8089 = -1;

    @OriginalMember(owner = "client!qla", name = "a", descriptor = "(ILclient!sb;Lclient!vq;)V")
    public static void method7096(@OriginalArg(1) js5 arg0, @OriginalArg(2) SignLink arg1) {
        Static442.aJs5_90 = arg0;
        Static185.aString34 = "";
        Static93.nativeLink = arg1;
        if (ClientInfo.osName.startsWith("win")) {
            Static185.aString34 = Static185.aString34 + "windows/";
        } else if (ClientInfo.osName.startsWith("linux")) {
            Static185.aString34 = Static185.aString34 + "linux/";
        } else if (ClientInfo.osName.startsWith("mac")) {
            Static185.aString34 = Static185.aString34 + "macos/";
        }
        if (Static93.nativeLink.microsoftjava) {
            Static185.aString34 = Static185.aString34 + "msjava/";
        } else if (ClientInfo.osArch.startsWith("amd64") || ClientInfo.osArch.startsWith("x86_64")) {
            Static185.aString34 = Static185.aString34 + "x86_64/";
        } else if (ClientInfo.osArch.startsWith("i386") || ClientInfo.osArch.startsWith("i486") || ClientInfo.osArch.startsWith("i586") || ClientInfo.osArch.startsWith("x86")) {
            Static185.aString34 = Static185.aString34 + "x86/";
        } else if (ClientInfo.osArch.startsWith("ppc")) {
            Static185.aString34 = Static185.aString34 + "ppc/";
        } else {
            Static185.aString34 = Static185.aString34 + "universal/";
        }
    }
}
