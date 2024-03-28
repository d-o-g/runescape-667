import com.jagex.Client;
import com.jagex.ClientProt;
import com.jagex.core.constants.MainLogicStep;
import com.jagex.core.constants.ModeWhere;
import com.jagex.core.util.JavaScript;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static314 {

    @OriginalMember(owner = "client!jw", name = "b", descriptor = "(B)V")
    public static void tbrefresh() {
        if (Client.modeWhere != ModeWhere.LOCAL) {
            try {
                JavaScript.call("tbrefresh", client.aClient1);
            } catch (@Pc(34) Throwable local34) {
            }
        }
    }

    @OriginalMember(owner = "client!jw", name = "a", descriptor = "(BFFFFI[BIIFILclient!tk;I)V")
    public static void method4565(@OriginalArg(1) float arg0, @OriginalArg(2) float arg1, @OriginalArg(3) float arg2, @OriginalArg(4) float arg3, @OriginalArg(6) byte[] arg4, @OriginalArg(8) int arg5, @OriginalArg(9) float arg6, @OriginalArg(11) Class59 arg7) {
        for (@Pc(5) int local5 = 0; local5 < 16; local5++) {
            Static364.method5251(arg0, arg3, local5, arg7, arg4, arg6, arg1, arg5, arg2);
            arg5 += 16384;
        }
    }

    @OriginalMember(owner = "client!jw", name = "a", descriptor = "(Z)V")
    public static void method4567() {
        if (debugconsole.output != null) {
            try {
                debugconsole.output.close();
            } catch (@Pc(10) IOException local10) {
            }
        }
        debugconsole.output = null;
    }

    @OriginalMember(owner = "client!jw", name = "a", descriptor = "(ZI)V")
    public static void noTimeout(@OriginalArg(0) boolean forceSend) {
        Static557.method7331();

        if (!MainLogicStep.isAtGameScreen(MainLogicManager.step)) {
            return;
        }

        @Pc(13) ServerConnection[] connections = ServerConnection.VALUES;
        for (@Pc(15) int i = 0; i < connections.length; i++) {
            @Pc(20) ServerConnection connection = connections[i];

            connection.idleWriteTicks++;
            if (connection.idleWriteTicks < 50 && !forceSend) {
                return;
            }

            connection.idleWriteTicks = 0;

            if (!connection.errored && connection.connection != null) {
                @Pc(59) ClientMessage message = ClientMessage.create(ClientProt.NO_TIMEOUT, connection.cipher);

                connection.send(message);

                try {
                    connection.flush();
                } catch (@Pc(68) IOException ignored) {
                    connection.errored = true;
                }
            }
        }

        Static557.method7331();
    }
}
