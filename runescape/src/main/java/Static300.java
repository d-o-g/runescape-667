import org.openrs2.deob.annotation.OriginalMember;

public final class Static300 {

    @OriginalMember(owner = "client!jj", name = "a", descriptor = "[I")
    public static final int[] anIntArray368 = new int[3];

    @OriginalMember(owner = "client!jj", name = "a", descriptor = "(Z)V")
    public static void method4389() {
        LoginManager.password = "";
        LoginManager.username = "";
    }

    @OriginalMember(owner = "client!jj", name = "a", descriptor = "(I)V")
    public static void method4393() {
        WorldMap.reset(false);
        if (Static114.toolkitType >= 0 && Static114.toolkitType != 0) {
            Static32.setToolkit(Static114.toolkitType, false);
            Static114.toolkitType = -1;
        }
    }
}
