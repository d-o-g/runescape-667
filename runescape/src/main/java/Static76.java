import com.jagex.sign.SignedResourceStatus;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;

public final class Static76 {

    @OriginalMember(owner = "client!cha", name = "d", descriptor = "I")
    public static int anInt1604 = 0;

    @OriginalMember(owner = "client!cha", name = "a", descriptor = "(BLclient!ca;)V")
    public static void method1552(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(19) PositionedSound local19 = (PositionedSound) SoundManager.playerSounds.get(arg0.id);
        if (local19 == null) {
            return;
        }
        if (local19.stream != null) {
            SoundManager.activeStreams.remove(local19.stream);
            local19.stream = null;
        }
        local19.unlink();
    }

    @OriginalMember(owner = "client!cha", name = "b", descriptor = "(B)V")
    public static void method1555() {
        if (LobbyManager.step == 0) {
            return;
        }
        try {
            if (++Static654.anInt9739 > 2000) {
                ServerConnection.LOBBY.close();
                if (Static720.anInt10865 >= 2) {
                    LobbyManager.step = 0;
                    Static580.anInt8621 = -5;
                    return;
                }
                ConnectionInfo.lobby.rotateMethods();
                LobbyManager.step = 1;
                Static654.anInt9739 = 0;
                Static720.anInt10865++;
            }
            if (LobbyManager.step == 1) {
                ServerConnection.LOBBY.gameSocketRequest = ConnectionInfo.lobby.openSocket(GameShell.signLink);
                LobbyManager.step = 2;
            }
            if (LobbyManager.step == 2) {
                if (ServerConnection.LOBBY.gameSocketRequest.status == SignedResourceStatus.ERROR) {
                    throw new IOException();
                }
                if (ServerConnection.LOBBY.gameSocketRequest.status != SignedResourceStatus.SUCCESS) {
                    return;
                }
                ServerConnection.LOBBY.connection = Static99.method1975((Socket) ServerConnection.LOBBY.gameSocketRequest.result);
                ServerConnection.LOBBY.gameSocketRequest = null;
                ServerConnection.LOBBY.flush();
                LobbyManager.step = 4;
            }
            if (LobbyManager.step == 4 && ServerConnection.LOBBY.connection.hasAvailable(1)) {
                ServerConnection.LOBBY.connection.read(ServerConnection.LOBBY.bitPacket.data, 1, 0);
                @Pc(139) int local139 = ServerConnection.LOBBY.bitPacket.data[0] & 0xFF;
                LobbyManager.step = 0;
                Static580.anInt8621 = local139;
                ServerConnection.LOBBY.close();
            }
        } catch (@Pc(148) IOException local148) {
            ServerConnection.LOBBY.close();
            if (Static720.anInt10865 < 2) {
                ConnectionInfo.lobby.rotateMethods();
                Static720.anInt10865++;
                Static654.anInt9739 = 0;
                LobbyManager.step = 1;
            } else {
                LobbyManager.step = 0;
                Static580.anInt8621 = -4;
            }
        }
    }
}
