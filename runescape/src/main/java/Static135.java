import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static135 {

    @OriginalMember(owner = "client!ee", name = "P", descriptor = "[F")
    public static final float[] aFloatArray56 = new float[16];

    @OriginalMember(owner = "client!ee", name = "a", descriptor = "(IZI)Z")
    public static boolean method7236(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        @Pc(28) boolean local28 = (arg1 & 0x37) == 0 ? Static519.method6832(-125, arg0, arg1) : Static576.method7609(arg1, arg0);
        return local28 | Static526.method7073(arg1, arg0) | (arg0 & 0x10000) != 0;
    }

    @OriginalMember(owner = "client!ee", name = "g", descriptor = "(I)V")
    public static void method7237() {
        Static203.aMatrix_4 = null;
        Static450.anInterface9_1 = null;
        Static49.anInt1045 = -1;
        Static173.anIntArray252 = null;
        Static420.aMatrix_7 = null;
        Static138.anInt2512 = -1;
        Static448.anInt6796 = -1;
        Static74.aToolkit_4 = null;
        Static693.anInt10382 = -1;
        Static651.anInterface9Array1 = null;
        Static712.aMatrix_11 = null;
        Static10.aClass213_1.method5010();
    }

}
