import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;
import java.lang.reflect.Method;

public final class Static733 {

    @OriginalMember(owner = "client!sd", name = "a", descriptor = "(Lclient!sb;IILclient!d;Ljava/awt/Canvas;)Lclient!ha;")
    public static Toolkit method7618(@OriginalArg(0) Class330 arg0, @OriginalArg(1) int arg1, @OriginalArg(3) Interface4 arg2, @OriginalArg(4) Canvas arg3) {
        try {
            if (!Static651.method8516()) {
                throw new RuntimeException("");
            } else if (Static14.method179("jagdx")) {
                @Pc(26) Class local26 = Class.forName("Toolkit_Sub1_Sub1");
                @Pc(68) Method local68 = local26.getDeclaredMethod("createToolkit", Class.forName("java.awt.Canvas"), Class.forName("Interface4"), Class.forName("Class330"), Class.forName("java.lang.Integer"));
                return (Toolkit) local68.invoke((Object) null, arg3, arg2, arg0, Integer.valueOf(arg1));
            } else {
                throw new RuntimeException("");
            }
        } catch (@Pc(98) Throwable local98) {
            throw new RuntimeException("");
        }
    }
}
