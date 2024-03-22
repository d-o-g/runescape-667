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
    public static int scheduledTicks;

    @OriginalMember(owner = "client!bba", name = "D", descriptor = "I")
    public static int anInt773 = 0;

    @OriginalMember(owner = "client!bba", name = "L", descriptor = "I")
    public static int anInt777 = 100;

    @OriginalMember(owner = "client!bba", name = "a", descriptor = "(IBII)Lclient!fk;")
    public static ClientMessage method878(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(11) ClientMessage local11 = null;
        if (arg2 == 0) {
            local11 = ClientMessage.create(Static500.A_CLIENT_PROT___91, ConnectionManager.GAME.cipher);
        }
        if (arg2 == 1) {
            local11 = ClientMessage.create(Static632.A_CLIENT_PROT___111, ConnectionManager.GAME.cipher);
        }
        local11.buffer.p2_alt3(arg0 + WorldMap.areaBaseX);
        local11.buffer.p2_alt3(WorldMap.areaBaseY + arg1);
        local11.buffer.p1(KeyMonitor.instance.isPressed(82) ? 1 : 0);
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
