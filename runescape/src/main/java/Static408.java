import com.jagex.game.runetek6.config.meltype.MapElementType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import rs2.client.clan.settings.ClanSettings;

public final class Static408 {

    @OriginalMember(owner = "client!ms", name = "a", descriptor = "(I)V")
    public static void method5632() {
        client.aClient1.load_jagmisc();
        ServerConnection.active.clear();
        ServerConnection.active.idleReadTicks = 0;
        Static249.rebootTimer = 0;
        ServerConnection.active.antepenultimateProt = null;
        ServerConnection.active.penultimateProt = null;
        ServerConnection.active.lastProt = null;
        ServerConnection.active.bitPacket.pos = 0;
        Static102.method2022();
        FriendsList.status = 0;
        FriendChat.name = null;
        FriendsList.count = 0;
        ClanSettings.listened = null;
        ClanSettings.affined = null;
        FriendChat.count = 0;
        FriendChat.users = null;
    }

    @OriginalMember(owner = "client!ms", name = "a", descriptor = "(ZLclient!el;)Z")
    public static boolean method5634(@OriginalArg(1) MapElementType arg0) {
        if (arg0 == null) {
            return false;
        } else if (!arg0.aBoolean214) {
            return false;
        } else if (!arg0.variableTest(WorldMap.varDomain)) {
            return false;
        } else if (Static268.A_HASH_TABLE___22.get(arg0.id) == null) {
            return Static232.A_HASH_TABLE___18.get(arg0.category) == null;
        } else {
            return false;
        }
    }
}
