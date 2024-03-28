import com.jagex.Entity;
import com.jagex.sound.Class123;
import com.jagex.sound.Node_Sub6_Sub1;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static576 {

    @OriginalMember(owner = "client!sba", name = "e", descriptor = "[Lclient!eo;")
    public static Entity[] opaqueStationaryEntities;

    @OriginalMember(owner = "client!sba", name = "d", descriptor = "I")
    public static int anInt8585;

    @OriginalMember(owner = "client!sba", name = "a", descriptor = "(III)Z")
    public static boolean method7609(@OriginalArg(0) int arg0, @OriginalArg(2) int arg1) {
        return Static69.method6335(arg1, arg0) & (Static526.method7073(arg0, arg1) | (arg1 & 0x2000) != 0 | Static220.method3197(arg1, arg0));
    }

    @OriginalMember(owner = "client!sba", name = "b", descriptor = "(Z)Z")
    public static boolean method7611() {
        try {
            if (Static96.anInt10171 == 2) {
                if (Static62.aClass2_Sub8_3 == null) {
                    Static62.aClass2_Sub8_3 = Static728.method1153(Static676.midiSongs, Static99.midiGroupId, Static174.midiFileId);
                    if (Static62.aClass2_Sub8_3 == null) {
                        return false;
                    }
                }
                if (Static12.aClass123_4 == null) {
                    Static12.aClass123_4 = new Class123(Static91.aJs5_117, Static296.aJs5_61);
                }
                @Pc(36) Node_Sub6_Sub1 local36 = Static581.aClass2_Sub6_Sub1_3;
                if (Static117.aClass2_Sub6_Sub1_2 != null) {
                    local36 = Static117.aClass2_Sub6_Sub1_2;
                }
                if (local36.method944(Static12.aClass123_4, Static86.aJs5_13, Static62.aClass2_Sub8_3)) {
                    Static581.aClass2_Sub6_Sub1_3 = local36;
                    Static581.aClass2_Sub6_Sub1_3.method933();
                    @Pc(65) int local65;
                    if (Static611.anInt9335 <= 0) {
                        Static96.anInt10171 = 0;
                        Static581.aClass2_Sub6_Sub1_3.method916(Static24.midiVolume);
                        for (local65 = 0; local65 < Static286.anIntArray358.length; local65++) {
                            Static581.aClass2_Sub6_Sub1_3.method926(Static286.anIntArray358[local65], local65);
                            Static286.anIntArray358[local65] = 255;
                        }
                    } else {
                        Static96.anInt10171 = 3;
                        Static581.aClass2_Sub6_Sub1_3.method916(Static24.midiVolume < Static611.anInt9335 ? Static24.midiVolume : Static611.anInt9335);
                        for (local65 = 0; local65 < Static286.anIntArray358.length; local65++) {
                            Static581.aClass2_Sub6_Sub1_3.method926(Static286.anIntArray358[local65], local65);
                            Static286.anIntArray358[local65] = 255;
                        }
                    }
                    if (Static117.aClass2_Sub6_Sub1_2 == null) {
                        if (Static146.aLong95 <= 0L) {
                            Static581.aClass2_Sub6_Sub1_3.method934(Static62.aClass2_Sub8_3, Static497.aBoolean564);
                        } else {
                            Static581.aClass2_Sub6_Sub1_3.method925(Static62.aClass2_Sub8_3, Static497.aBoolean564, Static146.aLong95);
                        }
                    }
                    if (Static426.aClass56_2 != null) {
                        Static426.aClass56_2.method3582(Static581.aClass2_Sub6_Sub1_3);
                    }
                    Static146.aLong95 = 0L;
                    Static12.aClass123_4 = null;
                    Static62.aClass2_Sub8_3 = null;
                    Static117.aClass2_Sub6_Sub1_2 = null;
                    Static676.midiSongs = null;
                    return true;
                }
            }
        } catch (@Pc(191) Exception local191) {
            local191.printStackTrace();
            Static581.aClass2_Sub6_Sub1_3.method912();
            Static12.aClass123_4 = null;
            Static117.aClass2_Sub6_Sub1_2 = null;
            Static676.midiSongs = null;
            Static62.aClass2_Sub8_3 = null;
            Static96.anInt10171 = 0;
        }
        return false;
    }

}
