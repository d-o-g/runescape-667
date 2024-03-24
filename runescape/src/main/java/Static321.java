import com.jagex.core.constants.MiniMenuAction;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static321 {

    @OriginalMember(owner = "client!kca", name = "V", descriptor = "I")
    public static int anInt5113;

    @OriginalMember(owner = "client!kca", name = "w", descriptor = "Lclient!ss;")
    public static final ClientProt VIDEO_END = new ClientProt(58, 2);

    @OriginalMember(owner = "client!kca", name = "y", descriptor = "I")
    public static int lastMiscTransmit = 0;

    @OriginalMember(owner = "client!kca", name = "O", descriptor = "[I")
    public static final int[] anIntArray388 = new int[2048];

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(IB)Lclient!wca;")
    public static Class396 method4620() {
        return new Class396(1, false);
    }

    @OriginalMember(owner = "client!kca", name = "a", descriptor = "(II)Z")
    public static boolean method4622(@OriginalArg(0) int arg0) {
        for (@Pc(8) MiniMenuEntry local8 = (MiniMenuEntry) MiniMenu.entry.first(); local8 != null; local8 = (MiniMenuEntry) MiniMenu.entry.next()) {
            if (MiniMenuAction.isNpcOp(local8.action) && local8.v1 == (long) arg0) {
                return true;
            }
        }
        return false;
    }
}
