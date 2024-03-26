import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static452 {

    @OriginalMember(owner = "client!oea", name = "y", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___173 = new ServerProt(44, 10);

    @OriginalMember(owner = "client!oea", name = "a", descriptor = "(ILclient!ge;)Lclient!fea;")
    public static Class125 method6171(@OriginalArg(1) Packet arg0) {
        @Pc(7) String local7 = arg0.gjstr();
        @Pc(14) HorizontalAlignment local14 = HorizontalAlignment.values()[arg0.g1()];
        @Pc(23) VerticalAlignment local23 = VerticalAlignment.values()[arg0.g1()];
        @Pc(27) int local27 = arg0.g2s();
        @Pc(33) int local33 = arg0.g2s();
        @Pc(39) int local39 = arg0.g1();
        @Pc(49) int local49 = arg0.g1();
        @Pc(53) int local53 = arg0.g1();
        @Pc(57) int local57 = arg0.g2();
        @Pc(61) int local61 = arg0.g2();
        @Pc(65) int local65 = arg0.g4();
        @Pc(69) int local69 = arg0.g4();
        @Pc(73) int local73 = arg0.g4();
        return new Class125(local7, local14, local23, local27, local33, local39, local49, local53, local57, local61, local65, local69, local73);
    }

}
