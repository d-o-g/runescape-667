import com.jagex.game.Animator;
import com.jagex.game.runetek6.config.seqtype.SeqType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!js")
public final class ComponentAnimator extends Animator {

    @OriginalMember(owner = "client!js", name = "<init>", descriptor = "()V")
    public ComponentAnimator() {
        super(true);
    }

    @OriginalMember(owner = "client!js", name = "a", descriptor = "(ILclient!cka;B)V")
    @Override
    protected void newFrame(@OriginalArg(0) int arg0, @OriginalArg(1) SeqType arg1) {
        SoundManager.method4577(arg0, arg1);
    }
}
