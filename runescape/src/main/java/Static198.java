import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static198 {

    // $FF: synthetic field
    @OriginalMember(owner = "client!gca", name = "l", descriptor = "Ljava/lang/Class;")
    public static Class aClass9;

    @OriginalMember(owner = "client!gca", name = "e", descriptor = "I")
    public static int anInt3276 = 0;

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "(IIIIIIII)V")
    public static void method2953(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(7) int arg6) {
        if (arg4 < 0 || arg1 < 0 || Static720.mapWidth - 1 <= arg4 || Static501.mapHeight - 1 <= arg1) {
            return;
        }
        if (Static334.activeTiles == null) {
            return;
        }
        @Pc(52) Location local52;
        if (arg6 == 0) {
            local52 = (Location) Static302.getWall(arg0, arg4, arg1);
            @Pc(58) Location local58 = (Location) Static619.method1510(arg0, arg4, arg1);
            if (local52 != null && arg2 != 2) {
                if (local52 instanceof DynamicWall) {
                    ((DynamicWall) local52).aClass337_1.method7672(arg3);
                } else {
                    Static235.method3421(arg1, arg2, arg5, arg4, arg3, arg6, arg0, local52.getId());
                }
            }
            if (local58 != null) {
                if (local58 instanceof DynamicWall) {
                    ((DynamicWall) local58).aClass337_1.method7672(arg3);
                } else {
                    Static235.method3421(arg1, arg2, arg5, arg4, arg3, arg6, arg0, local58.getId());
                }
            }
        } else if (arg6 == 1) {
            local52 = Static114.getWallDecor(arg0, arg4, arg1);
            if (local52 != null) {
                if (local52 instanceof DynamicWallDecor) {
                    ((DynamicWallDecor) local52).aClass337_4.method7672(arg3);
                } else {
                    @Pc(279) int local279 = local52.getId();
                    if (arg2 == 4 || arg2 == 5) {
                        Static235.method3421(arg1, 4, arg5, arg4, arg3, arg6, arg0, local279);
                    } else if (arg2 == 6) {
                        Static235.method3421(arg1, 4, arg5 + 4, arg4, arg3, arg6, arg0, local279);
                    } else if (arg2 == 7) {
                        Static235.method3421(arg1, 4, (arg5 + 2 & 0x3) + 4, arg4, arg3, arg6, arg0, local279);
                    } else if (arg2 == 8) {
                        Static235.method3421(arg1, 4, arg5 + 4, arg4, arg3, arg6, arg0, local279);
                        Static235.method3421(arg1, 4, (arg5 + 2 & 0x3) + 4, arg4, arg3, arg6, arg0, local279);
                    }
                }
            }
        } else if (arg6 == 2) {
            local52 = (Location) Static578.getEntity(arg0, arg4, arg1, aClass9 == null ? (aClass9 = getClass("Location")) : aClass9);
            if (local52 != null) {
                if (arg2 == 11) {
                    arg2 = 10;
                }
                if (local52 instanceof DynamicLocation) {
                    ((DynamicLocation) local52).aClass337_3.method7672(arg3);
                } else {
                    Static235.method3421(arg1, arg2, arg5, arg4, arg3, arg6, arg0, local52.getId());
                }
            }
        } else if (arg6 == 3) {
            local52 = (Location) Static687.method8959(arg0, arg4, arg1);
            if (local52 != null) {
                if (local52 instanceof DynamicGroundDecor) {
                    ((DynamicGroundDecor) local52).aClass337_2.method7672(arg3);
                } else {
                    Static235.method3421(arg1, arg2, arg5, arg4, arg3, arg6, arg0, local52.getId());
                }
            }
        }
    }

    static Class getClass(String name) {
        Class instance;
        try {
            instance = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw (NoClassDefFoundError) new NoClassDefFoundError().initCause(ex);
        }
        return instance;
    }

    @OriginalMember(owner = "client!gca", name = "a", descriptor = "(IIZ)Z")
    public static boolean method2957(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (Static116.method2142(arg0, arg1)) {
            return (arg0 & 0xB000) != 0 | Static54.method1183(arg1, arg0) | Static194.method2908(arg0, arg1) ? true : (Static139.method2358(arg0, arg1) | Static401.method5575(arg0, arg1)) & (arg1 & 0x37) == 0;
        } else {
            return false;
        }
    }
}
