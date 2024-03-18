import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dq")
public final class ObjStack extends Node {

    @OriginalMember(owner = "client!dq", name = "n", descriptor = "Lclient!sia;")
    public final Deque objs = new Deque();
}
