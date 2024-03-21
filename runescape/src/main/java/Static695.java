import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static695 {

    @OriginalMember(owner = "client!vw", name = "u", descriptor = "[I")
    public static int[] anIntArray868;

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(Ljava/lang/String;I)V")
    public static void method9265(@OriginalArg(0) String arg0) {
        Static44.method1072(arg0, "", 0, "", "", 0);
    }

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(I)V")
    public static void method9266() {
        Static470.anInt7113 = -1;
        Static299.anInt4825 = 1;
        Static524.aServerConnection_3 = ConnectionManager.LOBBY;
        Static238.method3471(Static319.aString51.equals(""), Static319.aString51, true, "");
    }

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(IZ)V")
    public static void method9267(@OriginalArg(0) int arg0) {
        @Pc(10) VideoType local10 = (VideoType) VideoTypeList.recentUse.get((long) arg0);
        if (local10 != null) {
            local10.aBoolean16 = !local10.aBoolean16;
            local10.js5.method9174(local10.aBoolean16);
        }
    }
}
