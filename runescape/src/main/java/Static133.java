import com.jagex.core.datastruct.key.Deque;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static133 {

    @OriginalMember(owner = "client!ed", name = "e", descriptor = "F")
    public static float aFloat63;

    @OriginalMember(owner = "client!ed", name = "h", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___55 = new ServerProt(90, 17);

    @OriginalMember(owner = "client!ed", name = "g", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___13 = new Deque();

    @OriginalMember(owner = "client!ed", name = "d", descriptor = "Lclient!ss;")
    public static final ClientProt A_CLIENT_PROT___26 = new ClientProt(89, 4);

    @OriginalMember(owner = "client!ed", name = "b", descriptor = "I")
    public static int anInt2458 = 0;

    @OriginalMember(owner = "client!ed", name = "a", descriptor = "(I)V")
    public static void method2316() {
        ClientOptions.instance.update(1, ClientOptions.instance.animateBackgroundDefault);
        ClientOptions.instance.update(1, ClientOptions.instance.animateBackground);
        ClientOptions.instance.update(2, ClientOptions.instance.removeRoofs);
        ClientOptions.instance.update(2, ClientOptions.instance.removeRoofsOverride);
        ClientOptions.instance.update(1, ClientOptions.instance.groundDecor);
        ClientOptions.instance.update(1, ClientOptions.instance.groundBlending);
        ClientOptions.instance.update(1, ClientOptions.instance.idleAnimations);
        ClientOptions.instance.update(1, ClientOptions.instance.flickeringEffects);
        ClientOptions.instance.update(1, ClientOptions.instance.spotShadows);
        ClientOptions.instance.update(1, ClientOptions.instance.textures);
        ClientOptions.instance.update(1, ClientOptions.instance.hardShadows);
        ClientOptions.instance.update(1, ClientOptions.instance.lightDetail);
        ClientOptions.instance.update(0, ClientOptions.instance.waterDetail);
        ClientOptions.instance.update(1, ClientOptions.instance.fog);
        ClientOptions.instance.update(0, ClientOptions.instance.antialiasingMode);
        ClientOptions.instance.update(0, ClientOptions.instance.antialiasingQuality);
        ClientOptions.instance.update(1, ClientOptions.instance.particles);
        ClientOptions.instance.update(0, ClientOptions.instance.buildArea);
        ClientOptions.instance.update(0, ClientOptions.instance.bloom);
        ClientOptions.instance.update(1, ClientOptions.instance.skydetail);
        Static376.method5313();
        ClientOptions.instance.update(1, ClientOptions.instance.maxScreenSize);
        ClientOptions.instance.update(3, ClientOptions.instance.graphicsQuality);
        Static296.updateFeatureMask();
        Static218.method3187();
        Static284.aBoolean355 = true;
    }
}
