import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.ClientInfo;

public final class Static308 {

    @OriginalMember(owner = "client!jp", name = "d", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_21 = new Class155(53);

    @OriginalMember(owner = "client!jp", name = "a", descriptor = "(BLclient!rka;I)V")
    public static void method4482(@OriginalArg(1) PacketBuffer arg0, @OriginalArg(2) int arg1) {
        Static652.anInt9713 = 0;
        Static358.aBoolean803 = false;
        Static263.method3856(arg0);
        Static618.method8319(arg0);
        if (Static358.aBoolean803) {
            System.out.println("---endgpp---");
        }
        if (arg0.pos != arg1) {
            throw new RuntimeException("gpi1 pos:" + arg0.pos + " psize:" + arg1);
        }
    }

    @OriginalMember(owner = "client!jp", name = "a", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
    public static String addNativeFileExtension(@OriginalArg(1) String arg0) {
        if (ClientInfo.osName.startsWith("win")) {
            return arg0 + ".dll";
        } else if (ClientInfo.osName.startsWith("linux")) {
            return "lib" + arg0 + ".so";
        } else if (ClientInfo.osName.startsWith("mac")) {
            return "lib" + arg0 + ".dylib";
        } else {
            return null;
        }
    }
}
