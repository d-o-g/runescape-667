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
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub19_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.animatingBackground);
        ClientOptions.instance.method5104(2, ClientOptions.instance.aClass57_Sub4_1);
        ClientOptions.instance.method5104(2, ClientOptions.instance.aClass57_Sub4_2);
        ClientOptions.instance.method5104(1, ClientOptions.instance.groundDecor);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub23_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub27_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub8_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub7_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.textures);
        ClientOptions.instance.method5104(1, ClientOptions.instance.hardShadows);
        ClientOptions.instance.method5104(1, ClientOptions.instance.lightDetail);
        ClientOptions.instance.method5104(0, ClientOptions.instance.waterDetail);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub16_1);
        ClientOptions.instance.method5104(0, ClientOptions.instance.antialiasingMode);
        ClientOptions.instance.method5104(0, ClientOptions.instance.aClass57_Sub13_1);
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub28_1);
        ClientOptions.instance.method5104(0, ClientOptions.instance.aClass57_Sub5_1);
        ClientOptions.instance.method5104(0, ClientOptions.instance.bloom);
        ClientOptions.instance.method5104(1, ClientOptions.instance.skydetail);
        Static376.method5313();
        ClientOptions.instance.method5104(1, ClientOptions.instance.aClass57_Sub18_1);
        ClientOptions.instance.method5104(3, ClientOptions.instance.aClass57_Sub15_1);
        Static296.updateFeatureMask();
        Static218.method3187();
        Static284.aBoolean355 = true;
    }
}
