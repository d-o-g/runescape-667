import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static609 {

    @OriginalMember(owner = "client!tea", name = "b", descriptor = "[I")
    public static final int[] anIntArray716 = new int[256];

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(III)V")
    public static void method8212(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(7) Tile local7 = Static334.activeTiles[arg0][arg1][arg2];
        if (local7 != null) {
            Static109.hide(local7.groundDecor);
            if (local7.groundDecor != null) {
                local7.groundDecor = null;
            }
        }
    }

}
