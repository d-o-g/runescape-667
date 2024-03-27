import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static482 {

    @OriginalMember(owner = "client!pda", name = "w", descriptor = "I")
    public static int anInt7265;

    @OriginalMember(owner = "client!pda", name = "L", descriptor = "I")
    public static int anInt7228 = 0;

    @OriginalMember(owner = "client!pda", name = "A", descriptor = "Lclient!eba;")
    public static final Class92 aClass92_13 = new Class92(2);

    @OriginalMember(owner = "client!pda", name = "p", descriptor = "[I")
    public static int[] anIntArray588 = new int[2];

    @OriginalMember(owner = "client!pda", name = "a", descriptor = "(IIIB)V")
    public static void method6481(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        @Pc(12) int local12 = ClientOptions.instance.musicVolume.getValue() * arg0 >> 8;
        if (local12 == 0 || arg1 == -1) {
            return;
        }
        if (!Static501.aBoolean575 && SoundManager.midiSong != -1 && Static52.method1157(0x6E ^ 0x11) && !Static203.method3070()) {
            Static8.aClass2_Sub6_Sub1_1 = Static426.method1018();
            @Pc(52) Node_Sub6_Sub1 local52 = Static48.method1100(Static8.aClass2_Sub6_Sub1_1);
            Static697.method9120(local52);
        }
        Static611.method8229(arg1, local12, js5.MIDI_JINGLES);
        SoundManager.mixBussSetLevel(255, -1);
        Static501.aBoolean575 = true;
    }
}
