import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static419 {

    @OriginalMember(owner = "client!ne", name = "v", descriptor = "[I")
    public static int[] anIntArray500;

    @OriginalMember(owner = "client!ne", name = "w", descriptor = "I")
    public static int anInt6434 = 0;

    @OriginalMember(owner = "client!ne", name = "b", descriptor = "(I)V")
    public static void method5757() {
        if (Loading.renderer != null) {
            Loading.renderer.complete();
        }
        if (Loading.rendererThread == null) {
            return;
        }
        while (true) {
            try {
                Loading.rendererThread.join();
                return;
            } catch (@Pc(26) InterruptedException local26) {
            }
        }
    }
}
