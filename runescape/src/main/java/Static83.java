import com.jagex.Client;
import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static83 {

    @OriginalMember(owner = "client!cla", name = "a", descriptor = "(IILclient!ge;)V")
    public static void method1608(@OriginalArg(1) int arg0, @OriginalArg(2) Packet arg1) {
        if (Client.uidDat == null) {
            return;
        }
        try {
            Client.uidDat.seek(0L);
            Client.uidDat.write(arg0, 24, arg1.data);
        } catch (@Pc(23) Exception local23) {
        }
    }
}
