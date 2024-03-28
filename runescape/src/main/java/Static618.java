import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.io.Packet;
import com.jagex.game.runetek6.config.vartype.VarcTypeList;
import com.jagex.js5.js5;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static618 {

    @OriginalMember(owner = "client!tja", name = "B", descriptor = "I")
    public static int anInt9449;

    @OriginalMember(owner = "client!tja", name = "G", descriptor = "Lclient!sia;")
    public static final Deque A_DEQUE___68 = new Deque();

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(III)Z")
    public static boolean method8316(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
        return Static335.method4946(arg2, arg1) | (arg1 & 0x60000) != 0 || Static69.method6333(arg1, arg2);
    }

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(BLclient!ge;)V")
    public static void method8317(@OriginalArg(1) Packet arg0) {
        if (arg0.data.length - arg0.pos < 1) {
            return;
        }
        @Pc(21) int local21 = arg0.g1();
        if (local21 < 0 || local21 > 1 || arg0.data.length - arg0.pos < 2) {
            return;
        }
        @Pc(62) int local62 = arg0.g2();
        if (local62 * 6 > arg0.data.length - arg0.pos) {
            return;
        }
        for (@Pc(80) int local80 = 0; local80 < local62; local80++) {
            @Pc(86) int local86 = arg0.g2();
            @Pc(90) int local90 = arg0.g4();
            if (local86 < Static511.varcs.length && Static118.permVarcs[local86] && (VarcTypeList.instance.list(local86).dataType != '1' || local90 >= -1 && local90 <= 1)) {
                Static511.varcs[local86] = local90;
            }
        }
    }

    @OriginalMember(owner = "client!tja", name = "a", descriptor = "(Lclient!sb;IZIIIZ)V")
    public static void method8318(@OriginalArg(0) js5 midiSongs, @OriginalArg(1) int volume, @OriginalArg(4) int id, @OriginalArg(5) int arg3) {
        if (arg3 <= 0) {
            Static611.method8229(id, volume, midiSongs);
            return;
        }
        Static24.midiVolume = volume;
        Static96.anInt10171 = 1;
        Static676.midiSongs = midiSongs;
        Static497.aBoolean564 = false;
        Static117.aClass2_Sub6_Sub1_2 = null;
        Static99.midiGroupId = id;
        Static174.midiFileId = 0;
        Static190.anInt3112 = Static581.aClass2_Sub6_Sub1_3.method948() / arg3;
        if (Static190.anInt3112 < 1) {
            Static190.anInt3112 = 1;
        }
    }

}
