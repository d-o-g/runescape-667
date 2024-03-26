import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static170 {

    @OriginalMember(owner = "client!fea", name = "a", descriptor = "(BI)V")
    public static void method2652(@OriginalArg(0) byte arg0) {
        if (Static328.aByteArrayArrayArray4 == null) {
            Static328.aByteArrayArrayArray4 = new byte[4][Static720.mapWidth][Static501.mapLength];
        }
        for (@Pc(14) int local14 = 0; local14 < 4; local14++) {
            for (@Pc(17) int local17 = 0; local17 < Static720.mapWidth; local17++) {
                for (@Pc(20) int local20 = 0; local20 < Static501.mapLength; local20++) {
                    Static328.aByteArrayArrayArray4[local14][local17][local20] = arg0;
                }
            }
        }
    }

    @OriginalMember(owner = "client!fea", name = "a", descriptor = "(II)V")
    public static void method2653(@OriginalArg(0) int arg0) {
        Static212.anInt3467 = 100;
        Static409.anInt6318 = arg0;
        Static320.anInt5084 = 3;
        Static475.anInt7168 = -1;
    }
}
