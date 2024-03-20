import com.jagex.collect.ref.ReferenceCache;
import com.jagex.game.runetek6.config.loctype.LocType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static449 {

    @OriginalMember(owner = "client!od", name = "h", descriptor = "Lclient!uaa;")
    public static Class364 aClass364_1;

    @OriginalMember(owner = "client!od", name = "c", descriptor = "[I")
    public static int[] anIntArray546;

    @OriginalMember(owner = "client!od", name = "l", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___146 = new ReferenceCache(8);

    @OriginalMember(owner = "client!od", name = "e", descriptor = "Z")
    public static boolean aBoolean511 = false;

    @OriginalMember(owner = "client!od", name = "d", descriptor = "Ljava/lang/String;")
    public static String aString75 = "";

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(IBILclient!hda;)V")
    public static void method6114(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) Class158 arg2) {
        Static192.anInt3123 = arg0;
        Static71.aClass158_2 = arg2;
        Static725.anInt10936 = arg1;
    }

    @OriginalMember(owner = "client!od", name = "a", descriptor = "(BZZLclient!aha;)V")
    public static void method6115(@OriginalArg(1) boolean arg0, @OriginalArg(2) boolean arg1, @OriginalArg(3) Node_Sub4 arg2) {
        @Pc(6) int local6 = arg2.anInt147;
        @Pc(10) int local10 = (int) arg2.key;
        arg2.remove();
        if (arg1) {
            Static347.method5094(local6);
        }
        Static193.method2897(local6);
        @Pc(27) Class158 local27 = Static145.method2412(local10);
        if (local27 != null) {
            Static178.method2729(local27);
        }
        Static94.method1840();
        if (!arg0 && Static377.anInt5930 != -1) {
            Static145.method2411(1, Static377.anInt5930);
        }
        @Pc(55) Class331 local55 = new Class331(Static548.aHashTable_40);
        for (@Pc(60) Node_Sub4 local60 = (Node_Sub4) local55.method7613(); local60 != null; local60 = (Node_Sub4) local55.method7610()) {
            if (!local60.hasPrev()) {
                local60 = (Node_Sub4) local55.method7613();
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
    public static boolean method6118(@OriginalArg(1) Location arg0) {
        @Pc(17) LocType local17 = Static354.aLocTypeList_4.list(arg0.getId(-32136));
        if (local17.msi == -1) {
            return true;
        } else {
            @Pc(31) Class173 local31 = Static720.aClass363_4.method8362(local17.msi);
            return local31.anInt4167 == -1 ? true : local31.method3690();
        }
    }
}
