import com.jagex.ServerProt;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static331 {

    @OriginalMember(owner = "client!ki", name = "k", descriptor = "Ljava/lang/String;")
    public static String walkText;

    @OriginalMember(owner = "client!ki", name = "h", descriptor = "Lclient!sb;")
    public static js5 aJs5_65;

    @OriginalMember(owner = "client!ki", name = "e", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___138 = new ServerProt(36, 4);

    @OriginalMember(owner = "client!ki", name = "i", descriptor = "I")
    public static int walkCursor = -1;

    @OriginalMember(owner = "client!ki", name = "g", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___139 = new ServerProt(118, -2);

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "I")
    public static int anInt5441 = -50;

    @OriginalMember(owner = "client!ki", name = "a", descriptor = "(ZLjava/lang/String;B)V")
    public static void method4924(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1) {
        Static263.method3855(arg0, -1, -1, arg1);
    }

}
