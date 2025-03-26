import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!wd")
public final class CutsceneAction_Sub1_Sub2 extends CutsceneAction_Sub1 {

    @OriginalMember(owner = "client!wd", name = "o", descriptor = "I")
    public final int anInt10564;

    @OriginalMember(owner = "client!wd", name = "p", descriptor = "I")
    public final int anInt10562;

    @OriginalMember(owner = "client!wd", name = "q", descriptor = "I")
    public final int anInt10563;

    @OriginalMember(owner = "client!wd", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub1_Sub2(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt10564 = arg0.g2();
        this.anInt10562 = arg0.g1();
        this.anInt10563 = arg0.g2();
    }

    @OriginalMember(owner = "client!wd", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        CutsceneManager.actors[this.anInt10564].entity().setEffect(this.anInt10562, super.anInt10556, false, super.anInt10560 << 16, this.anInt10563, super.anInt10558);
    }
}
