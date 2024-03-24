import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static319 {

    @OriginalMember(owner = "client!kba", name = "I", descriptor = "[[B")
    public static byte[][] aByteArrayArray16;

    @OriginalMember(owner = "client!kba", name = "R", descriptor = "I")
    public static int anInt5080;

    @OriginalMember(owner = "client!kba", name = "P", descriptor = "Ljava/lang/String;")
    public static String aString51 = "";

    @OriginalMember(owner = "client!kba", name = "N", descriptor = "[I")
    public static final int[] anIntArray384 = new int[6];

    @OriginalMember(owner = "client!kba", name = "J", descriptor = "[F")
    public static final float[] aFloatArray26 = new float[]{0.0F, -1.0F, 0.0F, 0.0F};

    @OriginalMember(owner = "client!kba", name = "K", descriptor = "I")
    public static int permVarcCount = 0;

    @OriginalMember(owner = "client!kba", name = "H", descriptor = "[I")
    public static final int[] anIntArray385 = new int[13];

    @OriginalMember(owner = "client!kba", name = "a", descriptor = "(IBI)Z")
    public static boolean method4594(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static483.method6488(arg1, arg0) & Static340.method5012(arg1, arg0);
    }

    @OriginalMember(owner = "client!kba", name = "a", descriptor = "(IZIBIII)V")
    public static void method4595(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) int arg5) {
        Static363.anInt6934 = arg3;
        Static694.anInt10411 = arg2;
        Static674.anInt10088 = arg5;
        Camera.anInt10667 = arg4;
        Camera.anInt2333 = arg0;
        if (arg1 && Static674.anInt10088 >= 100) {
            Camera.positionX = Camera.anInt2333 * 512 + 256;
            Camera.positionZ = Camera.anInt10667 * 512 + 256;
            Camera.positionY = Static102.method2025(Camera.renderingLevel, -29754, Camera.positionZ, Camera.positionX) - Static363.anInt6934;
        }
        Camera.mode = 2;
        Static693.anInt10383 = -1;
        Static692.anInt10376 = -1;
    }
}
