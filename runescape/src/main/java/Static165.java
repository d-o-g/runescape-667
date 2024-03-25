import com.jagex.core.constants.AreaMode;
import org.openrs2.deob.annotation.OriginalArg;
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
            NPCList.localNpcCount = 0;
            NPCList.newNpcCount = 0;
            NPCList.local.clear();
        }

        Static102.lastAreaMode = Static117.areaMode;
    }

    @OriginalMember(owner = "client!fc", name = "a", descriptor = "(IIBIIII)V")
    public static void method2608(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        if (ClientOptions.instance.soundVolume.getValue() != 0 && arg3 != 0 && SoundManager.count < 50 && arg2 != -1) {
            SoundManager.sounds[SoundManager.count++] = new Sound((byte) 1, arg2, arg3, arg1, arg0, arg5, arg4, null);
        }
    }
}
