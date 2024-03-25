import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static441 {

    @OriginalMember(owner = "client!nu", name = "g", descriptor = "I")
    public static int anInt6691;

    @OriginalMember(owner = "client!nu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___168 = new ServerProt(20, -1);

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(ILclient!cg;)V")
    public static void method5967(@OriginalArg(1) PathingEntity arg0) {
        @Pc(9) int local9 = arg0.exactMoveT1 - TimeUtils.clock;
        @Pc(20) int local20 = arg0.exactMoveX1 * 512 + arg0.getSize() * 256;
        @Pc(32) int local32 = arg0.exactMoveZ1 * 512 + arg0.getSize() * 256;
        arg0.z += (local32 - arg0.z) / local9;
        arg0.x += (local20 - arg0.x) / local9;
        arg0.delayedWalkingTicks = 0;
        if (arg0.exactMoveDirection == 0) {
            arg0.method9305(8192);
        }
        if (arg0.exactMoveDirection == 1) {
            arg0.method9305(12288);
        }
        if (arg0.exactMoveDirection == 2) {
            arg0.method9305(0);
        }
        if (arg0.exactMoveDirection == 3) {
            arg0.method9305(4096);
        }
    }

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(III)Z")
    public static boolean isBridgeAt(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= 0 && arg0 >= 0 && arg1 < Static280.tileFlags[1].length && arg0 < Static280.tileFlags[1][arg1].length) {
            return (Static280.tileFlags[1][arg1][arg0] & 0x2) != 0;
        } else {
            return false;
        }
    }
}
