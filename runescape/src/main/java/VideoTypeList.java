import com.jagex.core.datastruct.key.IterableHashTable;
import com.jagex.core.util.JagException;
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

    @OriginalMember(owner = "client!dp", name = "a", descriptor = "(II)V")
    public static void method2199(@OriginalArg(0) int arg0) {
        @Pc(17) VideoType type = (VideoType) recentUse.get((long) arg0);
        if (type != null) {
            type.js5.stop();
            Static635.method8380(type.anInt182, type.aBoolean15);
            type.unlink();
        }
    }

    @OriginalMember(owner = "client!vw", name = "a", descriptor = "(IZ)V")
    public static void method9267(@OriginalArg(0) int arg0) {
        @Pc(10) VideoType local10 = (VideoType) recentUse.get((long) arg0);
        if (local10 != null) {
            local10.aBoolean16 = !local10.aBoolean16;
            local10.js5.method9174(local10.aBoolean16);
        }
    }

    @OriginalMember(owner = "client!uja", name = "a", descriptor = "(BILclient!ha;)Lclient!st;")
    public static Sprite method8512(@OriginalArg(1) int arg0, @OriginalArg(2) Toolkit arg1) {
        @Pc(18) VideoType local18 = (VideoType) recentUse.get((long) arg0);
        if (local18 != null) {
            @Pc(25) OggTheoraStream local25 = local18.js5.getVideoStream();
            local18.aBoolean18 = true;
            if (local25 != null) {
                return local25.method5491(arg1);
            }
        }
        return null;
    }

    @OriginalMember(owner = "client!qda", name = "a", descriptor = "(ZIII)V")
    public static void method6802(@OriginalArg(0) boolean arg0, @OriginalArg(2) int arg1, @OriginalArg(3) int arg2) {
        if (recentUse.get((long) arg1) != null) {
            return;
        }
        if (Static234.aBoolean303) {
            @Pc(34) VideoType local34 = new VideoType(arg1, new Js5Video(4096, js5.js5_36, arg1), arg2, arg0);
            local34.js5.setLanguage(Static384.aStringArray31[Static51.language]);
            recentUse.put((long) arg1, local34);
        } else {
            Static635.method8380(arg1, arg0);
        }
    }

    @OriginalMember(owner = "client!pw", name = "c", descriptor = "(Z)V")
    public static void method6744() {
        for (@Pc(15) VideoType local15 = (VideoType) recentUse.first(); local15 != null; local15 = (VideoType) recentUse.next()) {
            if (local15.aBoolean18) {
                local15.aBoolean18 = false;
            } else {
                method2199(local15.anInt182);
            }
        }
    }

    @OriginalMember(owner = "client!bja", name = "a", descriptor = "(I)V")
    public static void method1084() {
        for (@Pc(8) VideoType local8 = (VideoType) recentUse.first(); local8 != null; local8 = (VideoType) recentUse.next()) {
            method2199(local8.anInt182);
        }
    }

    @OriginalMember(owner = "client!hfa", name = "c", descriptor = "(I)V")
    public static void method3453() {
        for (@Pc(16) VideoType local16 = (VideoType) recentUse.first(); local16 != null; local16 = (VideoType) recentUse.next()) {
            if (local16.js5.method9177()) {
                method2199(local16.anInt182);
            } else {
                local16.js5.readNextPages();
                try {
                    local16.js5.tick();
                } catch (@Pc(43) Exception local43) {
                    JagException.sendTrace(local43, "TV: " + local16.anInt182);
                    method2199(local16.anInt182);
                }
                if (!local16.aBoolean14 && !local16.aBoolean16) {
                    @Pc(73) OggVorbisStream local73 = local16.js5.getAudioStream();
                    if (local73 != null) {
                        @Pc(79) Node_Sub6_Sub5 local79 = local73.method3960();
                        if (local79 != null) {
                            local79.method9147(local16.anInt180);
                            Static336.aClass2_Sub6_Sub3_1.method5882(local79);
                            local16.aBoolean14 = true;
                        }
                    }
                }
            }
        }
    }
}
