import com.jagex.game.runetek6.client.GameShell;
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

    @OriginalMember(owner = "client!tea", name = "a", descriptor = "(IIILclient!cba;)V")
    public static void method8214(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) MiniMenuEntryInner arg2) {
        if (!MiniMenu.open) {
            return;
        }
        @Pc(11) int local11 = 0;
        @Pc(23) int local23;
        for (@Pc(17) MiniMenuEntry local17 = (MiniMenuEntry) arg2.entries.first(); local17 != null; local17 = (MiniMenuEntry) arg2.entries.next()) {
            local23 = MiniMenu.getLineWidth(local17);
            if (local23 > local11) {
                local11 = local23;
            }
        }
        local11 += 8;
        local23 = arg2.size * 16 + 21;
        MiniMenu.openedInnerHeight = (Static60.aBoolean87 ? 26 : 22) + arg2.size * 16;
        @Pc(71) int local71 = MiniMenu.width + MiniMenu.x;
        if (local11 + local71 > GameShell.canvasWid) {
            local71 = MiniMenu.x - local11;
        }
        if (local71 < 0) {
            local71 = 0;
        }
        @Pc(91) int local91 = Static60.aBoolean87 ? 33 : 31;
        @Pc(98) int local98 = arg0 + 13 - local91;
        if (GameShell.canvasHei < local23 + local98) {
            local98 = GameShell.canvasHei - local23;
        }
        MiniMenu.openedInnerX = local71;
        if (local98 < 0) {
            local98 = 0;
        }
        MiniMenu.openedInnerWidth = local11;
        MiniMenu.openedInner = arg2;
        MiniMenu.openedInnerY = local98;
    }

}
