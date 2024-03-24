import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!gv")
public final class CutsceneAction_Sub8 extends CutsceneAction {

    @OriginalMember(owner = "client!gv", name = "g", descriptor = "Ljava/lang/String;")
    public final String aString39;

    @OriginalMember(owner = "client!gv", name = "i", descriptor = "I")
    public final int anInt3635;

    @OriginalMember(owner = "client!gv", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub8(@OriginalArg(0) Packet arg0) {
        super(arg0);
        this.aString39 = arg0.gjstr();
        this.anInt3635 = arg0.g2();
    }

    @OriginalMember(owner = "client!gv", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        if (CutsceneManager.cutsceneId != -1) {
            ScriptRunner.executeCutsceneSubtitleTrigger(CutsceneManager.cutsceneId, this.aString39, this.anInt3635);
        }
    }
}
