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

}
