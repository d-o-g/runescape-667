import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static344 {

    @OriginalMember(owner = "client!kr", name = "i", descriptor = "I")
    public static int anInt5617 = -50;

    @OriginalMember(owner = "client!kr", name = "l", descriptor = "J")
    public static long aLong169 = 0L;

    @OriginalMember(owner = "client!kr", name = "a", descriptor = "(B)V")
    public static void method5043() {
        Static695.anIntArray868 = Static265.method3857(0.4F);
    }

    @OriginalMember(owner = "client!kr", name = "c", descriptor = "(I)V")
    public static void method5046() {
        if (Static625.anInt9472 <= 0) {
            debugconsole.currententry = "";
            return;
        }
        @Pc(19) int local19 = 0;
        for (@Pc(21) int local21 = 0; local21 < debugconsole.lines.length; local21++) {
            if (debugconsole.lines[local21].indexOf("--> ") != -1) {
                local19++;
                if (Static625.anInt9472 == local19) {
                    debugconsole.currententry = debugconsole.lines[local21].substring(debugconsole.lines[local21].indexOf(">") + 2);
                    return;
                }
            }
        }
    }

}
