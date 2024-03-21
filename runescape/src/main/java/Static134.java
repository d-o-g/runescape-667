import com.jagex.core.util.Arrays;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.FileOutputStream;

public final class Static134 {

    @OriginalMember(owner = "client!eda", name = "k", descriptor = "Ljava/io/FileOutputStream;")
    public static FileOutputStream aFileOutputStream2;

    @OriginalMember(owner = "client!eda", name = "f", descriptor = "Lclient!taa;")
    public static MapRegion aMapRegion_3;

    @OriginalMember(owner = "client!eda", name = "e", descriptor = "I")
    public static int anInt10326;

    @OriginalMember(owner = "client!eda", name = "h", descriptor = "[J")
    public static final long[] aLongArray20 = new long[10];

    @OriginalMember(owner = "client!eda", name = "g", descriptor = "I")
    public static int anInt10329 = 0;

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

    @OriginalMember(owner = "client!eda", name = "a", descriptor = "(Lclient!hda;BZ)V")
    public static void method8956(@OriginalArg(0) Component arg0, @OriginalArg(2) boolean arg1) {
        @Pc(16) int local16 = arg0.scrollWidth == 0 ? arg0.width : arg0.scrollWidth;
        @Pc(37) int local37 = arg0.scrollHeight == 0 ? arg0.height : arg0.scrollHeight;
        Static220.method3200(local16, arg1, local37, InterfaceList.interfaces[arg0.slot >> 16], arg0.slot);
        if (arg0.aComponentArray1 != null) {
            Static220.method3200(local16, arg1, local37, arg0.aComponentArray1, arg0.slot);
        }
        @Pc(72) Node_Sub4 local72 = (Node_Sub4) Static548.aIterableHashTable_40.get((long) arg0.slot);
        if (local72 != null) {
            Static19.method265(arg1, local72.anInt147, local37, local16);
        }
    }
}
