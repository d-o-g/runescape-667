import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.msitype.MSIType;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static449 {

    @OriginalMember(owner = "client!od", name = "h", descriptor = "Lclient!uaa;")
    public static Class364 aClass364_1;

    @OriginalMember(owner = "client!od", name = "c", descriptor = "[I")
    public static int[] anIntArray546;

    @OriginalMember(owner = "client!od", name = "e", descriptor = "Z")
    public static boolean aBoolean511 = false;

    @OriginalMember(owner = "client!od", name = "d", descriptor = "Ljava/lang/String;")
    public static String aString75 = "";

    @OriginalMember(owner = "client!od", name = "b", descriptor = "(I)V")
    public static void mapBuild() {
        if (MainLogicManager.step == 3) {
            MainLogicManager.setStep(4);
        } else if (MainLogicManager.step == 7) {
            MainLogicManager.setStep(8);
        } else if (MainLogicManager.step == 9) {
            MainLogicManager.setStep(10);
        } else if (MainLogicManager.step == 11) {
            MainLogicManager.setStep(12);
        }
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(ILclient!uv;)Z")
    public static boolean hasMsi(@OriginalArg(1) Location location) {
        @Pc(17) LocType locType = LocTypeList.instance.list(location.getId());
        if (locType.msi == -1) {
            return true;
        }

        @Pc(31) MSIType msiType = MSITypeList.instance.list(locType.msi);
        if (msiType.image == -1) {
            return true;
        }

        return msiType.ready();
    }
}
