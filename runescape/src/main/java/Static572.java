import com.jagex.Client;
import com.jagex.game.LocalisedText;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static572 {

    @OriginalMember(owner = "client!s", name = "a", descriptor = "[Ljava/lang/String;")
    public static final String[] aStringArray42 = new String[200];

    @OriginalMember(owner = "client!s", name = "a", descriptor = "(IIII)I")
    public static int method7867(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(15) int local15 = 255 - arg2;
        @Pc(33) int local33 = ((arg0 & 0xFF00) * arg2 & 0xFF0000 | (arg0 & 0xFF00FF) * arg2 & 0xFF00FF00) >>> 8;
        return local33 + ((local15 * (arg1 & 0xFF00) & 0xFF0000 | (arg1 & 0xFF00FF) * local15 & 0xFF00FF00) >>> 8);
    }

    @OriginalMember(owner = "client!s", name = "b", descriptor = "(III)V")
    public static void method7876(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        @Pc(11) int local11 = Fonts.b12Metrics.stringWidth(LocalisedText.CHOOSEOPTION.localise(Client.language));
        @Pc(68) int local68;
        @Pc(27) int local27;
        if (Static236.aBoolean304) {
            for (@Pc(18) MiniMenuEntryInner local18 = (MiniMenuEntryInner) MiniMenu.innerEntries.first(); local18 != null; local18 = (MiniMenuEntryInner) MiniMenu.innerEntries.next()) {
                if (local18.size == 1) {
                    local27 = MiniMenu.getLineWidth((MiniMenuEntry) local18.entries.sentinel.next2);
                } else {
                    local27 = Static192.method2875(local18);
                }
                if (local27 > local11) {
                    local11 = local27;
                }
            }
            local11 += 8;
            MiniMenu.height = (Static60.aBoolean87 ? 26 : 22) + MiniMenu.innerCount * 16;
            local68 = MiniMenu.innerCount * 16 + 21;
        } else {
            for (@Pc(74) MiniMenuEntry local74 = (MiniMenuEntry) MiniMenu.entries.first(); local74 != null; local74 = (MiniMenuEntry) MiniMenu.entries.next()) {
                local27 = MiniMenu.getLineWidth(local74);
                if (local11 < local27) {
                    local11 = local27;
                }
            }
            local11 += 8;
            MiniMenu.height = (Static60.aBoolean87 ? 26 : 22) + MiniMenu.entryCount * 16;
            local68 = MiniMenu.entryCount * 16 + 21;
        }
        @Pc(118) int local118 = arg1 - local11 / 2;
        if (GameShell.canvasWid < local11 + local118) {
            local118 = GameShell.canvasWid - local11;
        }
        if (local118 < 0) {
            local118 = 0;
        }
        @Pc(146) int local146 = arg0;
        if (arg0 + local68 > GameShell.canvasHei) {
            local146 = GameShell.canvasHei - local68;
        }
        if (local146 < 0) {
            local146 = 0;
        }
        MiniMenu.x = local118;
        MiniMenu.open = true;
        MiniMenu.y = local146;
        MiniMenu.width = local11;
    }
}
