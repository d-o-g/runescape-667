import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static312 {

    @OriginalMember(owner = "client!jt", name = "f", descriptor = "I")
    public static int anInt5001;

    @OriginalMember(owner = "client!jt", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___131 = new ServerProt(112, 6);

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "(II)V")
    public static void method4541() {
        Static117.aClass2_Sub6_Sub1_2 = null;
        Static676.aJs5_121 = null;
        Static190.anInt3112 = 2;
        Static497.aBoolean564 = false;
        Static24.anInt595 = 0;
        Static96.anInt10171 = 1;
        Static99.anInt2077 = -1;
        Static174.anInt2918 = -1;
    }

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "(BLclient!hda;)V")
    public static void method4542(@OriginalArg(1) Component arg0) {
        if (!InterfaceManager.targeting) {
            return;
        }
        if (arg0.onOpT != null) {
            @Pc(17) Component local17 = InterfaceList.getComponent(InterfaceManager.targetComponent, InterfaceManager.targetSlot);
            if (local17 != null) {
                @Pc(23) HookRequest local23 = new HookRequest();
                local23.arguments = arg0.onOpT;
                local23.source = arg0;
                local23.aComponent_13 = local17;
                ScriptRunner.executeHookInner(local23);
            }
        }
        @Pc(45) ClientMessage local45 = ClientMessage.create(Static505.A_CLIENT_PROT___119, ConnectionManager.GAME.cipher);
        local45.buffer.p4_alt2(arg0.slot);
        local45.buffer.p2_alt2(InterfaceManager.targetInvObj);
        local45.buffer.p2_alt3(InterfaceManager.targetComponent);
        local45.buffer.p4_alt3(InterfaceManager.targetSlot);
        local45.buffer.p2_alt2(arg0.invObject);
        local45.buffer.p2_alt1(arg0.id);
        ConnectionManager.GAME.send(local45);
    }
}
