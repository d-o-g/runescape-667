import com.jagex.game.runetek6.sound.OggStream;
import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!maa")
public final class OggOtherStream extends OggStream {

    @OriginalMember(owner = "client!maa", name = "<init>", descriptor = "(Lclient!jagtheora/ogg/OggStreamState;)V")
    public OggOtherStream(@OriginalArg(0) OggStreamState arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!maa", name = "b", descriptor = "(I)V")
    @Override
    public void stop() {
    }

    @OriginalMember(owner = "client!maa", name = "b", descriptor = "(ILclient!jagtheora/ogg/OggPacket;)V")
    @Override
    protected void decode(@OriginalArg(1) OggPacket packet) {
    }
}
