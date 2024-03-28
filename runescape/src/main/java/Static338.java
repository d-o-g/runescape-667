import com.jagex.Client;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static338 {

    @OriginalMember(owner = "client!km", name = "d", descriptor = "I")
    public static int anInt5563;

    @OriginalMember(owner = "client!km", name = "a", descriptor = "(I[[BLclient!taa;)V")
    public static void method4994(@OriginalArg(1) byte[][] arg0, @OriginalArg(2) MapRegion arg1) {
        @Pc(6) int local6 = Static319.aByteArrayArray16.length;
        for (@Pc(8) int local8 = 0; local8 < local6; local8++) {
            @Pc(13) byte[] local13 = arg0[local8];
            if (local13 != null) {
                @Pc(26) int local26 = (Static89.zoneIds[local8] >> 8) * 64 - WorldMap.areaBaseX;
                @Pc(36) int local36 = (Static89.zoneIds[local8] & 0xFF) * 64 - WorldMap.areaBaseZ;
                Static557.method7331();
                arg1.loadLocations(local26, local36, Client.collisionMaps, Toolkit.active, local13);
            }
        }
    }

}
