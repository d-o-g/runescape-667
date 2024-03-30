import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static687 {

    @OriginalMember(owner = "client!vo", name = "a", descriptor = "(IIBII)V")
    public static void method8958(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3) {
        if (arg2 != 8 && arg2 != 16) {
            @Pc(28) Tile local28 = Static334.activeTiles[arg1][arg0][arg3];
            if (local28 != null) {
                if (arg2 == 1) {
                    local28.aShort84 = 0;
                } else if (arg2 == 2) {
                    local28.aShort83 = 0;
                }
            }
            Static416.method5705();
            return;
        }
        for (@Pc(61) int local61 = 0; local61 < Static150.anInt2634; local61++) {
            @Pc(67) LocOccluder local67 = Static285.aLocOccluderArray1[local61];
            if (local67.aByte43 == arg2 && arg0 == local67.aShort26 && arg3 == local67.aShort23 || local67.aShort24 == arg0 && arg3 == local67.aShort23) {
                if (local61 != Static150.anInt2634) {
                    Arrays.copy(Static285.aLocOccluderArray1, local61 + 1, Static285.aLocOccluderArray1, local61, Static285.aLocOccluderArray1.length - local61 - 1);
                }
                Static150.anInt2634--;
                return;
            }
        }
    }

    @OriginalMember(owner = "client!vo", name = "a", descriptor = "(III)Lclient!eia;")
    public static GroundDecor getGroundDecor(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
        @Pc(7) Tile tile = Static334.activeTiles[level][x][z];
        return tile == null || tile.groundDecor == null ? null : tile.groundDecor;
    }
}
