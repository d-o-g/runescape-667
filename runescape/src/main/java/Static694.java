import com.jagex.graphics.texture.Node_Sub1_Sub27;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static694 {

    @OriginalMember(owner = "client!vv", name = "z", descriptor = "I")
    public static int anInt10405;

    @OriginalMember(owner = "client!vv", name = "F", descriptor = "Lclient!fma;")
    public static final Class131 aClass131_6 = new Class131();

    @OriginalMember(owner = "client!vv", name = "c", descriptor = "(B)I")
    public static int method9030() {
        @Pc(9) int local9 = Loading.state.getStep();
        if (local9 < Loading.states.length - 1) {
            Loading.state = Loading.states[local9 + 1];
        }
        return 100;
    }

    @OriginalMember(owner = "client!vv", name = "e", descriptor = "(I)V")
    public static void method9031() {
        for (@Pc(10) int local10 = 0; local10 < Static617.anInt9434; local10++) {
            @Pc(23) int local23 = Node_Sub1_Sub27.method9118(Static482.anInt7265 + local10, Static617.anInt9434) * Static211.anInt5574;
            for (@Pc(25) int local25 = 0; local25 < Static211.anInt5574; local25++) {
                @Pc(36) int local36 = Node_Sub1_Sub27.method9118(Static632.anInt9503 + local25, Static211.anInt5574) + local23;
                if (Static173.anIntArray252[local36] == Static420.anInt6436) {
                    Static651.anInterface9Array1[local36].method9040(0, 0, Static437.horizontalAspectRatio, Static714.verticalAspectRatio, Static437.horizontalAspectRatio * local25, Static714.verticalAspectRatio * local10);
                }
            }
        }
        anInt10405++;
    }
}
