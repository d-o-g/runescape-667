import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.game.DelayedStateChange;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.client.event.keyboard.KeyboardMonitor;
import rs2.client.event.keyboard.SimpleKeyboardMonitor;

public final class Static32 {

    @OriginalMember(owner = "client!bba", name = "q", descriptor = "I")
    public static int anInt772;

    @OriginalMember(owner = "client!bba", name = "bb", descriptor = "I")
    public static int anInt775;

    @OriginalMember(owner = "client!bba", name = "D", descriptor = "I")
    public static int anInt773 = 0;

    @OriginalMember(owner = "client!bba", name = "L", descriptor = "I")
    public static int anInt777 = 100;

    @OriginalMember(owner = "client!bba", name = "a", descriptor = "(IBII)Lclient!fk;")
    public static ClientMessage moveMessage(@OriginalArg(0) int x, @OriginalArg(2) int y, @OriginalArg(3) int click) {
        @Pc(11) ClientMessage message = null;
        if (click == 0) {
            message = ClientMessage.create(ClientProt.MOVE_GAMECLICK, ServerConnection.GAME.cipher);
        } else if (click == 1) {
            message = ClientMessage.create(ClientProt.MOVE_MINIMAPCLICK, ServerConnection.GAME.cipher);
        }

        message.bitPacket.p2_alt3(x + WorldMap.areaBaseX);
        message.bitPacket.p2_alt3(WorldMap.areaBaseZ + y);
        message.bitPacket.p1(KeyboardMonitor.instance.isPressed(SimpleKeyboardMonitor.KEY_CODE_CONTROL) ? 1 : 0);

        Minimap.flagSet = false;
        Minimap.flagX = x;
        Minimap.flagY = y;
        DelayedStateChange.resetMapFlag();
        return message;
    }

    @OriginalMember(owner = "client!bba", name = "a", descriptor = "(IZZ)V")
    public static void setToolkit(@OriginalArg(0) int toolkit, @OriginalArg(2) boolean arg1) {
        Static667.setToolkit(arg1, LocalisedText.LOADING.localise(Client.language), toolkit);
    }
}
