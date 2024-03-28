import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static597 {

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "I")
    public static int themeMusic = -1;

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "(IIIZ)I")
    public static int method7822(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) boolean arg2) {
        @Pc(18) ClientInventory local18 = Static556.method7303(arg0, arg2);
        if (local18 == null) {
            return -1;
        } else if (arg1 >= 0 && arg1 < local18.anIntArray278.length) {
            return local18.anIntArray278[arg1];
        } else {
            return -1;
        }
    }

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "(I[BI)[B")
    public static byte[] method7823(@OriginalArg(1) byte[] arg0, @OriginalArg(2) int arg1) {
        @Pc(12) byte[] local12 = new byte[arg1];
        Arrays.copy(arg0, 0, local12, 0, arg1);
        return local12;
    }

}
