import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cv")
public final class ObjStackEntry extends Node {

    @OriginalMember(owner = "client!cv", name = "o", descriptor = "I")
    public final int id;

    @OriginalMember(owner = "client!cv", name = "q", descriptor = "I")
    public int count;

    @OriginalMember(owner = "client!cv", name = "<init>", descriptor = "(II)V")
    public ObjStackEntry(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
        this.id = arg0;
        this.count = arg1;
    }
}
