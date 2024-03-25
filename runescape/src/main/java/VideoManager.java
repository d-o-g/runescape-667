import com.jagex.core.util.JagException;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class VideoManager {

    @OriginalMember(owner = "client!pw", name = "c", descriptor = "(Z)V")
    public static void unpause() {
        for (@Pc(15) VideoType type = (VideoType) VideoTypeList.recentUse.first(); type != null; type = (VideoType) VideoTypeList.recentUse.next()) {
            if (type.paused) {
                type.paused = false;
            } else {
                stop(type.id);
            }
        }
    }

    @OriginalMember(owner = "client!hfa", name = "c", descriptor = "(I)V")
    public static void tick() {
        for (@Pc(16) VideoType type = (VideoType) VideoTypeList.recentUse.first(); type != null; type = (VideoType) VideoTypeList.recentUse.next()) {
            if (type.js5.method9177()) {
                stop(type.id);
            } else {
                type.js5.readNextPages();

                try {
                    type.js5.tick();
                } catch (@Pc(43) Exception cause) {
                    JagException.sendTrace(cause, "TV: " + type.id);
                    stop(type.id);
                }

                if (!type.aBoolean14 && !type.aBoolean16) {
                    @Pc(73) OggVorbisStream audio = type.js5.getAudioStream();

                    if (audio != null) {
                        @Pc(79) Node_Sub6_Sub5 local79 = audio.method3960();

                        if (local79 != null) {
                            local79.method9147(type.anInt180);
                            Static336.activeStreams.method5882(local79);
                            type.aBoolean14 = true;
                        }
                    }
                }
            }
        }
    }

    @OriginalMember(owner = "client!bja", name = "a", descriptor = "(I)V")
    public static void stop() {
        for (@Pc(8) VideoType type = (VideoType) VideoTypeList.recentUse.first(); type != null; type = (VideoType) VideoTypeList.recentUse.next()) {
            stop(type.id);
        }
    }

    @OriginalMember(owner = "client!dp", name = "a", descriptor = "(II)V")
    public static void stop(@OriginalArg(0) int id) {
        @Pc(17) VideoType type = (VideoType) VideoTypeList.recentUse.get(id);

        if (type != null) {
            type.js5.stop();
            ended(type.id, type.transmitOnEnd);
            type.unlink();
        }
    }

    @OriginalMember(owner = "client!ub", name = "a", descriptor = "(IZB)V")
    public static void ended(@OriginalArg(0) int id, @OriginalArg(1) boolean transmit) {
        if (transmit) {
            @Pc(26) ClientMessage message = ClientMessage.create(Static321.VIDEO_END, ConnectionManager.GAME.cipher);
            message.bitPacket.p2(id);
            ConnectionManager.GAME.send(message);
        } else {
            ScriptRunner.executeTrigger(ClientTriggerType.VIDEO_END, id, -1);
        }
    }
}
