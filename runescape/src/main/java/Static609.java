import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static609 {

    @OriginalMember(owner = "client!tea", name = "i", descriptor = "Lclient!it;")
    public static final Class184 aClass184_16 = new Class184(12, 0, 1, 0);

    @OriginalMember(owner = "client!tea", name = "g", descriptor = "[I")
    public static final int[] anIntArray715 = new int[]{0, -1, 0, 1};

    @OriginalMember(owner = "client!tea", name = "b", descriptor = "[I")
    public static final int[] anIntArray716 = new int[256];

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(III)V")
    public static void method8212(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(7) Class291 local7 = Static334.aClass291ArrayArrayArray1[arg0][arg1][arg2];
        if (local7 != null) {
            Static109.method2068(local7.aClass8_Sub2_Sub2_1);
            if (local7.aClass8_Sub2_Sub2_1 != null) {
                local7.aClass8_Sub2_Sub2_1 = null;
            }
        }
    }

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(ZI)V")
    public static void method8213(@OriginalArg(0) boolean arg0) {
        for (@Pc(8) Node_Sub51 local8 = (Node_Sub51) Static460.A_DEQUE___40.first(65280); local8 != null; local8 = (Node_Sub51) Static460.A_DEQUE___40.next()) {
            if (local8.aClass2_Sub6_Sub2_4 != null) {
                Static336.aClass2_Sub6_Sub3_1.method5883(local8.aClass2_Sub6_Sub2_4);
                local8.aClass2_Sub6_Sub2_4 = null;
            }
            if (local8.aClass2_Sub6_Sub2_3 != null) {
                Static336.aClass2_Sub6_Sub3_1.method5883(local8.aClass2_Sub6_Sub2_3);
                local8.aClass2_Sub6_Sub2_3 = null;
            }
            local8.remove();
        }
        if (!arg0) {
            return;
        }
        for (@Pc(57) Node_Sub51 local57 = (Node_Sub51) Static717.A_DEQUE___81.first(65280); local57 != null; local57 = (Node_Sub51) Static717.A_DEQUE___81.next()) {
            if (local57.aClass2_Sub6_Sub2_4 != null) {
                Static336.aClass2_Sub6_Sub3_1.method5883(local57.aClass2_Sub6_Sub2_4);
                local57.aClass2_Sub6_Sub2_4 = null;
            }
            local57.remove();
        }
        for (@Pc(85) Node_Sub51 local85 = (Node_Sub51) Static113.A_HASH_TABLE___12.first(); local85 != null; local85 = (Node_Sub51) Static113.A_HASH_TABLE___12.next()) {
            if (local85.aClass2_Sub6_Sub2_4 != null) {
                Static336.aClass2_Sub6_Sub3_1.method5883(local85.aClass2_Sub6_Sub2_4);
                local85.aClass2_Sub6_Sub2_4 = null;
            }
            local85.remove();
        }
    }

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(IIILclient!cba;)V")
    public static void method8214(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Node_Sub2_Sub4 arg2) {
        if (!Static400.aBoolean622) {
            return;
        }
        @Pc(11) int local11 = 0;
        @Pc(23) int local23;
        for (@Pc(17) Node_Sub2_Sub16 local17 = (Node_Sub2_Sub16) arg2.aClass192_3.method4352(); local17 != null; local17 = (Node_Sub2_Sub16) arg2.aClass192_3.method4350()) {
            local23 = Static249.method3536(local17);
            if (local23 > local11) {
                local11 = local23;
            }
        }
        local11 += 8;
        local23 = arg2.anInt1534 * 16 + 21;
        Static25.anInt598 = (Static60.aBoolean87 ? 26 : 22) + arg2.anInt1534 * 16;
        @Pc(71) int local71 = Static682.anInt10295 + Static71.anInt1576;
        if (local11 + local71 > Static680.anInt10289) {
            local71 = Static71.anInt1576 - local11;
        }
        if (local71 < 0) {
            local71 = 0;
        }
        @Pc(91) int local91 = Static60.aBoolean87 ? 33 : 31;
        @Pc(98) int local98 = arg0 + 13 - local91;
        if (Static380.anInt5979 < local23 + local98) {
            local98 = Static380.anInt5979 - local23;
        }
        Static692.anInt10375 = local71;
        if (local98 < 0) {
            local98 = 0;
        }
        Static85.anInt10675 = local11;
        Static139.aClass2_Sub2_Sub4_1 = arg2;
        Static493.anInt7364 = local98;
    }

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(IZI)B")
    public static byte method8215(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        if (arg0 == 9) {
            return (byte) ((arg1 & 0x1) == 0 ? 1 : 2);
        } else {
            return 0;
        }
    }
}
