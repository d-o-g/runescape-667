import com.jagex.core.datastruct.ref.ReferenceCache;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static594 {

    @OriginalMember(owner = "client!sn", name = "f", descriptor = "I")
    public static int anInt8775;

    @OriginalMember(owner = "client!sn", name = "g", descriptor = "Lclient!dla;")
    public static final ReferenceCache A_WEIGHTED_CACHE___193 = new ReferenceCache(128, 4);

    @OriginalMember(owner = "client!sn", name = "h", descriptor = "I")
    public static int anInt8776 = 0;

    @OriginalMember(owner = "client!sn", name = "a", descriptor = "(II)Z")
    public static boolean method7782(@OriginalArg(0) int arg0) {
        return arg0 == 4 || arg0 == 8 || arg0 == 12 || arg0 == 10;
    }
}
