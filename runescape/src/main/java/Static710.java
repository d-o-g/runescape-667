import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static710 {

    @OriginalMember(owner = "client!wha", name = "l", descriptor = "I")
    public static int varclanUpdateCount = 0;

    @OriginalMember(owner = "client!wha", name = "a", descriptor = "(ILclient!hda;Lclient!hda;)V")
    public static void method6710(@OriginalArg(1) Component arg0, @OriginalArg(2) Component arg1) {
        @Pc(15) ClientMessage local15 = ClientMessage.create(Static671.A_CLIENT_PROT___117, ServerConnection.GAME.cipher);
        local15.bitPacket.p2(arg1.invObject);
        local15.bitPacket.p2_alt1(arg0.id);
        local15.bitPacket.p2_alt2(arg0.invObject);
        local15.bitPacket.p4_alt2(arg0.slot);
        local15.bitPacket.p2_alt1(arg1.id);
        local15.bitPacket.p4_alt3(arg1.slot);
        ServerConnection.GAME.send(local15);
    }

    @OriginalMember(owner = "client!wha", name = "a", descriptor = "(I)V")
    public static void method6711() {
        for (@Pc(10) Class8_Sub1 local10 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.removeFirst(); local10 != null; local10 = (Class8_Sub1) Static149.A_ENTITY_LIST___4.removeFirst()) {
            Static703.method9171(local10);
        }
        @Pc(36) int local36;
        @Pc(38) int local38;
        if (ClientOptions.instance.animateBackground.getValue() == 1) {
            local36 = 0;
            local38 = 3;
        } else {
            local38 = Static164.areaLevel;
            local36 = Static164.areaLevel;
        }
        @Pc(56) int local56;
        if (CutsceneManager.state == 3) {
            for (local56 = local36; local56 <= local38; local56++) {
                Static84.method1654(local56);
            }
            Static84.method1652();
            return;
        }
        Static84.method1655();
        for (local56 = local36; local56 <= local38; local56++) {
            Static84.method1665();
            Static84.method1670(local56);
            Static84.method1654(local56);
        }
        Static84.method1664();
        Static84.method1652();
    }

    @OriginalMember(owner = "client!wha", name = "a", descriptor = "(III)Z")
    public static boolean method6713(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return false;
    }
}
