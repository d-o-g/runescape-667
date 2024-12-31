import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static61 {

    @OriginalMember(owner = "client!c", name = "a", descriptor = "(IIILclient!eia;)V")
    public static void method1299(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) GroundDecor arg3) {
        @Pc(4) Tile local4 = Static347.getTile(arg0, arg1, arg2);
        if (local4 == null) {
            return;
        }
        local4.groundDecor = arg3;
        @Pc(19) int local19 = Static246.ground == Static693.underwaterGround ? 1 : 0;
        if (arg3.isStationary()) {
            if (arg3.isTransparent(0)) {
                arg3.nextEntity = Static398.transparentStationaryEntities[local19];
                Static398.transparentStationaryEntities[local19] = arg3;
                return;
            }
            arg3.nextEntity = Static576.opaqueStationaryEntities[local19];
            Static576.opaqueStationaryEntities[local19] = arg3;
            Static75.hasOpaqueStationaryEntities = true;
            return;
        }
        arg3.nextEntity = Static468.dynamicEntities[local19];
        Static468.dynamicEntities[local19] = arg3;
    }

    @OriginalMember(owner = "client!c", name = "a", descriptor = "([J[Ljava/lang/Object;Z)V")
    public static void method1308(@OriginalArg(0) long[] arg0, @OriginalArg(1) Object[] arg1) {
        Static542.method7200(arg1, arg0, 0, arg0.length - 1);
    }

}
