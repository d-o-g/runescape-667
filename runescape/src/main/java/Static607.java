import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static607 {

    @OriginalMember(owner = "client!tca", name = "Fi", descriptor = "Lclient!sb;")
    public static js5 aJs5_113;

    @OriginalMember(owner = "client!tca", name = "fh", descriptor = "[Lclient!dda;")
    public static Class75[] aClass75Array4;

    @OriginalMember(owner = "client!tca", name = "Ci", descriptor = "[I")
    public static final int[] anIntArray711 = new int[1];

    @OriginalMember(owner = "client!tca", name = "eh", descriptor = "I")
    public static int anInt9251 = -1;

    @OriginalMember(owner = "client!tca", name = "bb", descriptor = "(I)Z")
    public static boolean method8163() {
        return Static236.aBoolean305;
    }

    @OriginalMember(owner = "client!tca", name = "a", descriptor = "([BIIIIII[BI)V")
    public static void method8167(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(7) byte[] arg6, @OriginalArg(8) int arg7) {
        @Pc(10) int local10 = -(arg3 >> 2);
        @Pc(15) int local15 = -(arg3 & 0x3);
        for (@Pc(24) int local24 = -arg4; local24 < 0; local24++) {
            @Pc(32) int local32;
            for (@Pc(28) int local28 = local10; local28 < 0; local28++) {
                local32 = arg2++;
                arg0[local32] += arg6[arg7++];
                @Pc(44) int local44 = arg2++;
                arg0[local44] += arg6[arg7++];
                @Pc(56) int local56 = arg2++;
                arg0[local56] += arg6[arg7++];
                @Pc(68) int local68 = arg2++;
                arg0[local68] += arg6[arg7++];
            }
            for (@Pc(88) int local88 = local15; local88 < 0; local88++) {
                local32 = arg2++;
                arg0[local32] += arg6[arg7++];
            }
            arg2 += arg5;
            arg7 += arg1;
        }
    }
}
