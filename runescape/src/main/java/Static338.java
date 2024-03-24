import com.jagex.core.constants.MiniMenuAction;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static338 {

    @OriginalMember(owner = "client!km", name = "d", descriptor = "I")
    public static int anInt5563;

    @OriginalMember(owner = "client!km", name = "a", descriptor = "I")
    public static int anInt5564 = 0;

    @OriginalMember(owner = "client!km", name = "a", descriptor = "(I[[BLclient!taa;)V")
    public static void method4994(@OriginalArg(1) byte[][] arg0, @OriginalArg(2) MapRegion arg1) {
        @Pc(6) int local6 = Static319.aByteArrayArray16.length;
        for (@Pc(8) int local8 = 0; local8 < local6; local8++) {
            @Pc(13) byte[] local13 = arg0[local8];
            if (local13 != null) {
                @Pc(26) int local26 = (Static89.anIntArray169[local8] >> 8) * 64 - WorldMap.areaBaseX;
                @Pc(36) int local36 = (Static89.anIntArray169[local8] & 0xFF) * 64 - WorldMap.areaBaseZ;
                Static557.method7331();
                arg1.loadLocations(local26, local36, Static577.A_COLLISION_MAP_ARRAY_1, Toolkit.active, local13);
            }
        }
    }

    @OriginalMember(owner = "client!km", name = "a", descriptor = "(I)I")
    public static int method4995() {
        if (MiniMenu.open) {
            return 6;
        } else if (Static470.aClass2_Sub2_Sub16_10 == null) {
            return 0;
        } else {
            @Pc(23) int local23 = Static470.aClass2_Sub2_Sub16_10.action;
            if (MiniMenuAction.isButtonOp(local23)) {
                return 1;
            } else if (Static245.method8635(local23)) {
                return 2;
            } else if (Static523.method3444(local23)) {
                return 3;
            } else if (Static598.method7825(local23)) {
                return 4;
            } else if (Static124.method2218(local23)) {
                return 7;
            } else if (local23 == 4) {
                return 8;
            } else {
                return 5;
            }
        }
    }
}
