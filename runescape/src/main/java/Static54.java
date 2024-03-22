import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static54 {

    @OriginalMember(owner = "client!bq", name = "E", descriptor = "[I")
    public static int[] anIntArray92;

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(I)V")
    public static void method1179() {
        Static342.method4465(ClientOptions.instance.aClass57_Sub5_1.method2172());
        @Pc(19) int local19 = (WorldMap.areaBaseX >> 3) + (Static170.anInt2864 >> 12);
        @Pc(28) int local28 = (Static110.anInt2186 >> 12) + (WorldMap.areaBaseY >> 3);
        Camera.renderingLevel = PlayerEntity.self.level = 0;
        PlayerEntity.self.method1419(8, 8);
        Static22.anIntArrayArray11 = new int[18][4];
        Static363.aByteArrayArray22 = new byte[18][];
        Static177.aByteArrayArray5 = new byte[18][];
        Static267.anIntArray329 = new int[18];
        Static68.anIntArray316 = new int[18];
        Static266.anIntArray615 = new int[18];
        Static89.anIntArray169 = new int[18];
        Static421.aByteArrayArray19 = new byte[18][];
        Static298.anIntArray367 = new int[18];
        Static376.anIntArray458 = new int[18];
        Static319.aByteArrayArray16 = new byte[18][];
        Static118.aByteArrayArray3 = new byte[18][];
        @Pc(79) int local79 = 0;
        @Pc(99) int local99;
        for (@Pc(88) int local88 = (local19 - (Static720.mapWidth >> 4)) / 8; local88 <= (local19 + (Static720.mapWidth >> 4)) / 8; local88++) {
            for (local99 = (local28 - (Static501.mapHeight >> 4)) / 8; local99 <= ((Static501.mapHeight >> 4) + local28) / 8; local99++) {
                @Pc(107) int local107 = local99 + (local88 << 8);
                Static89.anIntArray169[local79] = local107;
                Static267.anIntArray329[local79] = js5.MAPS.getgroupid("m" + local88 + "_" + local99);
                Static266.anIntArray615[local79] = js5.MAPS.getgroupid("l" + local88 + "_" + local99);
                Static376.anIntArray458[local79] = js5.MAPS.getgroupid("n" + local88 + "_" + local99);
                Static68.anIntArray316[local79] = js5.MAPS.getgroupid("um" + local88 + "_" + local99);
                Static298.anIntArray367[local79] = js5.MAPS.getgroupid("ul" + local88 + "_" + local99);
                if (Static376.anIntArray458[local79] == -1) {
                    Static267.anIntArray329[local79] = -1;
                    Static266.anIntArray615[local79] = -1;
                    Static68.anIntArray316[local79] = -1;
                    Static298.anIntArray367[local79] = -1;
                }
                local79++;
            }
        }
        for (local99 = local79; local99 < Static376.anIntArray458.length; local99++) {
            Static376.anIntArray458[local99] = -1;
            Static267.anIntArray329[local99] = -1;
            Static266.anIntArray615[local99] = -1;
            Static68.anIntArray316[local99] = -1;
            Static298.anIntArray367[local99] = -1;
        }
        @Pc(309) byte local309;
        if (MainLogicManager.step == 3) {
            local309 = 4;
        } else if (MainLogicManager.step == 9) {
            local309 = 10;
        } else if (MainLogicManager.step == 7) {
            local309 = 8;
        } else {
            throw new RuntimeException(String.valueOf(MainLogicManager.step));
        }
        Static684.method8931(false, local19, local309, local28);
    }

    @OriginalMember(owner = "client!bq", name = "a", descriptor = "(IBI)Z")
    public static boolean method1183(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x84080) != 0;
    }
}
