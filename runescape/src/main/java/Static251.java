import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static251 {

    @OriginalMember(owner = "client!ho", name = "c", descriptor = "I")
    public static int anInt4037;

    @OriginalMember(owner = "client!ho", name = "l", descriptor = "I")
    public static int anInt4036 = 0;

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "(BII)Z")
    public static boolean method3549(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        if (!MiniMenu.open) {
            return false;
        }
        @Pc(12) int local12 = arg0 >> 16;
        @Pc(23) int local23 = arg0 & 0xFFFF;
        if (InterfaceList.interfaces[local12] == null || InterfaceList.interfaces[local12][local23] == null) {
            return false;
        }
        @Pc(44) Component local44 = InterfaceList.interfaces[local12][local23];
        @Pc(57) MiniMenuEntry local57;
        if (arg1 == -1 && local44.type == 0) {
            for (local57 = (MiniMenuEntry) MiniMenu.entry.first(); local57 != null; local57 = (MiniMenuEntry) MiniMenu.entry.next()) {
                if (local57.action == 18 || local57.action == 1002 || local57.action == 12 || local57.action == 20 || local57.action == 10) {
                    for (@Pc(160) Component local160 = InterfaceList.list(local57.anInt7313); local160 != null; local160 = Static556.method7299(local160)) {
                        if (local160.slot == local44.slot) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (local57 = (MiniMenuEntry) MiniMenu.entry.first(); local57 != null; local57 = (MiniMenuEntry) MiniMenu.entry.next()) {
                if (local57.anInt7316 == arg1 && local44.slot == local57.anInt7313 && (local57.action == 18 || local57.action == 1002 || local57.action == 12 || local57.action == 20 || local57.action == 10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @OriginalMember(owner = "client!ho", name = "a", descriptor = "(III)Z")
    public static boolean method3550(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return Static590.method7746(arg1, arg0) | (arg0 & 0x70000) != 0 || Static42.method1054(arg1, arg0);
    }
}
