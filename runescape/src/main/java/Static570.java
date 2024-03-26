import com.jagex.ServerProt;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static570 {

    @OriginalMember(owner = "client!rv", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___208 = new ServerProt(99, -1);

    @OriginalMember(owner = "client!rv", name = "b", descriptor = "(I)Lclient!ge;")
    public static Packet method7552() {
        @Pc(8) Packet local8 = new Packet(518);
        Static219.xteaKey = new int[4];
        Static219.xteaKey[2] = (int) (Math.random() * 9.9999999E7D);
        Static219.xteaKey[0] = (int) (Math.random() * 9.9999999E7D);
        Static219.xteaKey[3] = (int) (Math.random() * 9.9999999E7D);
        Static219.xteaKey[1] = (int) (Math.random() * 9.9999999E7D);
        local8.p1(10);
        local8.p4(Static219.xteaKey[0]);
        local8.p4(Static219.xteaKey[1]);
        local8.p4(Static219.xteaKey[2]);
        local8.p4(Static219.xteaKey[3]);
        return local8;
    }

}
