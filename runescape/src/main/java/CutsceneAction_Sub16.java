import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pe")
public final class CutsceneAction_Sub16 extends CutsceneAction {

    @OriginalMember(owner = "client!pe", name = "i", descriptor = "I")
    public final int anInt7273;

    @OriginalMember(owner = "client!pe", name = "o", descriptor = "I")
    public final int anInt7275;

    @OriginalMember(owner = "client!pe", name = "p", descriptor = "I")
    public final int anInt7278;

    @OriginalMember(owner = "client!pe", name = "n", descriptor = "I")
    public final int anInt7280;

    @OriginalMember(owner = "client!pe", name = "g", descriptor = "I")
    public final int anInt7279;

    @OriginalMember(owner = "client!pe", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub16(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt7273 = arg0.g2();
        @Pc(11) int local11 = arg0.g4();
        this.anInt7275 = local11 & 0xFFFF;
        this.anInt7278 = local11 >>> 16;
        this.anInt7280 = arg0.g1();
        this.anInt7279 = arg0.g1();
    }

    @OriginalMember(owner = "client!pe", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        Static507.aClass394Array1[this.anInt7273].method9038(this.anInt7278, this.anInt7279, this.anInt7275, this.anInt7280);
    }
}
