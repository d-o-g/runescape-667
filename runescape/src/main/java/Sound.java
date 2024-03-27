import com.jagex.sound.SoundType;
import com.jagex.sound.SynthSound;
import com.jagex.sound.VariableRateSoundPacket;
import com.jagex.sound.vorbis.VorbisSound;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!eka")
public final class Sound {

    @OriginalMember(owner = "client!eka", name = "n", descriptor = "Lclient!sq;")
    public VariableRateSoundPacket packet;

    @OriginalMember(owner = "client!eka", name = "m", descriptor = "Lclient!haa;")
    public SoundStream stream;

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "Lclient!uj;")
    public VorbisSound vorbis;

    @OriginalMember(owner = "client!eka", name = "t", descriptor = "Lclient!dw;")
    public SynthSound synth;

    @OriginalMember(owner = "client!eka", name = "q", descriptor = "I")
    public final int rate;

    @OriginalMember(owner = "client!eka", name = "g", descriptor = "B")
    public final byte type;

    @OriginalMember(owner = "client!eka", name = "p", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!eka", name = "e", descriptor = "I")
    public int delay;

    @OriginalMember(owner = "client!eka", name = "k", descriptor = "I")
    public final int coord;

    @OriginalMember(owner = "client!eka", name = "b", descriptor = "I")
    public final int loops;

    @OriginalMember(owner = "client!eka", name = "j", descriptor = "Lclient!eo;")
    public final Entity entity;

    @OriginalMember(owner = "client!eka", name = "r", descriptor = "I")
    public final int volume;

    @OriginalMember(owner = "client!eka", name = "<init>", descriptor = "(BIIIIIILclient!eo;)V")
    public Sound(@OriginalArg(0) byte type, @OriginalArg(1) int id, @OriginalArg(2) int loops, @OriginalArg(3) int delay, @OriginalArg(4) int volume, @OriginalArg(6) int rate, @OriginalArg(5) int coord, @OriginalArg(7) Entity entity) {
        this.rate = rate;
        this.type = type;
        this.id = id;
        this.delay = delay;
        this.coord = coord;
        this.loops = loops;
        this.entity = entity;
        this.volume = volume;
    }

    @OriginalMember(owner = "client!eka", name = "a", descriptor = "(B)Z")
    public boolean isVorbis() {
        return this.type == SoundType.VORBIS || this.type == SoundType.VORBIS_VOICE_OVER;
    }
}
