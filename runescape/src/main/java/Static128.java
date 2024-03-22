import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static128 {

    @OriginalMember(owner = "client!ea", name = "m", descriptor = "Lclient!hi;")
    public static Class164 aClass164_8;

    @OriginalMember(owner = "client!ea", name = "f", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___106 = new ClientProt(6, 8);

    @OriginalMember(owner = "client!ea", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void method7754(@OriginalArg(1) String arg0) {
        if (Static87.aClass241Array1 == null) {
            return;
        }
        @Pc(21) ServerConnection local21 = Static668.method8701();
        @Pc(27) ClientMessage local27 = ClientMessage.create(Static436.A_CLIENT_PROT___45, local21.cipher);
        local27.buffer.p1(Static231.method3379(arg0));
        local27.buffer.pjstr(arg0);
        local21.send(local27);
    }
}
