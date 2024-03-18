import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static666 {

    @OriginalMember(owner = "client!vba", name = "K", descriptor = "J")
    public static long aLong301;

    @OriginalMember(owner = "client!vba", name = "M", descriptor = "Lclient!sb;")
    public static js5 aJs5_118;

    @OriginalMember(owner = "client!vba", name = "H", descriptor = "Z")
    public static boolean aBoolean766 = false;

    @OriginalMember(owner = "client!vba", name = "h", descriptor = "(I)V")
    public static void method8693(@OriginalArg(0) int arg0) {
        @Pc(5) FileOnDisk local5 = null;
        try {
            @Pc(18) SignedResource local18 = Static446.aSignLink_6.openPrefs("", true);
            while (local18.status == 0) {
                Static638.sleep(1L);
            }
            if (local18.status == 1) {
                local5 = (FileOnDisk) local18.result;
                @Pc(41) Packet local41 = Static400.instance.method5110();
                local5.method2162(local41.data, 0, local41.pos);
            }
        } catch (@Pc(51) Exception local51) {
        }
        try {
            if (local5 != null) {
                local5.close();
            }
        } catch (@Pc(58) Exception local58) {
        }
    }
}
