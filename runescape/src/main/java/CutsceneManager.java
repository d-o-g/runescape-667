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
}
