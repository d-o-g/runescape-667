import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.objtype.ObjTypeList;
import com.jagex.game.runetek6.config.paramtype.ParamTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static390 {

    @OriginalMember(owner = "client!mda", name = "P", descriptor = "Lclient!rt;")
    public static Class327 aClass327_5;

    @OriginalMember(owner = "client!mda", name = "x", descriptor = "[I")
    public static final int[] anIntArray476 = new int[]{1, 4, 1, 2, 1};

    @OriginalMember(owner = "client!mda", name = "z", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___158 = new ServerProt(53, -1);

    @OriginalMember(owner = "client!mda", name = "H", descriptor = "I")
    public static int anInt6126 = 0;

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(ZI)Lclient!rt;")
    public static Class327 method5493(@OriginalArg(1) int arg0) {
        if (arg0 == 0) {
            if ((double) WorldMap.currentZoom == 3.0D) {
                return Static559.aClass327_7;
            }
            if ((double) WorldMap.currentZoom == 4.0D) {
                return Static484.aClass327_6;
            }
            if ((double) WorldMap.currentZoom == 6.0D) {
                return Static142.aClass327_1;
            }
            if ((double) WorldMap.currentZoom >= 8.0D) {
                return Static651.aClass327_8;
            }
        } else if (arg0 == 1) {
            if ((double) WorldMap.currentZoom == 3.0D) {
                return Static142.aClass327_1;
            }
            if ((double) WorldMap.currentZoom == 4.0D) {
                return Static651.aClass327_8;
            }
            if ((double) WorldMap.currentZoom == 6.0D) {
                return Static275.aClass327_2;
            }
            if ((double) WorldMap.currentZoom >= 8.0D) {
                return aClass327_5;
            }
        } else if (arg0 == 2) {
            if ((double) WorldMap.currentZoom == 3.0D) {
                return Static275.aClass327_2;
            }
            if ((double) WorldMap.currentZoom == 4.0D) {
                return aClass327_5;
            }
            if ((double) WorldMap.currentZoom == 6.0D) {
                return Static364.aClass327_4;
            }
            if ((double) WorldMap.currentZoom >= 8.0D) {
                return Static359.aClass327_3;
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(IZIZI)I")
    public static int method5494(@OriginalArg(1) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(4) int arg2) {
        @Pc(18) ClientInventory local18 = Static556.method7303(arg2, false);
        if (local18 == null) {
            return 0;
        }
        @Pc(25) int local25 = 0;
        for (@Pc(27) int local27 = 0; local27 < local18.anIntArray278.length; local27++) {
            if (local18.anIntArray278[local27] >= 0 && local18.anIntArray278[local27] < ObjTypeList.instance.num) {
                @Pc(54) ObjType local54 = ObjTypeList.instance.list(local18.anIntArray278[local27]);
                @Pc(64) int local64 = local54.param(arg1, ParamTypeList.instance.list(arg1).defaultint);
                if (arg0) {
                    local25 += local64 * local18.anIntArray279[local27];
                } else {
                    local25 += local64;
                }
            }
        }
        return local25;
    }

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(III)Z")
    public static boolean method5495(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static483.method6488(arg1, arg0) | (arg0 & 0x60000) != 0 || Static198.method2957(arg0, arg1) || Static319.method4594(arg0, arg1);
    }
}
