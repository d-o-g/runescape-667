import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static24 {

    @OriginalMember(owner = "client!aq", name = "b", descriptor = "F")
    public static float aFloat20;

    @OriginalMember(owner = "client!aq", name = "f", descriptor = "[I")
    public static int[] anIntArray33;

    @OriginalMember(owner = "client!aq", name = "i", descriptor = "I")
    public static int anInt595;

    @OriginalMember(owner = "client!aq", name = "a", descriptor = "(I)V")
    public static void method680() {
        Static147.method2421((long) TimeUtils.clock, Static163.activeToolkit);
        if (Static377.anInt5930 != -1) {
            Static26.method716(Static377.anInt5930);
        }
        for (@Pc(23) int local23 = 0; local23 < Static122.anInt2339; local23++) {
            if (Static364.aBooleanArray18[local23]) {
                Static469.aBooleanArray23[local23] = true;
            }
            Static359.aBooleanArray17[local23] = Static364.aBooleanArray18[local23];
            Static364.aBooleanArray18[local23] = false;
        }
        Static171.anInt2880 = TimeUtils.clock;
        if (Static377.anInt5930 != -1) {
            Static122.anInt2339 = 0;
            Static261.method3833();
        }
        Static163.activeToolkit.la();
        Static676.method8859(Static163.activeToolkit);
        @Pc(77) int local77 = Static679.method8909();
        if (local77 == -1) {
            local77 = Static442.anInt6699;
        }
        if (local77 == -1) {
            local77 = StaticWallDecor.lb;
        }
        Static115.method2136(local77);
        Static35.anInt800 = 0;
    }

}
