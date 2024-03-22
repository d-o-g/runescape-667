import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static42 {

    @OriginalMember(owner = "client!bh", name = "u", descriptor = "Lclient!nc;")
    public static MapElementList aMapElementList_2;

    @OriginalMember(owner = "client!bh", name = "v", descriptor = "[I")
    public static int[] anIntArray69;

    @OriginalMember(owner = "client!bh", name = "w", descriptor = "Lclient!mia;")
    public static final ClientTriggerType A_CLIENT_TRIGGER_TYPE___4 = new ClientTriggerType("", 20);

    @OriginalMember(owner = "client!bh", name = "r", descriptor = "Lclient!eba;")
    public static final Class92 aClass92_3 = new Class92(1);

    @OriginalMember(owner = "client!bh", name = "a", descriptor = "(III)Z")
    public static boolean method1054(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return (Static119.method2175(arg0, arg1) | Static590.method7746(arg0, arg1) | Static604.method7904(arg1, arg0)) & Static154.method2475(arg0, arg1);
    }
}
