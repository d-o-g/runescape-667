import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseLog;

public final class Static407 {

    @OriginalMember(owner = "client!mr", name = "d", descriptor = "I")
    public static int anInt6285;

    @OriginalMember(owner = "client!mr", name = "f", descriptor = "I")
    public static int anInt6286;

    @OriginalMember(owner = "client!mr", name = "a", descriptor = "(III)Z")
    public static boolean method5627(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return false;
    }

    @OriginalMember(owner = "client!mr", name = "a", descriptor = "(B)V")
    public static void method5628() {
        @Pc(16) MouseLog local16 = (MouseLog) Static226.mouseLogs.first();
        @Pc(30) boolean local30 = InterfaceManager.dragSource != null || Static460.anInt6964 > 0;
        @Pc(34) int local34 = local16.getX();
        @Pc(38) int local38 = local16.getY();
        if (local30) {
            Static536.anInt8149 = 1;
        }
        if (local30) {
            Static75.aClass2_Sub2_Sub16_9 = MiniMenu.leftClickEntry;
        } else {
            MiniMenu.doAction(local38, MiniMenu.leftClickEntry, local34);
        }
    }
}
