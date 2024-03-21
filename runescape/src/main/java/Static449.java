import com.jagex.core.datastruct.key.Class331;
import com.jagex.game.runetek6.config.loctype.LocType;
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

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(BZZLclient!aha;)V")
    public static void method6115(@OriginalArg(1) boolean arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) SubInterface arg2) {
        @Pc(6) int local6 = arg2.anInt147;
        @Pc(10) int local10 = (int) arg2.key;
        arg2.unlink();
        if (arg1) {
            Static347.method5094(local6);
        }
        Static193.method2897(local6);
        @Pc(27) Component local27 = InterfaceList.list(local10);
        if (local27 != null) {
            InterfaceManager.redraw(local27);
        }
        Static94.method1840();
        if (!arg0 && Static377.anInt5930 != -1) {
            Static145.method2411(1, Static377.anInt5930);
        }
        @Pc(55) Class331 local55 = new Class331(InterfaceManager.subInterfaces);
        for (@Pc(60) SubInterface local60 = (SubInterface) local55.first(); local60 != null; local60 = (SubInterface) local55.next()) {
            if (!local60.isLinked()) {
                local60 = (SubInterface) local55.first();
                if (local60 == null) {
                    break;
                }
            }
            if (local60.anInt146 == 3) {
                @Pc(84) int local84 = (int) local60.key;
                if (local6 == local84 >>> 16) {
                    method6115(arg0, true, local60);
                }
            }
        }
    }

    @OriginalMember(owner = "client!od", name = "b", descriptor = "(I)V")
    public static void mapBuild() {
        if (Static283.step == 3) {
            Static81.method1586(4);
        } else if (Static283.step == 7) {
            Static81.method1586(8);
        } else if (Static283.step == 9) {
            Static81.method1586(10);
        } else if (Static283.step == 11) {
            Static81.method1586(12);
        }
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(ILclient!uv;)Z")
    public static boolean hasMsi(@OriginalArg(1) Location location) {
        @Pc(17) LocType locType = Static354.aLocTypeList_4.list(location.getId());
        if (locType.msi == -1) {
            return true;
        }

        @Pc(31) MSIType msiType = Static720.aMSITypeList_4.list(locType.msi);
        if (msiType.image == -1) {
            return true;
        }

        return msiType.ready();
    }
}
