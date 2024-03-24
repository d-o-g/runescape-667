import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static26 {

    @OriginalMember(owner = "client!at", name = "j", descriptor = "Lclient!st;")
    public static Sprite aSprite_5;

    @OriginalMember(owner = "client!at", name = "a", descriptor = "(III)V")
    public static void method717(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(7) Tile local7 = Static334.activeTiles[arg0][arg1][arg2];
        if (local7 == null) {
            return;
        }
        Static109.hide(local7.wall);
        Static109.hide(local7.adjacentWall);
        if (local7.wall != null) {
            local7.wall = null;
        }
        if (local7.adjacentWall != null) {
            local7.adjacentWall = null;
        }
    }
}
