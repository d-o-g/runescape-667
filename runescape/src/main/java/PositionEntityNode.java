import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pba")
public final class PositionEntityNode {

    private static final int MAX_POOL_SIZE = 500;

    @OriginalMember(owner = "client!fl", name = "c", descriptor = "I")
    private static int poolSize = 0;

    @OriginalMember(owner = "client!tka", name = "e", descriptor = "Lclient!pba;")
    private static PositionEntityNode poolHead;

    @OriginalMember(owner = "client!gu", name = "a", descriptor = "(ZLclient!qf;)Lclient!pba;")
    public static PositionEntityNode create(@OriginalArg(1) PositionEntity entity) {
        @Pc(7) PositionEntityNode node;
        if (poolHead == null) {
            node = new PositionEntityNode();
        } else {
            node = poolHead;
            poolHead = poolHead.node;
            node.node = null;
            poolSize--;
        }
        node.entity = entity;
        return node;
    }

    @OriginalMember(owner = "client!pba", name = "a", descriptor = "Lclient!pba;")
    public PositionEntityNode node;

    @OriginalMember(owner = "client!pba", name = "e", descriptor = "Lclient!qf;")
    public PositionEntity entity;

    @OriginalMember(owner = "client!pba", name = "a", descriptor = "(I)V")
    public void remove() {
        if (poolSize < MAX_POOL_SIZE) {
            this.node = poolHead;
            this.entity = null;
            poolHead = this;
            poolSize++;
        }
    }
}
