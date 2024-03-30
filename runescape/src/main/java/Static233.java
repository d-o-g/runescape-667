import com.jagex.core.util.TimeUtils;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static233 {

    @OriginalMember(owner = "client!he", name = "f", descriptor = "[[I")
    public static final int[][] anIntArrayArray90 = new int[][]{{0, 2, 4, 6}, {6, 0, 2, 3, 5, 3}, {6, 0, 2, 4}, {2, 5, 6, 1}, {0, 2, 6}, {6, 0, 2}, {5, 6, 0, 1, 2, 4}, {7, 7, 1, 2, 4, 6}, {2, 4, 4, 7}, {6, 6, 4, 0, 1, 1, 3, 3}, {0, 2, 2, 6, 6, 4}, {0, 2, 2, 3, 7, 0, 4, 3}, {0, 2, 4, 6}};

    @OriginalMember(owner = "client!he", name = "a", descriptor = "(IIIIIII)V")
    public static void method3407(@OriginalArg(3) int arg0, @OriginalArg(4) int arg1, @OriginalArg(5) int arg2, @OriginalArg(6) int arg3) {
        @Pc(14) HintArrow[] local14 = Static527.hintArrows;
        for (@Pc(16) int local16 = 0; local16 < local14.length; local16++) {
            @Pc(22) HintArrow local22 = local14[local16];
            if (local22 != null && local22.type == 2) {
                Static143.method3573(local22.y * 2, local22.x, arg0 >> 1, local22.z, local22.level, arg3 >> 1);
                if (OverlayManager.hitmarkpos[0] > -1 && TimeUtils.clock % 20 < 10) {
                    @Pc(76) Sprite local76 = Sprites.hintHeadicons[local22.sprite];
                    @Pc(84) int local84 = arg2 + OverlayManager.hitmarkpos[0] - 12;
                    @Pc(92) int local92 = OverlayManager.hitmarkpos[1] + arg1 - 28;
                    local76.render(local84, local92);
                    OrthoMode.method8927(local84, local76.scaleWidth() + local84, local92, local76.scaleHeight() + local92);
                }
            }
        }
    }

}
