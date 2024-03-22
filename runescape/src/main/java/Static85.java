import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static85 {

    @OriginalMember(owner = "client!cm", name = "o", descriptor = "I")
    public static int anInt10675;

    @OriginalMember(owner = "client!cm", name = "p", descriptor = "Lclient!lga;")
    public static final ServerProt A_SERVER_PROT___257 = new ServerProt(76, 9);

    @OriginalMember(owner = "client!cm", name = "a", descriptor = "(IIIIILclient!ha;)V")
    public static void method9264(@OriginalArg(1) int arg0, @OriginalArg(3) int arg1, @OriginalArg(5) Toolkit arg2) {
        Static74.aToolkit_4 = arg2;
        Static420.aMatrix_7 = Static74.aToolkit_4.createMatrix();
        Static203.aMatrix_4 = Static74.aToolkit_4.createMatrix();
        Static712.aMatrix_11 = Static74.aToolkit_4.createMatrix();
        Static173.anIntArray252 = null;
        Static321.anInt5113 = 100;
        Static702.anInt10569 = 100;
        Static651.anInterface9Array1 = null;
        Static448.anInt6796 = 0;
        Static388.method5454(arg0, arg1);
        Static49.anInt1045 = -1;
        Static693.anInt10382 = -1;
        Static138.anInt2512 = -1;
    }
}
