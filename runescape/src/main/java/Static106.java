import com.jagex.graphics.Toolkit;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class Static106 {

    @OriginalMember(owner = "client!dfa", name = "e", descriptor = "I")
    public static int anInt2153;

    @OriginalMember(owner = "client!dfa", name = "a", descriptor = "(ILclient!ha;)V")
    public static void method2046(@OriginalArg(1) Toolkit arg0) {
        if (Minimap.level != PlayerEntity.self.level && (Static334.activeTiles != null && Static484.method6494(arg0, PlayerEntity.self.level))) {
            Minimap.level = PlayerEntity.self.level;
        }
    }

    @OriginalMember(owner = "client!dfa", name = "a", descriptor = "(ZII)V")
    public static void method2048(@OriginalArg(1) int arg0, @OriginalArg(2) int arg1) {
        Static180.anInt3001 = arg0 - WorldMap.areaX;
        WorldMap.anInt3181 = arg1 - WorldMap.areaY;
    }
}
