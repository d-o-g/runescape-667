import com.jagex.Client;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static229 {

    @OriginalMember(owner = "client!hc", name = "a", descriptor = "(I)V")
    public static void method3368() {
        if (Static473.aLoadState_22 != null) {
            Static449.aLoadingScreenRenderer_1 = new LoadingScreenRenderer();
            Static449.aLoadingScreenRenderer_1.updateState(Static473.aLoadState_22.startPercentage, Static473.aLoadState_22.stalledText.localise(Client.language), Static473.aLoadState_22, Static72.aLong52);
            Static242.aThread1 = new Thread(Static449.aLoadingScreenRenderer_1, "");
            Static242.aThread1.start();
        }
    }
}
