import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!hb")
public final class CutsceneAction_Sub9 extends CutsceneAction {

    @OriginalMember(owner = "client!hb", name = "i", descriptor = "I")
    public final int anInt3695;

    @OriginalMember(owner = "client!hb", name = "h", descriptor = "I")
    public final int anInt3692;

    @OriginalMember(owner = "client!hb", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub9(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt3695 = arg0.g2();
        this.anInt3692 = arg0.g1();
    }

    @OriginalMember(owner = "client!hb", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        SoundManager.playMidiJingle(this.anInt3692, this.anInt3695, 0);
    }
}
