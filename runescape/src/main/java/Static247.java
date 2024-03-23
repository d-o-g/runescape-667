import com.jagex.game.runetek6.config.loctype.LocType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static247 {

    @OriginalMember(owner = "client!hla", name = "d", descriptor = "I")
    public static int anInt3993;

    @OriginalMember(owner = "client!hla", name = "a", descriptor = "(ILclient!ca;)V")
    public static void method3523(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(16) Node_Sub51 local16 = (Node_Sub51) Static113.A_HASH_TABLE___12.get(arg0.anInt10740);
        if (local16 == null) {
            Static89.method1714(arg0.level, arg0, arg0.pathX[0], arg0.pathY[0], null, null, 0);
        } else {
            local16.method8236();
        }
    }
}
