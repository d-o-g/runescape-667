import com.jagex.core.io.Packet;
import com.jagex.core.util.TimeUtils;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!fka")
public final class CutsceneAction_Sub5 extends CutsceneAction {

    @OriginalMember(owner = "client!fka", name = "k", descriptor = "I")
    public final int anInt3000;

    @OriginalMember(owner = "client!fka", name = "m", descriptor = "I")
    public final int anInt2996;

    @OriginalMember(owner = "client!fka", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub5(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.anInt3000 = arg0.g2();
        this.anInt2996 = arg0.g4();
    }

    @OriginalMember(owner = "client!fka", name = "b", descriptor = "(I)V")
    @Override
    public void execute() {
        Static323.anInt5120 = CutsceneManager.cutsceneFadeAlpha;
        Static493.anInt7370 = CutsceneManager.cutsceneFadeRed;
        Static582.anInt8628 = CutsceneManager.cutsceneFadeBlue;
        CutsceneManager.cutsceneFadeEnd = this.anInt3000 + TimeUtils.clock;
        Static201.anInt8407 = CutsceneManager.cutsceneFadeGreen;
        CutsceneManager.cutsceneFadeStart = TimeUtils.clock;
        CutsceneManager.cutsceneFadeGreen = this.anInt2996 & 0xFF;
        CutsceneManager.cutsceneFadeBlue = this.anInt2996 >>> 16 & 0xFF;
        CutsceneManager.cutsceneFadeAlpha = this.anInt2996 >>> 24;
        CutsceneManager.cutsceneFadeRed = this.anInt2996 >>> 8 & 0xFF;
    }
}
