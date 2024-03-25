import org.openrs2.deob.annotation.OriginalMember;

public final class SoundManager {
    @OriginalMember(owner = "client!mt", name = "L", descriptor = "[Lclient!eka;")
    public static Sound[] sounds = new Sound[50];

    @OriginalMember(owner = "client!bc", name = "c", descriptor = "I")
    public static int count = 0;

    @OriginalMember(owner = "client!lka", name = "b", descriptor = "(B)V")
    public static void reset() {
        count = 0;
        sounds = new Sound[50];
    }
}
