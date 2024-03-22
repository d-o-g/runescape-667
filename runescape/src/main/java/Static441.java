import com.jagex.core.util.TimeUtils;
import com.jagex.graphics.Sprite;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static441 {

    @OriginalMember(owner = "client!nu", name = "b", descriptor = "I")
    public static int anInt6689;

    @OriginalMember(owner = "client!nu", name = "d", descriptor = "[Lclient!st;")
    public static Sprite[] aSpriteArray10;

    @OriginalMember(owner = "client!nu", name = "g", descriptor = "I")
    public static int anInt6691;

    @OriginalMember(owner = "client!nu", name = "c", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___168 = new ServerProt(20, -1);

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(ILclient!cg;)V")
    public static void method5967(@OriginalArg(1) Class8_Sub2_Sub1_Sub2 arg0) {
        @Pc(9) int local9 = arg0.anInt10759 - TimeUtils.clock;
        @Pc(20) int local20 = arg0.anInt10750 * 512 + arg0.method9302((byte) 99) * 256;
        @Pc(32) int local32 = arg0.anInt10753 * 512 + arg0.method9302((byte) 58) * 256;
        arg0.anInt10694 += (local32 - arg0.anInt10694) / local9;
        arg0.anInt10690 += (local20 - arg0.anInt10690) / local9;
        arg0.anInt10763 = 0;
        if (arg0.anInt10754 == 0) {
            arg0.method9305(8192);
        }
        if (arg0.anInt10754 == 1) {
            arg0.method9305(12288);
        }
        if (arg0.anInt10754 == 2) {
            arg0.method9305(0);
        }
        if (arg0.anInt10754 == 3) {
            arg0.method9305(4096);
        }
    }

    @OriginalMember(owner = "client!nu", name = "a", descriptor = "(III)Z")
    public static boolean method5968(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        if (arg1 >= 0 && arg0 >= 0 && arg1 < Static280.tileFlags[1].length && arg0 < Static280.tileFlags[1][arg1].length) {
            return (Static280.tileFlags[1][arg1][arg0] & 0x2) != 0;
        } else {
            return false;
        }
    }
}
