import com.jagex.core.constants.TileFlag;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static441 {

    @OriginalMember(owner = "client!nu", name = "g", descriptor = "I")
    public static int anInt6691;

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(ILclient!cg;)V")
    public static void exactMoveTick1(@OriginalArg(1) PathingEntity entity) {
        @Pc(9) int deltaT = entity.exactMoveT1 - TimeUtils.clock;
        @Pc(20) int x = (entity.exactMoveX1 * 512) + (entity.getSize() * 256);
        @Pc(32) int z = (entity.exactMoveZ1 * 512) + (entity.getSize() * 256);

        entity.z += (z - entity.z) / deltaT;
        entity.x += (x - entity.x) / deltaT;
        entity.delayedWalkingTicks = 0;

        if (entity.exactMoveDirection == 0) {
            entity.turn(8192);
        }
        if (entity.exactMoveDirection == 1) {
            entity.turn(12288);
        }
        if (entity.exactMoveDirection == 2) {
            entity.turn(0);
        }
        if (entity.exactMoveDirection == 3) {
            entity.turn(4096);
        }
    }

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(III)Z")
    public static boolean isBridgeAt(@OriginalArg(0) int z, @OriginalArg(1) int x) {
        if (x >= 0 && z >= 0 && x < Static280.tileFlags[1].length && z < Static280.tileFlags[1][x].length) {
            return (Static280.tileFlags[1][x][z] & TileFlag.BRIDGE) != 0;
        } else {
            return false;
        }
    }
}
