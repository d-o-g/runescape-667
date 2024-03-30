import com.jagex.core.datastruct.key.Node;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mi")
public final class BoundedMapElementListEntry extends Node {

    @OriginalMember(owner = "client!mi", name = "s", descriptor = "I")
    public int rectY2 = Integer.MIN_VALUE;

    @OriginalMember(owner = "client!mi", name = "q", descriptor = "I")
    public int textY2 = Integer.MAX_VALUE;

    @OriginalMember(owner = "client!mi", name = "v", descriptor = "I")
    public int rectX2 = Integer.MIN_VALUE;

    @OriginalMember(owner = "client!mi", name = "k", descriptor = "I")
    public int textY1 = Integer.MIN_VALUE;

    @OriginalMember(owner = "client!mi", name = "u", descriptor = "I")
    public int rectY1 = Integer.MAX_VALUE;

    @OriginalMember(owner = "client!mi", name = "l", descriptor = "I")
    public int textX2 = Integer.MIN_VALUE;

    @OriginalMember(owner = "client!mi", name = "m", descriptor = "I")
    public int textX1 = Integer.MAX_VALUE;

    @OriginalMember(owner = "client!mi", name = "t", descriptor = "I")
    public int rectX1 = Integer.MAX_VALUE;

    @OriginalMember(owner = "client!mi", name = "p", descriptor = "Lclient!fu;")
    public final MapElementListEntry entry;

    @OriginalMember(owner = "client!mi", name = "<init>", descriptor = "(Lclient!fu;)V")
    public BoundedMapElementListEntry(@OriginalArg(0) MapElementListEntry entry) {
        this.entry = entry;
    }

    @OriginalMember(owner = "client!mi", name = "a", descriptor = "(IBI)Z")
    public boolean contains(@OriginalArg(0) int x, @OriginalArg(2) int y) {
        if (x >= this.textX1 && x <= this.textX2 && y >= this.textY2 && y <= this.textY1) {
            return true;
        } else if (x >= this.rectX1 && x <= this.rectX2 && y >= this.rectY1 && y <= this.rectY2) {
            return true;
        } else {
            return false;
        }
    }
}
