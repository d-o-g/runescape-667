import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static75 {

    @OriginalMember(owner = "client!ch", name = "j", descriptor = "Lclient!pg;")
    public static DoublyLinkedNode_Sub2_Sub16 aClass2_Sub2_Sub16_9;

    @OriginalMember(owner = "client!ch", name = "m", descriptor = "[Lclient!tn;")
    public static Class357[] aClass357Array2;

    @OriginalMember(owner = "client!ch", name = "k", descriptor = "Z")
    public static boolean aBoolean521 = true;

    @OriginalMember(owner = "client!ch", name = "b", descriptor = "(III)I")
    public static int method6238(@OriginalArg(2) int arg0) {
        if (arg0 == -1) {
            return 12345678;
        }
        @Pc(17) int local17 = (arg0 & 0x7F) * 96 >> 7;
        if (local17 < 2) {
            local17 = 2;
        } else if (local17 > 126) {
            local17 = 126;
        }
        return local17 + (arg0 & 0xFF80);
    }

    @OriginalMember(owner = "client!ch", name = "b", descriptor = "(B)V")
    public static void method6239() {
        ClientOptions.instance.update(1, ClientOptions.instance.aClass57_Sub19_1);
        ClientOptions.instance.update(1, ClientOptions.instance.animatingBackground);
        ClientOptions.instance.update(1, ClientOptions.instance.aClass57_Sub4_1);
        ClientOptions.instance.update(1, ClientOptions.instance.aClass57_Sub4_2);
        ClientOptions.instance.update(1, ClientOptions.instance.groundDecor);
        ClientOptions.instance.update(1, ClientOptions.instance.aClass57_Sub23_1);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub27_1);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub8_1);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub7_1);
        ClientOptions.instance.update(0, ClientOptions.instance.hardShadows);
        ClientOptions.instance.update(0, ClientOptions.instance.textures);
        ClientOptions.instance.update(0, ClientOptions.instance.lightDetail);
        ClientOptions.instance.update(0, ClientOptions.instance.waterDetail);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub16_1);
        ClientOptions.instance.update(0, ClientOptions.instance.antialiasingMode);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub13_1);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub28_1);
        ClientOptions.instance.update(0, ClientOptions.instance.aClass57_Sub5_1);
        ClientOptions.instance.update(0, ClientOptions.instance.bloom);
        ClientOptions.instance.update(0, ClientOptions.instance.skydetail);
        Static376.method5313();
        ClientOptions.instance.update(2, ClientOptions.instance.aClass57_Sub18_1);
        ClientOptions.instance.update(2, ClientOptions.instance.aClass57_Sub15_1);
        Static296.updateFeatureMask();
        Static218.method3187();
        Static284.aBoolean355 = true;
    }

    @OriginalMember(owner = "client!ch", name = "a", descriptor = "(BLclient!ge;)Lclient!kk;")
    public static Class154_Sub2 method6240(@OriginalArg(1) Packet arg0) {
        return new Class154_Sub2(arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g2s(), arg0.g3(), arg0.g3(), arg0.g1());
    }
}
