import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!qfa")
public final class NPCEntityNode extends Node {

    @OriginalMember(owner = "client!qfa", name = "l", descriptor = "Lclient!wj;")
    public final NPCEntity npc;

    @OriginalMember(owner = "client!qfa", name = "<init>", descriptor = "(Lclient!wj;)V")
    public NPCEntityNode(@OriginalArg(0) NPCEntity arg0) {
        this.npc = arg0;
    }
}
