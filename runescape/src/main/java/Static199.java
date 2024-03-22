import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static199 {

    @OriginalMember(owner = "client!gd", name = "g", descriptor = "(I)V")
    public static void doneslowupdate() {
        Static600.aClass27_1.reset();
        for (@Pc(8) int local8 = 0; local8 < 32; local8++) {
            Static475.drawTimes[local8] = 0L;
        }
        for (@Pc(19) int local19 = 0; local19 < 32; local19++) {
            Static221.drawTimes[local19] = 0L;
        }
        Static32.scheduledTicks = 0;
    }
}
