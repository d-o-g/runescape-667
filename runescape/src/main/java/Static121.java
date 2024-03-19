import com.jagex.js5.js5;
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
        @Pc(17) Node_Sub5 local17 = (Node_Sub5) Static106.A_HASH_TABLE___11.get((long) arg0);
        if (local17 != null) {
            local17.aClass222_Sub1_1.method9181();
            Static635.method8380(local17.anInt182, local17.aBoolean15);
            local17.remove();
        }
    }

    @OriginalMember(owner = "client!dp", name = "a", descriptor = "(IIILclient!sb;)Lclient!dv;")
    public static Mesh method2201(@OriginalArg(0) int arg0, @OriginalArg(3) js5 arg1) {
        @Pc(9) byte[] local9 = arg1.getfile(0, arg0);
        return local9 == null ? null : new Mesh(local9);
    }
}
