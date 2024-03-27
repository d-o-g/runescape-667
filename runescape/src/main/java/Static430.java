import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.Exception_Sub1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.net.URL;

public final class Static430 {

    @OriginalMember(owner = "client!nja", name = "O", descriptor = "[I")
    public static int[] anIntArray519;

    @OriginalMember(owner = "client!nja", name = "K", descriptor = "F")
    public static float aFloat120;

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(I[[I)V")
    public static void method5815(@OriginalArg(1) int[][] arg0) {
        Static723.anIntArrayArray266 = arg0;
    }

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(IBLjava/lang/String;)Z")
    public static boolean method5817(@OriginalArg(0) int arg0, @OriginalArg(2) String arg1) {
        if (GameShell.signLink.signed) {
            ConnectionInfo.login = new ConnectionInfo();
            ConnectionInfo.login.id = arg0;
            ConnectionInfo.login.address = arg1;
            if (Client.modeWhere != ModeWhere.LIVE) {
                ConnectionInfo.login.defaultPort = ConnectionInfo.login.id + 40000;
                ConnectionInfo.login.alternatePort = ConnectionInfo.login.id + 50000;
            }
            for (@Pc(45) int local45 = 0; local45 < WorldList.activeWorlds.length; local45++) {
                if (WorldList.activeWorlds[local45].id == arg0) {
                    Client.worldFlags = WorldList.activeWorlds[local45].flags;
                }
            }
            return true;
        }
        @Pc(73) String local73 = "";
        if (ModeWhere.LIVE != Client.modeWhere) {
            local73 = ":" + (arg0 + 7000);
        }
        @Pc(88) String local88 = "";
        if (Client.settings != null) {
            local88 = "/p=" + Client.settings;
        }
        @Pc(152) String local152 = "http://" + arg1 + local73 + "/l=" + Client.language + "/a=" + Client.affid + local88 + "/j" + (Client.js ? "1" : "0") + ",o" + (Client.objectTag ? "1" : "0") + ",a2";
        try {
            client.aClient1.getAppletContext().showDocument(new URL(local152), "_self");
            return true;
        } catch (@Pc(164) Exception local164) {
            return false;
        }
    }

    @OriginalMember(owner = "client!nja", name = "d", descriptor = "(B)V")
    public static void method5818() throws Exception_Sub1 {
        if (Static448.anInt6796 == 1) {
            Static74.aToolkit_4.flip(Static2.anInt45, Static312.anInt5001);
        } else {
            Static74.aToolkit_4.flip(0, 0);
        }
    }

    @OriginalMember(owner = "client!nja", name = "a", descriptor = "(Ljava/lang/String;II)V")
    public static void method5819(@OriginalArg(0) String arg0, @OriginalArg(2) int arg1) {
        @Pc(10) ServerConnection local10 = ConnectionManager.active();
        @Pc(16) ClientMessage local16 = ClientMessage.create(ClientProt.FRIEND_SETRANK, local10.cipher);
        local16.bitPacket.p1(Static231.method3379(arg0) + 1);
        local16.bitPacket.pjstr(arg0);
        local16.bitPacket.p1_alt2(arg1);
        local10.send(local16);
    }
}
