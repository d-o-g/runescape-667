import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static32 {

    @OriginalMember(owner = "client!bba", name = "q", descriptor = "I")
    public static int anInt772;

    @OriginalMember(owner = "client!bba", name = "bb", descriptor = "I")
    public static int anInt775;

    @OriginalMember(owner = "client!bba", name = "Z", descriptor = "I")
    public static int anInt776;

    @OriginalMember(owner = "client!bba", name = "D", descriptor = "I")
    public static int anInt773 = 0;

    @OriginalMember(owner = "client!bba", name = "L", descriptor = "I")
    public static int anInt777 = 100;

    @OriginalMember(owner = "client!bba", name = "a", descriptor = "(IBII)Lclient!fk;")
    public static ClientMessage method878(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(11) ClientMessage local11 = null;
        if (arg2 == 0) {
            local11 = Static293.method4335(Static500.aClass345_91, ConnectionManager.GAME.cipher);
        }
        if (arg2 == 1) {
            local11 = Static293.method4335(Static632.aClass345_111, ConnectionManager.GAME.cipher);
        }
        local11.buffer.p2_alt3(arg0 + Static691.areaBaseX);
        local11.buffer.p2_alt3(Static116.areaBaseY + arg1);
        local11.buffer.p1(Static334.aClass319_1.method8479(82) ? 1 : 0);
        Static266.aBoolean583 = false;
        Minimap.flagX = arg0;
        Minimap.flagY = arg1;
        DelayedStateChange.resetMapFlag();
        return local11;
    }

    @OriginalMember(owner = "client!bba", name = "a", descriptor = "(IZZ)V")
    public static void method880(@OriginalArg(0) int arg0, @OriginalArg(2) boolean arg1) {
        Static667.method8695(arg1, LocalisedText.LOADING.localise(Static51.language), arg0);
    }
}
