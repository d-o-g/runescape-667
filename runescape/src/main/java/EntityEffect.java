import com.jagex.game.Animator;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!jq")
public final class EntityEffect {

    @OriginalMember(owner = "client!jq", name = "e", descriptor = "I")
    public int wornSlot;

    @OriginalMember(owner = "client!jq", name = "h", descriptor = "I")
    public int rotation;

    @OriginalMember(owner = "client!jq", name = "d", descriptor = "I")
    public int height;

    @OriginalMember(owner = "client!jq", name = "a", descriptor = "I")
    public int id = -1;

    @OriginalMember(owner = "client!jq", name = "c", descriptor = "Lclient!gu;")
    public final Animator animator;

    @OriginalMember(owner = "client!jq", name = "<init>", descriptor = "(Lclient!cg;)V")
    public EntityEffect(@OriginalArg(0) PathingEntity arg0) {
        this.animator = new EntityAnimator(arg0, false);
    }
}
