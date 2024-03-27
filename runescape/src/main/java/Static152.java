import com.jagex.core.io.ConnectionInfo;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static152 {

    @OriginalMember(owner = "client!ep", name = "f", descriptor = "(I)V")
    public static void selectAutoWorld() {
        if (GameShell.signLink.signed && ConnectionInfo.auto.world != -1) {
            client.connectTo(ConnectionInfo.auto.world, ConnectionInfo.auto.address);
        }
    }
}
