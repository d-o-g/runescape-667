import com.jagex.graphics.Mesh;
import com.jagex.graphics.Model;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static691 {

    @OriginalMember(owner = "client!vs", name = "p", descriptor = "[Lclient!st;")
    public static Sprite[] aSpriteArray15;

    @OriginalMember(owner = "client!vs", name = "m", descriptor = "I")
    public static int anInt10368 = 0;

    @OriginalMember(owner = "client!vs", name = "a", descriptor = "(IIIIIILclient!ha;)Lclient!ka;")
    public static Model method9004(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg2, @OriginalArg(4) int arg3, @OriginalArg(5) int arg4, @OriginalArg(6) Toolkit arg5) {
        @Pc(13) long local13 = (long) arg2;
        @Pc(19) Model local19 = (Model) Static186.A_WEIGHTED_CACHE___67.get(local13);
        if (local19 == null) {
            @Pc(29) Mesh local29 = Mesh.load(arg2, js5.MODELS);
            if (local29 == null) {
                return null;
            }
            if (local29.version < 13) {
                local29.upscale();
            }
            local19 = arg5.createModel(local29, 2055, Static391.anInt6133, 64, 768);
            Static186.A_WEIGHTED_CACHE___67.put(local19, local13);
        }
        local19 = local19.copy((byte) 6, 2055, true);
        if (arg4 != 0) {
            local19.a(arg4);
        }
        if (arg0 != 0) {
            local19.FA(arg0);
        }
        if (arg1 != 0) {
            local19.VA(arg1);
        }
        if (arg3 != 0) {
            local19.H(0, arg3, 0);
        }
        return local19;
    }
}
