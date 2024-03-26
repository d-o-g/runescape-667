import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static58 {

    @OriginalMember(owner = "client!bu", name = "c", descriptor = "(III)Z")
    public static boolean method1257(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x22) != 0;
    }

    @OriginalMember(owner = "client!bu", name = "a", descriptor = "(ILclient!wj;)V")
    public static void method1259(@OriginalArg(1) NPCEntity arg0) {
        for (@Pc(17) PositionedSound local17 = (PositionedSound) SoundManager.npcSounds.first(); local17 != null; local17 = (PositionedSound) SoundManager.npcSounds.next()) {
            if (local17.npc == arg0) {
                if (local17.stream != null) {
                    SoundManager.activeStreams.remove(local17.stream);
                    local17.stream = null;
                }
                local17.unlink();
                return;
            }
        }
    }

    @OriginalMember(owner = "client!bu", name = "d", descriptor = "(B)I")
    public static int method1260() {
        return Static448.anInt6796 == 1 ? Static576.anInt8585 : Static281.anInt4566;
    }
}
