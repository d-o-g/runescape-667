import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.mouse.MouseLog;

public final class Static443 {

    @OriginalMember(owner = "client!nw", name = "a", descriptor = "(Z)V")
    public static void method5981() {
        if (Static377.anInt5930 == -1) {
            return;
        }
        @Pc(13) int local13 = Static189.aMouseMonitor_1.getRecordedX();
        @Pc(22) int local22 = Static189.aMouseMonitor_1.getRecordedY();
        @Pc(27) MouseLog local27 = (MouseLog) Static226.A_DEQUE___58.first();
        if (local27 != null) {
            local13 = local27.getX();
            local22 = local27.getY();
        }
        @Pc(44) int local44 = 0;
        @Pc(46) int local46 = 0;
        if (Static137.aBoolean210) {
            local44 = Static130.method2283();
            local46 = Static422.method5771();
        }
        Static431.method5822(local46 + Static380.anInt5979, local46, local46, local22, local22 + local46, local44 + Static680.anInt10289, local44, Static377.anInt5930, local13, local44 + local13, local44);
        if (Static210.aComponent_4 != null) {
            Static509.method6759(local13 + local44, local22 - -local46);
        }
    }

    @OriginalMember(owner = "client!nw", name = "a", descriptor = "(Lclient!hda;II)Ljava/lang/String;")
    public static String method5982(@OriginalArg(0) Component arg0, @OriginalArg(1) int arg1) {
        if (!InterfaceManager.serverActiveProperties(arg0).isOpEnabled(arg1) && arg0.onOp == null) {
            return null;
        } else if (arg0.ops == null || arg1 >= arg0.ops.length || arg0.ops[arg1] == null || arg0.ops[arg1].trim().length() == 0) {
            return InterfaceManager.testOpacity ? "Hidden-" + arg1 : null;
        } else {
            return arg0.ops[arg1];
        }
    }
}
