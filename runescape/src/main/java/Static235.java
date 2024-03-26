import com.jagex.game.runetek6.config.loctype.LocType;
import com.jagex.game.runetek6.config.loctype.LocTypeList;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static235 {

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(IIIIIIIII)V")
    public static void method3421(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(8) int arg7) {
        if (arg3 < 1 || arg0 < 1 || Static720.mapWidth - 2 < arg3 || Static501.mapHeight - 2 < arg0) {
            return;
        }
        @Pc(39) int local39 = arg6;
        if (arg6 < 3 && Static441.isBridgeAt(arg0, arg3)) {
            local39 = arg6 + 1;
        }
        if (ClientOptions.instance.animateBackground.getValue() == 0 && !Static696.isTileVisibleFrom(arg0, Static164.areaLevel, arg3, local39)) {
            return;
        }
        if (Static334.activeTiles == null) {
            return;
        }
        Static2.aMapRegion.method7901(arg5, arg0, Static577.collisionMaps[arg6], arg6, arg3, Toolkit.active);
        if (arg7 >= 0) {
            @Pc(93) int local93 = ClientOptions.instance.groundDecor.getValue();
            ClientOptions.instance.update(1, ClientOptions.instance.groundDecor);
            Static2.aMapRegion.loadLocation(arg1, arg7, Static577.collisionMaps[arg6], arg0, Toolkit.active, arg3, arg2, local39, arg6, arg4);
            ClientOptions.instance.update(local93, ClientOptions.instance.groundDecor);
        }
    }

    @OriginalMember(owner = "client!hf", name = "b", descriptor = "(III)Z")
    public static boolean method3424(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        if (arg1 == 11) {
            arg1 = 10;
        }
        @Pc(19) LocType local19 = LocTypeList.instance.list(arg0);
        if (arg1 >= 5 && arg1 <= 8) {
            arg1 = 4;
        }
        return local19.loadedModels(arg1);
    }

    @OriginalMember(owner = "client!hf", name = "a", descriptor = "(III)I")
    public static int method3427(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        @Pc(13) int local13 = arg1 >>> 31;
        return (local13 + arg1) / arg0 - local13;
    }
}
