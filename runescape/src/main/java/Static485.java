import com.jagex.core.util.Arrays;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static485 {

    @OriginalMember(owner = "client!pf", name = "C", descriptor = "[I")
    public static int[] anIntArray886;

    @OriginalMember(owner = "client!pf", name = "q", descriptor = "[I")
    public static final int[] anIntArray887 = new int[]{1, 0, -1, 0};

    @OriginalMember(owner = "client!pf", name = "x", descriptor = "[I")
    public static final int[] anIntArray888 = new int[3];

    @OriginalMember(owner = "client!pf", name = "a", descriptor = "(Lclient!hda;ILclient!ha;)V")
    public static void method9415(@OriginalArg(0) Component arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(38) boolean local38 = Static419.objTypeList.getCachedSprite(arg0.objWearCol ? Static556.self.playerModel : null, arg1, arg0.objNumMode, arg0.invObject, arg0.outline, arg0.invCount, arg0.shadow | 0xFF000000) == null;
        if (local38) {
            Static133.A_DEQUE___13.addLast(new Node_Sub36(arg0.invObject, arg0.invCount, arg0.outline, arg0.shadow | 0xFF000000, arg0.objNumMode, arg0.objWearCol));
            InterfaceManager.redraw(arg0);
        }
    }

    @OriginalMember(owner = "client!pf", name = "a", descriptor = "(Z[FI)[F")
    public static float[] method9420(@OriginalArg(0) boolean arg0, @OriginalArg(1) float[] arg1, @OriginalArg(2) int arg2) {
        if (arg0) {
            return null;
        } else {
            @Pc(12) float[] local12 = new float[arg2];
            Arrays.copy(arg1, 0, local12, 0, arg2);
            return local12;
        }
    }
}
