import com.jagex.core.io.Packet;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static518 {

    @OriginalMember(owner = "client!qf", name = "C", descriptor = "Lclient!ge;")
    public static Packet aClass2_Sub21_18;

    @OriginalMember(owner = "client!qf", name = "H", descriptor = "Z")
    public static boolean aBoolean814 = false;

    @OriginalMember(owner = "client!qf", name = "G", descriptor = "[[I")
    public static final int[][] anIntArrayArray262 = new int[6][];

    @OriginalMember(owner = "client!qf", name = "a", descriptor = "(Lclient!pg;B)Ljava/lang/String;")
    public static String method9293(@OriginalArg(0) MiniMenuEntry arg0) {
        if (arg0.aString88 == null || arg0.aString88.length() == 0) {
            return arg0.opBase == null || arg0.opBase.length() <= 0 ? arg0.aString87 : arg0.aString87 + LocalisedText.MINISEPARATOR.localise(client.language) + arg0.opBase;
        } else if (arg0.opBase == null || arg0.opBase.length() <= 0) {
            return arg0.aString87 + LocalisedText.MINISEPARATOR.localise(client.language) + arg0.aString88;
        } else {
            return arg0.aString87 + LocalisedText.MINISEPARATOR.localise(client.language) + arg0.opBase + LocalisedText.MINISEPARATOR.localise(client.language) + arg0.aString88;
        }
    }
}
