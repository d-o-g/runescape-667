import com.jagex.core.datastruct.LinkedList;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static129 {

    @OriginalMember(owner = "client!eaa", name = "B", descriptor = "Lclient!ek;")
    public static VerticalAlignment aVerticalAlignment_1;

    @OriginalMember(owner = "client!eaa", name = "w", descriptor = "Lclient!fla;")
    public static final LinkedList A_ENTITY_LIST___3 = new LinkedList();

    @OriginalMember(owner = "client!eaa", name = "b", descriptor = "Z")
    public static boolean orthoCameraLock = true;

    @OriginalMember(owner = "client!eaa", name = "a", descriptor = "(B)V")
    public static void method2279() {
        debugconsole.open = false;
        InterfaceManager.redrawAll();
    }
}
