import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static350 {

    @OriginalMember(owner = "client!la", name = "a", descriptor = "[J")
    public static long[] aLongArray9;

    @OriginalMember(owner = "client!la", name = "a", descriptor = "(II)I")
    public static int getWaterDepth(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        return Static272.waterDepth == null ? 0 : Static272.waterDepth[arg0][arg1] & 0xFFFF;
    }

}
