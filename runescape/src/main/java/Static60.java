import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static60 {

    @OriginalMember(owner = "client!bw", name = "J", descriptor = "Lclient!nga;")
    public static final Class259 aClass259_3 = new Class259();

    @OriginalMember(owner = "client!bw", name = "Q", descriptor = "Z")
    public static boolean aBoolean86 = false;

    @OriginalMember(owner = "client!bw", name = "I", descriptor = "Z")
    public static boolean aBoolean87 = false;

    @OriginalMember(owner = "client!bw", name = "H", descriptor = "[I")
    public static final int[] anIntArray111 = new int[]{16, 32, 64, 128};

    @OriginalMember(owner = "client!bw", name = "a", descriptor = "(IZIII)V")
    public static void method1293(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
        if (Static400.instance.aClass57_Sub29_1.method7915() == 0) {
            Static668.method8700(false);
        } else {
            Static114.anInt2256 = Static400.instance.aClass57_Sub29_1.method7915();
            Static32.method880(0, true);
        }
        Static696.aBoolean784 = arg1;
        Static529.anInt8089 = arg2;
        Static227.anInt3694 = arg3;
        WorldMap.setArea(arg0);
        if (arg4 != -11493) {
            aBoolean86 = false;
        }
    }
}
