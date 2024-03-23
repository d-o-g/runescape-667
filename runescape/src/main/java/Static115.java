import com.jagex.IndexedImage;
import com.jagex.SignLink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Point;

public final class Static115 {

    @OriginalMember(owner = "client!dka", name = "d", descriptor = "F")
    public static float aFloat50;

    @OriginalMember(owner = "client!dka", name = "a", descriptor = "[[I")
    public static final int[][] anIntArrayArray56 = new int[][]{{0, 2, 4, 6}, {6, 0, 2, 4}, {6, 0, 2}, {2, 6, 0}, {0, 2, 6}, {6, 0, 2}, {5, 6, 0, 1, 2, 4}, {7, 2, 4, 4}, {2, 4, 4, 7}, {6, 6, 4, 0, 2, 2}, {0, 2, 2, 6, 6, 4}, {0, 2, 2, 4, 6, 6}, {0, 2, 4, 6}};

    @OriginalMember(owner = "client!dka", name = "a", descriptor = "(II)V")
    public static void method2136(@OriginalArg(1) int arg0) {
        if (ClientOptions.instance.customCursors.getValue() == 0) {
            arg0 = -1;
        }
        if (arg0 == Static470.anInt7112) {
            return;
        }
        if (arg0 != -1) {
            @Pc(28) Class389 local28 = CursorTypeList.instance.list(arg0);
            @Pc(32) IndexedImage local32 = local28.method8934();
            if (local32 == null) {
                arg0 = -1;
            } else {
                SignLink.instance.method8995(GameShell.canvas, local32.method9383(), new Point(local28.anInt10303, local28.anInt10308), local32.offsetX(), local32.offsetY());
                Static470.anInt7112 = arg0;
            }
        }
        if (arg0 == -1 && Static470.anInt7112 != -1) {
            SignLink.instance.method8995(GameShell.canvas, null, new Point(), -1, -1);
            Static470.anInt7112 = -1;
        }
    }
}
