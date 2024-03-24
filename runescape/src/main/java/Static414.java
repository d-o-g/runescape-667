import com.jagex.IndexedImage;
import com.jagex.core.constants.ModeGame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static414 {

    @OriginalMember(owner = "client!nba", name = "i", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_2;

    @OriginalMember(owner = "client!nba", name = "b", descriptor = "[F")
    public static final float[] aFloatArray43 = new float[2];

    @OriginalMember(owner = "client!nba", name = "a", descriptor = "(III)V")
    public static void method5697(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        if (client.modeGame == ModeGame.STELLAR_DAWN) {
            if (!Static147.method2419(0, arg0, 1, false, arg1, 0, -2, 1)) {
                Static147.method2419(0, arg0, 1, false, arg1, 0, -3, 1);
            }
        } else if (!Static147.method2419(0, arg0, 1, false, arg1, 0, -3, 1)) {
            Static147.method2419(0, arg0, 1, false, arg1, 0, -2, 1);
        }
    }
}
