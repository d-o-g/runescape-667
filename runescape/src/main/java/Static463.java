import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static463 {

    @OriginalMember(owner = "client!oka", name = "c", descriptor = "[[Z")
    public static final boolean[][] aBooleanArrayArray6 = new boolean[][]{new boolean[4], {false, true, true, false}, {true, false, true, false}, {true, false, true, false}, {false, false, true, false}, {false, false, true, false}, {true, false, true, false}, {true, false, false, true}, {true, false, false, true}, {true, true, false, false}, new boolean[4], {false, true, false, true}, new boolean[4]};

    @OriginalMember(owner = "client!oka", name = "a", descriptor = "Z")
    public static boolean aBoolean531 = false;

    @OriginalMember(owner = "client!oka", name = "b", descriptor = "(II)Z")
    public static boolean method6280(@OriginalArg(0) int arg0) {
        return arg0 == 0 || arg0 == 2;
    }
}
