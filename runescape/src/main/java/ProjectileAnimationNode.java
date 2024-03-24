import com.jagex.core.datastruct.key.Node2;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!oea")
public final class ProjectileAnimationNode extends Node2 {

    @OriginalMember(owner = "client!oea", name = "t", descriptor = "Lclient!b;")
    public final ProjectileAnimation projectileAnimation;

    @OriginalMember(owner = "client!oea", name = "<init>", descriptor = "(Lclient!b;)V")
    public ProjectileAnimationNode(@OriginalArg(0) ProjectileAnimation projectileAnimation) {
        this.projectileAnimation = projectileAnimation;
    }
}
