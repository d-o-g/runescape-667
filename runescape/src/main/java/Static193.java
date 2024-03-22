import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static193 {

    @OriginalMember(owner = "client!fw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___74 = new ServerProt(10, 0);

    @OriginalMember(owner = "client!fw", name = "a", descriptor = "(BI)V")
    public static void method2897(@OriginalArg(1) int arg0) {
        for (@Pc(11) Node local11 = InterfaceManager.serverActiveProperties.first(); local11 != null; local11 = InterfaceManager.serverActiveProperties.next()) {
            if ((long) arg0 == (local11.key >> 48 & 0xFFFFL)) {
                local11.unlink();
            }
        }
    }
}
