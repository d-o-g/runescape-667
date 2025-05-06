import com.jagex.ChangeLocationRequest;
import com.jagex.game.runetek6.client.GameShell;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static271 {

    @OriginalMember(owner = "client!ij", name = "n", descriptor = "I")
    public static int anInt4363;

    @OriginalMember(owner = "client!ij", name = "a", descriptor = "(I)J")
    public static long method3929() {
        return GameShell.tickScheduler.getTickTime();
    }

    @OriginalMember(owner = "client!ij", name = "c", descriptor = "(B)V")
    public static void processLocChanges() {
        for (@Pc(10) ChangeLocationRequest request = Static159.changes.first(); request != null; request = Static159.changes.next()) {
            Static544.method7214(request, false);
        }

        for (@Pc(10) ChangeLocationRequest request = Static227.customisations.first(); request != null; request = Static227.customisations.next()) {
            Static544.method7214(request, true);
        }
    }
}
