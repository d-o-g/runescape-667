import com.jagex.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;
import java.net.Socket;

public final class Static76 {

    @OriginalMember(owner = "client!cha", name = "h", descriptor = "I")
    public static int anInt1601 = 0;

    @OriginalMember(owner = "client!cha", name = "d", descriptor = "I")
    public static int anInt1604 = 0;

    @OriginalMember(owner = "client!cha", name = "a", descriptor = "(BLclient!ca;)V")
    public static void method1552(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(19) Node_Sub51 local19 = (Node_Sub51) Static113.A_HASH_TABLE___12.get((long) arg0.anInt10740);
        if (local19 == null) {
            return;
        }
        if (local19.aClass2_Sub6_Sub2_4 != null) {
            Static336.aClass2_Sub6_Sub3_1.method5883(local19.aClass2_Sub6_Sub2_4);
            local19.aClass2_Sub6_Sub2_4 = null;
        }
        local19.unlink();
    }

    @OriginalMember(owner = "client!cha", name = "b", descriptor = "(B)V")
    public static void method1555() {
        if (Static6.anInt95 == 0) {
            return;
        }
        try {
            if (++Static654.anInt9739 > 2000) {
                ConnectionManager.LOBBY.close();
                if (Static720.anInt10865 >= 2) {
                    Static6.anInt95 = 0;
                    Static580.anInt8621 = -5;
                    return;
                }
                Login.lobbyInfo.rotateMethods();
                Static6.anInt95 = 1;
                Static654.anInt9739 = 0;
                Static720.anInt10865++;
            }
            if (Static6.anInt95 == 1) {
                ConnectionManager.LOBBY.gameSocketRequest = Login.lobbyInfo.openSocket(SignLink.instance);
                Static6.anInt95 = 2;
            }
            if (Static6.anInt95 == 2) {
                if (ConnectionManager.LOBBY.gameSocketRequest.status == 2) {
                    throw new IOException();
                }
                if (ConnectionManager.LOBBY.gameSocketRequest.status != 1) {
                    return;
                }
                ConnectionManager.LOBBY.connection = Static99.method1975((Socket) ConnectionManager.LOBBY.gameSocketRequest.result);
                ConnectionManager.LOBBY.gameSocketRequest = null;
                ConnectionManager.LOBBY.flush();
                Static6.anInt95 = 4;
            }
            if (Static6.anInt95 == 4 && ConnectionManager.LOBBY.connection.hasAvailable(1)) {
                ConnectionManager.LOBBY.connection.read(ConnectionManager.LOBBY.buffer.data, 1, 0);
                @Pc(139) int local139 = ConnectionManager.LOBBY.buffer.data[0] & 0xFF;
                Static6.anInt95 = 0;
                Static580.anInt8621 = local139;
                ConnectionManager.LOBBY.close();
            }
        } catch (@Pc(148) IOException local148) {
            ConnectionManager.LOBBY.close();
            if (Static720.anInt10865 < 2) {
                Login.lobbyInfo.rotateMethods();
                Static720.anInt10865++;
                Static654.anInt9739 = 0;
                Static6.anInt95 = 1;
            } else {
                Static6.anInt95 = 0;
                Static580.anInt8621 = -4;
            }
        }
    }
}
