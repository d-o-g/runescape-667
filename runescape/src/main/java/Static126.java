import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static126 {

    @OriginalMember(owner = "client!du", name = "f", descriptor = "Lclient!hc;")
    public static final Class155 aClass155_12 = new Class155(52);

    @OriginalMember(owner = "client!du", name = "d", descriptor = "Z")
    public static boolean aBoolean200 = false;

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(BI)V")
    public static void method2226(@OriginalArg(1) int arg0) {
        if (Static96.anInt10171 == 0) {
            Static581.aClass2_Sub6_Sub1_3.method916(arg0);
        } else {
            Static24.anInt595 = arg0;
        }
    }

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(Lclient!ha;IIIIIBI)V")
    public static void method2227(@OriginalArg(0) Toolkit toolkit, @OriginalArg(2) int arg1, @OriginalArg(3) int horizontalAspectRatio, @OriginalArg(4) int verticalAspectRatio, @OriginalArg(7) int arg4) {
        Static74.aToolkit_4 = toolkit;
        Static420.aMatrix_7 = Static74.aToolkit_4.createMatrix();
        Static203.aMatrix_4 = Static74.aToolkit_4.createMatrix();
        Static712.aMatrix_11 = Static74.aToolkit_4.createMatrix();
        Static437.horizontalAspectRatio = horizontalAspectRatio;
        Static116.anInt2268 = 2;
        Static448.anInt6796 = 1;
        Static482.anInt7265 = 0;
        Static632.anInt9503 = 0;
        Static464.anInt7013 = 2;
        Static714.verticalAspectRatio = verticalAspectRatio;
        Static450.anInterface9_1 = null;
        Static388.method5454(arg4, arg1);
    }

    @OriginalMember(owner = "client!du", name = "a", descriptor = "(I)V")
    public static void method2228() {
        Static179.playerCount = 0;
        Static480.npcCount = 0;
        Static577.anInt8587 = 0;
        Static606.anInt8954 = 0;
    }

}
