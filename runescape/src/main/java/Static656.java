import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static656 {

    @OriginalMember(owner = "client!up", name = "u", descriptor = "F")
    public static float aFloat127 = 0.25F;

    @OriginalMember(owner = "client!up", name = "a", descriptor = "(II)Z")
    public static boolean method6691(@OriginalArg(0) int arg0) {
        return arg0 == 9 || arg0 == 10;
    }

    @OriginalMember(owner = "client!up", name = "c", descriptor = "(Z)V")
    public static void method6692() {
        InterfaceList.interfaces = new Component[Component.interfacesJs5.groupSize()][];
        InterfaceManager.cache = new Component[Component.interfacesJs5.groupSize()][];
        InterfaceList.loaded = new boolean[Component.interfacesJs5.groupSize()];
    }
}
