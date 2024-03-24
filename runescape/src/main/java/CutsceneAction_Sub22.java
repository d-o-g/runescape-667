import com.jagex.core.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!uca")
public final class CutsceneAction_Sub22 extends CutsceneAction {

    @OriginalMember(owner = "client!uca", name = "<init>", descriptor = "(Lclient!ge;)V")
    public CutsceneAction_Sub22(@OriginalArg(0) Packet arg0) {
        super(arg0);
    }

    @OriginalMember(owner = "client!uca", name = "b", descriptor = "(I)V")
    @Override
    public void method9161() {
        Static33.method881();
    }
}
