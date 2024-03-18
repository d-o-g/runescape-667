import com.jagex.collect.Queue;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static350 {

    @OriginalMember(owner = "client!la", name = "a", descriptor = "[J")
    public static long[] aLongArray9;

    @OriginalMember(owner = "client!la", name = "v", descriptor = "Lclient!jga;")
    public static final Queue A_QUEUE___8 = new Queue();

    @OriginalMember(owner = "client!la", name = "u", descriptor = "[I")
    public static final int[] anIntArray433 = new int[1000];

    @OriginalMember(owner = "client!la", name = "a", descriptor = "(II)I")
    public static int method5124(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return Static272.aShortArrayArray5 == null ? 0 : Static272.aShortArrayArray5[arg0][arg1] & 0xFFFF;
    }

}
