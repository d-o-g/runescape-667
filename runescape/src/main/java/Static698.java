import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static698 {

    @OriginalMember(owner = "client!wba", name = "f", descriptor = "[I")
    public static final int[] anIntArray831 = new int[]{0, 1, 2, 3, 4, 5, 6, 14};

    @OriginalMember(owner = "client!wba", name = "b", descriptor = "Z")
    public static boolean aBoolean792 = false;

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ZII)V")
    public static void method9123(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
        @Pc(12) Node_Sub22 local12 = Static556.method7303(arg1, arg0);
        if (local12 != null) {
            local12.remove();
        }
    }

    @OriginalMember(owner = "client!wba", name = "a", descriptor = "(ILjava/lang/String;)V")
    public static void method9124(@OriginalArg(1) String arg0) {
        if (arg0.equals("")) {
            return;
        }
        @Pc(16) Class153 local16 = Static668.method8701();
        @Pc(29) Node_Sub19 local29 = Static293.method4335(Static244.aClass345_53, local16.aClass186_1);
        local29.aClass2_Sub21_Sub2_1.p1(Static231.method3379(arg0));
        local29.aClass2_Sub21_Sub2_1.pjstr(arg0);
        local16.method3275(local29);
    }
}
