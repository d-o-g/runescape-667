import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static134 {

    @OriginalMember(owner = "client!eda", name = "f", descriptor = "Lclient!taa;")
    public static MapRegion aMapRegion_3;

    @OriginalMember(owner = "client!eda", name = "e", descriptor = "I")
    public static int anInt10326;

    @OriginalMember(owner = "client!eda", name = "h", descriptor = "[J")
    public static final long[] aLongArray20 = new long[10];

    @OriginalMember(owner = "client!eda", name = "m", descriptor = "I")
    public static int anInt10330 = 0;

    @OriginalMember(owner = "client!eda", name = "a", descriptor = "([BI)[B")
    public static byte[] method8955(@OriginalArg(0) byte[] arg0) {
        if (arg0 == null) {
            return null;
        } else {
            @Pc(12) byte[] local12 = new byte[arg0.length];
            Arrays.copy(arg0, 0, local12, 0, arg0.length);
            return local12;
        }
    }

}
