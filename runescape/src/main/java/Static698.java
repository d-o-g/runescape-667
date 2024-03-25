import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static698 {

    @OriginalMember(owner = "client!wba", name = "f", descriptor = "[I")
    public static final int[] anIntArray831 = new int[]{0, 1, 2, 3, 4, 5, 6, 14};

    @OriginalMember(owner = "client!wba", name = "b", descriptor = "Z")
    public static boolean aBoolean792 = false;

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ZII)V")
    public static void method9123(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
        @Pc(12) ClientInventory local12 = Static556.method7303(arg1, arg0);
        if (local12 != null) {
            local12.unlink();
        }
    }

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void method9124(@OriginalArg(1) String arg0) {
        if (arg0.equals("")) {
            return;
        }
        @Pc(16) ServerConnection local16 = ConnectionManager.active();
        @Pc(29) ClientMessage local29 = ClientMessage.create(Static244.A_CLIENT_PROT___53, local16.cipher);
        local29.bitPacket.p1(Static231.method3379(arg0));
        local29.bitPacket.pjstr(arg0);
        local16.send(local29);
    }
}
