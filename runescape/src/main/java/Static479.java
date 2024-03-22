import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static479 {

    @OriginalMember(owner = "client!pc", name = "a", descriptor = "F")
    public static float aFloat123 = 1024.0F;

    @OriginalMember(owner = "client!pc", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___177 = new ServerProt(49, 1);

    @OriginalMember(owner = "client!pc", name = "a", descriptor = "(IZI)V")
    public static void method6461(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(13) ClientMessage local13 = ClientMessage.create(Static288.A_CLIENT_PROT___58, ConnectionManager.GAME.cipher);
        local13.buffer.p4_alt3(arg1);
        local13.buffer.p2_alt3(arg0);
        ConnectionManager.GAME.send(local13);
    }

}
