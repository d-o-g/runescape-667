import com.jagex.graphics.TextureSource;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.Canvas;

public final class Static643 {

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "D")
    public static double aDouble23;

    @OriginalMember(owner = "client!uf", name = "f", descriptor = "I")
    public static int anInt9604 = -1;

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(III)Z")
    public static boolean method8442(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static710.method6713(arg1, arg0) || Static286.method4110(arg1, arg0);
    }

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(IILclient!d;ILjava/awt/Canvas;)Lclient!ha;")
    public static Toolkit method8443(@OriginalArg(0) int arg0, @OriginalArg(2) TextureSource arg1, @OriginalArg(3) int arg2, @OriginalArg(4) Canvas arg3) {
        return new Toolkit_Sub2(arg3, arg1, arg0, arg2);
    }

    @OriginalMember(owner = "client!uf", name = "a", descriptor = "(II[Lclient!hda;)V")
    public static void method8444(@OriginalArg(1) int arg0, @OriginalArg(2) Component[] arg1) {
        for (@Pc(3) int local3 = 0; local3 < arg1.length; local3++) {
            @Pc(9) Component local9 = arg1[local3];
            if (local9 != null && local9.layer == arg0 && !InterfaceManager.isHidden(local9)) {
                if (local9.type == 0) {
                    method8444(local9.slot, arg1);
                    if (local9.aComponentArray1 != null) {
                        method8444(local9.slot, local9.aComponentArray1);
                    }
                    @Pc(56) Node_Sub4 local56 = (Node_Sub4) Static548.aHashTable_40.get((long) local9.slot);
                    if (local56 != null) {
                        Static26.method716(local56.anInt147);
                    }
                }
                if (local9.type == 6 && local9.modelAnimation != -1) {
                    if (local9.aAnimator_6 == null) {
                        local9.aAnimator_6 = new Animator_Sub1();
                        local9.aAnimator_6.update(true, local9.modelAnimation);
                    }
                    if (local9.aAnimator_6.tick(Static35.anInt800) && local9.aAnimator_6.isFinished()) {
                        local9.aAnimator_6.method9099();
                    }
                }
            }
        }
    }
}
