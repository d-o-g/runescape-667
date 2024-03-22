import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class ScriptRunner {
    @OriginalMember(owner = "client!ou", name = "a", descriptor = "(Lclient!pd;)V")
    public static void executeHookInner(@OriginalArg(0) HookRequest arg0) {
        Static472.method6422(arg0, 200000);
    }

    @OriginalMember(owner = "client!ou", name = "d", descriptor = "(I)V")
    public static void executeOnLoad(@OriginalArg(0) int arg0) {
        if (arg0 == -1 || !InterfaceList.load(arg0)) {
            return;
        }
        @Pc(14) Component[] local14 = InterfaceList.interfaces[arg0];
        for (@Pc(16) int local16 = 0; local16 < local14.length; local16++) {
            @Pc(21) Component local21 = local14[local16];
            if (local21.onLoad != null) {
                @Pc(28) HookRequest local28 = new HookRequest();
                local28.source = local21;
                local28.arguments = local21.onLoad;
                Static472.method6422(local28, 2000000);
            }
        }
    }
}
