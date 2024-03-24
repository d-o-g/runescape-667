import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static549 {

    @OriginalMember(owner = "client!rea", name = "f", descriptor = "J")
    public static long aLong282 = 0L;

    @OriginalMember(owner = "client!rea", name = "b", descriptor = "I")
    public static int anInt9424 = 1;

    @OriginalMember(owner = "client!rea", name = "a", descriptor = "(Lclient!qf;Z)V")
    public static void method8293(@OriginalArg(0) PositionEntity arg0, @OriginalArg(1) boolean arg1) {
        for (@Pc(2) int local2 = arg0.x1; local2 <= arg0.x2; local2++) {
            for (@Pc(6) int local6 = arg0.z1; local6 <= arg0.z2; local6++) {
                @Pc(16) Tile local16 = Static334.activeTiles[arg0.level][local2][local6];
                if (local16 != null) {
                    @Pc(21) PositionEntityNode local21 = local16.head;
                    @Pc(23) PositionEntityNode local23 = null;
                    while (local21 != null) {
                        if (local21.entity == arg0) {
                            if (local23 == null) {
                                local16.head = local21.node;
                            } else {
                                local23.node = local21.node;
                            }
                            local21.remove();
                            break;
                        }
                        local23 = local21;
                        local21 = local21.node;
                    }
                }
            }
        }
        if (!arg1) {
            Static109.method2068(arg0);
        }
    }
}
