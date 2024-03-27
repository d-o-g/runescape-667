import com.jagex.Client;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static104 {

    @OriginalMember(owner = "client!de", name = "h", descriptor = "Lclient!uf;")
    public static final Class370 aClass370_1 = new Class370();

    @OriginalMember(owner = "client!de", name = "a", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_2 = new Class131();

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(BLjava/lang/String;)V")
    public static void method2029(@OriginalArg(1) String arg0) {
        @Pc(6) ClientMessage local6 = ClientMessage.createRaw();
        local6.bitPacket.p1(LoginProt.A_LOGIN_PROT___63.opcode);
        local6.bitPacket.p2(0);
        @Pc(28) int local28 = local6.bitPacket.pos;
        local6.bitPacket.p2(667);
        @Pc(39) int[] local39 = Static664.method8652(local6);
        @Pc(43) int local43 = local6.bitPacket.pos;
        local6.bitPacket.pjstr(arg0);
        local6.bitPacket.p1(Client.language);
        local6.bitPacket.pos += 7;
        local6.bitPacket.tinyenc(local39, local43, local6.bitPacket.pos);
        local6.bitPacket.psize2(local6.bitPacket.pos - local28);
        ServerConnection.LOBBY.send(local6);
        Static580.anInt8621 = -3;
        Static654.anInt9739 = 0;
        LobbyManager.step = 1;
        Static720.anInt10865 = 0;
    }

    @OriginalMember(owner = "client!de", name = "b", descriptor = "(B)V")
    public static void method2033() {
        Static425.toolkit.xa(((float) ClientOptions.instance.brightness.getValue() * 0.1F + 0.7F) * 1.1523438F);
        Static425.toolkit.ZA(Static68.anInt4096, 0.69921875F, 1.2F, -200.0F, -240.0F, -200.0F);
        Static425.toolkit.L(Static563.anInt8460, -1, 0);
        Static425.toolkit.method7973(Static226.aClass67_9);
    }
}
