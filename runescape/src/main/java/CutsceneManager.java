import com.jagex.ClientProt;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalMember;

public final class CutsceneManager {

    @OriginalMember(owner = "client!aa", name = "d", descriptor = "I")
    public static int state = 0;

    @OriginalMember(owner = "client!aba", name = "f", descriptor = "I")
    public static int cutsceneFadeEnd = -1;

    @OriginalMember(owner = "client!mja", name = "g", descriptor = "I")
    public static int cutsceneFadeAlpha = 255;

    @OriginalMember(owner = "client!kla", name = "Gc", descriptor = "I")
    public static int cutsceneFadeBlue = 0;

    @OriginalMember(owner = "client!fo", name = "d", descriptor = "I")
    public static int cutsceneFadeRed = 0;

    @OriginalMember(owner = "client!tla", name = "A", descriptor = "I")
    public static int cutsceneFadeGreen = 0;

    @OriginalMember(owner = "client!dka", name = "e", descriptor = "I")
    public static int cutsceneFadeStart = -1;

    @OriginalMember(owner = "client!wn", name = "j", descriptor = "I")
    public static int cutsceneId = -1;

    @OriginalMember(owner = "client!gp", name = "a", descriptor = "[Lclient!lw;")
    public static Actor[] actors;

    @OriginalMember(owner = "client!nf", name = "k", descriptor = "Z")
    public static boolean aBoolean480 = false;

    @OriginalMember(owner = "client!kd", name = "j", descriptor = "[[I")
    public static int[][] anIntArrayArray265;

    @OriginalMember(owner = "client!qf", name = "C", descriptor = "Lclient!ge;")
    public static Packet packet;

    @OriginalMember(owner = "client!tca", name = "eh", descriptor = "I")
    public static int clock = -1;

    @OriginalMember(owner = "client!bc", name = "a", descriptor = "(B)V")
    public static void method881() {
        state = 4;
        anIntArrayArray265 = null;
        aBoolean480 = false;
        packet = null;
        Static298.method4385();
        ServerConnection.GAME.send(ClientMessage.create(ClientProt.CUTSCENE_FINISHED, ServerConnection.GAME.cipher));
    }
}
