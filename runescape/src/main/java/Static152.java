import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static152 {

    @OriginalMember(owner = "client!ep", name = "f", descriptor = "(I)V")
    public static void method9273() {
        if (GameShell.signLink.signed && Static668.aConnectionInfo_5.id != -1) {
            Static430.method5817(Static668.aConnectionInfo_5.id, Static668.aConnectionInfo_5.address);
        }
    }
}
