import com.jagex.core.io.Packet;
import com.jagex.js5.js5;
import com.jagex.sound.midi.MidiSong;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static728 {

    @OriginalMember(owner = "client!bn", name = "a", descriptor = "(Lclient!sb;II)Lclient!bn;")
    public static MidiSong method1153(@OriginalArg(0) js5 midiSongs, @OriginalArg(1) int groupId, @OriginalArg(2) int fileId) {
        @Pc(5) byte[] data = midiSongs.getfile(fileId, groupId);
        return data == null ? null : new MidiSong(new Packet(data));
    }
}
