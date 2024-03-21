import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static121 {

    @OriginalMember(owner = "client!dp", name = "f", descriptor = "I")
    public static int anInt2333;

    @OriginalMember(owner = "client!dp", name = "c", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_49 = new Class225(5, 7);

    @OriginalMember(owner = "client!dp", name = "a", descriptor = "(II)V")
    public static void method2199(@OriginalArg(0) int arg0) {
        @Pc(17) VideoType local17 = (VideoType) VideoTypeList.recentUse.get((long) arg0);
        if (local17 != null) {
            local17.js5.stop();
            Static635.method8380(local17.anInt182, local17.aBoolean15);
            local17.unlink();
        }
    }

}
