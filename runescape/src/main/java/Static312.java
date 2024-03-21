import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static312 {

    @OriginalMember(owner = "client!jt", name = "f", descriptor = "I")
    public static int anInt5001;

    @OriginalMember(owner = "client!jt", name = "h", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_131 = new Class225(112, 6);

    @OriginalMember(owner = "client!jt", name = "g", descriptor = "I")
    public static int anInt5000 = -1;

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
        if (!Static156.aBoolean223) {
            return;
        }
        if (arg0.onOpT != null) {
            @Pc(17) Component local17 = Static15.method186(Static77.anInt1614, Static450.anInt6819);
            if (local17 != null) {
                @Pc(23) Node_Sub42 local23 = new Node_Sub42();
                local23.anObjectArray36 = arg0.onOpT;
                local23.aComponent_14 = arg0;
                local23.aComponent_13 = local17;
                Static472.method6420(local23);
            }
        }
        @Pc(45) ClientMessage local45 = Static293.method4335(Static505.aClass345_119, ConnectionManager.GAME.aClass186_1);
        local45.buffer.p4_alt2(arg0.slot);
        local45.buffer.p2_alt2(Static162.anInt2799);
        local45.buffer.p2_alt3(Static77.anInt1614);
        local45.buffer.p4_alt3(Static450.anInt6819);
        local45.buffer.p2_alt2(arg0.anInt3760);
        local45.buffer.p2_alt1(arg0.id);
        ConnectionManager.GAME.send(local45);
    }
}
