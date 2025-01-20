import com.jagex.Client;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.PathFinder;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static147 {

    @OriginalMember(owner = "client!eka", name = "c", descriptor = "[I")
    public static final int[] anIntArray226 = new int[2];

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(IIIZIIIII)Z")
    public static boolean findPath(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
        @Pc(16) int local16 = PlayerEntity.self.pathX[0];
        @Pc(21) int local21 = PlayerEntity.self.pathZ[0];
        if (local16 < 0 || local16 >= Static720.mapWidth || local21 < 0 || Static501.mapLength <= local21) {
            return false;
        } else if (arg4 >= 0 && Static720.mapWidth > arg4 && arg1 >= 0 && arg1 < Static501.mapLength) {
            @Pc(98) int local98 = PathFinder.findPath(Client.collisionMaps[PlayerEntity.self.level], PlayerEntity.runZ, PlayerEntity.runX, local16, local21, PlayerEntity.self.getSize(), arg4, arg1, arg7, arg2, arg6, arg0, arg5, arg3);
            if (local98 < 1) {
                return false;
            }
            Minimap.flagX = PlayerEntity.runX[local98 - 1];
            Minimap.flagY = PlayerEntity.runZ[local98 - 1];
            Minimap.flagSet = false;
            DelayedStateChange.resetMapFlag();
            return true;
        } else {
            return false;
        }
    }

}
