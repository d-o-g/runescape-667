import org.openrs2.deob.annotation.OriginalMember;

public final class Static254 {

    @OriginalMember(owner = "client!hr", name = "i", descriptor = "I")
    public static int anInt4115;

    @OriginalMember(owner = "client!hr", name = "b", descriptor = "(I)V")
    public static void method3606() {
        if (!Camera.angleChangingX) {
            Camera.angleUpdated = true;
            Camera.angleChangingX = true;
            Camera.angleAxisX += (24.0F - Camera.angleAxisX) / 2.0F;
        }
    }
}
