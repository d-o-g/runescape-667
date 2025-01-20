import com.jagex.core.constants.AreaMode;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static165 {

    @OriginalMember(owner = "client!fc", name = "h", descriptor = "I")
    public static int anInt2810;

    @OriginalMember(owner = "client!fc", name = "a", descriptor = "(I)V")
    public static void updateLastAreaMode() {
        if (Static117.areaMode == AreaMode.DEFAULT || Static102.lastAreaMode == AreaMode.DEFAULT) {
            return;
        }

        if (Static117.areaMode == AreaMode.CLEAR_LOCAL_NPCS || Static117.areaMode == AreaMode.ALLOW_OUT_OF_BOUNDS || Static117.areaMode != Static102.lastAreaMode && (Static117.areaMode == AreaMode.STATIC_AREA || Static102.lastAreaMode == AreaMode.STATIC_AREA)) {
            NPCList.size = 0;
            NPCList.newSize = 0;
            NPCList.local.clear();
        }

        Static102.lastAreaMode = Static117.areaMode;
    }

}
