import com.jagex.core.util.SystemTimer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static81 {

    @OriginalMember(owner = "client!cka", name = "q", descriptor = "I")
    public static int anInt1644;

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(I)Lclient!aj;")
    public static DoublyLinkedNode_Sub2__ method1587() {
        @Pc(17) DoublyLinkedNode_Sub2__ local17 = (DoublyLinkedNode_Sub2__) Static138.A_QUEUE___6.first();
        if (local17 != null) {
            local17.unlink();
            local17.unlink2();
            return local17;
        }
        do {
            local17 = (DoublyLinkedNode_Sub2__) Static59.A_QUEUE___9.first();
            if (local17 == null) {
                return null;
            }
            if (local17.method201() > SystemTimer.safetime()) {
                return null;
            }
            local17.unlink();
            local17.unlink2();
        } while ((local17.key2 & Long.MIN_VALUE) == 0L);
        return local17;
    }

    @OriginalMember(owner = "client!cka", name = "c", descriptor = "(I)V")
    public static void method1589() {
        Static345.method5049();
    }

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;ZI)V")
    public static void method1591(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) boolean arg3) {
        @Pc(8) ClientMessage local8 = Static273.method3962();
        local8.buffer.p1(LoginProt.A_LOGIN_PROT___58.opcode);
        local8.buffer.p2(0);
        @Pc(25) int local25 = local8.buffer.pos;
        local8.buffer.p2(667);
        @Pc(38) int[] local38 = Static664.method8652(local8);
        @Pc(42) int local42 = local8.buffer.pos;
        local8.buffer.pjstr(arg0);
        local8.buffer.p2(Static323.anInt5121);
        local8.buffer.pjstr(arg2);
        local8.buffer.p8(Static416.aLong208);
        local8.buffer.p1(Static51.language);
        local8.buffer.p1(Static392.aModeGame_4.id);
        Static176.method6690(local8.buffer);
        @Pc(81) String local81 = Static389.aString64;
        local8.buffer.p1(local81 == null ? 0 : 1);
        if (local81 != null) {
            local8.buffer.pjstr(local81);
        }
        local8.buffer.p1(arg1);
        local8.buffer.p1(arg3 ? 1 : 0);
        local8.buffer.pos += 7;
        local8.buffer.tinyenc(local38, local42, local8.buffer.pos);
        local8.buffer.psize2(local8.buffer.pos - local25);
        ConnectionManager.LOBBY.send(local8);
        Static720.anInt10865 = 0;
        Static580.anInt8621 = -3;
        Static654.anInt9739 = 0;
        Static6.anInt95 = 1;
        if (arg1 < 13) {
            Static477.aBoolean543 = true;
            Static358.method9190();
        }
    }
}
