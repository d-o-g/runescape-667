import org.openrs2.deob.annotation.OriginalMember;

public final class Static599 {

    @OriginalMember(owner = "client!su", name = "g", descriptor = "I")
    public static int anInt8837;

    @OriginalMember(owner = "client!su", name = "h", descriptor = "Ljava/lang/Object;")
    public static Object anObject14;

    @OriginalMember(owner = "client!su", name = "b", descriptor = "(B)V")
    public static void method7835() {
        if (!Camera.angleChangingY) {
            Camera.angleAxisY += (12.0F - Camera.angleAxisY) / 2.0F;
            Camera.angleChangingY = true;
            Camera.angleUpdated = true;
        }
    }
}
