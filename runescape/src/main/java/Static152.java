import com.jagex.core.io.ConnectionInfo;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static152 {

    @OriginalMember(owner = "client!ep", name = "f", descriptor = "(I)V")
    public static void selectAutoWorld() {
        if (GameShell.signLink.signed && ConnectionInfo.autoWorld.id != -1) {
            Static430.method5817(ConnectionInfo.autoWorld.id, ConnectionInfo.autoWorld.address);
        }
    }
}
