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
    public static void method3068() {
        Static441.aSpriteArray10 = null;
        Static558.aSpriteArray7 = null;
        Static174.aSpriteArray4 = null;
        Fonts.p11 = null;
        Fonts.p12 = null;
        Static12.aSprite_27 = null;
        Static119.aSpriteArray3 = null;
        Static291.aSpriteArray8 = null;
        Static471.aSpriteArray11 = null;
        Static34.aSpriteArray2 = null;
        Static517.aSprite_32 = null;
        Static355.aSpriteArray9 = null;
        Fonts.b12 = null;
        Static679.aSpriteArray14 = null;
        Static691.aSpriteArray15 = null;
        Static28.aSpriteArray1 = null;
        Static493.aSpriteArray12 = null;
    }

    @OriginalMember(owner = "client!gf", name = "a", descriptor = "(I)Z")
    public static boolean method3070() {
        return Static96.anInt10171 != 0;
    }

}
