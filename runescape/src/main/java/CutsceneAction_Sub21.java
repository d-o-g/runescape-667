import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!sha")
public final class CutsceneAction_Sub21 extends CutsceneAction {

    @OriginalMember(owner = "client!sha", name = "j", descriptor = "I")
    public final int anInt8669;

    @OriginalMember(owner = "client!sha", name = "g", descriptor = "I")
    public final int anInt8671;

    @OriginalMember(owner = "client!sha", name = "i", descriptor = "I")
    public final int anInt8668;

    @OriginalMember(owner = "client!sha", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub21(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt8669 = arg0.g2();
        this.anInt8671 = arg0.g2();
        this.anInt8668 = arg0.g1();
    }

    @OriginalMember(owner = "client!sha", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        @Pc(8) Actor local8 = CutsceneManager.actors[this.anInt8669];
        @Pc(13) Class231 local13 = Static183.aClass231Array1[this.anInt8671];
        local13.method5271(local8, this.anInt8668);
    }
}
