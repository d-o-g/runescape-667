import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static39 {

    @OriginalMember(owner = "client!bf", name = "p", descriptor = "Lclient!mia;")
    public static final ClientTriggerType A_CLIENT_TRIGGER_TYPE___3 = new ClientTriggerType("", 11);

    @OriginalMember(owner = "client!bf", name = "o", descriptor = "I")
    public static int lastClanChannelTransmit = 0;

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(III)I")
    public static int method1020(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        @Pc(5) int local5 = 1;
        while (arg0 > 1) {
            if ((arg0 & 0x1) != 0) {
                local5 *= arg1;
            }
            arg1 *= arg1;
            arg0 >>= 0x1;
        }
        if (arg0 == 1) {
            return local5 * arg1;
        } else {
            return local5;
        }
    }

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(ILclient!ha;)V")
    public static void method1022(@OriginalArg(1) Toolkit arg0) {
        if (Static60.aBoolean87) {
            Static149.method2449(arg0);
        } else {
            Static159.method2574(arg0);
        }
    }
}
