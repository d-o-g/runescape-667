import com.jagex.core.datastruct.key.Deque;
import com.jagex.graphics.Matrix;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static59 {

    @OriginalMember(owner = "client!bv", name = "m", descriptor = "Lclient!tt;")
    public static Matrix aMatrix_5;

    @OriginalMember(owner = "client!bv", name = "o", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___33 = new Deque();

    @OriginalMember(owner = "client!bv", name = "n", descriptor = "I")
    public static int anInt5936 = 999999;

    @OriginalMember(owner = "client!bv", name = "l", descriptor = "Ljava/lang/String;")
    public static String aString63 = "";

    @OriginalMember(owner = "client!bv", name = "q", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_25 = new Class155(43);

    @OriginalMember(owner = "client!bv", name = "a", descriptor = "(Lclient!rka;I)I")
    public static int method5329(@OriginalArg(0) PacketBuffer arg0) {
        @Pc(10) int local10 = arg0.readBits(2);
        @Pc(22) int local22;
        if (local10 == 0) {
            local22 = 0;
        } else if (local10 == 1) {
            local22 = arg0.readBits(5);
        } else if (local10 == 2) {
            local22 = arg0.readBits(8);
        } else {
            local22 = arg0.readBits(11);
        }
        return local22;
    }
}
