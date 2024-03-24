import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static584 {

    @OriginalMember(owner = "client!sga", name = "a", descriptor = "(IIILclient!kp;Lclient!kp;)V")
    public static void method7665(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Wall arg3, @OriginalArg(4) Wall arg4) {
        @Pc(4) Tile local4 = Static347.getTile(arg0, arg1, arg2);
        if (local4 == null) {
            return;
        }
        local4.aClass8_Sub2_Sub3_2 = arg3;
        local4.aWall_1 = arg4;
        @Pc(22) int local22 = Static246.ground == Static693.underwaterGround ? 1 : 0;
        if (!arg3.isStationary()) {
            arg3.dynamicEntity = Static468.dynamicEntities[local22];
            Static468.dynamicEntities[local22] = arg3;
        } else if (arg3.isTransparent(0)) {
            arg3.dynamicEntity = Static398.transparentStationaryEntities[local22];
            Static398.transparentStationaryEntities[local22] = arg3;
        } else {
            arg3.dynamicEntity = Static576.opaqueStationaryEntities[local22];
            Static576.opaqueStationaryEntities[local22] = arg3;
            Static75.hasOpaqueStationaryEntities = true;
        }
        if (arg4 == null) {
            return;
        }
        if (arg4.isStationary()) {
            if (arg4.isTransparent(0)) {
                arg4.dynamicEntity = Static398.transparentStationaryEntities[local22];
                Static398.transparentStationaryEntities[local22] = arg4;
                return;
            }
            arg4.dynamicEntity = Static576.opaqueStationaryEntities[local22];
            Static576.opaqueStationaryEntities[local22] = arg4;
            Static75.hasOpaqueStationaryEntities = true;
            return;
        }
        arg4.dynamicEntity = Static468.dynamicEntities[local22];
        Static468.dynamicEntities[local22] = arg4;
    }

}
