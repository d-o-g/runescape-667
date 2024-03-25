import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static81 {

    @OriginalMember(owner = "client!cka", name = "c", descriptor = "(I)V")
    public static void method1589() {
        Static345.method5049();
    }

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;ZI)V")
    public static void method1591(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) boolean arg3) {
        @Pc(8) ClientMessage local8 = Static273.method3962();
        local8.bitPacket.p1(LoginProt.A_LOGIN_PROT___58.opcode);
        local8.bitPacket.p2(0);
        @Pc(25) int local25 = local8.bitPacket.pos;
        local8.bitPacket.p2(667);
        @Pc(38) int[] local38 = Static664.method8652(local8);
        @Pc(42) int local42 = local8.bitPacket.pos;
        local8.bitPacket.pjstr(arg0);
        local8.bitPacket.p2(client.affid);
        local8.bitPacket.pjstr(arg2);
        local8.bitPacket.p8(client.userFlow);
        local8.bitPacket.p1(client.language);
        local8.bitPacket.p1(client.modeGame.id);
        Static176.method6690(local8.bitPacket);
        @Pc(81) String local81 = client.addtionalInfo;
        local8.bitPacket.p1(local81 == null ? 0 : 1);
        if (local81 != null) {
            local8.bitPacket.pjstr(local81);
        }
        local8.bitPacket.p1(arg1);
        local8.bitPacket.p1(arg3 ? 1 : 0);
        local8.bitPacket.pos += 7;
        local8.bitPacket.tinyenc(local38, local42, local8.bitPacket.pos);
        local8.bitPacket.psize2(local8.bitPacket.pos - local25);
        ConnectionManager.LOBBY.send(local8);
        Static720.anInt10865 = 0;
        Static580.anInt8621 = -3;
        Static654.anInt9739 = 0;
        Static6.anInt95 = 1;
        if (arg1 < 13) {
            client.under13 = true;
            Static358.method9190();
        }
    }
}
