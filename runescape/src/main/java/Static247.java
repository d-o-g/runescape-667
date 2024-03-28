import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static247 {

    @OriginalMember(owner = "client!hla", name = "a", descriptor = "(ILclient!ca;)V")
    public static void method3523(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(16) PositionedSound local16 = (PositionedSound) SoundManager.playerSounds.get(arg0.id);
        if (local16 == null) {
            Static89.method1714(arg0.level, arg0, arg0.pathX[0], arg0.pathZ[0], null, null, 0);
        } else {
            local16.update();
        }
    }
}
