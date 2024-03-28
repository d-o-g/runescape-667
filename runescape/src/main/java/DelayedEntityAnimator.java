import com.jagex.Entity;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!wb")
public final class DelayedEntityAnimator extends EntityAnimator {

    @OriginalMember(owner = "client!wb", name = "W", descriptor = "I")
    public int entityDelay;

    @OriginalMember(owner = "client!wb", name = "<init>", descriptor = "(Lclient!eo;)V")
    public DelayedEntityAnimator(@OriginalArg(0) Entity entity) {
        super(entity, false);
    }
}
