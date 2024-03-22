import com.jagex.core.util.JavaScript;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.io.IOException;

public final class Static314 {

    @OriginalMember(owner = "client!jw", name = "v", descriptor = "I")
    public static int anInt5035;

    @OriginalMember(owner = "client!jw", name = "D", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___132 = new ServerProt(27, 0);

    @OriginalMember(owner = "client!jw", name = "b", descriptor = "(B)V")
    public static void method4562() {
        if (Static2.aClass355_1 != Static16.aClass355_2) {
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
        if (Static134.aFileOutputStream2 != null) {
            try {
                Static134.aFileOutputStream2.close();
            } catch (@Pc(10) IOException local10) {
            }
        }
        Static134.aFileOutputStream2 = null;
    }

    @OriginalMember(owner = "client!jw", name = "a", descriptor = "(ZI)V")
    public static void method4568(@OriginalArg(0) boolean arg0) {
        Static557.method7331();
        if (!Static109.method2070(MainLogicManager.step)) {
            return;
        }
        @Pc(13) ServerConnection[] local13 = Static405.A_SERVER_CONNECTION_ARRAY_1;
        for (@Pc(15) int local15 = 0; local15 < local13.length; local15++) {
            @Pc(20) ServerConnection local20 = local13[local15];
            local20.idleWriteTicks++;
            if (local20.idleWriteTicks < 50 && !arg0) {
                return;
            }
            local20.idleWriteTicks = 0;
            if (!local20.errored && local20.connection != null) {
                @Pc(59) ClientMessage local59 = Static293.method4335(Static415.aClass345_75, local20.cipher);
                local20.send(local59);
                try {
                    local20.flush();
                } catch (@Pc(68) IOException local68) {
                    local20.errored = true;
                }
            }
        }
        Static557.method7331();
    }
}
