import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static186 {

    @OriginalMember(owner = "client!fo", name = "m", descriptor = "Ljava/lang/Object;")
    public static Object anObject7;

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(IIIBIIZ)V")
    public static void method2818(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) boolean arg5) {
        if ((arg5 ? ClientOptions.instance.speechVolume.getValue() : ClientOptions.instance.soundVolume.getValue()) != 0 && arg1 != 0 && SoundManager.count < 50 && arg0 != -1) {
            SoundManager.sounds[SoundManager.count++] = new Sound((byte) (arg5 ? 3 : 2), arg0, arg1, arg3, arg4, 0, arg2, null);
        }
    }

    @OriginalMember(owner = "client!fo", name = "a", descriptor = "(III)V")
    public static void method2821(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        Static281.anInt4566 = arg0;
        Static252.anInt4078 = arg1;
        if (Static448.anInt6796 == 0) {
            Static571.anInt8534 = Static321.anInt5113 * 2 + Static252.anInt4078;
            Static576.anInt8585 = Static281.anInt4566 + Static702.anInt10569 * 2;
        } else if (Static448.anInt6796 == 1) {
            Static211.anInt5574 = Static116.anInt2268 + Static252.anInt4078 / Static437.horizontalAspectRatio + 2;
            Static617.anInt9434 = Static281.anInt4566 / Static714.verticalAspectRatio + Static464.anInt7013 + 2;
            Static576.anInt8585 = Static617.anInt9434 * Static714.verticalAspectRatio;
            Static571.anInt8534 = Static211.anInt5574 * Static437.horizontalAspectRatio;
            Static321.anInt5113 = Static571.anInt8534 - Static252.anInt4078 >> 1;
            Static702.anInt10569 = Static576.anInt8585 - Static281.anInt4566 >> 1;
        } else if (Static448.anInt6796 == 2) {
            Static571.anInt8534 = Static252.anInt4078;
            Static576.anInt8585 = Static281.anInt4566;
        }
    }
}
