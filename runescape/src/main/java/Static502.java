import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static502 {

    @OriginalMember(owner = "client!pr", name = "k", descriptor = "S")
    public static short aShort97 = 320;

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(BLclient!ge;)Lclient!il;")
    public static Class138_Sub3 method6720(@OriginalArg(1) Packet arg0) {
        @Pc(7) Class138 local7 = Static632.method8359(arg0);
        @Pc(23) int local23 = arg0.g4();
        @Pc(27) int local27 = arg0.g4();
        return new Class138_Sub3(local7.aClass403_10, local7.aClass103_10, local7.anInt4423, local7.anInt4412, local7.anInt4418, local7.anInt4413, local7.anInt4416, local7.anInt4415, local7.anInt4421, local23, local27);
    }

    @OriginalMember(owner = "client!pr", name = "a", descriptor = "(B[B)V")
    public static void decodeMapDefaults(@OriginalArg(1) byte[] arg0) {
        @Pc(10) Packet local10 = new Packet(arg0);
        while (true) {
            @Pc(14) int local14;
            @Pc(55) int local55;
            @Pc(50) int local50;
            label46:
            do {
                while (true) {
                    while (true) {
                        local14 = local10.g1();
                        if (local14 == 0) {
                            return;
                        }
                        if (local14 == 1) {
                            @Pc(137) int[] local137 = Static449.anIntArray546 = new int[6];
                            local137[0] = local10.g2();
                            local137[1] = local10.g2();
                            local137[2] = local10.g2();
                            local137[3] = local10.g2();
                            local137[4] = local10.g2();
                            local137[5] = local10.g2();
                        } else {
                            if (local14 != 4) {
                                continue label46;
                            }
                            local50 = local10.g1();
                            Static406.maleTitleEnums = new int[local50];
                            for (local55 = 0; local55 < local50; local55++) {
                                Static406.maleTitleEnums[local55] = local10.g2();
                                if (Static406.maleTitleEnums[local55] == 65535) {
                                    Static406.maleTitleEnums[local55] = -1;
                                }
                            }
                        }
                    }
                }
            } while (local14 != 5);
            local50 = local10.g1();
            Static150.femaleTitleEnums = new int[local50];
            for (local55 = 0; local55 < local50; local55++) {
                Static150.femaleTitleEnums[local55] = local10.g2();
                if (Static150.femaleTitleEnums[local55] == 65535) {
                    Static150.femaleTitleEnums[local55] = -1;
                }
            }
        }
    }
}
