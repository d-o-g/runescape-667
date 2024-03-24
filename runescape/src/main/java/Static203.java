import com.jagex.graphics.Matrix;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static203 {

    @OriginalMember(owner = "client!fb", name = "i", descriptor = "[F")
    public static final float[] aFloatArray79 = new float[16384];

    @OriginalMember(owner = "client!fb", name = "c", descriptor = "[F")
    public static final float[] aFloatArray80 = new float[16384];

    static {
        @Pc(70) double local70 = 3.834951969714103E-4D;
        for (@Pc(72) int local72 = 0; local72 < 16384; local72++) {
            aFloatArray79[local72] = (float) Math.sin(local70 * (double) local72);
            aFloatArray80[local72] = (float) Math.cos(local70 * (double) local72);
        }
    }

    @OriginalMember(owner = "client!gf", name = "l", descriptor = "F")
    public static float aFloat69;

    @OriginalMember(owner = "client!gf", name = "j", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_4;

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(B)V")
    public static void resetStaticSprites() {
        Sprites.headiconsPk = null;
        Sprites.hintMapedge = null;
        Sprites.hintMapmarkers = null;
        Fonts.p11 = null;
        Fonts.p12 = null;
        Sprites.compass = null;
        Sprites.hitbarDefault = null;
        Sprites.scrollbar = null;
        Sprites.mapdots = null;
        Sprites.timerbarDefault = null;
        Sprites.otherlevel = null;
        Sprites.cross = null;
        Fonts.b12 = null;
        Sprites.nameIcons = null;
        Sprites.mapflag = null;
        Sprites.hintHeadicons = null;
        Sprites.headiconsPrayer = null;
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(I)Z")
    public static boolean method3070() {
        return Static96.anInt10171 != 0;
    }

}
