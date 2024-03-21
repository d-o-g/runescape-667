import com.jagex.core.datastruct.key.IterableHashTable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class VideoTypeList {

    @OriginalMember(owner = "client!dfa", name = "a", descriptor = "Lclient!av;")
    public static final IterableHashTable recentUse = new IterableHashTable(4);

    @OriginalMember(owner = "client!ek", name = "a", descriptor = "(II)Ljava/lang/String;")
    public static String subtitles(@OriginalArg(1) int id) {
        @Pc(16) VideoType type = (VideoType) recentUse.get(id);
        if (type == null) {
            return null;
        }

        @Pc(23) OggKateStream stream = type.js5.subtitleStream();
        if (stream == null) {
            return null;
        }

        @Pc(32) double time = type.js5.getTime();
        if (time >= (double) stream.getStartTime() && time <= (double) stream.getEndTime()) {
            return stream.getSubtitle();
        }

        return null;
    }
}
