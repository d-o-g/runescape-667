import com.jagex.game.runetek6.config.iftype.SubInterface;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static77 {

    @OriginalMember(owner = "client!ci", name = "k", descriptor = "I")
    public static int anInt1613;

    @OriginalMember(owner = "client!ci", name = "g", descriptor = "Lclient!pc;")
    public static final ZoneProt A_ZONE_PROT___5 = new ZoneProt(13, 7);

    @OriginalMember(owner = "client!ci", name = "d", descriptor = "Lclient!kda;")
    public static final Class204 aClass204_1 = new Class204(1, 2);

    @OriginalMember(owner = "client!ci", name = "a", descriptor = "(IZ)V")
    public static void method1557() {
        @Pc(13) ClientMessage local13 = ClientMessage.create(Static317.A_CLIENT_PROT___62, ConnectionManager.GAME.cipher);
        ConnectionManager.GAME.send(local13);
        for (@Pc(22) SubInterface local22 = (SubInterface) InterfaceManager.subInterfaces.first(); local22 != null; local22 = (SubInterface) InterfaceManager.subInterfaces.next()) {
            if (!local22.isLinked()) {
                local22 = (SubInterface) InterfaceManager.subInterfaces.first();
                if (local22 == null) {
                    break;
                }
            }
            if (local22.type == 0) {
                InterfaceManager.closeSubInterface(true, true, local22);
            }
        }
        if (InterfaceManager.dialog != null) {
            InterfaceManager.redraw(InterfaceManager.dialog);
            InterfaceManager.dialog = null;
        }
    }

    @OriginalMember(owner = "client!ci", name = "a", descriptor = "(III)Z")
    public static boolean method1560(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x84080) != 0;
    }

    @OriginalMember(owner = "client!ci", name = "b", descriptor = "(I)V")
    public static void method1561() {
        @Pc(8) int local8 = ClientOptions.instance.removeRoofsOverride.getValue();
        if (local8 == 0) {
            Static328.aByteArrayArrayArray4 = null;
            Static556.method7300(0);
        } else if (local8 == 1) {
            Static170.method2652((byte) 0);
            Static556.method7300(512);
            if (Static280.tileFlags != null) {
                Static361.method5240();
            }
        } else {
            Static170.method2652((byte) (Static198.anInt3276 - 4 & 0xFF));
            Static556.method7300(2);
        }
        Static514.anInt7680 = Camera.renderingLevel;
    }
}
