import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseLog;
import rs2.client.event.mouse.MouseMonitor;

public final class Static443 {

    @OriginalMember(owner = "client!nw", name = "a", descriptor = "(Z)V")
    public static void method5981() {
        if (InterfaceManager.topLevelInterface == -1) {
            return;
        }
        @Pc(13) int local13 = MouseMonitor.instance.getRecordedX();
        @Pc(22) int local22 = MouseMonitor.instance.getRecordedY();
        @Pc(27) MouseLog local27 = (MouseLog) Static226.mouseLogs.first();
        if (local27 != null) {
            local13 = local27.getX();
            local22 = local27.getY();
        }
        @Pc(44) int local44 = 0;
        @Pc(46) int local46 = 0;
        if (InterfaceManager.aBoolean210) {
            local44 = Static130.method2283();
            local46 = Static422.method5771();
        }
        InterfaceManager.mainLogic(local46 + GameShell.canvasHei, local46, local46, local22, local22 + local46, local44 + GameShell.canvasWid, local44, InterfaceManager.topLevelInterface, local13, local44 + local13, local44);
        if (WorldMap.component != null) {
            Static509.method6759(local13 + local44, local22 - -local46);
        }
    }

}
