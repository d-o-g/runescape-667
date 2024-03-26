import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.game.runetek6.config.msitype.MSIType;
import com.jagex.game.runetek6.config.msitype.MSITypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static449 {

    @OriginalMember(owner = "client!od", name = "h", descriptor = "Lclient!uaa;")
    public static LoadingScreenRenderer aLoadingScreenRenderer_1;

    @OriginalMember(owner = "client!od", name = "c", descriptor = "[I")
    public static int[] anIntArray546;

    @OriginalMember(owner = "client!od", name = "e", descriptor = "Z")
    public static boolean aBoolean511 = false;

    @OriginalMember(owner = "client!od", name = "d", descriptor = "Ljava/lang/String;")
    public static String aString75 = "";

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
