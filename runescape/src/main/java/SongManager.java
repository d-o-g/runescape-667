import com.jagex.js5.js5;
import com.jagex.sound.MixBuss;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;

public final class SongManager {

    @OriginalMember(owner = "client!sj", name = "e", descriptor = "I")
    public static int playing = -1;

    @OriginalMember(owner = "client!aq", name = "i", descriptor = "I")
    public static int volume;

    @OriginalMember(owner = "client!fs", name = "h", descriptor = "I")
    public static int anInt3112;

    @OriginalMember(owner = "client!vha", name = "I", descriptor = "Lclient!sb;")
    public static js5 midiSongs;

    @OriginalMember(owner = "client!ek", name = "c", descriptor = "J")
    public static long aLong95;

    @OriginalMember(owner = "client!fh", name = "l", descriptor = "I")
    public static int midiFileId;

    @OriginalMember(owner = "client!pla", name = "E", descriptor = "Z")
    public static boolean aBoolean564;

    @OriginalMember(owner = "client!dba", name = "z", descriptor = "I")
    public static int groupId;

    @OriginalMember(owner = "client!dla", name = "e", descriptor = "Lclient!bd;")
    public static MixBuss aClass2_Sub6_Sub1_2;

    @OriginalMember(owner = "client!tfa", name = "g", descriptor = "I")
    public static int anInt9335;

    @OriginalMember(owner = "client!da", name = "q", descriptor = "I")
    public static int anInt10171 = 0;

    @OriginalMember(owner = "client!bt", name = "a", descriptor = "(IIIZILclient!sb;Z)V")
    public static void reset(@OriginalArg(1) int groupId, @OriginalArg(4) int volume, @OriginalArg(5) js5 midiSongs) {
        SongManager.midiSongs = midiSongs;
        aBoolean564 = false;
        anInt3112 = 2;
        aClass2_Sub6_Sub1_2 = null;
        SongManager.volume = volume;
        anInt10171 = 1;
        midiFileId = 0;
        SongManager.groupId = groupId;
    }

    @OriginalMember(owner = "client!jt", name = "a", descriptor = "(II)V")
    public static void stop() {
        aClass2_Sub6_Sub1_2 = null;
        midiSongs = null;
        anInt3112 = 2;
        aBoolean564 = false;
        volume = 0;
        anInt10171 = 1;
        groupId = -1;
        midiFileId = -1;
    }

    @OriginalMember(owner = "client!kw", name = "a", descriptor = "(IILclient!sb;IZIJB)V")
    public static void method5119(@OriginalArg(2) js5 midiSongs, @OriginalArg(3) int volume, @OriginalArg(5) int groupId, @OriginalArg(6) long aLong95) {
        SongManager.volume = volume;
        anInt10171 = 1;
        anInt9335 = 0;
        SongManager.groupId = groupId;
        aBoolean564 = false;
        anInt3112 = 10000;
        aClass2_Sub6_Sub1_2 = null;
        midiFileId = 0;
        SongManager.aLong95 = aLong95;
        SongManager.midiSongs = midiSongs;
    }

    @OriginalMember(owner = "client!fma", name = "a", descriptor = "(JZIIIILclient!sb;)V")
    public static void method2797(@OriginalArg(0) long arg0, @OriginalArg(3) int midiGroupId, @OriginalArg(5) int volume, @OriginalArg(6) js5 midiSongs) {
        method5119(midiSongs, volume, midiGroupId, arg0);
    }

    @OriginalMember(owner = "client!ik", name = "a", descriptor = "(Lclient!bd;ZIILclient!sb;II)V")
    public static void method3961(@OriginalArg(0) MixBuss aClass2_Sub6_Sub1_2, @OriginalArg(3) int arg1, @OriginalArg(4) js5 arg2, @OriginalArg(5) int arg3) {
        method8229(arg1, arg3, arg2);
        SongManager.aClass2_Sub6_Sub1_2 = aClass2_Sub6_Sub1_2;
    }

    @OriginalMember(owner = "client!tfa", name = "a", descriptor = "(IIILclient!sb;ZI)V")
    public static void method8229(@OriginalArg(0) int midiGroupId, @OriginalArg(2) int volume, @OriginalArg(3) js5 midiSongs) {
        method2797(0L, midiGroupId, volume, midiSongs);
    }

}
