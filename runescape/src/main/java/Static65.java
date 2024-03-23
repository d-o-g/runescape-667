import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static65 {

    @OriginalMember(owner = "client!cba", name = "D", descriptor = "[Z")
    public static final boolean[] aBooleanArray2 = new boolean[100];

    @OriginalMember(owner = "client!cba", name = "v", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_8 = new Class155(11);

    @OriginalMember(owner = "client!cba", name = "c", descriptor = "(B)I")
    public static int method1470() {
        @Pc(5) Toolkit local5 = Toolkit.active;
        @Pc(7) boolean local7 = false;
        if (ClientOptions.instance.toolkit.getValue() != 0) {
            @Pc(19) Canvas local19 = new Canvas();
            local19.setSize(100, 100);
            local7 = true;
            local5 = Static255.method3612((js5) null, (TextureSource) null, 0, local19, 0);
        }
        @Pc(36) long local36 = SystemTimer.safetime();
        for (@Pc(38) int local38 = 0; local38 < 10000; local38++) {
            local5.method7994();
        }
        @Pc(71) int local71 = (int) (SystemTimer.safetime() - local36);
        local5.fillRect(100, 100, 0, 0, -16777216);
        if (local7) {
            local5.free();
        }
        return local71;
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(I)V")
    public static void method1472() {
        Static157.method2560();
        Static425.aClass67_6 = null;
        Static74.aSkyBox_1 = null;
        Static456.aSkyBox_3 = null;
        Static74.aClass67_3 = null;
        Static425.aToolkit_13 = null;
        Static226.aClass67_9 = null;
        Static665.aEnvironmentArrayArray1 = null;
    }

}
