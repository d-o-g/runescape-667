import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static137 {

    @OriginalMember(owner = "client!ef", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___56 = new ServerProt(11, 3);

    @OriginalMember(owner = "client!ef", name = "l", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___57 = new ServerProt(24, -1);

    @OriginalMember(owner = "client!ef", name = "e", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___28 = new ClientProt(7, -1);

    @OriginalMember(owner = "client!ef", name = "f", descriptor = "Lclient!om;")
    public static final Class280 aClass280_4 = new Class280(1);

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(III)Z")
    public static boolean method2350(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0xC580) != 0;
    }

    @OriginalMember(owner = "client!ef", name = "a", descriptor = "(I)V")
    public static void method2354() {
        Static589.aFont1 = null;
        Static103.anImage1 = null;
    }
}
