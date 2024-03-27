import com.jagex.graphics.Ground;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static429 {

    @OriginalMember(owner = "client!nj", name = "g", descriptor = "[Z")
    public static final boolean[] aBooleanArray21 = new boolean[200];

    @OriginalMember(owner = "client!nj", name = "a", descriptor = "(ILclient!s;)V")
    public static void method5805(@OriginalArg(0) int arg0, @OriginalArg(1) Ground arg1) {
        Static246.ground[arg0] = arg1;
    }
}
