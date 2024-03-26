import com.jagex.Client;
import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.game.runetek6.sound.OggKateStream;
import com.jagex.graphics.Sprite;
import com.jagex.graphics.Toolkit;
import com.jagex.js5.js5;
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

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(IZ)V")
    public static void method9267(@OriginalArg(0) int arg0) {
        @Pc(10) VideoType local10 = (VideoType) recentUse.get(arg0);
        if (local10 != null) {
            local10.aBoolean16 = !local10.aBoolean16;
            local10.js5.method9174(local10.aBoolean16);
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(BILclient!ha;)Lclient!st;")
    public static Sprite frame(@OriginalArg(1) int arg0, @OriginalArg(2) Toolkit toolkit) {
        @Pc(18) VideoType type = (VideoType) recentUse.get(arg0);

        if (type != null) {
            @Pc(25) OggTheoraStream stream = type.js5.getVideoStream();
            type.paused = true;

            if (stream != null) {
                return stream.sprite(toolkit);
            }
        }

        return null;
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(ZIII)V")
    public static void method6802(@OriginalArg(0) boolean transmitOnEnd, @OriginalArg(2) int id, @OriginalArg(3) int arg2) {
        if (recentUse.get(id) != null) {
            return;
        }

        if (Static234.loadedJagtheora) {
            @Pc(34) VideoType type = new VideoType(id, new Js5Video(4096, js5.VIDEOS, id), arg2, transmitOnEnd);
            type.js5.setLanguage(Static384.aStringArray31[Client.language]);
            recentUse.put(id, type);
        } else {
            VideoManager.ended(id, transmitOnEnd);
        }
    }

}
