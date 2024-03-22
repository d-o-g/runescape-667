import org.openrs2.deob.annotation.OriginalMember;

public final class Static376 {

    @OriginalMember(owner = "client!lr", name = "f", descriptor = "I")
    public static int anInt5919;

    @OriginalMember(owner = "client!lr", name = "a", descriptor = "F")
    public static float aFloat113;

    @OriginalMember(owner = "client!lr", name = "g", descriptor = "[I")
    public static int[] anIntArray458;

    @OriginalMember(owner = "client!lr", name = "d", descriptor = "[F")
    public static final float[] aFloatArray42 = new float[4];

    @OriginalMember(owner = "client!lr", name = "a", descriptor = "(B)V")
    public static void method5313() {
        if (ClientOptions.cpucount <= 1) {
            ClientOptions.instance.update(2, ClientOptions.instance.cpuUsage);
        } else {
            ClientOptions.instance.update(4, ClientOptions.instance.cpuUsage);
        }
    }
}
