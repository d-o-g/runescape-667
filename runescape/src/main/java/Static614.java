import com.jagex.game.PlayerModel;
import com.jagex.game.runetek6.config.fonttype.FontTypeList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static614 {

    @OriginalMember(owner = "client!th", name = "p", descriptor = "I")
    public static int anInt9373;

    @OriginalMember(owner = "client!th", name = "q", descriptor = "D")
    public static double aDouble22;

    @OriginalMember(owner = "client!th", name = "c", descriptor = "[F")
    public static final float[] aFloatArray67 = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F};

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(ZJ)I")
    public static int method8242(@OriginalArg(1) long arg0) {
        Static551.method7276(arg0);
        return Static260.aCalendar2.get(1);
    }

    @OriginalMember(owner = "client!th", name = "a", descriptor = "(JBI)Ljava/lang/String;")
    public static String method8243(@OriginalArg(0) long arg0, @OriginalArg(2) int arg1) {
        Static551.method7276(arg0);
        @Pc(17) int local17 = Static260.aCalendar2.get(5);
        @Pc(23) int local23 = Static260.aCalendar2.get(2) + 1;
        @Pc(27) int local27 = Static260.aCalendar2.get(1);
        return Integer.toString(local17 / 10) + local17 % 10 + "/" + local23 / 10 + local23 % 10 + "/" + local27 % 100 / 10 + local27 % 10;
    }

    @OriginalMember(owner = "client!th", name = "b", descriptor = "(I)V")
    public static void method8245() {
        Static467.aClass96_3.method2355();
        Static540.aClass79_6.method2073();
        Static68.aIDKTypeList_3.cacheClean(5);
        Static354.aLocTypeList_4.cacheClean(5);
        Static690.aNPCTypeList_2.cacheClean(5);
        Static419.aObjTypeList_1.cacheClean(5);
        Static25.aSeqTypeList_1.cacheClean();
        Static23.aClass128_1.method2698();
        Static529.aClass161_1.method3428();
        Static36.aClass260_1.method5785();
        Static628.aClass342_5.method7784();
        Static648.aClass17_1.method267();
        Static574.aBASTypeList_2.cacheClean(5);
        Static577.aClass246_4.method5581();
        Static720.aMSITypeList_4.cacheClean(5);
        Static523.instance.cacheClean(5);
        Static272.aClass45_1.method1096();
        Static324.aSkyBoxTypeList_1.cacheClean(5);
        Static99.aSkyBoxSphereTypeList_1.cacheClean(5);
        Static48.aClass384_1.method8813();
        Static354.aClass267_1.method5970();
        Static652.aClass214_1.method5037();
        Static561.aClass220_2.method5184();
        PlayerModel.cacheClean();
        Static534.method7121();
        FontTypeList.cacheClean(50);
        Static198.method2951();
        Static194.method2907();
        Static230.A_WEIGHTED_CACHE___81.clean(5);
        Static669.A_WEIGHTED_CACHE___215.clean(5);
        Static541.A_WEIGHTED_CACHE___174.clean(5);
        Static452.A_WEIGHTED_CACHE___149.clean(5);
        Static472.A_WEIGHTED_CACHE___156.clean(5);
    }
}
