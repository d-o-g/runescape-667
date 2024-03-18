import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Frame;

public final class Static655 {

    @OriginalMember(owner = "client!un", name = "K", descriptor = "[Lclient!gca;")
    public static Class140[] aClass140Array1;

    @OriginalMember(owner = "client!un", name = "I", descriptor = "Lclient!lga;")
    public static final Class225 aClass225_237 = new Class225(18, 4);

    @OriginalMember(owner = "client!un", name = "t", descriptor = "I")
    public static int anInt9763 = -1;

    @OriginalMember(owner = "client!un", name = "z", descriptor = "I")
    public static int anInt9766 = 0;

    @OriginalMember(owner = "client!un", name = "B", descriptor = "I")
    public static int anInt9767 = 0;

    @OriginalMember(owner = "client!un", name = "a", descriptor = "(Lclient!vq;ILjava/awt/Frame;)V")
    public static void method8562(@OriginalArg(0) SignLink arg0, @OriginalArg(2) Frame arg1) {
        while (true) {
            @Pc(10) SignedResource local10 = arg0.exitFullscreen(arg1);
            while (local10.status == 0) {
                Static638.sleep(10L);
            }
            if (local10.status == 1) {
                arg1.setVisible(false);
                arg1.dispose();
                return;
            }
            Static638.sleep(100L);
        }
    }
}
