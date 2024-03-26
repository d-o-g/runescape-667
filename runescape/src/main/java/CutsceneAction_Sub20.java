import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!sda")
public final class CutsceneAction_Sub20 extends CutsceneAction {

    @OriginalMember(owner = "client!sda", name = "j", descriptor = "I")
    public final int anInt8594;

    @OriginalMember(owner = "client!sda", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub20(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt8594 = arg0.g2();
    }

    @OriginalMember(owner = "client!sda", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        CutsceneManager.actors[this.anInt8594].reset();
    }
}
