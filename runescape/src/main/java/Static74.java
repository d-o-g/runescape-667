import com.jagex.IndexedImage;
import com.jagex.Class67;
import com.jagex.game.Class381;
import com.jagex.graphics.Toolkit;
import com.jagex.graphics.skybox.SkyBox;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static74 {

    @OriginalMember(owner = "client!cga", name = "d", descriptor = "Lclient!wp;")
    public static IndexedImage aIndexedImage_1;

    @OriginalMember(owner = "client!cga", name = "b", descriptor = "Lclient!ha;")
    public static Toolkit aToolkit_4;

    @OriginalMember(owner = "client!cga", name = "e", descriptor = "Lclient!pu;")
    public static Class67 aClass67_3;

    @OriginalMember(owner = "client!cga", name = "a", descriptor = "Lclient!gm;")
    public static SkyBox aSkyBox_1;

    @OriginalMember(owner = "client!cga", name = "a", descriptor = "(IIILclient!sb;)Lclient!ve;")
    public static Class381 method1535(@OriginalArg(2) int arg0, @OriginalArg(3) js5 arg1) {
        @Pc(17) byte[] local17 = arg1.getfile(0, arg0);
        return local17 == null ? null : new Class381(local17);
    }
}
