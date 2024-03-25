import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static39 {

    @OriginalMember(owner = "client!bf", name = "o", descriptor = "I")
    public static int lastClanChannelTransmit = 0;

    @OriginalMember(owner = "client!bf", name = "a", descriptor = "(ILclient!ha;)V")
    public static void method1022(@OriginalArg(1) Toolkit arg0) {
        if (Static60.aBoolean87) {
            Static149.method2449(arg0);
        } else {
            Static159.method2574(arg0);
        }
    }
}
