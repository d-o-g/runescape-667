import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.event.keyboard.KeyLog;

public final class Static194 {

    @OriginalMember(owner = "client!g", name = "j", descriptor = "[I")
    public static final int[] anIntArray268 = new int[5];

    @OriginalMember(owner = "client!g", name = "h", descriptor = "[Lclient!wka;")
    public static final KeyLog[] AN_KEYBOARD_EVENT_ARRAY_1 = new KeyLog[128];

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(IBI)B")
    public static byte method2904(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        if (arg0 == 9) {
            return (byte) ((arg1 & 0x1) == 0 ? 1 : 2);
        } else {
            return 0;
        }
    }

    @OriginalMember(owner = "client!g", name = "a", descriptor = "(BII)Z")
    public static boolean method2908(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg0 & 0x100100) != 0;
    }
}
