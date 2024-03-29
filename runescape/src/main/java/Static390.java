import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static390 {

    @OriginalMember(owner = "client!mda", name = "P", descriptor = "Lclient!rt;")
    public static Class327 aClass327_5;

    @OriginalMember(owner = "client!mda", name = "x", descriptor = "[I")
    public static final int[] anIntArray476 = new int[]{1, 4, 1, 2, 1};

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

    @OriginalMember(owner = "client!mda", name = "a", descriptor = "(III)Z")
    public static boolean method5495(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static483.method6488(arg1, arg0) | (arg0 & 0x60000) != 0 || Static198.method2957(arg0, arg1) || Static319.method4594(arg0, arg1);
    }
}
