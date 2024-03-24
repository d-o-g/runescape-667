import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static471 {

    @OriginalMember(owner = "client!ot", name = "b", descriptor = "(IIII)V")
    public static void method6408(@OriginalArg(2) int arg0, @OriginalArg(3) int arg1) {
        @Pc(11) int local11 = arg1 << 3;
        @Pc(15) int local15 = arg0 << 3;
        if (Camera.anInt7645 == 2) {
            Camera.pitch = local11;
            Camera.roll = 0;
            Camera.yaw = local15;
        }
        Static479.aFloat123 = (float) local11;
        Static171.aFloat64 = (float) local15;
        Static723.method9451();
        Static273.aBoolean339 = true;
    }

    @OriginalMember(owner = "client!ot", name = "b", descriptor = "(II)Lclient!hc;")
    public static Class155 method6409(@OriginalArg(0) int arg0) {
        @Pc(8) Class155[] local8 = Static486.method6503();
        for (@Pc(19) int local19 = 0; local19 < local8.length; local19++) {
            @Pc(25) Class155 local25 = local8[local19];
            if (arg0 == local25.anInt3714) {
                return local25;
            }
        }
        return null;
    }
}
