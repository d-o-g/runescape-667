import com.jagex.game.runetek6.config.bastype.BASType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static326 {

    @OriginalMember(owner = "client!kf", name = "a", descriptor = "(ILclient!ca;)I")
    public static int method4870(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(6) int local6 = arg0.anInt1445;
        @Pc(10) BASType local10 = arg0.method9317();
        @Pc(15) int local15 = arg0.animator.getAnimationId();
        if (local15 == -1 || arg0.aBoolean817) {
            local6 = arg0.anInt1455;
        } else if (local10.run == local15 || local15 == local10.runFollowTurn180 || local10.runFollowTurnCw == local15 || local10.runFollowTurnCcw == local15) {
            local6 = arg0.anInt1469;
        } else if (local10.crawl == local15 || local10.crawlFollowTurn180 == local15 || local10.crawlFollowTurnCw == local15 || local10.crawlFollowTurnCcw == local15) {
            local6 = arg0.anInt1459;
        }
        return local6;
    }
}
