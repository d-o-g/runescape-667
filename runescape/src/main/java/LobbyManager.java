import com.jagex.Client;
import com.jagex.LoginProt;
import com.jagex.core.io.ConnectionInfo;
import com.jagex.core.io.connection.Connection;
import com.jagex.game.runetek6.client.GameShell;
import com.jagex.sign.SignedResourceStatus;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;

public final class LobbyManager {

    /* from ClientScript 3220, 2284 */
    public static final int LOBBY_RESPONSE_NOREPLY = -5; // No response from server

    public static final int LOBBY_RESPONSE_ERROR = -4; // Error contacting server

    public static final int LOBBY_RESPONSE_AWAITING = -3;

    public static final int LOBBY_RESPONSE_DEFAULT = -2;

    @OriginalMember(owner = "client!ad", name = "a", descriptor = "I")
    public static int step = 0;

    @OriginalMember(owner = "client!ula", name = "B", descriptor = "I")
    public static int ticks = 0;

    @OriginalMember(owner = "client!wr", name = "G", descriptor = "I")
    public static int errors = 0;

    @OriginalMember(owner = "client!sea", name = "z", descriptor = "I")
    public static int response = LOBBY_RESPONSE_DEFAULT;

    @OriginalMember(owner = "client!cha", name = "b", descriptor = "(B)V")
    public static void changeMainState() {
        if (step == 0) {
            return;
        }

        try {
            if (++ticks > 2000) {
                ServerConnection.LOBBY.close();

                if (errors >= 2) {
                    step = 0;
                    response = LOBBY_RESPONSE_NOREPLY;
                    return;
                }

                ConnectionInfo.lobby.rotateMethods();
                step = 1;
                ticks = 0;
                errors++;
            }

            if (step == 1) {
                ServerConnection.LOBBY.gameSocketRequest = ConnectionInfo.lobby.openSocket(GameShell.signLink);
                step = 2;
            }

            if (step == 2) {
                if (ServerConnection.LOBBY.gameSocketRequest.status == SignedResourceStatus.ERROR) {
                    throw new IOException();
                }
                if (ServerConnection.LOBBY.gameSocketRequest.status != SignedResourceStatus.SUCCESS) {
                    return;
                }

                ServerConnection.LOBBY.connection = Connection.create((Socket) ServerConnection.LOBBY.gameSocketRequest.result);
                ServerConnection.LOBBY.gameSocketRequest = null;
                ServerConnection.LOBBY.flush();
                step = 4;
            }

            if (step == 4 && ServerConnection.LOBBY.connection.hasAvailable(1)) {
                ServerConnection.LOBBY.connection.read(ServerConnection.LOBBY.bitPacket.data, 1, 0);
                @Pc(139) int responseCode = ServerConnection.LOBBY.bitPacket.data[0] & 0xFF;
                step = 0;
                response = responseCode;
                ServerConnection.LOBBY.close();
            }
        } catch (@Pc(148) IOException ignored) {
            ServerConnection.LOBBY.close();

            if (errors < 2) {
                ConnectionInfo.lobby.rotateMethods();
                errors++;
                ticks = 0;
                step = 1;
            } else {
                step = 0;
                response = LOBBY_RESPONSE_ERROR;
            }
        }
    }

    @OriginalMember(owner = "client!de", name = "a", descriptor = "(BLjava/lang/String;)V")
    public static void checkEmail(@OriginalArg(1) String email) {
        @Pc(6) ClientMessage message = ClientMessage.createRaw();
        message.bitPacket.p1(LoginProt.CHECK_EMAIL.opcode);
        message.bitPacket.p2(0);

        @Pc(28) int buildPos = message.bitPacket.pos;
        message.bitPacket.p2(Client.BUILD);

        @Pc(39) int[] key = LoginManager.pushXtea(message);
        @Pc(43) int keyPos = message.bitPacket.pos;
        message.bitPacket.pjstr(email);
        message.bitPacket.p1(Client.language);
        message.bitPacket.pos += 7;
        message.bitPacket.tinyenc(key, keyPos, message.bitPacket.pos);
        message.bitPacket.psize2(message.bitPacket.pos - buildPos);
        ServerConnection.LOBBY.send(message);

        response = LOBBY_RESPONSE_AWAITING;
        ticks = 0;
        step = 1;
        errors = 0;
    }

    @OriginalMember(owner = "client!cka", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;ZI)V")
    public static void createAccount(@OriginalArg(0) String email, @OriginalArg(1) int age, @OriginalArg(2) String password, @OriginalArg(3) boolean subscribeToUpdates) {
        @Pc(8) ClientMessage message = ClientMessage.createRaw();
        message.bitPacket.p1(LoginProt.CREATE_ACCOUNT_CONNECT.opcode);
        message.bitPacket.p2(0);

        @Pc(25) int buildPos = message.bitPacket.pos;
        message.bitPacket.p2(Client.BUILD);

        @Pc(38) int[] key = LoginManager.pushXtea(message);
        @Pc(42) int keyPos = message.bitPacket.pos;
        message.bitPacket.pjstr(email);
        message.bitPacket.p2(Client.affid);
        message.bitPacket.pjstr(password);
        message.bitPacket.p8(Client.userFlow);
        message.bitPacket.p1(Client.language);
        message.bitPacket.p1(Client.modeGame.id);

        GameShell.pushUID192(message.bitPacket);

        @Pc(81) String additionalInfo = Client.additionalInfo;
        message.bitPacket.p1(additionalInfo == null ? 0 : 1);
        if (additionalInfo != null) {
            message.bitPacket.pjstr(additionalInfo);
        }

        message.bitPacket.p1(age);
        message.bitPacket.p1(subscribeToUpdates ? 1 : 0);
        message.bitPacket.pos += 7;
        message.bitPacket.tinyenc(key, keyPos, message.bitPacket.pos);
        message.bitPacket.psize2(message.bitPacket.pos - buildPos);
        ServerConnection.LOBBY.send(message);

        errors = 0;
        response = LOBBY_RESPONSE_AWAITING;
        ticks = 0;
        step = 1;

        if (age < 13) {
            Client.under13 = true;
            Static358.setUnderageCookie();
        }
    }

    private LobbyManager() {
        /* empty */
    }
}
