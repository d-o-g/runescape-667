import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static76 {

    @OriginalMember(owner = "client!cha", name = "d", descriptor = "I")
    public static int anInt1604 = 0;

    @OriginalMember(owner = "client!cha", name = "a", descriptor = "(BLclient!ca;)V")
    public static void method1552(@OriginalArg(1) PlayerEntity arg0) {
        @Pc(19) PositionedSound local19 = (PositionedSound) SoundManager.playerSounds.get(arg0.slot);
        if (local19 == null) {
            return;
        }
        if (local19.stream != null) {
            SoundManager.activeStreams.remove(local19.stream);
            local19.stream = null;
        }
        local19.unlink();
    }

}
