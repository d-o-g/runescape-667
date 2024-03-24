import com.jagex.graphics.Matrix;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static420 {

    @OriginalMember(owner = "client!nea", name = "f", descriptor = "Z")
    public static boolean aBoolean479;

    @OriginalMember(owner = "client!nea", name = "b", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_7;

    @OriginalMember(owner = "client!nea", name = "g", descriptor = "[[[Lclient!pha;")
    public static Class291[][][] aClass291ArrayArrayArray2;

    @OriginalMember(owner = "client!nea", name = "c", descriptor = "Lclient!pc;")
    public static final Class287 aClass287_13 = new Class287(3, 4);

    @OriginalMember(owner = "client!nea", name = "a", descriptor = "I")
    public static int anInt6436 = 1;

    @OriginalMember(owner = "client!nea", name = "a", descriptor = "(I[SI[Ljava/lang/String;I)V")
    public static void method5759(@OriginalArg(0) int arg0, @OriginalArg(1) short[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) String[] arg3) {
        if (arg2 >= arg0) {
            return;
        }
        @Pc(12) int local12 = (arg0 + arg2) / 2;
        @Pc(14) int local14 = arg2;
        @Pc(18) String local18 = arg3[local12];
        arg3[local12] = arg3[arg0];
        arg3[arg0] = local18;
        @Pc(32) short local32 = arg1[local12];
        arg1[local12] = arg1[arg0];
        arg1[arg0] = local32;
        for (@Pc(44) int local44 = arg2; local44 < arg0; local44++) {
            if (local18 == null || arg3[local44] != null && arg3[local44].compareTo(local18) < (local44 & 0x1)) {
                @Pc(68) String local68 = arg3[local44];
                arg3[local44] = arg3[local14];
                arg3[local14] = local68;
                @Pc(82) short local82 = arg1[local44];
                arg1[local44] = arg1[local14];
                arg1[local14++] = local82;
            }
        }
        arg3[arg0] = arg3[local14];
        arg3[local14] = local18;
        arg1[arg0] = arg1[local14];
        arg1[local14] = local32;
        method5759(local14 - 1, arg1, arg2, arg3);
        method5759(arg0, arg1, local14 + 1, arg3);
    }
}
