import com.jagex.game.runetek6.config.seqtype.SeqType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static315 {

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(II)V")
    public static void method4574(@OriginalArg(0) int arg0) {
        if (Static430.anIntArray519 == null || Static430.anIntArray519.length < arg0) {
            Static430.anIntArray519 = new int[arg0];
        }
    }

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(IILclient!cka;)V")
    public static void method4577(@OriginalArg(0) int arg0, @OriginalArg(2) SeqType arg1) {
        if (SoundManager.count >= 50 || (arg1 == null || arg1.soundInfo == null || arg1.soundInfo.length <= arg0 || arg1.soundInfo[arg0] == null)) {
            return;
        }
        @Pc(42) int local42 = arg1.soundInfo[arg0][0];
        @Pc(46) int local46 = local42 >> 8;
        @Pc(63) int local63;
        if (arg1.soundInfo[arg0].length > 1) {
            local63 = (int) (Math.random() * (double) arg1.soundInfo[arg0].length);
            if (local63 > 0) {
                local46 = arg1.soundInfo[arg0][local63];
            }
        }
        @Pc(81) int local81 = local42 >> 5 & 0x7;
        local63 = 256;
        if (arg1.anIntArray154 != null && arg1.anIntArray155 != null) {
            local63 = Static159.method2572(arg1.anIntArray154[arg0], arg1.anIntArray155[arg0]);
        }
        if (arg1.vorbisSound) {
            Static186.method2818(local46, local81, local63, 0, 255, false);
        } else {
            Static161.method2586(local63, 0, local46, local81, 255);
        }
    }

}
