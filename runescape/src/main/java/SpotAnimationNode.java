import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vb")
public final class SpotAnimationNode extends Node2 {

    @OriginalMember(owner = "client!vb", name = "t", descriptor = "Lclient!pja;")
    public final SpotAnimation spotAnimation;

    @OriginalMember(owner = "client!vb", name = "<init>", descriptor = "(Lclient!pja;)V")
    public SpotAnimationNode(@OriginalArg(0) SpotAnimation spotAnimation) {
        this.spotAnimation = spotAnimation;
    }
}
