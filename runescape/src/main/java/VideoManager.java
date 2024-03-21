import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class VideoManager {
    @OriginalMember(owner = "client!ek", name = "a", descriptor = "(II)Ljava/lang/String;")
    public static String subtitles(@OriginalArg(1) int arg0) {
        @Pc(16) Node_Sub5 local16 = (Node_Sub5) Static106.A_HASH_TABLE___11.get((long) arg0);
        if (local16 != null) {
            @Pc(23) Node_Sub28_Sub4 local23 = local16.aClass222_Sub1_1.method9178();
            if (local23 != null) {
                @Pc(32) double local32 = local16.aClass222_Sub1_1.method9185();
                if ((double) local23.method8561() <= local32 && local32 <= (double) local23.method8566()) {
                    return local23.method8565();
                }
            }
        }
        return null;
    }
}
