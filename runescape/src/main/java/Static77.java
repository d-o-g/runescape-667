import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static77 {

    @OriginalMember(owner = "client!ci", name = "k", descriptor = "I")
    public static int anInt1613;

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
