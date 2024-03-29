import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static597 {

    @OriginalMember(owner = "client!sr", name = "a", descriptor = "(I[BI)[B")
    public static byte[] method7823(@OriginalArg(1) byte[] arg0, @OriginalArg(2) int arg1) {
        @Pc(12) byte[] local12 = new byte[arg1];
        Arrays.copy(arg0, 0, local12, 0, arg1);
        return local12;
    }

}
