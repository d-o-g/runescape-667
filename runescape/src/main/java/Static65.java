import com.jagex.core.util.SystemTimer;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.ToolkitType;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static65 {

    @OriginalMember(owner = "client!cba", name = "D", descriptor = "[Z")
    public static final boolean[] aBooleanArray2 = new boolean[100];

    @OriginalMember(owner = "client!cba", name = "v", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_8 = new Class155(11);

    @OriginalMember(owner = "client!cba", name = "c", descriptor = "(B)I")
    public static int profileCpu() {
        @Pc(5) Toolkit toolkit = Toolkit.active;

        @Pc(7) boolean toolkitChanged = false;
        if (ClientOptions.instance.toolkit.getValue() != ToolkitType.JAVA) {
            @Pc(19) Canvas canvas = new Canvas();
            canvas.setSize(100, 100);

            toolkitChanged = true;
            toolkit = Static255.create(ToolkitType.JAVA, null, canvas, null, 0);
        }

        @Pc(36) long startTime = SystemTimer.safetime();
        for (@Pc(38) int i = 0; i < 10000; i++) {
            toolkit.method7994();
        }

        @Pc(71) int deltaTime = (int) (SystemTimer.safetime() - startTime);
        toolkit.fillRect(100, 100, 0, 0, 0xFF000000);

        if (toolkitChanged) {
            toolkit.free();
        }

        return deltaTime;
    }

    @OriginalMember(owner = "client!cba", name = "a", descriptor = "(I)V")
    public static void method1472() {
        Environment.cacheReset();
        Static425.aClass67_6 = null;
        Static74.aSkyBox_1 = null;
        Static456.aSkyBox_3 = null;
        Static74.aClass67_3 = null;
        Static425.toolkit = null;
        Static226.aClass67_9 = null;
        Static665.aEnvironmentArrayArray1 = null;
    }

}
