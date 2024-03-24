import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static538 {

    @OriginalMember(owner = "client!qv", name = "f", descriptor = "F")
    public static float aFloat174;

    @OriginalMember(owner = "client!qv", name = "a", descriptor = "(ILjava/awt/Canvas;II)Lclient!cda;")
    public static Node_Sub10 method7192(@OriginalArg(0) int arg0, @OriginalArg(1) Canvas arg1, @OriginalArg(3) int arg2) {
        try {
            @Pc(13) Class local13 = Class.forName("Node_Sub20_Sub2");
            @Pc(17) Node_Sub10 local17 = (Node_Sub10) local13.getDeclaredConstructor().newInstance();
            local17.method6332(arg2, arg0, arg1);
            return local17;
        } catch (@Pc(26) Throwable local26) {
            @Pc(30) Node_Sub10_Sub1 local30 = new Node_Sub10_Sub1();
            local30.method6332(arg2, arg0, arg1);
            return local30;
        }
    }

}
