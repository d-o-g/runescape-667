import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cp")
public final class CutsceneAction_Sub2 extends CutsceneAction {

    @OriginalMember(owner = "client!cp", name = "j", descriptor = "I")
    public final int anInt1832;

    @OriginalMember(owner = "client!cp", name = "k", descriptor = "Ljava/lang/String;")
    public final String aString15;

    @OriginalMember(owner = "client!cp", name = "i", descriptor = "I")
    public final int anInt1834;

    @OriginalMember(owner = "client!cp", name = "m", descriptor = "I")
    public final int anInt1833;

    @OriginalMember(owner = "client!cp", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub2(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt1832 = arg0.g2();
        this.aString15 = arg0.gjstr();
        this.anInt1834 = arg0.g4();
        this.anInt1833 = arg0.g2();
    }

    @OriginalMember(owner = "client!cp", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        Static219.aClass236Array1[this.anInt1832].method5363().setChatLine(this.anInt1833, this.aString15, 0, this.anInt1834);
    }
}
