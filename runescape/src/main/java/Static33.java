import org.openrs2.deob.annotation.OriginalMember;

public final class Static33 {

    @OriginalMember(owner = "client!bc", name = "c", descriptor = "I")
    public static int anInt779 = 0;

    @OriginalMember(owner = "client!bc", name = "a", descriptor = "(B)V")
    public static void method881() {
        CutsceneManager.state = 4;
        Static322.anIntArrayArray265 = null;
        Static421.aBoolean480 = false;
        Static518.aClass2_Sub21_18 = null;
        Static298.method4385();
        ConnectionManager.GAME.send(ClientMessage.create(Static45.A_CLIENT_PROT___5, ConnectionManager.GAME.cipher));
    }

    @OriginalMember(owner = "client!bc", name = "a", descriptor = "(I)[Lclient!wk;")
    public static horizontalAlignment[] method882() {
        return new horizontalAlignment[]{Static555.A_HORIZONTAL_ALIGNMENT___14, Static710.A_HORIZONTAL_ALIGNMENT___13, Static169.A_HORIZONTAL_ALIGNMENT___1};
    }
}
