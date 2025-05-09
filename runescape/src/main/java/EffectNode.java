import com.jagex.core.datastruct.key.DoublyLinkedNode;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!vb")
public final class EffectNode extends DoublyLinkedNode {

    @OriginalMember(owner = "client!vb", name = "t", descriptor = "Lclient!pja;")
    public final Effect effect;

    @OriginalMember(owner = "client!vb", name = "<init>", descriptor = "(Lclient!pja;)V")
    public EffectNode(@OriginalArg(0) Effect effect) {
        this.effect = effect;
    }
}
