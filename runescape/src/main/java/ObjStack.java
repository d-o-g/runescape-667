import com.jagex.core.datastruct.key.Deque;
import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!dq")
public final class ObjStack extends Node {

    @OriginalMember(owner = "client!dq", name = "n", descriptor = "Lclient!sia;")
    public final Deque<ObjStackEntry> entries = new Deque<>();
}
