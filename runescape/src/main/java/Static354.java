import com.jagex.core.util.TimeUtils;
import com.jagex.game.Animator;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static354 {

    @OriginalMember(owner = "client!ld", name = "m", descriptor = "I")
    public static int anInt5759;

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "I")
    public static int anInt5763;

    @OriginalMember(owner = "client!ld", name = "k", descriptor = "Z")
    public static boolean aBoolean439 = false;

    @OriginalMember(owner = "client!ld", name = "f", descriptor = "Z")
    public static boolean showProfiling = false;

    @OriginalMember(owner = "client!ld", name = "a", descriptor = "(BLclient!cg;)V")
    public static void method5181(@OriginalArg(1) PathingEntity arg0) {
        @Pc(6) Animator local6 = arg0.actionAnimator;
        if (TimeUtils.clock == arg0.exactMoveT2 || !local6.isAnimating() || local6.method9090()) {
            @Pc(34) int local34 = arg0.exactMoveT2 - arg0.exactMoveT1;
            @Pc(40) int local40 = TimeUtils.clock - arg0.exactMoveT1;
            @Pc(52) int local52 = arg0.exactMoveX1 * 512 + arg0.getSize() * 256;
            @Pc(64) int local64 = arg0.exactMoveZ1 * 512 + arg0.getSize() * 256;
            @Pc(76) int local76 = arg0.exactMoveX2 * 512 + arg0.getSize() * 256;
            @Pc(88) int local88 = arg0.exactMoveZ2 * 512 + arg0.getSize() * 256;
            arg0.x = (local76 * local40 + local52 * (local34 - local40)) / local34;
            arg0.z = (local40 * local88 + local64 * (local34 - local40)) / local34;
        }
        arg0.delayedWalkingTicks = 0;
        if (arg0.exactMoveDirection == 0) {
            arg0.turn(8192, false);
        }
        if (arg0.exactMoveDirection == 1) {
            arg0.turn(12288, false);
        }
        if (arg0.exactMoveDirection == 2) {
            arg0.turn(0, false);
        }
        if (arg0.exactMoveDirection == 3) {
            arg0.turn(4096, false);
        }
    }
}
