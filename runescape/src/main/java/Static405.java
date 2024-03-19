import com.jagex.graphics.TextureSource;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static405 {

    @OriginalMember(owner = "client!mn", name = "b", descriptor = "Lclient!sb;")
    public static js5 aJs5_84;

    @OriginalMember(owner = "client!mn", name = "m", descriptor = "I")
    public static int anInt6255;

    @OriginalMember(owner = "client!mn", name = "k", descriptor = "Lclient!gw;")
    public static final Class153 aClass153_1 = new Class153();

    @OriginalMember(owner = "client!mn", name = "q", descriptor = "Lclient!gw;")
    public static final Class153 aClass153_2 = new Class153();

    @OriginalMember(owner = "client!mn", name = "f", descriptor = "[Lclient!gw;")
    public static final Class153[] aClass153Array1 = new Class153[]{aClass153_2, aClass153_1};

    @OriginalMember(owner = "client!mn", name = "p", descriptor = "Lclient!v;")
    public static final Node_Sub54 aClass2_Sub54_1 = new Node_Sub54(0, 0);

    @OriginalMember(owner = "client!mn", name = "i", descriptor = "Lclient!ss;")
    public static final Class345 aClass345_73 = new Class345(55, 7);

    @OriginalMember(owner = "client!mn", name = "a", descriptor = "(Lclient!d;Lclient!sb;Z)V")
    public static void method5592(@OriginalArg(0) TextureSource arg0, @OriginalArg(1) js5 arg1) {
        Static708.anTextureSource_12 = arg0;
        Static386.aJs5_80 = arg1;
    }
}
