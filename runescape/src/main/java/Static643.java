import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

import java.awt.Canvas;

public final class Static643 {

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "D")
    public static double aDouble23;

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(III)Z")
    public static boolean method8442(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static710.method6713(arg1, arg0) || Static286.method4110(arg1, arg0);
    }

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(IILclient!d;ILjava/awt/Canvas;)Lclient!ha;")
    public static Toolkit method8443(@OriginalArg(0) int arg0, @OriginalArg(2) TextureSource arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Canvas arg3) {
        return new Toolkit_Sub2(arg3, arg1, arg0, arg2);
    }

}
