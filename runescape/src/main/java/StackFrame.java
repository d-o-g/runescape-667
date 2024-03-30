import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!gf")
public final class StackFrame {

    @OriginalMember(owner = "client!gf", name = "m", descriptor = "[J")
    public long[] longVars;

    @OriginalMember(owner = "client!gf", name = "f", descriptor = "[Ljava/lang/String;")
    public String[] stringVars;

    @OriginalMember(owner = "client!gf", name = "c", descriptor = "[I")
    public int[] intVars;

    @OriginalMember(owner = "client!gf", name = "k", descriptor = "Lclient!fj;")
    public ClientScript script;

    @OriginalMember(owner = "client!gf", name = "d", descriptor = "I")
    public int pc = -1;
}
