import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static179 {

    @OriginalMember(owner = "client!fk", name = "k", descriptor = "I")
    public static int playerCount = 0;

    @OriginalMember(owner = "client!fk", name = "a", descriptor = "(IIIIZIII)V")
    public static void method2770(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(5) int arg3, @OriginalArg(6) int arg4, @OriginalArg(7) int arg5) {
        if (ClientOptions.instance.soundVolume.getValue() != 0 && arg0 != 0 && SoundManager.count < 50 && arg5 != -1) {
            SoundManager.sounds[SoundManager.count++] = new Sound((byte) 2, arg5, arg0, arg1, arg4, arg2, arg3, null);
        }
    }
}
