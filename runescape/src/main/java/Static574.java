import com.jagex.game.runetek6.client.GameShell;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Dimension;

public final class Static574 {

    @OriginalMember(owner = "client!saa", name = "b", descriptor = "[I")
    public static final int[] anIntArray683 = new int[3];

    @OriginalMember(owner = "client!saa", name = "b", descriptor = "(I)V")
    public static void method7572() {
        if (Toolkit.active.method7978()) {
            Toolkit.active.releaseSurface(GameShell.canvas);
            Static208.method3106();
            if (OrthoMode.toolkitActive) {
                Static720.method9397(GameShell.canvas);
            } else {
                @Pc(26) Dimension local26 = GameShell.canvas.getSize();
                Toolkit.active.addCanvas(GameShell.canvas, local26.width, local26.height);
            }
            Toolkit.active.setCanvas(GameShell.canvas);
        } else {
            Static32.setToolkit(ClientOptions.instance.toolkit.getValue(), false);
        }
        InterfaceManager.redrawAll();
        Static75.hasOpaqueStationaryEntities = true;
    }

    @OriginalMember(owner = "client!saa", name = "a", descriptor = "(I)Z")
    public static boolean method7573() {
        Static334.anInt5456++;
        Static252.aBoolean316 = true;
        return true;
    }
}
