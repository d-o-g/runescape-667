import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static122 {

    @OriginalMember(owner = "client!dq", name = "b", descriptor = "(B)Lclient!fu;")
    public static Node_Sub20 method2207() {
        if (Static30.A_DEQUE___31 == null || Static444.aClass191_1 == null) {
            return null;
        }
        Static444.aClass191_1.setDeque(Static30.A_DEQUE___31);
        @Pc(23) Node_Sub20 local23 = (Node_Sub20) Static444.aClass191_1.first();
        if (local23 == null) {
            return null;
        } else {
            @Pc(42) Class105 local42 = Static30.aClass246_3.method5584(local23.anInt3131);
            return local42 != null && local42.aBoolean217 && local42.method2425(Static30.anVarDomain_3) ? local23 : Static364.method5248();
        }
    }

    @OriginalMember(owner = "client!dq", name = "a", descriptor = "(II)V")
    public static void method2208(@OriginalArg(0) int arg0) {
        if (!InterfaceList.load(arg0)) {
            return;
        }
        @Pc(13) Component[] local13 = InterfaceList.interfaces[arg0];
        for (@Pc(15) int local15 = 0; local15 < local13.length; local15++) {
            @Pc(20) Component local20 = local13[local15];
            if (local20 != null && local20.animator != null) {
                local20.animator.resetImmediately();
            }
        }
    }
}
