import com.jagex.ChangeLocationRequest;
import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static227 {

    @OriginalMember(owner = "client!hb", name = "k", descriptor = "Lclient!sia;")
    public static Deque<ChangeLocationRequest> customisations = new Deque<>();

    @OriginalMember(owner = "client!hb", name = "a", descriptor = "()V")
    public static void method3354() {
        for (@Pc(1) int local1 = 0; local1 < Static226.aClass46Array7.length; local1++) {
            Static226.aClass46Array7[local1].method1101();
        }
        Static226.aClass46Array7 = null;
    }
}
