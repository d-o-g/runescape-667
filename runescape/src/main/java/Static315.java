import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static315 {

    @OriginalMember(owner = "client!k", name = "a", descriptor = "(II)V")
    public static void method4574(@OriginalArg(0) int arg0) {
        if (Static430.anIntArray519 == null || Static430.anIntArray519.length < arg0) {
            Static430.anIntArray519 = new int[arg0];
        }
    }

}
