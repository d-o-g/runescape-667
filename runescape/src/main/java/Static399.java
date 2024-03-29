import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static399 {

    @OriginalMember(owner = "client!mja", name = "b", descriptor = "[I")
    public static final int[] anIntArray483 = new int[8];

    @OriginalMember(owner = "client!mja", name = "a", descriptor = "(IIB)I")
    public static int method5571(@OriginalArg(0) int toolkit, @OriginalArg(1) int arg1) {
        @Pc(27) byte local27;
        if (arg1 > 20000) {
            local27 = 4;
            Static395.method9162();
        } else if (arg1 > 10000) {
            Static133.method2316();
            local27 = 3;
        } else if (arg1 <= 5000) {
            local27 = 1;
            Static468.method7643();
        } else {
            local27 = 2;
            Static75.method6239();
        }
        if (toolkit != ClientOptions.instance.toolkit.getValue()) {
            ClientOptions.instance.update(toolkit, ClientOptions.instance.toolkitDefault);
            Static32.setToolkit(toolkit, false);
        }
        ClientOptions.save();
        return local27;
    }

    @OriginalMember(owner = "client!mja", name = "a", descriptor = "(III)Z")
    public static boolean method5572(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        return Static407.method5627(arg0, arg1) || Static475.method6443(arg0, arg1);
    }
}
