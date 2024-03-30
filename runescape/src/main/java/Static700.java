import com.jagex.Client;
import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static700 {

    @OriginalMember(owner = "client!wca", name = "a", descriptor = "(B)V")
    public static void method9152() {
        Static563.method7461();
        for (@Pc(16) int local16 = 0; local16 < 4; local16++) {
            Client.collisionMaps[local16].reset();
        }
        Minimap.reset();
        client.cacheReset();
        VideoManager.stop();
        System.gc();
        Toolkit.active.ya();
    }

}
