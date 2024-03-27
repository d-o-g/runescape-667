import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static63 {

    @OriginalMember(owner = "client!caa", name = "a", descriptor = "(IIII)V")
    public static void method1427(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        @Pc(12) int local12 = arg0 * ClientOptions.instance.musicVolume.getValue() >> 8;
        if (arg1 == -1 && !Static501.aBoolean575) {
            Static100.method1988();
        } else if (arg1 != -1 && (SoundManager.midiSong != arg1 || !Static52.method1157(-122)) && local12 != 0 && !Static501.aBoolean575) {
            Static618.method8318(js5.MIDI_SONGS, local12, arg1, arg2);
            SoundManager.mixBussReset();
        }
        if (SoundManager.midiSong != arg1) {
            Static8.aClass2_Sub6_Sub1_1 = null;
        }
        SoundManager.midiSong = arg1;
    }
}
