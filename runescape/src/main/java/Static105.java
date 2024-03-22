import com.jagex.core.datastruct.key.HashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static105 {

    @OriginalMember(owner = "client!df", name = "p", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_3 = new Class131();

    @OriginalMember(owner = "client!df", name = "u", descriptor = "[Lclient!ho;")
    public static final Class171[] aClass171Array1 = new Class171[6];

    @OriginalMember(owner = "client!df", name = "a", descriptor = "(IIII[BII)Z")
    public static boolean method2042(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) byte[] arg3, @OriginalArg(5) int arg4) {
        @Pc(9) int local9 = arg4 % 8;
        @Pc(16) int local16;
        if (local9 == 0) {
            local16 = 0;
        } else {
            local16 = 8 - local9;
        }
        @Pc(29) int local29 = -((arg0 + 8 - 1) / 8);
        @Pc(38) int local38 = -((arg4 + 8 - 1) / 8);
        for (@Pc(40) int local40 = local29; local40 < 0; local40++) {
            for (@Pc(46) int local46 = local38; local46 < 0; local46++) {
                if (arg3[arg1] == 0) {
                    return true;
                }
                arg1 += 8;
            }
            arg1 -= local16;
            if (arg3[arg1 - 1] == 0) {
                return true;
            }
            arg1 += arg2;
        }
        return false;
    }

    @OriginalMember(owner = "client!df", name = "b", descriptor = "(I)V")
    public static void method2044() {
        Static519.aHashTable_1 = new HashTable(8);
        Static654.anInt9740 = 0;
        for (@Pc(20) ParticleSystem local20 = (ParticleSystem) ParticleSystem.systems.first(); local20 != null; local20 = (ParticleSystem) ParticleSystem.systems.next()) {
            local20.method3652();
        }
    }
}
