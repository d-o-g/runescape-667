import com.jagex.ServerProt;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static157 {

    @OriginalMember(owner = "client!eu", name = "bb", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___61 = new ServerProt(46, 3);

    @OriginalMember(owner = "client!eu", name = "a", descriptor = "(IIIILclient!nda;)V")
    public static void method2564(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) Class8_Sub2_Sub5 arg4) {
        @Pc(4) Tile local4 = Static347.getTile(arg0, arg1, arg2);
        if (local4 == null) {
            return;
        }
        arg4.x = (arg1 << Static52.anInt1066) + Static247.anInt3993;
        arg4.y = arg3;
        arg4.z = (arg2 << Static52.anInt1066) + Static247.anInt3993;
        local4.aClass8_Sub2_Sub5_1 = arg4;
        @Pc(36) int local36 = Static246.ground == Static693.underwaterGround ? 1 : 0;
        if (arg4.isStationary()) {
            if (arg4.isTransparent(0)) {
                arg4.nextEntity = Static398.transparentStationaryEntities[local36];
                Static398.transparentStationaryEntities[local36] = arg4;
                return;
            }
            arg4.nextEntity = Static576.opaqueStationaryEntities[local36];
            Static576.opaqueStationaryEntities[local36] = arg4;
            Static75.hasOpaqueStationaryEntities = true;
            return;
        }
        arg4.nextEntity = Static468.dynamicEntities[local36];
        Static468.dynamicEntities[local36] = arg4;
    }
}
