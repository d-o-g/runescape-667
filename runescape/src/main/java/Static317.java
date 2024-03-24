import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static317 {

    @OriginalMember(owner = "client!kaa", name = "g", descriptor = "I")
    public static int anInt5046;

    @OriginalMember(owner = "client!kaa", name = "h", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___62 = new ClientProt(56, 0);

    @OriginalMember(owner = "client!kaa", name = "a", descriptor = "(IBI)I")
    public static int method4579(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(4) int local4;
        if (arg1 < arg0) {
            local4 = arg1;
            arg1 = arg0;
            arg0 = local4;
        }
        while (arg0 != 0) {
            local4 = arg1 % arg0;
            arg1 = arg0;
            arg0 = local4;
        }
        return arg1;
    }

}
