import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static433 {

    @OriginalMember(owner = "client!nl", name = "a", descriptor = "[[[Z")
    public static boolean[][][] aBooleanArrayArrayArray5;

    @OriginalMember(owner = "client!nl", name = "a", descriptor = "(III)Z")
    public static boolean method5601(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return (arg1 & 0x100) != 0;
    }
}
