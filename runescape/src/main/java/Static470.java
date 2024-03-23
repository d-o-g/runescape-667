import org.openrs2.deob.annotation.OriginalMember;

public final class Static470 {

    @OriginalMember(owner = "client!or", name = "F", descriptor = "Lclient!pg;")
    public static MiniMenuEntry aClass2_Sub2_Sub16_10;

    @OriginalMember(owner = "client!or", name = "J", descriptor = "S")
    public static short aShort82;

    @OriginalMember(owner = "client!or", name = "H", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___88 = new ClientProt(19, 3);

    @OriginalMember(owner = "client!or", name = "P", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_32 = new Class155(50);

    @OriginalMember(owner = "client!or", name = "Y", descriptor = "I")
    public static int anInt7112 = -1;

    @OriginalMember(owner = "client!or", name = "Z", descriptor = "I")
    public static int anInt7113 = -1;

    @OriginalMember(owner = "client!or", name = "d", descriptor = "(B)V")
    public static void method6386() {
        if (!Static15.aBoolean17) {
            Static552.aFloat207 += (-Static552.aFloat207 - 24.0F) / 2.0F;
            Static15.aBoolean17 = true;
            Static273.aBoolean339 = true;
        }
    }

    @OriginalMember(owner = "client!or", name = "a", descriptor = "(Z)Z")
    public static boolean method6387() {
        if (MainLogicManager.step == 3) {
            return Static135.anInt8223 == 0 && Static6.anInt95 == 0;
        } else {
            return false;
        }
    }
}
