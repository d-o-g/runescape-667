import org.openrs2.deob.annotation.OriginalMember;

public final class Static564 {

    @OriginalMember(owner = "client!rp", name = "c", descriptor = "I")
    public static int anInt8464;

    @OriginalMember(owner = "client!rp", name = "b", descriptor = "[I")
    public static final int[] anIntArray653 = new int[1];

    @OriginalMember(owner = "client!rp", name = "b", descriptor = "(B)V")
    public static void method7465() {
        if (Static656.method6691(MainLogicManager.step)) {
            if (ConnectionManager.LOBBY.connection == null) {
                MainLogicManager.setStep(5);
            } else {
                MainLogicManager.setStep(7);
            }
        } else if (MainLogicManager.step == 5 || MainLogicManager.step == 6) {
            MainLogicManager.setStep(3);
        } else if (MainLogicManager.step == 13) {
            MainLogicManager.setStep(3);
        }
    }
}
