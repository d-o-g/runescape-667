import com.jagex.ClientTextCoord;
import com.jagex.core.util.TimeUtils;
import com.jagex.graphics.Fonts;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static205 {

    @OriginalMember(owner = "client!gg", name = "l", descriptor = "Lclient!hc;")
    public static final CutsceneActionType A_CUTSCENE_ACTION_TYPE___15 = new CutsceneActionType(42);

    @OriginalMember(owner = "client!gg", name = "a", descriptor = "(BIIIIII)V")
    public static void method3091(@OriginalArg(1) int arg0, @OriginalArg(3) int arg1, @OriginalArg(5) int arg2, @OriginalArg(6) int arg3) {
        for (@Pc(17) ClientTextCoord local17 = (ClientTextCoord) TextCoordList.textCoords.first(); local17 != null; local17 = (ClientTextCoord) TextCoordList.textCoords.next()) {
            if (local17.end <= TimeUtils.clock) {
                local17.unlink();
            } else {
                Static143.method3573(local17.y * 2, (local17.x << 9) + 256, arg0 >> 1, (local17.z << 9) + 256, local17.level, arg1 >> 1);
                Fonts.b12.renderCentre(0, OverlayManager.hitmarkpos[0] + arg3, local17.text, OverlayManager.hitmarkpos[1] + arg2, local17.colour | 0xFF000000);
            }
        }
    }
}
