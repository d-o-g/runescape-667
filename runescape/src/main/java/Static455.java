import org.openrs2.deob.annotation.OriginalMember;

public final class Static455 {

    @OriginalMember(owner = "client!oga", name = "d", descriptor = "I")
    public static int anInt6915 = 1;

    @OriginalMember(owner = "client!oga", name = "g", descriptor = "I")
    public static int varcstrUpdateCount = 0;

    @OriginalMember(owner = "client!oga", name = "a", descriptor = "(I)V")
    public static void method6224() {
        if (!Static647.method8468()) {
            return;
        }
        if (debugconsole.lines == null) {
            debugconsole.reset();
        }
        Static460.anInt8472 = 0;
        debugconsole.open = true;
    }
}
