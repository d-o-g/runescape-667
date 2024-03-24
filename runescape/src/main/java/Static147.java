import com.jagex.game.DelayedStateChange;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static147 {

    @OriginalMember(owner = "client!eka", name = "c", descriptor = "[I")
    public static final int[] anIntArray226 = new int[2];

    @OriginalMember(owner = "client!eka", name = "h", descriptor = "[I")
    public static final int[] playerOpCursors = new int[8];

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(IIIZIIIII)Z")
    public static boolean method2419(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
        @Pc(16) int local16 = PlayerEntity.self.pathX[0];
        @Pc(21) int local21 = PlayerEntity.self.pathY[0];
        if (local16 < 0 || local16 >= Static720.mapWidth || local21 < 0 || Static501.mapHeight <= local21) {
            return false;
        } else if (arg4 >= 0 && Static720.mapWidth > arg4 && arg1 >= 0 && arg1 < Static501.mapHeight) {
            @Pc(98) int local98 = Static521.method6870(arg1, PlayerEntity.self.boundSize((byte) 107), arg3, arg5, local16, arg2, Static480.anIntArray583, arg7, local21, arg6, Static577.A_COLLISION_MAP_ARRAY_1[PlayerEntity.self.level], Static70.anIntArray147, arg4, arg0);
            if (local98 < 1) {
                return false;
            }
            Minimap.flagX = Static70.anIntArray147[local98 - 1];
            Minimap.flagY = Static480.anIntArray583[local98 - 1];
            Static266.aBoolean583 = false;
            DelayedStateChange.resetMapFlag();
            return true;
        } else {
            return false;
        }
    }

}
