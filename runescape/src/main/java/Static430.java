import com.jagex.ClientProt;
import com.jagex.graphics.Exception_Sub1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static430 {

    @OriginalMember(owner = "client!nja", name = "O", descriptor = "[I")
    public static int[] anIntArray519;

    @OriginalMember(owner = "client!nja", name = "K", descriptor = "F")
    public static float aFloat120;

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(I[[I)V")
    public static void method5815(@OriginalArg(1) int[][] arg0) {
        Static723.anIntArrayArray266 = arg0;
    }

    @OriginalMember(owner = "client!nja", name = "d", descriptor = "(B)V")
    public static void method5818() throws Exception_Sub1 {
        if (Static448.anInt6796 == 1) {
            Static74.aToolkit_4.flip(Static2.anInt45, Static312.anInt5001);
        } else {
            Static74.aToolkit_4.flip(0, 0);
        }
    }

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(Ljava/lang/String;II)V")
    public static void method5819(@OriginalArg(0) String arg0, @OriginalArg(2) int arg1) {
        @Pc(10) ServerConnection local10 = ConnectionManager.active();
        @Pc(16) ClientMessage local16 = ClientMessage.create(ClientProt.FRIEND_SETRANK, local10.cipher);
        local16.bitPacket.p1(Static231.method3379(arg0) + 1);
        local16.bitPacket.pjstr(arg0);
        local16.bitPacket.p1_alt2(arg1);
        local10.send(local16);
    }
}
